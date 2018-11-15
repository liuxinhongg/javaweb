package com.bdxh.kmsale.controller.org;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.org.AgentPo;
import com.bdxh.kmsale.bean.org.BranchPo;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.cache.redis.RedisTemplate;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.AgentService;
import com.bdxh.kmsale.service.BranchService;

@Controller
@RequestMapping("/org/branch")
public class BranchController extends AbstractBackendController<AbstractEntity, Long>{

	protected RedisTemplate redisTemplate = RedisTemplate.getInstance();
	
	@Resource
	private BranchService branchService;
	
	@Resource
	private AgentService agentService;
	
	//显示用户列表
	@RequestMapping("")
	public String index() {
		return "org/branch/branch";
	}
	
	@RequestMapping("/gettree")
	public @ResponseBody ResponseEntity<String> getTree(){
	
		String tree = branchService.getAllBrachPo();
			
		return getJsonResponseEntity(tree); 
	}
	
	@RequestMapping("openBranch")
	public String openBranch() {
		return "org/branch/openBranch";
	}
	
	@RequestMapping(value = "/getSampleBranchs",method = RequestMethod.POST)	
	public @ResponseBody ResponseEntity<String> getSampleBranchs(@RequestBody Paging paging,String branchName){
		
		Integer pageCurrent = paging.getPageCurrent();// 当前页

		if (pageCurrent == null || pageCurrent == 0) {
			pageCurrent = 1;
		}

		paging.setPageCurrent(pageCurrent);

		// 条件查询返回数
		Integer userCountCondition = branchService.getSampleCount(branchName);

		// 每页显示的数据
		Integer pageSize = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition -1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrent = pageCount;
		}
		List<BranchPo> list = branchService.getSamplePage(branchName, paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("branchs", list);
		map.put("pageSize", pageSize);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrent);
		return getJsonResponseEntity(map);
	}
	
	@RequestMapping(value = "/getBranchs",method = RequestMethod.POST)	
	public @ResponseBody ResponseEntity<String> getBranchs(@RequestBody Paging paging,Integer upId,String branchName,String agentName,String noId) {
		
		BranchPo branchPo = new BranchPo();
		
		branchPo.setUpId(upId);
		branchPo.setNoId(noId);
		branchPo.setAgentName(agentName);
		branchPo.setBranchName(branchName);
		
		Integer pageCurrent = paging.getPageCurrent();// 当前页

		if (pageCurrent == null || pageCurrent == 0) {
			pageCurrent = 1;
		}

		paging.setPageCurrent(pageCurrent);

		// 条件查询返回数
		Integer userCountCondition = branchService.getCount(branchPo);

		// 每页显示的数据
		Integer pageSize = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition -1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrent = pageCount;
		}
		List<BranchPo> list = branchService.getPage(branchPo, paging);
		
        Map<Integer, String> branchMap = redisTemplate.get("branch_key_name");
		
		if(branchMap == null){
			
			branchService.initBranch();
			
			branchMap = redisTemplate.get("branch_key_name");
		}
		
		if(null != branchMap){
			
			for(int i = 0 ; i < list.size() ; i ++){
				
				BranchPo po = list.get(i);
				
				po.setUpName(branchMap.get(upId));
			}
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("branchs", list);
		map.put("pageSize", pageSize);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrent);
		return getJsonResponseEntity(map);
	}

	
	@RequestMapping("/toAddOrg")
	public String toAddOrg(){
		return "org/branch/addorg";
	}
	
	@RequestMapping("/toEditOrg")
	public String toEditOrg(Model model,Integer id){
		
		BranchPo branchPo = branchService.getById(id);
		
		model.addAttribute("branchPo",branchPo);
		
		return "org/branch/editorg";
	}
	
	@RequestMapping("/toAddBatch")
	public String toAddBatch(){
		return "org/branch/addBranch";
	}
	
	@RequestMapping("/toEditBatch")
	public String toEditBatch(Model model,Integer id){
		
		BranchPo branchPo = branchService.getById(id);
		
		model.addAttribute("branchPo",branchPo);
		
		return "org/branch/editBranch";
	}
	
	@RequestMapping("/agents")
	public String agents(){
	
		return "org/branch/agent";
	}
	
	@RequestMapping("/getOrgs")
	public @ResponseBody ResponseEntity<String> getOrgs(){
	
		BranchPo branchPo = new BranchPo();
		
		branchPo.setStatus(1);
		branchPo.setLvl(2);
		
		List<BranchPo> list = branchService.getBranchList(branchPo);
			
		return getJsonResponseEntity(list); 
	}
	
	@RequestMapping(value = "/getAgents",method = RequestMethod.POST)	
	public @ResponseBody ResponseEntity<String> getAgentsList(@RequestBody Paging paging,String agentName,String noId) {
		
		AgentPo agentPo = new AgentPo();
		
		agentPo.setNoId(noId);
		agentPo.setAgentName(agentName);
		
		Integer pageCurrent = paging.getPageCurrent();// 当前页

		if (pageCurrent == null || pageCurrent == 0 || pageCurrent.equals("")) {
			pageCurrent = 1;
		}

		paging.setPageCurrent(pageCurrent);

		// 条件查询返回数
		Integer userCountCondition = agentService.getSampleCount(agentPo).intValue();

		// 每页显示的数据
		Integer pageSize = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition -1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrent = pageCount;
		}
		List<AgentPo> list = agentService.getSamplePage(agentPo, paging);
		
		Map<Integer, String> branchMap = redisTemplate.get("branch_key_name");
		
		if(branchMap == null){
			
			branchService.initBranch();
			
			branchMap = redisTemplate.get("branch_key_name");
		}
		
		if(null != branchMap){
			
			for(int i = 0 ; i < list.size() ; i ++){
				
				AgentPo po = list.get(i);
				
				po.setUpBranchName(branchMap.get(Integer.parseInt(po.getUpBranchId())));
			}
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("agents", list);
		map.put("pageSize", pageSize);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrent);
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value="/addOrg",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addOrg(Integer branchCity,String branchName,Integer upId,String noId,Integer status
			,String effectMonth ,HttpSession session){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			
            BranchPo branchPo = new BranchPo();
			
            branchPo.setBranchCity(branchCity);
			branchPo.setBranchName(branchName);
//			branchPo.setNoId(noId);
			branchPo.setUpId(upId);
			branchPo.setStatus(status);
			branchPo.setEffectMonth(effectMonth.replace("-", "")); 
			
			User user = (User) session.getAttribute(Constants.SESSION_USER);
			
			branchPo.setOperId(user.getLoginId());

		    branchService.saveOrg(branchPo);
		    
		    branchService.initBranch();
			
			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "添加失败");
		}
		return getJsonResponseEntity(map); 
	}
	
	@RequestMapping(value="/editOrg",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> editOrg(Integer id,Integer branchCity,String branchName,Integer upId,String noId,Integer status,String effectMonth ,HttpSession session){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			
			BranchPo branchPo = new BranchPo();
			
			branchPo.setId(id);
            branchPo.setBranchCity(branchCity);
			branchPo.setBranchName(branchName);
			branchPo.setUpId(upId);
//			branchPo.setNoId(noId);
			branchPo.setStatus(status);
			branchPo.setEffectMonth(effectMonth.replace("-", ""));
			
			User user = (User) session.getAttribute(Constants.SESSION_USER);
			
			branchPo.setOperId(user.getLoginId());

		    branchService.updateBranchPo(branchPo);
		    
		    branchService.initBranch();
			
			map.put("state", 0);
			map.put("msg", "编辑成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "编辑失败");
		}
		return getJsonResponseEntity(map); 
	}
	
	@RequestMapping(value="/addBatch",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addBatch(String branchName,Integer upId,String noId,Integer status,String effectMonth ,HttpSession session){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			
			BranchPo branchPo = new BranchPo();
			
			branchPo.setBranchName(branchName);
			branchPo.setUpId(upId);
			branchPo.setNoId(noId);
			branchPo.setStatus(status);
			branchPo.setEffectMonth(effectMonth.replace("-", ""));
			
			User user = (User) session.getAttribute(Constants.SESSION_USER);
			
			branchPo.setOperId(user.getLoginId());

		    branchService.saveBranchPo(branchPo);
		    
		    branchService.initBranch();
			
			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "添加失败");
		}
		return getJsonResponseEntity(map); 
	}
	
	@RequestMapping(value="/editBatch",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> editBatch(Integer id,String branchName,Integer upId,String noId,Integer status,String effectMonth ,HttpSession session){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			
			BranchPo branchPo = new BranchPo();
			
			branchPo.setId(id);
			branchPo.setBranchName(branchName);
			branchPo.setUpId(upId);
			branchPo.setNoId(noId);
			branchPo.setStatus(status);
			branchPo.setEffectMonth(effectMonth.replace("-", ""));
			
			User user = (User) session.getAttribute(Constants.SESSION_USER);
			
			branchPo.setOperId(user.getLoginId());

		    branchService.updateBranchPo(branchPo);
		    
		    branchService.initBranch();
			
			map.put("state", 0);
			map.put("msg", "编辑成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "编辑失败");
		}
		return getJsonResponseEntity(map); 
	}
	
	@RequestMapping(value="/delBatch",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> delBatch(Integer id){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			
			branchService.deleteBranch(id);
			
			branchService.initBranch();
			
			map.put("state", 0);
			map.put("msg", "删除成功");
		} catch (Exception e) {
			
			e.printStackTrace();
			
			map.put("state", -1);
			map.put("msg", "删除失败");
		}
		return getJsonResponseEntity(map); 
	}
	
	@RequestMapping(value="/delOrg",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> delOrg(Integer id){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			
			branchService.delOrg(id);
			
			branchService.initBranch();
			
			map.put("state", 0);
			map.put("msg", "删除成功");
		} catch (Exception e) {
			
			e.printStackTrace();
			
			map.put("state", -1);
			map.put("msg", "删除失败");
		}
		return getJsonResponseEntity(map); 
	}
}

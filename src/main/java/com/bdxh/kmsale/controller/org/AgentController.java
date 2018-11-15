package com.bdxh.kmsale.controller.org;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.org.AgentPo;
import com.bdxh.kmsale.cache.redis.RedisTemplate;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.AgentService;
import com.bdxh.kmsale.service.BranchService;
import com.bdxh.kmsale.utils.ExcelUtil;

@Controller
@RequestMapping("/org/agent")
public class AgentController extends AbstractBackendController<AbstractEntity, Long> {

	protected RedisTemplate redisTemplate = RedisTemplate.getInstance();

	@Resource
	private BranchService branchService;

	@Resource
	private AgentService agentService;

	@RequestMapping("")
	public String index() {
		return "org/agent/agent";
	}

	@RequestMapping("/alert")
	public String alert() {

		return "org/alert/alert";
	}

	@RequestMapping(value = "/getAgents", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getAgentsList(@RequestBody Paging paging, String agentName, String noId,
			String startTime, String endTime, String upAgentName, String branchName, Integer status, Integer joinType,
			String tel) {
		AgentPo agentPo = new AgentPo();
		agentPo.setNoId(noId);
		agentPo.setAgentName(agentName);
		agentPo.setStartTime(startTime);
		agentPo.setEndTime(endTime);
		agentPo.setUpAgentName(upAgentName);
		agentPo.setBranchName(branchName);
		agentPo.setStatus(status);
		agentPo.setJoinType(joinType);
		agentPo.setTel(tel);
		Integer pageCurrent = paging.getPageCurrent();// 当前页
		if (pageCurrent == null || pageCurrent == 0) {
			pageCurrent = 1;
		}
		paging.setPageCurrent(pageCurrent);
		// 条件查询返回数
		Integer userCountCondition = agentService.getCount(agentPo).intValue();
		// 每页显示的数据
		Integer pageSize = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrent = pageCount;
		}
		List<AgentPo> list = agentService.getPage(agentPo, paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("agents", list);
		map.put("pageSize", pageSize);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrent);
		return getJsonResponseEntity(map);
	}

	@RequestMapping("/toAddAgent")
	public String toAddAgent() {
		return "org/agent/addAgent";
	}

	@RequestMapping("/toEditAgent")
	public String toEditAgent(Model model, String noId) {

		AgentPo agentPo = agentService.getAgentById(noId);

		model.addAttribute("agentPo", agentPo);

		return "org/agent/editAgent";
	}

	/**
	 * 注销业务员
	 * 
	 * @param noId
	 * @return
	 */
	@RequestMapping(value = "/delAgent", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> delOrg(String noId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			agentService.saveDelAgent(noId.split(","));

			map.put("state", 0);
			map.put("msg", "删除成功");
		} catch (Exception e) {

			e.printStackTrace();

			map.put("state", -1);
			map.put("msg", "删除失败");
		}
		return getJsonResponseEntity(map);
	}

	/**
	 * 除名业务员
	 * 
	 * @param noId
	 * @return
	 */
	@RequestMapping(value = "/deleteAgent", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> deleteAgent(String noId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			agentService.saveDeleteAgent(noId.split(","));

			map.put("state", 0);
			map.put("msg", "删除成功");
		} catch (Exception e) {

			e.printStackTrace();

			map.put("state", -1);
			map.put("msg", "删除失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/getAlertAgents", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getAlertAgents(@RequestBody Paging paging, String upId,
			String branchName, String upAgentName, Integer branchCity) {

		AgentPo agentPo = new AgentPo();

		agentPo.setUpAgentName(upAgentName);
		agentPo.setBranchName(branchName);
		agentPo.setUpBranchId(upId);
		agentPo.setBranchCity(branchCity);

		Integer pageCurrent = paging.getPageCurrent();// 当前页

		if (pageCurrent == null || pageCurrent == 0) {
			pageCurrent = 1;
		}

		paging.setPageCurrent(pageCurrent);

		// 条件查询返回数
		Integer userCountCondition = agentService.getAgentAlertCount(agentPo).intValue();

		// 每页显示的数据
		Integer pageSize = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrent = pageCount;
		}
		List<AgentPo> list = agentService.getAgentAlertPage(agentPo, paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("agents", list);
		map.put("pageSize", pageSize);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrent);
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = { "/exportalert" })
	public @ResponseBody String export(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			String upId, String branchName, String upAgentName, Integer branchCity) {

		AgentPo agentPo = new AgentPo();

		agentPo.setUpAgentName(upAgentName);
		agentPo.setBranchName(branchName);
		agentPo.setUpBranchId(upId);
		agentPo.setBranchCity(branchCity);

		List<AgentPo> list = agentService.getAgentAlertList(agentPo);

		String[] title = { "业务代码", "姓名", "业务电话", "所属分区","所属分部", "入职时间","累计0业绩时长","推荐人姓名","推荐人业务代码", "身份证号码" };

		Date d = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");

		// excel文件名
		String fileName = "alert_" + sdf1.format(d) + ".xls";

		// sheet名
		String sheetName = "学生信息表";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String[][] content = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			content[i] = new String[title.length];
			AgentPo alert = (AgentPo) list.get(i);
			content[i][0] = alert.getNoId();
			content[i][1] = alert.getAgentName();
			content[i][2] = alert.getTel();
			content[i][3] = alert.getBranchName();
			content[i][4] = alert.getUpBranchName();
			content[i][5] = sdf.format(alert.getCreateDate());
			content[i][6] = getMoth(alert.getTotalZeroMonth());
			content[i][7] = alert.getUpAgentName();
			content[i][8] = alert.getpNoId();
			content[i][9] = alert.getIdNumber();
		}

		HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

		// 响应到客户端
		try {
			this.setResponseHeader(response, fileName);
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 发送响应流方法
	public void setResponseHeader(HttpServletResponse response, String fileName) {
		try {
			try {
				fileName = new String(fileName.getBytes(), "ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String getMoth(Integer totalZeroMonth){
		
		if(null == totalZeroMonth) {
			return "四月";
		}
		else if(5 == totalZeroMonth) {
			return "五月";
		}
		
		return "四月";
	}
	
	/**
	 * 除名业务员
	 * 
	 * @param noId
	 * @return
	 */
	@RequestMapping(value = "/sendSMS", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> sendSMS(String noId,Integer sendMyself,Integer sendUpAgent,Integer sendBranchManager) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			map.put("state", 0);
			map.put("msg", "发送成功");
		} catch (Exception e) {

			e.printStackTrace();

			map.put("state", -1);
			map.put("msg", "发送失败");
		}
		return getJsonResponseEntity(map);
	}
}

package com.bdxh.kmsale.controller.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.code.CommNewAgentPo;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.CommNewAgentService;

@Controller
@RequestMapping("/code/agentsub")
public class CommNewAgentController extends AbstractBackendController<AbstractEntity, Long>{

	@Resource
	private CommNewAgentService commNewAgentService;

	// 代理补贴
	@RequestMapping("")
	public String index() {
		return "code/agentsub/agentsub";
	}

	//列表
	@RequestMapping(value = "/getAgentSubList", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getAgentSubList(Integer pageCurrent, Integer pageSize) {

		Paging paging = new Paging();
		paging.setPageCurrent(pageCurrent);
		paging.setPageSize(pageSize);

		Integer pageCurrents = paging.getPageCurrent();// 当前页
		if (pageCurrents == null || pageCurrents == 0) {
			pageCurrents = 1;
		}
		paging.setPageCurrent(pageCurrents);
		// 满足条件查询的条数
		Integer userCountCondition = commNewAgentService.getCount().intValue();

		// 每页显示数据条数
		Integer pageSizes = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrents = pageCount;
		}
		List<CommNewAgentPo> list = commNewAgentService.getPage(paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commNewAgentPoList", list);
		map.put("pageSize", pageSizes);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrents);
		return getJsonResponseEntity(map);
	}

	@RequestMapping("/toAddAgentSub")
	public String toAddTellBill() {
		return "code/agentsub/addAgentSub";
	}

	@RequestMapping("/toEditAgentSub")
	public String toEditAgentSub(Model model, String codeId) {

		CommNewAgentPo commNewAgentPo = commNewAgentService.getCommNewAgentPoById(codeId);

		model.addAttribute("commNewAgentPo", commNewAgentPo);

		return "code/agentsub/editAgentSub";
	}

	@RequestMapping(value = "/addAgentSub", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addAgentSub(Double totalMoney, Double firstMMoney, Double secondMMoney, Double lastMMoney,
			 Integer status,String codeDesc, HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			CommNewAgentPo commNewAgentPo = new CommNewAgentPo();
			commNewAgentPo.setTotalMoney(totalMoney);
			commNewAgentPo.setFirstMMoney(firstMMoney);
			commNewAgentPo.setSecondMMoney(secondMMoney);
			commNewAgentPo.setLastMMoney(lastMMoney);
			commNewAgentPo.setOperId(user.getLoginId());
			commNewAgentPo.setStatus(status);
			commNewAgentPo.setCodeDesc(codeDesc);

			commNewAgentService.insertCommNewAgentPo(commNewAgentPo);

			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "添加失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/editAgentSub", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> editAgentSub(String codeId,Double totalMoney, Double firstMMoney, Double secondMMoney, Double lastMMoney,
			 Integer status,String codeDesc, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			CommNewAgentPo commNewAgentPo = new CommNewAgentPo();
			commNewAgentPo.setTotalMoney(totalMoney);
			commNewAgentPo.setFirstMMoney(firstMMoney);
			commNewAgentPo.setSecondMMoney(secondMMoney);
			commNewAgentPo.setLastMMoney(lastMMoney);
			commNewAgentPo.setOperId(user.getLoginId());
			commNewAgentPo.setStatus(status);
			commNewAgentPo.setCodeDesc(codeDesc);
			commNewAgentPo.setCodeId(codeId);

			commNewAgentService.updateCommNewAgentPo(commNewAgentPo);

			map.put("state", 0);
			map.put("msg", "编辑成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "编辑失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/deleteAgentSubs", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> deleteAgentSubs(String codeIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			commNewAgentService.deleteCommNewAgentPo(codeIds);

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

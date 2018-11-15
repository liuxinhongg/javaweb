package com.bdxh.kmsale.controller.code;

import java.util.Date;
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
import com.bdxh.kmsale.bean.code.CommCallPo;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.CommCallService;

@Controller
@RequestMapping("/code/pushmoney")
public class ProductCommController extends AbstractBackendController<AbstractEntity, Long>{

	@Resource
	private CommCallService commCallService;

	// 话费提成标准
	@RequestMapping("")
	public String index() {
		return "code/pushmoney/pushmoney";
	}
	
	@RequestMapping("call")
	public String call() {
		return "code/pushmoney/call";
	}

	//列表
	@RequestMapping(value = "/getCommCallList", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getCommCallList(Integer pageCurrent, Integer pageSize) {

		Paging paging = new Paging();
		paging.setPageCurrent(pageCurrent);
		paging.setPageSize(pageSize);

		Integer pageCurrents = paging.getPageCurrent();// 当前页
		if (pageCurrents == null || pageCurrents == 0) {
			pageCurrents = 1;
		}
		paging.setPageCurrent(pageCurrents);
		// 满足条件查询的条数
		Integer userCountCondition = commCallService.getCount().intValue();

		// 每页显示数据条数
		Integer pageSizes = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrents = pageCount;
		}
		List<CommCallPo> list = commCallService.getPage(paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commCallPoList", list);
		map.put("pageSize", pageSizes);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrents);
		return getJsonResponseEntity(map);
	}

	@RequestMapping("/toAddCommCall")
	public String toAddCommCall() {
		return "code/pushmoney/addCommCall";
	}

	@RequestMapping("/toEditCommCall")
	public String toEditCommCall(Model model, String codeId) {

		CommCallPo commCallPo = commCallService.getCommCallPoById(codeId);

		model.addAttribute("commCallPo", commCallPo);

		return "code/pushmoney/editCommCall";
	}

	@RequestMapping(value = "/addCommCall", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addCommCall(Double firstYRate,Double secondYRate, Double commMin, Double commMax,
			Integer ord, Integer status,String codeDesc, HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			CommCallPo commCallPo = new CommCallPo();
			commCallPo.setFirstYRate(firstYRate);
			commCallPo.setSecondYRate(secondYRate);
			commCallPo.setCommMax(commMax);
			commCallPo.setCommMin(commMin);
			commCallPo.setStatus(status);
			commCallPo.setOrd(ord);
			commCallPo.setCodeDesc(codeDesc);
			commCallPo.setOperId(user.getLoginId());

			commCallService.insertCommCallPo(commCallPo);

			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "添加失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/editCommCall", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> editCommCall(String codeId,Double firstYRate,Double secondYRate, Double commMin, Double commMax,
			Integer ord, Integer status,String codeDesc, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			CommCallPo commCallPo = new CommCallPo();
			commCallPo.setFirstYRate(firstYRate);
			commCallPo.setSecondYRate(secondYRate);
			commCallPo.setCommMax(commMax);
			commCallPo.setCommMin(commMin);
			commCallPo.setStatus(status);
			commCallPo.setOrd(ord);
			commCallPo.setCodeDesc(codeDesc);
			commCallPo.setOperId(user.getLoginId());
			commCallPo.setCodeId(codeId);
			commCallPo.setCreateDate(new Date());

			commCallService.updateCommCallPo(commCallPo);

			map.put("state", 0);
			map.put("msg", "编辑成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "编辑失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/deleteCommCalls", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> deleteCommCalls(String codeIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			commCallService.deleteCommCallPo(codeIds);

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

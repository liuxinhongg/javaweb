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
import com.bdxh.kmsale.bean.code.CommManagerPo;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.CommManagerService;

@Controller
@RequestMapping("/code/managebenefit")
public class CommManagerController extends AbstractBackendController<AbstractEntity, Long>{

	@Resource
	private CommManagerService commManagerService;

	// 管理津贴
	@RequestMapping("")
	public String index() {
		return "code/managebenefit/managebenefit";
	}

	//列表
	@RequestMapping(value = "/getManageBenefitList", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getManageBenefitList(Integer pageCurrent, Integer pageSize) {

		Paging paging = new Paging();
		paging.setPageCurrent(pageCurrent);
		paging.setPageSize(pageSize);

		Integer pageCurrents = paging.getPageCurrent();// 当前页
		if (pageCurrents == null || pageCurrents == 0) {
			pageCurrents = 1;
		}
		paging.setPageCurrent(pageCurrents);
		// 满足条件查询的条数
		Integer userCountCondition = commManagerService.getCount().intValue();

		// 每页显示数据条数
		Integer pageSizes = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrents = pageCount;
		}
		List<CommManagerPo> list = commManagerService.getPage(paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commManagerPoList", list);
		map.put("pageSize", pageSizes);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrents);
		return getJsonResponseEntity(map);
	}

	@RequestMapping("/toAddCommManager")
	public String toAddTellBill() {
		return "code/managebenefit/addCommManager";
	}

	@RequestMapping("/toEditCommManager")
	public String toEditCommManager(Model model, String codeId) {

		CommManagerPo commManagerPo = commManagerService.getCommManagerPoById(codeId);

		model.addAttribute("commManagerPo", commManagerPo);

		return "code/managebenefit/editCommManager";
	}

	@RequestMapping(value = "/addCommManager", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addCommManager(Double commMin, Double commMax, Double commRate ,
			 Integer status,Integer ord, HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			CommManagerPo commManagerPo = new CommManagerPo();
			commManagerPo.setCommMin(commMin);
			commManagerPo.setCommMax(commMax);
			commManagerPo.setCommRate(commRate);
			commManagerPo.setOperId(user.getLoginId());
			commManagerPo.setStatus(status);
			commManagerPo.setOrd(ord);

			commManagerService.insertCommManagerPo(commManagerPo);

			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "添加失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/editCommManager", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> editCommManager(String codeId,Double commMin, Double commMax, Double commRate ,
			 Integer status,Integer ord, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			CommManagerPo commManagerPo = new CommManagerPo();
			commManagerPo.setCommMin(commMin);
			commManagerPo.setCommMax(commMax);
			commManagerPo.setCommRate(commRate);
			commManagerPo.setOperId(user.getLoginId());
			commManagerPo.setStatus(status);
			commManagerPo.setOrd(ord);
			commManagerPo.setCreateDate(new Date());
			commManagerPo.setCodeId(codeId);

			commManagerService.updateCommManagerPo(commManagerPo);

			map.put("state", 0);
			map.put("msg", "编辑成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "编辑失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/deleteCommManagers", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> deleteCommManagers(String codeIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			commManagerService.deleteCommManagerPo(codeIds);

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

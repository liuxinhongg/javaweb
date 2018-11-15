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
import com.bdxh.kmsale.bean.code.PositionRiseConditionPo;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.PositionRiseConditionService;

@Controller
@RequestMapping("/code/agentprom")
public class PositionRiseConditionController extends AbstractBackendController<AbstractEntity, Long>{

	@Resource
	private PositionRiseConditionService positionRiseConditionService;

	// 管理津贴
	@RequestMapping("")
	public String index() {
		return "code/agentprom/agentprom";
	}

	//列表
	@RequestMapping(value = "/getAgentpromList", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getAgentpromList(Integer pageCurrent, Integer pageSize) {

		Paging paging = new Paging();
		paging.setPageCurrent(pageCurrent);
		paging.setPageSize(pageSize);

		Integer pageCurrents = paging.getPageCurrent();// 当前页
		if (pageCurrents == null || pageCurrents == 0) {
			pageCurrents = 1;
		}
		paging.setPageCurrent(pageCurrents);
		// 满足条件查询的条数
		Integer userCountCondition = positionRiseConditionService.getCount().intValue();

		// 每页显示数据条数
		Integer pageSizes = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrents = pageCount;
		}
		List<PositionRiseConditionPo> list = positionRiseConditionService.getPage(paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("positionRiseConditionPoList", list);
		map.put("pageSize", pageSizes);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrents);
		return getJsonResponseEntity(map);
	}

	@RequestMapping("/toAddPositionRiseCondition")
	public String toAddPositionRiseCondition() {
		return "code/agentprom/addagentprom";
	}

	@RequestMapping("/toEditPositionRiseCondition")
	public String toEditPositionRiseCondition(Model model, Integer conditionId) {

		PositionRiseConditionPo positionRiseConditionPo = positionRiseConditionService.getPositionRiseConditionPoById(conditionId);

		model.addAttribute("positionRiseConditionPo", positionRiseConditionPo);

		return "code/agentprom/editagentprom";
	}

	@RequestMapping(value = "/addPositionRiseCondition", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addPositionRiseCondition(Integer positionId, Integer needPositionId, Integer standardType ,
			 Integer highType,Double highValueMin,Double highValueMax,Integer conditionOrd,Integer status, HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			PositionRiseConditionPo positionRiseConditionPo = new PositionRiseConditionPo();
			positionRiseConditionPo.setPositionId(positionId);
			positionRiseConditionPo.setNeedPositionId(needPositionId);
			positionRiseConditionPo.setStandardType(standardType);
			positionRiseConditionPo.setHighType(highType);
			positionRiseConditionPo.setHighValueMin(highValueMin);
			positionRiseConditionPo.setHighValueMax(highValueMax);
			positionRiseConditionPo.setOperId(user.getLoginId());
			positionRiseConditionPo.setStatus(status);
			positionRiseConditionPo.setConditionOrd(conditionOrd);

			positionRiseConditionService.insertPositionRiseConditionPo(positionRiseConditionPo);

			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "添加失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/editPositionRiseCondition", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> editCommManager(Integer conditionId,Integer positionId, Integer needPositionId, Integer standardType ,
			 Integer highType,Double highValueMin,Double highValueMax,Integer conditionOrd,Integer status, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			PositionRiseConditionPo positionRiseConditionPo = new PositionRiseConditionPo();
			
			positionRiseConditionPo.setConditionId(conditionId);
			positionRiseConditionPo.setPositionId(positionId);
			positionRiseConditionPo.setNeedPositionId(needPositionId);
			positionRiseConditionPo.setStandardType(standardType);
			positionRiseConditionPo.setHighType(highType);
			positionRiseConditionPo.setHighValueMin(highValueMin);
			positionRiseConditionPo.setHighValueMax(highValueMax);
			positionRiseConditionPo.setOperId(user.getLoginId());
			positionRiseConditionPo.setStatus(status);
			positionRiseConditionPo.setConditionOrd(conditionOrd);
			positionRiseConditionPo.setConditionDate(new Date());

			positionRiseConditionService.updatePositionRiseConditionPo(positionRiseConditionPo);

			map.put("state", 0);
			map.put("msg", "编辑成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "编辑失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/deletePositionRiseConditions", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> deletePositionRiseConditions(String conditionIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			positionRiseConditionService.deletePositionRiseConditionPo(conditionIds);
			
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

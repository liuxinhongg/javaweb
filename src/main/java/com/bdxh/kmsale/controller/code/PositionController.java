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
import com.bdxh.kmsale.bean.code.PositionConditionPo;
import com.bdxh.kmsale.bean.code.PositionPo;
import com.bdxh.kmsale.bean.code.ProductTypePo;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.PositionService;

@Controller
@RequestMapping("/code/position")
public class PositionController extends AbstractBackendController<AbstractEntity, Long> {

	@Resource
	private PositionService positionService;

	// 岗位津贴
	@RequestMapping("")
	public String index() {
		return "code/position/position";
	}

	// 多条件模糊查询
	@RequestMapping(value = "/getPositionList", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getPositionList(Integer pageCurrent, Integer pageSize) {

		Paging paging = new Paging();
		paging.setPageCurrent(pageCurrent);
		paging.setPageSize(pageSize);

		Integer pageCurrents = paging.getPageCurrent();// 当前页
		if (pageCurrents == null || pageCurrents == 0) {
			pageCurrents = 1;
		}
		paging.setPageCurrent(pageCurrents);
		// 满足条件查询的条数
		Integer userCountCondition = positionService.getCount().intValue();

		// 每页显示数据条数
		Integer pageSizes = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrents = pageCount;
		}
		List<PositionPo> list = positionService.getPage(paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("positionPoList", list);
		map.put("pageSize", pageSizes);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrents);
		return getJsonResponseEntity(map);
	}

	@RequestMapping("/toAddPosition")
	public String toAddPosition() {
		return "code/position/addPosition";
	}

	@RequestMapping("/toEditPosition")
	public String toEditPosition(Model model, Integer id) {

		PositionPo positionPo = positionService.getPositionById(id);

		model.addAttribute("positionPo", positionPo);

		return "code/position/editPosition";
	}

	@RequestMapping(value = "/addPosition", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addPosition(String positionName, Double positionComm, Integer status,
			Integer ord, String positionDesc, HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			PositionPo positionPo = new PositionPo();
			positionPo.setPositionName(positionName);
			positionPo.setPositionComm(positionComm);
			positionPo.setOperId(user.getLoginId());
			positionPo.setStatus(status);
			positionPo.setOrd(ord);
			positionPo.setPositionDesc(positionDesc);

			positionService.insertPosition(positionPo);

			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "添加失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/editPosition", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> editPosition(Integer id, String positionName, Double positionComm,
			Integer ord, Integer status, String positionDesc, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			PositionPo positionPo = new PositionPo();
			positionPo.setId(id);
			positionPo.setPositionName(positionName);
			positionPo.setPositionComm(positionComm);
			positionPo.setOperId(user.getLoginId());
			positionPo.setStatus(status);
			positionPo.setOrd(ord);
			positionPo.setPositionDesc(positionDesc);

			positionService.updatePosition(positionPo);

			map.put("state", 0);
			map.put("msg", "编辑成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "编辑失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/deletePositions", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> deletePositions(String positionIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			positionService.deletePosition(positionIds);

			map.put("state", 0);
			map.put("msg", "删除成功");
		} catch (Exception e) {

			e.printStackTrace();

			map.put("state", -1);
			map.put("msg", "删除失败");
		}
		return getJsonResponseEntity(map);
	}
	
	// 查询岗位列表
	@RequestMapping(value = "/getPositions", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getPositions() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<PositionPo> positionPoList = positionService.getAllPositions();
		map.put("positionPoList", positionPoList);
		return getJsonResponseEntity(map);
	}

	// 多条件模糊查询
	@RequestMapping(value = "/getPositionConditionList", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getPositionConditionList(Integer conditionType,Integer pageCurrent, Integer pageSize) {

		Paging paging = new Paging();
		paging.setPageCurrent(pageCurrent);
		paging.setPageSize(pageSize);

		Integer pageCurrents = paging.getPageCurrent();// 当前页
		if (pageCurrents == null || pageCurrents == 0) {
			pageCurrents = 1;
		}
		paging.setPageCurrent(pageCurrents);
		// 满足条件查询的条数
		Integer userCountCondition = positionService.getConditionCount(conditionType).intValue();

		// 每页显示数据条数
		Integer pageSizes = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrents = pageCount;
		}
		List<PositionConditionPo> list = positionService.getConditionPage(conditionType,paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("positionConditionPoList", list);
		map.put("pageSize", pageSizes);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrents);
		return getJsonResponseEntity(map);
	}

	@RequestMapping("/toAddPositionCondition")
	public String toAddPositionCondition(Model model, Integer conditionType) {
		
		model.addAttribute("conditionType", conditionType);
		
		return "code/position/addPositionCondition";
	}

	@RequestMapping("/toEditPositionCondition")
	public String toEditPositionCondition(Model model, Integer conditionId) {

		PositionConditionPo positionConditionPo = positionService.getPositionConditionPoById(conditionId);

		model.addAttribute("positionConditionPo", positionConditionPo);

		return "code/position/editPositionCondition";
	}

	@RequestMapping(value = "/addPositionCondition", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addPositionCondition(String conditionName, Double conditionX,Double conditionY, Integer status,
			Integer conditionOrd, String conditionDesc,Integer conditionType, HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			PositionConditionPo positionConditionPo = new PositionConditionPo();
			positionConditionPo.setConditionName(conditionName);
			positionConditionPo.setConditionX(conditionX == null ? 0 : conditionX);
			positionConditionPo.setConditionY(conditionY == null ? 0 : conditionY);
			positionConditionPo.setOperId(user.getLoginId());
			positionConditionPo.setStatus(status);
			positionConditionPo.setConditionOrd(conditionOrd);
			positionConditionPo.setConditionDesc(conditionDesc);
			positionConditionPo.setConditionType(conditionType);

			positionService.insertPositionConditionPo(positionConditionPo);

			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "添加失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/editPositionCondition", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> editPositionCondition(Integer conditionId, String conditionName, Double conditionX,Double conditionY,
			Integer conditionOrd, Integer status, String conditionDesc, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			PositionConditionPo positionConditionPo = new PositionConditionPo();
			positionConditionPo.setConditionId(conditionId);
			positionConditionPo.setConditionName(conditionName);
			positionConditionPo.setConditionX(conditionX == null ? 0 : conditionX);
			positionConditionPo.setConditionY(conditionY == null ? 0 : conditionY);
			positionConditionPo.setOperId(user.getLoginId());
			positionConditionPo.setStatus(status);
			positionConditionPo.setConditionOrd(conditionOrd);
			positionConditionPo.setConditionDesc(conditionDesc);
			positionConditionPo.setConditionDate(new Date());

			positionService.updatePositionConditionPo(positionConditionPo);

			map.put("state", 0);
			map.put("msg", "编辑成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "编辑失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/deletePositionConditions", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> deletePositionConditions(String conditionIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			positionService.deletePositionConditionPo(conditionIds);

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

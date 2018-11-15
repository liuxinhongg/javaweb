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
import com.bdxh.kmsale.bean.code.CommTelBillPo;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.CommTelBillService;

@Controller
@RequestMapping("/code/tellBill")
public class CommTelBillController extends AbstractBackendController<AbstractEntity, Long>{

	@Resource
	private CommTelBillService commTelBillService;

	// 话费补助
	@RequestMapping("")
	public String index() {
		return "code/tellBill/tellBill";
	}

	//列表
	@RequestMapping(value = "/getTellBillList", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getTellBillList(Integer pageCurrent, Integer pageSize) {

		Paging paging = new Paging();
		paging.setPageCurrent(pageCurrent);
		paging.setPageSize(pageSize);

		Integer pageCurrents = paging.getPageCurrent();// 当前页
		if (pageCurrents == null || pageCurrents == 0) {
			pageCurrents = 1;
		}
		paging.setPageCurrent(pageCurrents);
		// 满足条件查询的条数
		Integer userCountCondition = commTelBillService.getCount().intValue();

		// 每页显示数据条数
		Integer pageSizes = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrents = pageCount;
		}
		List<CommTelBillPo> list = commTelBillService.getPage(paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commTelBillPoList", list);
		map.put("pageSize", pageSizes);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrents);
		return getJsonResponseEntity(map);
	}

	@RequestMapping("/toAddTellBill")
	public String toAddTellBill() {
		return "code/tellBill/addTelBill";
	}

	@RequestMapping("/toEditTellBill")
	public String toEditTellBill(Model model, Integer telBillId) {

		CommTelBillPo commTelBillPo = commTelBillService.getCommTelBillPoById(telBillId);

		model.addAttribute("commTelBillPo", commTelBillPo);

		return "code/tellBill/editTelBill";
	}

	@RequestMapping(value = "/addTellBill", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addTellBill(Double allowance, Integer commMin, Integer commMax,
			Integer ord, Integer status, HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			CommTelBillPo commTelBillPo = new CommTelBillPo();
			commTelBillPo.setAllowance(allowance);
			commTelBillPo.setCommMin(commMin);
			commTelBillPo.setCommMax(commMax);
			commTelBillPo.setOperId(user.getLoginId());
			commTelBillPo.setStatus(status);
			commTelBillPo.setOrd(ord);	

			commTelBillService.insertCommTelBillPo(commTelBillPo);

			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "添加失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/editTellBill", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> editTellBill(Integer telBillId, Double allowance, Integer commMin,
			Integer commMax, Integer ord, Integer status, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			CommTelBillPo commTelBillPo = new CommTelBillPo();
			commTelBillPo.setAllowance(allowance);
			commTelBillPo.setCommMin(commMin);
			commTelBillPo.setCommMax(commMax);
			commTelBillPo.setOperId(user.getLoginId());
			commTelBillPo.setStatus(status);
			commTelBillPo.setOrd(ord);
			commTelBillPo.setTelBillId(telBillId);
			commTelBillPo.setCreateDate(new Date());

			commTelBillService.updateCommTelBillPo(commTelBillPo);

			map.put("state", 0);
			map.put("msg", "编辑成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "编辑失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/deleteCommTelBills", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> deleteCommTelBills(String positionIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			commTelBillService.deleteCommTelBillPo(positionIds);

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

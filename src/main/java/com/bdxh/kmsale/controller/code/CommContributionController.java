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
import com.bdxh.kmsale.bean.code.CommContributionPo;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.CommContributionService;

@Controller
@RequestMapping("/code/outstandaward")
public class CommContributionController extends AbstractBackendController<AbstractEntity, Long>{

	@Resource
	private CommContributionService commContributionService;

	// 杰出贡献奖
	@RequestMapping("")
	public String index() {
		return "code/outstandaward/outstandaward";
	}

	//列表
	@RequestMapping(value = "/getOutstandawardList", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getOutstandawardList(Integer pageCurrent, Integer pageSize) {

		Paging paging = new Paging();
		paging.setPageCurrent(pageCurrent);
		paging.setPageSize(pageSize);

		Integer pageCurrents = paging.getPageCurrent();// 当前页
		if (pageCurrents == null || pageCurrents == 0) {
			pageCurrents = 1;
		}
		paging.setPageCurrent(pageCurrents);
		// 满足条件查询的条数
		Integer userCountCondition = commContributionService.getCount().intValue();

		// 每页显示数据条数
		Integer pageSizes = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrents = pageCount;
		}
		List<CommContributionPo> list = commContributionService.getPage(paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commContributionPoList", list);
		map.put("pageSize", pageSizes);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrents);
		return getJsonResponseEntity(map);
	}

	@RequestMapping("/toAddCommContribution")
	public String toAddTellBill() {
		return "code/outstandaward/addCommContribution";
	}

	@RequestMapping("/toEditCommContribution")
	public String toEditCommContribution(Model model, String codeId) {

		CommContributionPo commContributionPo = commContributionService.getCommContributionPoById(codeId);

		model.addAttribute("commContributionPo", commContributionPo);

		return "code/outstandaward/editCommContribution";
	}

	@RequestMapping(value = "/addCommContribution", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addCommContribution(String codeDesc, Double commMin, Double commContribution ,
			 Integer status,Integer ord, HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			CommContributionPo commContributionPo = new CommContributionPo();
			commContributionPo.setCommMin(commMin);
			commContributionPo.setCodeDesc(codeDesc);
			commContributionPo.setCommContribution(commContribution);
			commContributionPo.setOperId(user.getLoginId());
			commContributionPo.setStatus(status);
			commContributionPo.setOrd(ord);

			commContributionService.insertCommContributionPo(commContributionPo);

			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "添加失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/editCommContribution", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> editCommContribution(String codeId,String codeDesc, Double commMin, Double commContribution ,
			 Integer status,Integer ord, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			CommContributionPo commContributionPo = new CommContributionPo();
			commContributionPo.setCommMin(commMin);
			commContributionPo.setCodeDesc(codeDesc);
			commContributionPo.setCommContribution(commContribution);
			commContributionPo.setOperId(user.getLoginId());
			commContributionPo.setStatus(status);
			commContributionPo.setOrd(ord);
			commContributionPo.setCodeId(codeId);
			commContributionPo.setCreateDate(new Date());

			commContributionService.updateCommContributionPo(commContributionPo);

			map.put("state", 0);
			map.put("msg", "编辑成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "编辑失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/deleteCommContributions", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> deleteCommContributions(String codeIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			commContributionService.deleteCommContributionPo(codeIds);

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

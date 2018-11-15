package com.bdxh.kmsale.controller.comm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.comm.CommissionPo;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.CommissionService;

@Controller
@RequestMapping("/comm/account")
public class CommissionController extends AbstractBackendController<AbstractEntity, Long>{

	@Resource
	private CommissionService commissionService;

	// 杰出贡献奖
	@RequestMapping("")
	public String index() {
		return "comm/account/account";
	}

	//列表
	@RequestMapping(value = "/getAccountsList", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getAccountsList(String userName,String noId,String acctMonth,Integer branchId,Integer positionId,
			String noIdOrg,Integer pageCurrent, Integer pageSize) {

		Paging paging = new Paging();
		paging.setPageCurrent(pageCurrent);
		paging.setPageSize(pageSize);
		
		CommissionPo commissionPo = new CommissionPo();
		commissionPo.setUserName(userName);
		commissionPo.setNoId(noId);
		
		if(StringUtils.isNotBlank(acctMonth)) {
			commissionPo.setAcctMonth(acctMonth.replace("-", ""));
		}
		commissionPo.setBranchId(branchId);
		commissionPo.setPositionId(positionId);
		commissionPo.setNoIdOrg(noIdOrg);
		

		Integer pageCurrents = paging.getPageCurrent();// 当前页
		if (pageCurrents == null || pageCurrents == 0) {
			pageCurrents = 1;
		}
		paging.setPageCurrent(pageCurrents);
		// 满足条件查询的条数
		Integer userCountCondition = commissionService.getCount(commissionPo).intValue();

		// 每页显示数据条数
		Integer pageSizes = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrents = pageCount;
		}
		List<CommissionPo> list = commissionService.getPage(commissionPo,paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commissionPoList", list);
		map.put("pageSize", pageSizes);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrents);
		return getJsonResponseEntity(map);
	}
}

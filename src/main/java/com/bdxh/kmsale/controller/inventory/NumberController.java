package com.bdxh.kmsale.controller.inventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.NumberPo;
import com.bdxh.kmsale.bean.NumberType;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.BranchService;
import com.bdxh.kmsale.service.NumberService;
import com.bdxh.kmsale.service.NumberTypeService;

@Controller
@RequestMapping("/inventory/number")
public class NumberController extends AbstractBackendController<AbstractEntity, Long> {

	@Resource
	private NumberTypeService numberServic;
	
	@Resource
	private NumberService numberService;

	@Resource
	private BranchService branchService;

	// 显示号码管理页面
	@RequestMapping("/getNumber")
	public String getNumber() {
		return "inventory/number";
	}

	// 多条件模糊查询
	@RequestMapping(value = "/getNumberList", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getNumberList(String serchSvcNumber, String svcnumber2, String endSvcNumber,
			String snNo, Integer isshare, Integer status, String beginSvcNumber, String lvlType,
			Integer pageCurrent, Integer pageSize) {

		Paging paging = new Paging();
		paging.setPageCurrent(pageCurrent);
		paging.setPageSize(pageSize);

		NumberPo numberPo = new NumberPo();
		numberPo.setSerchSvcNumber(serchSvcNumber);
		numberPo.setSvcnumber2(svcnumber2);
		numberPo.setEndSvcNumber(endSvcNumber);
		numberPo.setBeginSvcNumber(beginSvcNumber);
		numberPo.setSnNo(snNo);
		numberPo.setIsShare(isshare);
		numberPo.setStatus(status);
		numberPo.setNumberLevel(lvlType);

		Integer pageCurrents = paging.getPageCurrent();// 当前页
		if (pageCurrents == null || pageCurrents == 0 || pageCurrents.equals("")) {
			pageCurrents = 1;
		}
		paging.setPageCurrent(pageCurrents);
		// 满足条件查询的条数
		Integer userCountCondition = numberService.getCount(numberPo).intValue();

		// 每页显示数据条数
		Integer pageSizes = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrents = pageCount;
		}
		List<NumberPo> list = numberService.getPage(numberPo, paging);

		Map<Integer, String> branchMap = redisTemplate.get("branch_key_name");

		if (branchMap == null) {

			branchService.initBranch();

			branchMap = redisTemplate.get("branch_key_name");
		}

		if (null != branchMap) {

			for (int i = 0; i < list.size(); i++) {

				NumberPo po = list.get(i);

				po.setBranchName(branchMap.get(po.getBranchId()));
			}
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("numberPosList", list);
		map.put("pageSize", pageSizes);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrents);
		return getJsonResponseEntity(map);

	}

	// 查询靓号类型
	@RequestMapping(value = "/getNumberType", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getNumberType() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<NumberType> numberTypeList = numberServic.selectList();
		map.put("numberTypeList", numberTypeList);
		return getJsonResponseEntity(map);
	}
	
	@RequestMapping(value = "/saveNumber", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> saveNumber(Integer saveType,String numberId,Integer branchId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			numberService.saveBackOrSend(saveType,numberId,branchId);

			map.put("state", 0);
			map.put("msg", "操作成功");
		} catch (Exception e) {

			e.printStackTrace();

			map.put("state", -1);
			map.put("msg", "操作失败");
		}
		return getJsonResponseEntity(map);
	}
}

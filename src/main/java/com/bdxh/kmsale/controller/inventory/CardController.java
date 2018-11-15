package com.bdxh.kmsale.controller.inventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.CardPo;
import com.bdxh.kmsale.bean.NumberPo;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.CardService;

/**
 * SIM号码管理
 * @author 陈晗
 *
 */

@Controller
@RequestMapping("/manage/card")
public class CardController extends AbstractBackendController<AbstractEntity, Long>{
	
	@Resource
	private CardService CardService;
	
	//显示号码管理页面
	@RequestMapping("/getCard")
	public String getCard(){
		return "system/card";
	}

	//多条件模糊查询
	@RequestMapping(value="/getCarList",method = RequestMethod.POST)
	public ResponseEntity<String> getCarList(String simnumber,
			Integer opertype,String ksvcnumber,String jsvcnumber,String snno,Integer status,Integer pageCurrent,Integer pageSize){
				
		Paging paging=new Paging();
		paging.setPageCurrent(pageCurrent);
		paging.setPageSize(pageSize);
		
		NumberPo numberPo=new NumberPo();
		numberPo.setSimNumber(simnumber);
		numberPo.setOperType(opertype);
		numberPo.setKsvcnumber(ksvcnumber);
		numberPo.setJsvcnumber(jsvcnumber);
		numberPo.setSnNo(snno);
		numberPo.setStatus(status);
		
		Integer pageCurrents=paging.getPageCurrent();//当前页
		if(pageCurrents==null||pageCurrents==0||pageCurrents.equals("")) {
			pageCurrents=1;
		}
		paging.setPageCurrent(pageCurrent);
		//满足条件查询的条数
		Integer userCountCondition=CardService.seleclCount(numberPo);
		
		//总条数
		Integer userCountAll=CardService.selectCountAll();
		
		//每页显示数据条数
		Integer pageSizes=paging.getPageSize();
		//总页数
		Integer pageCount = (pageCurrents + pageSizes - 1) / pageSizes;
		if(paging.getPageCurrent()>pageCount){
			paging.setPageCurrent(pageCount);
			pageCurrents=pageCount;
		}
		List<CardPo>cardList=CardService.numberList(numberPo,paging);
		System.out.println(cardList);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("cardList", cardList);
		map.put("userCountAll", userCountAll);
		map.put("pageSize", pageSize);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrent);
		return getJsonResponseEntity(map);  		
		
	}
}

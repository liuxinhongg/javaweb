package com.bdxh.kmsale.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.bdxh.kmsale.bean.inventory.CardInPo;
import com.bdxh.kmsale.mapper.CardInMapper;
import com.bdxh.kmsale.service.CardInService;

@Service
public class CardInServiceImpl implements CardInService{

	@Resource
	private CardInMapper cardInMapper;

	@Override
	public BigDecimal saveInportSimFile(List<CardInPo> list, String operId) {

        Integer result1 = 0;
		
        cardInMapper.deleteCardInByOperId(operId);
		
		for(int i = 0  ; i < list.size() ; i++) {
			
			CardInPo cardInPo = list.get(i);
			
			result1 = cardInMapper.insertCardIn(cardInPo);
		}
		
		BigDecimal sunccess = new BigDecimal(0);
	    
		if(result1 != 0) {
			
		    BigDecimal result = new BigDecimal(0);
		    
		    Map<String,Object>  paramts = new HashMap<String,Object>();
		    
		    paramts.put("result", result);
		    paramts.put("loginId", operId);
			
		    cardInMapper.callImportCard(paramts);
		    		
		    sunccess = (BigDecimal)paramts.get("result");     
		}
		
		return sunccess;
	}
}

package com.bdxh.kmsale.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bdxh.kmsale.bean.NumberInPo;
import com.bdxh.kmsale.mapper.NumberInMapper;
import com.bdxh.kmsale.service.NumberInService;

@Service
public class NumberInServiceImpl implements NumberInService{
	@Resource
	private NumberInMapper numberInMapper;

	@Override
	public BigDecimal insertMandatory(NumberInPo numberInPo,String loginId) {
	
//		numberInMapper.insertMandatory(numberInPo);
		
		BigDecimal success = new BigDecimal(0);
	      
		String simNumber = numberInPo.getSimNumber();
		String svcNumber = numberInPo.getSvcNumber();

		BigDecimal cardType = null;
		if (StringUtils.isNotBlank(svcNumber) && StringUtils.isNotBlank(simNumber)) {
			
			cardType = new BigDecimal(2);
		} else {
			cardType = new BigDecimal(1);
			simNumber = "0";
		}

		Map<String, Object> paramts = new HashMap<String, Object>();

		BigDecimal result = new BigDecimal(0);

		paramts.put("result", result);
		paramts.put("svcNumber", svcNumber);
		paramts.put("simNumber", simNumber);
		paramts.put("loginId", loginId);
		paramts.put("cardType", cardType);
		paramts.put("branchId", "");

		success = numberInMapper.callImportNumberForce(paramts);
		
		return success;
	}
	
	@Transactional
	@Override
	public BigDecimal saveInportSimFile(List<NumberInPo> list,String operId){
		
		Integer result1 = 0;
		
		numberInMapper.deleteNumberInByOperId(operId);
		
		for(int i = 0  ; i < list.size() ; i++) {
			
			NumberInPo numberInPo = list.get(i);
			
			result1 = numberInMapper.insertNumberIn(numberInPo);
		}
		
		BigDecimal sunccess = new BigDecimal(0);
		BigDecimal cardType = new BigDecimal(0);

	    if ((list != null) && (list.size() > 0)){
	    	
	    	NumberInPo numberInPo = list.get(0);
	    	
	        String number = numberInPo.getSvcNumber();
	        
	        if(StringUtils.isBlank(numberInPo.getSimNumber())) {
	        	
	        	if (number.substring(0, 4).equals("0871")){
		             cardType = new BigDecimal(4);
		        }
		        else{
		             cardType = new BigDecimal(1);
		        }
	        }
	        else{
		        cardType = new BigDecimal(2);
		    }
	    }
	    
		if(result1 != 0) {
			
		    BigDecimal result = new BigDecimal(0);
		    
		    Map<String,Object>  paramts = new HashMap<String,Object>();
		    
		    paramts.put("result", result);
		    paramts.put("loginId", operId);
		    paramts.put("cardType", cardType);
			
		    numberInMapper.callImportNumber(paramts);
		    		
		    sunccess = (BigDecimal)paramts.get("result");     
		}
		
		return sunccess;	 
	}

}

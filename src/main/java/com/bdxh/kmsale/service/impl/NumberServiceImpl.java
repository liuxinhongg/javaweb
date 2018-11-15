package com.bdxh.kmsale.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.bdxh.kmsale.bean.NumberPo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.NumberMapper;
import com.bdxh.kmsale.service.NumberService;

@Service
public class NumberServiceImpl implements NumberService{

	@Resource
	private NumberMapper numberMapper;

	@Override
	public List<NumberPo> getPage(NumberPo numberPo, Paging paging) {
		// TODO Auto-generated method stub
		return numberMapper.getPage(numberPo, paging);
	}

	@Override
	public Long getCount(NumberPo numberPo) {
		// TODO Auto-generated method stub
		return numberMapper.getCount(numberPo);
	}
	
	@Override
	public void saveBackOrSend(Integer saveType,String numberId,Integer branchId) {
		
		String[] numberIds = numberId.split(",");
		
		if(saveType.equals(1) || saveType.equals(2)) {
			
			for(int i = 0 ; i < numberIds.length ; i ++) {
				
				numberMapper.shareNumberById(branchId, Integer.parseInt(numberIds[i]));
			}
		}
		else {
			
            for(int i = 0 ; i < numberIds.length ; i ++) {
				
				numberMapper.recoverNumberById(branchId, Integer.parseInt(numberIds[i]));
			}
		}
	}
}

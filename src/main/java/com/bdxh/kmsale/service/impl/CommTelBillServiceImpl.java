package com.bdxh.kmsale.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.bdxh.kmsale.bean.code.CommTelBillPo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.code.CommTelBillMapper;
import com.bdxh.kmsale.service.CommTelBillService;

@Service
public class CommTelBillServiceImpl implements CommTelBillService{

	@Resource 
	private CommTelBillMapper commTelBillMapper;

	@Override
	public List<CommTelBillPo> getPage(Paging paging) {
		// TODO Auto-generated method stub
		return commTelBillMapper.getPage(paging);
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return commTelBillMapper.getCount();
	}

	@Override
	public CommTelBillPo getCommTelBillPoById(Integer telBillId) {
		// TODO Auto-generated method stub
		return commTelBillMapper.getCommTelBillPoById(telBillId);
	}

	@Override
	public Integer insertCommTelBillPo(CommTelBillPo commTelBillPo) {
		// TODO Auto-generated method stub
		return commTelBillMapper.insertCommTelBillPo(commTelBillPo);
	}

	@Override
	public Integer updateCommTelBillPo(CommTelBillPo commTelBillPo) {
		// TODO Auto-generated method stub
		return commTelBillMapper.updateCommTelBillPo(commTelBillPo);
	}

	@Override
	public Integer deleteCommTelBillPo(String telBillId) {
	
		String[] telBillIds = telBillId.split(",");
		
		for(int i = 0 ; i < telBillIds.length ; i ++) {
			
			commTelBillMapper.deleteCommTelBillPo(Integer.parseInt(telBillIds[i]));
		}
		
		return 1;
	}
}

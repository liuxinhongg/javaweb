package com.bdxh.kmsale.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.bdxh.kmsale.bean.comm.CommissionPo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.comm.CommissionMapper;
import com.bdxh.kmsale.service.CommissionService;

@Service
public class CommissionServiceImpl implements  CommissionService{
	
	@Resource
	private CommissionMapper commissionMapper;

	@Override
	public List<CommissionPo> getPage(CommissionPo commissionPo, Paging paging) {
		// TODO Auto-generated method stub
		return commissionMapper.getPage(commissionPo, paging);
	}

	@Override
	public Long getCount(CommissionPo commissionPo) {
		// TODO Auto-generated method stub
		return commissionMapper.getCount(commissionPo);
	}

	@Override
	public List<CommissionPo> getAllCommissionByCondition(CommissionPo commissionPo) {
		// TODO Auto-generated method stub
		return commissionMapper.getAllCommissionByCondition(commissionPo);
	}

}

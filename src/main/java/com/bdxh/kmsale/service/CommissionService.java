package com.bdxh.kmsale.service;

import java.util.List;
import com.bdxh.kmsale.bean.comm.CommissionPo;
import com.bdxh.kmsale.domain.Paging;

public interface CommissionService {

	List<CommissionPo> getPage(CommissionPo commissionPo, Paging paging);

	Long getCount(CommissionPo commissionPo);
	
	List<CommissionPo> getAllCommissionByCondition(CommissionPo commissionPo);	
}

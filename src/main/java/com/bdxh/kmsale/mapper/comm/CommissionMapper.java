package com.bdxh.kmsale.mapper.comm;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.comm.CommissionPo;
import com.bdxh.kmsale.domain.Paging;

public interface CommissionMapper {

	List<CommissionPo> getPage(@Param(value = "commissionPo") CommissionPo commissionPo, @Param(value = "paging") Paging paging);

	Long getCount(@Param(value = "commissionPo") CommissionPo commissionPo);
	
	List<CommissionPo> getAllCommissionByCondition(@Param(value = "commissionPo") CommissionPo commissionPo);	
}

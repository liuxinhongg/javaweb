package com.bdxh.kmsale.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.NumberPo;
import com.bdxh.kmsale.domain.Paging;

public interface NumberMapper {

	List<NumberPo> getPage(@Param(value = "numberPo") NumberPo numberPo, @Param(value = "paging") Paging paging);
	
	Long getCount(@Param(value = "numberPo") NumberPo numberPo);
	
	public NumberPo getNumberBySvcNumber(@Param(value = "svcNum") String svcNum);
	
	Integer shareNumberById(@Param(value = "branchId") Integer branchId,@Param(value = "id") Integer id);
	
	Integer recoverNumberById(@Param(value = "branchId") Integer branchId,@Param(value = "id") Integer id);
}

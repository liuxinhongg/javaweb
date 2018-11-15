package com.bdxh.kmsale.mapper;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bdxh.kmsale.bean.NumberInPo;


public interface NumberInMapper {

	//强制导入手机号
	Integer insertMandatory(@Param(value = "numberInPo")NumberInPo numberInPo);

	Integer insertNumberIn(@Param(value = "numberInPo")NumberInPo numberInPo);
	
	public Long deleteNumberInByOperId(@Param(value = "operId")String operId);
	
	public BigDecimal callImportNumber(Map<String,Object> paramts);
	
	public BigDecimal callImportNumberForce(Map<String,Object> paramts);
}

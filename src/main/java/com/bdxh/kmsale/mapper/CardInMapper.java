package com.bdxh.kmsale.mapper;

import java.math.BigDecimal;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.inventory.CardInPo;

public interface CardInMapper {

	public Integer insertCardIn(@Param(value = "cardInPo") CardInPo cardInPo);
	
	public Long deleteCardInByOperId(@Param(value = "operId")String operId);
	
	public BigDecimal callImportCard(Map<String,Object> paramts);
}

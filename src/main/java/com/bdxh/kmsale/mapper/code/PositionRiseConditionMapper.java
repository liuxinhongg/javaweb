package com.bdxh.kmsale.mapper.code;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.code.PositionRiseConditionPo;
import com.bdxh.kmsale.domain.Paging;

public interface PositionRiseConditionMapper {

	List<PositionRiseConditionPo> getPage(@Param(value = "paging") Paging paging);

	Long getCount();
	
	PositionRiseConditionPo getPositionRiseConditionPoById(@Param(value = "conditionId") Integer conditionId);
	
	Integer insertPositionRiseConditionPo(@Param(value = "positionRiseConditionPo") PositionRiseConditionPo positionRiseConditionPo);

	Integer updatePositionRiseConditionPo(@Param(value = "positionRiseConditionPo") PositionRiseConditionPo positionRiseConditionPo);

	Integer deletePositionRiseConditionPo(@Param(value = "conditionId") Integer conditionId);
}

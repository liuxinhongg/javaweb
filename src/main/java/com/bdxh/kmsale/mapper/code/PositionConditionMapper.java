package com.bdxh.kmsale.mapper.code;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.code.PositionConditionPo;
import com.bdxh.kmsale.domain.Paging;

public interface PositionConditionMapper {

	List<PositionConditionPo> getPage(@Param(value = "conditionType")Integer conditionType,@Param(value = "paging") Paging paging);

	Long getCount(@Param(value = "conditionType")Integer conditionType);
	
	PositionConditionPo getPositionConditionPoById(@Param(value = "conditionId") Integer conditionId);
	
	Integer insertPositionConditionPo(@Param(value = "positionConditionPo") PositionConditionPo positionConditionPo);

	Integer updatePositionConditionPo(@Param(value = "positionConditionPo") PositionConditionPo positionConditionPo);

	Integer deletePositionConditionPo(@Param(value = "conditionId") Integer conditionId);
}

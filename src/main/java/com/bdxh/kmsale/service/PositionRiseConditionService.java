package com.bdxh.kmsale.service;

import java.util.List;
import com.bdxh.kmsale.bean.code.PositionRiseConditionPo;
import com.bdxh.kmsale.domain.Paging;

public interface PositionRiseConditionService {

	List<PositionRiseConditionPo> getPage(Paging paging);

	Long getCount();
	
	PositionRiseConditionPo getPositionRiseConditionPoById(Integer conditionId);
	
	Integer insertPositionRiseConditionPo(PositionRiseConditionPo positionRiseConditionPo);

	Integer updatePositionRiseConditionPo(PositionRiseConditionPo positionRiseConditionPo);

	Integer deletePositionRiseConditionPo(String conditionId);
}

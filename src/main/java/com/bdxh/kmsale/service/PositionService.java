package com.bdxh.kmsale.service;

import java.util.List;
import com.bdxh.kmsale.bean.code.PositionConditionPo;
import com.bdxh.kmsale.bean.code.PositionPo;
import com.bdxh.kmsale.domain.Paging;

public interface PositionService {

	List<PositionPo> getPage(Paging paging);

	Long getCount();

	PositionPo getPositionById(Integer id);

	Integer insertPosition(PositionPo positionPo);

	Integer updatePosition(PositionPo positionPo);

	Integer deletePosition(String id);
	
	List<PositionPo> getAllPositions();
	
	List<PositionConditionPo> getConditionPage(Integer conditiontype,Paging paging);

	Long getConditionCount(Integer conditiontype);
	
    PositionConditionPo getPositionConditionPoById(Integer conditionId);
	
	Integer insertPositionConditionPo(PositionConditionPo positionConditionPo);

	Integer updatePositionConditionPo(PositionConditionPo positionConditionPo);

	Integer deletePositionConditionPo(String conditionId);
}

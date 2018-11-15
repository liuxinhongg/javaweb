package com.bdxh.kmsale.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdxh.kmsale.bean.code.PositionRiseConditionPo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.code.PositionRiseConditionMapper;
import com.bdxh.kmsale.service.PositionRiseConditionService;

@Service
public class PositionRiseConditionServiceImpl implements PositionRiseConditionService{

	@Resource
	private PositionRiseConditionMapper positionRiseConditionMapper;
	
	@Override
	public List<PositionRiseConditionPo> getPage(Paging paging) {
		// TODO Auto-generated method stub
		return positionRiseConditionMapper.getPage(paging);
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return positionRiseConditionMapper.getCount();
	}

	@Override
	public PositionRiseConditionPo getPositionRiseConditionPoById(Integer conditionId) {
		// TODO Auto-generated method stub
		return positionRiseConditionMapper.getPositionRiseConditionPoById(conditionId);
	}

	@Override
	public Integer insertPositionRiseConditionPo(PositionRiseConditionPo positionRiseConditionPo) {
		// TODO Auto-generated method stub
		return positionRiseConditionMapper.insertPositionRiseConditionPo(positionRiseConditionPo);
	}

	@Override
	public Integer updatePositionRiseConditionPo(PositionRiseConditionPo positionRiseConditionPo) {
		// TODO Auto-generated method stub
		return positionRiseConditionMapper.updatePositionRiseConditionPo(positionRiseConditionPo);
	}

	@Override
	public Integer deletePositionRiseConditionPo(String conditionId) {
		// TODO Auto-generated method stub
		String[] conditionIds = conditionId.split(",");
		
		for(int i = 0 ; i < conditionIds.length ; i ++){
			
			positionRiseConditionMapper.deletePositionRiseConditionPo(Integer.parseInt(conditionIds[i]));
		}
		
		return 1;
	}

}

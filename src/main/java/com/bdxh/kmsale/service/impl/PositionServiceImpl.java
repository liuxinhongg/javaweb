package com.bdxh.kmsale.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.bdxh.kmsale.bean.code.PositionConditionPo;
import com.bdxh.kmsale.bean.code.PositionPo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.code.PositionConditionMapper;
import com.bdxh.kmsale.mapper.code.PositionMapper;
import com.bdxh.kmsale.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {

	@Resource
	private PositionMapper positionMapper;

	@Resource
	private PositionConditionMapper positionConditionMapper;

	@Override
	public List<PositionPo> getPage(Paging paging) {
		// TODO Auto-generated method stub
		return positionMapper.getPage(paging);
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return positionMapper.getCount();
	}

	@Override
	public PositionPo getPositionById(Integer id) {
		// TODO Auto-generated method stub
		return positionMapper.getPositionById(id);
	}

	@Override
	public Integer insertPosition(PositionPo positionPo) {
		// TODO Auto-generated method stub
		return positionMapper.insertPosition(positionPo);
	}

	@Override
	public Integer updatePosition(PositionPo positionPo) {
		// TODO Auto-generated method stub
		return positionMapper.updatePosition(positionPo);
	}

	@Override
	public Integer deletePosition(String id) {

		String[] ids = id.split(",");

		for (int i = 0; i < ids.length; i++) {

			positionMapper.deletePosition(Integer.parseInt(ids[i]));
		}

		return 1;
	}
	
	@Override
	public List<PositionPo> getAllPositions(){
		
		return positionMapper.getAllPositions();
	}

	@Override
	public List<PositionConditionPo> getConditionPage(Integer conditiontype,Paging paging) {

		return positionConditionMapper.getPage(conditiontype,paging);
	}

	@Override
	public Long getConditionCount(Integer conditiontype) {

		return positionConditionMapper.getCount(conditiontype);
	}

	@Override
	public PositionConditionPo getPositionConditionPoById(Integer conditionId) {

		return positionConditionMapper.getPositionConditionPoById(conditionId);
	}

	@Override
	public Integer insertPositionConditionPo(PositionConditionPo positionConditionPo) {

		return positionConditionMapper.insertPositionConditionPo(positionConditionPo);
	}

	@Override
	public Integer updatePositionConditionPo(PositionConditionPo positionConditionPo) {

		return positionConditionMapper.updatePositionConditionPo(positionConditionPo);
	}

	@Override
	public Integer deletePositionConditionPo(String conditionId) {

		String[] conditionIds = conditionId.split(",");

		for (int i = 0; i < conditionIds.length; i++) {

			positionConditionMapper.deletePositionConditionPo(Integer.parseInt(conditionIds[i]));
		}

		return 1;
	}

}

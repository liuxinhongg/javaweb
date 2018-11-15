package com.bdxh.kmsale.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdxh.kmsale.bean.NumberPo;
import com.bdxh.kmsale.bean.NumberType;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.NumberTypeMapper;
import com.bdxh.kmsale.service.NumberTypeService;

@Service
public class NumberTypeServicImpl implements NumberTypeService{
	@Resource
	private NumberTypeMapper numberTypeMapper;

	@Override
	public List<NumberType> selectList() {
		
		return numberTypeMapper.selectList();
	}

	@Override
	public List<NumberPo> numberList(NumberPo numberPo,Paging paging) {
		Map<String,Object>map=new HashMap<>();
		map.put("svcnumber1", numberPo.getSvcnumber1());
		map.put("svcnumber2", numberPo.getSvcnumber2());
		map.put("ksvcnumber", numberPo.getKsvcnumber());
		map.put("jsvcnumber", numberPo.getJsvcnumber());
		map.put("leveltype", numberPo.getNumberLevel());
		map.put("opertype", numberPo.getOperType());
		map.put("snno", numberPo.getSnNo());
		map.put("isshare", numberPo.getIsShare());
		map.put("status", numberPo.getStatus());
		map.put("endPos", paging.getEndPos());
		map.put("startPos", paging.getStartPos());
		
		return numberTypeMapper.numberList(map);
	}

	@Override
	public Integer seleclCount(NumberPo numberPo) {
		
		Map<String,Object>map=new HashMap<>();
		map.put("svcnumber1", numberPo.getSvcnumber1());
		map.put("svcnumber2", numberPo.getSvcnumber2());
		map.put("ksvcnumber", numberPo.getKsvcnumber());
		map.put("jsvcnumber", numberPo.getJsvcnumber());
		map.put("leveltype", numberPo.getNumberLevel());
		map.put("opertype", numberPo.getOperType());
		map.put("snno", numberPo.getSnNo());
		map.put("isshare", numberPo.getIsShare());
		map.put("status", numberPo.getStatus());
		
		return numberTypeMapper.seleclCount(map) ;
	}

	@Override
	public Integer selectCountAll() {
		
		return numberTypeMapper.selectCountAll();
	}

}

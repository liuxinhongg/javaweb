package com.bdxh.kmsale.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdxh.kmsale.bean.CardPo;
import com.bdxh.kmsale.bean.NumberPo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.CardMapper;
import com.bdxh.kmsale.service.CardService;

@Service
public class CardServiceImpl implements CardService{
	
	@Resource
	private CardMapper cardMapper;

	@Override
	public Integer seleclCount(NumberPo numberPo) {
		Map<String,Object>map=new HashMap<>(16);
		map.put("simnumber", numberPo.getSimNumber());
		map.put("ksvcnumber", numberPo.getKsvcnumber());
		map.put("jsvcnumber", numberPo.getJsvcnumber());
		map.put("opertype", numberPo.getOperType());
		map.put("snno", numberPo.getSnNo());
		map.put("status", numberPo.getStatus());
		
		return cardMapper.seleclCount(map);
	}

	@Override
	public Integer selectCountAll() {
	
		return cardMapper.selectCountAll();
	}

	@Override
	public List<CardPo> numberList(NumberPo numberPo,Paging paging) {
		
		Map<String,Object>map=new HashMap<>(16);
		map.put("simnumber", numberPo.getSimNumber());
		map.put("ksvcnumber", numberPo.getKsvcnumber());
		map.put("jsvcnumber", numberPo.getJsvcnumber());
		map.put("opertype", numberPo.getOperType());
		map.put("snno", numberPo.getSnNo());
		map.put("status", numberPo.getStatus());
		map.put("startPos",paging.getStartPos());
		map.put("endPos", paging.getEndPos());
		
		return cardMapper.numberList(map);
	}

}

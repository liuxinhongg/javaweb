package com.bdxh.kmsale.service.oper.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdxh.kmsale.bean.oper.Complain;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.oper.ComplainMapper;
import com.bdxh.kmsale.service.oper.ComplainService;
@Service
public class ComplainServiceImpl implements ComplainService{

	@Resource ComplainMapper complainMapper;

	@Override
	public List<Complain> selectComplainByCondition(Complain complain, Paging paging) {
		return complainMapper.selectComplainByCondition(complain, paging);
	}

	@Override
	public Integer selectComplainCount(Complain complain) {
		return complainMapper.selectComplainCount(complain);
	}

	@Override
	public List<Complain> selectComplainByAll(Complain complain) {
		return complainMapper.selectComplainByAll(complain);
	}

}

package com.bdxh.kmsale.service;

import java.util.List;

import com.bdxh.kmsale.bean.NumberPo;
import com.bdxh.kmsale.bean.NumberType;
import com.bdxh.kmsale.domain.Paging;

public interface NumberTypeService {

	//查询靓号类型
	List<NumberType> selectList();
	
    //多条件查询并显示数据
	List<NumberPo> numberList(NumberPo numberPo,Paging paging);

	//查询满足条件的总条数
	Integer seleclCount(NumberPo numberPo);
    //查询总条数
	Integer selectCountAll();

}

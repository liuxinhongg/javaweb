package com.bdxh.kmsale.mapper;

import java.util.List;
import java.util.Map;
import com.bdxh.kmsale.bean.NumberPo;
import com.bdxh.kmsale.bean.NumberType;


public interface NumberTypeMapper {

	//查询靓号类型
	List<NumberType> selectList();
	
    //多条件查询，显示手机号信息
	List<NumberPo> numberList(Map<String, Object> map);
	
	//查询满足条件的总条数
	Integer seleclCount(Map<String, Object> map);
	
	//查询总条数
	Integer selectCountAll();
	
	

}

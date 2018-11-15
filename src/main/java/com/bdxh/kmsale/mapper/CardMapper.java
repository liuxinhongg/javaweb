package com.bdxh.kmsale.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bdxh.kmsale.bean.CardPo;
import com.bdxh.kmsale.bean.NumberPo;
import com.bdxh.kmsale.domain.Paging;

public interface CardMapper {

	Integer seleclCount(Map<String, Object> map);

	Integer selectCountAll();

/*	List<CardPo> numberList(@Param(value="numberPo")NumberPo numberPo,@Param(value="paging")Paging paging);*/

	List<CardPo> numberList(Map<String, Object> map);

}

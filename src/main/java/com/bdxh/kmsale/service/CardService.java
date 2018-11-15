package com.bdxh.kmsale.service;

import java.util.List;

import com.bdxh.kmsale.bean.CardPo;
import com.bdxh.kmsale.bean.NumberPo;
import com.bdxh.kmsale.domain.Paging;

public interface CardService {

	Integer seleclCount(NumberPo numberPo);

	Integer selectCountAll();

	List<CardPo> numberList(NumberPo numberPo,Paging paging);

}

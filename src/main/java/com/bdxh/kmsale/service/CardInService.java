package com.bdxh.kmsale.service;

import java.math.BigDecimal;
import java.util.List;
import com.bdxh.kmsale.bean.inventory.CardInPo;

public interface CardInService {

	BigDecimal saveInportSimFile(List<CardInPo> list,String operId);
}

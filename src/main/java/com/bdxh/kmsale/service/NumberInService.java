package com.bdxh.kmsale.service;

import java.math.BigDecimal;
import java.util.List;

import com.bdxh.kmsale.bean.NumberInPo;

public interface NumberInService {

	BigDecimal insertMandatory(NumberInPo numberInPo,String loginId);

	BigDecimal saveInportSimFile(List<NumberInPo> list,String operId);
}

package com.bdxh.kmsale.service;

import java.util.List;
import com.bdxh.kmsale.bean.NumberPo;
import com.bdxh.kmsale.domain.Paging;

public interface NumberService {

    List<NumberPo> getPage(NumberPo numberPo, Paging paging);
	
	Long getCount(NumberPo numberPo);
	
	void saveBackOrSend(Integer saveType,String numberId,Integer branchId);
}

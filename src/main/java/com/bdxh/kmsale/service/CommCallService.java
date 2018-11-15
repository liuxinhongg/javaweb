package com.bdxh.kmsale.service;

import java.util.List;
import com.bdxh.kmsale.bean.code.CommCallPo;
import com.bdxh.kmsale.domain.Paging;

public interface CommCallService {

	List<CommCallPo> getPage(Paging paging);

	Long getCount();
	
	CommCallPo getCommCallPoById(String codeId);
	
	Integer insertCommCallPo(CommCallPo commCallPo);

	Integer updateCommCallPo(CommCallPo commCallPo);

	Integer deleteCommCallPo(String codeId);
}

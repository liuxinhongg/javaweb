package com.bdxh.kmsale.service;

import java.util.List;
import com.bdxh.kmsale.bean.code.CommManagerPo;
import com.bdxh.kmsale.domain.Paging;

public interface CommManagerService {

	List<CommManagerPo> getPage(Paging paging);

	Long getCount();
	
	CommManagerPo getCommManagerPoById(String codeId);
	
	Integer insertCommManagerPo(CommManagerPo commManagerPo);

	Integer updateCommManagerPo(CommManagerPo commManagerPo);

	Integer deleteCommManagerPo(String codeId);
}

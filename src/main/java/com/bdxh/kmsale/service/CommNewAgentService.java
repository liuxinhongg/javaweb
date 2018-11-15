package com.bdxh.kmsale.service;

import java.util.List;
import com.bdxh.kmsale.bean.code.CommNewAgentPo;
import com.bdxh.kmsale.domain.Paging;

public interface CommNewAgentService {

	List<CommNewAgentPo> getPage(Paging paging);

	Long getCount();
	
	CommNewAgentPo getCommNewAgentPoById(String codeId);
	
	Integer insertCommNewAgentPo(CommNewAgentPo commNewAgentPo);

	Integer updateCommNewAgentPo(CommNewAgentPo commNewAgentPo);

	Integer deleteCommNewAgentPo(String codeId);
}

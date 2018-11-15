package com.bdxh.kmsale.service;

import java.util.List;
import com.bdxh.kmsale.bean.code.CommContributionPo;
import com.bdxh.kmsale.domain.Paging;

public interface CommContributionService {

	List<CommContributionPo> getPage(Paging paging);

	Long getCount();
	
	CommContributionPo getCommContributionPoById(String codeId);
	
	Integer insertCommContributionPo(CommContributionPo commContributionPo);

	Integer updateCommContributionPo(CommContributionPo commContributionPo);

	Integer deleteCommContributionPo(String codeId);
}

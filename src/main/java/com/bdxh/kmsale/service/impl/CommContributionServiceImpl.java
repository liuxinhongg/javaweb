package com.bdxh.kmsale.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.bdxh.kmsale.bean.code.CommContributionPo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.code.CommContributionMapper;
import com.bdxh.kmsale.service.CommContributionService;

@Service
public class CommContributionServiceImpl implements CommContributionService{

	@Resource
	private CommContributionMapper commContributionMapper;
	
	@Override
	public List<CommContributionPo> getPage(Paging paging) {
		// TODO Auto-generated method stub
		return commContributionMapper.getPage(paging);
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return commContributionMapper.getCount();
	}

	@Override
	public CommContributionPo getCommContributionPoById(String codeId) {
		// TODO Auto-generated method stub
		return commContributionMapper.getCommContributionPoById(codeId);
	}

	@Override
	public Integer insertCommContributionPo(CommContributionPo commContributionPo) {
		// TODO Auto-generated method stub
		return commContributionMapper.insertCommContributionPo(commContributionPo);
	}

	@Override
	public Integer updateCommContributionPo(CommContributionPo commContributionPo) {
		// TODO Auto-generated method stub
		return commContributionMapper.updateCommContributionPo(commContributionPo);
	}

	@Override
	public Integer deleteCommContributionPo(String codeId) {
		// TODO Auto-generated method stub
		
		String[] codeIds = codeId.split(",");
		
		for(int i = 0 ; i < codeIds.length ; i++) {
			
			commContributionMapper.deleteCommContributionPo(codeIds[i]);
		}
		
		return 1;
	}

}

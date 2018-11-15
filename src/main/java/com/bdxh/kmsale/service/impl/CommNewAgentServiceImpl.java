package com.bdxh.kmsale.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.bdxh.kmsale.bean.code.CommNewAgentPo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.code.CommNewAgentMapper;
import com.bdxh.kmsale.service.CommNewAgentService;

@Service
public class CommNewAgentServiceImpl implements CommNewAgentService{
	
	@Resource
	private CommNewAgentMapper commNewAgentMapper;

	@Override
	public List<CommNewAgentPo> getPage(Paging paging) {
		// TODO Auto-generated method stub
		return commNewAgentMapper.getPage(paging);
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return commNewAgentMapper.getCount();
	}

	@Override
	public CommNewAgentPo getCommNewAgentPoById(String codeId) {
		// TODO Auto-generated method stub
		return commNewAgentMapper.getCommNewAgentPoById(codeId);
	}

	@Override
	public Integer insertCommNewAgentPo(CommNewAgentPo commNewAgentPo) {
		// TODO Auto-generated method stub
		return commNewAgentMapper.insertCommNewAgentPo(commNewAgentPo);
	}

	@Override
	public Integer updateCommNewAgentPo(CommNewAgentPo commNewAgentPo) {
		// TODO Auto-generated method stub
		return commNewAgentMapper.updateCommNewAgentPo(commNewAgentPo);
	}

	@Override
	public Integer deleteCommNewAgentPo(String codeId) {
		
		String[] codeIds = codeId.split(",");
		
		for(int i = 0 ; i < codeIds.length ; i ++) {
			
			commNewAgentMapper.deleteCommNewAgentPo(codeIds[i]);
		}
		
		return 1;
	}

}

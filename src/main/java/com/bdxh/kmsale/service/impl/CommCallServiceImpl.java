package com.bdxh.kmsale.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.bdxh.kmsale.bean.code.CommCallPo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.code.CommCallMapper;
import com.bdxh.kmsale.service.CommCallService;

@Service
public class CommCallServiceImpl implements CommCallService{
	
	@Resource
	private CommCallMapper commCallMapper;

	@Override
	public List<CommCallPo> getPage(Paging paging) {
		// TODO Auto-generated method stub
		return commCallMapper.getPage(paging);
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return commCallMapper.getCount();
	}

	@Override
	public CommCallPo getCommCallPoById(String codeId) {
		// TODO Auto-generated method stub
		return commCallMapper.getCommCallPoById(codeId);
	}

	@Override
	public Integer insertCommCallPo(CommCallPo commCallPo) {
		// TODO Auto-generated method stub
		return commCallMapper.insertCommCallPo(commCallPo);
	}

	@Override
	public Integer updateCommCallPo(CommCallPo commCallPo) {
		// TODO Auto-generated method stub
		return commCallMapper.updateCommCallPo(commCallPo);
	}

	@Override
	public Integer deleteCommCallPo(String codeId) {
		
		String[] codeIds = codeId.split(",");
		
		for(int i = 0 ; i < codeIds.length ; i ++) {
			
			commCallMapper.deleteCommCallPo(codeIds[i]);
		}
		
		return 1;
	}

}

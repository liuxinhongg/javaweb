package com.bdxh.kmsale.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.bdxh.kmsale.bean.code.CommManagerPo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.code.CommManagerMapper;
import com.bdxh.kmsale.service.CommManagerService;

@Service
public class CommManagerServiceImpl implements CommManagerService{

	@Resource
	private CommManagerMapper commManagerMapper;
	
	@Override
	public List<CommManagerPo> getPage(Paging paging) {
		// TODO Auto-generated method stub
		return commManagerMapper.getPage(paging);
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return commManagerMapper.getCount();
	}

	@Override
	public CommManagerPo getCommManagerPoById(String codeId) {
		// TODO Auto-generated method stub
		return commManagerMapper.getCommManagerPoById(codeId);
	}

	@Override
	public Integer insertCommManagerPo(CommManagerPo commManagerPo) {
		// TODO Auto-generated method stub
		return commManagerMapper.insertCommManagerPo(commManagerPo);
	}

	@Override
	public Integer updateCommManagerPo(CommManagerPo commManagerPo) {
		// TODO Auto-generated method stub
		return commManagerMapper.updateCommManagerPo(commManagerPo);
	}

	@Override
	public Integer deleteCommManagerPo(String codeId) {
		// TODO Auto-generated method stub
		
		String[] codeIds = codeId.split(",");
		
		for(int i = 0 ; i < codeIds.length ; i++) {
			
			commManagerMapper.deleteCommManagerPo(codeIds[i]);
		}
		
		return 1;
	}

}

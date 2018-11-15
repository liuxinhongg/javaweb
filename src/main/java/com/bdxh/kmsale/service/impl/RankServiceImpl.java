package com.bdxh.kmsale.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.bdxh.kmsale.bean.org.RankPo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.RankMapper;
import com.bdxh.kmsale.service.RankService;

@Service
public class RankServiceImpl implements RankService{

	@Resource
	private RankMapper rankMapper;

	@Override
	public List<RankPo> getPage(RankPo rankPo, Paging paging) {
		// TODO Auto-generated method stub
		return rankMapper.getPage(rankPo, paging);
	}

	@Override
	public Long getCount(RankPo rankPo) {
		// TODO Auto-generated method stub
		return rankMapper.getCount(rankPo);
	}

	@Override
	public List<RankPo> getRankPoList(RankPo rankPo) {
		// TODO Auto-generated method stub
		return rankMapper.getRankPoList(rankPo);
	}

	@Override
	public void refreshRank() {
		// TODO Auto-generated method stub
	    String result = "ERROR";
	    Map<String,Object> paramts = new HashMap<String,Object>();
	    
	    paramts.put("result", result);
			
		rankMapper.refreshRank(paramts);
	}
}

package com.bdxh.kmsale.service;

import java.util.List;
import com.bdxh.kmsale.bean.org.RankPo;
import com.bdxh.kmsale.domain.Paging;

public interface RankService {

    List<RankPo> getPage(RankPo rankPo,Paging paging);
	
	Long getCount(RankPo rankPo);
	
	List<RankPo> getRankPoList(RankPo rankPo);
	
	void refreshRank();
}

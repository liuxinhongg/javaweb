package com.bdxh.kmsale.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.org.RankPo;
import com.bdxh.kmsale.domain.Paging;

public interface RankMapper {

	List<RankPo> getPage(@Param(value = "rankPo") RankPo rankPo, @Param(value = "paging") Paging paging);
	
	Long getCount(@Param(value = "rankPo") RankPo rankPo);
	
	List<RankPo> getRankPoList(@Param(value = "rankPo") RankPo rankPo);
	
	void refreshRank(Map<String,Object> paramts);
}

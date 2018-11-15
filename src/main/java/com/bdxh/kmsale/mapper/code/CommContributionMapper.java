package com.bdxh.kmsale.mapper.code;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.code.CommContributionPo;
import com.bdxh.kmsale.domain.Paging;

public interface CommContributionMapper {

	List<CommContributionPo> getPage(@Param(value = "paging") Paging paging);

	Long getCount();
	
	CommContributionPo getCommContributionPoById(@Param(value = "codeId") String codeId);
	
	Integer insertCommContributionPo(@Param(value = "commContributionPo") CommContributionPo commContributionPo);

	Integer updateCommContributionPo(@Param(value = "commContributionPo") CommContributionPo commContributionPo);

	Integer deleteCommContributionPo(@Param(value = "codeId") String codeId);
}

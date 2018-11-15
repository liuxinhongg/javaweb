package com.bdxh.kmsale.mapper.code;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.code.CommNewAgentPo;
import com.bdxh.kmsale.domain.Paging;

public interface CommNewAgentMapper {

	List<CommNewAgentPo> getPage(@Param(value = "paging") Paging paging);

	Long getCount();
	
	CommNewAgentPo getCommNewAgentPoById(@Param(value = "codeId") String codeId);
	
	Integer insertCommNewAgentPo(@Param(value = "commNewAgentPo") CommNewAgentPo commNewAgentPo);

	Integer updateCommNewAgentPo(@Param(value = "commNewAgentPo") CommNewAgentPo commNewAgentPo);

	Integer deleteCommNewAgentPo(@Param(value = "codeId") String codeId);
}

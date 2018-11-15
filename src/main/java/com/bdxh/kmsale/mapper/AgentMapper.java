package com.bdxh.kmsale.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.org.AgentPo;
import com.bdxh.kmsale.domain.Paging;

public interface AgentMapper {

    List<AgentPo> getSamplePage(@Param(value = "agentPo") AgentPo agentPo, @Param(value = "paging") Paging paging);
	
    Long getSampleCount(@Param(value = "agentPo") AgentPo agentPo);
    
    List<AgentPo> getPage(@Param(value = "agentPo") AgentPo agentPo, @Param(value = "paging") Paging paging);
    
    Long getCount(@Param(value = "agentPo") AgentPo agentPo);
	
	AgentPo getAgentById(@Param(value = "noId") String noId);
	
	String saveOrg(AgentPo agentPo);
	
	BigDecimal updateOrg(AgentPo agentPo);
	
	BigDecimal saveDelAgent(Map<String,Object> paramts);
	
	List<AgentPo> getAgentAlertPage(@Param(value = "agentPo") AgentPo agentPo, @Param(value = "paging") Paging paging);
	
	Long getAgentAlertCount(@Param(value = "agentPo") AgentPo agentPo);
	 
	List<AgentPo> getAgentAlertList(@Param(value = "agentPo") AgentPo agentPo);
}

package com.bdxh.kmsale.service;

import java.math.BigDecimal;
import java.util.List;
import com.bdxh.kmsale.bean.org.AgentPo;
import com.bdxh.kmsale.domain.Paging;

public interface AgentService {

	List<AgentPo> getSamplePage(AgentPo agentPo, Paging paging);

	Long getSampleCount(AgentPo agentPo);
	
	List<AgentPo> getPage(AgentPo agentPo, Paging paging);

	Long getCount(AgentPo agentPo);

	AgentPo getAgentById(String noId);
	
	String saveOrg(AgentPo agentPo);
	
	BigDecimal updateOrg(AgentPo agentPo);
	
	void saveDelAgent(String[] noId);
	
	void saveDeleteAgent(String[] noId);
	
	List<AgentPo> getAgentAlertPage(AgentPo agentPo, Paging paging);
	
	Long getAgentAlertCount(AgentPo agentPo);
	
	List<AgentPo> getAgentAlertList(AgentPo agentPo);
}

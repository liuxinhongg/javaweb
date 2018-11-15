package com.bdxh.kmsale.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bdxh.kmsale.bean.org.AgentPo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.AgentMapper;
import com.bdxh.kmsale.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService {

	@Resource
	private AgentMapper agentMapper;

	@Override
	public List<AgentPo> getSamplePage(AgentPo agentPo, Paging paging) {
		// TODO Auto-generated method stub
		return agentMapper.getSamplePage(agentPo, paging);
	}

	@Override
	public Long getSampleCount(AgentPo agentPo) {
		// TODO Auto-generated method stub
		return agentMapper.getSampleCount(agentPo);
	}

	@Override
	public AgentPo getAgentById(String noId) {
		// TODO Auto-generated method stub
		return agentMapper.getAgentById(noId);
	}

	@Override
	public List<AgentPo> getPage(AgentPo agentPo, Paging paging) {

		return agentMapper.getPage(agentPo, paging);
	}

	@Override
	public Long getCount(AgentPo agentPo) {

		return agentMapper.getCount(agentPo);
	}

	@Override
	public String saveOrg(AgentPo agentPo) {

		return agentMapper.saveOrg(agentPo);
	}

	@Override
	public BigDecimal updateOrg(AgentPo agentPo) {

		return agentMapper.updateOrg(agentPo);
	}

	@Transactional
	@Override
	public void saveDelAgent(String[] noId) {

		for (int i = 0; i < noId.length; i++) {

			BigDecimal result = new BigDecimal(0);
			Map<String, Object> paramts = new HashMap<String, Object>();

			paramts.put("V_RESULT", result);
			paramts.put("V_STATUS", new BigDecimal(0));
			paramts.put("V_NO_ID", noId[i]);

			agentMapper.saveDelAgent(paramts);
			
			System.out.println((BigDecimal)paramts.get("V_RESULT"));
		}
	}

	@Transactional
	@Override
	public void saveDeleteAgent(String[] noId) {

		for (int i = 0; i < noId.length; i++) {

			BigDecimal result = new BigDecimal(0);
			Map<String, Object> paramts = new HashMap<String, Object>();

			paramts.put("V_RESULT", result);
			paramts.put("V_STATUS", new BigDecimal(2));
			paramts.put("V_NO_ID", noId[i]);

			agentMapper.saveDelAgent(paramts);
			
			System.out.println((BigDecimal)paramts.get("V_RESULT"));
		}
	}
	
	@Override
	public List<AgentPo> getAgentAlertPage(AgentPo agentPo, Paging paging){
		
		return agentMapper.getAgentAlertPage(agentPo, paging);
	}
	
	@Override
	public Long getAgentAlertCount(AgentPo agentPo) {
		
		return agentMapper.getAgentAlertCount(agentPo);
	}
	
	@Override
	public List<AgentPo> getAgentAlertList(AgentPo agentPo){
		
		return agentMapper.getAgentAlertList(agentPo);
	}

}

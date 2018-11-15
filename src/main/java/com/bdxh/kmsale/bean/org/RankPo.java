package com.bdxh.kmsale.bean.org;

import java.io.Serializable;

public class RankPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8181201184223218271L;
	
	private String noId;
	private String pNoId;
	private String agentName;
	private String pAgentName;
	private Integer branchId;
	private String branchName;
	private Integer lvl;
	private String rank;
	private String rankNo;
	private String rankStr;

	public void setNoId(String noId) {
		this.noId = noId;
	}

	public String getNoId() {
		return this.noId;
	}

	public void setPNoId(String pNoId) {
		this.pNoId = pNoId;
	}

	public String getPNoId() {
		return this.pNoId;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentName() {
		return this.agentName;
	}

	public void setpAgentName(String pAgentName) {
		this.pAgentName = pAgentName;
	}

	public String getpAgentName() {
		return this.pAgentName;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getBranchId() {
		return this.branchId;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}

	public Integer getLvl() {
		return this.lvl;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getRank() {
		return this.rank;
	}

	public void setRankNo(String rankNo) {
		this.rankNo = rankNo;
	}

	public String getRankNo() {
		return this.rankNo;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setRankStr(String rankStr) {
		this.rankStr = rankStr;
	}

	public String getRankStr() {
		return this.rankStr;
	}
}

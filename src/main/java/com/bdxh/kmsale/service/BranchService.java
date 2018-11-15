package com.bdxh.kmsale.service;

import java.math.BigDecimal;
import java.util.List;
import com.bdxh.kmsale.bean.org.BranchPo;
import com.bdxh.kmsale.domain.Paging;

public interface BranchService {
	
	List<BranchPo> getPage(BranchPo branchPo, Paging paging);
	
	Integer getCount(BranchPo branchPo);
	
    List<BranchPo> getSamplePage(String branchName, Paging paging);
	
	Integer getSampleCount(String branchName);

	String getAllBrachPo();
	
	BranchPo getById(Integer id);
    
    List<BranchPo> getBranchList(BranchPo branchPo);
	
	Long saveOrg(BranchPo branchPo);
	
	Long updateOrg(BranchPo branchPo);
	
	Long saveBranchPo(BranchPo branchPo);
	
	Long updateBranchPo(BranchPo branchPo);
	
	void initBranch();
	
	public BigDecimal deleteBranch(Integer branchId) throws Exception;
	
	void delOrg(Integer branchId) throws Exception;
}

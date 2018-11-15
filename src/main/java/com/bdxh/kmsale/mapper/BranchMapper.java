package com.bdxh.kmsale.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.org.BranchPo;
import com.bdxh.kmsale.domain.Paging;

public interface BranchMapper {
	
	List<BranchPo> getPage(@Param(value = "branchPo") BranchPo branchPo, @Param(value = "paging") Paging paging);
		
	Integer getCount(@Param(value = "branchPo") BranchPo branchPo);
		
	BranchPo getById(@Param(value = "value")Integer value);
	
	List<BranchPo> getAllBrachPo();
	
	List<BranchPo> getBranchList(@Param(value = "branchPo") BranchPo branchPo);
	
	Long saveBranchPo(@Param(value = "branchPo") BranchPo branchPo);
	
	Long updateBranchPo(@Param(value = "branchPo") BranchPo branchPo);
	
	public BigDecimal assumeManager(Map<String,Object> paramts);
	
	public BigDecimal deleteBranch(Map<String,Object> paramts);
	
	public Integer isHasBranchNode(@Param(value = "branchId")Integer branchId);
	
	void delOrg(@Param(value = "branchId")Integer branchId);
	
    List<BranchPo> getSamplePage(@Param(value = "branchName")String branchName,@Param(value = "paging")Paging paging);
	
	Integer getSampleCount(@Param(value = "branchName")String branchName);
}

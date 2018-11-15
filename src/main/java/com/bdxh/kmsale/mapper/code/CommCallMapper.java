package com.bdxh.kmsale.mapper.code;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.code.CommCallPo;
import com.bdxh.kmsale.domain.Paging;

public interface CommCallMapper {

	List<CommCallPo> getPage(@Param(value = "paging") Paging paging);

	Long getCount();
	
	CommCallPo getCommCallPoById(@Param(value = "codeId") String codeId);
	
	Integer insertCommCallPo(@Param(value = "commCallPo") CommCallPo commCallPo);

	Integer updateCommCallPo(@Param(value = "commCallPo") CommCallPo commCallPo);

	Integer deleteCommCallPo(@Param(value = "codeId") String codeId);
}

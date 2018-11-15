package com.bdxh.kmsale.mapper.code;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.code.CommManagerPo;
import com.bdxh.kmsale.domain.Paging;

public interface CommManagerMapper {

	List<CommManagerPo> getPage(@Param(value = "paging") Paging paging);

	Long getCount();
	
	CommManagerPo getCommManagerPoById(@Param(value = "codeId") String codeId);
	
	Integer insertCommManagerPo(@Param(value = "commManagerPo") CommManagerPo commManagerPo);

	Integer updateCommManagerPo(@Param(value = "commManagerPo") CommManagerPo commManagerPo);

	Integer deleteCommManagerPo(@Param(value = "codeId") String codeId);
}

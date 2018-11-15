package com.bdxh.kmsale.mapper.code;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.code.CommTelBillPo;
import com.bdxh.kmsale.domain.Paging;

public interface CommTelBillMapper {

	List<CommTelBillPo> getPage(@Param(value = "paging") Paging paging);

	Long getCount();
	
	CommTelBillPo getCommTelBillPoById(@Param(value = "telBillId") Integer telBillId);
	
	Integer insertCommTelBillPo(@Param(value = "commTelBillPo") CommTelBillPo commTelBillPo);

	Integer updateCommTelBillPo(@Param(value = "commTelBillPo") CommTelBillPo commTelBillPo);

	Integer deleteCommTelBillPo(@Param(value = "telBillId") Integer telBillId);
}

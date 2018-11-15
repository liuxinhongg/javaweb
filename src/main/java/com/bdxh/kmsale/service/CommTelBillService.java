package com.bdxh.kmsale.service;

import java.util.List;
import com.bdxh.kmsale.bean.code.CommTelBillPo;
import com.bdxh.kmsale.domain.Paging;

public interface CommTelBillService {

	List<CommTelBillPo> getPage(Paging paging);

	Long getCount();
	
	CommTelBillPo getCommTelBillPoById(Integer telBillId);
	
	Integer insertCommTelBillPo(CommTelBillPo commTelBillPo);

	Integer updateCommTelBillPo(CommTelBillPo commTelBillPo);

	Integer deleteCommTelBillPo(String telBillId);
}

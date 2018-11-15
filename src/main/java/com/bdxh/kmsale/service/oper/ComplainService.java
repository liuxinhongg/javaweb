package com.bdxh.kmsale.service.oper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdxh.kmsale.bean.oper.Complain;
import com.bdxh.kmsale.domain.Paging;

public interface ComplainService {
	
	Integer selectComplainCount(Complain complain);
	//分页模糊查询
	List<Complain> selectComplainByCondition(Complain complain,Paging paging);

	List<Complain> selectComplainByAll(Complain complain);
}

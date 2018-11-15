package com.bdxh.kmsale.mapper.oper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdxh.kmsale.bean.oper.Complain;
import com.bdxh.kmsale.bean.oper.SaleBo;
import com.bdxh.kmsale.bean.oper.SalePo;
import com.bdxh.kmsale.domain.Paging;

public interface ComplainMapper {
//模糊查询数据数量，输入null则为全部
Integer selectComplainCount(@Param(value = "complain") Complain complain);
//分页模糊查询
List<Complain> selectComplainByCondition(@Param(value = "complain") Complain complain, @Param(value = "paging") Paging paging);

List<Complain> selectComplainByAll(@Param(value = "complain") Complain complain);
}

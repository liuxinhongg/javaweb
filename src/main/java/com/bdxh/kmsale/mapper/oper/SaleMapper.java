package com.bdxh.kmsale.mapper.oper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bdxh.kmsale.bean.code.DeviceBo;
import com.bdxh.kmsale.bean.code.DevicePo;
import com.bdxh.kmsale.bean.code.ProductPo;
import com.bdxh.kmsale.bean.oper.SaleBo;
import com.bdxh.kmsale.bean.oper.SalePo;
import com.bdxh.kmsale.domain.Paging;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月7日,下午5:46:43
 * @Description 销售记录
 */
public interface SaleMapper {
	//模糊查询数据数量，输入null则为全部
		Integer selectSaleCount(SaleBo saleBo);
		//模糊分页查询
		List<SalePo> selectSaleByCondition(@Param(value = "saleBo") SaleBo saleBo, @Param(value = "paging") Paging paging);
		//根据Id删除sale
		void deleteSaleById(String saleId);
		//插入对象
		void insertSale(SaleBo saleBo);
		//查询所有终端
		List<DevicePo> selectAllDeviceList();
		//查询所有套餐
		List<ProductPo> selectAllProductList();
		//根据operId查询用户是否有权限
		Integer selectViewRoleUser(String operId);
}

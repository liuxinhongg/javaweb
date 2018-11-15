package com.bdxh.kmsale.service.oper;

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
public interface SaleService {
	   /**
	    * @param saleBo为查询条件
	    * @return 模糊查询数据数量，输入null则为全部
	    */
		Integer selectSaleCount(SaleBo saleBo);
		/**
		 * 
		 * @param saleBo 查询条件
		 * @param paging 分页条件
		 * @return 模糊分页查询数据SalePo集合
		 */
		List<SalePo> selectSaleByCondition(SaleBo saleBo, Paging paging);
		/**
		 * 根据Id删除sale
		 * @param saleId
		 */
		void deleteSaleById(String saleId);
		/**
		 * 查询saleBo对象
		 */
		void insertSale(SaleBo saleBo);
		/**
		 * @return 查询所有终端
		 */
		List<DevicePo> selectAllDeviceList();
		/**
		 * @return 查询所有套餐
		 */
		List<ProductPo> selectAllProductList();
		/**
		 * @param operId 查询条件
		 * @return 查询用户是否有权限
		 */
		Integer selectViewRoleUser(String operId);
}

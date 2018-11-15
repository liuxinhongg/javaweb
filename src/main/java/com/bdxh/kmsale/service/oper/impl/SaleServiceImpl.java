package com.bdxh.kmsale.service.oper.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdxh.kmsale.bean.code.DeviceBo;
import com.bdxh.kmsale.bean.code.DevicePo;
import com.bdxh.kmsale.bean.code.ProductPo;
import com.bdxh.kmsale.bean.oper.SaleBo;
import com.bdxh.kmsale.bean.oper.SalePo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.oper.SaleMapper;
import com.bdxh.kmsale.service.oper.SaleService;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月7日,下午5:46:43
 * @Description 销售记录
 */
@Service
public class SaleServiceImpl implements SaleService{
	@Resource
	private SaleMapper saleMapper;
	@Override
	public Integer selectSaleCount(SaleBo saleBo) {
		return saleMapper.selectSaleCount(saleBo);
	}

	@Override
	public List<SalePo> selectSaleByCondition(SaleBo saleBo, Paging paging) {
		return saleMapper.selectSaleByCondition(saleBo, paging);
	}

	@Override
	public void deleteSaleById(String saleId) {
		saleMapper.deleteSaleById(saleId);
	}

	@Override
	public void insertSale(SaleBo saleBo) {
		saleMapper.insertSale(saleBo);
	}

	@Override
	public List<DevicePo> selectAllDeviceList() {
		return saleMapper.selectAllDeviceList();
	}

	@Override
	public List<ProductPo> selectAllProductList() {
		return saleMapper.selectAllProductList();
	}

	@Override
	public Integer selectViewRoleUser(String operId) {
		return saleMapper.selectViewRoleUser(operId);
	}

}

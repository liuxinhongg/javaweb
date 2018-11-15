package com.bdxh.kmsale.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bdxh.kmsale.bean.code.ProductPo;
import com.bdxh.kmsale.bean.code.ProductTypePo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.code.ProductMapper;
import com.bdxh.kmsale.mapper.code.ProductTypeMapper;
import com.bdxh.kmsale.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Resource
	private ProductMapper productMapper;
	
	@Resource
	private ProductTypeMapper productTypeMapper;

	@Override
	public List<ProductPo> getPage(ProductPo productPo, Paging paging) {
		// TODO Auto-generated method stub
		return productMapper.getPage(productPo, paging);
	}

	@Override
	public Long getCount(ProductPo productPo) {
		// TODO Auto-generated method stub
		return productMapper.getCount(productPo);
	}

	@Override
	public List<ProductPo> getList(ProductPo cardPo) {
		// TODO Auto-generated method stub
		return productMapper.getList(cardPo);
	}

	@Override
	public ProductPo getProductById(String productId) {
		// TODO Auto-generated method stub
		return productMapper.getProductById(productId);
	}

	@Override
	public Integer insertProduct(ProductPo productPo) {
		// TODO Auto-generated method stub
		return productMapper.insertProduct(productPo);
	}

	@Override
	public Integer updateProduct(ProductPo productPo) {
		// TODO Auto-generated method stub
		return productMapper.updateProduct(productPo);
	}

	@Transactional
	@Override
	public Integer deleteProduct(String productId) {
		// TODO Auto-generated method stub
		
		String[] productIds = productId.split(",");
		
		for(int i = 0 ; i < productIds.length ; i ++) {
			
			productMapper.deleteProduct(productIds[i]);
		}
		
		return 1;
	}

	@Override
	public List<ProductTypePo> getAllProductType() {
		// TODO Auto-generated method stub
		return productMapper.getAllProductType();
	}
	
	@Override
	public List<ProductTypePo> getTypePage(Paging paging){
		
		return productTypeMapper.getPage(paging);
	}

	@Override
	public Long getTypeCount() {
		
		return productTypeMapper.getCount();
	}
	
	@Override
	public ProductTypePo getProductTypePoById(String codeId) {
		
		return productTypeMapper.getProductTypePoById(codeId);
	}
	
	@Override
	public Integer insertProductTypePo(ProductTypePo productTypePo) {
		
		return productTypeMapper.insertProductTypePo(productTypePo);
	}

	@Override
	public Integer updateProductTypePo(ProductTypePo productTypePo) {
		
		return productTypeMapper.updateProductTypePo(productTypePo);
	}

	@Override
	public Integer deleteProductTypePo(String codeId) {
		
		return productTypeMapper.deleteProductTypePo(codeId);
	}
}

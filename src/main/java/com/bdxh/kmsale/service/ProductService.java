package com.bdxh.kmsale.service;

import java.util.List;
import com.bdxh.kmsale.bean.code.ProductPo;
import com.bdxh.kmsale.bean.code.ProductTypePo;
import com.bdxh.kmsale.domain.Paging;

public interface ProductService {

    List<ProductPo> getPage(ProductPo productPo,Paging paging);
	
	Long getCount(ProductPo productPo);
	
	List<ProductPo> getList(ProductPo cardPo);
	
	ProductPo getProductById(String  productId);
	
	Integer insertProduct(ProductPo productPo);
	
	Integer updateProduct(ProductPo productPo);
	
	Integer deleteProduct(String  productId);
	
	List<ProductTypePo>  getAllProductType();
	
	List<ProductTypePo> getTypePage(Paging paging);

	Long getTypeCount();
	
	ProductTypePo getProductTypePoById(String codeId);
	
	Integer insertProductTypePo(ProductTypePo productTypePo);

	Integer updateProductTypePo(ProductTypePo productTypePo);

	Integer deleteProductTypePo(String codeId);
}

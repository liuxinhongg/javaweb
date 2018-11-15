package com.bdxh.kmsale.mapper.code;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.code.ProductPo;
import com.bdxh.kmsale.bean.code.ProductTypePo;
import com.bdxh.kmsale.domain.Paging;

public interface ProductMapper {

    List<ProductPo> getPage(@Param(value = "productPo") ProductPo productPo, @Param(value = "paging") Paging paging);
	
	Long getCount(@Param(value = "productPo") ProductPo productPo);
	
	List<ProductPo> getList(@Param(value = "productPo") ProductPo cardPo);
	
	ProductPo getProductById(@Param(value = "productId") String  productId);
	
	Integer insertProduct(@Param(value = "productPo") ProductPo productPo);
	
	Integer updateProduct(@Param(value = "productPo") ProductPo productPo);
	
	Integer deleteProduct(@Param(value = "productId") String  productId);
	
	List<ProductTypePo>  getAllProductType();
}

package com.bdxh.kmsale.mapper.code;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.code.ProductTypePo;
import com.bdxh.kmsale.domain.Paging;

public interface ProductTypeMapper {

	List<ProductTypePo> getPage(@Param(value = "paging") Paging paging);

	Long getCount();
	
	ProductTypePo getProductTypePoById(@Param(value = "codeId") String codeId);
	
	Integer insertProductTypePo(@Param(value = "productTypePo") ProductTypePo productTypePo);

	Integer updateProductTypePo(@Param(value = "productTypePo") ProductTypePo productTypePo);

	Integer deleteProductTypePo(@Param(value = "codeId") String codeId);
}

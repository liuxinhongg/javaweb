package com.bdxh.kmsale.mapper.code;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.code.PositionPo;
import com.bdxh.kmsale.domain.Paging;

public interface PositionMapper {

	List<PositionPo> getPage(@Param(value = "paging") Paging paging);

	Long getCount();

	PositionPo getPositionById(@Param(value = "id") Integer id);

	Integer insertPosition(@Param(value = "positionPo") PositionPo positionPo);

	Integer updatePosition(@Param(value = "positionPo") PositionPo positionPo);

	Integer deletePosition(@Param(value = "id") Integer id);
	
	List<PositionPo> getAllPositions();
}

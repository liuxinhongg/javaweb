package com.bdxh.kmsale.mapper.code;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bdxh.kmsale.bean.code.DevicePo;
import com.bdxh.kmsale.bean.code.DeviceTypePo;
import com.bdxh.kmsale.bean.code.SchemeTypePo;
import com.bdxh.kmsale.domain.Paging;

public interface DeviceMapper {

    List<DevicePo> getPage(@Param(value = "devicePo") DevicePo devicePo, @Param(value = "paging") Paging paging);
	
	Long getCount(@Param(value = "devicePo") DevicePo devicePo);
	
	List<DevicePo> getList(@Param(value = "devicePo") DevicePo devicePo);
	
	DevicePo getDeviceById(@Param(value = "deviceId") Integer  deviceId);
	
	Integer insertDevice(@Param(value = "devicePo") DevicePo devicePo);
	
	Integer updateDevice(@Param(value = "devicePo") DevicePo devicePo);
	
	Integer deleteDevice(@Param(value = "deviceId") Integer  deviceId);
	
	List<DeviceTypePo>  getAllDeviceType();
	
	List<SchemeTypePo> getAllSchemeType();
}

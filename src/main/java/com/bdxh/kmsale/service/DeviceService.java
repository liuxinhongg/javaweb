package com.bdxh.kmsale.service;

import java.util.List;
import com.bdxh.kmsale.bean.code.DevicePo;
import com.bdxh.kmsale.bean.code.DeviceTypePo;
import com.bdxh.kmsale.bean.code.SchemeTypePo;
import com.bdxh.kmsale.domain.Paging;

public interface DeviceService {

    List<DevicePo> getPage(DevicePo devicePo, Paging paging);
	
	Long getCount(DevicePo devicePo);
	
	List<DevicePo> getList(DevicePo devicePo);
	
	DevicePo getDeviceById(Integer  deviceId);
	
	Integer insertDevice(DevicePo devicePo);
	
	Integer updateDevice(DevicePo devicePo);
	
	Integer deleteDevice(String  deviceId);
	
	List<DeviceTypePo>  getAllDeviceType();
	
	List<SchemeTypePo> getAllSchemeType();
}

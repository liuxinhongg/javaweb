package com.bdxh.kmsale.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.bdxh.kmsale.bean.code.DevicePo;
import com.bdxh.kmsale.bean.code.DeviceTypePo;
import com.bdxh.kmsale.bean.code.SchemeTypePo;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.code.DeviceMapper;
import com.bdxh.kmsale.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService{

	@Resource
	private DeviceMapper deviceMapper;

	@Override
	public List<DevicePo> getPage(DevicePo devicePo, Paging paging) {
		// TODO Auto-generated method stub
		return deviceMapper.getPage(devicePo, paging);
	}

	@Override
	public Long getCount(DevicePo devicePo) {
		// TODO Auto-generated method stub
		return deviceMapper.getCount(devicePo);
	}

	@Override
	public List<DevicePo> getList(DevicePo devicePo) {
		// TODO Auto-generated method stub
		return deviceMapper.getList(devicePo);
	}

	@Override
	public DevicePo getDeviceById(Integer deviceId) {
		// TODO Auto-generated method stub
		return deviceMapper.getDeviceById(deviceId);
	}

	@Override
	public Integer insertDevice(DevicePo devicePo) {
		// TODO Auto-generated method stub
		return deviceMapper.insertDevice(devicePo);
	}

	@Override
	public Integer updateDevice(DevicePo devicePo) {
		// TODO Auto-generated method stub
		return deviceMapper.updateDevice(devicePo);
	}

	@Override
	public Integer deleteDevice(String deviceId) {

        String[] deviceIds = deviceId.split(",");
        
        for(int i = 0 ; i < deviceIds.length ; i ++) {
        	
        	deviceMapper.deleteDevice(Integer.parseInt(deviceIds[i]));
        }
		
		return null;
	}

	@Override
	public List<DeviceTypePo> getAllDeviceType() {
		// TODO Auto-generated method stub
		return deviceMapper.getAllDeviceType();
	}
	
	@Override
	public List<SchemeTypePo> getAllSchemeType(){
		
		return deviceMapper.getAllSchemeType();
	}
}

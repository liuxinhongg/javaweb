package com.bdxh.kmsale.controller.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.code.DevicePo;
import com.bdxh.kmsale.bean.code.DeviceTypePo;
import com.bdxh.kmsale.bean.code.SchemeTypePo;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.DeviceService;

@Controller
@RequestMapping("/code/device")
public class DeviceController extends AbstractBackendController<AbstractEntity, Long> {

	@Resource
	private DeviceService deviceService;
	
	// 列表页
	@RequestMapping("")
	public String index() {
		return "code/device/device";
	}

	// 多条件模糊查询
	@RequestMapping(value = "/getDeviceList", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getDeviceList(String deviceName, String deviceDesc, String deviceTypeCode,
			String schemeTypeCode,String status, Integer pageCurrent, Integer pageSize) {

		Paging paging = new Paging();
		paging.setPageCurrent(pageCurrent);
		paging.setPageSize(pageSize);

		DevicePo devicePo = new DevicePo();
		devicePo.setDeviceName(deviceName);
		devicePo.setDeviceDesc(deviceDesc);
		devicePo.setDeviceTypeCode(deviceTypeCode);
		devicePo.setSchemeTypeCode(schemeTypeCode);
		devicePo.setStatus(status);

		Integer pageCurrents = paging.getPageCurrent();// 当前页
		if (pageCurrents == null || pageCurrents == 0 || pageCurrents.equals("")) {
			pageCurrents = 1;
		}
		paging.setPageCurrent(pageCurrents);
		// 满足条件查询的条数
		Integer userCountCondition = deviceService.getCount(devicePo).intValue();

		// 每页显示数据条数
		Integer pageSizes = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrents = pageCount;
		}
		List<DevicePo> list = deviceService.getPage(devicePo, paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("devicePoList", list);
		map.put("pageSize", pageSizes);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrents);
		return getJsonResponseEntity(map);
	}

	// 查询设备类型
	@RequestMapping(value = "/getAllDeviceType", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getAllDeviceType() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<DeviceTypePo> numberTypeList = deviceService.getAllDeviceType();
		map.put("deviceTypeList", numberTypeList);
		return getJsonResponseEntity(map);
	}
	
	// 查询业务类型
	@RequestMapping(value = "/getAllSchemeType", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getAllSchemeType() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<SchemeTypePo> schemeTypeList = deviceService.getAllSchemeType();
		map.put("schemeTypeList", schemeTypeList);
		return getJsonResponseEntity(map);
	}

	@RequestMapping("/toAddDevice")
	public String toAddDevice() {
		return "code/device/addDevice";
	}

	@RequestMapping("/toEditDevice")
	public String toEditDevice(Model model, Integer deviceId) {

		DevicePo devicePo = deviceService.getDeviceById(deviceId);

		model.addAttribute("devicePo", devicePo);

		return "code/device/editDevice";
	}

	@RequestMapping(value = "/addDevice", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addDevice(String deviceName, String deviceDesc, String deviceTypeCode,
			String schemeTypeCode, Double deduct,Double price,String status) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			DevicePo devicePo = new DevicePo();
			devicePo.setDeviceName(deviceName);
			devicePo.setDeviceDesc(deviceDesc);
			devicePo.setDeviceTypeCode(deviceTypeCode);
			devicePo.setSchemeTypeCode(schemeTypeCode);
			devicePo.setDeduct(deduct);
			devicePo.setPrice(price);
			devicePo.setStatus(status);

			deviceService.insertDevice(devicePo);

			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "添加失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/editDevice", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> editDevice(Integer deviceId,String deviceName, String deviceDesc, String deviceTypeCode,
			String schemeTypeCode, Double deduct,Double price,String status) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			DevicePo devicePo = new DevicePo();
			devicePo.setDeviceId(deviceId);
			devicePo.setDeviceName(deviceName);
			devicePo.setDeviceDesc(deviceDesc);
			devicePo.setDeviceTypeCode(deviceTypeCode);
			devicePo.setSchemeTypeCode(schemeTypeCode);
			devicePo.setDeduct(deduct);
			devicePo.setPrice(price);
			devicePo.setStatus(status);

			deviceService.updateDevice(devicePo);

			map.put("state", 0);
			map.put("msg", "编辑成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "编辑失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/deleteDevices", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> deleteDevices(String deviceIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			deviceService.deleteDevice(deviceIds);

			map.put("state", 0);
			map.put("msg", "删除成功");
		} catch (Exception e) {

			e.printStackTrace();

			map.put("state", -1);
			map.put("msg", "删除失败");
		}
		return getJsonResponseEntity(map);
	}
}

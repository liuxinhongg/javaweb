package com.bdxh.kmsale.controller.oper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.code.DeviceBo;
import com.bdxh.kmsale.bean.code.DevicePo;
import com.bdxh.kmsale.bean.code.ProductPo;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.service.oper.SaleService;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月7日,下午5:59:37
 * @Description 销售记录控制器
 */
@Controller
@RequestMapping("/oper/sale")
public class SaleController extends AbstractBackendController<AbstractEntity, Long> {
	@Resource
	private SaleService saleService;
	//显示菜单列表
	@RequestMapping("")
	public String showsale() {
		return "oper/sale";
	}
	//显示菜单列表
	@RequestMapping("/list")
	public String showSaleList() {
		return "oper/saleList";
	}
	//显示选择设置
	@RequestMapping("/addDevice")
	public String showAddDevice() {
		return "oper/addSaleDevice";
	}
	
	//确认批量添加
	@RequestMapping("/confirmAddSale")
	public String showConfirmAddSale() {
		return "oper/confirmAddSale";
	}
	/**
	 * 查询所有终端
	 * @return devices
	 */
	@RequestMapping(value = "/getDevice", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getDevice(){
		List<DevicePo> devices=saleService.selectAllDeviceList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("devices", devices);
		return getJsonResponseEntity(map);
	}
	
	/**
	 * 查询所有套餐
	 * @return devices
	 */
	@RequestMapping(value = "/getProduct", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getProduct(){
		List<ProductPo> products=saleService.selectAllProductList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("products", products);
		return getJsonResponseEntity(map);
	}
}

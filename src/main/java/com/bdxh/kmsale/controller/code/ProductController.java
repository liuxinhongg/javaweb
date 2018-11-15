package com.bdxh.kmsale.controller.code;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.code.ProductPo;
import com.bdxh.kmsale.bean.code.ProductTypePo;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.ProductService;

@Controller
@RequestMapping("/code/product")
public class ProductController extends AbstractBackendController<AbstractEntity, Long> {

	@Resource
	private ProductService productService;

	// 列表页
	@RequestMapping("")
	public String index() {
		return "code/product/product";
	}

	// 多条件模糊查询
	@RequestMapping(value = "/getProductList", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getProductList(String productName, String productType, Short isView,
			String isIh, String isKh, Integer pageCurrent, Integer pageSize) {

		Paging paging = new Paging();
		paging.setPageCurrent(pageCurrent);
		paging.setPageSize(pageSize);

		ProductPo productPo = new ProductPo();
		productPo.setProductName(productName);
		productPo.setProductType(productType);
		productPo.setIsView(isView);
		productPo.setIsIh(isIh);
		productPo.setIsKh(isKh);

		Integer pageCurrents = paging.getPageCurrent();// 当前页
		if (pageCurrents == null || pageCurrents == 0 || pageCurrents.equals("")) {
			pageCurrents = 1;
		}
		paging.setPageCurrent(pageCurrents);
		// 满足条件查询的条数
		Integer userCountCondition = productService.getCount(productPo).intValue();

		// 每页显示数据条数
		Integer pageSizes = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrents = pageCount;
		}
		List<ProductPo> list = productService.getPage(productPo, paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("proudctPoList", list);
		map.put("pageSize", pageSizes);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrents);
		return getJsonResponseEntity(map);
	}

	// 查询套餐类型
	@RequestMapping(value = "/getProductType", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getProductType() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<ProductTypePo> numberTypeList = productService.getAllProductType();
		map.put("productTypeList", numberTypeList);
		return getJsonResponseEntity(map);
	}

	@RequestMapping("/toAddProduct")
	public String toAddProduct() {
		return "code/product/addProduct";
	}

	@RequestMapping("/toEditProduct")
	public String toEditProduct(Model model, String productId) {

		ProductPo productPo = productService.getProductById(productId);

		model.addAttribute("productPo", productPo);

		return "code/product/editProduct";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addProduct(String productName, Short isView, String productType,
			Double action, Double four, Double noneFour, String isIh, String isKh, String productDesc) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			ProductPo productPo = new ProductPo();

			productPo.setProductName(productName);
			productPo.setIsView(isView);
			productPo.setProductType(productType);
			productPo.setAction(action);
			productPo.setFour(noneFour);
			productPo.setNoneFour(noneFour);
			productPo.setIsIh(isIh);
			productPo.setIsKh(isKh);
			productPo.setProductDesc(productDesc);

			productService.insertProduct(productPo);

			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "添加失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> editProduct(String productId, String productName, Short isView,
			String productType, Double action, Double four, Double noneFour, String isIh, String isKh,
			String productDesc) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			ProductPo productPo = new ProductPo();

			productPo.setProductId(productId);
			productPo.setProductName(productName);
			productPo.setIsView(isView);
			productPo.setProductType(productType);
			productPo.setAction(action);
			productPo.setFour(noneFour);
			productPo.setNoneFour(noneFour);
			productPo.setIsIh(isIh);
			productPo.setIsKh(isKh);
			productPo.setProductDesc(productDesc);

			productService.updateProduct(productPo);

			map.put("state", 0);
			map.put("msg", "编辑成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "编辑失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/delProducts", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> delProducts(String productIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			productService.deleteProduct(productIds);

			map.put("state", 0);
			map.put("msg", "删除成功");
		} catch (Exception e) {

			e.printStackTrace();

			map.put("state", -1);
			map.put("msg", "删除失败");
		}
		return getJsonResponseEntity(map);
	}

	// 列表
	@RequestMapping(value = "/getTypeList", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getTypeList(Integer pageCurrent, Integer pageSize) {

		Paging paging = new Paging();
		paging.setPageCurrent(pageCurrent);
		paging.setPageSize(pageSize);

		Integer pageCurrents = paging.getPageCurrent();// 当前页
		if (pageCurrents == null || pageCurrents == 0) {
			pageCurrents = 1;
		}
		paging.setPageCurrent(pageCurrents);
		// 满足条件查询的条数
		Integer userCountCondition = productService.getTypeCount().intValue();

		// 每页显示数据条数
		Integer pageSizes = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrents = pageCount;
		}
		List<ProductTypePo> list = productService.getTypePage(paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productTypeList", list);
		map.put("pageSize", pageSizes);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrents);
		return getJsonResponseEntity(map);
	}

	@RequestMapping("/toAddType")
	public String toAddTellBill() {
		return "code/pushmoney/addType";
	}

	@RequestMapping("/toEditType")
	public String toEditTellBill(Model model, String codeId) {

		ProductTypePo productTypePo = productService.getProductTypePoById(codeId);

		model.addAttribute("productTypePo", productTypePo);

		return "code/pushmoney/editType";
	}

	@RequestMapping(value = "/addType", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addType(Double onceRate, String codeDesc, Integer ord, Integer status, HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			ProductTypePo productTypePo = new ProductTypePo();
			productTypePo.setOnceRate(onceRate);
			productTypePo.setCodeDesc(codeDesc);
			productTypePo.setOrd(ord);
			productTypePo.setOperId(user.getLoginId());
			productTypePo.setStatus(status);

			productService.insertProductTypePo(productTypePo);

			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "添加失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/editType", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> editType(String codeId, Double onceRate, String codeDesc,
			Integer ord, Integer status, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			ProductTypePo productTypePo = new ProductTypePo();
			productTypePo.setOnceRate(onceRate);
			productTypePo.setCodeDesc(codeDesc);
			productTypePo.setOrd(ord);
			productTypePo.setOperId(user.getLoginId());
			productTypePo.setStatus(status);
			productTypePo.setCodeId(codeId);
			productTypePo.setCreateDate(new Date());

			productService.updateProductTypePo(productTypePo);

			map.put("state", 0);
			map.put("msg", "编辑成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "编辑失败");
		}
		return getJsonResponseEntity(map);
	}

	@RequestMapping(value = "/deleteProductTypes", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> deleteProductTypes(String codeIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			productService.deleteProductTypePo(codeIds);

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

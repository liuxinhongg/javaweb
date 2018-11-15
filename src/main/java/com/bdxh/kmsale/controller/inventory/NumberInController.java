package com.bdxh.kmsale.controller.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSONObject;
import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.NumberInPo;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.service.NumberInService;
import com.bdxh.kmsale.utils.PoiExcelTool;

@Controller
@RequestMapping("/inventory/numberIn")
public class NumberInController extends AbstractBackendController<AbstractEntity, Long> {

	@Resource
	private NumberInService numberInService;

	@RequestMapping("/getNumberIn")
	public String getNumberIn() {
		return "inventory/numberIn";
	}

	@RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject uploadExcel(@RequestParam(value="uploadExcel")MultipartFile uploadExcel, Integer branchId, HttpSession session) {

		JSONObject resObj = new JSONObject();

		PoiExcelTool et;

		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			et = new PoiExcelTool(uploadExcel.getInputStream());

			List<String[]> dataList = et.getAllData();

			List<NumberInPo> list = new ArrayList<NumberInPo>();

			for (int i = 0; i < dataList.size(); i++) {

				String[] data = dataList.get(i);

				NumberInPo numberIn = new NumberInPo();
				numberIn.setOperId(user.getLoginId());
				numberIn.setSvcNumber((String) data[0]);

				if (data.length == 1) {
					numberIn.setSimNumber("");
				} else {
					numberIn.setSimNumber((String) data[1]);
				}

				numberIn.setBranchId(String.valueOf(branchId));

				list.add(numberIn);
			}

			numberInService.saveInportSimFile(list, user.getLoginId());

			resObj.put("state", 0);
			resObj.put("msg", "添加成功");

		} catch (Exception e) {
			e.printStackTrace();

			resObj.put("state", -1);
			resObj.put("msg", "添加失败");
		}
		return resObj;
	}

	// 强制导入
	@RequestMapping(value = "excelMandatory", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> excelMandatory(String simnumber, String svcnumber,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			User user = (User) session.getAttribute(Constants.SESSION_USER);
			NumberInPo numberInPo = new NumberInPo();
			numberInPo.setSimNumber(simnumber);
			numberInPo.setSvcNumber(svcnumber);
			numberInPo.setOperId(user.getLoginId());

			numberInService.insertMandatory(numberInPo,user.getLoginId());

			map.put("state", 0);
			map.put("msg", "添加成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "添加失败");
		}
		return getJsonResponseEntity(map);
	}

	// 手机号导入
	@RequestMapping(value = "/addNumberIn", method = RequestMethod.POST)
	@ResponseBody
	public boolean addNumberIn(@RequestParam("file") MultipartFile file, HttpServletResponse response) {

		boolean bool = false;
		String fileName = file.getOriginalFilename();// 获取上传文件原名
		try {
			/* bool = numberInService.addNumberIn(fileName, file,response); */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

}

package com.bdxh.kmsale.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.system.Department;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.service.system.DepartmentService;

/**
 * 部门管理
 * @author 莫夏欣  2018.10.27
 *
 */
@Controller
@RequestMapping("/manage/department")
public class DepartmentController  extends AbstractBackendController<AbstractEntity, Long>{
	@Resource
	private DepartmentService deparService;
	 
	  //输出全部部门列表
		@RequestMapping("/listAll")
		public @ResponseBody ResponseEntity<String> listAll() {
			Map<String, Object> map=new HashMap<String, Object>();
			List<Department> departmentAll=deparService.selectDepartmentList(null);
			map.put("depars", departmentAll);
			return getJsonResponseEntity(map); 
		}
		
}

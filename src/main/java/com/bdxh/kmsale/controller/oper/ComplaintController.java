package com.bdxh.kmsale.controller.oper;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.oper.Complain;
import com.bdxh.kmsale.bean.oper.SaleBo;
import com.bdxh.kmsale.bean.oper.SalePo;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.oper.ComplainService;
import com.bdxh.kmsale.service.oper.SaleService;
import com.bdxh.kmsale.utils.ExcelUtil;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月12日,下午6:08:04
 * @Description 投诉管理
 */
@Controller
@RequestMapping("/oper/complaint")
public class ComplaintController  extends AbstractBackendController<AbstractEntity, Long>{
	@Resource
	private ComplainService complainService;
	//显示投诉列表
		@RequestMapping("")
		public String showSale() {
			return "oper/complaint";
		}
		//显示投诉列表
		@RequestMapping("add")
		public String showAddSale() {
			return "oper/addComplaint";
		}
		
		/**
		 * 查询所有sale
		 * @return devices
		 */
		@RequestMapping(value = "/getComplaint", method = RequestMethod.POST)
		public @ResponseBody ResponseEntity<String> getSale(
				@RequestBody Paging paging,String svcNumber,
				String branchManagerName,String agentName,
				String operatorName,String operOrgId,
				String branchId,String status,
				String endRecord,String isOver,
				String branchCity,String saleDateStart,
				String saleDateEnd){
			Complain complain=new Complain();
			if(svcNumber!=null&&!svcNumber.equals("")){	
				complain.setSvcNumber(svcNumber);
			}
			if(branchManagerName!=null&&!branchManagerName.equals("")){	
				complain.setBranchManagerName(branchManagerName);
			}
			if(agentName!=null&&!agentName.equals("")){	
				complain.setAgentName(agentName);
			}
			if(operatorName!=null&&!operatorName.equals("")){	
				complain.setOperatorName(operatorName);
			}
			if(operOrgId!=null&&!operOrgId.equals("")){	
				complain.setOperOrgId(operOrgId);
			}
			if(branchId!=null&&!branchId.equals("")){
				complain.setBranchId(branchId);
			}
			if(status!=null&&!status.equals("")){	
				complain.setStatus(Integer.parseInt(status));
			}
			if(endRecord!=null&&!endRecord.equals("")){	
				complain.setEndRecord(Integer.parseInt(endRecord));
			}
			if(isOver!=null&&!isOver.equals("")){	
				complain.setIsOver(Integer.parseInt(isOver));
			}
			if(branchCity!=null&&!branchCity.equals("")){	
				complain.setBranchCity(Integer.parseInt(branchCity));
			}
			if(saleDateStart!=null&&!saleDateStart.equals("")){	
				complain.setSaleDateStart(saleDateStart);
			}
			if(saleDateEnd!=null&&!saleDateEnd.equals("")){
				complain.setSaleDateEnd(saleDateEnd);
			}
			Integer pageCurrent = paging.getPageCurrent();// 当前页
			if (pageCurrent == null || pageCurrent == 0) {
				pageCurrent = 1;
			}
			paging.setPageCurrent(pageCurrent);
			// 条件查询返回数
			Complain complain2=new Complain();
			//总数
			Integer complainCount =complainService.selectComplainCount(complain2);
			// 每页显示的数据
			Integer pageSize = paging.getPageSize();
			// 总页数
			Integer CountCondition = complainService.selectComplainCount(complain);
			Integer pageCount = (CountCondition + pageSize - 1) / pageSize;
			if (paging.getPageCurrent() > pageCount) {
				paging.setPageCurrent(pageCount);
				pageCurrent = pageCount;
			}
			List<Complain> complaints=complainService.selectComplainByCondition(complain, paging);
			System.err.println(complaints);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("complaints", complaints);
			map.put("complainCount", complainCount);//总数
			map.put("pageSize", pageSize);
			map.put("pageCount", pageCount);
			map.put("pageCurrent", pageCurrent);
			return getJsonResponseEntity(map);
		}
		
		@RequestMapping(value = { "/exportrank" })
		public @ResponseBody String export(HttpServletRequest request, HttpServletResponse response, ModelMap model,
				String svcNumber,
				String branchManagerName,String agentName,
				String operatorName,String operOrgId,
				String branchId,String status,
				String endRecord,String isOver,
				String branchCity,String saleDateStart,
				String saleDateEnd) {
			Complain complain=new Complain();
			if(svcNumber!=null&&!svcNumber.equals("")){	
				complain.setSvcNumber(svcNumber);
			}
			if(branchManagerName!=null&&!branchManagerName.equals("")){	
				complain.setBranchManagerName(branchManagerName);
			}
			if(agentName!=null&&!agentName.equals("")){	
				complain.setAgentName(agentName);
			}
			if(operatorName!=null&&!operatorName.equals("")){	
				complain.setOperatorName(operatorName);
			}
			if(operOrgId!=null&&!operOrgId.equals("")){	
				complain.setOperOrgId(operOrgId);
			}
			if(branchId!=null&&!branchId.equals("")){
				complain.setBranchId(branchId);
			}
			if(status!=null&&!status.equals("")){	
				complain.setStatus(Integer.parseInt(status));
			}
			if(endRecord!=null&&!endRecord.equals("")){	
				complain.setEndRecord(Integer.parseInt(endRecord));
			}
			if(isOver!=null&&!isOver.equals("")){	
				complain.setIsOver(Integer.parseInt(isOver));
			}
			if(branchCity!=null&&!branchCity.equals("")){	
				complain.setBranchCity(Integer.parseInt(branchCity));
			}
			if(saleDateStart!=null&&!saleDateStart.equals("")){	
				complain.setSaleDateStart(saleDateStart);
			}
			if(saleDateEnd!=null&&!saleDateEnd.equals("")){
				complain.setSaleDateEnd(saleDateEnd);
			}

			List<Complain> list=complainService.selectComplainByAll(complain);
			System.out.println(list);
			String[] title = {"序号","投诉时间","手机号","用户姓名","办卡时间",
					"套餐","终端","投诉内容描述","投诉紧迫性","接线客服姓名",
					"接线客服ID","接线客服处理状态","接线客服处理记录","代理人姓名","代理人编码",
					"代理人所属分区","分区编码","代理人处理状态","代理人处理记录","代理人处理时间",
					"分区经理姓名","分区经理编码","分区经理所属分部","分区经理处理状态","分区经理处理时间",
					"分部经理姓名","分部经理编码","分部经理所属分部","分部经理处理状态","分部经理处理时间",
					"最终处理结果记录","是否处理完结","完结时间","处理登记","登记人",
					"登记时间"};
			Date d = new Date();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMDDhhmmss");
			// excel文件名
			String fileName = "complaint_" + sdf1.format(d)+".xls";
			// sheet名
			String sheetName = "投诉记录";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String[][] content = new String[list.size()][];
			for (int i = 0; i < list.size(); i++) {
				content[i] = new String[title.length];
				Complain rank = (Complain) list.get(i);
				content[i][0] = String.valueOf(i+1);
				content[i][1] = formatter.format(rank.getSaleDate());
				content[i][2] = rank.getSvcNumber();
				content[i][3] = rank.getComplainName();
				content[i][4] = formatter.format(rank.getSaleDate());
				content[i][5] = rank.getProductId();
				content[i][6] = rank.getDeviceId();
				content[i][7] = rank.getMemo();
				content[i][8] = String.valueOf(rank.getStatus());
				content[i][9] = rank.getOperatorName();
				content[i][10] = rank.getOperatorId();
				content[i][11] = String.valueOf(rank.getOperatorStatus());
				content[i][12] = String.valueOf(rank.getOperatorRecord());
				content[i][13] = rank.getAgentName();
			    content[i][14] = rank.getNoId();
				content[i][15] = rank.getBranchName();
				content[i][16] = rank.getBranchId();
				content[i][17] = String.valueOf(rank.getAgentStatus());
				content[i][18] = String.valueOf(rank.getAgentRecord());
				if(rank.getAgentDate()!=null){					
					content[i][19] = formatter.format(rank.getAgentDate());
				}
				content[i][20] = rank.getBranchManagerName();
				content[i][21] = rank.getBranchManagerId();
					content[i][22] = String.valueOf(rank.getBranchStatus());
					content[i][23] = String.valueOf(rank.getBranchRecord());
				if(rank.getBranchDate()!=null){					
					content[i][24] = formatter.format(rank.getBranchDate());
				}
				content[i][25] = rank.getOperOrgManagerName();
				content[i][26] = rank.getOperOrgManagerId();
					content[i][27] = String.valueOf(rank.getOperOrgStatus());
					content[i][28] = String.valueOf(rank.getOperOrgRecord());
				if(rank.getOperOrgDate()!=null){					
					content[i][29] = formatter.format(rank.getOperOrgDate());
				}
					content[i][30] = String.valueOf(rank.getEndStatus());
					content[i][31] = String.valueOf(rank.getIsOver());
				if(rank.getOverData()!=null){					
					content[i][32] = formatter.format(rank.getOverData());
				}
					content[i][33] = String.valueOf(rank.getEndRecord());
				content[i][34] = rank.getOperId();
				if(rank.getOperData()!=null){					
					content[i][35] = formatter.format(rank.getOperData());
				}
			}

			HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

			// 响应到客户端
			try {
				this.setResponseHeader(response, fileName);
				OutputStream os = response.getOutputStream();
				wb.write(os);
				os.flush();
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}

		// 发送响应流方法
		public void setResponseHeader(HttpServletResponse response, String fileName) {
			try {
				try {
					fileName = new String(fileName.getBytes(), "ISO8859-1");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.setContentType("application/octet-stream;charset=ISO8859-1");
				response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
				response.addHeader("Pargam", "no-cache");
				response.addHeader("Cache-Control", "no-cache");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
}

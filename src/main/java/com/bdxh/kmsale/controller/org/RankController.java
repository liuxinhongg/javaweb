package com.bdxh.kmsale.controller.org;

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
import com.bdxh.kmsale.bean.org.RankPo;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.service.RankService;
import com.bdxh.kmsale.utils.ExcelUtil;

@Controller
@RequestMapping("/org/rank")
public class RankController extends AbstractBackendController<AbstractEntity, Long>{

	@Resource
	private RankService rankService;
	
	@RequestMapping("")
	public String rank() {
		return "org/rank/rank";
	}
	
	@RequestMapping(value = "/getRanks", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getRanks(@RequestBody Paging paging, String agentName, String noId, Integer lvl) {

		RankPo rankPo = new RankPo();

		rankPo.setNoId(noId);
		rankPo.setAgentName(agentName);
		rankPo.setLvl(lvl);

		Integer pageCurrent = paging.getPageCurrent();// 当前页

		if (pageCurrent == null || pageCurrent == 0) {
			pageCurrent = 1;
		}

		paging.setPageCurrent(pageCurrent);

		// 条件查询返回数
		Integer userCountCondition = rankService.getCount(rankPo).intValue();

		// 每页显示的数据
		Integer pageSize = paging.getPageSize();
		// 总页数
		Integer pageCount = (userCountCondition - 1) / pageSize + 1;
		if (paging.getPageCurrent() > pageCount) {
			paging.setPageCurrent(pageCount);
			pageCurrent = pageCount;
		}
		List<RankPo> list = rankService.getPage(rankPo, paging);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ranks", list);
		map.put("pageSize", pageSize);
		map.put("pageCount", pageCount);
		map.put("userCountCondition", userCountCondition);
		map.put("pageCurrent", pageCurrent);
		return getJsonResponseEntity(map);
	}
	
	@RequestMapping(value="/refreshRank",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> refreshRank(){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			
			rankService.refreshRank();
			
			map.put("state", 0);
			map.put("msg", "刷新成功");
		} catch (Exception e) {
			
			e.printStackTrace();
			
			map.put("state", -1);
			map.put("msg", "刷新失败");
		}
		return getJsonResponseEntity(map); 
	}
	
	@RequestMapping(value = { "/exportrank" })
	public @ResponseBody String export(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			String agentName, String noId, Integer lvl) {

		RankPo rankPo = new RankPo();

		rankPo.setNoId(noId);
		rankPo.setAgentName(agentName);
		rankPo.setLvl(lvl);

		List<RankPo> list = rankService.getRankPoList(rankPo);

		String[] title = { "所在部门", "姓名","业务代码", "所在层级","血缘路径"};

		Date d = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");

		// excel文件名
		String fileName = "rank_" + sdf1.format(d) + ".xls";

		// sheet名
		String sheetName = "血缘关系";

		String[][] content = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			content[i] = new String[title.length];
			RankPo rank = (RankPo) list.get(i);
			content[i][0] = rank.getBranchName();
			content[i][1] = rank.getAgentName();
			content[i][2] = rank.getNoId();
			content[i][3] = String.valueOf(rank.getLvl());
			content[i][4] = rank.getRankNo();
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

package com.bdxh.kmsale.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bdxh.kmsale.bean.org.BranchPo;
import com.bdxh.kmsale.cache.redis.RedisTemplate;
import com.bdxh.kmsale.domain.Paging;
import com.bdxh.kmsale.mapper.BranchMapper;
import com.bdxh.kmsale.mapper.CommonMapper;
import com.bdxh.kmsale.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	protected RedisTemplate redisTemplate = RedisTemplate.getInstance();

	@Resource
	private BranchMapper branchMapper;
	
	@Resource
	private CommonMapper commonMapper;

	@Override
	public String getAllBrachPo() {

		String tree = redisTemplate.get("branch_tree");
		
		if(StringUtils.isBlank(tree)){
			
			List<BranchPo> list = branchMapper.getAllBrachPo();

			// 判断是否初始化缓存
			if (list != null && list.size() > 0) {	

				tree = initBrachTree(list);
			}
		}

		return tree;
	}
	
	@Override
	public List<BranchPo> getPage(BranchPo branchPo, Paging paging){
		
		return branchMapper.getPage(branchPo, paging);
	}
	
	@Override
	public Integer getCount(BranchPo branchPo){
		
		return branchMapper.getCount(branchPo);
	}
	
	@Override
	public List<BranchPo> getSamplePage(String branchName, Paging paging){
		
		return branchMapper.getSamplePage(branchName, paging);
	}
	
	@Override
	public Integer getSampleCount(String branchName) {
		
		return branchMapper.getSampleCount(branchName);
	}
	
	@Override
	public BranchPo getById(Integer id){
		
		return branchMapper.getById(id);
	}
	
	@Override
	public List<BranchPo> getBranchList(BranchPo branchPo){
		
		return branchMapper.getBranchList(branchPo);
	}
	
	@Transactional
	@Override
	public Long saveOrg(BranchPo branchPo){
		
        Integer branchId = commonMapper.getSpecSequence();
		
		branchPo.setId(branchId);
		
		BranchPo parBranchPo = branchMapper.getById(branchPo.getUpId());

		String branchType = parBranchPo.getBranchTypeCode();
		
		Integer lvl = parBranchPo.getLvl();
		
		if ((branchType != null) && (!"".equals(branchType.trim()))) {
			branchPo.setBranchTypeCode(String.valueOf(Integer.parseInt(branchType) + 1));
		}
		if (lvl != null) {
			branchPo.setLvl(Integer.valueOf(lvl.intValue() + 1));
		}
		
        long id = branchMapper.saveBranchPo(branchPo);
		
//		BigDecimal result = new BigDecimal(-1);
//	    Map<String,Object> paramts = new HashMap<String,Object>();
//	    
//	    paramts.put("result", result);
//	    paramts.put("noId", branchPo.getNoId());
//	    paramts.put("branchId", new BigDecimal(branchPo.getId().intValue()));
//	    paramts.put("operId", branchPo.getOperId());
//	    paramts.put("effectMonth", branchPo.getEffectMonth());
//		
//	    branchMapper.assumeManager(paramts);
		
		return id;
	}
	
	@Transactional
	@Override
	public Long updateOrg(BranchPo branchPo){
		
		BranchPo parBranchPo = branchMapper.getById(branchPo.getUpId());

		String branchType = parBranchPo.getBranchTypeCode();
		
		Integer lvl = parBranchPo.getLvl();
		
		if ((branchType != null) && (!"".equals(branchType.trim()))) {
			branchPo.setBranchTypeCode(String.valueOf(Integer.parseInt(branchType) + 1));
		}
		if (lvl != null) {
			branchPo.setLvl(Integer.valueOf(lvl.intValue() + 1));
		}
		
		long id = branchMapper.updateBranchPo(branchPo);
		
//		BigDecimal result = new BigDecimal(-1);
//	    Map<String,Object> paramts = new HashMap<String,Object>();
//	    
//	    paramts.put("result", result);
//	    paramts.put("noId", branchPo.getNoId());
//	    paramts.put("branchId", new BigDecimal(branchPo.getId().intValue()));
//	    paramts.put("operId", branchPo.getOperId());
//	    paramts.put("effectMonth", branchPo.getEffectMonth());
//		
//	    branchMapper.assumeManager(paramts);
		
		return id;
	}
	
	@Transactional
	@Override
	public Long saveBranchPo(BranchPo branchPo){
		
		Integer branchId = commonMapper.getSpecSequence();
		
		branchPo.setId(branchId);
		
		BranchPo parBranchPo = branchMapper.getById(branchPo.getUpId());

		String branchType = parBranchPo.getBranchTypeCode();
		
		Integer lvl = parBranchPo.getLvl();
		
		if ((branchType != null) && (!"".equals(branchType.trim()))) {
			branchPo.setBranchTypeCode(String.valueOf(Integer.parseInt(branchType) + 1));
		}
		if (lvl != null) {
			branchPo.setLvl(Integer.valueOf(lvl.intValue() + 1));
		}
		
		branchPo.setBranchCity(parBranchPo.getBranchCity());
		
		long id = branchMapper.saveBranchPo(branchPo);
		
		BigDecimal result = new BigDecimal(-1);
	    Map<String,Object> paramts = new HashMap<String,Object>();
	    
	    paramts.put("result", result);
	    paramts.put("noId", branchPo.getNoId());
	    paramts.put("branchId", new BigDecimal(branchPo.getId().intValue()));
	    paramts.put("operId", branchPo.getOperId());
	    paramts.put("effectMonth", branchPo.getEffectMonth());
		
	    branchMapper.assumeManager(paramts);
		
		return id;
	}
	
	@Transactional
	@Override
	public Long updateBranchPo(BranchPo branchPo){
		
		BranchPo parBranchPo = branchMapper.getById(branchPo.getUpId());

		String branchType = parBranchPo.getBranchTypeCode();
		
		Integer lvl = parBranchPo.getLvl();
		
		if ((branchType != null) && (!"".equals(branchType.trim()))) {
			branchPo.setBranchTypeCode(String.valueOf(Integer.parseInt(branchType) + 1));
		}
		if (lvl != null) {
			branchPo.setLvl(Integer.valueOf(lvl.intValue() + 1));
		}
		
		branchPo.setBranchCity(parBranchPo.getBranchCity());
		
		long id = branchMapper.updateBranchPo(branchPo);
		
		BigDecimal result = new BigDecimal(-1);
	    Map<String,Object> paramts = new HashMap<String,Object>();
	    
	    paramts.put("result", result);
	    paramts.put("noId", branchPo.getNoId());
	    paramts.put("branchId", new BigDecimal(branchPo.getId().intValue()));
	    paramts.put("operId", branchPo.getOperId());
	    paramts.put("effectMonth", branchPo.getEffectMonth());
		
	    branchMapper.assumeManager(paramts);
		
		return id;
	}

	public String initBrachTree(List<BranchPo> list) {
		
		String tree = "";

		Map<Integer, String> map = new HashMap<Integer, String>();

		List<BranchPo> p_list = new ArrayList<BranchPo>();
		
		String name = "公众营销部";

		for (int i = 0; i < list.size(); i++) {

			BranchPo po = list.get(i);
			
			map.put(po.getId(), po.getBranchName());
			
			if(po.getLvl().equals(0)){
				
				name = po.getBranchName();
				
				continue;
			}
			else if (po.getLvl().equals(1)) {

				p_list.add(po);
				
			    po.setChildList(new ArrayList<BranchPo>());
				
			} 
			else if(po.getLvl().equals(2)) {

				for (int j = 0 ; j < p_list.size() ; j++) {
					
					BranchPo p = p_list.get(j);
					
					if(p.getId().equals(po.getUpId())){
						
						p.getChildList().add(po);
					}
				}
			}
		}
		
		JSONArray nodes = new JSONArray();
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("name", name);
		jsonObject.put("spread", "true");
		
		JSONObject kunming = new JSONObject();
		
		kunming.put("name", "昆明");
		kunming.put("spread", "true");
		
		JSONObject qita = new JSONObject();
		
		qita.put("name", "地州/市");
		qita.put("spread", "true");
		
		JSONArray childNodes = new JSONArray();
		
        jsonObject.put("name", name);
		
		
		for(int k = 0 ; k < p_list.size() ; k ++){
			
			BranchPo po = p_list.get(k);
			
			JSONObject jo = new JSONObject();	
			
            jo.put("name", po.getBranchName());
            
            if(null != po.getChildList()){
            	
            	List<BranchPo> childlist = po.getChildList();
            	
            	int n = po.getChildList().size();
            	
            	JSONArray kumingJsonArray = new JSONArray();
        		JSONArray qitaJsonArray = new JSONArray();
            	
            	for(int m = 0 ; m < n ; m++){
                	
            		BranchPo child =  childlist.get(m);
            		
            		JSONObject co = new JSONObject();
            		
            		co.put("name", child.getBranchName());
                    co.put("href", "javascript:searchbranchList(" + child.getId() + ");");
                    
                    if(child.getBranchCity().equals(0)){
                    	 kumingJsonArray.add(co);
                    }
                    else{
                     	qitaJsonArray.add(co);
                    }
                } 
            	
            	kunming.put("children", kumingJsonArray);
        		qita.put("children", qitaJsonArray);    
            }  
		}
		
		childNodes.add(kunming);
		childNodes.add(qita);
		
		jsonObject.put("children", childNodes);
		
		nodes.add(jsonObject);
		
		tree = nodes.toJSONString();

		redisTemplate.set("branch_tree", tree);
		redisTemplate.set("branch_key_name", map);
		
		return tree;
	}
	
   	
	@Override
	public void initBranch(){
		
		List<BranchPo> list = branchMapper.getAllBrachPo();

		// 判断是否初始化缓存
		if (list != null && list.size() > 0) {	

			initBrachTree(list);
		}
	}
	
	@Override
	public BigDecimal deleteBranch(Integer branchId) throws Exception{
		
		Integer childCount = branchMapper.isHasBranchNode(branchId);
		
		if ((childCount != null) && (childCount.intValue() > 0)) {
			throw new Exception("存在下级部门，不能删除！");
		}
		
		BigDecimal result = new BigDecimal(0);

		Map<String,Object> paramts = new HashMap<String,Object>();

		paramts.put("result", result);
		paramts.put("branchId", new BigDecimal(branchId.intValue()));

		branchMapper.deleteBranch(paramts);

		result = (BigDecimal) paramts.get("result");
		return (BigDecimal) paramts.get("result");
	}
	
	@Override
	public void delOrg(Integer branchId) throws Exception{
		
         Integer childCount = branchMapper.isHasBranchNode(branchId);
		
		if ((childCount != null) && (childCount.intValue() > 0)) {
			throw new Exception("存在下级部门，不能删除！");
		}
		
		branchMapper.delOrg(branchId);
	}
}

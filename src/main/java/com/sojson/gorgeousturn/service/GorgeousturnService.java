package com.sojson.gorgeousturn.service;

import java.util.List;
import java.util.Map;

import com.sojson.common.model.GorgeousturnM;
import com.sojson.core.mybatis.page.Pagination;


public interface GorgeousturnService {

	//int deleteByPrimaryKey(Long id);

   // GorgeousturnM selectByPrimaryKey(Long id);
	Pagination<GorgeousturnM> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);
    
	        GorgeousturnM selectByPKey(Long id);
	        List<GorgeousturnM> getAllmeeting();
	        GorgeousturnM  insertmeeting(GorgeousturnM gorgeousturnm);
}

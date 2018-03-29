package com.sojson.gorgeousturn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.GorgeousturnMapper;
import com.sojson.common.model.GorgeousturnM;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.gorgeousturn.service.GorgeousturnService;

@Service
public class GorgeousturnServiceImpl extends BaseMybatisDao<GorgeousturnMapper> implements GorgeousturnService {
	/***
	 * 用户手动操作Session
	 * */
	
	@Autowired
	 GorgeousturnMapper gorgeousturnMmapper;
	
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<GorgeousturnM> findByPage(Map<String, Object> resultMap, Integer pageNo, 
			Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}

	@Override
	public GorgeousturnM selectByPKey(Long id) {
		return gorgeousturnMmapper.selectByPKey(id);
	}

	@Override
	public List<GorgeousturnM> getAllmeeting() {
		return gorgeousturnMmapper.getAllmeeting();
	}

	@Override
	public GorgeousturnM insertmeeting(GorgeousturnM gorgeousturnm) {
		// TODO Auto-generated method stub
		 gorgeousturnMmapper.insertmeeting(gorgeousturnm);
		 return  gorgeousturnm;
	}


	

	
	
}

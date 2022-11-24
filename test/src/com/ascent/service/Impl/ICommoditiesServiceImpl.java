package com.ascent.service.Impl;

import java.util.List;

import com.ascent.dao.ICommoditiesDAO;
import com.ascent.po.Commodities;
import com.ascent.service.ICommoditiesService;
import com.ascent.po.Pager;
public class ICommoditiesServiceImpl implements ICommoditiesService{
	private ICommoditiesDAO commoditiesDAO;
	public void setCommoditiesDAO(ICommoditiesDAO CommoditiesDAO) {
		this.commoditiesDAO = CommoditiesDAO;
	}
	public ICommoditiesDAO getCommoditiesDAO() {
		return commoditiesDAO;
	}
	public String addObject2(Object obj,String name) {
		return commoditiesDAO.addObject2(obj,name);
	}
	public List selectSQL(String sql, Object[] value) {
		return commoditiesDAO.selectSQL(sql,value);
	}
	public void updateObject(Object obj) {
		commoditiesDAO.updateObject(obj);
	}
	
	public void deleteObject(Object obj) {
		commoditiesDAO.deleteObject(obj);
	}
	
	public Pager<Commodities> findByPage(Commodities searchModel, int pageNum, int pageSize) {
        Pager<Commodities> result = commoditiesDAO.findByPage(searchModel, pageNum, pageSize);
        return result;
    }
	
	public Pager<Commodities> findByPage2(Commodities searchModel, int pageNum, int pageSize) {
        Pager<Commodities> result = commoditiesDAO.findByPage2(searchModel, pageNum, pageSize);
        return result;
    }
}

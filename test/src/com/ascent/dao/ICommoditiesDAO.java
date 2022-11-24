package com.ascent.dao;

import java.util.List;
import com.ascent.po.Pager;
import com.ascent.po.Commodities;

public interface ICommoditiesDAO {
	//添加方法
	public String addObject2(Object obj,String name);
	
	//根据SQL语句查询
	public List selectSQL(String sql,Object[] value);
		
	//修改方法
	public void updateObject(Object obj);

	//删除方法
	public void deleteObject(Object obj);

	/**
	 * 根据查询条件，查询商品分页信息
	 * 
	 * @param searchModel
	 *            封装查询条件
	 * @param pageNum
	 *            查询第几页数据
	 * @param pageSize
	 *            每页显示多少条记录
	 * @return 查询结果
	 */
	Pager<Commodities> findByPage(Commodities searchModel, int pageNum,
			int pageSize);
	
	Pager<Commodities> findByPage2(Commodities searchModel, int pageNum,
			int pageSize);
}

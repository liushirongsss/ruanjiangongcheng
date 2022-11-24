package com.ascent.dao.Impl;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.ascent.po.Commodities;
import com.ascent.dao.ICommoditiesDAO;
import org.hibernate.FlushMode;
import com.ascent.po.Pager;
import com.ascent.po.Users;

public class ICommoditiesDAOImpl extends HibernateDaoSupport implements ICommoditiesDAO{
	public Integer id;
	public String name;
	public Integer weight;
	public String category;
	public Integer number;
	public Integer purchaseprice;
	public Integer sales;
	public String brand;
	public String supplier;
	public Commodities commodities;
	
	private SessionFactory sessionFactory;

	public void setSessionsFactory(){
		this.setSessionFactory(sessionFactory);
	}
	public String addObject2(Object obj,String name) {
		this.getHibernateTemplate().setCheckWriteOperations(false);
		String[] u = {name};
		String sql = "from Commodities u where u.tradename=?";
		List list = this.getHibernateTemplate().find(sql,u);
		Commodities commoditie = new Commodities();
		if(list.size()>0){
			return "error";
		} else {
			this.getHibernateTemplate().save(obj);
			return "success";
		}
	}
	public List selectSQL(String sql, Object[] value) {
		this.getHibernateTemplate().setCheckWriteOperations(false);
		if(value==null){
			return this.getHibernateTemplate().find(sql);
		} else {
			return this.getHibernateTemplate().find(sql,value);
		}
	}

	public void updateObject(Object obj) {
		this.getHibernateTemplate().setCheckWriteOperations(false);
		Commodities product = new Commodities();
		product = (Commodities)obj;
		id = product.getId();
		name = product.getTradename();
		weight = product.getWeight();
		category = product.getCategory();
		number = product.getNumber();
		purchaseprice = product.getPurchaseprice();
		sales = product.getSales();
		brand = product.getBrand();
		supplier = product.getSupplier();
		String hqlStr = "UPDATE Commodities a"
                + " SET a.tradename=? ,"
                + "  a.weight=? ,"
                + "  a.category=?, "
                + "  a.number=? ,"
                + "  a.purchaseprice=?,"
                + "  a.sales=?,"
                + "  a.brand=?,"
                + "  a.supplier=? "
                + " WHERE a.id=?";
        Session session = this.getSessionFactory().openSession();
        session.createQuery(hqlStr).setString(0, name)
            .setInteger(1, weight).setString(2, category).setInteger(3, number).setInteger(4, purchaseprice)
            .setInteger(5,sales).setString(6, brand).setString(7, supplier).setInteger(8,id).executeUpdate();
        
    
	}

	public void deleteObject(Object obj) {
		this.getHibernateTemplate().setCheckWriteOperations(false);
		Commodities product = new Commodities();
		product = (Commodities)obj;
		id = product.getId();
		Session session = this.getSessionFactory().openSession();
		session.createQuery("delete Commodities where id=?").setInteger(0,id).executeUpdate();
	}
	
	@Transactional(readOnly=true)
	public Pager<Commodities> findByPage(Commodities searchModel, int pageNum, int pageSize) {
		System.out.println("dao层方法启动");
		// 声明结果集
		Pager<Commodities> result = null;

		// 存放查询参数
		Map<String, Object> paramMap = new HashMap<String, Object>();

		String proName = searchModel.getTradename();
		//Double price = searchModel.getPrice();

		StringBuilder hql = new StringBuilder("from Commodities where 1=1");
		StringBuilder countHql = new StringBuilder("select count(id) from Commodities where 1=1 ");

		// 起始索引
		int fromIndex = pageSize * (pageNum - 1);

		// 存放所有查询出的商品对象
		List<Commodities> productList = new ArrayList<Commodities>();

		Session session = null;

		// 获取被Spring托管的session
		session = this.getHibernateTemplate().getSessionFactory().openSession();

		// 获取query对象
		Query hqlQuery = session.createQuery(hql.toString());
		Query countHqlQuery = session.createQuery(countHql.toString());

		// 设置查询参数
		setQueryParams(hqlQuery, paramMap);
		setQueryParams(countHqlQuery, paramMap);

		// 从第几条记录开始查询
		hqlQuery.setFirstResult(fromIndex);

		// 一共查询多少条记录
		hqlQuery.setMaxResults(pageSize);

		// 获取查询的结果
		productList = hqlQuery.list();

		// 获取总记录数
		List<?> countResult = countHqlQuery.list();
		int totalRecord = ((Number) countResult.get(0)).intValue();

		// 获取总页数
		int totalPage = totalRecord / pageSize;
		if (totalRecord % pageSize != 0) {
			totalPage++;
		}

		// 组装pager对象
		result = new Pager<Commodities>(pageSize, pageNum, totalRecord, totalPage, productList);
		System.out.println("dao层方法运行结束");
		
		return result;
	}
	
	@Transactional(readOnly=true)
	public Pager<Commodities> findByPage2(Commodities searchModel, int pageNum, int pageSize) {
		System.out.println("dao层方法启动");
		// 声明结果集
		Pager<Commodities> result = null;

		// 存放查询参数
		Map<String, Object> paramMap = new HashMap<String, Object>();

		String proName = searchModel.getTradename();
		//Double price = searchModel.getPrice();

		StringBuilder hql = new StringBuilder("from Commodities where 1=1");
		StringBuilder countHql = new StringBuilder("select count(id) from Commodities where 1=1 ");
//!!!!!
		if (proName != null && !proName.equals("")) {
			hql.append(" and tradename like :proName ");
			countHql.append("  and tradename like :proName ");
			paramMap.put("proName", "%" + proName + "%");
		}

		// 起始索引
		int fromIndex = pageSize * (pageNum - 1);

		// 存放所有查询出的商品对象
		List<Commodities> productList = new ArrayList<Commodities>();

		Session session = null;

		// 获取被Spring托管的session
		session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();

		// 获取query对象
		Query hqlQuery = session.createQuery(hql.toString());
		Query countHqlQuery = session.createQuery(countHql.toString());

		// 设置查询参数
		setQueryParams(hqlQuery, paramMap);
		setQueryParams(countHqlQuery, paramMap);

		// 从第几条记录开始查询
		hqlQuery.setFirstResult(fromIndex);

		// 一共查询多少条记录
		hqlQuery.setMaxResults(pageSize);

		// 获取查询的结果
		productList = hqlQuery.list();

		// 获取总记录数
		List<?> countResult = countHqlQuery.list();
		int totalRecord = ((Number) countResult.get(0)).intValue();

		// 获取总页数
		int totalPage = totalRecord / pageSize;
		if (totalRecord % pageSize != 0) {
			totalPage++;
		}

		// 组装pager对象
		result = new Pager<Commodities>(pageSize, pageNum, totalRecord, totalPage, productList);
		System.out.println("dao层方法运行结束");
		return result;
	}

	/**
	 * 设置查询的参数
	 * 
	 * @param query
	 * @param paramMap
	 * @return
	 */
	private Query setQueryParams(Query query, Map<String, Object> paramMap) {
		if (paramMap != null && !paramMap.isEmpty()) {
			for (Map.Entry<String, Object> param : paramMap.entrySet()) {
				query.setParameter(param.getKey(), param.getValue());
			}
		}
		return query;
	}
	
	public String showtest(String temp){
		return temp;
	}
}

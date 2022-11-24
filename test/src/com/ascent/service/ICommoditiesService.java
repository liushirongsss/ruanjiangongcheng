package com.ascent.service;
import java.util.List;

import com.ascent.po.Commodities;
import com.ascent.po.Pager;
public interface ICommoditiesService {
	//��ӷ���
	public String addObject2(Object obj,String name);
	
	//����SQL����ѯ
	public List selectSQL(String sql,Object[] value);
			
	//�޸ķ���
	public void updateObject(Object obj);
		
	//ɾ������
	public void deleteObject(Object obj);
	
	/**
     * ���ݲ�ѯ��������ѯ��Ʒ��ҳ��Ϣ
     * 
     * @param searchModel
     *            ��װ��ѯ����
     * @param pageNum
     *            ��ѯ�ڼ�ҳ����
     * @param pageSize
     *            ÿҳ��ʾ��������¼
     * @return ��ѯ���
     */

    Pager<Commodities> findByPage(Commodities searchModel, int pageNum, int pageSize);
    
    Pager<Commodities> findByPage2(Commodities searchModel, int pageNum, int pageSize);

}

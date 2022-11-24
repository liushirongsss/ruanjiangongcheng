package com.ascent.action;
import com.opensymphony.xwork2.ActionContext;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.ascent.po.Pager;
import com.ascent.po.Commodities;

import com.ascent.service.*;
public class ProductAction extends BaseAction{
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
	public Integer getid() {
		return id;
	}
	public void setid(Integer id) {
		this.id = id;
	}
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	
	public Integer getweight() {
		return weight;
	}
	public void setweight(Integer weight) {
		this.weight = weight;
	}
	
	public String getcategory() {
		return category;
	}
	public void setcategory(String category) {
		this.category = category;
	}
	
	public Integer getnumber() {
		return number;
	}
	public void setnumber(Integer number) {
		this.number = number;
	}
	
	public Integer getpurchaseprice() {
		return purchaseprice;
	}
	public void setpurchaseprice(Integer purchaseprice) {
		this.purchaseprice = purchaseprice;
	}
	
	public Integer getsales() {
		return sales;
	}
	public void setsales(Integer sales) {
		this.sales = sales;
	}
	
	public String getbrand() {
		return brand;
	}
	public void setbrand(String brand) {
		this.brand = brand;
	}
	
	public String getsupplier() {
		return supplier;
	}
	public void setsupplier(String supplier) {
		this.supplier = supplier;
	}

	public void setCommodities(Commodities c){
		this.commodities = c;
	}
	
	public String execute(){
		//������Ʒ����
		Commodities product = new Commodities();
		// ��Ӳ�Ʒ��Ϣ
		product.setTradename(this.getname());
		product.setWeight(this.getweight());
		product.setCategory(this.getcategory());
		product.setNumber(this.getnumber());
		product.setPurchaseprice(this.getpurchaseprice());
		product.setSales(this.getsales());
		product.setBrand(this.getbrand());
		product.setSupplier(this.getsupplier());
		if(commoditiesService.addObject2(product,this.getname()).equals("success")){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
		
	}
	
	public String updateProduct(){
		//���Ҷ����޸���Ϣ
		String sql = "from Commodities n where n.id=?";
		Integer[] value = new Integer[1];
		value[0] = this.getid();
		List list = commoditiesService.selectSQL(sql,value);
		Commodities commodities = (Commodities) list.get(0);
		if(!this.getname().equals("")){
			commodities.setTradename(this.getname());
		}
		if(this.getweight()!=null){
			commodities.setWeight(this.getweight());
		}
		if(!this.getcategory().equals("")){
			commodities.setCategory(this.getcategory());
		}
		if(this.getnumber()!=null){
			commodities.setNumber(this.getnumber());
		}
		if(this.getpurchaseprice()!=null){
			commodities.setPurchaseprice(this.getpurchaseprice());
		}
		if(this.getsales()!=null){
			commodities.setSales(this.getsales());
		}
		if(!this.getbrand().equals("")){
			commodities.setBrand(this.getbrand());
		}
		if(!this.getsupplier().equals("")){
			commodities.setSupplier(this.getsupplier());
		}

		//�����޸ĺ���Ϣ
		commoditiesService.updateObject(commodities);
		
		return SUCCESS;
	}
	
	public String deleteProduct(){
		Integer temp = this.getid();
		String sql = "from Commodities n where n.id=?";
		Integer[] value = new Integer[1];
		value[0] = this.getid();
		List list = commoditiesService.selectSQL(sql,value);
		Commodities commodities = (Commodities) list.get(0);
		commoditiesService.deleteObject(commodities);
		return SUCCESS;
	}
	
	//����ǰ�˵�JSON�ַ�������Ҫ�ṩget/set����
    private String responseStr; 

    public String getResponseStr() {
        return responseStr;
    }

    public void setResponseStr(String responseStr) {
        this.responseStr = responseStr;
    }

    public void setProductService(ICommoditiesService productService) {
        this.commoditiesService = productService;
    }

    public String print1(){
    	System.out.print("111111111111");
    	System.out.print(this.getname());
    	return SUCCESS;
    }

    public String findAll() {
        System.out.println("��������������");
        // ʹ��struts2��servlet�ӿڣ�����request��Ĳ���
        // ��Ʒ���ֲ���
        HttpServletRequest request = ServletActionContext.getRequest();
        String proName = request.getParameter("proName");

        // У��pageNum��������Ϸ���
        String pageNumStr = request.getParameter("pageNum");
        System.out.println("ǰ�˸���pageNum�ǣ�"+pageNumStr);

        int pageNum = 1; // Ĭ����ʾ�ڼ�ҳ����
        if (pageNumStr != null && !"".equals(pageNumStr.trim())) {
            pageNum = Integer.parseInt(pageNumStr);
        }

        int pageSize = 5; // Ĭ��ÿҳ��ʾ��������¼
        String pageSizeStr = request.getParameter("pageSize");
        if (pageSizeStr != null && !"".equals(pageSizeStr.trim())) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        // ��װģ����ѯ����
        Commodities searchModel = new Commodities();
        searchModel.setTradename(proName);
        System.out.println("==============Product����==============");
        System.out.println(searchModel);
        // ����service ��ȡ��ѯ���
        Pager<Commodities> result = commoditiesService.findByPage(searchModel, pageNum, pageSize);
        
        // ��pageBean����ֵջ����ǰ��ҳ���ȡ        
        ActionContext.getContext().getValueStack().push(result);
        // ����ѯ����Ҳѹ��ֵջ���ڳ�ʼ��������Ϊ���ʼ��
        ActionContext.getContext().getValueStack().push(searchModel);
        System.out.println("==============Pager����==============");
        System.out.println(result);
        System.out.println("�������������");
        return "findAll";
    }
    
    public String findAll2() {
        System.out.println("��������������");
        // ʹ��struts2��servlet�ӿڣ�����request��Ĳ���
        // ��Ʒ���ֲ���
        HttpServletRequest request = ServletActionContext.getRequest();
        String proName = request.getParameter("proName");

        // У��pageNum��������Ϸ���
        String pageNumStr = request.getParameter("pageNum");
        System.out.println("ǰ�˸���pageNum�ǣ�"+pageNumStr);

        int pageNum = 1; // Ĭ����ʾ�ڼ�ҳ����
        if (pageNumStr != null && !"".equals(pageNumStr.trim())) {
            pageNum = Integer.parseInt(pageNumStr);
        }

        int pageSize = 5; // Ĭ��ÿҳ��ʾ��������¼
        String pageSizeStr = request.getParameter("pageSize");
        if (pageSizeStr != null && !"".equals(pageSizeStr.trim())) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        // ��װģ����ѯ����
        Commodities searchModel = new Commodities();
        searchModel.setTradename(proName);
        System.out.println("==============Product����==============");
        System.out.println(searchModel);
        // ����service ��ȡ��ѯ���
        Pager<Commodities> result = commoditiesService.findByPage2(searchModel, pageNum, pageSize);
        
        // ��pageBean����ֵջ����ǰ��ҳ���ȡ        
        ActionContext.getContext().getValueStack().push(result);
        // ����ѯ����Ҳѹ��ֵջ���ڳ�ʼ��������Ϊ���ʼ��
        ActionContext.getContext().getValueStack().push(searchModel);
        System.out.println("==============Pager����==============");
        System.out.println(result);
        System.out.println("�������������");
        return "findAll";
    }

    public void getALL(){
		// ��Ӳ�Ʒ��Ϣ
    	System.out.print(this.getid());
    	System.out.print(this.getname());
    }
    
    public void getID(){
		// ��Ӳ�Ʒ��Ϣ
    	System.out.print(this.getid());
    }
}

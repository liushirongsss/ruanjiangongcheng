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
		//创建产品对象
		Commodities product = new Commodities();
		// 添加产品信息
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
		//查找对象并修改信息
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

		//保存修改后信息
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
	
	//返回前端的JSON字符串，需要提供get/set方法
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
        System.out.println("控制器方法启动");
        // 使用struts2的servlet接口，接收request里的参数
        // 商品名字参数
        HttpServletRequest request = ServletActionContext.getRequest();
        String proName = request.getParameter("proName");

        // 校验pageNum参数输入合法性
        String pageNumStr = request.getParameter("pageNum");
        System.out.println("前端给的pageNum是："+pageNumStr);

        int pageNum = 1; // 默认显示第几页数据
        if (pageNumStr != null && !"".equals(pageNumStr.trim())) {
            pageNum = Integer.parseInt(pageNumStr);
        }

        int pageSize = 5; // 默认每页显示多少条记录
        String pageSizeStr = request.getParameter("pageSize");
        if (pageSizeStr != null && !"".equals(pageSizeStr.trim())) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        // 组装模糊查询条件
        Commodities searchModel = new Commodities();
        searchModel.setTradename(proName);
        System.out.println("==============Product对象==============");
        System.out.println(searchModel);
        // 调用service 获取查询结果
        Pager<Commodities> result = commoditiesService.findByPage(searchModel, pageNum, pageSize);
        
        // 将pageBean存入值栈，供前端页面读取        
        ActionContext.getContext().getValueStack().push(result);
        // 将查询条件也压回值栈，在初始化函数中为其初始化
        ActionContext.getContext().getValueStack().push(searchModel);
        System.out.println("==============Pager对象==============");
        System.out.println(result);
        System.out.println("控制器方法完成");
        return "findAll";
    }
    
    public String findAll2() {
        System.out.println("控制器方法启动");
        // 使用struts2的servlet接口，接收request里的参数
        // 商品名字参数
        HttpServletRequest request = ServletActionContext.getRequest();
        String proName = request.getParameter("proName");

        // 校验pageNum参数输入合法性
        String pageNumStr = request.getParameter("pageNum");
        System.out.println("前端给的pageNum是："+pageNumStr);

        int pageNum = 1; // 默认显示第几页数据
        if (pageNumStr != null && !"".equals(pageNumStr.trim())) {
            pageNum = Integer.parseInt(pageNumStr);
        }

        int pageSize = 5; // 默认每页显示多少条记录
        String pageSizeStr = request.getParameter("pageSize");
        if (pageSizeStr != null && !"".equals(pageSizeStr.trim())) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        // 组装模糊查询条件
        Commodities searchModel = new Commodities();
        searchModel.setTradename(proName);
        System.out.println("==============Product对象==============");
        System.out.println(searchModel);
        // 调用service 获取查询结果
        Pager<Commodities> result = commoditiesService.findByPage2(searchModel, pageNum, pageSize);
        
        // 将pageBean存入值栈，供前端页面读取        
        ActionContext.getContext().getValueStack().push(result);
        // 将查询条件也压回值栈，在初始化函数中为其初始化
        ActionContext.getContext().getValueStack().push(searchModel);
        System.out.println("==============Pager对象==============");
        System.out.println(result);
        System.out.println("控制器方法完成");
        return "findAll";
    }

    public void getALL(){
		// 添加产品信息
    	System.out.print(this.getid());
    	System.out.print(this.getname());
    }
    
    public void getID(){
		// 添加产品信息
    	System.out.print(this.getid());
    }
}

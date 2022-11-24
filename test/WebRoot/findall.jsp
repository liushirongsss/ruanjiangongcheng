<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.table1 {
    border: 1px solid #ddd;
    width: 900px;
}
.box a{ padding:0 10px;}
thead {
    background-color: lightblue;
}
.container {
	display: flex;
	flex-direction: row;
}
#proForm {
	margin: 10px;
}
#proForm2 {
	margin: 10px;
}
</style>

</head>


<%
    // 获取请求的上下文
    String context = request.getContextPath();
%>
<link href="${pageContext.request.contextPath}WebRoot/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/WebRoot/js/bootstrap.min.js"></script>
<script type="text/javascript" >
// 点击分页按钮以后触发的动作
function handlePaginationClickup(new_page_index) {
    $("#proForm").attr("action", "productAction4.action?pageNum=" + (new_page_index +1));
    $("#proForm").submit();
    //localStorage.tempz=0;
    return false;
}
function handlePaginationClickdown(new_page_index) {
    $("#proForm").attr("action", "<%=context %>/productAction4.action?pageNum=" + (new_page_index -1));
    $("#proForm").submit();
    //localStorage.tempz=0;
    return false;
}
//初始化函数
$(function(){

    //$("#pro_name").val("${pname}");
    //$("#pro_price").val("${price}");

});

</script>

<script>
   var tempz = 1;
   localStorage.setItem(tempz,0);
   if (localStorage.tempz){
    localStorage.tempz=parseInt(localStorage.tempz)+1;
   }
   else{localStorage.tempz=1;}
   window.onload = function(){
   //alert(parseInt(localStorage.tempz));
    if(parseInt(localStorage.tempz)==1){
    document.getElementById("bottons").click();
    }
   }
</script>

<body >

    <div class="container">
        <form action="<%=context %>/productAction5.action" id="proForm" method="post">
            商品名称 <input type="text" name="proName" id="pro_name" style="width: 120px" > &nbsp; 
        <input type="submit" value="查询">
        </form>
        
        <form action="<%=context %>/productAction4.action" id="proForm2" method="post">
        <input type="submit" value="展示全部商品" id="bottons"> 
        </form>
       
		
    </div>
    <p class="box">
    <a href="<%=request.getContextPath() %>/addproduct.jsp">&gt;&gt;添加商品&lt;&lt;</a>
    <a href="<%=request.getContextPath() %>/login.jsp">&gt;&gt;登出&lt;&lt;</a>    
    </p>
<c:if test="${fn:length(dataList) gt 0 }">
<table border="1px" cellspacing="0px"
                style="border-collapse: collapse">
                <thead>
                    <tr height="30">
                <td align="center">商品编号</td>
                <td align="center">商品名称</td>
                <td align="center">商品重量</td>
                <td align="center">商品类别</td>
                <td align="center">商品数量</td>
                <td align="center">商品进价</td>
                <td align="center">商品售价</td>
                <td align="center">商品品牌</td>
                <td align="center">商品供应商</td>
                <td align="center">操作</td>
                <td align="center">操作2</td>
                    </tr>
                </thead>
                    <c:forEach items="${dataList}" var="p">
                        <tr>
                            <td><c:out value="${p.id }" ></c:out></td>
                            <td><c:out value="${p.tradename }" ></c:out></td>
                            <td><c:out value="${p.weight }" ></c:out></td>
                            <td><c:out value="${p.category }"></c:out></td>
                            <td><c:out value="${p.number }"></c:out></td>
                            <td><c:out value="${p.purchaseprice }"></c:out></td>
                            <td><c:out value="${p.sales }"></c:out></td>
                            <td><c:out value="${p.brand }"></c:out></td>
                            <td><c:out value="${p.supplier }"></c:out></td>
                            <td><a href="<%=request.getContextPath() %>/updateproduct.jsp?idname=${p.id}&trname=${p.tradename}&wename=${p.weight}&caname=${p.category}&nuname=${p.number}&puname=${p.purchaseprice}&saname=${p.sales}&brname=${p.brand}&suname=${p.supplier}">&gt;&gt;修改&lt;&lt;</a></td>
                            <td><a href="<%=request.getContextPath() %>/deleteproduct.jsp?idname=${p.id}">&gt;&gt;删除&lt;&lt;</a></td>
                        </tr>
                    </c:forEach>
            </table>
            <div style="float: right;">
       			共 <font color="red">${totalRecord}</font> 条数据   
  				当前第 <font color="red">${currentPage} - 1</font> 页  
  				共 <font color="red">${totalPage}</font> 页  
         		<c:if test="${currentPage!=1}">
         		<a href="#" onclick="handlePaginationClickdown(${currentPage})">上一页</a>
         		</c:if>
         		<c:if test="${currentPage!=totalPage}">
         		<a href="#" onclick="handlePaginationClickup(${currentPage})">下一页</a>
				</c:if>
          		<label>跳转到</label>
          		<input type="text" name="currentPages" id="currentPages" style="width: 40px;"/>
          		<input type="hidden" name="PageTotal" id="PageTotal" value="">
          		<label>页</label>
          		<input type="button" value="跳转" class="btn btn-success" οnclick="check()"/>
      		</div>
    </c:if>

</body>
</html>
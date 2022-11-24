<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
//...
String param = request.getParameter("idname");
String param2 = request.getParameter("trname");
String param3 = request.getParameter("wename");
String param4 = request.getParameter("caname");
String param5 = request.getParameter("nuname");
String param6 = request.getParameter("puname");
String param7 = request.getParameter("saname");
String param8 = request.getParameter("brname");
String param9 = request.getParameter("suname");
int idtemp = Integer.parseInt(param);
int wetemp = Integer.parseInt(param3);
int nutemp = Integer.parseInt(param5);
int putemp = Integer.parseInt(param6);
int satemp = Integer.parseInt(param7);

//...
%>
<script>
localStorage.tempz=0;
</script>
<html>
	<head>
		<title>updateproduct.jsp</title>
	</head>
	<body>
		<form action="productAction2.action" method="post">
			ID<input type="test2" name="id" value=<%=idtemp%> disable><br>
			Name<input type="test2" name="name" value=<%=param2%>><br>
			Weight<input type="test2" name="weight" value=<%=wetemp%>><br>
			Category<input type="test2" name="category" value=<%=param4%>><br>
			Number<input type="test2" name="number" value=<%=nutemp%>><br>
			Purchase price<input type="test2" name="purchaseprice" value=<%=putemp%>><br>
			Sales<input type="test2" name="sales" value=<%=satemp%>><br>
			Brand<input type="test2" name="brand" value=<%=param8%>><br>
			Supplier<input type="test2" name="supplier" value=<%=param9%>><br>
			<input type="submit" value="修改"/>
			<input type="reset" value="重置"/>
			<a href="<%=request.getContextPath() %>/findall.jsp">返回商品管理</a>
		</form>
	</body>
</html>
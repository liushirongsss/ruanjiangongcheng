<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script>
localStorage.tempz=0;
</script>
<html>
	<head>
		<title>addproduct.jsp</title>
	</head>
	<body>
		<form action="productAction.action" method="post">
			Name<input type="test2" name="name"/><br>
			Weight<input type="test2" name="weight"/><br>
			Category<input type="test2" name="category"/><br>
			Number<input type="test2" name="number"/><br>
			Purchase price<input type="test2" name="purchaseprice"/><br>
			Sales<input type="test2" name="sales"/><br>
			Brand<input type="test2" name="brand"/><br>
			Supplier<input type="test2" name="supplier"/><br>
			<input type="submit" value="添加"/>
			<input type="reset" value="重置"/>
			<a href="<%=request.getContextPath() %>/findall.jsp">返回商品管理</a>
		</form>
	</body>
</html>
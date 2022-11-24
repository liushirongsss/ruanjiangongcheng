<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
//...
String param = request.getParameter("idname");//param就是取到的传递过来的内容，试试吧
int idtemp = Integer.parseInt(param);
//...
%>
<script>
localStorage.tempz=0;
</script>
<html>
	<head>
		<title>deleteproduct.jsp</title>
		<style>
        * {
            margin: 0;
            padding: 0;
        }
        html {
            height: 100%;
        }
        body {
            height: 100%;
        }
        .container {
            height: 100%;
            background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
        }
        .login-wrapper {
            background-color: #fff;
            width: 358px;
            height: 588px;
            border-radius: 15px;
            padding: 0 50px;
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
        }
        .header {
            font-size: 38px;
            font-weight: bold;
            text-align: center;
            line-height: 200px;
        }
        .input-item {
            display: block;
            width: 100%;
            margin-bottom: 20px;
            border: 0;
            padding: 10px;
            border-bottom: 1px solid rgb(128, 125, 125);
            font-size: 15px;
            outline: none;
        }
        .input-item:placeholder {
            text-transform: uppercase;
        }
        .btn {
            text-align: center;
            padding: 10px;
            width: 100%;
            margin-top: 40px;
            background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
            color: #fff;
        }
        .msg {
            text-align: center;
            line-height: 88px;
        }
        a {
            text-decoration-line: none;
            color: #abc1ee;
        }
    </style>
	</head>
	<body>
		<div class="container">
        <div class="login-wrapper">
            <div class="header">Delete</div>
            <div class="form-wrapper">
                <form action="productAction3.action" method="post">
                	确定要删除ID<%out.println(idtemp); %>的商品吗？
                	<input type="submit" value="删除" class="btn"/>
				</form>
            </div>
            <div class="msg">
                <a href="<%=request.getContextPath() %>/findall.jsp">不，返回商品管理</a>>
            </div>
        </div>
    </div>
    
 <script>
document.write=param;
</script>
	</body>
</html>
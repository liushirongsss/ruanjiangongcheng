<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
            height: 488px;
            border-radius: 15px;
            padding: 0 50px;            
            top:50%;
            left:50%;
			transform: translate(-50%, -50%);      
			position:absolute;
        }
        .form-wrapper{
            top:60%;
            left:50%;
			transform: translate(-50%, -50%);    
			position:absolute;
        }
        .header {
            font-size: 38px;
            font-weight: bold;
            text-align: center;
            line-height: 240px;
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
            <div class="header">ERROR!</div>
            <div class="form-wrapper">
                	<a href="<%=request.getContextPath() %>/login.jsp">
                	 <font color="#A67D3D" size=8 face= "黑体" class="btn">返回登录</font>
                	</a>
            </div>
        </div>
    </div>
</body>
</html>
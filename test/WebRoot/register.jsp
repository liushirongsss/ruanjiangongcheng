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
            background-image: linear-gradient(to right,  #a6c1ee ,#fbc2eb);
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
            line-height: 150px;
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
            background-image: linear-gradient(to right,  #fbc2eb ,#a6c1ee);
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
            <div class="header">Register</div>
            <div class="form-wrapper">
                <form action="registerAction.action" method="post">
					<input type="test2" name="name" placeholder="username" class="input-item">
                	<input type="test2" name="password" placeholder="password" class="input-item">
                	<input type="test2" name="phone" placeholder="phone" class="input-item">
                	<input type="test2" name="address" placeholder="address" class="input-item">
                	<input type="test2" name="emailid" placeholder="emailid" class="input-item">
                	<input type="submit" value="提交" class="btn"/>
				</form>
            </div>
            <div class="msg">
                Return Login?
                <a href="<%=request.getContextPath() %>/login.jsp">Sign up</a>
            </div>
        </div>
    </div>
</body>
</html>
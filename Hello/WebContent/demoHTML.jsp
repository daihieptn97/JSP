<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<form class="login" action="Demo" method="post">
	  <div class="form-group">
	    <input type="text" class="user" name="user" placeholder="type your user name">
	    <input type="password" class="pwd" name="password" placeholder="type your password">
	  </div>
	  <span class="links">
	    <a href="#">signup</a>
	    <a href="#">forgot password ?</a>
	  </span>
	  <br/>
	  <input type="button" class="btn" id="sb" value="login">     
</form>
<script  src="<%=request.getContextPath()%>/js/login.js"></script>
</body>
</html>



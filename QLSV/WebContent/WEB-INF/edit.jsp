<%@page import="Ultils.Sinhvien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea,  input[type=number] {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit], input[type=button] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover, input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  width : 1000px;
  margin : auto;
}
h3 {
	text-align: center;
	text-transform: uppercase;
}
</style>
</head>
<body >

<% Sinhvien sinhvien = (Sinhvien)request.getAttribute("data"); %>

<div class="container">
<h3 >Edit Form</h3>
  <form method="POST">
  <input type="hidden" id="fname" name="id" placeholder="Your msv" value="<%= sinhvien.getId()  %>">
    <label for="fname">Mã sinh viên</label>
    <input type="text" id="fname" name="msv" placeholder="Your msv" value="<%= sinhvien.getMsv()  %>">

    <label for="lname">Tên </label>
    <input type="text" id="lname" name="ten" placeholder="Your name.." value="<%= sinhvien.getTen() %>">


    <label for="subject">Tuổi</label>
    <input type="number" id="lname" name="tuoi" placeholder="0" min=18 max=40 value="<%= sinhvien.getTuoi()  %>">

    <input type="submit" value="Sửa">
    <a href="Home">
    	 <input type="button" value="Back">
    </a>
  </form>
</div>

</body>
</html>

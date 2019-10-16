<%@page import="Ultils.Sinhvien"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 1000px;
	margin: auto;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}

h1 {
	text-align: center;
	text-transform: uppercase;
}

.tag-a {
	text-align: right;
	width: 1000px;
	margin: auto;
}

.tag-a a {
	text-decoration: none;
	color: green;
}
</style>

</head>


<body>
	<table id="customers">
		<h1>danh sach sinh vien</h1>
		<div class="tag-a">
			<a href="./Add">Thêm sinh viên</a>
		</div>
		<tr>
			<th>ID</th>
			<th>ten</th>
			<th>tuoi</th>
			<th>ma sinh vien</th>
			<th></th>
			<th></th>
		</tr>

		<%
			List<Sinhvien> listsv = (List<Sinhvien>) request.getAttribute("list");
			for (int i = 0; i < listsv.size(); i++) {
		%>
		<tr>
			<td><%=listsv.get(i).getId()%></td>
			<td><%=listsv.get(i).getTen()%></td>
			<td><%=listsv.get(i).getTuoi()%></td>
			<td><%=listsv.get(i).getMsv()%></td>
			<td><a href="?action=delete&id=<%=listsv.get(i).getId()%>">delete</a>
			<td><a href="?action=edit&id=<%=listsv.get(i).getId()%>">edit</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>


</body>
</html>
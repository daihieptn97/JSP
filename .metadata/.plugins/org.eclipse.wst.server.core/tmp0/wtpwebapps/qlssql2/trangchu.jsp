
<%@page import="Ultils.Sach"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello</h1>

	<table>
		<tr>
			<th>ID</th>
			<th>Ten</th>
			<th>Gia</th>
		</tr>
		<%
			List<Sach> list = (List<Sach>) request.getAttribute("list");
			for (int i = 0; i < list.size(); i++) {
		%>
			<tr>
				<td><%= list.get(i).getId() %></td>
				<td><%= list.get(i).getTen() %></td>
				<td><%= list.get(i).getGia() %></td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>
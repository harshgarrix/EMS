<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" import="com.DBConnection.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>welcome</h1>
<%
int pid=Integer.parseInt(request.getParameter("pid"));
String pname = request.getParameter("pname");
int price=Integer.parseInt(request.getParameter("price"));
DbConfig d = new DbConfig();
Connection con = d.getCon();
PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?)");
ps.setInt(1,pid);
ps.setString(2, pname);
ps.setInt(3,price);
ps.executeUpdate();
response.sendRedirect("AddProduct.html");
 %>
<table border=1>
<tr>
<td><%out.println(request.getParameter("pid")); %></td>
</tr>
<tr>
<td><%out.println(request.getParameter("pname")); %></td>
</tr>
<tr>
<td><%out.println(request.getParameter("price")); %></td>
</tr>
</table>

</body>
</html>
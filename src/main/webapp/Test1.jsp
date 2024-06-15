<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//scripted tag
int y=10;
if(y==10)
	out.println(y);
%>

<!-- expression tag -->
<%="hello" %>
<%=10+20+30 %>

<%!
//declaration tag
int a,b;
%>
</body>
</html>
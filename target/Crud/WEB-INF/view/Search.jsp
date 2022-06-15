<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<td>First_name</td>
<td>Last_name</td>
<td>Mobileno</td>
<td>City</td>
<td>Pincode</td>
<td>action</td>
<td>action</td>
</tr>	
<c:forEach var ="i" items = "${list}">
<tr>
<td>${i.firstname}</td>
<td>${i.lastname}</td>
<td>${i.mobileno}</td>
<td>${i.city}</td>
<td>${i.pincode}</td>
<td><a href="/delete?id=${i.id}">delete</a></td>
<td><a href="/edit?id=${i.id}">update</a></td>
</tr>
</c:forEach>
</table>
<a href="/insert">insert</a>
</body>
</html>
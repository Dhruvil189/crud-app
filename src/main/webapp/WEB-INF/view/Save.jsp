<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  action="/view" method="post">
firstname: <input type="text" name="firstname" id="firstname" value="${student.firstname}" maxlength="10"  />
		<br />
lastname: <input type="text" name="lastname" id="lastname" value="${student.lastname}" maxlength="10" />
		<br />

		<br />
mobileno: <input type="text" name="mobileno" id="mobileno" value="${student.mobileno}"/>
		<br />
city: <input type="text" name="city" maxlength="10" id="city" value="${student.city}"  />
		<br />
pincode: <input type="text" name="pincode" maxlength="6" id="pincode" value="${student.pincode}" />
		<br />
		<input type="hidden" name="id" id="id" value="${student.id}"/>
		
		<input type="submit" value="submit" >
</form>
</body>
</html>
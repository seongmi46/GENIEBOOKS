<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%
	System.out.println("dd" + request.getAttribute("alertMessage"));
	String alert = (String)request.getAttribute("alert");
	String path = (String)request.getAttribute("path");
	System.out.println("ss" + path);
	System.out.println("alert : " + alert);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	alert("${requestScope.alert}");
	location.href = "${requestScope.path}";
		

	//document.location.href = "${requestScope.path}";
</script>
</head>
<body>
dfdsfsdf
</body>
</html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Airplane</title>
</head>
<body>
	<h1> welcome</h1>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<a href="${contextPath}/user/login" >login</a> &nbsp;&nbsp;&nbsp;&nbsp;

</body>
</html>
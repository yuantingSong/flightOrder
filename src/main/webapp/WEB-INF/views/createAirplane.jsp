<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>createAirplane</title>
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<a href="${contextPath}/airplane/showAirplanes" >back</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<h1>create Airplane </h1>
	    <form action="${contextPath}/airplane/createAirplane" method="POST">
		 name:<br>
		  <input type="text" name="name" value="">
		  <br>
		  seatNumber:<br>
		  <input type="text" name="seatNumber" value="">
		  <br><br>
		  <input type="submit" value="Submit">
		</form> 
<%
		HttpSession sess = request.getSession();
		String message = (String)sess.getAttribute("mes");
	if(message == ""){
		%>
		<%
	}else{
		%>
			 <script type="text/javascript">
					alert("<%=message %>");
			 </script>
		<%
		sess.setAttribute("mes", "");
	}
 %>


</body>
</html>
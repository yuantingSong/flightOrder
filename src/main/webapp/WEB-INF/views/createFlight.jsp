<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>createFlight</title>
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<a href="${contextPath}/airplane/showAirplanes" >back</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<h1>create Flight of Id No.${airplaneId}  </h1>
	    <form action="${contextPath}/flight/createFlight" method="POST">
		 from:<br>
		  <input type="text" name="from" value="">
		  <br>
		  to:<br>
		  <input type="text" name="to" value="">
		  <br>
		  		 departureTime:<br>
		  <input type="text" name="departureTime" value="">
		  <br>
		  		 arrivalTime:<br>
		  <input type="text" name="arrivalTime" value="">
		  <br>
		  <br>
		  	<input type="submit" value="Submit">
		  	<input type="hidden" name="airplaneId"  value="${airplaneId}">
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
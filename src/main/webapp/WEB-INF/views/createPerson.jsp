<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>createPerson</title>
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<a href="${contextPath}/person/showPersons" >back</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<h1>create User Person No.${user.userId}  </h1>
	    <form action="${contextPath}/person/createPerson" method="POST">
		 firstname:<br>
		  <input type="text" name="firstname" value="">
		  <br>
		  lastname:<br>
		  <input type="text" name="lastname" value="">
		  <br>
		  		 birthday:<br>
		  <input type="text" name="birthday" value="">
		  <br>
		  		 age:<br>
		  <input type="text" name="age" value="">
		  <br>
		  		  <br>
		  		 email:<br>
		  <input type="text" name="email" value="">
		  <br>
		  <br>
		  	<input type="submit" value="Submit">
		  	<input type="hidden" name="userId"  value="${user.userId}">
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
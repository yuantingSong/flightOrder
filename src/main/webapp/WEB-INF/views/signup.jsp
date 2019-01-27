<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
</head>
<body>
	<h1>Sign up</h1>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	    <form action="${contextPath}/user/signup" method="POST">
		 name:<br>
		  <input type="text" name="name" value="Name">
		  <br>
		  password:<br>
		  <input type="text" name="password" value="Passord">
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
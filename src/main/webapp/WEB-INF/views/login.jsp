<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginPage</title>
</head>
<body>
	<h1> Login </h1>
	
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<FORM action="${contextPath}/user/login" METHOD="POST">
		<TABLE>
				<TR>
					<TD>Username: <INPUT TYPE="TEXT" NAME="name"> <TR>
					<TD>Password: <INPUT TYPE="PASSWORD" NAME="password"> <TR>
					<TH>
					<INPUT TYPE="SUBMIT" VALUE="login">
				<tr>
					<td> <input type="checkbox" name="rememberMe" value="remember" /> Remember me  <br/><br/>
					</td>
				</tr>
		</TABLE>
	</FORM>
    <form method="get" action="${contextPath}/user/signup">
   		<button type="submit">SignUp</button>
	</form>
	
</body>
</html>
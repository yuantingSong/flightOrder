<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>showPersons</title>
</head>
<body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<a href="${contextPath}/person/" >back to order</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<h1>The person info</h1> 
	</form>
    <form method="post" action="${contextPath}/person/createPerson.htm">
    	<input type="hidden" name="flightId"  value="${flightId}">
		<input type="submit" value="create " />
	</form>
	
<div id="coursediv">
<table border="1" cellpadding="5" cellspacing="5">
		<tr>
			<td><b>PersonId</b></td>
			<td><b>first name</b></td>
			<td><b>last name</b></td> 
			<td><b>birthday</b></td>
			<td><b>age</b></td>		 
			<td><b>email</b></td>		
			<td colspan="3"><b>OPERATION</b></td>
		</tr>
		
		<c:forEach var="person" items="${persons}">
			<tr>
				<td>${person.personId}</td>
				<td>${person.firstname}</td>
				<td>${person.lastname}</td>
				<td>${person.birthday}</td>
				<td>${person.age}</td>  
				<td>${person.email}</td> 
	             <td >
                 <form action="${contextPath}/person/change" method="post">
                 
                <input type="hidden" name="flightId"  value="${flightId}">
                 <input type="submit" value="change" /> 
                </form></td>
                <td>
                <form action="${contextPath}/person/remove" method="post"> 
                
                <input type="hidden" name="flightId"  value="${flightId}">
                <input type="submit" value="remove" />
                </form></td>
                 <td>
                <form action="${contextPath}/person/order" method="post"> 
                <input type="hidden" name="flightId"  value="${flightId}">
                
                <input type="hidden" name="personId"  value="${person.personId}">
                <input type="submit" value="order" />
                
                </form></td>
			</tr>
			
		</c:forEach>
	</table>
	
		
</body>
</html>
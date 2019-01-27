<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flights</title>
</head>
<body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" /> 
	
<div id="coursediv">
<table border="1" cellpadding="5" cellspacing="5">
		<tr>
			<td><b>FLight Id</b></td>
			<td><b>from</b></td>
			<td><b>to</b></td> 
			<td><b>departureTime</b></td>
			<td><b>arrivalTime</b></td>			
			<td colspan="1"><b>OPERATION</b></td>
		</tr>
		
		<c:forEach var="flight" items="${flights}">
			<tr>
				<td>${flight.flightId}</td>
				<td>${flight.fromTime}</td>
				<td>${flight.toTime}</td>
				<td>${flight.departureTime}</td>
				<td>${flight.arrivalTime}</td> 

	             <td >
                 <form action="${contextPath}/flight/orderFlight" method="post">
                 <input type="submit" value="order" />
                <input type="hidden" name="flightId"  value="${flight.flightId}" >
                </form></td> 
			</tr>
			
		</c:forEach>
	</table>
	
		
</body>
</html>
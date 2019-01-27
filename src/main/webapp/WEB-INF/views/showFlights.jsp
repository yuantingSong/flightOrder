<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>showFlights</title>
</head>
<body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<a href="${contextPath}/airplane/showAirplanes" >back</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<h1>Airplane :  ${airplane.name}</h1>
	<h1>seat :  ${airplane.seatNum}</h1>
	</form>
	
    <form method="post" action="${contextPath}/flight/createFlight.htm">
		<input type="submit" value="create Flight" />
		<input type="hidden" name="airplaneId"  value="${airplane.airplaneId}" >
	</form>
	
<div id="coursediv">
<table border="1" cellpadding="5" cellspacing="5">
		<tr>
			<td><b>FLight Id</b></td>
			<td><b>from</b></td>
			<td><b>to</b></td> 
			<td><b>departureTime</b></td>
			<td><b>arrivalTime</b></td>			
			<td colspan="2"><b>OPERATION</b></td>
		</tr>
		
		<c:forEach var="flight" items="${flights}">
			<tr>
				<td>${flight.flightId}</td>
				<td>${flight.fromTime}</td>
				<td>${flight.toTime}</td>
				<td>${flight.departureTime}</td>
				<td>${flight.arrivalTime}</td> 

	             <td >
                 <form action="${contextPath}/flight/change" method="post">
                 <input type="submit" value="change" />
                <input type="hidden" name="airplaneId"  value="${flight.flightId}" >
                </form></td>
                <td>
                <form action="${contextPath}/flight/remove" method="get">
                <input type="hidden" name="flightId"  value="${flight.flightId}">
                <input type="submit" value="remove" />
                </form></td>
			</tr>
			
		</c:forEach>
	</table>
	
		
</body>
</html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>showAirplanes</title>
</head>
<body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<a href="${contextPath}" >Logout</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<h1>Hi,Welcome</h1> 
    <form method="get" action="${contextPath}/airplane/createAirplane.htm">
   		<button type="submit">create Airplane</button>
	</form>
	<a href="${contextPath}/airplane/createAirplane.htm" >Delete Airplane</a>&nbsp;&nbsp;&nbsp;&nbsp;
	
<div id="coursediv">
<table border="1" cellpadding="5" cellspacing="5">
		<tr>
		<td><b>Airplane Id</b></td>
			<td><b>Name</b></td>
			<td><b>Seat Number</b></td>
			<td colspan="2"><b>OPERATION</b></td>
		</tr>
		
		<c:forEach var="airplane" items="${airplanes}">
			<tr>
				<td>${airplane.airplaneId}</td>
				<td>${airplane.name}</td>
				<td>${airplane.seatNum}</td>

	             <td >
                 <form action="${contextPath}/airplane/showFlights" method="post">
                 <input type="submit" value="Flights" />
                <input type="hidden" name="airplaneId"  value="${airplane.airplaneId}" >
                </form></td>
                <td>
                <form action="${contextPath}/airplane/deleteAirplane" method="post">
                <input type="hidden" name="airplaneId"  value="${airplane.airplaneId}">
                <input type="submit" value="Delete" />
                </form></td>
			</tr>
			
		</c:forEach>
	</table>
	<form action="${contextPath}/airplane/getpage" method="post">
	<c:forEach begin="1" end="${airplanes.size()/5+1}" var="pagenum">
                 <input type="radio" name="page" value="${pageScope.pagenum}">${pageScope.pagenum} &nbsp;
                 
             </c:forEach>
             <br>
              <input type="hidden" name="action" value="display"/>
         <input type="submit" value="display"/>
         
          </form>
             
	
	
	</div>
		
</body>
</html>
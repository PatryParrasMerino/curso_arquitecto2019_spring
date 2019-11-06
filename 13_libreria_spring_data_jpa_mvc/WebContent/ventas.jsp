<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	%>

<html>
<head>
<title>libros</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
 <c:set var="ventas" value="${requestScope.ventas}"/>   
<c:choose>
	<c:when test="${!empty ventas}">

		<table border="1">
		    <tr><th>Titulo</th><th>Fecha</th><th>Precio</th></tr>		    	
		    	<c:forEach var="vt" items="${ventas}">
		    		<tr>
		    			<td>${vt.libro.titulo}</td>
						<td>${vt.fecha}</td>
						<td>${vt.libro.precio}</td>
					</tr>		    	
		    	</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h2>No hay compras para ${sessionScope.cliente.usuario}</h2>
	</c:otherwise>
</c:choose>
<br/><br/>
<a href="toMenu">Menú</a>
</body>
</html>
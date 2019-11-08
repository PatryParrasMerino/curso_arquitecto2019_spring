<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
<h1>Saldo actual:${requestScope.saldo}</h1>
	<table class="table table-striped table-bordered">
		<thead><tr><th>Cantidad</th><th>Operación</th><th>Fecha</th></tr></thead>
		<tbody>
		
		<c:forEach var="m" items="${requestScope.movimientos}" >
			<tr>
				<td>${m.cantidad}</td>
				<td>${m.operacion}</td>
				<td>${m.fecha}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<br/><br/>
	<a href="toOperaciones">Volver</a>
</div>

</body>
</html>
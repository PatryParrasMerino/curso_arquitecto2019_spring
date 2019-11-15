<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>	
<div class="container">
	<h1>Creación de cuenta</h1>
	<f:form action="nuevaCuenta" method="post" modelAttribute="cuenta">
		<div class="form-group">
			<label>Número de cuenta:</label><f:input path="numeroCuenta" class="form-control" style="width:30%"/>
		</div>
		<div class="form-group">
			<label>Saldo:</label><f:input path="saldo" class="form-control" style="width:30%"/>
		</div>
		<div class="form-group">
			<label>Tipo de cuenta:</label><f:input path="tipocuenta" class="form-control" style="width:30%"/>
		</div>
		<div class="form-group">	
			<label>Cliente asociado(dni):</label>		
			<f:select path="dni" class="form-control" style="width:20%">
				<f:option value="0" label="-Seleccionar-"/>
				<f:options items="${clientes}" itemValue="dni" itemLabel="nombre" />
			</f:select>					
		</div>	
		<button type="submit" class="btn btn-default">Confirmar</button><br/>	
	</f:form>
	<div class="form-group">
		<a href="aAdministracion">Volver</a><br/>
	</div>
</div>		
</body>
</html>
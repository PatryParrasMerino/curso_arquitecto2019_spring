<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
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
	<h1>Menu de Usuario</h1>
	<form>
		<h2>Cuenta:${sessionScope.cuentaAutenticada.numeroCuenta}</h1>
		<h5>(Saldo:${sessionScope.cuentaAutenticada.saldo})</h5><br/>
		<h3>Operaciones</h1>		
		<div class="form-group">					
			<a href="aIngreso">Realizar ingreso</a><br/>
			<a href="aExtraccion">Realizar extracción</a><br/>
			<a href="aTransferencia">Realizar transferencia</a><br/>
			<a href="aCambioDeCuenta?cuenta=${cuentaCambiada}">Cambiar a cuenta:</a><input type="text" id="cuentaCambiada" class="form-control" style="width:10%" />	
		</div>	
		<br/><br/>
		<div class="form-group">
			<a href="aMenu">Salir</a>
		</div>	
	</form>			
</div>
</body>
</html>
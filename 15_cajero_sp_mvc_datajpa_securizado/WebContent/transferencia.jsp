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
	<h1>Cuenta:${sessionScope.cuentaAutenticada.numeroCuenta}</h1>
	<h5>(Saldo:${sessionScope.cuentaAutenticada.saldo})</h5><br/>
	<h1>Transferencia</h1>	
	<form action="transferencia" method="post">
		<div class="form-group">
			<label>Cuenta Destino:</label><input type="text" name="cuentaDestino" class="form-control" style="width:30%"/>
		</div>
		<div class="form-group">
			<label>Cantidad:</label><input type="text" name="cantidad" class="form-control" style="width:30%" />
		</div><br/>		
		<button type="submit" class="btn btn-default">Enviar</button>		
	</form>
</div>
</body>
</html>
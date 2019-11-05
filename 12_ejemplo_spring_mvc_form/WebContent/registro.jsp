<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
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
	<h1>Registro de usuarios</h1>
	<f:form action="registrar" method="post" modelAttribute="cliente">
		<div class="form-group">
			<label>Usuario:</label><f:input path="usuario" class="form-control" style="width:30%" placeholder="Usuario" autocomplete="name"/>
		</div>
		<div class="form-group">
			<label>Password:</label><f:password path="password" class="form-control" style="width:30%" placeholder="Contraseña"/>
		</div>
		<div class="form-group">
			<label>Email:</label><f:input path="email" class="form-control" style="width:30%" placeholder="Email" autocomplete="name"/>
		</div>
		<div class="form-group">
			<label>Teléfono:</label><f:input path="telefono" class="form-control" style="width:30%" placeholder="Teléfono"/>
		</div>
		<button type="submit" class="btn btn-default">Registrar</button>		
	</f:form>
</div>
</body>
</html>
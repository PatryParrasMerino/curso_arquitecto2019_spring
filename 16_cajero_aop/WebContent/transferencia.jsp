<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h1>Transferencia</h1>
  <br/>
  <form action="doTransferencia" method="post">
    <div class="input-group">
  	 	<span class="input-group-addon">Cantidad:</span>
    	<input id="cantidad" type="text" class="form-control" name="cantidad" placeholder="cantidad" required="required">
	</div>
	<br/><br/>
	<div class="input-group">
  	 	<span class="input-group-addon">Cuenta destino:</span>
    	<input id="email" type="text" class="form-control" name="destino" placeholder="cuenta" required="required">
	</div>
  	<br/>
    <button type="submit" class="btn btn-default btn-primary" style="width:100%">Transferir</button>
    
  </form>
  <br/><br/>
  <a href="toOperaciones">Volver</a>
</div>

</body>
</html>
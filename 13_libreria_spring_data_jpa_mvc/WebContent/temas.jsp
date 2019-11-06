<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	
	pageEncoding="ISO-8859-1" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>seleccion</title>
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1" >
</head>
<body>

	<center>
            <h1>Seleccione Tema</h1>
            <br/><br/>
		<form  action="libros" method="post">
			<select name="tema">
				<option value="0">Todos</option>
				<c:forEach var="t" items="${requestScope.temas}">
					<option value="${t.idTema}">${t.tema}</option>				
				</c:forEach>
				
			</select>
			<br/><br/>
			<input type="submit" value="Ver libros"/>
			
		</form>
		<br/><br/>
		<c:set var="libros" value="${requestScope.libros}"/>   
		<c:choose>
			<c:when test="${!empty libros}">
		
				<table border="1">
				    <tr><th>Titulo</th><th>Autor</th><th>Precio</th></tr>		    	
				    	<c:forEach var="lib" items="${libros}">
				    		<tr>
				    			<td>${lib.titulo}</td>
								<td>${lib.autor}</td>
								<td>${lib.precio}</td>
								
							</tr>		    	
				    	</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h2>No hay libros</h2>
			</c:otherwise>
		</c:choose>
		<br/><br/>
		<a href="toMenu">Volver</a>
	
	</center>

</body>
</html>
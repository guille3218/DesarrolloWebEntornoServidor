<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
<% if (!session.isNew() && session.getAttribute("registrado")!=null && ((boolean)session.getAttribute("registrado")) ) { %>
<jsp:include page="barra.jsp"></jsp:include>
<img alt="Imagen Bienvenida" src="./img.png">
<% } else { %>
	<h1>CENTRAL DE VIAJES</h1>
	
	<form method="post" action="MainServlet">
		<label class="form-label" for="user">Usuario:</label>
		<input class="form-control" type="text" name="user" required>
		<label class="form-label" for="password">Password:</label>
		<input class="form-control" type="password" name="password" required>
		<label class="form-label" for="passwdConfirm">Confirmar Password:</label>
		<input class="form-control" type="password" name="passwdConfirm" required>
		<label class="form-label" for="email">Email:</label>
		<input class="form-control" type="email" name="email" required>	
		<input class="btn btn-primary" type="submit" name="registro" value="REGISTRARSE">
	
	</form>
	<%} %>
</body>
</html>
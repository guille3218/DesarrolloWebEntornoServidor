<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserva</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="barra.jsp"></jsp:include>

	<h1>DATOS DE LA RESERVA</h1>

	<form method="post" action="ReservarServlet">
		<label class="form-label" for="start">Fecha de Inicio</label>
		<input class="form-control" type="date" name="start" required>
		<label class="form-label" for="end">Fecha de Fin</label>
		<input class="form-control" type="date" name="end" required>
		<label class="form-label" for="personas">Número de Personas</label>
		<input class="form-comtrol" type="text" name="personas"><br>
		<label class="form-label" for="servicios"><h3>Servicios</h3></label><br>
		<input type="checkbox" value="Wifi" name="servicios">Wifi
		<input type="checkbox" value="Limpieza" name="servicios">Limpieza <br>
		<input type="checkbox" value="Toallas" name="servicios">Toallas 
		<input type="checkbox" value="Ruta Guiada" name="servicios">Ruta Guiada <br>
		<input type="checkbox" value="Desayuno" name="servicios">Desayuno
		<input type="checkbox" value="Sauna" name="servicios">Sauna<br>
		
		<input class="btn btn-primary" type="submit" name="reservar" value="RESERVAR">
		
	</form>
</body>
</html>
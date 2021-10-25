<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmar</title>
</head>
<body>
	<jsp:useBean id="reservaBean" class="org.iesalixar.servidor.model.Reserva" scope="request"></jsp:useBean>
	<h1>Reserva Confirmada</h1>
	<p>FECHA DE INICIO: <%= out.println(reservaBean.getFechaInicio()) %></p>
	<p>FECHA FINALIZACIÓN: <%= out.println(reservaBean.getFechaFin()) %></p>
	<p>NÚMERO DE PERSONAS: <%= out.println(reservaBean.getPersonas()) %></p>
	<p>SERVICIOS RESERVADOS:</p>
	<ul>
		<% String[] servicios = (String[]) reservaBean.getServicios();
			if(servicios.length==0){
		%>
			<li>No hay ningun servicio seleccionado.</li>
		
		<% }else{
			for(String s : servicios){%>
				<li><%= out.println(s) %></li>
				<%}
			} %>
	</ul>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmar</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="barra.jsp"></jsp:include>
	<jsp:useBean id="reservaBean" class="org.iesalixar.servidor.model.Reserva" scope="request"></jsp:useBean>
	<h1>Reserva Confirmada</h1>
	<p>FECHA DE INICIO: <%= reservaBean.getFechaInicio() %></p>
	<p>FECHA FINALIZACIÓN: <%= reservaBean.getFechaFin() %></p>
	<p>NÚMERO DE PERSONAS: <%= Integer.toString(reservaBean.getPersonas()) %></p>
	<p>SERVICIOS RESERVADOS:</p>
	<ul>
		<% String[] servicios = (String[]) reservaBean.getServicios();
			if(servicios.length==0){
		%>
			<li>No hay ningun servicio seleccionado.</li>
		
		<% }else{
			for(String s : servicios){%>
				<li><%= s %></li>
				<%}
			} %>
	</ul>
</body>
</html>
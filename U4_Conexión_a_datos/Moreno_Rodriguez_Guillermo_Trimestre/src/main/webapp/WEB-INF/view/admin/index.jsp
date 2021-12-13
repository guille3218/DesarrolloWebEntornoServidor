<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/bootstrap.jsp" />
<title>Inicio</title>
</head>
<body>
	<jsp:include page="../include/barra.jsp" />

	<h1>Operaciones disponibles</h1>

	<ul>
		<li><a href="${pageContext.request.contextPath}/Admin/Empleados">Mostrar Empleados</a></li>
		<li><a href="${pageContext.request.contextPath}/Admin/AddEmpleado">Añadir Empleados</a></li>
	</ul>
</body>
</html>
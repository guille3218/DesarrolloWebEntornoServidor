<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/bootstrap.jsp" />
<title>Empleados</title>
</head>
<body>
<jsp:include page="../include/barra.jsp" />
<div class="container">
	<a class="btn btn-primary w-25 mt-3" href="${pageContext.request.contextPath}/Admin/AddEmpleado">Añadir Empleado</a>
		
		<h1 class="text-center">Empleados</h1>
		
		<div class="row justify-content-center">

			<div class="col-10">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Número</th>
							<th>Apellidos</th>
							<th>Nombre</th>
							<th>Puesto</th>
							<th>Oficina</th>
							<th>Jefe</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${employees}" var ="e">
							<tr>
								<td>${e.employeeNumber}</td>
								<td>${e.lastName}</td>
								<td>${e.firstName}</td>
								<td>${e.jobTitle}</td>
								<td>${e.officeCode}</td>
								<td>${e.reportsTo}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/bootstrap.jsp" />
<title>Añadir Empleado</title>
</head>
<body>
		<jsp:include page="../include/barra.jsp" />
	<div class="row justify-content-center mt-5">
		<div class="col-6">
			<form method="post">
					<label for="employeeNumber"  class="form-label  mt-3">Número de Empleado</label>
					<input type="number" class="form-control" id="employeeNumber" name="employeeNumber" required />
					<c:if test="${error!=null}">
							<p class="text-danger text-small mt-3">${error}</p>
						</c:if>
    				<label for="lastName" class="form-label mt-3">Apellidos</label>
    				<input type="text" class="form-control" id="lastName" name="lastName" required >
    				<label for="name" class="form-label mt-3">Nombre</label>
    				<input type="text" class="form-control" id="name" name="name" required >			
    				<label for="extension" class="form-label mt-3">Extension</label>
    				<input type="text" class="form-control" id="extension" name="extension" required >
    				<label for="email" class="form-label mt-3">Email</label>
    				<input type="email" class="form-control" id="email" name="email" required >
    				<label for="puesto" class="form-label mt-3">Puesto</label>
    				<input type="text" class="form-control" id="puesto" name="puesto" required >
    				
    				<label for="oficina" class="form-label mt-3">Oficina</label>
    				<select class="custom-select" id="oficina" name="oficina">
					<c:forEach items="${offices}" var="o">
					<option value="${o.officeCode}">${o.city}</option>
					</c:forEach>
					</select>
    				
    				<label for="jefe" class="form-label mt-3">Jefe</label>
    				<select class="custom-select" id="jefe" name="jefe">
    				<c:forEach items="${employees}" var="e">
					<option value="${e.employeeNumber}">${e.firstName} ${e.lastName}</option>
					</c:forEach>
    				</select>
     				<input type="submit" class="btn btn-primary w-100 mt-3" value="Añadir Empleado" />
			</form>

		</div>
	</div>
</body>
</html>
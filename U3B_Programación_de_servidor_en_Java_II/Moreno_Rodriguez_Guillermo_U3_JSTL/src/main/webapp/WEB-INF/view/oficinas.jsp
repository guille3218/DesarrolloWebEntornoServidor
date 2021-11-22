<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oficinas</title>
<jsp:include page="include/bootstrap.jsp" />
</head>
<body>
	<jsp:include page="include/barra.jsp" />
	<form method="post">
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">Oficinas</label>
			</div>
			<select class="custom-select" id="city" name="city">
				<option selected>Elige la Ciudad</option>
				<c:forEach items="${offices}" var="o">
					<option value="${o.city}">${o.city}</option>
				</c:forEach>
			</select>
			<input type="submit" class="btn btn-primary w-100 mt-3" value="OBTENER DATOS" />
		</div>
	</form>
	
		<p>DATOS DE LA OFICINA DE ${office.city }</p>
		<p>Code: ${office.officeCode}</p>
		<p>Ciudad: ${office.city }</p>
		<p>Teléfono: ${office.phone}</p>
		<p>Dirección 1: ${office.addressLine1}</p>
		<p>Dirección 1: ${office.addressLine2}</p>
		<p>Estado: ${office.state}</p>
		<p>País: ${office.country}</p>
		<p>Código Postal: ${office.postalCode}</p>
		<p>Territorio: ${office.territory}</p>
</body>
</html>
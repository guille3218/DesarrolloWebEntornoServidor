<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.usuario!=null}">
	<div class="d-flex p-2 bg-primary text-white justify-content-between">
		<div>
			<p>
				<a class="text-white" href="${pageContext.request.contextPath}/Home">Inicio</a>
				<c:if test="${sessionScope.role == 'admin'}">
					<a class="text-white"
						href="${pageContext.request.contextPath}/Admin/Empleados">Mostrar
						Empleados</a>

					<a class="text-white"
						href="${pageContext.request.contextPath}/Admin/AddEmpleado">AÒadir
						Empleados</a>
				</c:if>
		</div>
		<div>
			<p class="text-white">
				ZONA DE
				<c:choose>
					<c:when test="${sessionScope.role == 'admin'}">
						ADMINISTRACIÛN
					</c:when>
					<c:when test="${sessionScope.role != 'admin'}">
						USUARIO
					</c:when>
				</c:choose>
			</p>
		</div>
		<div>
			<a class="text-white"
				href="${pageContext.request.contextPath}/LogOut">Salir</a>
			</p>
		</div>
	</div>
</c:if>
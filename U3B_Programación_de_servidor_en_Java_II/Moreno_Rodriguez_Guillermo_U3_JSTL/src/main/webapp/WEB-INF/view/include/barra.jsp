<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.usuario!=null}">
	<div class="d-flex p-2 bg-primary text-white justify-content-between" >
	<div>
		<p>
		<a class="text-white" href="${pageContext.request.contextPath}/">Inicio</a>
		<a class="text-white" href="${pageContext.request.contextPath}/Oficinas">Buscar Oficinas</a>		
	</div>
		<div>
			<p>Está usted logueado como: <c:out value="${sessionScope.nombre}" /> <c:out value="${sessionScope.apellidos}" />
			
			<a class="text-white" href="${pageContext.request.contextPath}/LogOut">Salir</a></p>
			</div>	
	</div>
</c:if>
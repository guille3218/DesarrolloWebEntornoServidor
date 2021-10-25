
<ul class="nav justify-content-end bg-light">
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="<%= request.getContextPath() %>">Volver</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<%= request.getContextPath()+"/Logout" %>">Salir</a>
  </li>
</ul>
<p style="color:blue">Usuario: <%=session.getAttribute("user") %> Sesión: <%= session.getAttribute("fecha") %> </p>

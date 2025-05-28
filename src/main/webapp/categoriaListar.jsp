<%--
  Created by IntelliJ IDEA.
  User: ESTUDIANTE
  Date: 28/5/2025
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%-- Añadimos las librerías   --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="global.models.* , java.util.*" %>

<%
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
    Optional<String> username = (Optional<String>) request.getAttribute("username");
%>

<html>

<head>
    <title>Listado Categoría</title>
</head>

<body>

<h1>Listado Categoría</h1>
<table>
    <thead>
    <th>Id Categoría</th>
    <th>Nombre</th>
    <th>Descripción</th>
    <th>Condición</th>
    <th>Acciones</th>
    </thead>

    <%
        for (Categoria cat : categorias) {  %>
             <tbody>
                    <td><%=cat.getIdCategoria()%> </td >
                    <td><%=cat.getNombre()%> </td >
                    <td><%=cat.getDescripcion()%> </td >
                    <td><%=cat.getCondicion()%> </td>
                    <td><a href="">Editar</a></td>
                    <td><a href="">Activar o Desactivar</a></td>
            </tbody>
        <% } %>



</table>

</body>

</html>

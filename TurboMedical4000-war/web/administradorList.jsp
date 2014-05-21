<%-- 
    Document   : administradorList
    Created on : 24-abr-2014, 22:01:23
    Author     : Juan
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="ComprobacionesSesion/comprobacionAdministrador.jsp" %>

<%
    List<Administrador> lista;
    
    lista = (List<Administrador>)request.getAttribute("lista");
%>   

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Administrador > Gesti&oacute;n Administradores</title>
    </head>
    <body>
        
        <jsp:include page="OpcionesMenu/aperturaOpcionesAdministrador.jsp" />
                
                    
                    <h1>Gesti&oacute;n de Administradores</h1>
                    <form name="filtarAdmin" action="BusquedaAdministradorServlet" method="post">
                        Usuario<input type="text" maxlength="20" size="20" name="usuario"/>
                        <input type="Submit" value="Buscar" align="right">
                    </form>
                    <a href="EditAdministradoresServlet?do=addForm">A&ntilde;adir nuevo administrador</a><br>
                    <b><a style="color:red"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
                    <%
                        if (!lista.isEmpty()){
                    %>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Usuario</th>                  
                <th>&nbsp;</th>
            </tr>
<%
        for (Administrador usuario: lista) {
%>
            <tr>
                <td><%= usuario.getIdAdministrador() %></td>
                <td><%= usuario.getUsuario() %></td>
                <td><a href="EditAdministradoresServlet?do=editForm&idAdministrador=<%= usuario.getIdAdministrador() %>">Editar</a>
                    <a href="EditAdministradoresServlet?do=delete&idAdministrador=<%= usuario.getIdAdministrador() %>" onclick="return confirm('¿Seguro que desea eliminar\nel usuario <%= usuario.getUsuario()%>?')">Borrar</a></td>
            </tr>

<%            
        }
%>            
       </table>
                    <% }else{ %>
                    <h3>NO HAY ADMINISTRADORES QUE MOSTRAR</h3>
                    <% } %>
                   </td> 
               
            </tr>
        
        <jsp:include page="OpcionesMenu/opcionesAdministrador.jsp" />
        
    </body>
</html>

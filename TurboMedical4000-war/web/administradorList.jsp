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
        
        <%@ include file="OpcionesMenu/aperturaOpcionesComun.jsp" %>
        
             <tr>
                <th> &nbsp; </th> <td rowspan="7" >
                
                    
                    <h1>Gesti&oacute;n de Administradores</h1>
                    <form name="filtarAdmin" action="BusquedaAdministradorServlet" method="post">
                        Usuario<input type="text" maxlength="20" size="20" name="usuario"/>
                        <input type="Submit" value="Buscar" align="right">
                    </form>
                    <a href="EditAdministradoresServlet?do=addForm">A&ntilde;adir nuevo administrador</a><br>
                    <b><a style="color:red"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Usuario</th>                  
                <th>&nbsp;</th>
            </tr>
<%
    if (lista != null)
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
                   </td> 
               
            </tr>
        
        <%@ include file="OpcionesMenu/opcionesAdministrador.jsp" %>
        
    </body>
</html>

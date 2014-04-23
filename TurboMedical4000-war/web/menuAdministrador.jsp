<%-- 
    Document   : menuAdministrador
    Created on : 11-abr-2014, 2:14:26
    Author     : jorge, juan
--%>

<%@page import="turbomedical4000.entity.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Administrador</title>
<% 
    Administrador administrador =(Administrador) request.getAttribute("administrador");
%>
    </head>
    <body>
        <h1>Menú de administrador</h1>
        
        <table width="100%" border="1" cellspacing="0" >
              
            <tr>
                <th> &nbsp; </th> <th rowspan="5" >
                    Usuario: <%= administrador.getUsuario() %> </br>
                </th>
            </tr>
            <tr>
                <td>Perfil</td>
            </tr>
            <tr>
                <td><a href="ListaMedicosServlet">M&eacute;dicos</a></td>
            </tr>
            <tr>
                <td><a href="ListaPacientesServlet">Pacientes</a></td>
            </tr>
            <tr>
                <td><a href="ListaAdministradoresServlet">Administradores</a></td>
            </tr>
            <tr>
                <td>Formularios</td>
            </tr>
        </table>
        </br>
        Cerrar sesi&oacute;n
    </body>
</html>

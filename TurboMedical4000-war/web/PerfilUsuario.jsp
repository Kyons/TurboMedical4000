<%-- 
    Document   : PerfilUsuario
    Created on : 13-abr-2014, 13:25:49
    Author     : Sihame
--%>

<%@page import="turbomedical4000.entity.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Paciente</title>
   <%
  	
	Paciente paciente =(Paciente) session.getAttribute("paciente");
  %>
    </head>
    <body>
     
        <table width="100%" border="1" cellspacing="0" bordercolor="#000000" >
              
            <tr> <th> &nbsp; </th> <td rowspan="4" >
                  <h2>Perfil personal</h2>
            <table border ="1">
                <tr>
                    <th> Nombre</th>
                    <th> Apellidos</th>
                    <th>  N&uacute;mero S.S</th>
                    <th> Fecha nacimiento</th>
                    <th> Direcci&oacute;n</th>
                    <th>  Localidad</th>
                    <th>  Provincia</th>
                    <th> Tel&eacute;fono</th>
                </tr>
                <tr>
                    <td> <%= paciente.getNombre() %></td>
                    <td><%= paciente.getApellidos()%></td>
                    <td> <%= paciente.getNumSS()%></td>
                    <td><%= paciente.getFechaNac() %></td>
                    <td><%= paciente.getDireccion() %></td>
                    <td><%= paciente.getLocalidad() %></td>
                    <td> <%= paciente.getProvincia() %></td>
                    <td><%= paciente.getTelefono() %></td>
                </tr>
            </table>
                </td></tr>
            
            <%@ include file="OpcionesMenu/opcionesPaciente.jsp" %>
    </body>
</html>

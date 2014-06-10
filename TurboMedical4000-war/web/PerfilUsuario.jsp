<%-- 
    Document   : PerfilUsuario
    Created on : 13-abr-2014, 13:25:49
    Author     : Sihame
--%>

<%@page import="turbomedical4000.entity.Cita"%>
<%@page import="turbomedical4000.entity.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="ComprobacionesSesion/comprobacionPaciente.jsp" %>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Paciente</title>
   <%
	//Paciente paciente =(Paciente) session.getAttribute("paciente");
        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
  %>
    </head>
    <body>
     
        <jsp:include page="OpcionesMenu/aperturaOpcionesPaciente.jsp" />
                  <h2>Perfil personal</h2>
                  
            <table border="1">
                <tr><td>
                    <b>Pr&oacute;ximas citas: </b>
<%
        Cita proximaCitaPaciente = (Cita)request.getAttribute("proximaCitaPaciente");
        if(proximaCitaPaciente != null){
            java.text.DateFormat dfFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
            java.text.DateFormat dfHora = new java.text.SimpleDateFormat("HH:mm");
%>
                    Usted tiene una cita pendiente el <%= dfFecha.format(proximaCitaPaciente.getFecha()) %> a las <%= dfHora.format(proximaCitaPaciente.getHora()) %> <a href="ConsultarCitasServlet">(Ir a citas)</a></td>
<%
        }else{
%>
                    Usted no tiene ninguna cita pendiente.
<%
        }
%>
                </td></tr>
            </table>
                  
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
                    <td><%= paciente.getNombre() == null ? "-":paciente.getNombre() %></td>
                    <td><%= paciente.getApellidos() == null ? "-":paciente.getApellidos() %></td>
                    <td><%= paciente.getNumSS() == null ? "-":paciente.getNumSS() %></td>
                    <td><%= paciente.getFechaNac() == null ? "-":df.format( paciente.getFechaNac()) %></td>
                    <td><%= paciente.getDireccion() == null ? "-":paciente.getDireccion() %></td>
                    <td><%= paciente.getLocalidad() == null ? "-":paciente.getLocalidad() %></td>
                    <td><%= paciente.getProvincia() == null ? "-":paciente.getProvincia() %></td>
                    <td><%= paciente.getTelefono() == null ? "-":paciente.getTelefono() %></td>
                </tr>
            </table>
                </td></tr>
            
            
            
            <jsp:include page="OpcionesMenu/opcionesPaciente.jsp" />
    </body>
</html>

<%-- 
    Document   : PerfilMedico
    Created on : 25-abr-2014, 15:30:13
    Author     : Sihame
--%>

<%@page import="turbomedical4000.entity.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil M&eacute;dico</title>
        <% 
            Medico medico= (Medico) session.getAttribute("medico");
            java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
        %>
    </head>
   <body>
         <table width="100%" border="1" cellspacing="0" bordercolor="#000000" >
              
            <tr> <th> &nbsp; </th> <td rowspan="5" >
            <h2> Perfil Personal</h2>
             <table border ="1">
                <tr>
                    <th> Nombre</th>
                    <th> Apellidos</th>
                    <th> DNI</th>
                     <th> Nº Colegiado</th>
                     <th> Especialidad</th>
                    <th> Fecha nacimiento</th>
                    <th> Direcci&oacute;n</th>
                    <th>  Localidad</th>
                    <th>  Provincia</th>
                    <th> Tel&eacute;fono</th>
                </tr>
                <tr>
                    <td><%=medico.getNombre() %> </td>
                    <td><%= medico.getApellidos()%></td>
                    <td><%=medico.getDni() %> </td>
                    <td><%=medico.getNumColegiado() %></td>
                    <td> <%= medico.getEspecialidadidEspecialidad().getDescripcion() %></td>
                    <td><%=df.format(medico.getFechaNac()) %></td>
                    <td><%=medico.getDireccion() %></td>
                    <td><%=medico.getLocalidad() %></td>
                    <td><%=medico.getProvincia() %> </td>
                    <td><%=medico.getTelefono() %></td>
                </tr>
            </table>
                </td></tr>
             <%@ include file="OpcionesMenu/opcionesMedico.jsp" %>
    </body>
</html>

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
         <jsp:include page="OpcionesMenu/aperturaOpcionesMedico.jsp" />
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
                    <td><%=medico.getNombre() == null ? "-":medico.getNombre() %> </td>
                    <td><%= medico.getApellidos() == null ? "-":medico.getApellidos() %></td>
                    <td><%=medico.getDni() == null ? "-":medico.getDni() %> </td>
                    <td><%=medico.getNumColegiado() == null ? "-":medico.getNumColegiado() %></td>
                    <td> <%= medico.getEspecialidadidEspecialidad().getDescripcion() == null ? "-":medico.getEspecialidadidEspecialidad().getDescripcion() %></td>
                    <td><%=medico.getFechaNac() == null ? "-":df.format(medico.getFechaNac()) %></td>
                    <td><%=medico.getDireccion() == null ? "-":medico.getDireccion() %></td>
                    <td><%=medico.getLocalidad() == null ? "-":medico.getLocalidad() %></td>
                    <td><%=medico.getProvincia() == null ? "-":medico.getProvincia() %> </td>
                    <td><%=medico.getTelefono() == null ? "-":medico.getTelefono() %></td>
                </tr>
            </table>
                </td></tr>
             <jsp:include page="OpcionesMenu/opcionesMedico.jsp" />
    </body>
</html>

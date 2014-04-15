<%--
    Document   : menuMedico
    Created on : 11-abr-2014, 2:13:37
    Author     : jorge
--%>

<%@page import="turbomedical4000.entity.Especialidad"%>
<%@page import="turbomedical4000.entity.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; M&uacute;dico</title>
<% 
    Medico medico =(Medico) request.getAttribute("medico");
  
%>
    </head>
    <body>
         <table width="100%" border="1" cellspacing="0" bordercolor="#000000" >
              
            <tr> <th> &nbsp; </th> <th rowspan="5" >
                    Nombre: <%= medico.getNombre() %> </br>
                    Apellidos: <%= medico.getApellidos() %></br>
                    DNI: <%= medico.getDni() %></br>
                    Nº Colegiado: <%= medico.getNumColegiado() %></br>
                    Especialidad: <%= medico.getEspecialidadidEspecialidad().getDescripcion() %></br>
                    Fecha nacimiento: <%= medico.getFechaNac() %></br>
                    Direcci&oacute;n: <%= medico.getNombre() %></br>
                    Localidad: <%= medico.getLocalidad() %></br>
                    Provincia: <%= medico.getProvincia() %></br>
                    Tel&eacute;fono: <%= medico.getTelefono() %></br>
                </th></tr>
            <tr> <td><input type ="submit" value ="Perfil Médico" ></td>  </tr>
            <tr > <td ><input type="submit" value="Pacientes"></td>  </tr>
            <tr > <td ><input type="submit" value="Citas"></td>  </tr>
            <tr > <td ><a href="AddToHistorialServlet"><input type="submit" value="Historial"></a></td>  </tr>

        </table>
        </br>
         <input type="submit" value="Cerrar Sesión">
    </body>
</html>

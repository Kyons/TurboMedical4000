<%-- 
    Document   : pacienteEdit
    Created on : 29-abr-2014, 21:41:49
    Author     : Juan
--%>

<%-- 
    FALTA LA ASIGANACION DE PACIENTES A MEDICOS
--%>

<%@page import="turbomedical4000.entity.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@ include file="../ComprobacionesSesion/comprobacionAdministrador.jsp" %>

<%
    Paciente usuario = (Paciente) request.getAttribute("usuario");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Administrador > Gesti&oacute;n Administradores > Editar paciente</title>
    </head>
    <body>
        
        <%@ include file="../OpcionesMenu/aperturaOpcionesComun.jsp" %>

        <tr>
            <th> &nbsp; </th>
            <td rowspan="7" >
                <h1>Editar paciente</h1>
                
                <form name="editForm" action="EditPacientesServlet" method="post">
                <input type="hidden" name="do" value="edit">
                <input type="hidden" name="numSS" value="<%=usuario.getNumSS()%>">
                <b><a style="color:red"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
                <table border="1">
                    <tr>
                        <td>N&uacute;mero Seguridad Social:</td>
                        <td><input type="text" name="numSegSoc" value="<%=usuario.getNumSS() == null ? "":usuario.getNumSS()%>" readonly></td>
                    </tr><tr>
                        <td>Nombre:</td>	
                        <td><input type="text" name="nombre" value="<%=usuario.getNombre() == null ? "":usuario.getNombre()%>"></td>
                    </tr><tr>
                        <td>Apellidos:</td>	
                        <td><input type="text" name="apellidos" value="<%=usuario.getApellidos() == null ? "":usuario.getApellidos()%>"></td>
                    </tr><tr>
<%
    java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
%>
                        <td>Fecha nacimiento:</td>	
                        <td><input type="text" name="fechaNac" value="<%= usuario.getFechaNac() == null ? "":df.format(usuario.getFechaNac()) %>"></td>
                    </tr><tr>
                        <td>DNI:</td>	
                        <td><input type="text" name="dni" value="<%=usuario.getDni() == null ? "":usuario.getDni()%>"></td>
                    </tr><tr>
                        <td>Direcci&oacute;n:</td>	
                        <td><input type="text" name="direccion" value="<%=usuario.getDireccion() == null ? "":usuario.getDireccion()%>"></td>
                    </tr><tr>
                        <td>Localidad:</td>	
                        <td><input type="text" name="localidad" value="<%=usuario.getLocalidad() == null ? "":usuario.getLocalidad()%>"></td>
                    </tr><tr>
                        <td>Provincia:</td>	
                        <td><input type="text" name="provincia" value="<%=usuario.getProvincia() == null ? "":usuario.getProvincia() %>"></td>
                    </tr><tr>
                        <td>Tel&eacute;fono:</td>	
                        <td><input type="text" name="telefono" value="<%=usuario.getTelefono() == null ? "":usuario.getTelefono()%>"></td>
                    </tr><tr>
                        <td>Contrase&ntilde;a:</td>	
                        <td><input type="password" name="contrasena" value="<%=usuario.getContrasena() == null ? "":usuario.getContrasena()%>"></td>
                    </tr><tr>
                        <td colspan="2"><input type="submit" name="btnEditar" value="Editar"></td>
                    </tr>
                </table>
                </form>
                
            </td> 
        </tr>
        
        <%@ include file="../OpcionesMenu/opcionesAdministrador.jsp" %>
            
    </body>
</html>

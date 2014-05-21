<%-- 
    Document   : pacienteList
    Created on : 24-abr-2014, 22:01:15
    Author     : Juan
--%>

<%@page import="java.util.List"%>
<%@page import="turbomedical4000.entity.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="ComprobacionesSesion/comprobacionAdministrador.jsp" %>

<%
    List<Paciente> lista;
    
    lista = (List<Paciente>)request.getAttribute("lista");
%>   

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Administrador > Gesti&oacute;n Pacientes</title>
    </head>
    <body>
        
       <jsp:include page="OpcionesMenu/AperturaOpcionesAdministrador.jsp" />
                
                    
                    <h1>Gesti&oacute;n de Pacientes</h1>
                    <form name="filtrarPacientes" action="BusquedaPacienteServlet" method="post">
                        <table>
                            <tr>
                                <td align="right">N&uacute;meroSS<input type="text" maxlength="20" size="20" name="numSS"/></td>
                                <td align="right">DNI<input type="text" maxlength="20" size="20" name="dni"/></td>
                                <td align="right">Nombre<input type="text" maxlength="20" size="20" name="nombre"/></td>
                            </tr>
                            <tr>
                                <td align="right">Apellidos<input type="text" maxlength="20" size="20" name="apellidos"/></td>
                                <td align="right">Fecha Nacimiento<input type="text" maxlength="20" size="20" name="fechaNac" value="dd/MM/yyyy" onfocus="if(value==='dd/MM/yyyy')value=''"/></td>
                                <td align="right">Direcci&oacute;n<input type="text" maxlength="20" size="20" name="direcc"/></td>
                            </tr>
                            <tr>
                                <td align="right">Localidad<input type="text" maxlength="20" size="20" name="localidad"/></td>
                                <td align="right">Provincia<input type="text" maxlength="20" size="20" name="provincia"/></td>
                                <td align="right">Tel&eacute;fono<input type="text" maxlength="20" size="20" name="telefono"/></td>
                            </tr>
                        </table>
                        <input type="Submit" value="Buscar" align="right">                       
                    </form>
                    <a href="EditPacientesServlet?do=addForm">A&ntilde;adir nuevo paciente</a><br>
                    <b><a style="color:red"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
        <table border="1">
            <tr>
                <th>N&uacute;mero SS</th>
                <th>DNI</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Fecha nacimiento</th>
                <th>Direcci&oacute;n</th>
                <th>Localidad</th>
                <th>Provincia</th>
                <th>Tel&eacute;fono</th>
                <th>&nbsp;</th>
            </tr>
<%
    if (lista != null){
        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
        for (Paciente paciente: lista) {
%>
            <tr>
                <td><%= paciente.getNumSS() == null ? "-":paciente.getNumSS() %></td>
                <td><%= paciente.getDni() == null ? "-":paciente.getDni() %></td>
                <td><%= paciente.getNombre() == null ? "-":paciente.getNombre() %></td>
                <td><%= paciente.getApellidos() == null ? "-":paciente.getApellidos() %></td>
                <td><%= paciente.getFechaNac() == null ? "-":df.format( paciente.getFechaNac()) %></td>               
                <td><%= paciente.getDireccion() == null ? "-":paciente.getDireccion() %></td>
                <td><%= paciente.getLocalidad() == null ? "-":paciente.getLocalidad() %></td>
                <td><%= paciente.getProvincia() == null ? "-":paciente.getProvincia() %></td>
                <td><%= paciente.getTelefono() == null ? "-":paciente.getTelefono() %></td>
                <td><a href="EditPacientesServlet?do=editForm&numSS=<%= paciente.getNumSS() %>" >Editar</a>
                    <a href="EditPacientesServlet?do=delete&numSS=<%= paciente.getNumSS() %>" onclick="return confirm('¿Seguro que desea eliminar\nel usuario <%= paciente.getNumSS()%>?')">Borrar</a></td>
            </tr>

<%            
        }
    }
%>            
       </table>   
                   </td> 
               
            </tr>
        

        <jsp:include page="OpcionesMenu/opcionesAdministrador.jsp" />
        
    </body>
</html>

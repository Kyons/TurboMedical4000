<%-- 
    Document   : pacienteAsignadoList
    Created on : 03-may-2014, 11:42:17
    Author     : Juan
--%>

<%@page import="turbomedical4000.entity.Medico"%>
<%@page import="java.util.List"%>
<%@page import="turbomedical4000.entity.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    List<Paciente> lista;
    
    lista = (List<Paciente>)request.getAttribute("lista");
    
    Medico medico= (Medico) session.getAttribute("medico");
%>   

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; M&eacute;dico > Pacientes asignados</title>
    </head>
    <body>
        
        <%@ include file="OpcionesMenu/aperturaOpcionesComun.jsp" %>
              
            <tr>
                <th> &nbsp; </th> <td rowspan="5" >

                    <h1>Pacientes asignados a <%= medico.getNombre() %> <%= medico.getApellidos() %></h1>
                    <form name="filtrarPacientesAsignados" action="BusquedaPacienteAsignadoServlet" method="post">
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
        <table border="1">
            <tr>
                <th>N&uacute;mero SS</th>                
                <th>Nombre</th>                
                <th>Apellidos</th>                
                <th>Fecha Nacimiento</th>                
                <th>DNI</th>                
                <th>Direcci&oacute;n</th>                
                <th>Localidad</th>
                <th>Provincia</th>
                <th>Tel&eacute;fono</th>
            </tr>
<%
    if (lista != null){
        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
        for (Paciente paciente: lista) {
%>
            <tr>
                <td><%= paciente.getNumSS() == null ? "-":paciente.getNumSS() %></td>
                <td><%= paciente.getNombre() == null ? "-":paciente.getNombre() %></td>
                <td><%= paciente.getApellidos() == null ? "-":paciente.getApellidos() %></td>
                <td><%= paciente.getFechaNac() == null ? "-":df.format( paciente.getFechaNac()) %></td>
                <td><%= paciente.getDni() == null ? "-":paciente.getDni() %></td>
                <td><%= paciente.getDireccion() == null ? "-":paciente.getDireccion() %></td>
                <td><%= paciente.getLocalidad() == null ? "-":paciente.getLocalidad() %></td>
                <td><%= paciente.getProvincia() == null ? "-":paciente.getProvincia() %></td>
                <td><%= paciente.getTelefono() == null ? "-":paciente.getTelefono() %></td>
            </tr>

<%            
        }
    }
%>            
       </table>   
                   </td> 
               
            </tr>
            
            <%@ include file="OpcionesMenu/opcionesMedico.jsp" %>
            
    </body>
</html>


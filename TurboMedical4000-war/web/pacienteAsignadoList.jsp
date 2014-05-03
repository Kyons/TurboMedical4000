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
        for (Paciente usuario: lista) {
%>
            <tr>
                <td><%= usuario.getNumSS() %></td>
                <td><%= usuario.getNombre() %></td>                
                <td><%= usuario.getApellidos() %></td>                
                <td><%= df.format(usuario.getFechaNac()) %></td>                
                <td><%= usuario.getDni() %></td>                                
                <td><%= usuario.getDireccion() %></td>                          
                <td><%= usuario.getLocalidad() %></td>
                <td><%= usuario.getProvincia() %></td>
                <td><%= usuario.getTelefono() %></td>
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


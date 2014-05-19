<%-- 
    Document   : medicoList
    Created on : 23-abr-2014, 19:14:12
    Author     : Juan
--%>

<%@page import="turbomedical4000.entity.Medico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="ComprobacionesSesion/comprobacionAdministrador.jsp" %>

<%
    List<Medico> lista;
    
    lista = (List<Medico>)request.getAttribute("lista");
%>   

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Administrador > Gesti&oacute;n M&eacute;dicos</title>
    </head>
    <body>
        
        <%@ include file="OpcionesMenu/aperturaOpcionesComun.jsp" %>
              
            <tr>
                <th> &nbsp; </th> <td rowspan="7" >
                
                    
                    <h1>Gesti&oacute;n de M&eacute;dicos</h1>
                    <form name="filtrarMedicos" action="BusquedaMedicoServlet" method="post">
                        <table>
                            <tr>
                                <td align="right">N&uacute;mero Colegiado<input type="text" maxlength="20" size="20" name="numCol"/></td>
                                <td align="right">Especialidad<input type="text" maxlength="20" size="20" name="especialidad"/></td>
                                <td align="right">Nombre<input type="text" maxlength="20" size="20" name="nombre"/></td>
                            </tr>
                            <tr>
                                <td align="right">Apellidos<input type="text" maxlength="20" size="20" name="apellidos"/></td>
                                <td align="right">Fecha Nacimiento<input type="text" maxlength="20" size="20" name="fechaNac"/></td>
                                <td align="right">DNI<input type="text" maxlength="20" size="20" name="dni"/></td>
                            </tr>
                            <tr>
                                <td align="right">Direcci&oacute;n<input type="text" maxlength="20" size="20" name="direcc"/></td>
                                <td align="right">Localidad<input type="text" maxlength="20" size="20" name="localidad"/></td>
                                <td align="right">Provincia<input type="text" maxlength="20" size="20" name="provincia"/></td>                   
                            </tr>
                            <tr>
                                <td align="right">Tel&eacute;fono<input type="text" maxlength="20" size="20" name="telefono"/></td>
                            </tr>
                        </table>
                        <input type="Submit" value="Buscar" align="right">                       
                    </form>
                    <a href="EditMedicosServlet?do=addForm">A&ntilde;adir nuevo m&eacute;dico</a><br>
                    <b><a style="color:red"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
        <table border="1">
            <tr>
                <th>N&uacute;mero colegiado</th>
                <th>Especialidad</th>                  
                <th>Nombre</th>                
                <th>Apellidos</th>                
                <th>Fecha Nacimiento</th>                
                <th>DNI</th>                
                <th>Direcci&oacute;n</th>                
                <th>Localidad</th>
                <th>Provincia</th>
                <th>Tel&eacute;fono</th>
                <th>&nbsp;</th>
            </tr>
<%
    if (lista != null){
        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
        for (Medico usuario: lista) {
%>
            <tr>
                <td><%= usuario.getNumColegiado() %></td>
                <td><%= usuario.getEspecialidadidEspecialidad().getDescripcion() %></td>
                <td><%= usuario.getNombre() %></td>                
                <td><%= usuario.getApellidos() %></td>                
                <td><%= df.format(usuario.getFechaNac()) %></td>                
                <td><%= usuario.getDni() %></td>                                
                <td><%= usuario.getDireccion() %></td>                          
                <td><%= usuario.getLocalidad() %></td>
                <td><%= usuario.getProvincia() %></td>
                <td><%= usuario.getTelefono() %></td>
                <td><a href="EditMedicosServlet?do=editForm&numColegiado=<%= usuario.getNumColegiado() %>" >Editar</a>
                    <a href="EditMedicosServlet?do=delete&numColegiado=<%= usuario.getNumColegiado() %>" onclick="return confirm('¿Seguro que desea eliminar\nel usuario <%= usuario.getNumColegiado()%>?')">Borrar</a></td>
            </tr>

<%            
        }
    }
%>            
       </table>   
                   </td> 
               
            </tr>
            
            <%@ include file="OpcionesMenu/opcionesAdministrador.jsp" %>
            
    </body>
</html>

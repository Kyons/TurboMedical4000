<%-- 
    Document   : medicoAdd
    Created on : 29-abr-2014, 21:41:23
    Author     : Juan
--%>

<%-- 
    FALTA LA ASIGANACION DE PACIENTES A MEDICOS
--%>

<%@page import="turbomedical4000.entity.Especialidad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="../ComprobacionesSesion/comprobacionAdministrador.jsp" %>

<%
    List<Especialidad> especialidades;
    
    especialidades = (List<Especialidad>)request.getAttribute("especialidades");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Administrador > Gesti&oacute;n Administradores > Nuevo m&eacute;dico</title>
    </head>
    <body>
        
        <%@ include file="../OpcionesMenu/aperturaOpcionesComun.jsp" %>

        <tr>
            <th> &nbsp; </th>
            <td rowspan="7" >
                <h1>A&ntilde;adir nuevo m&eacute;dico</h1>
                
                <form name="addForm" action="EditMedicosServlet">
                <input type="hidden" name="do" value="add">
                <b><a style="color:red"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
                <table border="1">
                    <tr>
                        <td>N&uacute;mero colegiado:</td>
                        <td><input type="text" name="numColegiado" value=""></td>
                    </tr><tr>
                        <td>Especialidad:</td>
                        <td><select name="idEspecialidad">                    
<%
    if (especialidades != null)
        for (Especialidad especialidad: especialidades) {
%>
                            <option value="<%= especialidad.getIdEspecialidad() %>"><%= especialidad.getDescripcion() %></option>
<%            
        }
%>
                        </select></td>
                    </tr><tr>
                        <td>Nombre:</td>	
                        <td><input type="text" name="nombre" value=""></td>
                    </tr><tr>
                        <td>Apellidos:</td>	
                        <td><input type="text" name="apellidos" value=""></td>
                    </tr><tr>
                        <td>Fecha nacimient:</td>	
                        <td><input type="text" name="fechaNac" value=""></td>
                    </tr><tr>
                        <td>DNI:</td>	
                        <td><input type="text" name="dni" value=""></td>
                    </tr><tr>
                        <td>Direcci&oacute;n:</td>	
                        <td><input type="text" name="direccion" value=""></td>
                    </tr><tr>
                        <td>Localidad:</td>	
                        <td><input type="text" name="localidad" value=""></td>
                    </tr><tr>
                        <td>Provincia:</td>	
                        <td><input type="text" name="provincia" value=""></td>
                    </tr><tr>
                        <td>Tel&eacute;fono:</td>	
                        <td><input type="text" name="telefono" value=""></td>
                    </tr><tr>
                        <td>Contrase&ntilde;a:</td>	
                        <td><input type="password" name="contrasena" value=""></td>
                    </tr><tr>
                        <td colspan="2"><input type="submit" name="btnAniadir" value="A&ntilde;adir"></td>
                    </tr>
                </table>
                </form>
                
            </td> 
        </tr>
        
        <%@ include file="../OpcionesMenu/opcionesAdministrador.jsp" %>
            
    </body>
</html>
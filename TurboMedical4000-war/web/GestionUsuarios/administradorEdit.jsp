<%-- 
    Document   : administradorEdit
    Created on : 29-abr-2014, 21:42:12
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="../ComprobacionesSesion/comprobacionAdministrador.jsp" %>

<%
    Administrador usuario = (Administrador) request.getAttribute("usuario");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Administrador > Gesti&oacute;n Administradores > Editar administrador</title>
    </head>
    <body>
        
        <%@ include file="../OpcionesMenu/aperturaOpcionesComun.jsp" %>

        <tr>
            <th> &nbsp; </th>
            <td rowspan="5" >
                <h1>Editar administrador</h1>
                
                <form name="editForm" action="EditAdministradoresServlet">
                <input type="hidden" name="do" value="edit">
                <input type="hidden" name="idAdministrador" value="<%=usuario.getIdAdministrador()%>">
                <table border="1">
                    <tr>
                        <td>Usuario:</td>
                        <td><input type="text" name="usuario" value="<%=usuario.getUsuario()%>"></td>
                    </tr><tr>		
                        <td>Contrase&ntilde;a:</td>	
                        <td><input type="password" name="contrasena" value="<%=usuario.getContrasena()%>"></td>
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

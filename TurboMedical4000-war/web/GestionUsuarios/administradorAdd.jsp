<%-- 
    Document   : administradorAdd
    Created on : 29-abr-2014, 21:41:58
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="../ComprobacionesSesion/comprobacionAdministrador.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Administrador > Gesti&oacute;n Administradores > Nuevo administrador</title>
    </head>
    <body>
        
        <jsp:include page="../OpcionesMenu/aperturaOpcionesAdministrador.jsp" />
        <a href="ListaAdministradoresServlet">&#8592; Volver</a>
        
                <h1>A&ntilde;adir nuevo administrador</h1>
                
                <form name="addForm" action="EditAdministradoresServlet" method="post">
                <input type="hidden" name="do" value="add">
                <b><a style="color:red"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
                <table border="1">
                    <tr>
                        <td>Usuario:</td>
                        <td><input type="text" name="usuario" value=""></td>
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
        
        <jsp:include page="../OpcionesMenu/opcionesAdministrador.jsp" />
            
    </body>
</html>
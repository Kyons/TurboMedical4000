<%-- 
    Document   : menuAdministrador
    Created on : 11-abr-2014, 2:14:26
    Author     : jorge, juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="ComprobacionesSesion/comprobacionAdministrador.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Administrador</title>

    </head>
    <body>
        
        <%@ include file="OpcionesMenu/aperturaOpcionesComun.jsp" %>
              
            <tr>
                <th> &nbsp; </th> <th rowspan="6" >
                    Usuario: <%= administrador.getUsuario() %> </br>
                </th>
            </tr>
            
            <%@ include file="OpcionesMenu/opcionesAdministrador.jsp" %>
            
    </body>
</html>

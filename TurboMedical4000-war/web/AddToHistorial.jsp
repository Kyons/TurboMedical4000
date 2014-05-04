<%-- 
    Document   : AddToHistorial
    Created on : 13-abr-2014, 17:59:01
    Author     : Sihame
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A&ntilde;adir al Historial</title>

    </head>
    <body>
         <table width="100%" border="1" cellspacing="0" bordercolor="#000000" >
              
            <tr> <th> &nbsp; </th> <th rowspan="5" >
            <form name="add" accion="AdToHistorialServlet" method="post">
                <table>
                    <tr>
                        <th>Usuario</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                       
                    </tr>
                    <tr>
                        <td><input type="text" name="usuario" value=""></td>
                        <td><input type="text" name="fecha" value=""></td>
                        <td> <input type="text" name="hora" value=""></td>
                        
                       
                    </tr>
                    <tr>  <th>Entrada</th> <th>&nbsp;</th><th>&nbsp;</th>
                         
                    </tr>
                    <tr>
                        <td colspan="4"><textarea name="entrada" cols="60" rows="10" ></textarea></td>
                    </tr>
                    <tr>
                        <td>&nbsp</td>
                        <td>&nbsp;</td>
                        <td><input type="submit" name="guardar" value="Guardar"></td>
                    </tr>
           
                </table>
           
              </form> 

                </th></tr>
           <%@ include file="OpcionesMenu/opcionesMedico.jsp" %>
    </body>
</html>

<%-- 
    Document   : CrearAlertas
    Created on : 16-may-2014, 7:08:48
    Author     : Tomás
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="ComprobacionesSesion/comprobacionMedico.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; M&eacute;dico</title>
    </head>
    <body>

        <jsp:include page="OpcionesMenu/aperturaOpcionesMedico.jsp" />

        <form name="addAlerta" action="CrearAlertasServlet" method="post">
            <table>
                <h1>Crear nueva Alerta</h1>
                <tr>
                    <th>N&uacute;mero SS Paciente:</th>
                    <th>N&uacute;mero colegiado:</th>
                    <th>Fecha:</th>
                    <th>Hora:</th>
                    <th>Descripci&oacute;n:</th>
                    <th></th>
                </tr>
                <tr>
                    <td><input type="text" name="paciente" value=""></td>
                    <td><input type="text" name="numCol" value=""></td>
                    <td><input type="text" name="fecha" value=""></td>
                    <td><input type="text" name="hora" value=""></td> 
                    <td><input type="text" name="texto" value=""></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><input type="submit" name="NuevaAl" value="Crear Alerta"></td>
                </tr>

            </table>            
        </form>
        <jsp:include page="OpcionesMenu/opcionesMedico.jsp" />
    </body>
</html>

<%-- 
    Document   : SolicitarCita
    Created on : 04-may-2014, 1:27:47
    Author     : Tomás
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Paciente</title>
    </head>
    <body>
        <h1>Solicitar cita</h1>
        <table width="100%" border="1" cellspacing="0" bordercolor="#000000" >
        <tr> <th> &nbsp; </th> <td rowspan="4" >
        <h2>Solicitar Cita</h2>
        <form name="addCita" action="SolicitarCitaServlet" method="post">
              <table>
                    <tr>
                        <th>N&uacute;mero colegiado:</th>
                        <th>Fecha:</th>
                        <th>Hora:</th>
                        <th>Lugar:</th>
                    </tr>
                    <tr>
                        <td><input type="text" name="numCol" value=""></td>
                        <td><input type="text" name="fecha" value="dd/MM/yyyy" onfocus="if(value==='dd/MM/yyyy')value=''"></td>
                        <td><input type="text" name="hora" value="HH:mm" onfocus="if(value==='HH:mm')value=''"></td> 
                        <td><input type="text" name="lugar" value=""></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><input type="submit" name="pedir" value="Pedir Cita"></td>
                    </tr>
                    
            </table>            
      </form>
      <%@ include file="OpcionesMenu/opcionesPaciente.jsp" %>
  </body>
</html>

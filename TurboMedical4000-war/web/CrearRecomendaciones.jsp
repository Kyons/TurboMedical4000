<%-- 
    Document   : CrearRecomendaciones
    Created on : 16-may-2014, 7:09:13
    Author     : Tomás
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; M&eacute;dico</title>
    </head>
    <body>
        <h1>Crear nueva recomendaci&oacute;n</h1>
        <jsp:include page="OpcionesMenu/AperturaOpcionesMedico.jsp" />
        
        <form name="addRecom" action="CrearRecomendacionesServlet" method="post">
              <table>
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
                        <td><input type="submit" name="NuevaR" value="Nueva Recomendaci&oacute;n></td>
                    </tr>
                    
            </table>            
      </form>
        <jsp:include page="OpcionesMenu/ppcionesMedico.jsp" />
  </body>
</html>

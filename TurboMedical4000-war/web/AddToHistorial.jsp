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
        <title>Men&uacute; M&uacute;dico</title>

    </head>
    <body>
         <table width="100%" border="1" cellspacing="0" bordercolor="#000000" >
              
            <tr> <th> &nbsp; </th> <th rowspan="5" >
            <form name="add" accion="AdToHistorialServlet" method="post">
              Usuario:  <input type="text" name="usuario" value=""> </br>
              Fecha: <input type="text" name="fecha" value=""></br>
              Hora: <input type="text" name="hora" value=""></br>
              Entrada:<input type="text" name="entrada" value=""></br>
              <input type="submit" name="guardar" value="Guardar">
            </form>
                </th></tr>
            <tr> <td><input type ="submit" value ="Perfil Médico" ></td>  </tr>
            <tr > <td ><input type="submit" value="Pacientes"></td>  </tr>
            <tr > <td ><input type="submit" value="Citas"></td>  </tr>
            <tr > <td ><a href="AddToHistorialServlet"><input type="submit" value="Historial"></a></td>  </tr>

        </table>
        </br>
         <input type="submit" value="Cerrar Sesión">
    </body>
</html>

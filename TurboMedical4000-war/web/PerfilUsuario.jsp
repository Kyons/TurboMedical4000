<%-- 
    Document   : PerfilUsuario
    Created on : 13-abr-2014, 13:25:49
    Author     : Sihame
--%>

<%@page import="turbomedical4000.entity.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Paciente</title>
   <%
  	//get the book object from the request
	Paciente paciente =(Paciente) request.getAttribute("paciente");
  %>
    </head>
    <body>
     
        <table width="100%" border="1" cellspacing="0" bordercolor="#000000" >
              
            <tr> <th> &nbsp; </th> <th rowspan="4" >
                     Nombre: <%= paciente.getNombre() %>
                    </br>
                    Apellidos: 
                    </br> 
                    N&uacute;mero S.S: <%= paciente.getNumSS()%>
                    </br>
                    DNI: <%= paciente.getDni() %>
                    </br>
                    Fecha naciemiento: <%= paciente.getFechaNac() %>
                    </br>
                    Direcci&oacute;n:<%= paciente.getDireccion() %>
                    </br>
                    Localidad:<%= paciente.getLocalidad() %>
                    </br>
                    Provincia: <%= paciente.getProvincia() %>
                    </br>
                    Tel&eacute;fono: <%= paciente.getTelefono() %>
                </th></tr>
            
            <tr> <td><a href="ConsultarPerfilUsuarioServlet?usuario=<%= paciente.getNumSS() %>"><input type ="submit" value ="Perfil"  ></a></td>  </tr>
            <tr > <td ><input type="submit" value="Citas"></td>  </tr>
            <tr > <td ><a href="ConsultarHistorialServlet?usuario=<%= paciente.getNumSS() %> "><input type="submit" value="Historial"></a></td>  </tr>

        </table>
            
        </br>
        <a href="loginPacientes.jsp"> <input type="submit" value="Cerrar Sesión" ></a>
    </body>
</html>

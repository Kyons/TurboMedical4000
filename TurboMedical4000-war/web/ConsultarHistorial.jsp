<%-- 
    Document   : ConsultarHistorial
    Created on : 13-abr-2014, 13:04:13
    Author     : Sihame
--%>

<%@page import="java.util.List"%>
<%@page import="turbomedical4000.entity.Lineahistorial"%>
<%@page import="java.util.Collection"%>
<%@page import="turbomedical4000.entity.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Paciente</title>
         <%
  	//get the book object from the request
	List <Lineahistorial> historial =(List <Lineahistorial>) request.getAttribute("historial");
       Paciente paciente =(Paciente) request.getAttribute("paciente");
       
         
  %>
    </head>
    <body>
        <form name="edit" action="ConsultarHistorialServlet" method="get">
        <table width="100%" border="1" cellspacing="0" bordercolor="#000000" >
              
            <tr> <th> &nbsp; </th> <th rowspan="4" >
               Nombre del paciente : <%= paciente.getNombre() %> </br>
                <%
            for(Lineahistorial lh: historial){
             %>
           
             Fecha: <%= lh.getFecha() %> </br>
             Hora: <%= lh.getHora() %> </br>
             Entrada: <%= lh.getEntrada() %> </br>
             <%
            }
       %>
                    
                </th></tr>
            <tr> <td><a href="ConsultarPerfilUsuarioServlet?usuario=<%= paciente.getNumSS() %>"><input type ="submit" value ="Perfil"  ></a></td>  </tr>
            <tr > <td ><input type="submit" value="Citas"></td>  </tr>
            <tr > <td ><a href="ConsultarHistorialServlet?usuario=<%= paciente.getNumSS() %>"><input type="submit" value="Historial"></a></td>  </tr>

        </table>
        </form>
        </br>
        <a href="loginPacientes.jsp"> <input type="submit" value="Cerrar Sesión" ></a>
    </body>
</html>

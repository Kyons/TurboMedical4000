<%-- 
    Document   : menuPaciente
    Created on : 11-abr-2014, 2:12:50
    Author     : jorge
--%>

<%@page import="turbomedical4000.entity.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Paciente</title>
   <%
      
        Paciente paciente =(Paciente) session.getAttribute("paciente");
       if(paciente ==null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("loginPacientes.jsp");
            dispatcher.forward(request, response);
       }
            
  	
	
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
            
           <%@ include file="OpcionesMenu/opcionesPaciente.jsp" %>
    </body>
</html>

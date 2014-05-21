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
     
        <jsp:include page="OpcionesMenu/AperturaOpcionesPaciente.jsp" />
                   Usuario:<%= paciente.getNombre()+" "+ paciente.getApellidos() %>
                </td></tr>
            
           <jsp:include page="OpcionesMenu/opcionesPaciente.jsp" />
    </body>
</html>

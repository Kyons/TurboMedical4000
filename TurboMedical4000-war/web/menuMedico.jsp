<%--
    Document   : menuMedico
    Created on : 11-abr-2014, 2:13:37
    Author     : jorge
--%>

<%@page import="turbomedical4000.entity.Especialidad"%>
<%@page import="turbomedical4000.entity.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; M&eacute;dico</title>
<% 
    Medico medico =(Medico) session.getAttribute("medico");
    if(medico ==null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("loginMedicos.jsp");
            dispatcher.forward(request, response);
       }
  
%>
    </head>
    <body>
         <jsp:include page="OpcionesMenu/aperturaOpcionesMedico.jsp" />
                Usuario: <%= medico.getNombre() %> <%= medico.getApellidos() %>
                </td></tr>
             <jsp:include page="OpcionesMenu/opcionesMedico.jsp" />
    </body>
</html>

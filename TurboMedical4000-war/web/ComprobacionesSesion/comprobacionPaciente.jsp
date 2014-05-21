<%-- 
    Document   : comprobacionPaciente
    Author     : Juan
--%>

<%@page import="turbomedical4000.entity.Paciente"%>

<%
Paciente paciente =(Paciente) session.getAttribute("paciente");

if(paciente == null){
    RequestDispatcher dispatcher = request.getRequestDispatcher("loginPacientes.jsp?msg=Necesaria autenticación de paciente");
    dispatcher.forward(request, response);
}
%>
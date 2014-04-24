<%-- 
    Document   : comprobacionAdministrador
    Created on : 24-abr-2014, 21:43:37
    Author     : Juan
--%>

<%@page import="turbomedical4000.entity.Administrador"%>

<%
Administrador administrador =(Administrador) session.getAttribute("administrador");

if(administrador ==null){
    RequestDispatcher dispatcher = request.getRequestDispatcher("loginAdministrador.jsp?msg=Necesaria autenticación de administrador");
    dispatcher.forward(request, response);
}
%>
<%-- 
    Document   : comprobacionMedico
    Author     : Juan
--%>

<%@page import="turbomedical4000.entity.Medico"%>

<%
Medico medico =(Medico) session.getAttribute("medico");

if(medico == null){
    RequestDispatcher dispatcher = request.getRequestDispatcher("loginMedicos.jsp?msg=Necesaria autenticaci�n de m�dico");
    dispatcher.forward(request, response);
}
%>
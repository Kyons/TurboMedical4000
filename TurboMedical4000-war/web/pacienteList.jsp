<%-- 
    Document   : pacienteList
    Created on : 24-abr-2014, 22:01:15
    Author     : Juan
--%>

<%@page import="java.util.List"%>
<%@page import="turbomedical4000.entity.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="ComprobacionesSesion/comprobacionAdministrador.jsp" %>

<%
    List<Paciente> lista;
    
    lista = (List<Paciente>)request.getAttribute("lista");
%>   

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Administrador > Gesti&oacute;n Pacientes</title>
    </head>
    <body>
        
        <%@ include file="OpcionesMenu/aperturaOpcionesComun.jsp" %>

        <th> &nbsp; </th> <td rowspan="5" >POR IMPLEMENTAR

        <%@ include file="OpcionesMenu/opcionesAdministrador.jsp" %>
        
    </body>
</html>

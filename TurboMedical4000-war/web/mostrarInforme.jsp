<%-- 
    Document   : mostrarInforme
    Created on : 14-may-2014, 21:52:52
    Author     : Juan
--%>

<%--
    Esta página no lleva las opciones de menú y demás por si se deseara imprimir
    el informe generado.
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="turbomedical4000.entity.Formulario"%>
<%@page import="turbomedical4000.entity.Tipoformulario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="ComprobacionesSesion/comprobacionAdministrador.jsp" %>

<%
    Map<Tipoformulario,List<Formulario>> formularios = (Map<Tipoformulario,List<Formulario>>)request.getAttribute("formularios");
    
    Date fecha1 = (Date)request.getAttribute("fecha1");
    Date fecha2 = (Date)request.getAttribute("fecha2");

    java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
    java.text.DateFormat df2 = new java.text.SimpleDateFormat("HH:MM");
%>  

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informe de formularios enviados entre el d&iacute;a <%= df.format(fecha1) %> y el <%= df.format(fecha2) %></title>
    </head>
    <body>
        <a href="GeneradorInformesServlet">&#8592; Volver</a>
        
        <a name="inicio"><h1>Informe de formularios entre el <%= df.format(fecha1) %> y el <%= df.format(fecha2) %></h1></a>

        <b>Tipos de formularios incluidos en este informe: 
<%
    if((Boolean)request.getAttribute("ninguno")){
%>
        No se ha seleccionado ning&uacute;n tipo de formulario para este informe.</b>
<%
    }else{
%>
        <ul>
<%
        for(Tipoformulario tipo: formularios.keySet()){
%>
            <li><a href="#<%= tipo.getTipo() %>"><%= tipo.getTipo() %></a></li>
<%
        }
%>
        </ul>
        </b>
        
<%
        for(Tipoformulario tipo: formularios.keySet()){
%>          
            <hr>
            <a name="<%= tipo.getTipo() %>"><h2>Formularios de <%= tipo.getTipo() %></h2></a>
            <b>Total de formularios de este tipo:</b> <%= formularios.get(tipo).size() %><br><br>
            
<%
            for(Formulario formul : formularios.get(tipo)){
%>
                <b>Identificador de formulario:</b> <%= formul.getIdFormulario() %><br>
                <b>Formulario enviado por el paciente con num. SS</b> <%= formul.getPacientenumSS().getNumSS() %><b>.</b>
                <b>El d&iacute;a</b> <%= df.format(formul.getFecha() ) %> <b>a las</b> <%= df2.format(formul.getHora()) %>
                <br>
                <b>Contenido:</b>
                <p><%= formul.getEntrada() %></p>
                <br>
<%
            }
%>
            <a href="#inicio">&#8593; Volver al inicio</a>
<%
        }
    }
%>
            
    </body>
</html>

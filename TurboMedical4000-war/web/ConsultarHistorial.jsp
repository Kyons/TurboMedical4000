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
  	List <Lineahistorial> historial =(List <Lineahistorial>) request.getAttribute("historial");
        %>
    </head>
    <body>
     
        <table width="100%" border="1" cellspacing="0" bordercolor="#000000" >
              
            <tr> <th> &nbsp; </th> <td rowspan="4" >
                    <h2>Historial Personal</h2>
               <table border="1">
                   <tr>
                       <th>Fecha</th>
                       <th>Hora</th>
                       <th>Entrada</th>
                   </tr>
 <%
            if(historial!=null){
            java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
             java.text.DateFormat hf = new java.text.SimpleDateFormat("HH:MM:SS");
            for(Lineahistorial lh: historial){
                
 %>
                  <tr>
                      <td><%= df.format(lh.getFecha()) %></td>
                      <td> <%= hf.format(lh.getHora()) %></td>
                      <td><%= lh.getEntrada() %></td>
                  </tr>
  <%
            }
            }
  %>
               </table>  
                </td></tr>
             <%@ include file="OpcionesMenu/opcionesPaciente.jsp" %>
</html>

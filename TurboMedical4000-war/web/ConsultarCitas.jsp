<%-- 
    Document   : ConsultarCitas
    Created on : 03-may-2014, 22:28:23
    Author     : Tomás
--%>

<%@page import="java.util.List"%>
<%@page import="turbomedical4000.entity.Cita"%>
<%@page import="java.util.Collection"%>
<%@page import="turbomedical4000.entity.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Paciente</title>
         <%
             List<Cita> cita = (List<Cita>) request.getAttribute("citas");
  	 %>
    </head>
    <body>
        
        <table width="100%" border="1" cellspacing="0" bordercolor="#000000" >
              
            <tr> <th> &nbsp; </th> <td rowspan="4" >
                    <h2>Lista de Citas</h2>
               <table border="1">
                   <tr>
                       <th>Fecha</th>
                       <th>Hora</th>
                       <th>Lugar</th>
                       <th>Medico</th>
                   </tr>
 <%
            if(cita!=null){
                java.text.DateFormat dfFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
                java.text.DateFormat dfHora = new java.text.SimpleDateFormat("HH:mm");
                for(Cita ct: cita){             
 %>
                  <tr>
                      <td> <%= dfFecha.format(ct.getFecha()) %> </td>
                      <td> <%= dfHora.format(ct.getHora()) %> </td>
                      <td> <%= ct.getLugar() %> </td>
                      <td> <%= ct.getMediconumColegiado().getNumColegiado() %> </td>
                  </tr>
  <%
                }  
            }
  %>
               </table>  
                </td></tr>
            <tr> <td><a href="SolicitarCita.jsp">Solicitar Cita</a></td>  </tr>

             <%@ include file="OpcionesMenu/opcionesPaciente.jsp" %>       
        
    </body>
</html>

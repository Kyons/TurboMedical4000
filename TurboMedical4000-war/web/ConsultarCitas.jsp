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
                    <form name="filtrarCitas" action="BusquedaCitasPacienteServlet" method="post">
                        <table>
                            <tr>
                                <td align="right">Fecha<input type="text" maxlength="20" size="20" name="fecha" value="dd/MM/yyyy" onfocus="if(value==='dd/MM/yyyy')value=''"/></td>
                                <td align="right">Hora<input type="text" maxlength="20" size="20" name="hora" value="HH:mm" onfocus="if(value==='HH:mm')value=''"/></td>
                            </tr>
                            <tr>
                                <td align="right">Lugar<input type="text" maxlength="20" size="20" name="lugar"/></td>
                                <td align="right">M&eacute;dico<input type="text" maxlength="20" size="20" name="medico"/></td>
                            </tr>
                        </table>
                        <input type="Submit" value="Buscar">
                    </form>
                    <a href="SolicitarCita.jsp">Solicitar cita</a><br>
                    <b><a style="color:red"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
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
                      <td> <%= ct.getFecha() == null ? "-":dfFecha.format(ct.getFecha()) %> </td>
                      <td> <%= ct.getHora() == null ? "-":dfHora.format(ct.getHora()) %> </td>
                      <td> <%= ct.getLugar() == null ? "-":ct.getLugar() %> </td>
                      <td> <%= ct.getMediconumColegiado().getNombre() %> <%= ct.getMediconumColegiado().getApellidos() %> </td>
                  </tr>
  <%
                }  
            }
  %>
               </table>  
                </td></tr>

             <%@ include file="OpcionesMenu/opcionesPaciente.jsp" %>       
        
    </body>
</html>

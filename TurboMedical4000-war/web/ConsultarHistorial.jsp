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
<%@ include file="ComprobacionesSesion/comprobacionPaciente.jsp" %>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Paciente</title>
         <%
  	List <Lineahistorial> historial =(List <Lineahistorial>) request.getAttribute("historial");
        %>
    </head>
    <body>
     
        <jsp:include page="OpcionesMenu/aperturaOpcionesPaciente.jsp" />
        <a href="ConsultarPerfilUsuarioServlet">&#8592; Volver</a>
        
                    <h2>Historial Personal</h2>
                    <form name="filtrarHistorial" action="BusquedaHistorialPacienteServlet" method="post">
                        <table>
                            <tr>
                                <td align="right">Fecha<input type="text" maxlength="20" size="20" name="fecha" value="dd/MM/yyyy" onfocus="if(value==='dd/MM/yyyy')value=''"/></td>
                                <td align="right">Hora<input type="text" maxlength="20" size="20" name="hora" value="HH:mm" onfocus="if(value==='HH:mm')value=''"/></td>
                            </tr>
                            <tr>
                                <td align="right">Entrada<input type="text" maxlength="40" size="20" name="entrada"/></td>
                                <td></td>
                            </tr>
                        </table>
                        <input type="Submit" value="Buscar">
                    </form>
                 <% 
                    if(!historial.isEmpty()){
                        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
                        java.text.DateFormat hf = new java.text.SimpleDateFormat("HH:mm");
                 %>
               <table border="1">
                   <tr>
                       <th>Fecha</th>
                       <th>Hora</th>
                       <th>Entrada</th>
                   </tr>
 <%
           
                    for(Lineahistorial lh: historial){
                
 %>
                  <tr>
                      <td><%= lh.getFecha() == null ? "-":df.format(lh.getFecha()) %></td>
                      <td> <%= lh.getHora() == null ? "-":hf.format(lh.getHora()) %></td>
                      <td><%= lh.getEntrada() == null ? "-":lh.getEntrada() %></td>
                  </tr>
  <%
                    }
  %>
               </table>
               <a href="ConsultarHistorialPersonal.jsf">Ver Historial</a>
               <% }else{ %>
               <h3>NO HAY NINGUNA ENTRADA EN EL HISTORIAL PARA MOSTRAR</h3>
               <% } %>
                </td></tr>
             <jsp:include page="OpcionesMenu/opcionesPaciente.jsp" />
</html>

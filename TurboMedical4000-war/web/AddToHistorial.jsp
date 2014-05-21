<%-- 
    Document   : AddToHistorial
    Created on : 13-abr-2014, 17:59:01
    Author     : Sihame
--%>

<%@page import="turbomedical4000.entity.Paciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="ComprobacionesSesion/comprobacionMedico.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A&ntilde;adir al Historial</title>
        <% 
            List<Paciente> listapacientes= (List<Paciente>)request.getAttribute("lista");
        %>

    </head>
    
    <body>
        <jsp:include page="OpcionesMenu/aperturaOpcionesMedico.jsp" />
                     <a href="ConsultarPerfilMedicoServlet">&#8592; Volver</a>
            <form name="add" accion="AddToHistorialServlet" method="post">
                <table>
                    <tr>
                        <th>Usuario</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                       
                    </tr>
                    <tr>
                        <td>
                            <select name="usuario">
        <%
    if (listapacientes != null)
        for (Paciente p: listapacientes) {
%>
<option value="<%= p.getNumSS() %>"<% if(Integer.parseInt(request.getParameter("id")) == p.getNumSS()){ %> selected="selected"  <% } %> ><%= p.getNumSS()+" "+p.getNombre()+" "+p.getApellidos() %></option>
<%            
        }
%>       
                            </select>
                        </td>
                        <td><input type="text" name="fecha" value="dd/MM/yyyy" onfocus="if(value==='dd/MM/yyyy')value=''"></td>
                        <td> <input type="text" name="hora" value="HH:mm" onfocus="if(value==='HH:mm')value=''" ></td>
                        
                       
                    </tr>
                    <tr>  <th>Entrada</th> <th>&nbsp;</th><th>&nbsp;</th>
                         
                    </tr>
                    <tr>
                        <td colspan="4"><textarea name="entrada" cols="60" rows="10" ></textarea></td>
                    </tr>
                    <tr>
                        <td>&nbsp</td>
                        <td>&nbsp;</td>
                        <td><input type="submit" name="guardar" value="Guardar"></td>
                    </tr>
           
                </table>
                
           
              </form> 

                </td></tr>
           <jsp:include page="OpcionesMenu/opcionesMedico.jsp" />
    </body>
</html>

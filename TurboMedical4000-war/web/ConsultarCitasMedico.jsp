<%-- 
    Document   : ConsultarCitasMedico
    Created on : 04-may-2014, 15:42:53
    Author     : Sihame
--%>

<%@page import="turbomedical4000.entity.Cita"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citas Actuales</title>
        <%
            List<Cita> citas = (List<Cita>) request.getAttribute("citas");
        %>
    </head>
      <body>
         <table width="100%" border="1" cellspacing="0" bordercolor="#000000" >
              
            <tr> <th> &nbsp; </th> <td rowspan="5" >
                    <h1>Citas actualmente registradas</h1>
                    <form name="filtrarCitas" action="BusquedaCitasMedicoServlet" method="post">
                        <table>
                            <tr>
                                <td align="right">Fecha<input type="text" maxlength="20" size="20" name="fecha"/></td>
                                <td align="right">Hora<input type="text" maxlength="20" size="20" name="hora"/></td>
                            </tr>
                            <tr>
                                <td align="right">Lugar<input type="text" maxlength="20" size="20" name="lugar"/></td>
                                <td align="right">Paciente<input type="text" maxlength="20" size="20" name="paciente"/></td>
                            </tr>
                        </table>
                        <input type="Submit" value="Buscar">
                    </form>
                <table border="1">
                   <tr>
                       <th>Paciente</th>
                       <th>Fecha</th>
                       <th>Hora</th>
                   </tr>
 <%
            if(citas!=null){
            java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
             java.text.DateFormat hf = new java.text.SimpleDateFormat("HH:MM:SS");
            for(Cita c: citas){
                
 %>
                  <tr>
                      <td><%= c.getPacientenumSS().getNombre()+" "+c.getPacientenumSS().getApellidos() %></td>
                      <td> <%= df.format(c.getFecha()) %></td>
                      <td><%= hf.format(c.getHora()) %></td>
                  </tr>
  <%
            }
            }
  %>
               </table>  
           
              

                </td></tr>
           <%@ include file="OpcionesMenu/opcionesMedico.jsp" %>
    </body>
</html>

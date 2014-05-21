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
         <jsp:include page="OpcionesMenu/aperturaOpcionesMedico.jsp" />
                    <h1>Citas actualmente registradas</h1>
                    <form name="filtrarCitas" action="BusquedaCitasMedicoServlet" method="post">
                        <table>
                            <tr>
                                <td align="right">Fecha<input type="text" maxlength="20" size="20" name="fecha" value="dd/MM/yyyy" onfocus="if(value==='dd/MM/yyyy')value=''"/></td>
                                <td align="right">Hora<input type="text" maxlength="20" size="20" name="hora" value="HH:mm" onfocus="if(value==='HH:mm')value=''"/></td>
                            </tr>
                            <tr>
                                <td align="right">Lugar<input type="text" maxlength="20" size="20" name="lugar"/></td>
                                <td align="right">Paciente<input type="text" maxlength="20" size="20" name="paciente"/></td>
                            </tr>
                        </table>
                        <input type="Submit" value="Buscar">
                    </form>
                    <%
                        if(!citas.isEmpty()){
                        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
                        java.text.DateFormat hf = new java.text.SimpleDateFormat("HH:mm");
                    %>
                <table border="1">
                   <tr>
                       <th>Paciente</th>
                       <th>Fecha</th>
                       <th>Hora</th>
                   </tr>
 <%
            for(Cita c: citas){          
 %>
                  <tr>
                      <td><%= c.getPacientenumSS().getNombre()+" "+c.getPacientenumSS().getApellidos() %></td>
                      <td> <%= c.getFecha() == null ? "-":df.format(c.getFecha()) %> </td>
                      <td> <%= c.getHora() == null ? "-":hf.format(c.getHora()) %> </td>
                  </tr>
  <%
            }
  %>
               </table>  
               <%
                        }else{
               %>
               <h3>NO HAY CITAS EN ESTE MOMENTO PARA MOSTRAR</h3>          
                <% } %>
                </td></tr>
           <jsp:include page="OpcionesMenu/opcionesMedico.jsp" />
    </body>
</html>

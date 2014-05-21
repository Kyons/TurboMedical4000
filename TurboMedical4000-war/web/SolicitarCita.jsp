<%-- 
    Document   : SolicitarCita
    Created on : 04-may-2014, 1:27:47
    Author     : Tomás
--%>

<%@page import="turbomedical4000.ejb.PacienteHasMedicoFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="turbomedical4000.ejb.PacienteHasMedicoFacadeLocal"%>
<%@page import="javax.ejb.EJB"%>
<%@page import="turbomedical4000.entity.Paciente"%>
<%@page import="turbomedical4000.entity.Medico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Paciente</title>
    </head>
    <body>
        <h1>Solicitar cita</h1>
        
        <jsp:include page="OpcionesMenu/aperturaOpcionesPaciente.jsp" />
        <a href="ConsultarCitasServlet">&#8592; Volver</a>
        
        <h2>Solicitar Cita</h2>
        <form name="addCita" action="SolicitarCitaServlet" method="post">
              <table>
                    <tr>
                        <th>N&uacute;mero colegiado:</th>
                        <th>Fecha:</th>
                        <th>Hora:</th>
                        <th>Lugar:</th>
                    </tr>
                    <tr>
                        <%
                         List<Medico> medicos = (List<Medico>) request.getAttribute("medicos");
                        %>
                        <td><select name="numCol">                    
<%
    if (!medicos.isEmpty())
        for (Medico mec: medicos) {
%>
                            <option value="<%= mec.getNumColegiado() %>"><%= mec.getNombre() + " " + mec.getApellidos() %></option>
<%            
        }
%>
                            </select></td>
                        <%--<td><input type="text" name="numCol" value=""></td> --%>
                        <td><input type="text" name="fecha" value="dd/MM/yyyy" onfocus="if(value==='dd/MM/yyyy')value=''"></td>
                        <td><input type="text" name="hora" value="HH:mm" onfocus="if(value==='HH:mm')value=''"></td> 
                        <td><input type="text" name="lugar" value=""></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><input type="submit" name="pedir" value="Pedir Cita"></td>
                    </tr>
                    
            </table>            
      </form>
       
       <jsp:include page="OpcionesMenu/opcionesPaciente.jsp" />
  </body>
</html>

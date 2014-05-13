<%-- 
    Document   : MedicoPacienteList
    Created on : 12-may-2014, 13:12:47
    Author     : Sihame
--%>

<%@page import="turbomedical4000.entity.PacienteHasMedico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medico-Paciente</title>
        <%
            List<PacienteHasMedico> lista = (List<PacienteHasMedico>)request.getAttribute("lista");
        %>
    </head>
    <body>
        <%@ include file="OpcionesMenu/aperturaOpcionesComun.jsp" %>
        
             <tr>
                <th> &nbsp; </th> <td rowspan="7" >
        <h2>Lista de M&eacute;dico Paciente</h2>
        <a href="EditMedicoPacienteServet?do=add">A&ntilde;adir nueva asignaci&oacute;n</a>
        <table border="1">
            <tr>
                <th>Paciente</th>
                <th>M&eacute;dico</th>
                <th>&nbsp;</th>
            </tr>
            <% 
            if(lista != null){
                for(PacienteHasMedico pm : lista){
          
            %>
            <tr>
                <td><%=pm.getPaciente().getNumSS() %></td>
                <td><%=pm.getMedico().getNumColegiado() %></td>
                
                <td><a href="EditMedicoPacienteServet?do=delete&numss=<%=pm.getPaciente().getNumSS()%>&numc=<%=pm.getMedico().getNumColegiado() %>">Borrar</a></td>
            </tr>
            <% 
                }
            } 
            %>
        </table>
            </td> 
               
            </tr>
        
        <%@ include file="OpcionesMenu/opcionesAdministrador.jsp" %>
    </body>
</html>

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
        <form name="filtrarPacMed" action="BusquedaPacienteMedicoServlet" method="post">
            <table>
                <tr>
                    <td align="right">Paciente<input type="text" maxlength="20" size="20" name="paciente"/></td>
                    <td align="right">NumSS<input type="text" maxlength="20" size="20" name="numSS"/></td>
                </tr>
                <tr>
                    <td align="right">M&eacute;dico<input type="text" maxlength="20" size="20" name="medico"/></td>
                    <td align="right">Num Colegiado<input type="text" maxlength="20" size="20" name="numCol"/></td>
                </tr>
            </table>
            <input type="Submit" value="Buscar">
        </form>
        <a href="EditMedicoPacienteServet?do=add">A&ntilde;adir nueva asignaci&oacute;n</a>
        <%
            if(!lista.isEmpty()){
        %>
        <table border="1">
            <tr>
                <th>Num SS</th>
                <th>Paciente</th>
                <th>Num Colegiado</th>
                <th>M&eacute;dico</th>
                <th>&nbsp;</th>
            </tr>
            <% 
                for(PacienteHasMedico pm : lista){
            %>
            <tr>
                <td><%=pm.getPaciente().getNumSS() %></td>
                <td><%=pm.getPaciente().getNombre() %></td>
                <td><%=pm.getMedico().getNumColegiado() %></td>
                <td><%=pm.getMedico().getNombre() %></td>
                
                <td><a href="EditMedicoPacienteServet?do=delete&numss=<%=pm.getPaciente().getNumSS()%>&numc=<%=pm.getMedico().getNumColegiado() %>">Borrar</a></td>
            </tr>
            <% 
                } 
            %>
        </table>
        <% }else{ %>
        <h3>NO HAY ASIGNACIONES QUE MOSTRAR</h3>
        <% } %>
            </td> 
               
            </tr>
        
        <%@ include file="OpcionesMenu/opcionesAdministrador.jsp" %>
    </body>
</html>

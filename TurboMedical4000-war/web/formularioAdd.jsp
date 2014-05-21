<%-- 
    Document   : formularioAdd
    Created on : 14-may-2014, 18:23:14
    Author     : Juan
--%>

<%@page import="turbomedical4000.entity.Tipoformulario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    List<Tipoformulario> tiposFormulario;
    
    tiposFormulario = (List<Tipoformulario>)request.getAttribute("tiposFormulario");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Paciente > Enviar formulario</title>
    </head>
    <body>
        
        <jsp:include page="OpcionesMenu/aperturaOpcionesPaciente.jsp" />
        <a href="ConsultarPerfilUsuarioServlet">&#8592; Volver</a>
        
                <h1>Enviar un formulario de queja, reclamaci&oacute;n, etc.</h1>
                
                <form name="formularioAdd" action="addFormularioServlet" method="post">
                <b><a style="color:red"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
                <table border="1">
                    <tr>
                        <td>Tipo de formulario:</td>
                        <td><select name="idTipoFormulario">                    
<%
    if (tiposFormulario != null)
        for (Tipoformulario tipo: tiposFormulario) {
%>
                            <option value="<%= tipo.getIdTipoFormulario() %>"><%= tipo.getTipo() %></option>
<%            
        }
%>
                        </select></td>
                    </tr><tr>
                        <td>Entrada:</td>
                        <td>
                            <textarea name="entrada" cols="60" rows="10" ></textarea>
                        </td>
                    </tr><tr>
                        <td>
                            <input type="submit" name="enviar" value="Enviar">
                        </td>
                    </tr>
                </table>
                </form>
                
            </td> 
        </tr>
        
        <jsp:include page="OpcionesMenu/opcionesPaciente.jsp" />
            
    </body>
</html>
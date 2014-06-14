<%-- 
    Document   : generadorInformes.jsp
    Created on : 14-may-2014, 20:46:46
    Author     : Juan
--%>

<%@page import="turbomedical4000.entity.Tipoformulario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="ComprobacionesSesion/comprobacionAdministrador.jsp" %>
<%    List<Tipoformulario> tiposFormulario;

    tiposFormulario = (List<Tipoformulario>) request.getAttribute("tiposFormulario");
%>  

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Administrador > Generar informe de formularios</title>
    </head>
    <body>

        <jsp:include page="OpcionesMenu/aperturaOpcionesAdministrador.jsp" />
        <a href="menuAdministrador.jsp">&#8592; Volver</a>        

        <h1>Generar informe de formularios</h1>

        <form name="generadorInformes" action="GenerarInformeServlet" method="post">
            <b><a style="color:red"><%= request.getParameter("msg") != null ? request.getParameter("msg") : ""%></a></b>
            <table border="1">
                <tr>
                    <td>Tipos de formulario a incluir en el informe:</td>
                    <td>  
                        <%-- La siguiente linea se incluye par simplificar el control de que no se seleccione ningún tipo de formulario --%>
                        <input type="hidden" name="idTiposFormulario" value="-1">  
                        <%
                            if (tiposFormulario != null)
                                for (Tipoformulario tipo : tiposFormulario) {
                        %>
                        <input type="checkbox" name="idTiposFormulario" value="<%= tipo.getIdTipoFormulario()%>" checked><%= tipo.getTipo()%><br>
                        <%
                            }
                        %>
                    </td>
                </tr><tr>
                    <td colspan="2">
                        Incluir formularios enviados entre el <input type="text" name="fecha1" value="">
                        y el <input type="text" name="fecha2" value="">
                    </td>
                </tr><tr>
                    <td>
                        <input type="submit" name="generar" value="Generar">
                    </td>
                </tr>
            </table>
        </form>

    </td> 

</tr>


<jsp:include page="OpcionesMenu/opcionesAdministrador.jsp" />

</body>
</html>

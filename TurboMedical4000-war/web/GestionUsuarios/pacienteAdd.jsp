<%-- 
    Document   : pacienteAdd
    Created on : 29-abr-2014, 21:41:41
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../ComprobacionesSesion/comprobacionAdministrador.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Men&uacute; Administrador > Gesti&oacute;n Administradores > Nuevo paciente</title>
    </head>
    <body>

        <jsp:include page="../OpcionesMenu/aperturaOpcionesAdministrador.jsp" />
        <a href="ListaPacientesServlet">&#8592; Volver</a>

        <h1>A&ntilde;adir nuevo paciente</h1>

        <form name="addForm" action="EditPacientesServlet" method="post">
            <input type="hidden" name="do" value="add">
            <b><a style="color:red"><%= request.getParameter("msg") != null ? request.getParameter("msg") : ""%></a></b>
            <table border="1">
                <tr>
                    <td>N&uacute;mero Seguridad Social:</td>
                    <td><input type="text" name="numSS" value=""></td>
                </tr><tr>
                    <td>Nombre:</td>	
                    <td><input type="text" name="nombre" value=""></td>
                </tr><tr>
                    <td>Apellidos:</td>	
                    <td><input type="text" name="apellidos" value=""></td>
                </tr><tr>
                    <td>Fecha nacimient:</td>	
                    <td><input type="text" name="fechaNac" value="dd/MM/yyyy" onfocus="if (value === 'dd/MM/yyyy')
                                    value = ''"></td>
                </tr><tr>
                    <td>DNI:</td>	
                    <td><input type="text" name="dni" value=""></td>
                </tr><tr>
                    <td>Direcci&oacute;n:</td>	
                    <td><input type="text" name="direccion" value=""></td>
                </tr><tr>
                    <td>Localidad:</td>	
                    <td><input type="text" name="localidad" value=""></td>
                </tr><tr>
                    <td>Provincia:</td>	
                    <td><input type="text" name="provincia" value=""></td>
                </tr><tr>
                    <td>Tel&eacute;fono:</td>	
                    <td><input type="text" name="telefono" value=""></td>
                </tr><tr>
                    <td>Contrase&ntilde;a:</td>	
                    <td><input type="password" name="contrasena" value=""></td>
                </tr><tr>
                    <td colspan="2"><input type="submit" name="btnAniadir" value="A&ntilde;adir"></td>
                </tr>      
            </table>
        </form>

    </td> 
</tr>

<jsp:include page="../OpcionesMenu/opcionesAdministrador.jsp" />

</body>
</html>
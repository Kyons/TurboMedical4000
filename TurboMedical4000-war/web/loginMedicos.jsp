<%-- 
    Document   : loginMedicos
    Created on : 11-abr-2014, 0:34:22
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos/estiloBase.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Turbo Medical 4000 - Acceso m&eacute;dicos</title>
    </head>
    <body>
        <img src="img/logo.png" id="cabeceraLogin" />
        <div class="cajaLogin">
            <h3>Acceso m&eacute;dicos</h3>
            <form action="LoginMedicoServlet" method="post">
                Usuario: <input type="text" maxlength="20" size="20" name="usuario"> 
                <br/>
                Contrase&ntilde;a: <input type="password" maxlength="20" size="20" name="contrasena"> 
                <br/>
                <input type="submit" value="Entrar"> 
            </form>
            <b><a style="color:red"><%= request.getParameter("msg") != null ? request.getParameter("msg") : ""%></a></b>
            <br/>
            <a href="loginPacientes.jsp">Acceso pacientes</a> | <a href="loginAdministrador.jsp">Acceso administrador</a>
        </div>
    </body>
</html>

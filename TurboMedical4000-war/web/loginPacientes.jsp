<%-- 
    Document   : loginPacientes
    Created on : 11-abr-2014, 0:33:52
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <h3>Acceso usuarios</h3>
        <form action="LoginPacienteServlet" method="post">
            Usuario: <input type="text" maxlength="20" size="20" name="usuario"> 
            <br/>
            Contrase&ntilde;a: <input type="password" maxlength="20" size="20" name="contrasena"> 
            <br/>
            <input type="submit" value="Entrar"> 
        </form>
        <b><a style="color:red"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
        <br/>
        <br/>
        <a href="loginMedicos.jsp">Acceso m&eacute;dicos</a>
         | <a href="loginAdministrador.jsp">Acceso administrador</a>
    </body>
</html>

<%-- 
    Document   : loginMedicos
    Created on : 11-abr-2014, 0:34:22
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <h3>Acceso médicos</h3>
        <form action="LoginMedicoServlet" method="post">
            Usuario: <input type="text" maxlength="20" size="20" name="usuario"> 
            <br/>
            Contraseña: <input type="password" maxlength="20" size="20" name="contrasena"> 
            <br/>
            <input type="submit" value="Entrar"> 
        </form>
        <b><a style="color:red"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
        <br/>
        <br/>
        <a href="loginPacientes.jsp">Acceso pacientes</a>
         | <a href="loginAdministrador.jsp">Acceso administrador</a>
    </body>
</html>

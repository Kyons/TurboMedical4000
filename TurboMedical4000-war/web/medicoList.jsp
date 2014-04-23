<%-- 
    Document   : medicoList
    Created on : 23-abr-2014, 19:14:12
    Author     : Juan
--%>

<%@page import="turbomedical4000.entity.Medico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    List<Medico> lista;
    
    lista = (List<Medico>)request.getAttribute("lista");
%>   

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menú de administrador</h1>
        
        <table width="100%" border="1" cellspacing="0" >
              
            <tr>
                <th> &nbsp; </th> <td rowspan="5" >
                
                    
                    <h1>Lista de M&eacute;dicos</h1>
                    <a href="">A&ntilde;adir nuevo m&eacute;dico</a>
        <table border="1">
            <tr>
                <th>Numero colegiado</th>
                <th>Especialidad</th>                  
                <th>Nombre</th>                
                <th>Apellidos</th>                
                <th>Fecha Nacimiento</th>                
                <th>DNI</th>                
                <th>Direcci&oacute;n</th>                
                <th>Localidad</th>
                <th>Provincia</th>
                <th>Tel&eacute;fono</th>
                <th>&nbsp;</th>
            </tr>
<%
    if (lista != null)
        for (Medico medico: lista) {
%>
            <tr>
                <td><%= medico.getNumColegiado() %></td>
                <td><%= medico.getEspecialidadidEspecialidad().getDescripcion() %></td>
                <td><%= medico.getNombre() %></td>                
                <td><%= medico.getApellidos() %></td>                
                <td><%= medico.getFechaNac() %></td>                
                <td><%= medico.getDni() %></td>                                
                <td><%= medico.getDireccion() %></td>                          
                <td><%= medico.getLocalidad() %></td>
                <td><%= medico.getProvincia() %></td>
                <td><%= medico.getTelefono() %></td>
                <td><a href="" >Editar</a>
                    <a href="" >Borrar</a></td>
            </tr>

<%            
        }
%>            
       </table>   
                   </td> 
               
            </tr>
            <tr>
                <td>Perfil</td>
            </tr>
            <tr>
                <td><a href="ListaMedicosServlet">M&eacute;dicos</a></td>
            </tr>
            <tr>
                <td><a href="ListaPacientesServlet">Pacientes</a></td>
            </tr>
            <tr>
                <td><a href="ListaAdministradoresServlet">Administradores</a></td>
            </tr>
            <tr>
                <td>Formularios</td>
            </tr>
        </table>
        </br>
        Cerrar sesi&oacute;n
    </body>
</html>

<%-- 
    Document   : MedicoPacienteAdd
    Created on : 12-may-2014, 17:43:51
    Author     : Sihame
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../ComprobacionesSesion/comprobacionAdministrador.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A&ntilde;adir M&eacute;dico Paciente</title>
    </head>
    <body>
          <jsp:include page="../OpcionesMenu/aperturaOpcionesAdministrador.jsp" />
          <a href="ListaMedicoPaciente">&#8592; Volver</a>
          
        <h2>Lista de M&eacute;dico Paciente</h2>
        
         <form name="add" action="EditMedicoPacienteServet" method="post">
              
                
                <table border="1">
                    <tr>
                        <td>Paciente</td>
                        <td><input type="text" name="paciente" value=""></td>
                    </tr><tr>		
                        <td>M&eacute;dico</td>	
                        <td><input type="text" name="medico" value=""></td>
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

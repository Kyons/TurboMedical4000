<%-- 
    Document   : ConsultarAleras
    Created on : 15-may-2014, 19:55:50
    Author     : Tomás
--%> 
 
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="turbomedical4000.entity.Alertas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alertas del paciente</title>
        <%
             List<Alertas> alert = (List<Alertas>) request.getAttribute("alerta");
  	%>
    </head>
    <body>
         <jsp:include page="OpcionesMenu/aperturaOpcionesPaciente.jsp" />
                    <h2>Lista de Alertas</h2>
              <table border="1">
                   <tr>
                       <th>Fecha</th>
                       <th>Hora</th>
                       <th>Descripci&oacute;n</th>
                       <th>Medico</th>
                   </tr>
 <%
            if(alert!=null){
                java.text.DateFormat dfFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
                java.text.DateFormat dfHora = new java.text.SimpleDateFormat("00:00:00");
                for(Alertas al: alert){             
 %>
                  <tr>
                      <td> <%= dfFecha.format(al.getFechaAlerta()) %> </td>
                      <td> <%= dfHora.format(al.getHora()) %> </td>
                      <td> <%= al.getTexto() %> </td>
                      <td> <%= al.getNumColegiado() %> </td>
                  </tr>
  <%
                }  
            }
            else{
  
                    PrintWriter out2 = response.getWriter();
                    try {
                        out2.println("<h1>No hay Alertas para listar actualmente</h1>");
                    } finally {            
                        out.close();
                    }
                         
            }
  %>
               </table>  
                </td></tr>

             <jsp:include page="OpcionesMenu/opcionesPaciente.jsp" />      
        
    </body>
</html>

<%-- 
    Document   : ConsultarRecomendaciones
    Created on : 16-may-2014, 6:33:46
    Author     : Tomás
--%>

<%@page import="java.util.List"%>
<%@page import="turbomedical4000.entity.Recomendaciones"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recomendaciones del paciente</title>
        <%
             List<Recomendaciones> recom = (List<Recomendaciones>) request.getAttribute("reco");
  	%>
    </head>
    <body>
         <jsp:include page="OpcionesMenu/aperturaOpcionesPaciente.jsp" />
                    <h2>Lista de Recomendaciones</h2>
              <table border="1">
                   <tr>
                       <th>Fecha</th>
                       <th>Hora</th>
                       <th>Descripci&oacute;n</th>
                       <th>Medico</th>
                   </tr>
 <%
            if(recom!=null){
                java.text.DateFormat dfFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
                java.text.DateFormat dfHora = new java.text.SimpleDateFormat("00:00:00");
                for(Recomendaciones re: recom){             
 %>
                  <tr>
                      <td> <%= dfFecha.format(re.getFechaReco()) %> </td>
                      <td> <%= dfHora.format(re.getHora()) %> </td>
                      <td> <%= re.getTexto() %> </td>
                      <td> <%= re.getNumColegiado() %> </td>
                  </tr>
  <%
                }  
            }
            else{
  
                    PrintWriter out2 = response.getWriter();
                    try {
                        out2.println("<h1>No hay Recomendaciones para listar actualmente</h1>");
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

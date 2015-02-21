<%@page import="datos.*"%>
<%-- 
    Document   : guardar
    Created on : 10-07-2014, 03:35:25 PM
    Author     : alphyon
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int d;
            Mantenimiento mt = new Mantenimiento();
            tablaprueba tp = new tablaprueba();
            tp.setApellido(request.getParameter("a"));
            tp.setEmail(request.getParameter("e"));
            tp.setNombre(request.getParameter("n"));

            d = mt.Insertar(tp.getNombre(), tp.getApellido(), tp.getEmail());

            if (d == 1) {
                out.print("Guardado");
            } else {
                out.print("No Guardado");
            }

        %>

    </body>
</html>

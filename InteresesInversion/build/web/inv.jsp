<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            double resultado[][];
            resultado = (double[][]) request.getAttribute("resultado");
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>año</th>
                    <th>intereses del año</th>
                    
                    <th>intereses acumulados</th>
                    <th>capital</th>
                </tr>
            </thead>
            <tbody>
                <%
                    DecimalFormat ft = null;
                    ft = new DecimalFormat("0.00");
                    for (int i = 0; i < resultado.length; i++) {
                %>
                <tr>
                    <td><%=i%></td>
                    <td><%=ft.format(resultado[i][0])%></td>
                    <td><%=ft.format(resultado[i][1])%></td>
                    <td><%=ft.format(resultado[i][2])%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

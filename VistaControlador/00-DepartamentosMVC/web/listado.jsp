<%@page import="MisClases.Departamentos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de departamentos</title>
    </head>
    <body>
    <center>
        <h2>Listado de departamentos</h2>
        <table border="2">
            <tr>
                <th>Departamento</th>
                <th>Nombre</th>
                <th>Localidad</th>
            </tr>
            <%
                ArrayList listadep = (ArrayList) request.getAttribute("departamentos");
                if (listadep != null) 
                    for (int i = 0; i < listadep.size(); i++) {
                        Departamentos d = (Departamentos) listadep.get(i);
                        %>
                        <tr>
                            <td><%=d.getDeptno()%></td>
                            <td><%=d.getDnombre()%></td>
                            <td><%=d.getLoc()%></td>
                        </tr>
                        <%}
            %>
        </table>
        <br/><br/>
        <a href="index.html">Inicio</a>
    </center>
</body>
</html>

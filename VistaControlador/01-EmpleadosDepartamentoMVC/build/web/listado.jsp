<%@page import="MisClases.Oficios"%>
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
                <th>Oficio</th>
                <th>Empleados</th>
            </tr>
            <%
                ArrayList lista = (ArrayList) request.getAttribute("oficios");
                if (lista != null) 
                    for (int i = 0; i < lista.size(); i++) {
                        Oficios o = (Oficios) lista.get(i);
                        %>
                        <tr>
                            <td><%=o.getOf()%></td>
                            <td><%=o.getTrab()%></td>
                        </tr>
                        <%}
            %>
        </table>
        <br/><br/>
        <a href="index.html">Inicio</a>
    </center>
</body>
</html>

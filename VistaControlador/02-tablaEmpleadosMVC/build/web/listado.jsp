<%@page import="MisClases.Empleados"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de empleados</title>
    </head>
    <body>
    <center>
        <h2>Listado de empleados</h2>
        <table border="2">
            <tr>
                <th>Id</th>
                <th>Apellido</th>
                <th>Oficio</th>
                <th>Dir</th>
                <th>Fecha de alta</th>
                <th>Salario</th>
                <th>Comisión</th>
                <th>Departamento</th>
            </tr>
            <%
                ArrayList listaemp = (ArrayList) request.getAttribute("empleados");
                if (listaemp != null) 
                    for (int i = 0; i < listaemp.size(); i++) {
                        Empleados e = (Empleados) listaemp.get(i);
                        %>
                        <tr>
                            <td><%=e.getEmpno()%></td>
                            <td><%=e.getApellido()%></td>
                            <td><%=e.getOficio()%></td>
                            <td><%=e.getDir()%></td>
                            <td><%=e.getFecha_alt()%></td>
                            <td><%=e.getSalario()%></td>
                            <td><%=e.getComision()%></td>
                            <td><%=e.getDnombre()%></td>
                        </tr>
                        <%}
            %>
        </table>
        <br/><br/>
        <a href="index.html">Inicio</a>
    </center>
</body>
</html>

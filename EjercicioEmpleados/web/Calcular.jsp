<%-- 
    Document   : calcular
    Created on : 22 mar 2024, 18:15:01
    Author     : DANIELTEJERIZOMORETÓ
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="misclases.Constructor"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta</title>
    </head>
    <body>
        <h1>Consulta</h1>

        <%
            Connection conexion = null;
            ArrayList<Constructor> empleados = new ArrayList<>();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/daniel", "Daniel", "Daniel");

                Statement statement = conexion.createStatement();
                ResultSet result = statement.executeQuery("Select emp_no, apellido, salario , dept_no from empleados where salario < (select avg(salario) as media from empleados)");

                while (result.next()) {
                    int num_empleados = result.getInt("emp_no");
                    String apellido = result.getString("apellido");
                    double salario = result.getDouble("salario");
                    int numero_departamento = result.getInt("dept_no");

                    Constructor constructor = new Constructor(num_empleados, apellido, salario, numero_departamento);
                    empleados.add(constructor);
                }

                session.setAttribute("empleados", empleados);

                out.println("<table border='1'>");
                out.println("<tr><th>Numero empleados</th><th>Apellido</th><th>Salario</th><th>Numero departamento</th></tr>");

                for (Constructor constructor : empleados) {
                    out.println("<tr>");
                    out.println("<td>" + constructor.getNum_empleado() + "</td>");
                    out.println("<td>" + constructor.getApellido() + "</td>");
                    out.println("<td>" + constructor.getSalario() + "</td>");
                    out.println("<td>" + constructor.getNum_departamento() + "</td>");
                    out.println("</tr>");
                }

                out.println("</table>");

                result.close();
                statement.close();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        %>

        <br>
        <a href="Modif.jsp">Modificar</a>
    </body>
</html>

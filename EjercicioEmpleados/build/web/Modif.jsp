<%-- 
    Document   : Modifcacion
    Created on : 22 mar 2024, 18:56:22
    Author     : DANIELTEJERIZOMORETÓ
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="misclases.Constructor"%>
<%@page import="misclases.Constructor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificación</title>
    </head>
    <body>
        <h1>Modificación</h1>

        <%
            ArrayList<Constructor> empleados = (ArrayList<Constructor>) session.getAttribute("empleados");
            ArrayList<Constructor> modificacion = new ArrayList<>();
            Connection conexion = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/daniel", "Daniel", "Daniel");

                double salarioIncrementado = 0;
                double inc = 0;
                Statement MediaStatement = conexion.createStatement();
                ResultSet MediaResult = MediaStatement.executeQuery("SELECT AVG(salario) AS media FROM empleados");
                if (MediaResult.next()) {
                    double media = MediaResult.getDouble("media");
                    salarioIncrementado = media * 1.20;
                    inc = media * 0.20;
                }
                MediaResult.close();
                MediaStatement.close();

                PreparedStatement updateStatement = conexion.prepareStatement("UPDATE empleados SET salario = salario * 1.20 WHERE salario < ?");
                updateStatement.setDouble(1, salarioIncrementado);
                updateStatement.executeUpdate();
                updateStatement.close();
             

                Statement statement = conexion.createStatement();
                ResultSet result = statement.executeQuery("Select emp_no, apellido, salario , dept_no from empleados where salario < (select avg(salario) as media from empleados)");
                while (result.next()) {
                    int num_empleados = result.getInt("emp_no");
                    String apellido = result.getString("apellido");
                    double salario = result.getDouble("salario");
                    int numero_departamento = result.getInt("dept_no");

                    Constructor constructor = new Constructor(num_empleados, apellido, salario, numero_departamento);
                    modificacion.add(constructor);
                }

                out.println("<table border='1'>");
                out.println("<tr><th>Numero empleados</th><th>Apellido</th><th>Salario</th><th>Numero departamento</th></tr>");

                for (Constructor constructor : modificacion) {
                    out.println("<tr>");
                    out.println("<td>" + constructor.getNum_empleado() + "</td>");
                    out.println("<td>" + constructor.getApellido() + "</td>");
                    out.println("<td>" + constructor.getSalario() + "</td>");
                    out.println("<td>" + constructor.getNum_departamento() + "</td>");
                    out.println("</tr>");
                }

                out.println("</table>");

                out.println("<p> El salario inrementado es: " + inc + "</p>");

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
        <a href="index.jsp">Volver al inicio</a>
    </body>
</html>

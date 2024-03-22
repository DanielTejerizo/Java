<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de departamentos</title>
    </head>
    <!-- Form de entrada de datos e insercion en el javaBean-clase Departamentos -->
    <jsp:useBean id="depart" scope="request" class="MisClases.Departamentos"/>
    <jsp:setProperty name="depart" property="*"/>
    <%
        if (request.getParameter("deptno") != null) {%>
    <jsp:forward page="/Controlador?accion=editamiento"/>
    <%}%>
    <body>
    <center>
        <h1>Entrada de datos de departamentos</h1>
        <br/>
        <form method="post">
            <p>Número de departamento: <input name="deptno" type="text" size="5"></p>
            <p>Nombre: <input name="dnombre" type="text" size="15"></p>
            <p>Localidad: <input name="loc" type="text" size="15"></p>
            <input type="submit" name="editamiento" value="Editar departamento">
            <input type="reset" name="cancelar" value="Vaciar campos">
        </form>
        <br>
        <a href="index.html">Inicio</a>
    </center>
</body>
</html>

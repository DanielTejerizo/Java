<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Baja de departamentos</title>
    </head>

    <jsp:useBean id="depart" scope="request" class="MisClases.Departamentos"/>
    <jsp:setProperty name="depart" property="*"/>
    <%
        if (request.getParameter("deptno") != null) {%>
    <jsp:forward page="/Controlador?accion=eliminar"/>
    <%}%>
    <body>
    <center>
        <h1>Datos del departamento a eliminar</h1>
        <br/>
        <form method="post">
            <p>Número de departamento: <input name="deptno" type="text" size="5"></p>
            <input type="submit" name="eliminar" value="Eliminar departamento">
            <input type="reset" name="borrar" value="Vaciar campos">
        </form>
        <a href="index.html">Inicio</a>
    </center>
</body>
</html>
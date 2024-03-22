<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Baja de empleados</title>
    </head>
    
    <jsp:useBean id="emple" scope="request" class="MisClases.Empleados"/> 
    <jsp:setProperty name="emple" property="*"/>
    
    <%
        if (request.getParameter("empno") != null) {%>
    <jsp:forward page="/Controlador?accion=borramiento"/>
    <%}%>
    <body>
    <center>
        <h1>Entrada de datos de empleado</h1>
        <br/>
        <form method="post">
            <p>ID: <input name="empno" type="number" size="5"></p>
            <input type="submit" name="borrar" value="Borrar empleado">
            <input type="reset" name="cancelar" value="Vaciar campos">
        </form>
        <br>
        <a href="index.html">Inicio</a>
    </center>
</body>
</html>

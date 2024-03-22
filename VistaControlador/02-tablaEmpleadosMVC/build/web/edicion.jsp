<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edición de empleados</title>
    </head>
    
    <jsp:useBean id="emple" scope="request" class="MisClases.Empleados"/> 
    <jsp:setProperty name="emple" property="*"/>
    
    <%
        if (request.getParameter("apellido") != null) {%>
    <jsp:forward page="/Controlador?accion=editamiento"/>
    <%}%>
    <body>
    <center>
        <h1>Edición de datos de empleado</h1>
        <br/>
        <form method="post">
            <p>ID: <input name="empno" type="number" size="5"></p>
            <p>Apellido: <input name="apellido" type="text" size="15"></p>
            <p>Oficio: <input name="oficio" type="text" size="15"></p>
            <p>Dir: <input name="dir" type="number" size="5"></p>
            <p>Salario: <input name="salario" type="number" size="5"></p>
            <p>Comisión: <input name="comision" type="number" size="5"></p>
            <p>Departamento: <input name="deptno" type="number" size="15"></p>
            <input type="submit" name="Editar" value="Editar empleado">
            <input type="reset" name="Cancelar" value="Vaciar campos">
        </form>
        <br>
        <a href="index.html">Inicio</a>
    </center>
</body>
</html>

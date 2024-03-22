
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Contador de Aplicación</title>
    </head>
    <body>
        
        <%
            Integer contador = (Integer) pageContext.getAttribute("contador", pageContext.APPLICATION_SCOPE);
            if (contador == null) {
                contador = new Integer(1);
            }else{
                contador = contador + 1;
            }
            pageContext.setAttribute("contador", contador, pageContext.APPLICATION_SCOPE);
        %>
    <center>
        <h1>Contador de Aplicación</h1>
        <p>Contador: <%= contador%></p>
        <a href="./index.jsp">Inicio</a>
    </center>

</body>
</html>
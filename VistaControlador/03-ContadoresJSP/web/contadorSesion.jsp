
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contador de sesión</title>
    </head>
    <body>
        <%
            Integer contador = (Integer) pageContext.getAttribute("contador", pageContext.SESSION_SCOPE);
            if (contador == null) {
                contador = new Integer(1);
            }else{
                contador = contador + 1;
            }
            pageContext.setAttribute("contador", contador, pageContext.SESSION_SCOPE);
        %>
    <center>
        <h1>Contador de Sesión</h1>
        <p>Contador: <%= contador %></p>

        <a href="./index.jsp">Inicio</a>
  
    </center>

</body>
</html>

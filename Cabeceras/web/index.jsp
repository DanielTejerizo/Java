<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Lecturas de cabeceras de la petición</h1>
        <hr>
        <h2>Usando un enlace - Método get</h2>
        <a href="/Cabeceras/CabecerasServlet">Ver las cabeceras</a>
        <br><br>
        <hr>
        <br><br>
        <h2>Usando un formulario - Método post</h2>
        <form action="/Cabeceras/CabecerasServlet" method="post">
            <label>Nombre:</label> <br>
            <input type="text" name="nombre" value="" size="20" /> <br>
            <br><br>
            <input type="submit" value="enviar"/>
        </form>
    </body>
</html>

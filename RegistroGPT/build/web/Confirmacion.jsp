<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmación de Registro</title>
</head>
<body>
    <h1>Confirmación de Registro</h1>
    <p>Gracias por registrarte, <%= request.getParameter("nombre") %>!</p>
    <p>Tu dirección de correo electrónico es: <%= request.getParameter("email") %></p>
    <p>¡Tu registro ha sido exitoso!</p>
</body>
</html>

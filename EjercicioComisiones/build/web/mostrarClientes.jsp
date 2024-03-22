<%@page import="java.util.ArrayList"%>
<%@page import="misclases.Comision"%>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de departamentos</title>
</head>
<body>
    <center>
        <h2>Listado de departamentos</h2>
        <table border="2">
            <tr>
                <th>ID Cliente</th>
                <th>Nombre</th>
                <th>Categoría</th>
            </tr>
            <% 
            ArrayList<Comision> listaComision = (ArrayList<Comision>) request.getAttribute("departamentos");
            if (listaComision != null) {
                for (Comision comision : listaComision) {
            %>
            <tr>
                <td><%= comision.getIdCliente() %></td>
                <td><%= comision.getNombre() %></td>
                <td><%= comision.getCategoria() %></td>
            </tr>
            <% 
                }
            } 
            %>
        </table>
        <br/><br/>
        <a href="index.html">Inicio</a>
    </center>
</body>
</html>




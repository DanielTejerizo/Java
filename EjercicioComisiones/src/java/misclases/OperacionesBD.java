package misclases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OperacionesBD {

    public Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/daniel", "Daniel", "Daniel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public ArrayList listarDep() {
    ArrayList com = new ArrayList();
    try {
        Connection conexion = getConnection();
        if (conexion != null) {
            System.out.println("Conexión establecida correctamente.");

            Statement sentencia = conexion.createStatement();
            String sql = "SELECT c.IDCLIENTE, c.CNOMBRE, c.CATEGORIA"
                    + "FROM CLIENTE c "
                    + "JOIN ENCARGOS e ON c.IDCLIENTE = e.IDCLIENTE "
                    + "JOIN VENDEDORES v ON c.IDVENDEDOR = v.IDVENDEDOR "
                    + "WHERE c.CUENTAPORPAGAR < "
                    + "    (SELECT AVG(CUENTAPORPAGAR) "
                    + "     FROM CLIENTE "
                    + "     WHERE CATEGORIA = c.CATEGORIA)"
                    + "AND v.COMISION > 0.12 "
                    + "GROUP BY c.IDCLIENTE;";
            System.out.println("SQL: " + sql);

            ResultSet resul = sentencia.executeQuery(sql);
            while (resul.next()) {
                
                Comision c = new Comision(
                
                resul.getString("IDCLIENTE"),
                resul.getString("CNOMBRE"),
                resul.getInt("CATEGORIA")
                );
                
                com.add(c);
            }
            conexion.close();
        } else {
            System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return com;
}



}

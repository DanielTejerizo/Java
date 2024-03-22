package MisClases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OperacionesBD {

    //Obtener la conexión
    public Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//Cargar el driver
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/angela", "angy", "angy");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public ArrayList empleDepar() {
        ArrayList agrupacion = new ArrayList();
        try {
            Connection conexion = getConnection();
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT COUNT(e.emp_no) AS num, d.dnombre "
                    + "FROM empleados e "
                    + "right JOIN departamentos d ON d.dept_no = e.dept_no "
                    + "GROUP BY d.dnombre";
            ResultSet resul = sentencia.executeQuery(sql);
            while (resul.next()) { //Se crea un array con los datos de los dept
                MisClases.Oficios o = new MisClases.Oficios(
                        resul.getString("dnombre"),
                        resul.getInt("num")
                );
                agrupacion.add(o); //Añadir oficios al array
            }
            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (agrupacion);
    }
}

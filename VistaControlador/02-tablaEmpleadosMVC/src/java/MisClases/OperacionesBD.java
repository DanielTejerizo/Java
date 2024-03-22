package MisClases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OperacionesBD {

    public Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/angela", "angy", "angy");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public ArrayList listarEmp() {
        ArrayList empleados = new ArrayList();
        try {
            Connection conexion = getConnection();
            Statement sentencia = conexion.createStatement();
            String sql = "select e.*, d.dnombre from empleados e, departamentos d WHERE e.dept_no = d.dept_no";
            ResultSet resul = sentencia.executeQuery(sql);
            while (resul.next()) {
                MisClases.Empleados e = new MisClases.Empleados(
                        resul.getInt("emp_no"),
                        resul.getString("apellido"),
                        resul.getString("oficio"),
                        resul.getInt("dir"),
                        resul.getString("fecha_alt"),
                        resul.getDouble("salario"),
                        resul.getDouble("comision"),
                        resul.getInt("dept_no"),
                        resul.getString("dnombre")
                );
                empleados.add(e);
            }
            conexion.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (empleados);
    }
    
    //-----------------Altas----------------\\

    public void insertarEmp(MisClases.Empleados e) {
        try {
            Connection conexion = getConnection();
            Statement sentencia = conexion.createStatement();
            String sql = "INSERT INTO empleados VALUES('"
                    + e.getEmpno() + "','"
                    + e.getApellido() + "','"
                    + e.getOficio() + "','"
                    + e.getDir()
                    + "', current_date(), '"
                    + e.getSalario() + "','"
                    + e.getComision() + "','"
                    + e.getDeptno() + "')";
            if (e.getApellido() != null) {
                sentencia.execute(sql);
            }
            System.out.println("SQL: " + sql);
            conexion.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //-----------------Editar----------------\\
    
    public void editarEmp(MisClases.Empleados e) {
        try {
            Connection conexion = getConnection();
            Statement sentencia = conexion.createStatement();
            String sql = "UPDATE empleados SET apellido='" + e.getApellido() 
                    + "', oficio='" + e.getOficio() 
                    + "', dir=" + e.getDir()
                    + ", salario=" + e.getSalario() 
                    + ", comision=" + e.getComision() 
                    + ", dept_no=" + e.getDeptno() 
                    + " WHERE emp_no=" + e.getEmpno();
            if (e.getEmpno() != 0) {
                sentencia.execute(sql);
            }
            System.out.println("SQL: " + sql);
            conexion.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //-----------------Borrar----------------\\
    
    public void borrarEmp(MisClases.Empleados e) {
        try {
            Connection conexion = getConnection();
            Statement sentencia = conexion.createStatement();
            String sql = "DELETE FROM empleados WHERE emp_no=" + e.getEmpno();
            if (e.getEmpno() != 0) {
                sentencia.execute(sql);
            }
            System.out.println("SQL: " + sql);
            conexion.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

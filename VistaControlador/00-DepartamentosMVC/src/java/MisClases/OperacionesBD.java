
package MisClases;

import MisClases.*;
import java.sql.*;
import java.util.*;

public class OperacionesBD {
   //Obtener la conexión
    public Connection getConnection(){
        Connection conexion=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");//Cargar el driver
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/angela", "angy", "angy");  
        }catch(Exception e){
            e.printStackTrace();
        }
        return conexion;
    }
    
    //Listar - Devuelve un array con la lista de departamentos
    public ArrayList listarDep(){
        ArrayList departamentos = new ArrayList();
        try{
            Connection conexion = getConnection();
            Statement sentencia = conexion.createStatement();
            String sql ="SELECT * FROM departamentos";
            ResultSet resul=sentencia.executeQuery(sql);
            while(resul.next()){ //Se crea un array con los datos de los dept
                MisClases.Departamentos d = new MisClases.Departamentos(
                        resul.getByte("dept_no"),
                        resul.getString("dnombre"),
                        resul.getString("loc")
                );
                departamentos.add(d); //Añadir dept al array
            }
            conexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return(departamentos);
    }
    
    //Insertar - Recibe los datos del departamento a insertar en la tabla
    public void insertaDepartamento(MisClases.Departamentos d){
        try{
            Connection conexion = getConnection();
            Statement sentencia = conexion.createStatement();
            String sql = "INSERT INTO departamentos VALUES('"
                    + d.getDeptno()+"','"+d.getDnombre()+"','"+d.getLoc()+"')";
            if(d.getDeptno()!=0)sentencia.execute(sql);
            System.out.println("SQL: "+sql);
            conexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Eliminar - Recibe los datos del departamento a eliminar en la tabla
    public void eliminaDepartamento(MisClases.Departamentos d){
        try{
            Connection conexion = getConnection();
            Statement sentencia = conexion.createStatement();
            String sql = "DELETE FROM departamentos WHERE dept_no = " + d.getDeptno();
            String sql1 = "DELETE FROM empleados WHERE dept_no = " + d.getDeptno();
            if(d.getDeptno()!=0)sentencia.execute(sql);
            if(d.getDeptno()!=0)sentencia.execute(sql1);
            System.out.println("SQL: "+sql);
            System.out.println("SQL: "+sql1);
            conexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Editar - Recibe los datos del departamento a editar en la tabla
    public void editaDepartamento(MisClases.Departamentos d){
        try{
            Connection conexion = getConnection();
            Statement sentencia = conexion.createStatement();
            String sql = "UPDATE departamentos SET dnombre='" 
                    + d.getDnombre()+"', loc='"+d.getLoc()+"' WHERE dept_no= "+ d.getDeptno();
            if(d.getDeptno()!=0)sentencia.execute(sql);
            System.out.println("SQL: "+sql);
            conexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

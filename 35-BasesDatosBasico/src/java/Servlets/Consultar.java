package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Consultar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet cdr = null;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url_BD = "jdbc:mysql://localhost:3306/jl";
            String usuario_BD = "jl";
            String clave_BD = "jl";

            conexion = java.sql.DriverManager.getConnection(url_BD, usuario_BD, clave_BD);

            String consulta = "select * from departamentos";
            sentenciaSQL = conexion.createStatement();
            cdr = sentenciaSQL.executeQuery(consulta);
            out.println("<!DOCTYPE html>");
            out.println("<html>"); 
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"estilos/estilos.css\">");
            out.println("<title>35-BasesDatosBasico - Base de datos (I)</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>35-BasesDatosBasico - Base de datos (I)</h1><hr />");

            out.println("<table border=\"2\">");
            out.println("<tr bgcolor='red'>");
            out.println("<td><b>Nº DEPT</b></td>");
            out.println("<td><b>NOMBRE</b></td>");
            out.println("<td><b>LOCALIDAD</b></td>");
            out.println("</tr>");

            int i=0;

            while (cdr.next()) {
                if(i%2==0)
                    out.println("<tr>");
                else
                    out.println("<tr bgcolor='yellow'>");
                i++;
                
                out.println("<td>");
                out.println(cdr.getInt("dept_no"));
                out.println("</td>");

                out.println("<td>");
                out.println(cdr.getString("dnombre"));
                out.println("</td>");

                out.println("<td>");
                out.println(cdr.getString("loc"));
                out.println("</td>");

                out.println("</tr>");
            }
            out.println("</table>");

            out.println("<hr /><a href='"+request.getContextPath()+"/index.jsp'>Inicio</a>");
            out.println("</body>");
            out.println("</html>");

            if (cdr != null) {
                cdr.close();
            }
            if (sentenciaSQL != null) {
                sentenciaSQL.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

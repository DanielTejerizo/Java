/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DAW
 */
public class EjercicioDida extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejercicio Didáctico</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ejercicio Didáctico</h1>");

            String method = request.getMethod();
            if (method.equals("GET")) {
                out.println("<h2>Accedo desde el enlace - método get</h2>");
                out.println("<br><b>P1:</b>" + request.getParameter("p1"));
                out.println("<br><b>P2:</b>" + request.getParameter("p2"));
                out.println("<br><b>P3:</b>" + request.getParameter("p3"));

            } else if (method.equals("POST")) {
                String nombre = request.getParameter("nombre");
                String apellidos = request.getParameter("apellidos");
                String edad = request.getParameter("edad");

                out.println("<h2>Accedo desde el formulario - método post</h2>");
                out.println("<b>Nombre: " + nombre + "</b><br>");
                out.println("<b>Apellidos: " + apellidos + "</b><br>");
                out.println("<b>Edad: " + edad + "</b><br>");

                String[] ciudades = null;
                ciudades = request.getParameterValues("ciudad");
                if (ciudades != null) {
                    for (int i = 0; i < ciudades.length; i++) {
                        out.println("<br><b>Ciudad: " + ciudades[i]);
                    }
                }
            }
            out.println("<br><hr><br>");
            out.println("<h2>Recuperamos los nombres de los parámetros</h2>");
            Iterator<String> it = request.getParameterMap().keySet().iterator();
            // bucle de recorrido de la lista de los parámetros
            while (it.hasNext()) {
                String nombreParametro = (String) it.next();
                out.println("<b>nombre del parámetro: </b>");
                out.println(nombreParametro + "<br>");
                out.println("<b>valores del parámetro: </b>");
                String[] valoresParametro = (String[]) request.getParameterMap().get(nombreParametro);
                for (String valorParametro : valoresParametro) {
                    out.println(valorParametro);
                    out.println(", ");
                }
                out.println("<br>");
            }

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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

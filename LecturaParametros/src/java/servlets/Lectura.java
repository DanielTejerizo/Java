/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Enumeration;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DAW
 */
public class Lectura extends HttpServlet {

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
            out.println("<title>Servlet Lectura</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<hr>");
            // recuperación de un parámetro único por su nombre
            out.println("apellidos: ");
            out.println(request.getParameter("apellidos"));
            out.println("<br>");
            out.println("nombre: ");
            out.println(request.getParameter("nombre"));
            out.println("<br>");
            // recuperación de valores múltiples de un parámetro
            String[] aficiones = null;
            aficiones = request.getParameterValues("aficiones");
            out.println("aficiones:");
            for (String aficion : aficiones) {
                out.println(aficion + " ");
            }
            out.println("<hr>");
            out.println("<br>");
            // recuperación de los nombres de los parámetros
            Enumeration parametros = null;
            out.println("lista de los nombres de los parámetros");
            out.println("<br>");
            parametros = request.getParameterNames();
            while (parametros.hasMoreElements()) {
                out.println(parametros.nextElement());
            }
            out.println("<hr>");
            out.println("<br>");
            // recuperación de los nombres de los parámetros
            out.println("lista de los parámetros sin saber el nombre");
            out.println("<br>");
            // recuperación de un iterador sobre las claves
             Iterator it = request.getParameterMap().keySet().iterator();
            // bucle de recorrido de la lista de los parámetros
            while (it.hasNext()) {
                String nombreParametro = (String) it.next();
                out.println("nombre del parámetro: ");
                out.println(nombreParametro);
                out.println("valores del parámetro:");
                String[] valoresParametro = (String[]) request.getParameterMap().
                        get(nombreParametro);
                for (String valorParametro : valoresParametro) {
                    out.println(valorParametro);
                    out.println(";");
                }
                out.println("<br>");
            }
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

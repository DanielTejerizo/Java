
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"estilos/estilos.css\">");
            out.println("<title>09-ParametrosInicializacion - Lectura de los parámetros de inicialización</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>09-ParametrosInicializacion - Lectura de los parámetros de inicialización</h1><hr />");
            
            out.println("<h2>Conociendo los nombres de los parámetros</h2>");
            out.println("<br /><b>Modelo:</b> " + getInitParameter("modelo")); //Los parametros estan en WEB-IND/web.xml
            out.println("<br /><b>Marca:</b> " + getInitParameter("marca"));
            
            //No es necesario conocer los nombres de los parámetros de inicialización
            out.println("<h2>Sin conocer los nombres de los parámetros</h2>");
            Enumeration nombres = getInitParameterNames();
            String n;
            while(nombres.hasMoreElements()){
                n = nombres.nextElement().toString();
                out.println("<br /><b>Nombre del parámetro:</b> " + n);
                out.println(" - <b>Valor del parámetro:</b> " + getInitParameter(n));
            }
            
            out.println("</body>");
            out.println("</html>");
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

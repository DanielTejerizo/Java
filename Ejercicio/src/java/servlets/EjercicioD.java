package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EjercicioD")
public class EjercicioD extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MiServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<hr>");

            
            out.println("nombre: ");
            out.println(request.getParameter("nombre"));
            out.println("<br>");
            out.println("apellidos: ");
            out.println(request.getParameter("apellidos"));
            out.println("<br>");
            out.println("edad: ");
            out.println(request.getParameter("edad"));
            out.println("<br>");
            
            String[] ciudad = null;
            ciudad = request.getParameterValues("aficiones");
            out.println("aficiones:");
            for (String ciudades : ciudad) {
                out.println(ciudad + " ");
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
    

            out.println("</body>");
            out.println("</html>");
        }
    }


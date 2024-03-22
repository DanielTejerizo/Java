package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cabecera extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nombreCabecera = null;
        Enumeration nombresCabeceras = null;
        Enumeration valoresCabeceras = null;
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LecturaCabeceras</title>");
            out.println("</head>");
            out.println("<body>");
            nombresCabeceras = request.getHeaderNames();
            out.println("<table border=\"1\" cellpadding=\"10\">");
            out.println("<tbody>");
            while (nombresCabeceras.hasMoreElements()) {
                nombreCabecera = (String) nombresCabeceras.nextElement();
                out.println("<tr>");
                out.println("<td>" + nombreCabecera + "</td>");
                valoresCabeceras = request.getHeaders(nombreCabecera);
                while (valoresCabeceras.hasMoreElements()) {
                    out.println("<td>"
                            + valoresCabeceras.nextElement() + "</td>");
                }
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("<br>");
            out.println("</body>");
            out.println("</html>");
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

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoURL extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Información sobre URL</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("nombre del servidor (getServerName): ");
            out.println(request.getServerName());
            out.println("<br>");
            out.println("número de puerto del servidor (getServerPort): ");
            out.println(request.getServerPort());
            out.println("<br>");
            out.println("nombre de la aplicación en el servidor(getContextPath): ");
            out.println(request.getContextPath());
            out.println("<br>");
            out.println("identificación del servlet (getServletPath): ");
            out.println(request.getServletPath());
            out.println("<br>");
            out.println("método http (getMethod): ");
            out.println(request.getMethod());
            out.println("<br>");
            out.println("parámetros pasados en la petición(getQueryString): ");
            out.println(request.getQueryString());
            out.println("<br>");
            out.println("URL completa (getRequestURL): ");
            out.println(request.getRequestURL());
            out.println("<br>");
            out.println("dirección IP del servidor (getLocalAddr): ");
            out.println(request.getLocalAddr());
            out.println("<br>");
            out.println("nombre del servidor (getLocalName): ");
            out.println(request.getLocalName());
            out.println("<br>");
            out.println("puerto de recepción de la petición (getLocalPort): ");
            out.println(request.getLocalPort());
            out.println("<br>");
            out.println("dirección IP del cliente (getRemoteAddr): ");
            out.println(request.getRemoteAddr());
            out.println("<br>");
            out.println("nombre de la máquina cliente (getRemoteHost): ");
            out.println(request.getRemoteHost());
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

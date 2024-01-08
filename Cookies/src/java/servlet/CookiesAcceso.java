package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesAcceso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"estilos/estilos.css\">");
            out.println("<title>Contador de Accesos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Contador de Accesos</h1><hr />");

            // Obtener el contador actual de las cookies
            int contadorAccesos = 0;
            Cookie[] listaCookies = request.getCookies();
            if (listaCookies != null) {
                for (Cookie cookie : listaCookies) {
                    if ("contadorAccesos".equals(cookie.getName())) {
                        contadorAccesos = Integer.parseInt(cookie.getValue());
                        break;
                    }
                }
            }

            // Incrementar el contador
            contadorAccesos++;

            // Guardar el nuevo contador en una cookie
            Cookie cookieContador = new Cookie("contadorAccesos", String.valueOf(contadorAccesos));
            cookieContador.setMaxAge(365 * 24 * 60 * 60); // Cookie válida por un año
            response.addCookie(cookieContador);

            // Mostrar el contador en la página
            out.println("<p>Accesos totales: " + contadorAccesos + "</p>");

            out.println("<hr />");
            out.println("<a href='/Cookies/index.html'>Volver</a>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Contador de Accesos";
    }
}

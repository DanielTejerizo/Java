import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculadora extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String num1S = request.getParameter("num1");
            String num2S = request.getParameter("num2");
            String operacion = request.getParameter("operacion");


            int num1 = Integer.parseInt(num1S);
            int num2 = Integer.parseInt(num2S);
            int resultado = 0;

            switch (operacion) {
                case "sumar":
                    resultado = num1 + num2;
                    break;
                case "restar":
                    resultado = num1 - num2;
                    break;
                case "multiplicar":
                    resultado = num1 * num2;
                    break;
                case "dividir":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        out.println("Error: Division por 0.");
                        return;
                    }
                    break;
                default:
                    out.println("Error");
                    return;
            }


            out.println("<h1>El resultado de la  " + operacion + " es:</h1>");
            out.println("<p>" + num1 + " " + operacion + " " + num2 + " = " + resultado + "</p>");
        } catch (NumberFormatException e) {

            response.getWriter().println("Error.");
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
        return "Servlet for basic calculator operations";
    }
}

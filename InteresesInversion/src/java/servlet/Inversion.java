package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inversion extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
 PrintWriter out = response.getWriter();
        try {
            int duracion;
            double capital;
            double interes;
            duracion = Integer.parseInt(request.getParameter("duracion"));
            capital = Double.parseDouble(request.getParameter("capital"));
            interes = Double.parseDouble(request.getParameter("interes"));
            double resultado[][];
            resultado = new double[duracion + 1][3];
            resultado[0][0] = 0;
            resultado[0][1] = 0;
            resultado[0][2] = capital;
            for (int i = 1; i <= duracion; i++) {
                resultado[i][2] = resultado[i - 1][2] * (1 + (interes / 100));
                resultado[i][1] = resultado[i][2] - capital;
                resultado[i][0] = resultado[i - 1][2] * (interes / 100);
            }
            RequestDispatcher rd = null;
            rd = getServletContext().getRequestDispatcher("/inv0.jsp");
            request.setAttribute("resultado", resultado);
            rd.forward(request, response);
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

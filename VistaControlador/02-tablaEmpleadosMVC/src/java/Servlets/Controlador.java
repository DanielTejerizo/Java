
package Servlets;

import MisClases.OperacionesBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
             String op=request.getParameter("accion");
             
             if (op.equals("listado")){
                OperacionesBD operBD=new OperacionesBD();
                ArrayList lista = operBD.listarEmp(); 
                request.setAttribute("empleados", lista);
                RequestDispatcher rd=request.getRequestDispatcher("/listado.jsp");
                rd.forward(request, response);
            
             }
             
             //-----------------Altas----------------\\
            
             if (op.equals("alta")){
                 response.sendRedirect("altas.jsp");
             }
            
            if (op.equals("insertar")){
                MisClases.Empleados emp = (MisClases.Empleados)request.getAttribute("emple");
                OperacionesBD operBD=new OperacionesBD();
                operBD.insertarEmp(emp);
                response.sendRedirect("index.html");
             }
            
            //-----------------Edición----------------\\
            
            if (op.equals("edicion")){
                response.sendRedirect("edicion.jsp");
            }
            
            if (op.equals("editamiento")){
                MisClases.Empleados emp = (MisClases.Empleados)request.getAttribute("emple");
                OperacionesBD operBD=new OperacionesBD();
                operBD.editarEmp(emp);
                response.sendRedirect("index.html");
             }
            
            
            //-----------------Borrar----------------\\
            
            if (op.equals("baja")){
                response.sendRedirect("bajas.jsp");
            }
            
            if (op.equals("borramiento")){
                MisClases.Empleados emp = (MisClases.Empleados)request.getAttribute("emple");
                OperacionesBD operBD=new OperacionesBD();
                operBD.borrarEmp(emp);
                response.sendRedirect("index.html");
             }
            
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

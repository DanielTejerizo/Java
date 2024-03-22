
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import MisClases.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

public class Controlador extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //parametro accion se obtiene la url de index.html, puede ser alta o listado
            String op=request.getParameter("accion");
            
            //Si se ha pulsado en alta se visualiza la pantalla de alta
            if(op.equals("alta"))response.sendRedirect("altas.jsp");
            
            //Si se ha pulsado en editar se visualiza la pantalla de alta
            if(op.equals("edicion"))response.sendRedirect("modificaciones.jsp");
            
            //Si se ha pulsado en bajas se visualiza la pantalla de bajas
            if(op.equals("baja"))response.sendRedirect("bajas.jsp");
            
            /*Si se ha pulsado en listado primero se cargan los datos de departamentos
            en una lista y luego se envian a listado.jsp*/
            if(op.equals("listado")){
                OperacionesBD operBD=new OperacionesBD();
                ArrayList lista = operBD.listarDep(); //Carga los datos de los departamentos
                request.setAttribute("departamentos", lista);//Se prepara para enviar al jsp
                RequestDispatcher rd=request.getRequestDispatcher("/listado.jsp");
                rd.forward(request, response);
            }
            
            //Se inserta departamento en la tabla y luego se visualiza index.html
            if(op.equals("insertar")){
                MisClases.Departamentos dep=(MisClases.Departamentos)request.getAttribute("depart");//obtener depts
                OperacionesBD operbd=new OperacionesBD();
                operbd.insertaDepartamento(dep);//Se insertan en la tabla departamentos
                response.sendRedirect("index.html");//Se muestra la pagina inicial
                
            }
            
            //Se elimina departamento en la tabla y luego se visualiza index.html
            if(op.equals("eliminar")){
                MisClases.Departamentos dep=(MisClases.Departamentos)request.getAttribute("depart");//obtener depts
                OperacionesBD operbd=new OperacionesBD();
                operbd.eliminaDepartamento(dep);//Elimina el departamento
                response.sendRedirect("index.html");//Se muestra la pagina inicial
                
            }
            
            //Se modifica departamento en la tabla y luego se visualiza index.html
            if(op.equals("editamiento")){
                MisClases.Departamentos dep=(MisClases.Departamentos)request.getAttribute("depart");//obtener depts
                OperacionesBD operbd=new OperacionesBD();
                operbd.editaDepartamento(dep);//Se edita en la tabla departamentos
                response.sendRedirect("index.html");//Se muestra la pagina inicial
                
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

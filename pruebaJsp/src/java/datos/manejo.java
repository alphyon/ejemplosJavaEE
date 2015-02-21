package datos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alphyon
 */
@WebServlet(name = "manejo", urlPatterns = {"/manejo"})
public class manejo extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet manejo</title>");            
            out.println("</head>");
            out.println("<body>");
            String op = request.getParameter("op");
            int d;
            Mantenimiento mt = new Mantenimiento();
            tablaprueba tp = new tablaprueba();
            switch(op){
                case "guardar":
                     /////////////////////////////////////////////////
            
            
            tp.setApellido(request.getParameter("a"));
            tp.setEmail(request.getParameter("e"));
            tp.setNombre(request.getParameter("n"));
            
            d = mt.Insertar(tp.getNombre(),tp.getApellido(), tp.getEmail());
            
            
            if(d == 1){
                out.print("Guardado");
            }else{
                out.print("No Guardado");
            }
            
            ///////////////////////////////////////////////////////
                    break;
                    
                case "borrar":
                    String n = request.getParameter("id");
                    d = mt.Eliminar(Integer.parseInt(n));
                    
                     if(d == 1){
                out.print("Eliminado");
            }else{
                out.print("No Eliminado");
            }
                    
                    break;
            }
            
            
           
            out.println("</body>");
            out.println("</html>");
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

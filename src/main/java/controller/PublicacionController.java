package controller;

import database.PublicacionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Publicacion;


@WebServlet(name = "PublicacionController", urlPatterns = {"/publicacion/*"})
public class PublicacionController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            
            response.setContentType("text/html;charset=UTF-8");            
        
        try ( PrintWriter out = response.getWriter()) {
                        
            String action = request.getPathInfo();
            PublicacionDAO pdao = new PublicacionDAO();
            HttpSession session = request.getSession();            
            ArrayList<Publicacion> publicaciones;
            Publicacion actualPub;
            String username = (String) session.getAttribute("actualUsername");
            String modelo;
            String descripcion;
            String cilindrada;
            String urlfoto;
            int regs_afectados;
                        
            switch (action) {
                    
                case "/publicar":                    
                    
                    modelo = request.getParameter("modelo");                    
                    cilindrada = request.getParameter("cilindrada");
                    
                    if( pdao.getPubByUsernameModeloCilindrada(username,modelo,cilindrada) == null){                                              
                        urlfoto = request.getParameter("urlfoto");                    
                        descripcion = request.getParameter("descripcion");
                        
                        actualPub = new Publicacion(username,descripcion,cilindrada,modelo,urlfoto);                        
                        regs_afectados = pdao.createPub(actualPub);
                    }
                    else {
                        regs_afectados = 2;
                    }                    
                    session.setAttribute("pCreada", regs_afectados);
                    response.sendRedirect("/motos/views/publicacion/publicacionCreada.jsp");
                    break;
                    
                    
                case "/verPublicaciones":                                   
                    
                    publicaciones = (ArrayList<Publicacion>)pdao.getPubs();                    
                    session.setAttribute("publicaciones",publicaciones);                    
                    response.setContentType("ArrayList");
                    response.sendRedirect("/motos/views/publicacion/publicaciones.jsp");
                                        
                    break;                
                                   
                case "/publicaciones":                                   
                     
                    publicaciones = (ArrayList<Publicacion>) pdao.getPubsByUsername(username);            
                    request.setAttribute("publicaciones", publicaciones);       
                    response.sendRedirect("/motos/views/publicacion/publicaciones.jsp");
                    break;   
//                
//                case "/logoutUser":
//                    session.setAttribute("isLogin", false)
//                    session.setAttribute("actualUsername", "");
//                    response.sendRedirect("/motos/");
//                    break;
//                    
                
//                case "/deleteUser":
//                    username = (String) session.getAttribute("actualUsername");
//                    
//                    if(udao.getBorrable(username)){
//                        regs_afectados = udao.deleteUser(username);
//                        session.setAttribute("isLogin", false);
//                        session.setAttribute("actualUsername", "");
//                    }
//                    response.sendRedirect("/motos/");
//                    break;
//                
//                case "/updateUser":
//                    username = (String) session.getAttribute("actualUsername");
//                    password = request.getParameter("password");
//                    name = request.getParameter("name");
//                    last_name = request.getParameter("last_name");
//                    email = request.getParameter("email");
//                    actualUser = new Usuario(username, password, name, last_name, email);
//                    regs_afectados = udao.updateUser(actualUser);
//                    
//                    session.setAttribute("actualUser", actualUser);
//                    response.sendRedirect("/motos/views/edicion.jsp");
//                    
//                    break;
                
                default:
                    break;
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PublicacionController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PublicacionController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

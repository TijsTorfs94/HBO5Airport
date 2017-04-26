/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author c1040604
 */
@WebServlet(name = "ZoekServlet", urlPatterns = {"/ZoekServlet"})
public class ZoekServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
           
        } finally {
            out.close();
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
//        if (request.getParameter("Login") != null) {
//            CheckLogin();
//        }
        
        
        
        
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
    Connection conn;
    ResultSet rs = null;
    CallableStatement stored_pro = null;
    
    private void CheckLogin(){
        MakeConnection();
        try {
            stored_pro = conn.prepareCall("{call SPLOGINSELECT(?,?}");
            
        } catch (SQLException ex) {
            Logger.getLogger(ZoekServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    private void MakeConnection(){
        
      
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE","c1035462","7086");
            
        } catch (SQLException ex) {
            Logger.getLogger(ZoekServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
   
    
    }
    
    
    
    
    
}

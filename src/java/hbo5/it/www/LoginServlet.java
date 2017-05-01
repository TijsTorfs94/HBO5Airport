/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author steve
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            if (request.getParameter("login") != null){
           CheckLogin("steve","i");
           
            }
       else if (request.getParameter("registreer")!= null){
           
       }
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
   public  Boolean CheckLogin( String name, String Passwoord ){
        MakeConnection();
        Boolean hasResult = false;
        try {
            stored_pro = conn.prepareCall("{call CHKLOGIN(?,?)}");
            stored_pro.setString(1, name);
            stored_pro.setString(2, Passwoord);
            hasResult =  stored_pro.execute();
            System.out.println(hasResult);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ZoekServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasResult;
  
    }
    
    private void MakeConnection(){
        
      
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE","c1035462","7086");
            
        } catch (SQLException ex) {
            Logger.getLogger(ZoekServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
   
    
    } 
}
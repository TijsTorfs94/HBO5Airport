/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.dataaccess.DAPersoon;
import hbo5.it.www.dataaccess.DAVliegtuig;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author steve
 */
@WebServlet(name = "VliegtuigServlet", urlPatterns = {"/VliegtuigServlet"},
        initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE"),
    @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver"),
    @WebInitParam(name = "login", value = "c1035462"),
    @WebInitParam(name = "password", value = "7086")})
public class VliegtuigServlet extends HttpServlet {



     private DAVliegtuig davliegtuig = null;
    @Override
    public void init() throws ServletException {
        try {
            String url = getInitParameter("url");
            String password = getInitParameter("password");
            String login = getInitParameter("login");
            String driver = getInitParameter("driver");
            if ( davliegtuig == null) {
                davliegtuig = new DAVliegtuig(url, login, password, driver);
            }
        }catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
    }

    
    @Override
    public void destroy() {
        try {
            if ( davliegtuig != null) {
                davliegtuig.close();
            }
        } catch (SQLException e) {
        }}
  
    RequestDispatcher rd;
    HttpSession session = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
             rd = request.getRequestDispatcher("overzichtvliegtuigen.jsp");
         rd.forward(request, response);
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
        session = request.getSession();
        session.setAttribute("Varvliegtuig",request.getParameter("LstVliegtuigen"));
        request.setAttribute("Vliegtuig",davliegtuig.Getvliegtuiginfo((String)session.getAttribute("Varvliegtuig")));
        request.getRequestDispatcher("overzichtvliegtuigen.jsp").forward(request, response);
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

  }

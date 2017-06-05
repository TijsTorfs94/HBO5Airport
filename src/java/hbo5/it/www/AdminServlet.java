/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Crew;
import hbo5.it.www.beans.Hangar;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.dataaccess.DAHangar;
import hbo5.it.www.dataaccess.DALeasemaatschappij;
import hbo5.it.www.dataaccess.DALuchthaven;
import hbo5.it.www.dataaccess.DALuchtvaartmaatschappij;
import hbo5.it.www.dataaccess.DAPassagier;
import hbo5.it.www.dataaccess.DAPersoon;
import hbo5.it.www.dataaccess.DAVliegtuig;
import hbo5.it.www.dataaccess.DAVlucht;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author c1040604
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE"),
    @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver"),
    @WebInitParam(name = "login", value = "c1035462"),
    @WebInitParam(name = "password", value = "7086")})
public class AdminServlet extends HttpServlet {

    
        private DALuchthaven daLuchthaven = null;
        private DALuchtvaartmaatschappij damaatschappij = null;
        private DAPersoon dapersoon = null;
        private DAVliegtuig davliegtuig = null;
        private DAHangar dahangar = null;
        private DALeasemaatschappij dalease = null;
        private DAVlucht davlucht = null;
        private DAPassagier dapassagier = null;
        
        
        
        
    @Override
    public void init() throws ServletException {
        try {
            String url = getInitParameter("url");
            String password = getInitParameter("password");
            String login = getInitParameter("login");
            String driver = getInitParameter("driver");
            if (daLuchthaven == null) {
                daLuchthaven = new DALuchthaven(url, login, password, driver);
            }
            if (damaatschappij == null) {
                damaatschappij = new DALuchtvaartmaatschappij(url, login, password, driver);
            }
            if (dapersoon == null) {
                dapersoon = new DAPersoon(url, login, password, driver);
            }
            if (davliegtuig == null) {
                davliegtuig = new DAVliegtuig(url, login, password, driver);
            }
            if (dahangar == null) {
                dahangar = new DAHangar(url, login, password, driver);
            }
            if (dalease == null) {
                dalease = new DALeasemaatschappij(url, login, password, driver);
            }
            if (davlucht == null){
                davlucht = new DAVlucht(url, login, password, driver);
            }
            if(dapassagier == null){
                dapassagier = new DAPassagier(url, login, password, driver);
            }
        }catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void destroy() {
        try {
            if ( daLuchthaven != null) {
                daLuchthaven.close();
            }
            if (damaatschappij != null) {
                damaatschappij.close();
            }
            if (dapersoon != null){
                dapersoon.close();
            }
            if (davliegtuig != null) {
                davliegtuig.close();
            }
            if (dahangar != null) {
                dahangar.close();
            }
            if (dalease != null) {
                dalease.close();
            }
            if(davlucht != null){
                davlucht.close();
            }
            if (dapassagier != null) {
                dapassagier.close();
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

//              session.setAttribute("lijsthavens",  daLuchthaven.Get_naam_luchtHaven());
//              session.setAttribute("lijstmaatschappijen",damaatschappij.Get_Names());
//              session.setAttribute("lijstpersonen", dapersoon.get_names());
//              session.setAttribute("lijstvliegtuigen",davliegtuig.getList_ids());
//              session.setAttribute("lijstLease",dalease.get_leaseNamen());
   
          
            
        }
         rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
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
              session = request.getSession();
              session.setAttribute("lijstPassagiers",dapassagier.getPassagiers());
              session.setAttribute("lijstVluchten", davlucht.Vluchten());
              session.setAttribute("lijstvluchten", davlucht.Vlucht_ids());
              session.setAttribute("lijsthavens",  daLuchthaven.Get_naam_luchtHaven());
              session.setAttribute("lijstmaatschappijen",damaatschappij.Get_Names());
              session.setAttribute("lijstpersonen", dapersoon.get_names());
              session.setAttribute("lijstvliegtuigen",davliegtuig.getList_ids());
              session.setAttribute("lijstLease",dalease.get_leaseNamen());
   
        if (request.getParameter("btnWijzig")!= null) {
                url="LoginPage.jsp";
            }

            else if (request.getParameter("btnVerwijder") != null) {
                url="LoginPage.jsp";
            }
            else if("luchthavens".equals( request.getParameter("page"))){
                url= "overzichtLuchthavens.jsp";
            }
            else if ("bemanning".equals(request.getParameter("page"))){
                url="overzichtBemanning.jsp";
            }
            else if ("passagiers".equals(request.getParameter("page"))){
                url="overzichtPassagiers.jsp";
            }
             else if ("Leasemaatschappij".equals(request.getParameter("page"))){
                url="overzichtLease.jsp";
            }
             else if ("maatschappij".equals(request.getParameter("page"))){
                url="overzichtMaatschappijen.jsp";
            }
              else if ("vliegtuig".equals(request.getParameter("page"))){
                url="overzichtvliegtuigen.jsp";
            }
             else if ("persoon".equals(request.getParameter("page"))){
                url="overzichtPersonen.jsp";
            }
            
            else if("hangars".equals(request.getParameter("page"))){
                session.setAttribute("lijstHangars", dahangar.Get_Hangars());
                session.setAttribute("lijsthangarnamen", dahangar.get_namen((ArrayList<Hangar>)session.getAttribute("lijstHangars")));
                url = "overzichtHangars.jsp";
            }
            
             else  if ("add".equals(request.getParameter("choice"))){
             if ("lease".equals(request.getParameter("kind"))) {
                 request.setAttribute("topId", dalease.getTopId("Leasemaatschappij"));   
                 request.setAttribute("kind", "lease");
            }
             else if ("haven".equals(request.getParameter("kind"))) {
                request.setAttribute("topId", dalease.getTopId("Luchthaven"));
               
            }
             url="newitem.jsp";
         }
             else if ("update".equals(request.getParameter("choice"))) {
                  if ("lease".equals(request.getParameter("kind"))) {
                url="wijzigitem.jsp";
            }
        }
              else if ("delete".equals(request.getParameter("choice"))) {
                  if ("lease".equals(request.getParameter("kind"))) {
                url="deleteitem.jsp";
            }
        }
             else if (request.getParameter("nieuw") != null) {
            dalease.Add_maatschappij(Integer.parseInt( request.getParameter("txtid")), request.getParameter("txtnaam") );
            url = "StartAdmin.jsp";
        }
             else if (request.getParameter("update") != null) {
            dalease.Update_maatschappij(Integer.parseInt( request.getParameter("txtid")), request.getParameter("txtnaam") );
            url = "StartAdmin.jsp";
        }
             else if(request.getParameter("delete") != null){
                 dalease.DeleteItem("Leasemaatschappij",Integer.parseInt( request.getParameter("txtid")) );
                  url = "StartAdmin.jsp";
             }
             
            else{
                  url="StartAdmin.jsp";
            }
   rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
       // request.getRequestDispatcher(url).forward(request, response);
    }
   String url = null;
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
        session = request.getSession();
         session.setAttribute("VarVlucht", request.getParameter("LstVluchten"));
     Integer id;
        if ("BemVlucht".equals(request.getParameter("choice"))) {
           
            ArrayList<Crew> crewLijst;
            crewLijst = davlucht.Crew_per_vlucht((String)session.getAttribute("VarVlucht"));
            ArrayList<Persoon> persoonlijst;
            persoonlijst = dapersoon.GetPersonen();
            id = davlucht.vluchtID((String) session.getAttribute("VarVlucht"),(ArrayList<Vlucht>)session.getAttribute("lijstVluchten"));
            if (crewLijst.size() > 0) {
                request.setAttribute("Bemanning", crewLijst);
            }
            else{
                request.setAttribute("Bemanning", null );
            }
            
            url = "overzichtBemanning.jsp";
        }
        else if("PasVlucht".equals(request.getParameter("choice"))){
                id = davlucht.vluchtID((String) session.getAttribute("VarVlucht"),(ArrayList<Vlucht>)session.getAttribute("lijstVluchten"));
                ArrayList<Passagier> pasLijst;
                pasLijst = (ArrayList<Passagier>) session.getAttribute("lijstPassagiers");
                        if (pasLijst.size() > 0) {
                          request.setAttribute("Passagiers",davlucht.pervlucht(id,pasLijst,dapersoon));
                        }
                        else{
                            request.setAttribute("Passagiers", null);
                        }
                  url = "overzichtPassagiers.jsp";
        }
        else if ("Hangar".equals(request.getParameter("choice"))){
            request.setAttribute("VarHangar", request.getParameter("LstHangar"));
            request.setAttribute("Hangar", dahangar.get_byName((ArrayList<Hangar>) session.getAttribute("lijstHangars"),(String) request.getAttribute("VarHangar")));
            request.setAttribute("InhoudHangar", davliegtuig.Get_by_Hangar((String) request.getAttribute("VarHangar")));
            url="overzichtHangars.jsp";
        }
        else if ("Haven".equals(request.getParameter("choice"))){
        session.setAttribute("VarLuchthaven", request.getParameter("LstHaven"));
        request.setAttribute("Luchthaven", daLuchthaven.getLuchthaven((String)session.getAttribute("VarLuchthaven")));
        url = "overzichtLuchthavens.jsp";
        }
        else if ("maatschappij".equals(request.getParameter("choice"))){
        session.setAttribute("Varmaatschappij",request.getParameter("LstMaatschappij"));
        request.setAttribute("Maatschappij",damaatschappij.getMaatschappij((String) session.getAttribute("Varmaatschappij")) );
        url="overzichtMaatschappijen.jsp";
        }
         else if ("Leasemaatschappij".equals(request.getParameter("choice"))){
          session = request.getSession();
       // session.setAttribute("VarLease",request.getParameter("LstLease"));
        request.setAttribute("VarLeasemaatschappij", dalease.get_maatschappij(request.getParameter("LstLease")));
        url="overzichtLease.jsp";
        }
         else if ("Vliegtuig".equals(request.getParameter("choice"))){
          session = request.getSession();
          session.setAttribute("Varvliegtuig",request.getParameter("LstVliegtuigen"));
          request.setAttribute("Vliegtuig",davliegtuig.Getvliegtuiginfo((String)session.getAttribute("Varvliegtuig")));
          url="overzichtvliegtuigen.jsp";
        }
        else if ("Persoon".equals(request.getParameter("choice"))){
        session.setAttribute("Varpersoon",request.getParameter("LstPersonen"));
        request.setAttribute("Persoon",dapersoon.GetPersoonByname((String) session.getAttribute("Varpersoon")) );
        url="overzichtPersonen.jsp";
        }
  
        
        
      
          request.getRequestDispatcher(url).forward(request, response);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.ZoekServlet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import org.jboss.logging.Logger;

/**
 *
 * @author c1040604
 */
public class DAPersoon {
        private final Connection connection = null;

public DAPersoon(String url, String login, String password, String driver)   throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conn = DriverManager.getConnection(url, login, password);
    }
    
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }  
    }
    
    Connection conn;
    CallableStatement SP = null;
    
    public Boolean CheckLogin(String name, String Pass){
        
        Boolean result = false;
        try {
            SP = conn.prepareCall("{call chklogin(?,?)}");
            SP.setString("p_pers_login", name);
            SP.setString("p_pers_pas", Pass);
            result = SP.execute();
        } catch (SQLException e) {
          //  Logger.getLogger(ZoekServlet.class.getName()).log(Level.SEVERE,null);
        }
        
        
        
        
        
        
        return result;
    }

}

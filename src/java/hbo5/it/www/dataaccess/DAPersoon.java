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
import java.sql.Types;
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
        conn  = DriverManager.getConnection(url, login, password);
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
            
//            SP = conn.prepareCall("{CALL CHK_LOGIN(?,?)}");
//            
//            SP.setString(1, name);
//            SP.setString(2, Pass);
           // SP.registerOutParameter(0, Types.BOOLEAN);
         //  result = SP.execute();
           // result = SP.getBoolean(0);
           
           SP = conn.prepareCall(" ? := begin CHK_LOGIN(?,?); end;");
 
           SP.registerOutParameter(1, Types.BOOLEAN);          
           SP.setString(2, name);
           SP.setString(3, Pass);
           
           SP.executeUpdate();
           result = SP.getBoolean(1);
           
           
           
           
           
           
           
           
           
        } catch (SQLException e) {
          //  Logger.getLogger(ZoekServlet.class.getName()).log(Level.SEVERE,null);
        }
        
        
        
        
        
        
        return result;
    }
    
    
    

    

}

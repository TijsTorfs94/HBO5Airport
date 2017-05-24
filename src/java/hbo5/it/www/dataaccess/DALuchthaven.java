/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vlucht;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author c1040604
 */




public class DALuchthaven {
       private Connection connection = null;

       
        Connection conn;
        Luchthaven L = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        Integer res ;
       
public DALuchthaven (String url, String login, String password, String driver)   throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, login, password);
    }
    
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }  
    }
    
    public ArrayList<String> Get_naam_luchtHaven(){        ArrayList<String> Lijst= null;
         try {
          statement = conn.prepareStatement("select naam  from Luchthaven");
          set = statement.executeQuery();
                  if (set.next()) {
                   Lijst.add(set.getString("naam"));
                  }
         
        }
  catch (Exception e) {
    }
            return  Lijst;
              
            
        }
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
 


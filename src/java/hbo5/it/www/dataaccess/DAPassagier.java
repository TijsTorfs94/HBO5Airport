/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Passagier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

/**
 *
 * @author c1040604
 */
public class DAPassagier {
        private Connection connection = null;

public DAPassagier (String url, String login, String password, String driver)   throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, login, password);
    }
    
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }  
    }
    Connection conn;
    PreparedStatement statement = null;
    ResultSet set = null;
    
    public ArrayList<Passagier> getPassagiers (){
        ArrayList<Passagier> Lijst = new ArrayList<>();
        
        try {
              statement = connection.prepareStatement("select * from passagier");
              set = statement.executeQuery();
                while (set.next()) {            
                    Passagier P = new Passagier();
                    P.setId(set.getInt(1));
                    P.setIngeschreven(set.getInt(2));
                    P.setIngecheckt(set.getInt(3));
                    P.setKlasse_id(set.getInt(4));
                    P.setPlaats(set.getString(5));
                    P.setVlucht_id(set.getInt(6));
                    P.setPersoon_id(set.getInt(7));
                    Lijst.add(P);
                }
        } catch (Exception e) {
        }
      return Lijst;
        
    }
    
}

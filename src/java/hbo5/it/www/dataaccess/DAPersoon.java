/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import hbo5.it.www.ZoekServlet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import oracle.sql.DATE;
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
    
    public Integer CheckLogin(String name, String Pass){
        
        Integer result = 0;
        try {
           
           // string query = 
            
            
            
            
           SP = conn.prepareCall(" ? := begin CHK_LOGIN(?,?); end;");       
           SP.setString(2, name);
           SP.setString(3, Pass);
           
           SP.execute();
           result = SP.getInt(1);
        } catch (SQLException e) {
             java.util.logging.Logger.getLogger(DAPersoon.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
    
    

    
    
    
    
    public void Add_Persoon( int id,
    String voornaam, String achternaam, String Straat, String nmr,String code, String woonplaats,
            String land,String geboorte, String login, String pas ){
        
//            Timestamp datum = Timestamp.valueOf(geboorte);
//            
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd", Locale.US);
//            Date date = sdf.parse(geboorte);
//            
//            Calendar cal = sdf.getCalendar();
//            
//            
//            
//        
//            try {
//                SP = conn.prepareCall("{call ADD_PERSOON(?,?,?,?,?,?,?,?,?,?,?)}");
//                SP.setInt(1, id);
//                SP.setString(2, voornaam);
//                SP.setString(3, achternaam);
//                SP.setString(4, Straat);
//                SP.setString(5, nmr);
//                SP.setString(6, code);
//                SP.setString(7, woonplaats);
//                SP.setString(8, land);
//                SP.setDate(,date);
//
//                SP.setString(10, login);
//                SP.setString(11, pas);
//               
//                SP.execute();
//                
//                
//            } catch (SQLException ex) {
//                java.util.logging.Logger.getLogger(DAPersoon.class.getName()).log(Level.SEVERE, null, ex);
//            }
        
    }

}

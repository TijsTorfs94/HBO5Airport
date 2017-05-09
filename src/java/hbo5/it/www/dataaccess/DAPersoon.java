/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import hbo5.it.www.ZoekServlet;
import hbo5.it.www.beans.Persoon;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
public int CheckLogin(String Login, String Pass){
        
        
        
        
        
        
        Persoon P = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        
        try {
            statement = conn.prepareStatement
                                ("select * from Persoon where Login = ?");
            statement.setString(1, Login);
            set = statement.executeQuery(); 
            if (set.next()) {
                if( set.getString("PASWOORD").equals(Pass)){
                    
                    P = new Persoon();
                
                P.setFamilienaam(set.getString("FAMILIENAAM"));
                P.setGeboortedatum(set.getTimestamp("GEBOORTEDATUM"));
                P.setHuisnr(set.getString("HUISNR"));
                P.setLand(set.getString("LAND"));
                P.setLogin(set.getString("LOGIN"));
                P.setPaswoord(set.getString("PASWOORD"));
                P.setPostcode(set.getString("postcode"));
                P.setStraat(set.getString("STRAAT"));
                P.setVoornaam(set.getString("VOORNAAM"));
                P.setWoonplaats(set.getString("WOONPLAATS"));
                P.setId(set.getInt("ID"));
return 1;
                }
            }
        }
  catch (Exception e) {
    }
                
        
        return 0;
        
    }
    
}

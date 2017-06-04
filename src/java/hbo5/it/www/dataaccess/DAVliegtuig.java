/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Hangar;
import hbo5.it.www.beans.Leasemaatschappij;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Stockage;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.Vliegtuig_extend;
import hbo5.it.www.beans.Vlucht;
import static java.lang.Integer.parseInt;
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
public class DAVliegtuig {
       private Connection connection = null;

public DAVliegtuig (String url, String login, String password, String driver)   throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, login, password);
    }
    
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }  
    }
    
    PreparedStatement statement = null;
    ResultSet set = null;
    Vliegtuig V;
    
    public ArrayList<Vliegtuig> getVliegtuigLijst(){
        ArrayList<Vliegtuig> lijst = new ArrayList<>();
        try {
                statement = connection.prepareStatement("select * from vliegtuig"  );
                set = statement.executeQuery();   
                while (set.next()) {
                    V = new Vliegtuig();
                    V.setId(set.getInt("ID"));
                    V.setVliegtuigtype_id(set.getInt("vliegtuigType_id"));
                    V.setLeasemaatschappij_id(set.getInt("leasemaatschappij_id"));
                    V.setLuchtvaartmaatschappij_id(set.getInt("Luchtvaartmaatschappij_id"));
                    lijst.add(V);
            }      
        } catch (Exception e) {
        }
        return lijst;
    }

    public ArrayList<Integer> getList_ids(){
        ArrayList<Integer> lijst = new ArrayList<>();
        ArrayList<Vliegtuig> Vlijst = getVliegtuigLijst();
        
        for (Vliegtuig vliegtuig : Vlijst) {
            lijst.add(vliegtuig.getId());
        }
        return lijst;
    }
    
    public Vliegtuig_extend Getvliegtuiginfo(String id){
            Vliegtuig_extend E = new Vliegtuig_extend();
            Integer ID = parseInt(id);
        try {
            
            StringBuilder builder = new StringBuilder();
            builder.append("select t.naam, m.naam, v.LEASEMAATSCHAPPIJ_ID from vliegtuig v ");
            builder.append("inner join vliegtuigtype t on v.VLIEGTUIGTYPE_ID = t.ID ");
            builder.append("inner join LUCHTVAARTMAATSCHAPPIJ m on v.LUCHTVAARTMAATSCHAPPIJ_ID = m.id ");
            builder.append("where v.id = ?");
           
            
            
            
            
            statement = connection.prepareStatement(builder.toString());
            statement.setString(1, id);
            set = statement.executeQuery();   
            while (set.next()){
                String test = set.getString(3);
               E.setType_naam(set.getString(1));
               E.setMaatschappij_naam(set.getString(2));
                if (set.getString(3) != null) {
                    E.setLeased(true);
                }
                else{
                    E.setLeased(false);
                }
               
            }
        } catch (Exception e) {
        }
return E;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import pojo.UserInfo;

/**
 *
 * @author Jamie
 */
public class GetUsers {
    
    private final Connection con;
    
    public GetUsers(ServletContext sc) {
        con = (Connection)sc.getAttribute("dbConnection");      
    }
    
    public ArrayList<UserInfo> getUsers() {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();
            
            ArrayList<UserInfo> data = new ArrayList<>();
            while (rs.next()) {
                String uName = rs.getString("username");
                String uRole = rs.getString("role");
                String fName = rs.getString("name");
                data.add(new UserInfo(uName, uRole, fName));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
}

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author Jamie
 */
public class Login {
    
    private final Connection con;
    private final String username;
    private final String password;

    public Login(String username, String password, ServletContext sc) {
        con = (Connection)sc.getAttribute("dbConnection");
        this.username = username;
        this.password = password;
    }

    public boolean isAdmin(){
        String role = getUser();
        return "admin".equals(role);
    }
    
    public boolean isValidUser(){
        String role = getUser();
        return role != null;
    }
    private String getUser() {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM users WHERE username=?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String pWord = resultSet.getString("password");
                if (password.equals(pWord)) 
                {
                    return resultSet.getString("role");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}

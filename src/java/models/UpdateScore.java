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
 * @author jamie
 */
public class UpdateScore {
    private String username;
    private String score;
    private Connection con;
    
    public UpdateScore(String username, String score, ServletContext sc) {
        this.username = username;
        this.score = score;
        con = (Connection)sc.getAttribute("dbConnection");
    }
    public void updateUserScore(){
        try {
        boolean exists = false;
        PreparedStatement ps = con.prepareStatement("SELECT * FROM scores WHERE susername=?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            exists = true;
        }
        if (exists) {
            ps = con.prepareStatement("UPDATE scores SET sscore=? WHERE susername=?");
            ps.setString(1, score);
            ps.setString(2, username);
        } else {
            ps = con.prepareStatement("INSERT INTO scores (sscore, susername) VALUES (?,?)");
            ps.setString(1, score);
            ps.setString(2, username);
        }
        ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateScore.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
    }
}


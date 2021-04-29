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
import pojo.ScoreInfo;

/**
 *
 * @author jamie
 */
public class GetUserScores {
        private final Connection con;
    
    public GetUserScores(ServletContext sc) {
        con = (Connection)sc.getAttribute("dbConnection");      
    }
    
    public ArrayList<ScoreInfo> getUsersScores() {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM scores");
            ResultSet rs = ps.executeQuery();
            
            ArrayList<ScoreInfo> data = new ArrayList<>();
            while (rs.next()) {
                String sID = rs.getString("sid");
                String sScore = rs.getString("sscore");
                String sUsername = rs.getString("susername");
                data.add(new ScoreInfo(sID, sScore, sUsername));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
}
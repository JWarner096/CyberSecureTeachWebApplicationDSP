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
import pojo.QuestionInfo;

/**
 *
 * @author jamie
 */
public class GetQuestions {
            private final Connection con;
    
    public GetQuestions(ServletContext sc) {
        con = (Connection)sc.getAttribute("dbConnection");      
    }
    
    public ArrayList<QuestionInfo> getQuestions() {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM questions");
            ResultSet rs = ps.executeQuery();
            
            ArrayList<QuestionInfo> data = new ArrayList<>();
            while (rs.next()) {
                String qQuestion = rs.getString("question");
                String qAnswer = rs.getString("answer");
                data.add(new QuestionInfo(qQuestion, qAnswer));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
}

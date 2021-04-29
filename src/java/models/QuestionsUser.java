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
public class QuestionsUser {
    private Connection con;
    public QuestionsUser(ServletContext sc) {
        con = (Connection)sc.getAttribute("dbConnection");
    }
    public String getQuestions() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"questions\":[");
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM questions");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sb.append("{");
                sb.append("\"question\":"+"\""+rs.getString("question")+"\"" + ",");
                sb.append("\"answer\":"+rs.getString("answer"));
                sb.append("},");     
            }
            sb.setLength(sb.length()-1);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }
}

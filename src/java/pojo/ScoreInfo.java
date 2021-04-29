/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author jamie
 */
public class ScoreInfo {
    public final String sID;
    public final String sScore;
    public final String sUsername;

    public ScoreInfo(String sID, String sScore, String sUsername){
        this.sID = sID;
        this.sScore = sScore;
        this.sUsername = sUsername;
    }
}

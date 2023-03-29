package Data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class User {
    String acc, pass;

    public User() {
        connect();
    }

    public User(String acc, String pass) {
        this.acc = acc;
        this.pass = pass;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    Connection cnn; //Ket noi database
    Statement stm; //Thuc hien cau lenh SQL
    ResultSet rs;  //luu tru va xu li du lieu
    PreparedStatement pstm; //Co the thuc hien giong stm
    private void connect() {
        try {
            //Su dung DBContext1
            cnn = (new DBContext()).connection;
            System.out.println("Connect success");
        } catch (Exception e) {
            System.out.println("Connect error: " + e.getMessage());
        }
    }
    
    public boolean checkLogin(String acc, String pass) {
        try {
            String strSelect = "select * from Users "
                    +"where account=? and "
                    +"password=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, acc);
            pstm.setString(2, pass);
            rs= pstm.executeQuery();
            while (rs.next()) {                
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login Error" + e.getMessage());
        }
        return false;
    }
    
    public void insert(String acc, String pass) {
      try {
            String strInsert = "insert into Users "
                    +"VALUES(?, ?) ";
            pstm = cnn.prepareStatement(strInsert);
            pstm.setString(1, acc);
            pstm.setString(2, pass);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }
   
}

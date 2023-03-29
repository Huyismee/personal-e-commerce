/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Question {
    String id, question, a, b, c, d, answer;

    public Question() {
        connect();
    }

    public Question(String id, String question, String a, String b, String c, String d, String answer) {
        this.id = id;
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    Connection cnn; //Ket noi database
    Statement stm; //Thuc hien cau lenh SQL
    ResultSet rs;  //luu tru va xu li du lieu
    PreparedStatement pstm; //Co the thuc hien giong stm

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            System.out.println("Connect success");
        } catch (Exception e) {
            System.out.println("Connect error: " + e.getMessage());
        }
    }
    
     public Question getQuestionById(String input) {
        Question q = new Question();
        try {
            String strSelect = "select * from Question where Id = ?";
            pstm = cnn.prepareStatement(strSelect);
                pstm.setString(1, input);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String ques = rs.getString(2);
                String a = rs.getString(3);
                String b = rs.getString(4);
                String c = rs.getString(5);
                String d = rs.getString(6);
                String ans = rs.getString(7);
                
                 q = new Question(id, ques, a, b, c, d, ans);
            }
        } catch (Exception e) {
            System.out.println("Get list user error: " + e.getMessage());
        }
        return q;
    }
}

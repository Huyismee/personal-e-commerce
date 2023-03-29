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
public class Gun {
    String gunId, gunName;

    public Gun() {
        connect();
    }

    public Gun(String gunId, String gunName) {
        this.gunId = gunId;
        this.gunName = gunName;
    }

    public String getGunId() {
        return gunId;
    }

    public void setGunId(String gunId) {
        this.gunId = gunId;
    }

    public String getGunName() {
        return gunName;
    }

    public void setGunName(String gunName) {
        this.gunName = gunName;
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
    
    public ArrayList<Gun> getListGun() {
        ArrayList<Gun> list = new ArrayList<Gun>();
        try {
            String strSelect = "select * from Gun";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String gunId = rs.getString(1);
                String gunName = rs.getString(2);
                
                Gun g = new Gun(gunId, gunName);
                list.add(g);
            }
        } catch (Exception e) {
            System.out.println("Get list user error: " + e.getMessage());
        }
        return list;
    }
}

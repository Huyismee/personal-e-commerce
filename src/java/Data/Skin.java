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
public class Skin {

    String id, name, description, img, video, backgrImg;

    public Skin() {
        connect();
    }

    public Skin(String id, String name, String description, String img, String video) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.video = video;
    }

    public Skin(String id, String name, String description, String img, String video, String backgrImg) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.video = video;
        this.backgrImg = backgrImg;
    }

    public String getBackgrImg() {
        return backgrImg;
    }

    public void setBackgrImg(String backgrImg) {
        this.backgrImg = backgrImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
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

    public ArrayList<Skin> getListSkin() {
        ArrayList<Skin> list = new ArrayList<Skin>();
        try {
            String strSelect = "Select * from Skin";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                String img = rs.getString(4);
                String video = rs.getString(5);
                String backgrImg = rs.getString(6);
                Skin p = new Skin(id, name, des, img, video, backgrImg);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("Get list user error: " + e.getMessage());
        }
        return list;
    }

    public Skin getSkinById(String code) {
        Skin p = new Skin();
        try {
            String strSelect = "Select * from Skin where BundleId = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, code);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                String img = rs.getString(4);
                String video = rs.getString(5);
                String backgrImg = rs.getString(6);
                p = new Skin(id, name, des, img, video, backgrImg);
            }
        } catch (Exception e) {
            System.out.println("Get list product error: " + e.getMessage());
        }
        return p;
    }

    public ArrayList<Skin> getListSkinExept(String skinId) {
        ArrayList<Skin> list = new ArrayList<Skin>();
        try {
            String strSelect = "Select * from Skin where BundleId <> ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, skinId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                String img = rs.getString(4);
                String video = rs.getString(5);
                String backgrImg = rs.getString(6);
                Skin p = new Skin(id, name, des, img, video, backgrImg);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("Get list user error: " + e.getMessage());
        }
        return list;
    }

    public void updateCollection(String colId, String colName, String colDes, String colImg, String colVid, String colBackgrImg) {
        try {
            String strUpdate = "update Skin "
                    + "  set BundleName = ?, BundleDescription = ?, img = ?, video = ?, backgrImg =? "
                    + "  where BundleID =?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, colName);
            pstm.setString(2, colDes);
            pstm.setString(3, colImg);
            pstm.setString(4, colVid);
            pstm.setString(5, colBackgrImg);
            pstm.setString(6, colId);
            pstm.execute();
            rs = pstm.executeQuery();
        } catch (Exception e) {
            System.out.println("Update Collection Error: " + e.getMessage());
        }
    }

    public void insertCol(String colName, String colDes, String colImg, String colVid, String colBackgrImg) {
        try {
            String strUpdate = "INSERT INTO Skin"
                    + " VALUES( ?, ?, ?, ?, ?)";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, colName);
            pstm.setString(2, colDes);
            pstm.setString(3, colImg);
            pstm.setString(4, colVid);
            pstm.setString(5, colBackgrImg);
            rs = pstm.executeQuery();
        } catch (Exception e) {
            System.out.println("Update Collection Error: " + e.getMessage());
        }
    }

    public void deleteCollection(String colId) {
        try {
            String strDel = "Delete From Skin where BundleID = ? ";
            pstm = cnn.prepareStatement(strDel);
            pstm.setString(1, colId);
            rs = pstm.executeQuery();
        } catch (Exception e) {
            System.out.println("Delete Collection Error: " + e.getMessage());
        }
    }

}

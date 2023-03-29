package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Shop {

    String itemId, name, edition, price, stock, des, img, video, gunName, bundleName, gunId, bundleId, viewNum;

    public Shop() {
        connect();
    }

    public Shop(String itemId, String name, String edition, String price, String stock, String des, String img, String video, String gunId, String bundleId, String viewNum) {
        this.itemId = itemId;
        this.name = name;
        this.edition = edition;
        this.price = price;
        this.stock = stock;
        this.des = des;
        this.img = img;
        this.video = video;
        this.gunId = gunId;
        this.bundleId = bundleId;
        this.viewNum = viewNum;
    }

    public Shop(String itemId, String name, String edition, String price, String stock, String des, String img, String video, String gunName, String bundleName, String gunId, String bundleId, String viewNum) {
        this.itemId = itemId;
        this.name = name;
        this.edition = edition;
        this.price = price;
        this.stock = stock;
        this.des = des;
        this.img = img;
        this.video = video;
        this.gunName = gunName;
        this.bundleName = bundleName;
        this.gunId = gunId;
        this.bundleId = bundleId;
        this.viewNum = viewNum;
    }

    private Shop(String id, String name, String price, String stock, String img, String gunId) {
        this.itemId = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.img = img;
        this.gunId = gunId;
    }

    public String getGunName() {
        return gunName;
    }

    public void setGunName(String gunName) {
        this.gunName = gunName;
    }

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
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

    public String getGunId() {
        return gunId;
    }

    public void setGunId(String gunId) {
        this.gunId = gunId;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getViewNum() {
        return viewNum;
    }

    public void setViewNum(String viewNum) {
        this.viewNum = viewNum;
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

    public ArrayList<Shop> getListShop() {
        ArrayList<Shop> list = new ArrayList<Shop>();
        try {
            String strSelect = "select itemID, itemName, Edition, price, stock, itemDescription, Shop.img, Shop.video, GunName, BundleName, Shop.BundleID, Shop.GunID, ViewNum from "
                    + "  (Shop inner join Gun on Shop.GunID = gun.GunId) inner join Skin on Shop.BundleID = Skin.BundleID ";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String edition = rs.getString(3);
                String price = rs.getString(4);
                String stock = rs.getString(5);
                String des = rs.getString(6);
                String img = rs.getString(7);
                String video = rs.getString(8);
                String gunName = rs.getString(9);
                String bundleName = rs.getString(10);
                String gunId = rs.getString(11);
                String bundleId = rs.getString(12);
                String viewNum = rs.getString(13);
                Shop p = new Shop(id, name, edition, price, stock, des, img, video, gunName, bundleName, gunId, bundleId, viewNum);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("Get list user error: " + e.getMessage());
        }
        return list;
    }
    
    public ArrayList<Shop> getListShopTopView() {
        ArrayList<Shop> list = new ArrayList<Shop>();
        try {
            String strSelect = "  select itemID, itemName, Edition, price, stock, itemDescription, Shop.img, Shop.video, GunName, BundleName, Shop.BundleID, Shop.GunID, ViewNum from \n" +
"                      (Shop inner join Gun on Shop.GunID = gun.GunId) inner join Skin on Shop.BundleID = Skin.BundleID order by ViewNum DESC";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String edition = rs.getString(3);
                String price = rs.getString(4);
                String stock = rs.getString(5);
                String des = rs.getString(6);
                String img = rs.getString(7);
                String video = rs.getString(8);
                String gunName = rs.getString(9);
                String bundleName = rs.getString(10);
                String gunId = rs.getString(11);
                String bundleId = rs.getString(12);
                String viewNum = rs.getString(13);
                Shop p = new Shop(id, name, edition, price, stock, des, img, video, gunName, bundleName, gunId, bundleId, viewNum);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("Get list user error: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Shop> getListShopExcept(String itemId) {
        ArrayList<Shop> list = new ArrayList<Shop>();
        try {
            String strSelect = "select itemID, itemName, Edition, price, stock, itemDescription, Shop.img, Shop.video, GunName, BundleName, Shop.BundleID, Shop.GunID, ViewNum from "
                    + "  (Shop inner join Gun on Shop.GunID = gun.GunId) inner join Skin on Shop.BundleID = Skin.BundleID where itemId <> ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, itemId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String edition = rs.getString(3);
                String price = rs.getString(4);
                String stock = rs.getString(5);
                String des = rs.getString(6);
                String img = rs.getString(7);
                String video = rs.getString(8);
                String gunName = rs.getString(9);
                String bundleName = rs.getString(10);
                String gunId = rs.getString(11);
                String bundleId = rs.getString(12);
                String viewNum = rs.getString(13);
                Shop p = new Shop(id, name, edition, price, stock, des, img, video, gunName, bundleName, gunId, bundleId, viewNum);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("Get list user error: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Shop> getListItem() {
        ArrayList<Shop> list = new ArrayList<Shop>();
        try {
            String strSelect = "select * from Shop";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String price = rs.getString(4);
                String stock = rs.getString(5);
                String img = rs.getString(7);
                String gunId = rs.getString(9);
                Shop p = new Shop(id, name, price, stock, img, gunId);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("Get list user error: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Shop> getListShopById(String skinid) {
        ArrayList<Shop> list = new ArrayList<Shop>();
        try {
            String strSelect = "select itemID, itemName, Edition, price, stock, itemDescription, Shop.img, Shop.video, GunName, BundleName, Shop.BundleID, Shop.GunID, ViewNum from "
                    + "  (Shop inner join Gun on Shop.GunID = gun.GunId) inner join Skin on Shop.BundleID = Skin.BundleID "
                    + "  Where Shop.BundleID = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, skinid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String edition = rs.getString(3);
                String price = rs.getString(4);
                String stock = rs.getString(5);
                String des = rs.getString(6);
                String img = rs.getString(7);
                String video = rs.getString(8);
                String gunName = rs.getString(9);
                String bundleName = rs.getString(10);
                String bundleId = rs.getString(11);
                String gunId = rs.getString(12);
                String viewNum = rs.getString(13);
                Shop p = new Shop(id, name, edition, price, stock, des, img, video, gunName, bundleName, gunId, bundleId, viewNum);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("Get list user error: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Shop> seachListShop(String input) {
        ArrayList<Shop> list = new ArrayList<Shop>();
        try {
            String strSelect = "  select itemID, itemName, Edition, price, stock, itemDescription, Shop.img, Shop.video, GunName, BundleName, Shop.BundleID, Shop.GunID, ViewNum from \n"
                    + "(Shop inner join Gun on Shop.GunID = gun.GunId) inner join Skin on Shop.BundleID = Skin.BundleID where itemName like ? or GunName like ? or BundleName like ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%"+input+"%");
            pstm.setString(2, "%"+input+"%");
            pstm.setString(3, "%"+input+"%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String edition = rs.getString(3);
                String price = rs.getString(4);
                String stock = rs.getString(5);
                String des = rs.getString(6);
                String img = rs.getString(7);
                String video = rs.getString(8);
                String gunName = rs.getString(9);
                String bundleName = rs.getString(10);
                String bundleId = rs.getString(11);
                String gunId = rs.getString(12);
                String viewNum = rs.getString(13);
                Shop p = new Shop(id, name, edition, price, stock, des, img, video, gunName, bundleName, gunId, bundleId, viewNum);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("Get list user error: " + e.getMessage());
        }
        return list;
    }

    public Shop getItemById(String itemId) {
        Shop p = new Shop();
        try {
            String strSelect = "select itemID, itemName, Edition, price, stock, itemDescription, Shop.img, Shop.video, GunName, BundleName, Shop.BundleID, Shop.GunID, ViewNum from "
                    + "  (Shop inner join Gun on Shop.GunID = gun.GunId) inner join Skin on Shop.BundleID = Skin.BundleID "
                    + "  Where itemId = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, itemId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String edition = rs.getString(3);
                String price = rs.getString(4);
                String stock = rs.getString(5);
                String des = rs.getString(6);
                String img = rs.getString(7);
                String video = rs.getString(8);
                String gunName = rs.getString(9);
                String bundleName = rs.getString(10);
                String gunId = rs.getString(11);
                String bundleId = rs.getString(12);
                String viewNum = rs.getString(13);
                p = new Shop(id, name, edition, price, stock, des, img, video, gunName, bundleName, gunId, bundleId, viewNum);
            }
        } catch (Exception e) {
            System.out.println("Get list user error: " + e.getMessage());
        }
        return p;
    }

    public void updateItem(String itemId, String itemName, String itemEdition, String itemPrice, String itemStock, String itemDes, String itemImg, String itemVid, String itemGunId, String itemBundleId) {
        try {
            String strUpdate = "update Shop\n"
                    + "set itemName = ?, Edition = ?, price = ?, stock = ?, itemDescription =?, img = ?, video = ?, GunID = ?, BundleID = ?\n"
                    + "where itemID =?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, itemName);
            pstm.setString(2, itemEdition);
            pstm.setString(3, itemPrice);
            pstm.setString(4, itemStock);
            pstm.setString(5, itemDes);
            pstm.setString(6, itemImg);
            pstm.setString(7, itemVid);
            pstm.setString(8, itemGunId);
            pstm.setString(9, itemBundleId);
            pstm.setString(10, itemId);
            pstm.execute();
            rs = pstm.executeQuery();
        } catch (Exception e) {
            System.out.println("Update Item Error: " + e.getMessage());
        }
    }

    public void addItem(String itemName, String itemEdition, String itemPrice, String itemStock, String itemDes, String itemImg, String itemVid, String itemGunId, String itemBundleId) {
        try {
            String strUpdate = "INSERT INTO Shop VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, 0)";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, itemName);
            pstm.setString(2, itemEdition);
            pstm.setString(3, itemPrice);
            pstm.setString(4, itemStock);
            pstm.setString(5, itemDes);
            pstm.setString(6, itemImg);
            pstm.setString(7, itemVid);
            pstm.setString(8, itemGunId);
            pstm.setString(9, itemBundleId);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Update Item Error: " + e.getMessage());
        }
    }

    public void deleteItem(String itemId) {
        try {
            String strDel = "Delete From Shop where itemID=?";
            pstm = cnn.prepareStatement(strDel);
            pstm.setString(1, itemId);
            rs = pstm.executeQuery();
        } catch (Exception e) {
            System.out.println("Delete Collection Error: " + e.getMessage());
        }
    }
    
    public void updateView(String id, int view){
        try {
            String strUpdate = "update Shop "
                    + "set ViewNum = ? "
                    + "where itemID = ?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, String.valueOf(view));
            pstm.setString(2, id);
            pstm.execute();
            rs = pstm.executeQuery();
        } catch (Exception e) {
            System.out.println("Update Item Error: " + e.getMessage());
        }
    }
    
    public String formatPrice(double amount){
        Locale locale = new Locale("nv", "VN");      
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String total = currencyFormatter.format(amount);
        return total.substring(0);
    }
}

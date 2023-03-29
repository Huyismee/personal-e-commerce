/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Data.Gun;
import Data.Shop;
import Data.Skin;
import com.sun.swing.internal.plaf.metal.resources.metal;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class EditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("account") == null) {
            System.out.println("What?");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else if (session.getAttribute("account").equals("admin")) {
            String mode = req.getParameter("mode");

            Skin skin = new Skin();
            Shop s = new Shop();
            Gun gun = new Gun();
            ArrayList<Shop> sList = s.getListShop();
            ArrayList<Skin> list = skin.getListSkin();
            ArrayList<Gun> gList = gun.getListGun();
            if (mode != null && mode.equals("3")) {
                String mod = req.getParameter("mod");
                String colId = req.getParameter("id");
                Skin editSkin = skin.getSkinById(colId);
                String name = editSkin.getName();
                String des = editSkin.getDescription();
                String img = editSkin.getImg();
                String video = editSkin.getVideo();
                String backgrImg = editSkin.getBackgrImg();
                req.setAttribute("list", list);
                req.setAttribute("sList", sList);
                req.setAttribute("gList", gList);
                if (mod.equals("0")) {
                    req.setAttribute("colId", colId);
                    req.setAttribute("colName", name);
                    req.setAttribute("colDes", des);
                    req.setAttribute("colImg", img);
                    req.setAttribute("colVid", video);
                    req.setAttribute("colBackgrImg", backgrImg);
                    session.setAttribute("mode", mode);

                    req.getRequestDispatcher("edit.jsp").forward(req, resp);
                } else if (mod.equals("1")) {
                    skin.deleteCollection(colId);
                    req.setAttribute("mode", "1");
                    list = skin.getListSkin();
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("edit.jsp").forward(req, resp);
                }
            }
            if (mode != null && mode.equals("4")) {
                String mod = req.getParameter("mod");
                String itemId = req.getParameter("id");
                Shop shop = s.getItemById(itemId);
                String name = shop.getName();
                String edition = shop.getEdition();
                String price = shop.getPrice();
                String stock = shop.getStock();
                String des = shop.getDes();
                String img = shop.getImg();
                String video = shop.getVideo();
                String gunId = shop.getGunId();
                String bundleId = shop.getBundleId();
                req.setAttribute("list", list);
                req.setAttribute("sList", sList);
                req.setAttribute("gList", gList);
                if (mod.equals("0")) {
                    req.setAttribute("itemId", itemId);
                    req.setAttribute("itemName", name);
                    req.setAttribute("itemEdition", edition);
                    req.setAttribute("itemPrice", price);
                    req.setAttribute("itemStock", stock);
                    req.setAttribute("itemDes", des);
                    req.setAttribute("itemImg", img);
                    req.setAttribute("itemVid", video);
                    req.setAttribute("itemGunId", gunId);
                    req.setAttribute("itemBundleId", bundleId);
                    session.setAttribute("mode", mode);
                    req.getRequestDispatcher("edit.jsp").forward(req, resp);
                } else if (mod.equals("1")) {
                    s.deleteItem(itemId);
                    req.setAttribute("mode", "2");
                    sList = s.getListShop();
                    req.setAttribute("sList", sList);
                    req.getRequestDispatcher("edit.jsp").forward(req, resp);
                }
            } else if (mode != null && mode.equals("1")) {
                list = skin.getListSkin();
                req.setAttribute("list", list);
                sList = s.getListShop();
                req.setAttribute("sList", sList);
                gList = gun.getListGun();
                req.setAttribute("gList", gList);
                req.setAttribute("mode", mode);
                req.getRequestDispatcher("edit.jsp").forward(req, resp);
            } else if (mode != null && mode.equals("2")) {
                sList = s.getListShop();
                req.setAttribute("sList", sList);
                req.setAttribute("mode", mode);
                req.getRequestDispatcher("edit.jsp").forward(req, resp);
            } else {
                list = skin.getListSkin();
                req.setAttribute("list", list);
                req.setAttribute("mode", mode);
                sList = s.getListShop();
                req.setAttribute("sList", sList);
                gList = gun.getListGun();
                req.setAttribute("gList", gList);
                req.getRequestDispatcher("edit.jsp").forward(req, resp);
            }

        } else if (session.getAttribute("account") != null) {
            req.getRequestDispatcher("index1.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Skin skin = new Skin();
        Shop s = new Shop();
        Gun gun = new Gun();

        ArrayList<Shop> sList = s.getListShop();
        ArrayList<Skin> list = skin.getListSkin();
        ArrayList<Gun> gList = gun.getListGun();
        if (req.getParameter("colUpdate") != null) {
            String colId = req.getParameter("colId");
            String name = req.getParameter("colName");
            String des = req.getParameter("colDes");
            String img = req.getParameter("colImg");
            String video = req.getParameter("colVid");
            String backgrImg = req.getParameter("colBackgrImg");
            skin.updateCollection(colId, name, des, img, video, backgrImg);
            list = skin.getListSkin();
            req.setAttribute("list", list);
            req.setAttribute("mode", "1");
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        } else if (req.getParameter("itemUpdate") != null) {
            String itemId = req.getParameter("itemId");
            String name = req.getParameter("itemName");
            String edition = req.getParameter("itemEdition");
            String price = req.getParameter("itemPrice");
            String stock = req.getParameter("itemStock");
            String des = req.getParameter("itemDes");
            String img = req.getParameter("itemImg");
            String video = req.getParameter("itemVid");
            String gunId = req.getParameter("itemGunId");
            String bundleId = req.getParameter("itemBundleId");
            s.updateItem(itemId, name, edition, price, stock, des, img, video, gunId, bundleId);
            sList = s.getListShop();
            req.setAttribute("sList", sList);
            req.setAttribute("mode", "2");
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        } else if (req.getParameter("addCol") != null) {
            String name = req.getParameter("colName");
            String des = req.getParameter("colDes");
            String img = req.getParameter("colImg");
            String video = req.getParameter("colVid");
            String backgrImg = req.getParameter("colBackgrImg");
            skin.insertCol(name, des, img, video, backgrImg);
            list = skin.getListSkin();
            req.setAttribute("list", list);
            req.setAttribute("mode", "1");
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        } else if (req.getParameter("itemAdd") != null) {
            String name = req.getParameter("itemName");
            String edition = req.getParameter("itemEdition");
            String price = req.getParameter("itemPrice");
            String stock = req.getParameter("itemStock");
            String des = req.getParameter("itemDes");
            String img = req.getParameter("itemImg");
            String video = req.getParameter("itemVid");
            String gunId = req.getParameter("itemGunId");
            String bundleId = req.getParameter("itemBundleId");
            s.addItem(name, edition, price, stock, des, img, video, gunId, bundleId);
            sList = s.getListShop();
            req.setAttribute("sList", sList);
            req.setAttribute("mode", "2");
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        } else if (req.getParameter("itemCancel") != null) {
            req.setAttribute("mode", "2");
            sList = s.getListShop();
            req.setAttribute("sList", sList);
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        } else if (req.getParameter("cancelCol") != null) {
            req.setAttribute("mode", "1");
            list = skin.getListSkin();
            req.setAttribute("list", list);
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        }
    }

}

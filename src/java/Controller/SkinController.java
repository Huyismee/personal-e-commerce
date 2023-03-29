/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Data.Shop;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Data.Skin;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class SkinController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute("account") != null) {
                Skin skin = new Skin();
                Shop s = new Shop();
                ArrayList<Shop> sList = s.getListShop();
                ArrayList<Shop> topList = s.getListShopTopView();
                ArrayList<Skin> list = skin.getListSkin();
                req.setAttribute("topList", topList);
                req.setAttribute("list", list);
                req.setAttribute("sList", sList);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else{
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }

        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}

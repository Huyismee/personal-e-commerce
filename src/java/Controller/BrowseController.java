/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Data.Shop;
import Data.Skin;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class BrowseController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Shop s = new Shop();
        ArrayList<Shop> sList = s.getListShop();
        req.setAttribute("sList", sList);
        req.getRequestDispatcher("browse.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Shop s = new Shop();
        String input = req.getParameter("input");
        ArrayList<Shop> sList = s.seachListShop(input);
        req.setAttribute("sList", sList);
        req.getRequestDispatcher("browse.jsp").forward(req, resp);
    }

}

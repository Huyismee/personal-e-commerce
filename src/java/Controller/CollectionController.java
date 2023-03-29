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
public class CollectionController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Skin skin = new Skin();
        Skin bundle = skin.getSkinById(id);
        Shop s = new Shop();
        ArrayList<Shop> sList = s.getListShopById(id);
        ArrayList<Skin> exList = skin.getListSkinExept(id);
        req.setAttribute("exList", exList);
        req.setAttribute("sList", sList);
        req.setAttribute("bundleVideo", bundle.getVideo());
        req.setAttribute("bundleName", bundle.getName());
        req.setAttribute("bundleDes", bundle.getDescription());
        req.setAttribute("bundleImg", bundle.getImg());
        req.setAttribute("bundleBackgrImg", bundle.getBackgrImg());
        req.getRequestDispatcher("bundle.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    
    
}

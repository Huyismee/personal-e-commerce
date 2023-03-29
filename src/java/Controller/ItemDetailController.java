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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 *
 * @author ADMIN
 */
public class ItemDetailController extends HttpServlet{

   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute("account") != null) {
                String id = req.getParameter("id");
                Shop s = new Shop();
                Shop item = s.getItemById(id);
                int view;
                if(item.getViewNum()==null){
                    view = 1;
                } else{
                    view = Integer.parseInt(item.getViewNum());
                    view++;
                }             
                s.updateView(id, view);
                List<Shop> sList = s.getListShopExcept(id);
                req.setAttribute("sList", sList);
                req.setAttribute("name", item.getName());
                req.setAttribute("edition", item.getEdition());
                req.setAttribute("price", s.formatPrice(Double.parseDouble(item.getPrice())));
                req.setAttribute("stock", item.getStock());
                req.setAttribute("des", item.getDes());
                req.setAttribute("img", item.getImg());
                req.setAttribute("video", item.getVideo());
                req.setAttribute("gunName", item.getGunName());
                req.setAttribute("bundleName", item.getBundleName());
                req.setAttribute("viewNum", item.getViewNum());
                req.getRequestDispatcher("itemDetail.jsp").forward(req, resp);
            } else{
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }

        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    
    public static void main(String[] args) {
        Shop s = new Shop();
        ArrayList<Shop> sList = s.getListShop();
        for(Shop item : sList){
            System.out.println(item.formatPrice(Double.parseDouble(item.getPrice())));
        }
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Data.Skin;
import Data.User;
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
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acc = req.getParameter("acc");
        String pass = req.getParameter("pass");

        //XU LI 
        User u = new User();
        if (u.checkLogin(acc, pass) && req.getParameter("login") != null) {
            HttpSession session = req.getSession();
            session.setAttribute("account", acc);
            if (acc.equals("admin")) {
                req.setAttribute("mode", "1");
                Skin skin = new Skin();
                ArrayList<Skin> list = skin.getListSkin();
                req.setAttribute("list", list);
                req.getRequestDispatcher("edit.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("index1.jsp").forward(req, resp);
            }

        } else if (req.getParameter("register") != null) {
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Login Failed!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("account", null);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

}

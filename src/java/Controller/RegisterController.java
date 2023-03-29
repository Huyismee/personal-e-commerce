/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Data.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.AlphaComposite;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getParameter("register") != null) {
                User u = new User();
                String acc = req.getParameter("acc");
                String pass = req.getParameter("pass");
                String rePass = req.getParameter("rePass");

                if (pass != "" && pass.equals(rePass)) {
                    u.insert(acc, pass);
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Register Failed!");
                    req.getRequestDispatcher("register.jsp").forward(req, resp);
                }
            } else if (req.getParameter("cancel") != null) {
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Data.Question;
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
public class QuestionController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        Question q = new Question();
        String answer = req.getParameter("answer");
        id += 1;
        Question ques = q.getQuestionById(String.valueOf(id));
        if (ques.getId() != null) {
            req.setAttribute("id", String.valueOf(id));
            req.setAttribute("question", ques.getQuestion());
            req.setAttribute("a", ques.getA());
            req.setAttribute("b", ques.getB());
            req.setAttribute("c", ques.getC());
            req.setAttribute("d", ques.getD());
            req.getRequestDispatcher("Question.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Question q = new Question();
        Question ques = q.getQuestionById("1");
        req.setAttribute("id", "1");
        req.setAttribute("question", ques.getQuestion());
        req.setAttribute("a", ques.getA());
        req.setAttribute("b", ques.getB());
        req.setAttribute("c", ques.getC());
        req.setAttribute("d", ques.getD());
        req.getRequestDispatcher("Question.jsp").forward(req, resp);
    }

}

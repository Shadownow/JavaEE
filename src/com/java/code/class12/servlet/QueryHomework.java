package com.java.code.class12.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/QueryHomework")
public class QueryHomework extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //List<StudentHomework> list = StudentHomeworkJdbc.selectAll();


        //req.setAttribute("list", list);
        req.getRequestDispatcher("QueryHomework.jsp").forward(req, resp);
    }
}

package com.java.code.class12.servlet;

import com.java.code.class12.jdbc.HomeworkJdbc;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/UploadHomeworkServlet")
public class UploadHomeworkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获得请求表单中的信息
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        req.getRequestDispatcher("UploadHomework.jsp").forward(req, resp);
        HomeworkJdbc.addHomework(title,content);


    }

}

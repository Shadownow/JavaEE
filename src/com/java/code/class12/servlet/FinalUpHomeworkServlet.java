package com.java.code.class12.servlet;

import com.java.code.class12.jdbc.StudentHomeworkJdbc;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/FinalUpHomeworkServlet")
public class FinalUpHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String HID = req.getParameter("HID");
        String SID = req.getParameter("SID");
        String answer = req.getParameter("answer");
        StudentHomeworkJdbc.addStudentHomework(Long.parseLong(SID),Long.parseLong(HID),answer);


        resp.setCharacterEncoding("UTF-8");
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        JSONObject json = new JSONObject();
        json.put("boolean","true");
        PrintWriter out = resp.getWriter();
        out.write(String.valueOf(json));
    }
}

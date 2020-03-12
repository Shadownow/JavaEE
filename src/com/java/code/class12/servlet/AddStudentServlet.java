package com.java.code.class12.servlet;

import com.java.code.class12.jdbc.StudentJdbc;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获得请求表单中的信息
        req.setCharacterEncoding("UTF-8");
        String studentId = req.getParameter("studentId");
        String studentName = req.getParameter("studentName");


        resp.setCharacterEncoding("UTF-8");
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        if(studentId.equals("")){
            JSONObject data = new JSONObject();
            //获取PrintWriter输出流
            PrintWriter out = resp.getWriter();
            data.put("result","学号不能为空！");
            out.write(String.valueOf(data));
        }
        else if(studentName.equals("")){
            JSONObject data = new JSONObject();
            //获取PrintWriter输出流
            PrintWriter out = resp.getWriter();
            data.put("result","学生姓名不能为空！");
            out.write(String.valueOf(data));
        }
        else if(studentId.length()!=6){
            JSONObject data = new JSONObject();
            //获取PrintWriter输出流
            PrintWriter out = resp.getWriter();
            data.put("result","学号应为6位，请重新填写！");
            out.write(String.valueOf(data));
        }
        else if(!StudentJdbc.queryByStudentId( Long.parseLong(studentId))){
            JSONObject data = new JSONObject();
            //获取PrintWriter输出流
            PrintWriter out = resp.getWriter();
            data.put("result","该学号已存在，请重新输入！");
            out.write(String.valueOf(data));
        }
        else{
            JSONObject data = new JSONObject();
            //获取PrintWriter输出流
            PrintWriter out = resp.getWriter();
            data.put("result","添加成功！");
            out.write(String.valueOf(data));
            StudentJdbc.addStudent(Long.parseLong(studentId),studentName);
        }
    }
}

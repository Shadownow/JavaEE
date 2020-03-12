package com.java.code.class12.servlet;

import com.java.code.class12.jdbc.StudentJdbc;
import com.java.code.class12.model.Student;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UpFinishedHomeworkServlet")
public class UpFinishedHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        List<Student> students =StudentJdbc.selectAll();
        List<JSONObject> jsonList = new ArrayList<JSONObject>();

        for(int i=0 ; i<students.size(); i++){
            jsonList.add(new JSONObject());
            jsonList.get(i).put("StudentId",students.get(i).getStudentId());
        }
        //获取PrintWriter输出流
        PrintWriter out = resp.getWriter();
        out.write(String.valueOf(jsonList));
    }
}

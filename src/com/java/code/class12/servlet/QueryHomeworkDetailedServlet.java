package com.java.code.class12.servlet;

import com.java.code.class12.jdbc.StudentHomeworkJdbc;
import com.java.code.class12.model.StudentHomework;
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

@WebServlet("/QueryHomeworkDetailedServlet")
public class QueryHomeworkDetailedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String HID = req.getParameter("HID");
        List<StudentHomework> studentHomeworks = StudentHomeworkJdbc.selectByHID(Long.parseLong(HID));
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        for(int i=0;i<studentHomeworks.size();i++){
            jsonObjects.add(new JSONObject());
            jsonObjects.get(i).put("学号",studentHomeworks.get(i).getStudentId());
            jsonObjects.get(i).put("姓名",studentHomeworks.get(i).getStudentName());
            jsonObjects.get(i).put("作业编号",studentHomeworks.get(i).getHomeworkId());
            jsonObjects.get(i).put("作业标题",studentHomeworks.get(i).getHomeworkTitle());
            jsonObjects.get(i).put("作业内容",studentHomeworks.get(i).getHomeworkContent());
            jsonObjects.get(i).put("回答",studentHomeworks.get(i).getAnswer());
            jsonObjects.get(i).put("提交时间",studentHomeworks.get(i).getAnswerTime());
        }
        resp.setCharacterEncoding("UTF-8");
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(String.valueOf(jsonObjects));
    }
}

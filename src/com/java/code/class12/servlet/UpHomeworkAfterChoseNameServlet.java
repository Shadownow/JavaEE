package com.java.code.class12.servlet;

import com.java.code.class12.jdbc.HomeworkJdbc;
import com.java.code.class12.jdbc.StudentHomeworkJdbc;
import com.java.code.class12.model.Homework;
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

@WebServlet("/UpHomeworkAfterChoseName")
public class UpHomeworkAfterChoseNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String studentId = req.getParameter("studentId");
        //String studentId="123123";
        //System.out.println(studentId);
        List<Homework> homework = HomeworkJdbc.selectAll();
        List<StudentHomework>studentHomework = StudentHomeworkJdbc.selectBySID(Long.parseLong(studentId));
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        System.out.println(studentHomework.size());
        //System.out.println(homework.size());
        int k = 0;
        for(int i=0;i<homework.size();i++){
            if(studentHomework.size()==0){
                jsonObjects.add(new JSONObject());
                jsonObjects.get(k).put("作业号",homework.get(i).getId());
                jsonObjects.get(k).put("标题",homework.get(i).getHomeworkTitle());
                jsonObjects.get(k).put("内容",homework.get(i).getHomeworkContent());
                jsonObjects.get(k).put("提交情况","未提交");
                k++;
            }
            else{
                for(int j=0;j<studentHomework.size();j++){
                    if(homework.get(i).getId()==studentHomework.get(j).getHomeworkId()){
                        jsonObjects.add(new JSONObject());
                        jsonObjects.get(k).put("作业号",homework.get(i).getId());
                        jsonObjects.get(k).put("标题",homework.get(i).getHomeworkTitle());
                        jsonObjects.get(k).put("内容",homework.get(i).getHomeworkContent());
                        jsonObjects.get(k).put("提交情况","已提交");
                        k++;
                        break;
                    }
                    else if(j==studentHomework.size()-1){
                        jsonObjects.add(new JSONObject());
                        jsonObjects.get(k).put("作业号",homework.get(i).getId());
                        jsonObjects.get(k).put("标题",homework.get(i).getHomeworkTitle());
                        jsonObjects.get(k).put("内容",homework.get(i).getHomeworkContent());
                        jsonObjects.get(k).put("提交情况","未提交");
                        k++;
                    }

                }
            }

        }
        resp.setCharacterEncoding("UTF-8");
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(String.valueOf(jsonObjects));

    }
}

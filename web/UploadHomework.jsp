<%--
  Created by IntelliJ IDEA.
  User: 18221
  Date: 2020/3/10
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布作业</title>
    <script type="text/javascript">
        function beforeSubmit(form){
            if(form.title.value==''){
                alert('作业标题不能为空！');
                form.title.focus();
                return false;
            }
            if(form.content.value==''){
                alert('作业内容不能为空！');
                form.content.focus();
                return false;
            }
            alert('发布成功！');
            return true;
        }
    </script>
</head>
<body>
<div align="center">

<h1>发布作业</h1>
<form action="UploadHomeworkServlet" method="post" onSubmit="return beforeSubmit(this)">
    作业标题:<br>
    <input type="text" name="title" value="" style="width: 200px; height:35px;">
    <br>
    作业内容:<br>
    <input type="text" name="content" value="" style="width: 200px; height:35px;">
    <br><br>
    <input type="submit" style="width: 60px; height: 30px;" value="确认">&nbsp&nbsp<input type="reset" style="width: 60px; height: 30px;" value="清空">
</form>
<br>
<a href="index.jsp">返回首页</a>
</div>
</body>
</html>

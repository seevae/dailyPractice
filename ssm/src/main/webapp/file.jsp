<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/15
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
单文件上传
<form action="${pageContext.request.contextPath}/file/fileUp" method="post" enctype="multipart/form-data">
    <p>选择文件: <input type="file" name="files"></p>
    <p><input type="submit" value="提交"></p>
</form>

多文件上传
<form action="${pageContext.request.contextPath}/file/fileUps" method="post" enctype="multipart/form-data">
    <p>选择文件:<input type="file" name="files"></p><br>
    <p>选择文件:<input type="file" name="files"></p><br>
    <p>选择文件:<input type="file" name="files"></p><br>
    <p><input type="submit" value="提交"></p>
</form>
</body>
</html>

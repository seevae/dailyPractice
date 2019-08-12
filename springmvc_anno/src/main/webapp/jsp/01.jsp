<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
后端HttpServletRequst类接收前端传来的参数<br>

后端返回值为void<br>
<form action="/show.do" method="post">
    用户名:   <input type="text" name="name"><br>
    用户密码: <input type="text" name="password"><br>
    <input type="submit"><br>
</form>
<br>

后端返回值为String
<form action="/show2.do" method="post">
    用户名:   <input type="text" name="name"><br>
    用户密码: <input type="text" name="password"><br>
    <input type="submit"><br>
</form>

参数绑定指定获取前端数据
<form action="/show3.do" method="get">
    用户名:   <input type="text" name="name"><br>
    用户密码: <input type="text" name="password"><br>
    <input type="submit"><br>
</form>
<br>


使用实体类接收数据
<form action="/show4.do" method="get">
    id:   <input type="text" name="id"><br>
    name: <input type="text" name="name"><br>
    <input type="submit"><br>
</form>
<br>
</body>
</html>

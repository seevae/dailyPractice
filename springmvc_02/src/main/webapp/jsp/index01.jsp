<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- 引入c标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="">
    商品列表:
        <table width="100%" border="1">
            <tr>
                <td>商品编号</td>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>商品描述</td>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td>${item.itemsdetail}</td>
                </tr>
            </c:forEach>
        </table>
</form>
</body>
</html>

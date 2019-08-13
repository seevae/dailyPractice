<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="">
 商品列表：
        <table width="100%" border=1>
            <tr>
                <td>商品编号</td>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>商品描述</td>
                <td>操作</td>
            </tr>
            
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.id }</td>
                    <td>${item.name }</td>
                    <td>${item.price }</td>
                    <td>${item.itemsdetail}</td>

                    <td><a
                        href="${pageContext.request.contextPath }editItem.do?id=${item.id}">修改</a></td>

                </tr>
                <td><a
                        href="${pageContext.request.contextPath }delItem.do?id=${item.id}">删除</a></td>
                </tr>
            
            </c:forEach>
            
           </table> 
</form>

</body>
</html>
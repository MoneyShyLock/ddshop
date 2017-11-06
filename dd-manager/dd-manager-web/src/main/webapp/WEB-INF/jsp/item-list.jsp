<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <caption>商品列表</caption>
    <thead>
    <tr>
        <th>编号</th>
        <th>标题</th>
        <th>库存数量</th>
        <th>商品价格</th>
    </tr>


    </thead>
    <tbody>
    <c:forEach items="${items}" var="item">
        <tr>
        <th>${item.id}</th>
        <th>${item.title}</th>
        <th>${item.num}</th>
        <th>${item.price}</th>
        </tr>
    </c:forEach>
    </tbody>
</table>


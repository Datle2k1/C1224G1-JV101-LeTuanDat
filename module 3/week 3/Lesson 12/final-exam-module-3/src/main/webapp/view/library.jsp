<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: datle
  Date: 4/15/2025
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Table</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<c:if test="${notAvailable}">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <div><p>Lỗi !!!</p></div>
        <div><p>Cuốn sách này tạm thời đã cho mượn hết, vui lòng chọn sách khác</p></div>
        <a href="${pageContext.request.contextPath}/all-book">
            <button type="button" class="btn-close" aria-label="Close"></button>
        </a>
    </div>
</c:if>

<div class="container mt-5">
    <h2 class="mb-4">Danh Sách Sách</h2>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th scope="col">Mã Sách</th>
            <th scope="col">Tên Sách</th>
            <th scope="col">Tác Giả</th>
            <th scope="col">Số Lượng</th>
            <th scope="col">Mô Tả</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.getId()}</td>
                <td>${book.getName()}</td>
                <td>${book.getAuthor()}</td>
                <td>${book.getQuantity()}</td>
                <td>${book.getDescription()}</td>
                <td><form action="${pageContext.request.contextPath}/all-book" method="post">
                    <input type="hidden" name="action" value="borrow">
                    <input type="hidden" name="idBook" value="${book.getId()}">
                    <button class="btn btn-primary btn-sm">Mượn</button>
                </form></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

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

<c:if test="${confirm}">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <div><p>Bạn muốn trả cuốn sách ${nameBookReturn} ?</p></div>
        <form action="${pageContext.request.contextPath}/book-borrowed" method="post">
            <input type="hidden" name="action" value="return">
            <button type="submit">Xác nhận</button>
        </form>
        <a href="${pageContext.request.contextPath}/book-borrowed">
            <button type="button">Hủy</button>
        </a>
    </div>
</c:if>

<h2 class="text-center mb-4">Danh sách đã cho mượn</h2>

<div class="container mt-5">
    <a href="${pageContext.request.contextPath}/all-book">
        <button class="button">All Book</button>
    </a>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th scope="col">Mã mượn sách</th>
            <th scope="col">Tên Sách</th>
            <th scope="col">Tác Giả</th>
            <th scope="col">Tên học sinh</th>
            <th scope="col">Lớp</th>
            <th scope="col">Ngày mượn</th>
            <th scope="col">Ngày trả</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cards}" var="card">
            <tr>
                <td>${card.getId()}</td>
                <td>${card.getBook().getName()}</td>
                <td>${card.getBook().getAuthor()}</td>
                <td>${card.getStudent().getName()}</td>
                <td>${card.getStudent().getClasses()}</td>
                <td>${card.getDayBorrowed()}</td>
                <td>${card.getDateReturn()}</td>
                <td><form action="${pageContext.request.contextPath}/book-borrowed" method="post">
                    <input type="hidden" name="action" value="confirm">
                    <input type="hidden" name="idCard" value="${card.getId()}">
                    <input type="hidden" name="idBook" value="${card.getBook().getId()}">
                    <button type="submit" class="btn btn-primary btn-sm">Trả</button>
                </form></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

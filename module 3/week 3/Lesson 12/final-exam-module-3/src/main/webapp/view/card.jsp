<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: datle
  Date: 4/15/2025
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Mượn Sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Form Mượn Sách</h2>
    <form>
        <div class="mb-3">
            <label for="maMuonSach" class="form-label">Mã Mượn Sách</label>
            <input type="text" class="form-control" id="maMuonSach" placeholder="${}" disabled>
        </div>
        <div class="mb-3">
            <label for="tenSach" class="form-label">Tên Sách</label>
            <input type="text" class="form-control" id="tenSach" placeholder="${book.name}" disabled>
        </div>
        <div class="mb-3">
            <label for="tenHocSinh" class="form-label">Tên Học Sinh</label>
            <select class="form-select" id="tenHocSinh">
                <c:forEach items="${students}" var="student">
                    <option>${student.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="ngayMuonSach" class="form-label">Ngày Mượn Sách</label>
            <input type="date" class="form-control" id="ngayMuonSach" value="now" disabled>
        </div>
        <div class="mb-3">
            <label for="ngayTraSach" class="form-label">Ngày Trả Sách</label>
            <input type="date" class="form-control" id="ngayTraSach">
        </div>
        <div class="d-flex justify-content-end">
            <form action="${pageContext.request.contextPath}/card" method="post">
                <input type="hidden" name="action" value="borrow">
                <button type="submit" class="btn btn-primary me-2">Mượn Sách</button>
            </form>
            <a href="${pageContext.request.contextPath}/all-book">
                <button type="reset" class="btn btn-secondary">Hủy</button>
            </a>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
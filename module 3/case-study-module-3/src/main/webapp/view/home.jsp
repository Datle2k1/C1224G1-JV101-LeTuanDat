<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web Shop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles.css">
    <style></style>
</head>
<body>
<header class="accordion-header navbar navbar-dark py-2">
    <div class="container-fluid">
        <a class="navbar-brand text-black" href="#">Shop</a>

        <div class="icons-right d-flex align-items-center">
            <a href="${pageContext.request.contextPath}/cart" class="nav-link me-3">
                <i class="bi bi-cart bg-light"></i>
            </a>
            <a href="#" class="nav-link">
                <i class="bi bi-person fs-4"></i>
            </a>
        </div>
    </div>
</header>

<div class="main-content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-8 product-list">
                <h3>Danh sách sản phẩm</h3>
                <c:forEach items="${skins}" var="skin">
                    <div class="product-item d-inline-grid align-items-center">
                        <div class="col">
                            <img src="${CHAMPION_IMAGE_PATH}/${skin.thumbnail}" alt="${skin.name}" class="product-img img-fluid">
                        </div>
                        <div class="col">
                            <h5>Tên sản phẩm 1</h5>
                            <p>Giá: ${skin.price} VNĐ</p>
                        </div>
                        <div class="col">
                            <form action="${pageContext.request.contextPath}/add-to-cart?skin_id=${skin.skin_id}" method="post">
                                <input type="button" class="btn btn-primary btn-sm mb-2 w-100" name="Add to cart" value="Add To Cart">
                            </form>
                            <button class="btn btn-secondary btn-sm w-100">
                                <a href="${pageContext.request.contextPath}/skin-detail?id=${skin.skin_id}">Detail</a>
                            </button>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div class="col-md-4 cart bg-light p-3">
                <div class="slider">
                    <div class="slides">
                        <c:forEach items="${skins}" var="skin">
                            <div class="slide">
                                <img src="${CHAMPION_IMAGE_PATH}/${skin.thumbnail}" alt="${skin.name}">
                            </div>
                        </c:forEach>
                    </div>

                    <button class="prev" onclick="moveSlide(-1)">&#10094;</button>
                    <button class="next" onclick="moveSlide(1)">&#10095;</button>
                </div>
            </div>
        </div>
    </div>
</div>

<footer>
    <p>&copy; 2025 Web Shop. All rights reserved.</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
</body>
</html>

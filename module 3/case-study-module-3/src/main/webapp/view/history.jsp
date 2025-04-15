<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web Shop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        header {
            border: 2px solid black;
        }

        .main-content {
            flex: 1;
            padding: 20px;
        }

        .img-container img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            object-position: center;
        }

        footer {
            background-color: #f8f9fa;
            padding: 10px 0;
            text-align: center;
            border: 1px solid black;
        }

        .navbar-nav .nav-link {
            display: flex;
            align-items: center;
            gap: 5px;
        }

        .carousel-item img {
            width: 100%;
            aspect-ratio: 9 / 16;
            object-fit: cover;
        }
    </style>
</head>
<body>

<c:if test="${sessionScope.customerId == null}">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <p>You are not logged in</p>
        <a href="${pageContext.request.contextPath}/login">
            <button type="button" class="btn btn-outline-light" data-bs-dismiss="alert">Log in</button>
        </a>
    </div>
</c:if>

<c:if test="${sessionScope.addSkin}">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <p>Add to cart successfully!</p>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>

<header class="navbar navbar-expand-lg navbar-dark bg-light">
    <div class="container-fluid">
        <a class="navbar-brand text-black" href="#">Shop Skin</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon bg-black"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link text-black" href="${pageContext.request.contextPath}/home">
                        <i class="bi bi-house-door"></i> Home
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-black" href="${pageContext.request.contextPath}/cart">
                        <i class="bi bi-cart"></i> Cart
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-black" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        <i class="bi bi-person"></i> Customer
                    </a>
                    <ul class="dropdown-menu">
                        <c:if test="${sessionScope.customerId != null}">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/info">
                                <i class="bi bi-info"></i> Info
                            </a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/history">
                                <i class="bi bi-clock-history"></i> History
                            </a></li>
                            <li>
                                <form action="${pageContext.request.contextPath}/logout" method="post">
                                    <button type="submit" class="dropdown-item">
                                        <i class="bi bi-box-arrow-right"></i> Logout
                                    </button>
                                </form>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.customerId == null}">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/login">
                                <i class="bi bi-box-arrow-in-right"></i> Login
                            </a></li>
                        </c:if>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</header>

<div class="main-content">
    <div class="container-fluid">
        <c:forEach items="${orders}" var="order">
            <div class="row">
                <div class="col-4 align-content-center">
                    <p>Order : $${order.order_id}</p>
                </div>
                <div class="col-4 align-content-center">
                    <p>${order.order_date}</p>
                </div>
                <div class="col-4 align-content-center">
                    <p>${order.total_price}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<footer>
    <p>© 2025 Web Shop. All rights reserved.</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq"
        crossorigin="anonymous"></script>
</body>
</html>
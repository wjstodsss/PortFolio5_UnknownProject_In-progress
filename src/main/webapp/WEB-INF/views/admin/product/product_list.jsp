<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 관리</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h2>상품 정보</h2>
    <!-- 상품 등록 버튼 -->
    <a href="/admin/upload_form" class="btn btn-success mb-3">상품 등록</a>
    <table class="table">
        <thead>
            <tr>
                <th>상품 ID</th>
                <th>상품명</th>
                <th>설명</th>
                <th>가격</th>
                <th>카테고리</th>
                <th>이미지 URL</th>
                <th>작업</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.productId}</td>
                    <td>${product.productName}</td>
                    <td>${product.productDescription}</td>
                    <td>${product.productPrice}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productBrand}</td>
                    <td><img src="upload/${product.productImageURL}" alt="Product Image" style="max-width: 100px;"></td>
                    <td>${product.productRegdate}</td>
                    <td>${product.productUpdateDate}</td>
                    <td>
                        <a href="/admin/secured/product_detail?id=${product.id}" class="btn btn-primary">상세 보기</a>
                        <button type="button" class="btn btn-danger" onclick="deleteProduct(${product.id})">삭제</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script>
    function deleteProduct(id) {
        console.log("Delete Product ID:", id);
        if (confirm("정말로 이 상품을 삭제하시겠습니까?")) {
            // AJAX를 사용하여 삭제 요청을 보냄
            $.ajax({
                type: "POST",
                url: "/admin/product_delete",
                data: { id: id },
                success: function(response) {
                    // 삭제 성공 시 페이지를 다시 로드
                    location.reload(); // 현재 페이지를 새로 고침
                },
                error: function(xhr, status, error) {
                    console.error("Delete failed:", error);
                    // 삭제 실패 시 사용자에게 알림 등을 추가할 수 있습니다.
                }
            });
        }
    }
</script>
</body>
</html>

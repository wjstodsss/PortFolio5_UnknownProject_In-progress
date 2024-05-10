<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review Register</title>

</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Review Register</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">Review Register</div>
            <div class="panel-body">
                <form id="registerForm" name="registerForm" role="form" action="register" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
            
                    <div class="form-group">
                        <label for="reviewName">reviewName</label>
                        <input type="text" class="form-control" id="reviewName" name="reviewName" placeholder="상품명을 입력하세요">
                    </div>
                    <div class="form-group">
                        <label for="reviewBrand">reviewBrand</label>
                        <input type="text" class="form-control" id="reviewBrand" name="reviewBrand" placeholder="브랜드를 입력하세요">
                    </div>
                    <div class="form-group">
                        <label for="reviewCategory">reviewCategory</label>
                        <input type="text" class="form-control" id="reviewCategory" name="reviewCategory" placeholder="카테고리를 입력하세요">
                    </div>
                    <div class="form-group">
                        <label for="reviewPrice">reviewPrice</label>
                        <input type="text" class="form-control" id="reviewPrice" name="reviewPrice" placeholder="가격을 입력하세요">
                    </div>
                    <div class="form-group">
                        <label for="reviewDescription">reviewDescription</label>
                        <textarea class="form-control" rows="3" id="reviewDescription" name="reviewDescription" placeholder="설명을 입력하세요"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="uploadFile">uploadFile</label>
                        <input type="file" id="uploadFile" name="uploadFile" multiple>
                        <input type="hidden" value='defaltImage.jpg' name='reviewImageURL'>
                    </div>
                    <button type="submit" class="btn btn-default btn-success">Submit Button</button>
                    <button type="reset" class="btn btn-default btn-info">Reset Button</button>
                    <a class="btn btn-info" href="list">List</a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>
function validateForm() {
    var reviewName = document.forms["registerForm"]["reviewName"].value;
    var reviewBrand = document.forms["registerForm"]["reviewBrand"].value;
    var reviewCategory = document.forms["registerForm"]["reviewCategory"].value;
    var reviewPrice = document.forms["registerForm"]["reviewPrice"].value;
    var reviewDescription = document.forms["registerForm"]["reviewDescription"].value;
    
    if (reviewName == "" || reviewBrand == "" || reviewCategory == "" || reviewPrice == "" || reviewDescription == "") {
        alert("모든 필드를 입력하세요.");
        return false;
    }
    
    if (isNaN(reviewCategory) || isNaN(reviewPrice)) {
        alert("카테고리와 가격은 숫자로 입력해야 합니다.");
        return false;
    }
    
    return true; // 유효성 검사 통과
}
</script>
</html>

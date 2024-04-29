<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Register</title>

</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Register</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">Board Register</div>
            <div class="panel-body">
                <form id="registerForm" name="registerForm" role="form" action="register" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
            
                    <div class="form-group">
                        <label for="faqName">faqName</label>
                        <input type="text" class="form-control" id="faqName" name="faqName" placeholder="상품명을 입력하세요">
                    </div>
                    <div class="form-group">
                        <label for="faqBrand">faqBrand</label>
                        <input type="text" class="form-control" id="faqBrand" name="faqBrand" placeholder="브랜드를 입력하세요">
                    </div>
                    <div class="form-group">
                        <label for="faqCategory">faqCategory</label>
                        <input type="text" class="form-control" id="faqCategory" name="faqCategory" placeholder="카테고리를 입력하세요">
                    </div>
                    <div class="form-group">
                        <label for="faqPrice">faqPrice</label>
                        <input type="text" class="form-control" id="faqPrice" name="faqPrice" placeholder="가격을 입력하세요">
                    </div>
                    <div class="form-group">
                        <label for="faqDescription">faqDescription</label>
                        <textarea class="form-control" rows="3" id="faqDescription" name="faqDescription" placeholder="설명을 입력하세요"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="uploadFile">uploadFile</label>
                        <input type="file" id="uploadFile" name="uploadFile" multiple>
                        <input type="hidden" value='defaltImage.jpg' name='faqImageURL'>
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
    var faqName = document.forms["registerForm"]["faqName"].value;
    var faqBrand = document.forms["registerForm"]["faqBrand"].value;
    var faqCategory = document.forms["registerForm"]["faqCategory"].value;
    var faqPrice = document.forms["registerForm"]["faqPrice"].value;
    var faqDescription = document.forms["registerForm"]["faqDescription"].value;
    
    if (faqName == "" || faqBrand == "" || faqCategory == "" || faqPrice == "" || faqDescription == "") {
        alert("모든 필드를 입력하세요.");
        return false;
    }
    
    if (isNaN(faqCategory) || isNaN(faqPrice)) {
        alert("카테고리와 가격은 숫자로 입력해야 합니다.");
        return false;
    }
    
    return true; // 유효성 검사 통과
}
</script>
</html>

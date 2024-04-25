<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <h1>제품 상세 정보</h1>

    <div class="container">
        <form id="updateForm" action="/admin/upload" method="post" enctype="multipart/form-data">

            <label for="productName" class="mb-2 mr-sm-2">Name</label>
            <input type="text" class="form-control mb-2 mr-sm-2" id="productName" value="${product.name}" name="name">
            
            <label for="productDescription" class="mb-2 mr-sm-2">Description</label>
            <textarea class="form-control mb-2 mr-sm-2" id="productDescription" name="description" rows="5" cols="50">${product.description}</textarea>
            
            <label for="productPrice" class="mb-2 mr-sm-2">Price</label>
            <input type="text" class="form-control mb-2 mr-sm-2" id="productPrice" value="${product.price}" name="price">
            
            <label for="productCategory" class="mb-2 mr-sm-2">Category</label>
            <input type="text" class="form-control mb-2 mr-sm-2" id="productCategory" value="${product.category}" name="category">
            
            <label for="uploadFiles">Choose Files:</label>
			<input type="file" id="uploadFiles" name="uploadFiles">
			<input type="hidden" class="form-control mb-2 mr-sm-2" id="productImageUrl" name="imageUrl">
			
			<br>
			<br>
				
            <button type="submit" class="btn btn-primary mb-2" onclick="updateData()">Update</button>
            <button type="button" class="btn btn-info mb-2" onclick="window.location.href='secured/product_list'">List</button>
        </form>
            
    </div>

</body>
<script>
document.getElementById('uploadFiles').addEventListener('change', function() {
    var fileInput = document.getElementById('uploadFiles');
    var fileNameDisplay = document.getElementById('productImageUrl');
    
    // 파일이 선택되었을 때
    if (fileInput.files && fileInput.files.length > 0) {
        // 첫 번째 파일의 이름을 가져와서 표시
        fileNameDisplay.value = fileInput.files[0].name;
    }
});
</script>

</html>
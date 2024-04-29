
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">review Modify</h1>
	</div>
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">review Modify</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" action="modify" method="post" enctype="multipart/form-data">
				<input type='hidden' name='pageNum' value='${cri.pageNum}'>
	            <input type='hidden' name='amount' value='${cri.amount}'>
				<div class="form-group">
							<label>reviewName</label> <input class="form-control"  value='${review.reviewId}' name='reviewId'>
						</div>
					<div class="form-group">
							<label>reviewName</label> <input class="form-control"  value='${review.reviewName}' name='reviewName'>
						</div>
						<div class="form-group">
							<label>reviewBrand</label> <input class="form-control" value='${review.reviewBrand}' name='reviewBrand'>
						</div>
						<div class="form-group">
							<label>reviewCategory</label> <input class="form-control"  value='${review.reviewCategory}' name='reviewCategory'>
						</div>
						<div class="form-group">
							<label>reviewPrice</label> <input class="form-control" value='${review.reviewPrice}' name='reviewPrice'>
						</div>
						<div class="form-group">
							<label>reviewDescription</label>
							<textarea class="form-control" rows="3" value='' name='reviewDescription'>${review.reviewDescription}</textarea>
						</div>
						
						<div class="form-group">
							<input type='file' name='uploadFile' multiple>
						</div>
						<div class="form-group">
							<label>변경전 이미지</label>
							<img src="upload/${review.reviewImageURL}" alt="제품이미지" style="max-width: 100px">
							<input type="hidden" value='${review.reviewImageURL}' name='reviewImageURL'>
							
						</div>
					<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
					<button type="submit" data-oper='list' class="btn btn-info">List</button>

				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
</div>
<!-- /#page-wrapper -->

<!-- 제이쿼리 cdn이 footer안에 있기 때문에 여기에 위치 -->
<%@include file="../includes/footer.jsp"%>


<script type="text/javascript">

$(document).ready(function(){
	var formObj = $("form");
	
	$("button").on("click", function(e){
		e.preventDefault();
		
		var operation = $(this).data("oper");
		
		console.log(operation);
		
		if(operation === 'remove'){
			formObj.attr("action", "remove");
			
		}else if(operation === 'list'){
			formObj.attr("action", "list").attr("method", "get");
			var pageNumTag = $("input[name='pageNum']").clone();
			var amountTag = $("input[name='amount']").clone();
			
			formObj.empty();
			formObj.append(pageNumTag);
			formObj.append(amountTag);
		
		}
		
		formObj.submit();
	});
	
});
</script>





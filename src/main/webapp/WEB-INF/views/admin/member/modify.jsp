
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Member Modify</h1>
	</div>
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Member Modify</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" action="modify" method="post" enctype="multipart/form-data">
				<input type='hidden' name='pageNum' value='${cri.pageNum}'>
	            <input type='hidden' name='amount' value='${cri.amount}'>
				<div class="form-group">
							<label>memberName</label> <input class="form-control"  value='${member.memberId}' name='memberId'>
						</div>
					<div class="form-group">
							<label>memberName</label> <input class="form-control"  value='${member.memberName}' name='memberName'>
						</div>
						<div class="form-group">
							<label>memberBrand</label> <input class="form-control" value='${member.memberBrand}' name='memberBrand'>
						</div>
						<div class="form-group">
							<label>memberCategory</label> <input class="form-control"  value='${member.memberCategory}' name='memberCategory'>
						</div>
						<div class="form-group">
							<label>memberPrice</label> <input class="form-control" value='${member.memberPrice}' name='memberPrice'>
						</div>
						<div class="form-group">
							<label>memberDescription</label>
							<textarea class="form-control" rows="3" value='' name='memberDescription'>${member.memberDescription}</textarea>
						</div>
						
						<div class="form-group">
							<input type='file' name='uploadFile' multiple>
						</div>
						<div class="form-group">
							<label>변경전 이미지</label>
							<img src="/download/${member.memberImageURL}" alt="제품이미지" style="max-width: 100px">
							<input type="hidden" value='${member.memberImageURL}' name='memberImageURL'>
							
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





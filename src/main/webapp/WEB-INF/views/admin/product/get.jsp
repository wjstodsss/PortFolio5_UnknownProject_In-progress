<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Product Read</h1>
	</div>
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Product Read</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="form-group">
					<label>productId</label> <input class="form-control"
						name='productId' value='${product.productId}' readonly>
				</div>

				<div class="form-group">
					<label>productName</label> <input class="form-control"
						name='productName' value='${product.productName}' readonly>
				</div>

				<div class="form-group">
					<label>productDescription</label>
					<textarea class="form-control" rows="3" name='productDescription'
						readonly>${product.productDescription}</textarea>
				</div>

				<div class="form-group">
					<label>productPrice</label> <input class="form-control"
						name='productPrice' value='${product.productPrice}' readonly>
				</div>

				<button data-oper='modify' class="btn btn-default btn-success"
					onclick="location.href='admin/product/modify?productId=${product.productId}'">Modify</button>

				<button data-oper='list' class="btn btn-default btn-info"
					onclick="location.href='list'">List</button>

				<form id="operForm" action="admin/product/modify" method='get'>
					<input type='hidden' id='productId' name='productId'
						value="${product.productId}"> <input type='hidden'
						name='pageNum' value="${cri.pageNum}"> <input
						type='hidden' name='amount' value="${cri.amount}">
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

<%@include file="../includes/footer.jsp"%>


<script type="text/javascript">
	$(document).ready(function() {
		var operForm = $("#operForm");

		$("button[data-oper='modify']").on("click", function(e) {
			operForm.attr("action", "modify").submit();
		});

		$("button[data-oper='list']").on("click", function(e) {
			operForm.find("#productId").remove();
			operForm.attr("action", "list");
			operForm.submit();
		});
	});
</script>
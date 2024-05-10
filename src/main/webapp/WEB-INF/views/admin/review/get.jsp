<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Review Read</h1>
	</div>
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Review Read</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="form-group">
					<label>reviewId</label> <input class="form-control"
						name='reviewId' value='${review.reviewId}' readonly>
				</div>

				<div class="form-group">
					<label>reviewName</label> <input class="form-control"
						name='reviewName' value='${review.reviewName}' readonly>
				</div>

				<div class="form-group">
					<label>reviewDescription</label>
					<textarea class="form-control" rows="3" name='reviewDescription'
						readonly>${review.reviewDescription}</textarea>
				</div>

				<div class="form-group">
					<label>reviewPrice</label> <input class="form-control"
						name='reviewPrice' value='${review.reviewPrice}' readonly>
				</div>

				<button data-oper='modify' class="btn btn-default btn-success"
					onclick="location.href='modify?reviewId=${review.reviewId}'">Modify</button>

				<button data-oper='list' class="btn btn-default btn-info"
					onclick="location.href='list'">List</button>

				<form id="operForm" action="admin/review/modify" method='get'>
					<input type='hidden' id='reviewId' name='reviewId'
						value="${review.reviewId}"> <input type='hidden'
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
			operForm.find("#reviewId").remove();
			operForm.attr("action", "list");
			operForm.submit();
		});
	});
</script>
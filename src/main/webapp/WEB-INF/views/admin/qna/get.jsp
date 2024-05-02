<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Qna Read</h1>
	</div>
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Qna Read</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="form-group">
					<label>qnaId</label> <input class="form-control"
						name='qnaId' value='${qna.qnaId}' readonly>
				</div>

				<div class="form-group">
					<label>qnaName</label> <input class="form-control"
						name='qnaName' value='${qna.qnaName}' readonly>
				</div>

				<div class="form-group">
					<label>qnaDescription</label>
					<textarea class="form-control" rows="3" name='qnaDescription'
						readonly>${qna.qnaDescription}</textarea>
				</div>

				<div class="form-group">
					<label>qnaPrice</label> <input class="form-control"
						name='qnaPrice' value='${qna.qnaPrice}' readonly>
				</div>

				<button data-oper='modify' class="btn btn-default btn-success"
					onclick="location.href='modify?qnaId=${qna.qnaId}'">Modify</button>

				<button data-oper='list' class="btn btn-default btn-info"
					onclick="location.href='list'">List</button>

				<form id="operForm" action="admin/qna/modify" method='get'>
					<input type='hidden' id='qnaId' name='qnaId'
						value="${qna.qnaId}"> <input type='hidden'
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
			operForm.find("#qnaId").remove();
			operForm.attr("action", "list");
			operForm.submit();
		});
	});
</script>
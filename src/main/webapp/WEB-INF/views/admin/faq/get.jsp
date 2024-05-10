<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Faq Read</h1>
	</div>
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Faq Read</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="form-group">
					<label>faqId</label> <input class="form-control"
						name='faqId' value='${faq.faqId}' readonly>
				</div>

				<div class="form-group">
					<label>faqName</label> <input class="form-control"
						name='faqName' value='${faq.faqName}' readonly>
				</div>

				<div class="form-group">
					<label>faqDescription</label>
					<textarea class="form-control" rows="3" name='faqDescription'
						readonly>${faq.faqDescription}</textarea>
				</div>

				<div class="form-group">
					<label>faqPrice</label> <input class="form-control"
						name='faqPrice' value='${faq.faqPrice}' readonly>
				</div>

				<button data-oper='modify' class="btn btn-default btn-success"
					onclick="location.href='modify?faqId=${faq.faqId}'">Modify</button>

				<button data-oper='list' class="btn btn-default btn-info"
					onclick="location.href='list'">List</button>

				<form id="operForm" action="admin/faq/modify" method='get'>
					<input type='hidden' id='faqId' name='faqId'
						value="${faq.faqId}"> <input type='hidden'
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
			operForm.find("#faqId").remove();
			operForm.attr("action", "list");
			operForm.submit();
		});
	});
</script>
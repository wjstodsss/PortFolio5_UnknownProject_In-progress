<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Notice Read</h1>
	</div>
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Notice Read</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="form-group">
					<label>noticeId</label> <input class="form-control"
						name='noticeId' value='${notice.noticeId}' readonly>
				</div>

				<div class="form-group">
					<label>noticeName</label> <input class="form-control"
						name='noticeName' value='${notice.noticeName}' readonly>
				</div>

				<div class="form-group">
					<label>noticeDescription</label>
					<textarea class="form-control" rows="3" name='noticeDescription'
						readonly>${notice.noticeDescription}</textarea>
				</div>

				<div class="form-group">
					<label>noticePrice</label> <input class="form-control"
						name='noticePrice' value='${notice.noticePrice}' readonly>
				</div>

				<button data-oper='modify' class="btn btn-default btn-success"
					onclick="location.href='modify?noticeId=${notice.noticeId}'">Modify</button>

				<button data-oper='list' class="btn btn-default btn-info"
					onclick="location.href='list'">List</button>

				<form id="operForm" action="admin/notice/modify" method='get'>
					<input type='hidden' id='noticeId' name='noticeId'
						value="${notice.noticeId}"> <input type='hidden'
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
			operForm.find("#noticeId").remove();
			operForm.attr("action", "list");
			operForm.submit();
		});
	});
</script>
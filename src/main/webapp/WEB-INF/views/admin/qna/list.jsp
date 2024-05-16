<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@include file="../includes/header.jsp"%>
<%@include file="../includes/leftNav.jsp"%>

	<div class="col-lg-10">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board List Page
				
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
			<!-- 검색조건 -->
				  <div class="row">       
				    <div class="col-lg-4">                    
				        <form id='searchForm' action="/admin/qna/list" method='get'>
				            <select name='type'>
				                <option value=""
				                    <c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--</option>
				                <option value="N"
				                    <c:out value="${pageMaker.cri.type eq 'N'?'selected':''}"/>>이름</option>
				                <option value="A"
				                    <c:out value="${pageMaker.cri.type eq 'A'?'selected':''}"/>>주소</option>
				                <option value="M"
				                    <c:out value="${pageMaker.cri.type eq 'M'?'selected':''}"/>>메일</option>
				                <option value="NM"
				                    <c:out value="${pageMaker.cri.type eq 'NM'?'selected':''}"/>>이름 or 메일</option>
				                <option value="NA"
				                    <c:out value="${pageMaker.cri.type eq 'NA'?'selected':''}"/>>이름 or 주소</option>
				                <option value="NAM"
				                    <c:out value="${pageMaker.cri.type eq 'NAM'?'selected':''}"/>>이름 or 주소 or 메일</option>
				            </select> 
				            <input type='text' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>' /> 
				            <input type='hidden' name='pageNum' value='<c:out value="${pageMaker.cri.pageNum}"/>' /> 
				            <input type='hidden' name='amount' value='<c:out value="${pageMaker.cri.amount}"/>' />
				            <button class='btn btn-default'>Search</button>
				        </form>
				    </div>
				    
				    <div class="col-lg-8 button-add">	
				     	<a href="/admin/qna/list" type="button" class="btn btn-xs btn-dark pull-right btn-info col-lg-2 mx-2 my-2"> 오름차순 </a>
				        <a href="/admin/qna/descList" type="button" class="btn btn-xs pull-right btn-info btn-warning col-lg-2 mx-2 my-2"> 내림차순 </a>				      
				        <button id="regBtn" type="button" class="btn btn-xs pull-right btn-info col-lg-1 mx-2 my-2" onclick="goToModalForm()"> 새글 </button>
				    </div>
				</div>
				<!-- end 검색조건 --> 
				<a href="/admin/qna/list" type="button" class="btn btn-xs btn-light pull-right btn-info col-lg-2 mx-2 my-2">검색해제 일반리스트 </a>
				<table width="80%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					
					<caption class="table-caption">회원 정보</caption>
					<thead>
						<tr>
						<c:forEach var="thead" items="${tableHead}">
							<th>${thead}</th>
						</c:forEach>
						</tr>
					<thead>
					<tbody>
						<c:forEach var="qna" items="${qnas}">
							<tr class="odd gradeX">
								<td><a href='#' id="${qna.qnaId}" onclick="goToDetailModalForm(this)">${qna.qnaId}</a></td>
								<td>${qna.qnaName}</td>
								<td>${qna.qnaPrice}</td>
								
								<td>${qna.qnaBrand}</td>
								<td>${qna.qnaCategory}</td>
								
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${qna.qnaRegdate}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- 페이지 처리 -->
				<div class="pull-right">
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button"><a class="page-link"
								href="${pageMaker.startPage-1}">Previous</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							
							<li class="paginate_button ${pageMaker.cri.pageNum == num ? 'active': ''} ">
							<a href="${num}">${num}</a></li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li class="paginate_button"><a href="${pageMaker.endPage+1}">Next</a></li>
						</c:if>
					</ul>
				</div>
				<!-- end 페이지 처리 -->

				<form id='actionForm' action="/admin/qna/list" method='get'>
					<input type='hidden' name='pageNum'
						value='${pageMaker.cri.pageNum}'> <input type='hidden'
						name='amount' value='${pageMaker.cri.amount}'>
														<input type='hidden' name='type' value='${pageMaker.cri.type}'>
								<input type='hidden' name='keyword' value='${pageMaker.cri.keyword}'>
				</form>


				<!-- The Modal -->
				<div class="modal" id="myModal">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">Modal Heading</h4>
								<button type="button" class="close" onclick="closeModal(this)">&times;</button>
							</div>
							<!-- Modal body -->
							<div class="modal-body-id">처리가 완료되었습니다.</div>

							<!-- Modal footer -->
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									onclick="closeModal(this)">Close</button>
							</div>
						</div>
					</div>
					<!-- end Modal -->


				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>

</div>
<!-- /#page-wrapper -->

</div>
<!-- 등록 모달 -->
<div class="modal" id="formModal" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-qnaName" id="cartModalLabel">회원 등록</h5>
				<button type="button" class="close" aria-label="Close"
					onclick="closeModal('#formModal')">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="registerForm" name="registerForm" role="form" action="register" method="post">


					<div class="form-group">
						<label for="qnaName">이름</label> <input type="text"
							class="form-control" name="qnaName"
							placeholder="이름을 입력하세요" required>
					</div>

					<div class="form-group">
						<label for="qnaDescription">비밀번호</label> <input type="text"
							class="form-control" name="qnaDescription"
							placeholder="비밀번호를 입력하세요" required>
					</div>

					<div class="form-group">
						<label for="qnaPrice">메일</label> <input type="text"
							class="form-control" name="qnaPrice"
							placeholder="메일 입력하세요" required>
					</div>

					<div class="form-group">
						<label for="qnaCategory">도로명 주소</label> <input type="text"
							class="form-control" name="qnaCategory"
							placeholder="도로명 주소를 입력하세요" required>
					</div>

					<div class="form-group">
						<label for="qnaBrand">지번 주소</label> <input type="text"
							class="form-control" name="qnaBrand"
							placeholder="지번 주소를 입력하세요" required>
					</div>

					<div class="form-group">
						<label for="qnaImageURL">상세 주소</label> <input type="text"
							class="form-control" name="qnaImageURL"
							placeholder="상세 주소를 입력하세요" required>
					</div>

				
					

					<button type="submit" class="btn btn-default btn-success">Submit Button</button>
					<button type="reset" class="btn btn-secondary">다시 작성</button>
					<button type="button" class="btn btn-secondary" onclick="closeModal(this)">list</button>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- 상세 수정 삭제 모달 -->
<div class="modal" id="formModal2" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-qnaName" id="cartModalLabel">회원 수정</h5>
				<button type="button" class="close" aria-label="Close"
					onclick="closeModal('formModal2')">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="modifyForm" action="modify" method="post" enctype="multipart/form-data">
	        
				<div class="form-group">
					<label>회원ID</label> <input class="form-control" name='qnaId'
						id='qnaId' readonly>
				</div>
				<div class="form-group">
					<label>이름</label> <input class="form-control"
						id='qnaName' name='qnaName'>
				</div>
				<div class="form-group">
					<label>비밀번호</label> <input class="form-control"
						id='qnaDescription' name='qnaDescription'>
				</div>
				<div class="form-group">
					<label>메일</label> <input class="form-control"
						id='qnaPrice' name='qnaPrice'>
				</div>
				<div class="form-group">
					<label>도로명 주소</label> <input class="form-control"
						id='qnaCategory' name='qnaCategory'>
				</div>
				<div class="form-group">
					<label>지번 주소</label> <input class="form-control"
						id='qnaBrand' name='qnaBrand'>
				</div>
				<div class="form-group">
					<label>상세 주소</label> <input class="form-control"
						id='qnaImageURL' name='qnaImageURL'>
				</div>
				
		
				
				<div class="form-group">
					<label for="qnaRegdate">가입일</label> <input type="date" id="qnaRegdate" class="form-control" readonly>					
				</div>
				<div class="form-group">
					<label for="qnaUpdateDate">가입일</label> <input type="date"
						id="qnaUpdateDate" class="form-control" readonly>					
				</div>
				

				
				
				<button type="submit" class="btn btn-default">Modify</button>
				<button type="submit" onclick="removeAction()" class="btn btn-danger">Remove</button>
				<button type="button" class="btn btn-secondary" onclick="closeModal(this)">list</button>
				<input type="hidden" id="currentPath" name="currentPath" value="">
				</form>
			</div>
		</div>
	</div>
</div>


<%@include file="../includes/footer.jsp"%>



<script>
	$(document).ready(function() {
		var newPath = updateActionUrl();
		
		var actionForm = $("#actionForm");
		$(".paginate_button a").on(
				"click",
				function(e) {
					e.preventDefault();
					console.log("click");
	
					actionForm.find("input[name='pageNum']")
							.val($(this).attr("href"));
				    actionForm.attr("action", newPath);
					actionForm.submit();
				}
		);
		
		
		$(".button-add a").on("click", function(e) {
		    e.preventDefault();
		    var href = $(this).attr("href");
		    actionForm.attr("action", href); // 클릭한 앵커의 href 값을 action 속성 값으로 설정
		    actionForm.submit();
		});
		
		
		
		
		
		var searchForm = $("#searchForm");
		$("#searchForm button").on("click", function(e){
			if(!searchForm.find("option:selected").val()){
				alert("검색종류를 선택하세요");
				return false;
			}

			if(!searchForm.find("input[name='keyword']").val()){
				alert("키워드를 입력하세요");
				return false;
			}
			searchForm.find("input[name='pageNum']").val("1");
			e.preventDefault();
			searchForm.attr("action", newPath);
			searchForm.submit();
			
		});
	});

	function updateActionUrl() {
	    var currentUrl = window.location.href;
	    var newPath;
	
	    if (currentUrl.includes("desc")) {
	    	newPath = "/admin/qna/descList";
	    } else {
	    	newPath = "/admin/qna/list";
	    }
	   
	    // 설정한 값으로 hidden input 업데이트
	    $("#currentPath").val(extractPageName(newPath));
	    return newPath;
	}
	
	function extractPageName(url) {
	    // URL에서 마지막 '/' 다음의 문자열을 추출
	    var lastSlashIndex = url.lastIndexOf('/');
	    var pageName = url.substring(lastSlashIndex + 1);
	    return pageName;
	}

	function removeAction(){
		$("#modifyForm").attr("action", "remove");
		$("#modifyForm").submit();
		var result = '${result}';
		console.log(result);
	}
	
	function checkModal(result) {
		if (result === '' || history.state) {
			return;
		} else {
			if (parseInt(result) > 0) {
				$(".modal-body-id").html("게시글" + parseInt(result) + "번이 등록되었습니다.");
			}
			
			console.log("ttttttttttttt")
			$("#myModal").modal("show");
		}
	}

	function goToModalForm() {
		$('#formModal').modal('show');
	}
	
	function closeModal(element) {
		$(element).closest('.modal').modal('hide');
	}
	
	function goToDetailModalForm(element) {
		console.log(element)
		
		let valueToSend = element.id;
		console.log(valueToSend)
		$.ajax({
			url: '/admin/qna/get/'+ valueToSend, // 서버의 URL
			type: 'get', // GET 또는 POST 요청
			data: { qnaId: valueToSend }, // post.id를 서버로 전달
			success: function(response) {
				$("#qnaId").val(response.qnaId);
				$("#qnaName").val(response.qnaName);
				$("#qnaDescription").val(response.qnaDescription);
				$("#qnaPrice").val(response.qnaPrice);
				$("#qnaCategory").val(response.qnaCategory);
				$("#qnaBrand").val(response.qnaBrand);
				$("#qnaImageURL").val(response.qnaImageURL);
				$().val(response.qnaRegdate);
				$("#qnaUpdateDate").val(response.qnaUpdateDate);
				var regDate = new Date(response.qnaRegdate);
				var isoDateString1 = regDate.toISOString().substring(0, 10);
				$("#qnaRegdate").val = isoDateString1;
				var regDate = new Date(response.qnaUpdateDate);
				var isoDateString2 = regDate.toISOString().substring(0, 10);
				$("#qnaUpdateDate").val = isoDateString2;
				$('#formModal2').modal('show');
			},
			error: function(xhr, status, error) {
				console.error('AJAX 요청 실패:', error);
			}
		});
	}


</script>






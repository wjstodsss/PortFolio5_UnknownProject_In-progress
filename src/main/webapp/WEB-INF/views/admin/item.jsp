<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@include file="includes/header.jsp"%>
<%@include file="includes/leftNav.jsp"%>

	<div class="col-lg-10">
		<div class="panel panel-default">
			<div class="panel-heading">
				Item List Page
				
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
			<!-- 검색조건 -->
				  <div class="row">       
				    <div class="col-lg-4">                    
				        <form id='searchForm' action="/admin/item/list" method='get' class='searchForm'>
				            <select class="custom-select" name='type'>
				                <option value=""
				                    <c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--</option>
				                <option value="P"
				                    <c:out value="${pageMaker.cri.type eq 'P'?'selected':''}"/>>상품명</option>
				                <option value="B"
				                    <c:out value="${pageMaker.cri.type eq 'B'?'selected':''}"/>>브랜드ID</option>
			                    <option value="C"
				                    <c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>카테고리ID</option>
				                <option value="I"
				                    <c:out value="${pageMaker.cri.type eq 'I'?'selected':''}"/>>상품번호</option>
				  
				            </select> 
				            <input type='text' class='custom-keyword' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>' /> 
				            <input type='hidden' name='pageNum' value='<c:out value="${pageMaker.cri.pageNum}"/>' /> 
				            <input type='hidden' name='amount' value='<c:out value="${pageMaker.cri.amount}"/>' />
				            <button class='btn custom-btn'>Search</button>
				        </form>
				    </div>
				    
				    <div class="col-lg-8 button-add">	
				     	<a href="/admin/item/list" type="button" class="btn btn-board btn-xs btn-dark pull-right btn-info col-lg-2 mx-2 my-2"> 오름차순 </a>
				        <a href="/admin/item/descList" type="button" class="btn btn-board btn-xs pull-right btn-info btn-warning col-lg-2 mx-2 my-2"> 내림차순</a>		       
				    </div>
				</div>
				<!-- end 검색조건 -->
				<button id="regBtn" type="button" class="btn btn-board btn-xs pull-right btn-info col-lg-1 mx-2 my-2" onclick="goToModalForm()"> 새글 </button>
				<a href="/admin/item/list" type="button" class="btn btn-board btn-xs btn-light pull-right btn-info col-lg-2 mx-2 my-2">검색해제 일반리스트 </a>
				<table width="80%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					
					<caption class="table-caption">상품</caption>
					<thead>
						<tr>
							<th>상품ID</th>
							<th>상품이미지</th>
                            <th>상품명</th>
                            <th>상품재고</th>
                            <th>가격</th>
                            <th>할인율</th>
                            <th>브랜드ID</th>
                            <th>카테고리</th>
                            <th>등록일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${items}">
							<tr class="odd gradeX">
								<td><a href='#' id="${item.itemId}" onclick="goToDetailModalForm(this)">${item.itemId}</a></td>
								<td><img src="/download/${item.itemImageURL}" alt="상품이미지" style="max-width: 70px"></td>
								<td>${item.itemName}</td>                             
                                <td>${item.itemStock}</td>
                                <td>${item.itemPrice}</td>
                                <td>${item.itemDiscount}</td>
                                <td>${item.brandName}</td>
                                <td>${item.cateName}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.regDate}" /></td>
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

				<form id='actionForm' action="/admin/item/list" method='get'>
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
								<button type="button" class="btn btn-danger" onclick="closeModal(this)">Close</button>
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
				<h5 class="modal-itemName" id="cartModalLabel">상품 등록</h5>
				<button type="button" class="close" aria-label="Close"
					onclick="closeModal('#formModal')">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="registerForm" name="registerForm" role="form" action="register" method="post" enctype="multipart/form-data">


					<div class="form-group">
						<label>상품명</label> <input type="text"
							class="form-control" name="itemName"
							placeholder="상품명을 입력하세요" required>
					</div>

                    <div class="form-group">
                        <label>브랜드</label> <input class="form-control"
                           name='brandId' placeholder="브랜드" required>
                     </div>
                     
                     <div class="form-group">
                        <label>제조연도</label> <input class="form-control"
                           name='mnfcYear' placeholder="제조연도" required>
                     </div>
                     
                     <div class="form-group">
                        <label>제조사</label> <input class="form-control"
                             name='manufacturer'placeholder="제조사" required>
                     </div>
                     
                     <div class="form-group">
                        <label>카테고리</label> <input class="form-control"
                             name='cateCode'placeholder="카테고리" required>
                     </div>
                     
                     <div class="form-group">
                        <label>가격</label> <input class="form-control"
                             name='itemPrice'placeholder="가격" required>
                     </div>
                     
                     <div class="form-group">
                        <label>재고</label> <input class="form-control"
                             name='itemStock' placeholder="재고" required>
                     </div>
                     <div class="form-group">
                        <label>할인율</label> <input class="form-control"
                            name='itemDiscount' placeholder="할인율" required>
                     </div>
                     
                     <div class="form-group">
                        <label>상품 소개</label> <textarea class="form-control"
                        rows="3" name='itemIntro' placeholder="상품 소개" required></textarea>
                     </div>
                     
                     <div class="form-group">
                        <label>상품 설명</label> <textarea class="form-control"
                        rows="5" name='itemContents' placeholder="상품 설명" required></textarea>
                     </div>

                    <div class="form-group">
                        <label for="uploadFile">uploadFile</label>
                        <input type="file" id="uploadFile" name="uploadFile" multiple>
                        <input type="hidden" value='defaltImage.jpg' name='brandName'>
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
				<h5 class="modal-itemName" id="cartModalLabel">회원 수정</h5>
				<button type="button" class="close" aria-label="Close"
					onclick="closeModal(this)">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="modifyForm" action="modify" method="post" enctype="multipart/form-data">
	        
				<div class="form-group">
					<label>상품 ID</label> <input class="form-control" name='itemId' id='itemId' readonly>
				</div>
				<div class="form-group">
					<label>상품명</label> <input class="form-control"
						id='itemName' name='itemName'>
                </div>

				<div class="form-group">
                    <label>브랜드</label> <ipnut class="form-control"
                        id='brandId' name='brandId'>
                </div>

                <div class="form-group">
                    <label>제조연도</label> <input class="form-control"
                        id='mnfcYear' name='mnfcYear'>
                </div>

                <div class="form-group">
                    <label>제조사</label> <input class="form-control"
                        id='manufacturer' name='manufacturer'>
                </div>

                <div class="form-group">
                    <label>카테고리</label> <input class="form-control"
                        id='cateCode' name='cateCode'>
                </div>

                <div class="form-group">
                    <label>가격</label> <input class="form-control"
                        id='itemPrice' name='itemPrice'>
                </div>

                <div class="form-group">
                    <label>재고</label> <input class="form-control"
                        id='itemStock' name='itemStock' readonly>
                </div>

                <div class="form-group">
                    <label>할인율</label> <input class="form-control"
                        id='itemDiscount' name='itemDiscount'>
                </div>

                <div class="form-group">
                    <label>상품 소개</label> <textarea class="form-control"
                    rows="3" id='itemIntro' name='itemIntro'></textarea>
                </div>

                <div class="form-group">
                    <label>상품 설명</label> <textarea class="form-control"
                    rows="5" id='itemContents' name='itemContents'></textarea>
                </div>
                

                <div class="form-group">
                    <input type='file' name='uploadFile' multiple>
                </div>

                <div class="form-group">
                    <label>변경전 이미지</label>
                    <div class="row">
                    	<img src="" alt="상품이미지" style="max-width: 250px" id='imageSRC'>
                    	<input type="hidden" name='itemImageURL' id='imageID'>
                    </div>
                </div>
			
                <div class="form-group">
					<label for="regDate">등록일</label> <input type="text"
						id="regDate" class="form-control" readonly>					
				</div>

                <div class="form-group">
					<label for="updateDate">수정일</label> <input type="text"
						id="updateDate" class="form-control" readonly>					
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

<%@include file="includes/footer.jsp"%>

<script>
function updateActionUrl() {
    var currentUrl = window.location.href;
    var newPath;

    if (currentUrl.includes("desc")) {
    	newPath = "/admin/item/descList";
    } else {
    	newPath = "/admin/item/list";
    }
   
    // 설정한 값으로 hidden input 업데이트
    $("#currentPath").val(extractPageName(newPath));
    return newPath;
}

function goToDetailModalForm(element) {
	console.log(element)
	
	let valueToSend = element.id;
	console.log(valueToSend)
	$.ajax({
		url: '/admin/item/get/'+ valueToSend, // 서버의 URL
		type: 'get', // GET 또는 POST 요청
		data: { itemId: valueToSend }, // post.id를 서버로 전달
		success: function(response) {
			$("#itemId").val(response.item.itemId);
			$("#itemName").val(response.item.itemName);
			$("#brandId").text(response.item.brandId);
			var mnfcYear = new Date(response.item.mnfcYear);
			var mnfcYearDateString = mnfcYear.toISOString().substring(0, 10);
			$("#mnfcYear").val(mnfcYearDateString);
			$("#manufacturer").val(response.item.manufacturer);
			$("#cateCode").val(response.item.cateCode);
			$("#itemPrice").val(response.item.itemPrice);
			$("#itemStock").val(response.item.itemStock);
			$("#itemDiscount").val(response.item.itemDiscount);
			$("#itemIntro").val(response.item.itemIntro);
			$("#itemContents").val(response.item.itemContents);
			var regDate = new Date(response.item.regDate);
			var regDateString = regDate.toISOString().substring(0, 10);
			$('#regDate').val(regDateString);
            var upDateDate = new Date(response.item.updateDate);
			var updateDateDateString = upDateDate.toISOString().substring(0, 10);
			$('#updateDate').val(updateDateDateString);
			$("#imageSRC").attr("src", "/download/" + response.item.itemImageURL);
	        $("#imageID").val(response.item.itemImageURL);
			$('#formModal2').modal('show');
		},
		error: function(xhr, status, error) {
			console.error('AJAX 요청 실패:', error);
		}
	});
	
	
}
</script>
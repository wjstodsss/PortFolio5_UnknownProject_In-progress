$(document).ready(function() {
	var newPath = updateActionUrl();
	var actionForm = $("#actionForm");
	var sortColumnValue	= $("#sortColumn")
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
		var sortColumn = this.getAttribute('data-sortColumn');
		sortColumnValue.val(sortColumn);
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



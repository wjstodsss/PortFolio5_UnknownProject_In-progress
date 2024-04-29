<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   


<%@include file="../includes/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                          Board List Page
                          <button id="regBtn" type="button" class="btn btn-xs pull-right btn-info"> Register New Board</button>
                          
                          
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>제품ID</th>
                                        <th>제품이미지</th>
                                        <th>제품명</th>
                                        <th>제품설명</th>
                                        <th>제품가격</th>
                                        <th>카테고리</th>
                                        <th>브랜드</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                <tbody>
                                  <c:forEach var="notice" items="${notices}">
                                     <tr class="odd gradeX">
                                        <td>${notice.noticeId}</td>
                                        <td>
                                        	<a class="move" href='${notice.noticeId}'>
                                        		<img src="upload/${notice.noticeImageURL}" alt="Notice Image" style="max-width: 100px;">
                                        	</a>
                                        </td>
                                        <td><a class="move" href='${notice.noticeId}'> ${notice.noticeName}</a> </td>
                                        <td>${notice.noticeDescription}</td>
                                        <td>${notice.noticePrice}</td>
                                        <td>${notice.noticeCategory}</td>
                                        <td>${notice.noticeBrand}</td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${notice.noticeRegdate}"/></td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${notice.noticeUpdateDate}"/></td>
                                     </tr>
                                  
                                  </c:forEach>
                                   
                                </tbody>
                            </table>
                        
                                                   
							<!-- 페이지 처리 -->
							<div class="pull-right">
							   <ul class="pagination">
							        <c:if test="${pageMaker.prev}">
								   <li class="paginate_button"><a class="page-link" href="${pageMaker.startPage-1}">Previous</a></li>
							        </c:if>
							
							        <c:forEach var = "num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">			   
							           <li class="paginate_button ${pageMaker.cri.pageNum == num ? 'active': ''} "><a href="${num}">${num}</a></li>	
							       </c:forEach>
														    
							      <c:if test="${pageMaker.next}">
								<li  class="paginate_button"><a href="${pageMaker.endPage+1}">Next</a></li>
							     </c:if>
							   </ul>
							</div> 
							<!-- end 페이지 처리 --> 
                        
		                       <form id='actionForm' action="/admin/notice/list" method='get'>
									<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
									<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
								</form>
		                        
                        
                            <!-- The Modal -->
							<div class="modal" id="myModal">
								<div class="modal-dialog">
									<div class="modal-content">
			
										<!-- Modal Header -->
										<div class="modal-header">
											<h4 class="modal-title">Modal Heading</h4>
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>
										<!-- Modal body -->
										<div class="modal-body">처리가 완료되었습니다.</div>
			
										<!-- Modal footer -->
										<div class="modal-footer">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal">Close</button>
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
    
    
    <%@include file="../includes/footer.jsp" %>
    
    
    
    <script>
	    $(document).ready(function(){
	        var actionForm = $("#actionForm");
	        var result = '${result}';
	        console.log(result + "kkkkkk");
	
	        $(".paginate_button a").on("click", function(e){
	            e.preventDefault();
	            console.log("click");
	
	            actionForm.find("input[name='pageNum']").val($(this).attr("href"));
	            actionForm.submit();    
	        });
	
	        $(".move").on("click", function(e){
	            e.preventDefault();
	            actionForm.append("<input type='hidden' name='noticeId' value='" + $(this).attr("href") + "'>");
	            actionForm.attr("action", "get");
	            actionForm.submit();
	        });
	
	       checkModal(result);
	       
	
	        history.replaceState({}, null, null);
	
	        $("#regBtn").on("click", function(){
	            self.location="register";
	        });
	    });
	    
	    function checkModal(result){
	        if(result ===''  || history.state){
	            return;
	        } else {
	            if(parseInt(result) > 0){
	                $(".modal-body").html("게시글" + parseInt(result) + "번이 등록되었습니다.");
	            }
	            $("#myModal").modal("show");
	        }
	    }
	
	    

    </script>
    
    
    
    
    
    
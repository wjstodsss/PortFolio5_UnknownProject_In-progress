<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">${pageHeader}</h1>
    </div>
</div>

<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">${panelHeading}</div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="form-group">
                    <label>${dataLabel}</label>
                    <input class="form-control" name='${dataName}' value='${dataValue}' readonly>
                </div>

                <div class="form-group">
                    <label>${descriptionLabel}</label>
                    <textarea class="form-control" rows="3" name='${descriptionName}' readonly>${dataDescription}</textarea>
                </div>

                <div class="form-group">
                    <label>${priceLabel}</label>
                    <input class="form-control" name='${priceName}' value='${dataPrice}' readonly>
                </div>
                
                <%-- 가변적인 변수들을 출력 --%>
                <c:forEach var="additionalVar" items="${additionalVariables}">
                    <div class="form-group">
                        <label>${additionalVar.label}</label>
                        <%-- 출력 변수가 이미지 태그인 경우 --%>
                        <c:if test="${additionalVar.type eq 'image'}">
                            <img src="${additionalVar.value}" alt="${additionalVar.altText}">
                        </c:if>
                        <%-- 출력 변수가 인풋 태그인 경우 --%>
                        <c:if test="${additionalVar.type eq 'input'}">
                            <input class="form-control" name='${additionalVar.name}' value='${additionalVar.value}' readonly>
                        </c:if>
                    </div>
                </c:forEach>

                <button data-oper='modify' class="btn btn-default btn-success"
                        onclick="location.href='${modifyUrl}${dataId}'">Modify</button>

                <button data-oper='list' class="btn btn-default btn-info"
                        onclick="location.href='${listUrl}'">List</button>

                <form id="operForm" action="${modifyAction}" method='get'>
                    <input type='hidden' id='${dataIdParamName}' name='${dataIdParamName}' value="${dataId}">
                    <input type='hidden' name='pageNum' value="${cri.pageNum}">
                    <input type='hidden' name='amount' value="${cri.amount}">
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
            operForm.attr("action", "${modifyAction}").submit();
        });

        $("button[data-oper='list']").on("click", function(e) {
            operForm.find("#${dataIdParamName}").remove();
            operForm.attr("action", "${listAction}");
            operForm.submit();
        });
    });
</script>

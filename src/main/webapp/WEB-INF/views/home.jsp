<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="admin/product/list">관리자 제품</a>
<a href="admin/member/list">관리자 회원</a>
<a href="admin/notice/list">관리자 공지</a>
<a href="admin/qna/list">관리자 qna</a>
<a href="admin/faq/list">관리자 faq</a>
<a href="admin/review/list">관리자 review</a>
<a href="productDetails">테스트</a>
</body>
</html>

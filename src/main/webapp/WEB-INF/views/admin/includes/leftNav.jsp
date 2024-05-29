<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   


            <!-- /.row -->
            <div class="row">
            	<!-- 좌측 네비게이션 -->
            <div class="col-lg-2 bg-dark text-light"> <!-- 배경색과 텍스트색을 다크 테마로 변경 -->
                <h1 class="mt-5">Admin Page</h1>
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <!-- 네비게이션도 다크 테마로 변경 -->
                    <div class="container-fluid">
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav flex-column"> <!-- flex-column 클래스 추가 -->
                            
                            	 <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown1" role="button" data-bs-toggle="collapse" data-bs-target="#submenu1" aria-expanded="false" aria-controls="submenu1">
                                        상품 작업
                                    </a>
                                    <ul class="collapse dropdown-list" id="submenu1" aria-labelledby="navbarDropdown1">
                                        <li><a class="dropdown-item text-light" href="/admin/item/list">상품 관리</a></li>
                                        <li><a class="dropdown-item text-light" href="/admin/item/stock/list">재고 관리</a></li>
                                        <li><a class="dropdown-item text-light" href="/admin/item/log/list">발주/입고 이력</a></li>
                                    </ul>
                                </li>
                            
                            	<li class="nav-board dropdown">
                                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown2" role="button" data-bs-toggle="collapse" data-bs-target="#submenu2" aria-expanded="false" aria-controls="submenu2">
                                        게시판 관리
                                    </a>
                                    <ul class="collapse dropdown-list" id="submenu2" aria-labelledby="navbarDropdown2">
                                        <li><a class="dropdown-item text-light" href="/admin/notice/list">공지사항</a></li>
                                        <li><a class="dropdown-item text-light" href="/admin/faq/list">자주 찾는 문의</a></li>
                                        <li><a class="dropdown-item text-light" href="/admin/review/list">구매 후기</a></li>
                                         <li><a class="dropdown-item text-light" href="/admin/qna/list">질의응답</a></li>
                                    </ul>
                                </li>
                                
                               

                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
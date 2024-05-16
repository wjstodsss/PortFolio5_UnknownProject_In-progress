<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   


            <!-- /.row -->
            <div class="row">
            	<!-- 좌측 네비게이션 -->
            <div class="col-lg-2 bg-dark text-light"> <!-- 배경색과 텍스트색을 다크 테마로 변경 -->
                <h1 class="mt-5">Admin dashboard</h1>
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <!-- 네비게이션도 다크 테마로 변경 -->
                    <div class="container-fluid">
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav flex-column"> <!-- flex-column 클래스 추가 -->
                                <li class="nav-item dropdown"> <!-- 상품 관리 -->
                                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown1" role="button" data-bs-toggle="collapse" data-bs-target="#submenu1" aria-expanded="false" aria-controls="submenu1">
                                        상품 관리
                                    </a>
                                    <ul class="collapse dropdown-list" id="submenu1" aria-labelledby="navbarDropdown1">
                                        <li><a class="dropdown-item text-light" href="#">상품 조회(상세/수정/삭제)</a></li>
                                        <li><a class="dropdown-item text-light" href="#">상품 등록</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item dropdown"> <!-- 재고 관리 -->
                                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown2" role="button" data-bs-toggle="collapse" data-bs-target="#submenu2" aria-expanded="false" aria-controls="submenu2">
                                        재고 관리
                                    </a>
                                    <ul class="collapse dropdown-list" id="submenu2" aria-labelledby="navbarDropdown2">
                                        <li><a class="dropdown-item text-light" href="#">재고 조회(발주 신청/취소)</a></li>
                                        <li><a class="dropdown-item text-light" href="#">입고 조회</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item dropdown"> <!-- 주문 관리 -->
                                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown3" role="button" data-bs-toggle="collapse" data-bs-target="#submenu3" aria-expanded="false" aria-controls="submenu3">
                                        주문 관리
                                    </a>
                                    <ul class="collapse dropdown-list" id="submenu3" aria-labelledby="navbarDropdown3">
                                        <li><a class="dropdown-item text-light" href="#">주문 조회</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item dropdown"> <!-- 배송 관리 -->
                                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown4" role="button" data-bs-toggle="collapse" data-bs-target="#submenu4" aria-expanded="false" aria-controls="submenu4">
                                        배송 관리
                                    </a>
                                    <ul class="collapse dropdown-list" id="submenu4" aria-labelledby="navbarDropdown4">
                                        <li><a class="dropdown-item text-light" href="#">배송 조회</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item dropdown"> <!-- 회원 관리 -->
                                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown5" role="button" data-bs-toggle="collapse" data-bs-target="#submenu5" aria-expanded="false" aria-controls="submenu5">
                                        회원 관리
                                    </a>
                                    <ul class="collapse dropdown-list" id="submenu5" aria-labelledby="navbarDropdown5">
                                        <li><a href="/admin/member/list" class="dropdown-item text-light">회원 조회(등록/수정/삭제)</a></li>
                                        <li><a class="dropdown-item text-light" href="#">혜택 관리</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item dropdown"> <!-- 매출 관리 -->
                                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown6" role="button" data-bs-toggle="collapse" data-bs-target="#submenu6" aria-expanded="false" aria-controls="submenu6">
                                        매출 관리
                                    </a>
                                    <ul class="collapse dropdown-list" id="submenu6" aria-labelledby="navbarDropdown6">
                                        <li><a class="dropdown-item text-light" href="#">매출 조회</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
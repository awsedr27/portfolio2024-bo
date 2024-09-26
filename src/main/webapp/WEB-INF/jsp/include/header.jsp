<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Portfolio-BO</title>
<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
    <style>
        body {
            display: flex;
		    flex-direction: column;
		    height: 100vh;
		    padding-bottom: 0; 
        }
        #relative-footer {
			height: 60px;
	    	text-align: center;
        }
        .container{
        	flex:1;
        }
        td, tr, th{
            text-align: center;
		    vertical-align: middle;
		    height: 100px;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/product/list">Portfolio-BO</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mb-2 mb-lg-0 justify-content-end w-100">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="/product/list">상품관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/review/list">리뷰관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/order/list">주문관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/category/list">카테고리관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/user/list">사용자관리</a>
        </li>
		<li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
			  <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z"/>
			</svg>
          </a>
          <ul class="dropdown-menu dropdown-menu-end">
            <li>
            <form action="/user/logout" method="post">
			    <button class="dropdown-item" type="submit">로그아웃</button>
			</form>
            </li>
          </ul>
        </li>
      </ul>
      
    </div>
  </div>
</nav>
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
    <a class="navbar-brand" href="/home">Portfolio-BO</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0 justify-content-end">
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
      </ul>
    </div>
  </div>
</nav>
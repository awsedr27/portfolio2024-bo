<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp" %>

    <div class="container">
        <h1>오류 발생</h1>
        <div class="alert alert-danger">
            <c:out value="${errorMessage}"/>
        </div>
        <a href="<c:url value='/home'/>" class="btn btn-primary">홈으로 돌아가기</a>
    </div>
    
<%@ include file="include/footer.jsp" %>

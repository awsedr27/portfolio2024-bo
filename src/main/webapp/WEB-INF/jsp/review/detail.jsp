<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<div class="container">
    <h1 class="mb-4"><c:out value="리뷰상세"/></h1>
    
    <div class="form-group">
        <label for="productName">상품이름</label>
        <input type="text" class="form-control" id="productName" name="productName" value="<c:out value='${review.productName}'/>"readonly disabled>
    </div>
    <div class="form-group">
        <label for="userNickName">리뷰 작성자</label>
        <input type="text" class="form-control" id="userNickName" name="userNickName" value="<c:out value='${review.userNickName}'/>"readonly disabled>
    </div>
    
    <div class="form-group">
        <label for="rating">평점</label>
        <input type="number" class="form-control" id="rating" value="<c:out value='${review.rating}'/>" readonly disabled>
    </div>
    <div class="form-group">
        <label for="comment">리뷰 내용</label>
        <textarea class="form-control" id="comment" rows="3" readonly disabled><c:out value='${review.comment}'/></textarea>
    </div>
    
    <form action="<c:url value="/review/update"/>" method="post">
	    
	    <div class="form-group">
	        <label for="reviewId">리뷰 ID</label>
	        <input style="background-color:#e9ecef" type="number" class="form-control" id="reviewId" name="reviewId" value="<c:out value='${review.reviewId}'/>"required readonly>
	    </div>
        <div class="form-group">
            <label for="replyContent">답글 내용</label>
            <textarea class="form-control" id="reply" name="reply" rows="3"><c:out value='${review.reply}'/></textarea>
        </div>
        <div class="form-group">
            <label for="useYn">리뷰 상태</label>
            <select class="form-control" id="useYn" name="useYn" required>
                <option value="Y" <c:if test="${review.useYn == 'Y'}">selected</c:if>>예</option>
                <option value="N" <c:if test="${review.useYn == 'N'}">selected</c:if>>아니오</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary"><c:out value="답글등록/리뷰수정"/></button>
    </form>
</div>

<%@ include file="../include/footer.jsp" %>

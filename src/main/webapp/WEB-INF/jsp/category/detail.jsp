<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
        
<div class="container">
    <h1 class="mb-4"><c:out value="${category.categoryId == null ? '카테고리 등록' : '카테고리 수정'}"/></h1>
    <form action="<c:url value="${category.categoryId == null ? '/category/save' : '/category/update'}"/>" method="post">
        <c:if test="${category.categoryId != null}">
            <div class="form-group">
                <label for="categoryId">카테고리 ID</label>
                <input type="text" class="form-control" id="categoryId" name="categoryId" value="<c:out value='${category.categoryId}'/>" readonly>
            </div>
        </c:if>
        <div class="form-group">
            <label for="name">카테고리명</label>
            <input type="text" class="form-control" id="name" name="name" value="<c:out value='${category.name}'/>" required>
        </div>
        <div class="form-group">
            <label for="description">설명</label>
            <textarea class="form-control" id="description" name="description" rows="3" required><c:out value='${category.description}'/></textarea>
        </div>
        <div class="form-group">
            <label for="useYn">사용 여부</label>
            <select class="form-control" id="useYn" name="useYn" required>
                <option value="Y" <c:if test="${category.useYn == 'Y'}">selected</c:if>>예</option>
                <option value="N" <c:if test="${category.useYn == 'N'}">selected</c:if>>아니오</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary mt-4"><c:out value="${category.categoryId == null ? '등록' : '수정'}"/></button>
    </form>
</div>

<%@ include file="../include/footer.jsp" %>

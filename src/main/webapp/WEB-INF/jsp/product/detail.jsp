<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
        

    <div class="container">
        <h1 class="mb-4"><c:out value="${product.productId == null ? '상품 등록' : '상품 수정'}"/></h1>
        <form action="<c:url value="${product.productId == null ? '/product/save' : '/product/update'}"/>" method="post">
            <c:if test="${product.productId != null}">
                <div class="form-group">
                    <label for="productId">상품 ID</label>
                    <input type="text" class="form-control" id="productId" name="productId" value="<c:out value='${product.productId}'/>" readonly>
                </div>
            </c:if>
            <div class="form-group">
                <label for="name">상품명</label>
                <input type="text" class="form-control" id="name" name="name" value="<c:out value='${product.name}'/>" required>
            </div>
            <div class="form-group">
                <label for="description">설명</label>
                <textarea class="form-control" id="description" name="description" rows="3" required><c:out value='${product.description}'/></textarea>
            </div>
            <div class="form-group">
                <label for="useYn">사용 여부</label>
                <select class="form-control" id="useYn" name="useYn" required>
                    <option value="Y" <c:if test="${product.useYn == 'Y'}">selected</c:if>>예</option>
                    <option value="N" <c:if test="${product.useYn == 'N'}">selected</c:if>>아니오</option>
                </select>
            </div>
            <div class="form-group">
                <label for="price">가격</label>
                <input type="number" class="form-control" id="price" name="price" value="<c:out value='${product.price}'/>" required>
            </div>
            <div class="form-group">
                <label for="categoryId">카테고리</label>
                <select class="form-control" id="categoryId" name="categoryId" required>
                <option value="">All</option>
                    <c:forEach var="category" items="${categories}">
                        <option value="<c:out value='${category.categoryId}'/>" <c:if test="${category.categoryId == product.categoryId}">selected</c:if>><c:out value='${category.name}'/></option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary"><c:out value="${product.productId == null ? '등록' : '수정'}"/></button>
        </form>
    </div>



<%@ include file="../include/footer.jsp" %>

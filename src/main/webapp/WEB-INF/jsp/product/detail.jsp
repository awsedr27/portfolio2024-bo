<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
        

    <div class="container">
        <h1 class="mb-4"><c:out value="${product.productId == null ? '상품 등록' : '상품 수정'}"/></h1>
        <form action="<c:url value="${product.productId == null ? '/product/save' : '/product/update'}"/>" method="post" enctype="multipart/form-data">
            <c:if test="${product.productId != null}">
                <div class="form-group">
                    <label for="productId">상품 ID</label>
                    <input type="number" class="form-control" id="productId" name="productId" value="<c:out value='${product.productId}'/>" readonly>
                </div>
            </c:if>
            <div class="form-group">
                <label for="name">상품명</label>
                <input type="text" class="form-control" id="name" name="name" value="<c:out value='${product.name}'/>" required>
            </div>
            <div class="form-group">
                <label for="imageFile"><c:out value="${product.productId == null ? '이미지 등록' : '이미지 수정'}"/></label>
                <input type="file" class="form-control" id="imageFile" name="imageFile" accept="image/*" required>
                <c:choose>
	            	<c:when test="${empty product.imageUrl}">
	                	<img id="preview" src="#" alt="Image preview" style="display:none;">
	                </c:when>
	                <c:otherwise>
	                	<c:url var="imgUrl" value="/images/${product.imageUrl}">
	                	</c:url>
                    	<img id="preview" src="<c:out value='${imgUrl}'/>" alt="Image preview" style="display:block;">

	                </c:otherwise>
	            </c:choose>
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
                <label for="price">수량</label>
                <input type="number" class="form-control" id="quantity" name="quantity" value="<c:out value='${product.quantity}'/>" required>
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
    <script>
        document.getElementById('imageFile').addEventListener('change', function(event) {
            const file = event.target.files[0];
            const maxSize = 5 * 1024 * 1024; // 5MB
            if (file) {
                if (file.size > maxSize) {
                    alert("파일 크기가 너무 큽니다. 최대 5MB까지 업로드할 수 있습니다.");
                    event.target.value = ""; 
                    return;
                }
                const reader = new FileReader();
                reader.onload = function(e) {
                    const preview = document.getElementById('preview');
                    preview.src = e.target.result;
                    preview.style.display = 'block';
                    preview.style.width='400px';
                    preview.style.height='400px';
                }
                reader.readAsDataURL(file);
            } else {
                const preview = document.getElementById('preview');
                preview.src = '#';
                preview.style.display = 'none';
            }
        });
    </script>


<%@ include file="../include/footer.jsp" %>

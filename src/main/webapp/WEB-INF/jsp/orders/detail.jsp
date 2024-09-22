<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<div class="container">

    <h2 class="mb-4 mt-4">주문 정보</h2>
    
    
    <form action="<c:url value="/order/update"/>" method="post">
	    <div class="form-group">
	        <label for="orderId">주문번호</label>
	        <input type="number" class="form-control" id="orderId" name="orderId" value="<c:out value='${order.orderId}'/>" disabled>
	    </div>
	    <div class="form-group">
	        <label for="createDate">주문일</label>
	        <input type="text" class="form-control" id="createDate" name="createDate" value="<c:out value='${order.createDate}'/>" disabled>
	    </div>
	    <div class="form-group">
	        <label for="userNickName">주문자닉네임</label>
	        <input type="text" class="form-control" id="userNickName" name="userNickName" value="<c:out value='${order.userNickName}'/>" disabled>
	    </div>
	    <div class="form-group">
	        <label for="totalPrice">총 가격</label>
	        <input type="number" class="form-control" id="totalPrice" name="totalPrice" value="<c:out value='${order.totalPrice}'/>" disabled>
	    </div>
	    <div class="form-group">
	        <label for="postcode">우편번호</label>
	        <input type="text" class="form-control" id="postcode" name="postcode" value="<c:out value='${order.postcode}'/>" required>
	    </div>
	    <div class="form-group">
	        <label for="roadAddress">도로주소</label>
	        <input type="text" class="form-control" id="roadAddress" name="roadAddress" value="<c:out value='${order.roadAddress}'/>" required>
	    </div>
	    <div class="form-group">
	        <label for="jibunAddress">지번주소</label>
	        <input type="text" class="form-control" id="jibunAddress" name="jibunAddress" value="<c:out value='${order.jibunAddress}'/>" required>
	    </div>
	    <div class="form-group">
	        <label for="detailAddress">상세주소</label>
	        <input type="text" class="form-control" id="detailAddress" name="detailAddress" value="<c:out value='${order.detailAddress}'/>" required>
	    </div>
        <div class="form-group me-2">
            <label for="status" class="me-2">주문상태</label>
            <select id="status" name="status" class="form-control" required>
                <option value="PENDING" <c:if test="${order.status == 'PENDING'}">selected</c:if> >준비중</option>
                <option value="PROCESSING" <c:if test="${order.status == 'PROCESSING'}">selected</c:if> >진행중</option>
                <option value="SHIPPED" <c:if test="${order.status == 'SHIPPED'}">selected</c:if> >배송중</option>
                <option value="COMPLETED" <c:if test="${order.status == 'COMPLETED'}">selected</c:if> >완료</option>
                <option value="CANCELLED" <c:if test="${order.status == 'CANCELLED'}">selected</c:if> >취소</option>
            </select>     
			<div class="alert alert-primary d-flex align-items-center" role="alert">
			  <svg style="width: 17px;" xmlns="http://www.w3.org/2000/svg" class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Warning:">
			    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
			  </svg>
			  <div>
			    주문상태를 변경하면 주문 상품 상태가 전부 변경됩니다
			  </div>
			</div> 
        </div>
        <button type="submit" class="btn btn-primary mt-4"><c:out value="주문정보 수정"/></button>
    </form>
    
	<h2 class="mb-4 mt-4">주문 상품 목록</h2>    
    <table class="table table-hover" style="table-layout: fixed;">
        <thead>
            <tr>
				<th>상품이미지</th>
                <th>주문상품아이디</th>
                <th>상품이름</th>
                <th>수량</th>
                <th>가격</th>
                <th>주문일</th>
                <th>주문상품상태</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="orderItem" items="${order.orderItemList}">
                <tr>
					<td>
		                <c:choose>
			            	<c:when test="${empty orderItem.imageUrl}">
			                	<img id="preview" src="#" alt="Image preview" style="display:none;">
			                </c:when>
			                <c:otherwise>
			                	<c:url var="imgUrl" value="/images/${orderItem.imageUrl}">
			                	</c:url>
		                    	<img id="preview" src="<c:out value='${imgUrl}'/>" alt="Image preview" style="display:block;width:100%;height:auto">
		
			                </c:otherwise>
			            </c:choose>
					</td>
                    <td class="text-truncate"><c:out value='${orderItem.orderItemId}'/></td>
                    <td class="text-truncate"><c:out value='${orderItem.productName}'/></td>
                    <td class="text-truncate"><c:out value='${orderItem.quantity}'/></td>
                    <td class="text-truncate"><c:out value='${orderItem.price}'/></td>
                    <td class="text-truncate"><c:out value='${orderItem.orderItemCreateDate}'/></td>
                    <td class="text-truncate">
			            <select id="orderItemStatus" name="orderItemStatus" class="form-control" style="text-align:center" required>
			                <option value="PENDING" <c:if test="${orderItem.orderItemStatus == 'PENDING'}">selected</c:if> >준비중</option>
			                <option value="PROCESSING" <c:if test="${orderItem.orderItemStatus == 'PROCESSING'}">selected</c:if> >진행중</option>
			                <option value="SHIPPED" <c:if test="${orderItem.orderItemStatus == 'SHIPPED'}">selected</c:if> >배송중</option>
			                <option value="COMPLETED" <c:if test="${orderItem.orderItemStatus == 'COMPLETED'}">selected</c:if> >완료</option>
			                <option value="CANCELLED" <c:if test="${orderItem.orderItemStatus == 'CANCELLED'}">selected</c:if> >취소</option>
			            </select>     
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="../include/footer.jsp" %>

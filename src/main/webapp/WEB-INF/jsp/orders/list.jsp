<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>


<div class="container">
 <h1 class="mb-4 mt-4">주문 목록</h1>
 
	<form method="get" action="/order/list" class="form-inline mb-3">
        <div class="form-group me-2">
            <label for="orderId" class="me-2">주문번호</label>
            <input type="number" id="orderId" name="orderId" class="form-control" value="<c:out value="${search.orderId}"/>">
        </div>
        <div class="form-group me-2">
            <label for="userNickName" class="me-2">유저닉네임</label>
            <input type="number" id="userNickName" name="userNickName" class="form-control" value="<c:out value="${search.userNickName}"/>">
        </div>
        <div class="form-group me-2">
            <label for="status" class="me-2">주문상태</label>
            <select id="status" name="status" class="form-control">
                <option value="">All</option>
                <option value="PENDING" <c:if test="${param.status == 'PENDING'}">selected</c:if> >준비중</option>
                <option value="PROCESSING" <c:if test="${param.status == 'PROCESSING'}">selected</c:if> >진행중</option>
                <option value="SHIPPED" <c:if test="${param.status == 'SHIPPED'}">selected</c:if> >배송중</option>
                <option value="COMPLETED" <c:if test="${param.status == 'COMPLETED'}">selected</c:if> >완료</option>
                <option value="CANCELLED" <c:if test="${param.status == 'CANCELLED'}">selected</c:if> >취소</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary mt-4">검색</button>
    </form>
    <table class="table table-hover" style="table-layout: fixed;">
        <thead>
            <tr>
                <th>주문번호</th>
                <th>유저닉네임</th>
                <th>전체 가격</th>
                <th>주문상태</th>
                <th>주문일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="order" items="${order}">
	            <c:url var="OrderDetailUrl" value="/order/detail">
	            	<c:param name="orderId" value="${order.orderId}" />
	            </c:url>
				<tr style="cursor: pointer;" onclick="window.location.href='<c:out value="${OrderDetailUrl}"/>'">
                    <td class="text-truncate"><c:out value="${order.orderId}"/></td>
                    <td class="text-truncate"><c:out value="${order.userNickName}"/></td>
                    <td class="text-truncate"><c:out value="${order.totalPrice}"/></td>
                    <td class="text-truncate">
					    <c:choose>
					        <c:when test="${order.status == 'PENDING'}">준비중</c:when>
					        <c:when test="${order.status == 'PROCESSING'}">진행중</c:when>
					        <c:when test="${order.status == 'SHIPPED'}">배송중</c:when>
					        <c:when test="${order.status == 'COMPLETED'}">완료</c:when>
					        <c:when test="${order.status == 'CANCELLED'}">취소</c:when>
					        <c:otherwise>알 수 없음</c:otherwise>
					    </c:choose>
					</td>
                    <td class="text-truncate"><c:out value="${order.createDate}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
	<nav aria-label="Page navigation">
	    <ul class="pagination">
	        <c:if test="${paging.hasPreviousPage}">
	            <li class="page-item">
	                <c:url var="prevPageUrl" value="/order/list">
	                    <c:param name="page" value="${paging.firstPage - 1}" />
	                    <c:if test="${not empty search.orderId}">
	                        <c:param name="orderId" value="${search.orderId}" />
	                    </c:if>
	                    <c:if test="${not empty search.userNickName}">
	                        <c:param name="userNickName" value="${search.userNickName}" />
	                    </c:if>
	                    <c:if test="${not empty search.status}">
	                        <c:param name="status" value="${search.status}" />
	                    </c:if>
	                </c:url>
	                <a class="page-link" href="<c:out value='${prevPageUrl}'/>" aria-label="Previous">
	                    <span aria-hidden="true">&laquo;</span>
	                </a>
	            </li>
	        </c:if>
	        <c:forEach begin="${paging.firstPage}" end="${paging.lastPage}" var="pageNum">
	            <li class="page-item ${pageNum == paging.currentPage ? 'active' : ''}">
	                <c:url var="pageUrl" value="/order/list">
	                    <c:param name="page" value="${pageNum}" />
	                    <c:if test="${not empty search.orderId}">
	                        <c:param name="orderId" value="${search.orderId}" />
	                    </c:if>
	                    <c:if test="${not empty search.userNickName}">
	                        <c:param name="userNickName" value="${search.userNickName}" />
	                    </c:if>
	                    <c:if test="${not empty search.status}">
	                        <c:param name="status" value="${search.status}" />
	                    </c:if>
	                </c:url>
	                <a class="page-link" href="<c:out value='${pageUrl}'/>">
	                    <c:out value='${pageNum}'/>
	                </a>
	            </li>
	        </c:forEach>
	        <c:if test="${paging.hasNextPage}">
	            <li class="page-item">
	                <c:url var="nextPageUrl" value="/order/list">
	                    <c:param name="page" value="${paging.lastPage + 1}" />
	                    <c:if test="${not empty search.orderId}">
	                        <c:param name="orderId" value="${search.orderId}" />
	                    </c:if>
	                    <c:if test="${not empty search.userNickName}">
	                        <c:param name="userNickName" value="${search.userNickName}" />
	                    </c:if>
	                    <c:if test="${not empty search.status}">
	                        <c:param name="status" value="${search.status}" />
	                    </c:if>
	                </c:url>
	                <a class="page-link" href="<c:out value='${nextPageUrl}'/>" aria-label="Next">
	                    <span aria-hidden="true">&raquo;</span>
	                </a>
	            </li>
	        </c:if>
	    </ul>
	</nav>

</div>
<%@ include file="../include/footer.jsp" %>

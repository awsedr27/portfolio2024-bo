<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>


<div class="container">
 <h1 class="mb-4">주문 목록</h1>
 
	<form method="get" action="/order/list" class="form-inline mb-3">
        <div class="form-group mr-2">
            <label for="orderId" class="mr-2">Order ID</label>
            <input type="number" id="orderId" name="orderId" class="form-control" value="<c:out value="${search.orderId}"/>">
        </div>
        <div class="form-group mr-2">
            <label for="userId" class="mr-2">User ID</label>
            <input type="number" id="userId" name="userId" class="form-control" value="<c:out value="${search.userId}"/>">
        </div>
        <div class="form-group mr-2">
            <label for="status" class="mr-2">Status</label>
            <select id="status" name="status" class="form-control">
                <option value="">All</option>
                <option value="Pending" <c:if test="${param.status == 'Pending'}">selected</c:if> >Pending</option>
                <option value="Completed" <c:if test="${param.status == 'Completed'}">selected</c:if> >Completed</option>
                <option value="Cancelled" <c:if test="${param.status == 'Cancelled'}">selected</c:if> >Cancelled</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Filter</button>
    </form>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ORDER_ID</th>
                <th>USER_ID</th>
                <th>TOTAL_PRICE</th>
                <th>STATUS</th>
                <th>CREATE_DATE</th>
                <th>MODIFY_DATE</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="order" items="${order}">
	            <c:url var="OrderDetailUrl" value="/order/detail">
	            	<c:param name="orderId" value="${order.orderId}" />
	            </c:url>
				<tr style="cursor: pointer;" onclick="window.location.href='<c:out value="${OrderDetailUrl}"/>'">
                    <td><c:out value="${order.orderId}"/></td>
                    <td><c:out value="${order.userId}"/></td>
                    <td><c:out value="${order.totalPrice}"/></td>
                    <td><c:out value="${order.status}"/></td>
                    <td><c:out value="${order.createDate}"/></td>
                    <td><c:out value="${order.modifyDate}"/></td>
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
	                    <c:if test="${not empty search.userId}">
	                        <c:param name="userId" value="${search.userId}" />
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
	                    <c:if test="${not empty search.userId}">
	                        <c:param name="userId" value="${search.userId}" />
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
	                    <c:if test="${not empty search.userId}">
	                        <c:param name="userId" value="${search.userId}" />
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

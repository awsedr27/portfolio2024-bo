<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<div class="container">
    <h1 class="mb-4">리뷰 관리</h1>
    
    <form method="get" action="/review/list" class="form-inline mb-3">
        <div class="form-group mr-2">
            <label for="reviewId" class="mr-2">Review ID</label>
            <input type="number" id="reviewId" name="reviewId" class="form-control" value="<c:out value="${search.reviewId}"/>">
        </div>
        <div class="form-group mr-2">
            <label for="productId" class="mr-2">Product ID</label>
            <input type="number" id="productId" name="productId" class="form-control" value="<c:out value="${search.productId}"/>">
        </div>
        <div class="form-group mr-2">
            <label for="userId" class="mr-2">User ID</label>
            <input type="text" id="userId" name="userId" class="form-control" value="<c:out value="${search.userId}"/>">
        </div>
        <div class="form-group mr-2">
            <label for="useYn" class="mr-2">Use Y/N</label>
            <select id="useYn" name="useYn" class="form-control">
                <option value="">All</option>
                <option value="Y" <c:if test="${search.useYn == 'Y'}">selected</c:if> >Y</option>
                <option value="N" <c:if test="${search.useYn == 'N'}">selected</c:if> >N</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Filter</button>
    </form>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Review ID</th>
                <th>Product ID</th>
                <th>User ID</th>
                <th>Use Y/N</th>
                <th>Rating</th>
                <th>Comment</th>
                <th>Reply</th>
                <th>Create Date</th>
                <th>Modify Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="review" items="${reviewList}">
                <c:url var="ReviewDetailUrl" value="/review/detail">
                    <c:param name="reviewId" value="${review.reviewId}" />
                </c:url>
                <tr style="cursor: pointer;" onclick="window.location.href='<c:out value="${ReviewDetailUrl}"/>'">
                    <td><c:out value="${review.reviewId}"/></td>
                    <td><c:out value="${review.productId}"/></td>
                    <td><c:out value="${review.userId}"/></td>
                    <td><c:out value="${review.useYn}"/></td>
                    <td><c:out value="${review.rating}"/></td>
                    <td><c:out value="${review.comment}"/></td>
                    <td><c:out value="${review.reply}"/></td>
                    <td><c:out value="${review.createDate}"/></td>
                    <td><c:out value="${review.modifyDate}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${paging.hasPreviousPage}">
                <li class="page-item">
                    <c:url var="prevPageUrl" value="/review/list">
                        <c:param name="page" value="${paging.firstPage - 1}" />
                        <c:if test="${not empty search.reviewId}">
                            <c:param name="reviewId" value="${search.reviewId}" />
                        </c:if>
                        <c:if test="${not empty search.productId}">
                            <c:param name="productId" value="${search.productId}" />
                        </c:if>
                        <c:if test="${not empty search.userId}">
                            <c:param name="userId" value="${search.userId}" />
                        </c:if>
                        <c:if test="${not empty search.useYn}">
                            <c:param name="useYn" value="${search.useYn}" />
                        </c:if>
                    </c:url>
                    <a class="page-link" href="<c:out value='${prevPageUrl}'/>" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <c:forEach begin="${paging.firstPage}" end="${paging.lastPage}" var="pageNum">
                <li class="page-item ${pageNum == paging.currentPage ? 'active' : ''}">
                    <c:url var="pageUrl" value="/review/list">
                        <c:param name="page" value="${pageNum}" />
                        <c:if test="${not empty search.reviewId}">
                            <c:param name="reviewId" value="${search.reviewId}" />
                        </c:if>
                        <c:if test="${not empty search.productId}">
                            <c:param name="productId" value="${search.productId}" />
                        </c:if>
                        <c:if test="${not empty search.userId}">
                            <c:param name="userId" value="${search.userId}" />
                        </c:if>
                        <c:if test="${not empty search.useYn}">
                            <c:param name="useYn" value="${search.useYn}" />
                        </c:if>
                    </c:url>
                    <a class="page-link" href="<c:out value='${pageUrl}'/>">
                        <c:out value='${pageNum}'/>
                    </a>
                </li>
            </c:forEach>
            <c:if test="${paging.hasNextPage}">
                <li class="page-item">
                    <c:url var="nextPageUrl" value="/review/list">
                        <c:param name="page" value="${paging.lastPage + 1}" />
                        <c:if test="${not empty search.reviewId}">
                            <c:param name="reviewId" value="${search.reviewId}" />
                        </c:if>
                        <c:if test="${not empty search.productId}">
                            <c:param name="productId" value="${search.productId}" />
                        </c:if>
                        <c:if test="${not empty search.userId}">
                            <c:param name="userId" value="${search.userId}" />
                        </c:if>
                        <c:if test="${not empty search.useYn}">
                            <c:param name="useYn" value="${search.useYn}" />
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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<div class="container">
    <h1 class="mb-4 mt-4">리뷰 관리</h1>
    
    <form method="get" action="/review/list" class="form-inline mb-3">
        <div class="form-group me-2">
            <label for="productName" class="me-2">상품이름</label>
            <input type="text" id="productName" name="productName" class="form-control" value="<c:out value="${search.productName}"/>">
        </div>
        <div class="form-group me-2">
            <label for="userNickName" class="me-2">유저닉네임</label>
            <input type="text" id="userNickName" name="userNickName" class="form-control" value="<c:out value="${search.userNickName}"/>">
        </div>
        <div class="form-group me-2">
            <label for="useYn" class="me-2">게시여부</label>
            <select id="useYn" name="useYn" class="form-control">
                <option value="">All</option>
                <option value="Y" <c:if test="${search.useYn == 'Y'}">selected</c:if> >게시된리뷰</option>
                <option value="N" <c:if test="${search.useYn == 'N'}">selected</c:if> >삭제된리뷰</option>
            </select>
        </div>
        <div class="form-group me-2">
            <label for="replyYn" class="me-2">답변여부</label>
            <select id="replyYn" name="replyYn" class="form-control">
                <option value="">All</option>
                <option value="Y" <c:if test="${search.replyYn == 'Y'}">selected</c:if> >답변완료</option>
                <option value="N" <c:if test="${search.replyYn == 'N'}">selected</c:if> >답변미완료</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary mt-4">검색</button>
    </form>
    <table class="table table-hover" style="table-layout: fixed;">
        <thead>
            <tr>
                <th>리뷰번호</th>
                <th>상품이름</th>
                <th>유저닉네임</th>
                <th>게시여부</th>
                <th>별점</th>
                <th>리뷰내용</th>
                <th>관리자대답유무</th>
                <th>작성일</th>
                <th>수정일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="review" items="${reviewList}">
                <c:url var="ReviewDetailUrl" value="/review/detail">
                    <c:param name="reviewId" value="${review.reviewId}" />
                </c:url>
                <tr style="cursor: pointer;" onclick="window.location.href='<c:out value="${ReviewDetailUrl}"/>'">
                    <td class="text-truncate"><c:out value="${review.reviewId}"/></td>
                    <td class="text-truncate"><c:out value="${review.productName}"/></td>
                    <td class="text-truncate"><c:out value="${review.userNickName}"/></td>
                    <td class="text-truncate"><c:out value="${review.useYn}"/></td>
                    <td class="text-truncate"><c:out value="${review.rating}"/></td>
                    <td class="text-truncate"><c:out value="${review.comment}"/></td>
                    <td class="text-truncate"><c:out value="${review.reply}"/></td>
                    <td class="text-truncate"><c:out value="${review.createDate}"/></td>
                    <td class="text-truncate"><c:out value="${review.modifyDate}"/></td>
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
                        <c:if test="${not empty search.productName}">
                            <c:param name="productName" value="${search.productName}" />
                        </c:if>
                        <c:if test="${not empty search.userNickName}">
                            <c:param name="userNickName" value="${search.userNickName}" />
                        </c:if>
                        <c:if test="${not empty search.useYn}">
                            <c:param name="useYn" value="${search.useYn}" />
                        </c:if>
                        <c:if test="${not empty search.replyYn}">
                            <c:param name="replyYn" value="${search.replyYn}" />
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
                        <c:if test="${not empty search.productName}">
                            <c:param name="productName" value="${search.productName}" />
                        </c:if>
                        <c:if test="${not empty search.userNickName}">
                            <c:param name="userNickName" value="${search.userNickName}" />
                        </c:if>
                        <c:if test="${not empty search.useYn}">
                            <c:param name="useYn" value="${search.useYn}" />
                        </c:if>
                        <c:if test="${not empty search.replyYn}">
                            <c:param name="replyYn" value="${search.replyYn}" />
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
                        <c:if test="${not empty search.productName}">
                            <c:param name="productName" value="${search.productName}" />
                        </c:if>
                        <c:if test="${not empty search.userNickName}">
                            <c:param name="userNickName" value="${search.userNickName}" />
                        </c:if>
                        <c:if test="${not empty search.useYn}">
                            <c:param name="useYn" value="${search.useYn}" />
                        </c:if>
                        <c:if test="${not empty search.replyYn}">
                            <c:param name="replyYn" value="${search.replyYn}" />
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

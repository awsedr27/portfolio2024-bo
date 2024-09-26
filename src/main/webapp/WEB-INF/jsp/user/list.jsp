<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<div class="container">
    <h1 class="mb-4 mt-4">유저 관리</h1>
    
    <form method="get" action="/user/list" class="form-inline mb-3">
        <div class="form-group me-2">
            <label for="userNickName" class="me-2">유저닉네임</label>
            <input type="text" id="userNickName" name="userNickName" class="form-control" value="<c:out value="${search.userNickName}"/>">
        </div>
        <div class="form-group me-2">
            <label for="email" class="me-2">이메일</label>
            <input type="text" id="email" name="email" class="form-control" value="<c:out value="${search.email}"/>">
        </div>
        <div class="form-group me-2">
            <label for="useYn" class="me-2">탈퇴여부</label>
            <select id="useYn" name="useYn" class="form-control">
                <option value="">All</option>
                <option value="Y" <c:if test="${search.useYn == 'Y'}">selected</c:if> >사용중계정</option>
                <option value="N" <c:if test="${search.useYn == 'N'}">selected</c:if> >탈퇴된계정</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary mt-4">검색</button>
    </form>
    <table class="table table-hover" style="table-layout: fixed;">
        <thead>
            <tr>
                <th>유저번호</th>
                <th>이메일</th>
                <th>닉네임</th>
                <th>탈퇴여부</th>
                <th>가입일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${userList}">
	            <c:url var="UserDetailUrl" value="/user/detail">
	            	<c:param name="userId" value="${user.userId}" />
	            </c:url>
                <tr style="cursor: pointer;" onclick="window.location.href='<c:out value="${UserDetailUrl}"/>'">
                    <td class="text-truncate"><c:out value="${user.userId}"/></td>
                    <td class="text-truncate"><c:out value="${user.userNickName}"/></td>
                    <td class="text-truncate"><c:out value="${user.email}"/></td>
                    <td class="text-truncate"><c:out value="${user.useYn}"/></td>
                    <td class="text-truncate"><c:out value="${user.createDate}"/></td>
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
                        <c:if test="${not empty search.userNickName}">
                            <c:param name="userNickName" value="${search.userNickName}" />
                        </c:if>
                        <c:if test="${not empty search.email}">
                            <c:param name="email" value="${search.email}" />
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
                         <c:if test="${not empty search.userNickName}">
                            <c:param name="userNickName" value="${search.userNickName}" />
                        </c:if>
                        <c:if test="${not empty search.email}">
                            <c:param name="email" value="${search.email}" />
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
                        <c:if test="${not empty search.userNickName}">
                            <c:param name="userNickName" value="${search.userNickName}" />
                        </c:if>
                        <c:if test="${not empty search.email}">
                            <c:param name="email" value="${search.email}" />
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

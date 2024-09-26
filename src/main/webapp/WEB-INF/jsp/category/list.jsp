<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<div class="container">
 <h1 class="mb-4 mt-4">카테고리목록</h1>
 
	<form method="get" action="/category/list" class="form-inline mb-3">
        <div class="form-group mr-2">
            <label for="categoryId" class="mr-2">Category ID</label>
            <input type="number" id="categoryId" name="categoryId" class="form-control" value="<c:out value="${search.categoryId}"/>">
        </div>
        <div class="form-group mr-2">
            <label for="name" class="mr-2">Name</label>
            <input type="text" id="name" name="name" class="form-control" value="<c:out value="${search.name}"/>">
        </div>
        <div class="form-group mr-2">
            <label for="useYn" class="mr-2">Use Y/N</label>
            <select id="useYn" name="useYn" class="form-control">
                <option value="">All</option>
                <option value="Y" <c:if test="${search.useYn == 'Y'}">selected</c:if> >Y</option>
                <option value="N" <c:if test="${search.useYn == 'N'}">selected</c:if> >N</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary mt-4">검색</button>
        <a href="/category/detail" class="btn btn-primary mt-4">
			카테고리 추가
		</a>
    </form>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Category ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Use Y/N</th>
                <th>Create Date</th>
                <th>Modify Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="category" items="${categoryList}">
	            <c:url var="CategoryDetailUrl" value="/category/detail">
	            	<c:param name="categoryId" value="${category.categoryId}" />
	            </c:url>
				<tr style="cursor: pointer;" onclick="window.location.href='<c:out value="${CategoryDetailUrl}"/>'">
                    <td><c:out value="${category.categoryId}"/></td>
                    <td><c:out value="${category.name}"/></td>
                    <td><c:out value="${category.description}"/></td>
                    <td><c:out value="${category.useYn}"/></td>
                    <td><c:out value="${category.createDate}"/></td>
                    <td><c:out value="${category.modifyDate}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
	<nav aria-label="Page navigation">
	    <ul class="pagination">
	        <c:if test="${paging.hasPreviousPage}">
	            <li class="page-item">
	                <c:url var="prevPageUrl" value="/category/list">
	                    <c:param name="page" value="${paging.firstPage - 1}" />
	                    <c:if test="${not empty search.categoryId}">
	                        <c:param name="categoryId" value="${search.categoryId}" />
	                    </c:if>
	                    <c:if test="${not empty search.name}">
	                        <c:param name="name" value="${search.name}" />
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
	                <c:url var="pageUrl" value="/category/list">
	                    <c:param name="page" value="${pageNum}" />
	                    <c:if test="${not empty search.categoryId}">
	                        <c:param name="categoryId" value="${search.categoryId}" />
	                    </c:if>
	                    <c:if test="${not empty search.name}">
	                        <c:param name="name" value="${search.name}" />
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
	                <c:url var="nextPageUrl" value="/category/list">
	                    <c:param name="page" value="${paging.lastPage + 1}" />
	                    <c:if test="${not empty search.categoryId}">
	                        <c:param name="categoryId" value="${search.categoryId}" />
	                    </c:if>
	                    <c:if test="${not empty search.name}">
	                        <c:param name="name" value="${search.name}" />
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

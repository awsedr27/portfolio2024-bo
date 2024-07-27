<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<div class="container">
    <!-- 주문 아이템 목록 -->
    <h2 class="mb-4">주문 상세 목록</h2>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Order Item ID</th>
                <th>Product ID</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Create Date</th>
                <th>Modify Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="orderItem" items="${orderItems}">
                <tr>
                    <td><c:out value='${orderItem.orderItemId}'/></td>
                    <td><c:out value='${orderItem.productId}'/></td>
                    <td><c:out value='${orderItem.quantity}'/></td>
                    <td><c:out value='${orderItem.price}'/></td>
                    <td><c:out value='${orderItem.createDate}'/></td>
                    <td><c:out value='${orderItem.modifyDate}'/></td>
                    <!--<td>
                        <a href="<c:url value='/orderItem/edit?orderItemId=${orderItem.orderItemId}'/>" class="btn btn-sm btn-primary">Edit</a>
                        <a href="<c:url value='/orderItem/delete?orderItemId=${orderItem.orderItemId}'/>" class="btn btn-sm btn-danger">Delete</a>
                    </td>-->
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="../include/footer.jsp" %>

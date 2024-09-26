<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
        

    <div class="container">
        <h1 class="mb-4">유저 상세</h1>
        <form action="/user/update" method="post">

            <div class="form-group">
                <label for="userId">유저 ID</label>
                <input type="text" class="form-control" id="userId" name="userId" value="<c:out value='${user.userId}'/>" readonly>
            </div>
            <div class="form-group">
                <label for="username">유저 이름</label>
                <input type="text" class="form-control" id="username" name="username" value="<c:out value='${user.username}'/>" disabled>
            </div>
            <div class="form-group">
                <label for="userNickName">유저 닉네임</label>
                <input type="text" class="form-control" id="userNickName" name="userNickName" value="<c:out value='${user.userNickName}'/>" disabled>
            </div>
            <div class="form-group">
                <label for="gender">성별</label>
                <input type="text" class="form-control" id="gender" name="gender" value="<c:out value='${user.gender}'/>" disabled>
            </div>
            <div class="form-group">
                <label for="birthday">생년월일</label>
                <input type="text" class="form-control" id="birthday" name="birthday" value="<c:out value='${user.birthyear}'/>-<c:out value='${user.birthday}'/>" disabled>
            </div>
            <div class="form-group">
                <label for="useYn">아이디 사용여부</label>
                <select class="form-control" id="useYn" name="useYn" required>
                    <option value="Y" <c:if test="${user.useYn == 'Y'}">selected</c:if>>사용중</option>
                    <option value="N" <c:if test="${user.useYn == 'N'}">selected</c:if>>탈퇴</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">수정</button>
        </form>
    </div>


<%@ include file="../include/footer.jsp" %>

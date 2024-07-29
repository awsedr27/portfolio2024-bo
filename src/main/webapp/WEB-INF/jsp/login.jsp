<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>portfolio-bo</title>
<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
<style>
body {
  min-height: 100vh;
}

body {
  display: flex;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
  
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}

.form-signin .checkbox {
  font-weight: 400;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>
</head>

<body class="text-center">
    
<main class="form-signin">
  <form action='/user/login' method="post">
    <h1 class="h3 mb-3 fw-normal">Login portfolio-bo</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Id" name='userId' required">
      <label for="floatingInput">Id</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name='password' required>
      <label for="floatingPassword">Password</label>
    </div>

    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger mt-3">
            <c:out value="${errorMessage}"/>
        </div>
    </c:if>
    <p class="mt-5 mb-3 text-muted">&lt;CopyRight 2024. <strong>portfolio-bo</strong>.&gt;</p>
  </form>
</main>
<script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap.bundle.min.js'/>"></script>

</body>
</html>

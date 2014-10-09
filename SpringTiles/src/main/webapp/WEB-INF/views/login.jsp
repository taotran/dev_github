<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty error}">
    <div class="alert-error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
    <div class="alert">${msg}</div>
</c:if>
<form name="loginForm" action="<c:url value='/login' />" class="form-signin" role="form" method="POST" onload="document.loginForm.username.focus();">
    <h2 class="form-signin-heading">Please sign in</h2>
    <input type="username" name="username" class="form-control" placeholder="Username" required autofocus>
    <input type="password" name="password" class="form-control" placeholder="Password" required>
    <label class="checkbox">
        <input type="checkbox" value="remember-me" name="remember-me"> Remember me
    </label>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <%--<input type="hidden" name="${_csrf.parameterName}"--%>
           <%--value="${_csrf.token}" />--%>
</form>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util" %>
<html>
<head>
    <title><spring:message code="spring.test.mvc.example.title"/></title>
    <util:load-scripts/>
</head>
</head>
<body>
<div class="page">
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
        <%--<div class="navbar-inner">--%>
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><spring:message code="label.navigation.brand"/> </a>
            </div>

            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="<c:if test="${currentPage == 'home'}"><c:out value="active"/></c:if>"><a href="/index"><spring:message code="label.navigation.homepage.link"/></a></li>
                    <li class="<c:if test="${currentPage == 'userlist'}"><c:out value="active"/></c:if>"><a href="/userList"><spring:message code="label.navigation.user_list"/></a></li>
                    <li class="<c:if test="${currentPage == 'alluserlist'}"><c:out value="active"/></c:if>"><a href="/allUserList"><spring:message code="label.navigation.all_user_list"/></a></li>
                    <li class="<c:if test="${currentPage == 'sessionlist'}"><c:out value="active"/></c:if>"><a href="/sessionList"><spring:message code="label.navigation.session_list"/></a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <c:url value="/logout" var="logoutUrl"/>
                    <li><a href="${logoutUrl}"><spring:message code="label.navigation.logout.link"/></a></li>
                    <li><a href="/expire">Expire Now</a></li>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </ul>
            </div>
        </div>
        <%--</div>--%>
    </div>
    <div class="content">
        <div id="message-holder">
            <c:if test="${feedbackMessage != null}">
                <div class="messageblock hidden">${feedbackMessage}</div>
            </c:if>
            <c:if test="${errorMessage != null}">
                <div class="errorblock hidden">${errorMessage}</div>
            </c:if>
        </div>
        <div id="view-holder">
            <tiles:insertAttribute name="body"/>
        </div>
    </div>
</div>

<script id="template-alert-message-error" type="text/x-handlebars-template">
    <div id="alert-message-error" class="alert alert-error fade in">
        <a class="close" data-dismiss="alert">&times;</a>
        {{message}}
    </div>
</script>

<script id="template-alert-message" type="text/x-handlebars-template">
    <div id="alert-message" class="alert alert-success fade in">
        <a class="close" data-dismiss="alert">&times;</a>
        {{message}}
    </div>
</script>
</body>
</html>
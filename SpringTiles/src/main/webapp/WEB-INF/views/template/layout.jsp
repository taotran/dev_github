<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title><spring:message code="spring.test.mvc.example.title"/></title>
    <link rel="stylesheet" type="text/css" href="../../../static/css/example.css"/>
    <link rel="stylesheet" type="text/css" href="../../../static/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../../../static/css/bootstrap-responsive.css"/>
    <script type="text/javascript" src="../../../static/js/vendor/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="../../../static/js/vendor/bootstrap.js"></script>
    <script type="text/javascript" src="../../../static/js/vendor/bootstrap-transition.js"></script>
    <script type="text/javascript" src="../../../static/js/vendor/bootstrap-collapse.js"></script>
    <script type="text/javascript" src="../../../static/js/vendor/handlebars-1.0.rc.1.js"></script>
    <script type="text/javascript" src="../../../static/js/user.js"></script>
</head>
<body>
<div class="page">
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>

                <span class="brand"><spring:message code="label.navigation.brand"/></span>

                <div class="nav-collapse">
                    <ul class="nav">
                        <li><a href="/"><spring:message code="label.navigation.homepage.link"/></a></li>
                        <c:url value="/logout" var="logoutUrl"/>
                        <li><a href="${logoutUrl}"><spring:message code="label.navigation.logout.link"/></a></li>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <li><a href="/userList"><spring:message code="label.navigation.user_list"/></a></li>
                    </ul>
                </div>
            </div>
        </div>
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
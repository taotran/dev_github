<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapmin"/>
<spring:url value="/resources/css/navbar-fixed-top.css" var="navfixedtop"/>
<spring:url value="/resources/static/css/bootstrap-responsive.css" var="bootstrapresp"/>

<spring:url value="/resources/js/vendor/jquery-1.8.2.js" var="jquery"/>
<spring:url value="/resources/js/vendor/bootstrap-transition.js" var="bootstraptrans"/>
<spring:url value="/resources/js/vendor/bootstrap-collapse.js" var="bootstrapcoll"/>
<spring:url value="/resources/js/vendor/handlebars-1.0.rc.1.js" var="handlebars"/>
<spring:url value="/resources/js/user.js" var="userjs"/>

<link rel="stylesheet" type="text/css" media="screen" href="${bootstrapmin}"></link>
<link rel="stylesheet" type="text/css" media="screen" href="${navfixedtop}"></link>
<link rel="stylesheet" type="text/css" media="screen" href="${bootstrapresp}"></link>

<script type="text/javascript" src="${jquery}"></script>
<script type="text/javascript" src="${bootstraptrans}"></script>
<script type="text/javascript" src="${bootstrapcoll}"></script>
<script type="text/javascript" src="${handlebars}"></script>
<script type="text/javascript" src="${userjs}"></script>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <script type="text/javascript" src="/static/js/user.view.js"></script>
</head>
<body>
<div id="user-list" class="table-responsive">
    <c:choose>
        <c:when test="${empty usersessions}">
            <p>Empty</p>
        </c:when>
        <c:otherwise>

            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Username</th>
                    <th>Login Time</th>
                    <th>Session Id</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${usersessions}" var="us">
                    <tr>
                        <td>
                            <div id="user-id"><c:out value="${us.id}"/></div>
                        </td>
                        <td><c:out value="${us.user.username}"/></td>
                        <td><c:out value="${us.loginTimestamp}"/></td>
                        <td><c:out value="${us.sessionId}"/></td>
                        <td>
                            <div class="user-action-buttons">
                                <a href="/admin/update/id=${us.id}" class="btn btn-xs btn-primary">Update</a>
                                <a href="#" id="delete-user-link" class="btn btn-xs btn-danger">Expired Now!</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
<script id="template-expire-user-confirmation-dialog" type="text/x-handlebars-template">
    <div id="delete-user-confirmation-dialog" class="modal">
        <div class="modal-header">
            <button class="close" data-dismiss="modal">x</button>
            <h3>Delete this user?</h3>
        </div>
        <div class="modal-body">
            <p>Delete confirm message</p>
        </div>
        <div class="modal-footer">
            <a id="cancel-user-button" href="#" class="btn">Cancel</a>
            <a id="delete-user-button" href="#" class="btn btn-primary">OK</a>
        </div>

    </div>
</script>
</body>
</html>


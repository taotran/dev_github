<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <script type="text/javascript" src="/static/js/user.view.js"></script>
    <script type="text/javascript">
        $(function () {
            var userTable = $("#user-list");

            var renderTable = function (container) {
                $.get("/userList", function (data) {
                    container.empty().html(data);
                });
            };

//            renderTable(userTable);

            $("#refreshButton").click(function () {
                renderTable(userTable);
            });
        });

    </script>
</head>
<body>
<div id="user-list" class="table-responsive">
    <c:choose>
        <c:when test="${empty users}">
            <p>Empty</p>
        </c:when>
        <c:otherwise>

            <table class="table" id="userTable">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Enabled</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>
                            <div id="user-id"><c:out value="${user.id}"/></div>
                        </td>
                        <td><c:out value="${user.username}"/></td>
                        <td><c:out value="${user.role}"/></td>
                        <td><c:out value="${user.enabled}"/></td>
                        <td>
                            <div class="user-action-buttons">
                                <a href="/admin/update/id=${user.id}" class="btn btn-xs btn-primary">Update</a>
                                <a href="#" id="delete-user-link" class="btn btn-xs btn-danger">Delete</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="5">
                        <c:forEach begin="1" end="${pages}" varStatus="loop" var="i">
                            <c:out value="${i}"/> |
                        </c:forEach>
                            <%--1 | 2 | 3 | 4 | 5--%>
                    </td>
                </tr>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
    <%--<div id="pages"><c:forEach items="${pages}" var="page">--%>
    <%--<c:out value="${page}"/> |--%>
    <%--</c:forEach></div>--%>
    <input type="button" id="refreshButton" value="Refresh"/>
</div>
<script id="template-delete-user-confirmation-dialog" type="text/x-handlebars-template">
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


$(function () {

    $(".table").on("click", "#delete-user-link", function (e) {
        e.preventDefault();

        var userDeleteDialogTempate = Handlebars.compile($("#template-delete-user-confirmation-dialog").html());

        $("#view-holder").append(userDeleteDialogTempate());
        $("#delete-user-confirmation-dialog").modal();
    })

    $("#view-holder").on("click", "#cancel-user-button", function (e) {
        e.preventDefault();

        var deleteConfirmationDialog = $("#delete-user-confirmation-dialog")
        deleteConfirmationDialog.modal('hide');
        deleteConfirmationDialog.remove();
    });

    $("#view-holder").on("click", "#delete-user-button", function (e) {
        e.preventDefault();
        window.location.href = "/admin/delete/id=" + $("#user-id").text();
    });
});

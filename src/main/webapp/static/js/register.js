var email = $("#InputEmail1");
var username = $("#InputUsername");
var password = $("#Password1");
var regpassword = $("#Password2");
$(function () {

    $(".alert").hide();
    $("#submitbtn").click(function () {

        $("input").each(function () {
            if ($(this).val() == "") {
                $(this).addClass("is-invalid");
            }
        });

        if (email.hasClass("is-valid") && username.hasClass("is-valid") && password.hasClass("is-valid") && regpassword.hasClass("is-valid") && email.val() != "" && username.val() != "" && password.val() != "" && regpassword.val() != "") {
            return true;
        } else {
            return false;
        }
    });
});

function isSave() {
    var usernamereg = /^[a-zA-Z0-9]{5,20}$/;
    if (username.val()) {
        if (usernamereg.test(username.val())) {

            $.get("AjaxServlet", {username: $("#InputUsername").val()}, function (isSave) {
                if (isSave) {
                    $("#usernameHelp").addClass("alert-danger inpdanger").removeClass("alert-success").html("用户名已存在");
                    $("#InputUsername").removeClass("is-valid is-invalid");
                } else {
                    $("#usernameHelp").addClass("alert-success").removeClass("alert-danger").html("用户名可用");
                    $("#InputUsername").addClass("is-valid").removeClass("is-invalid");

                }
            });
        } else {
            username.addClass("is-invalid").removeClass("is-valid");
            $("#usernameHelp").removeClass("inpdanger")
        }
    }

    $(".alert").not('.inpdanger').hide();
    $("#usernameHelp").addClass("alert-secondary").removeClass("alert-success alert-danger").html("你可以使用字母、数字,和下划线");


}

function alertShow(e) {
    console.log(e)
    $(".alert").not('.inpdanger').hide();
    $(e).parent().find("small").show();
    var emailreg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    var passwordreg = /^[a-zA-Z0-9]{8,20}$/;

    if (email.val()) {
        if (emailreg.test(email.val())) {
            email.removeClass("is-invalid").addClass("is-valid");
        } else {
            email.addClass("is-invalid").removeClass("is-valid");
        }
    }

    if (password.val()) {
        if (passwordreg.test(password.val())) {
            password.removeClass("is-invalid").addClass("is-valid");
        } else {
            password.addClass("is-invalid").removeClass("is-valid");
        }
    }
    if (regpassword.val()) {
        if (password.val() == regpassword.val()) {
            regpassword.removeClass("is-invalid").addClass("is-valid");
        } else {
            regpassword.addClass("is-invalid").removeClass("is-valid");
        }
    }
}
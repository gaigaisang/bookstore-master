$(function () {
    $(".alert").hide();
//        $("#submitbtn").click(function () {
//            if (Password2.value != Password1.value) {
//                $("#registerform").removeAttribute("action");
//                $("#Password2").popover('show');
//            } else {
//                $("#registerform").setAttribute("action", "userregister");
//                $("#Password2").popover('hide');
//            }
//        })
//
//
//        Password2.onblur = function () {
//            console.log(Password1.value)
//            console.log(Password2.value)
//            if (Password2.value != Password1.value) {
//                $("#Password2").popover('show')
//            } else (
//                $("#Password2").popover('hide')
//            )
//        }
//
});
function isSave() {
    $.get("AjaxServlet", {username: $("#InputUsername").val()}, function (isSave) {
        if (isSave) {
            $("#InputUsername").addClass("border-danger").removeClass("border-success");
            $("#usernameHelp").addClass("alert-danger ").removeClass("alert-success").html("用户名已存在");
        } else {
            $("#usernameHelp").addClass("alert-success").removeClass("alert-danger").html("用户名可用");
            $("#InputUsername").addClass("border-success").removeClass("border-danger");
        }
    })
}
function alertShow(e) {
    console.log(e)
    $(".alert").hide();
    $(e).parent().find("small").show();
}
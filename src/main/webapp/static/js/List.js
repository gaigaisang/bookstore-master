$(function () {
    var varusername=null;
    getUser();

    $('#checkAll').click(function () {
        checkAll();
    });

    $('#tableMain').on('click', 'input[name="userCheckbox"]', function () {
        if ($('input[name="userCheckbox"]:checked').length == $('input[name="userCheckbox"]').length) {
            $('#checkAll').prop('checked', true);
        } else {
            $('#checkAll').prop('checked', false);
        }
    });

});

function checkAll() {
    if ($('#checkAll').is(':checked')) {

        $('input[name="userCheckbox"]').each(function () {
            $(this).prop('checked', true);
        });
    } else {

        $('input[name="userCheckbox"]').each(function () {
            $(this).prop('checked', false);
        });
    }
}

function getUser(num, username) {
    $("#tableMain").empty();
    $("#totalPage").empty();
    $.get("ListAjaxServlet", {pageIndex: num, username: username}, function (page) {
        for (user in page.users) {
            $("#tableMain").append('<tr> <th scope="col"><input name="userCheckbox" type="checkbox" class="isCheckbox"></th><td>' + page.users[user].id + '</td><td>' + page.users[user].email + '</td><td>' + page.users[user].username + '</td><td>' + page.users[user].password + '</td><td><button id="editUserBtn" class="btn btn btn-outline-primary btn-sm" onclick="editUser(this,' + page.page + ')" data-toggle="modal" data-target="#editUserModal">编辑</button><button class="btn btn btn-outline-danger btn-sm" onclick="deleteUser(this,' + page.page + ')">删除</button></td></tr>')
        }
        $("#totalPage").append('<li class="page-item ' + (page.page === 1 ? 'disabled' : '') + '"><button class="page-link" onclick="getUser(' + (page.page - 1) + ')"  aria-label="Previous"><span aria-hidden="true">&laquo;</span></button></li>')
        for (var i = 0; i < page.totalPage; i++) {
            $("#totalPage").append('<li class="page-item ' + ((i + 1) === page.page ? 'active' : '') + '"><button class="page-link" onclick="getUser(varusername,' + (i + 1) + ')">' + (i + 1) + '</button></li>')
        }
        $("#totalPage").append('<li class="page-item ' + (page.page === page.totalPage ? 'disabled' : '') + '"><button class="page-link" onclick="getUser(' + (page.page + 1) + ')"  aria-label="Next"><span aria-hidden="true">&raquo;</span></button></li>')
    });
}

function deleteUser(user, page) {
    const arr = $(user).parent().parent().children()
    const num = $(user).parent().parent().parent().children().length

    $.post("ListDeleteUserServlet", {userId: arr[1].innerText}, function (b) {
        if (num !== 1) {
            getUser(page)
        } else {
            getUser(page - 1)
        }
    });
}

function editUser(user, page) {
    const arr = $(user).parent().parent().children()
    $("#editId").val(arr[1].innerText)
    $("#editEmail").val(arr[2].innerText)
    $("#editUsername").val(arr[3].innerText)
    $("#editPassword").val(arr[4].innerText)
    $("#editBtn").click(function () {
        $.post("ListEditUserServlet", {
            id: $("#editId").val(),
            email: $("#editEmail").val(),
            username: $("#editUsername").val(),
            password: $("#editPassword").val()
        }, function (b) {
            getUser(page)
        });
    });
}

function addUser() {
    $("#addUserBtn").click(function () {
        $.post("ListAddUserServlet", {
            email: $("#addEmail").val(),
            username: $("#addUsername").val(),
            password: $("#addPassword").val()
        }, function (b) {
            getUser()
        });
    });


}

function selectUser() {
    varusername=$("#searchUserInp").val()
        getUser(-1,varusername)
}
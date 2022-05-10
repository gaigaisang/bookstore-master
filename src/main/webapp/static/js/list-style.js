$(function () {
    $('.editbtn').click(function () {
        let number = $(this).attr('number');
        $('#editUser').attr('value', number);
        const arr = $(this).parent().parent().children()
        $('#editUsername').val(arr[3].innerText);
        $('#editPassword').val(arr[4].innerText);
        $('#editEmail').val(arr[2].innerText);
    });
    $('#checkAll').click(function () {
        if ($(this).is(':checked')) {
            $('#deleteUser').removeClass('invisible');
            $('input[name="checkbox1"]').each(function () {
                $(this).prop('checked', true);
            });
        } else {
            $('#deleteUser').addClass('invisible');
            $('input[name="checkbox1"]').each(function () {
                $(this).prop('checked', false);
            });
        }
    });
    $('#searchUserBtn').click(function () {
        let username = $('#searchUserInp').val();
        $(this).attr('href', 'ListServlet?username='+username);

    });



});
function check_user_name() {
    var name = $('#user_name').val();
    if (name.length == 0 || trim(name).length == 0) {
        $('#user_name').next().html('请输入用户名')
        $('#user_name').next().show();
        error_name = true;
    } else {
        $('#user_name').next().hide();
        error_name = false;
    }
}

function check_pwd() {
    var pwd = $('#pwd').val();
    if (pwd.length == 0 || trim(pwd).length == 0) {
        $('#pwd').next().html('请输入密码')
        $('#pwd').next().show();
        error_password = true;
    } else {
        $('#pwd').next().hide();
        error_password = false;
    }
}
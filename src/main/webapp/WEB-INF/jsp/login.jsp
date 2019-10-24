<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="UTF-8">
    <title>天天生鲜-登录</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/reset.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/slide.js"></script>
    <script src="${pageContext.request.contextPath}/js/login.js"></script>
</head>
<body>
<div class="login_top clearfix">
    <a href="<%=path%>/index" class="login_logo"><img src="images/logo02.png"></a>
</div>

<div class="login_form_bg">
    <div class="login_form_wrap clearfix">
        <div class="login_banner fl"></div>
        <div class="slogan fl">日夜兼程 · 急速送达</div>
        <div class="login_form fr">
            <div class="login_title clearfix">
                <h1>用户登录</h1>
                <a href="<%=path%>/register">立即注册</a>
            </div>
            <div class="form_input" >
                <form id="login_form" autocomplete="off">
                    <input type="text" name="user_name" id="user_name" class="name_input" placeholder="请输入用户名或邮箱">
                    <div class="user_error">输入错误</div>
                    <input type="password" name="pwd" id="pwd" class="pass_input" placeholder="请输入密码">
                    <div class="pwd_error">输入错误</div>
                    <div style="position: absolute;left: 0;top: 120px;">
                        <img onclick="refreshCode(this);"
                             src="${pageContext.request.contextPath}/captcha2"
                             style="width: 100px;vertical-align: middle" id="cap">
                        <input style="background: #fdfdfd;height: 25px;width: 100px;vertical-align: middle;" id="captcha_input">
                        <span id="captcha_span" style="display:none;" >提示信息</span>
                    </div>
                    <div class="more_input clearfix">
                        <input type="checkbox" id="remember" name="remember">
                        <label>记住用户名</label>
                        <a href="#">忘记密码</a>
                    </div>
                    <input type="submit" value="登录" class="input_submit">
                </form>
            </div>
        </div>
    </div>
</div>

<div class="footer no-mp" id="footer">
</div>
<script>
    function refreshCode(a) {
        a.src="${pageContext.request.contextPath}/captcha2?" + new Date().getTime();
    }
    $(function () {
        $.get("${pageContext.request.contextPath}/footer", function (data) {
            $("#footer").html(data);
        });
        var captcha = false;
        var error_name = false;
        var error_password = false;
        $('#user_name').change(function() {
            check_user_name();
        });
        $('#pwd').change(function() {
            check_pwd();
        });
        $("#captcha_input").change(function () {
            var captchaInput = $("#captcha_input").val();
            $.ajax({
                url:"${pageContext.request.contextPath}/checkcaptcha",
                type:"post",
                data:JSON.stringify({captchaInput:captchaInput}),
                contentType:"application/json;charset=utf-8",
                dataType:"json",
                success:function (data) {
                    if (data.result == 1){
                        $("#captcha_span").text("验证码正确");
                        $("#captcha_span").css({"color":"green"});
                        $("#captcha_span").show();
                        captcha = true;
                    }else{
                        $("#captcha_span").text("验证码错误");
                        $("#captcha_span").css({"color":"red"});
                        $("#captcha_span").show();
                    }
                }
            });
        });
        $("#login_form").submit(function () {
            var username = $("#user_name").val();
            var password = $("#pwd").val();
            var remember = 0;
            if ($("#remember").is(":checked")){
                var remember = 1;
            }
            if (captcha == true && error_name == false && error_password == false){
                $.ajax({
                    url:"${pageContext.request.contextPath}/user/loginHandle",
                    type:"post",
                    data:JSON.stringify({username:username,password:password,remember:remember}),
                    contentType:"application/json;charset=utf-8",
                    dataType:"json",
                    success:function (data) {
                        if (data.result == 1){
                            alert("登陆成功！")
                            location.href="${pageContext.request.contextPath}/index"
                        }else{
                            $('#user_name').next().html('用户名或密码错误！请重新登陆！')
                            $('#user_name').next().show();
                        }
                    }
                });
            }
            return false;
        })
    })
</script>
</body>
</html>

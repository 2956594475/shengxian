<% String path = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>天天生鲜-首页</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/reset.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/slide.js"></script>
    <script src="${pageContext.request.contextPath}/js/register.js"></script>
    <script>
        $(function () {
            $.get("${pageContext.request.contextPath}/footer", function (data) {
                $("#footer").html(data);
            })
            var error_name = false;
            var error_password = false;
            var error_check_password = false;
            var error_email = false;
            var error_check = false;
            $('#user_name').blur(function() {
                check_user_name();
            });
            $('#pwd').blur(function() {
                check_pwd();
            });
            $('#cpwd').blur(function() {
                check_cpwd();
            });
            $('#email').blur(function() {
                check_email();
            });
            $('#allow').click(function() {
                if($(this).is(':checked'))
                {
                    error_check = false;
                    $(this).siblings('span').hide();
                }
                else
                {
                    error_check = true;
                    $(this).siblings('span').html('请勾选同意');
                    $(this).siblings('span').show();
                }
            });
            $('#registerForm').submit(function () {
                //如果校验通过发送ajax请求
                if (!(error_name && error_password && error_check_password && error_email && error_check)){
                    var username = $("#user_name").val();
                    var password = $("#pwd").val();
                    var email = $("#email").val();
                    $.ajax({
                        url:"${pageContext.request.contextPath}/user/registerHandle",
                        type:"POST",
                        data:JSON.stringify({username:username,password:password,email:email}),
                        contentType:"application/json;charset=utf-8",
                        dataType:"json",
                        success:function (data) {
                            if (data.result == 1){
                                location.href="${pageContext.request.contextPath}/registSuccess";
                            }else{
                                $('#user_name').next().html('该用户或邮箱已经注册！请重新注册！')
                                $('#user_name').next().show();
                                error_name = true;
                            }
                        }
                    });
                }
                return false;
            });

        })
    </script>
<body>
<div class="register_con">
    <div class="l_con fl">
        <a class="reg_logo"><img src="images/logo02.png"></a>
        <div class="reg_slogan">足不出户  ·  新鲜每一天</div>
        <div class="reg_banner"></div>
    </div>

    <div class="r_con fr">
        <div class="reg_title clearfix">
            <h1>用户注册</h1>
            <a href="<%=path%>/login">登录</a>
        </div>
        <div class="reg_form clearfix">
            <form id="registerForm">
                <ul>
                    <li>
                        <label>用户名:</label>
                        <input type="text" name="user_name" id="user_name">
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>密码:</label>
                        <input type="password" name="pwd" id="pwd">
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>确认密码:</label>
                        <input type="password" name="cpwd" id="cpwd">
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>邮箱:</label>
                        <input type="text" name="email" id="email">
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li class="agreement">
                        <input type="checkbox" name="allow" id="allow" checked="checked">
                        <label>同意”天天生鲜用户使用协议“</label>
                        <span class="error_tip2">提示信息</span>
                    </li>
                    <li class="reg_sub">
                        <input type="submit" value="注 册">
                    </li>
                </ul>
            </form>
        </div>

    </div>

</div>

<div class="footer no-mp" id="footer">
</div>
</body>
</html>

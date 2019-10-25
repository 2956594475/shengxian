<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="welcome fl login_btn">
    欢迎<shiro:user><shiro:principal/></shiro:user>
    来到天天生鲜!
    <shiro:user>
        <a href="${pageContext.request.contextPath}/user/logout">登出</a>
    </shiro:user>
</div>
<div class="fr">
    <div class="login_info fl">
        欢迎您
    </div>
    <div class="login_btn fl">
        <a href="${pageContext.request.contextPath}/login"><shiro:guest>登录</shiro:guest></a>
        <span>|</span>
        <a href="${pageContext.request.contextPath}/register">注册</a>
    </div>
    <div class="user_link fl">
        <span>|</span>
        <a href="${pageContext.request.contextPath}/user/info">用户中心</a>
        <span>|</span>
        <a href="${pageContext.request.contextPath}/user/cart">我的购物车</a>
        <span>|</span>
        <a href="user_center_order.html">我的订单</a>
    </div>
</div>

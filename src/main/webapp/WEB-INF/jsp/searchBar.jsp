<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href="index.html" class="logo fl"><img src="${pageContext.request.contextPath}/images/logo.png"></a>
<div class="search_con fl">
    <input type="text" class="input_text fl" name="" placeholder="搜索商品">
    <input type="button" class="input_btn fr" name="" value="搜索">
</div>
<div class="guest_cart fr">
    <a href="${pageContext.request.contextPath}/user/cart" class="cart_name fl" id="cart">我的购物车</a>
    <div class="goods_count fl" id="show_count">${cart_count}</div>
</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="UTF-8">
    <title>天天生鲜-商品详情</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/reset.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/slide.js"></script>
    <script type="text/javascript" src="<%=path%>/js/bigdecimal.js"></script>
    <script type="text/javascript">
        $(function () {

            $.get("${pageContext.request.contextPath}/header", function (data) {
                $("#header").html(data);
            });
            $.get("${pageContext.request.contextPath}/footer", function (data) {
                $("#footer").html(data);
            });
            $.get("${pageContext.request.contextPath}/searchBar", function (data) {
                $("#search").html(data);
            });
            cal_goods_amount();
            $(document).click(function () {
                $('.popup_con').fadeOut();
            });
        });
    </script>
</head>
<body>
<div class="header_con">
    <div class="header" id="header"></div>
</div>

<div class="search_bar clearfix" id="search">
</div>

<div class="navbar_con">
    <div class="navbar clearfix">
        <div class="subnav_con fl">
            <h1>全部商品分类</h1>
            <span></span>
            <ul class="subnav">
                <c:forEach items="${types}" var="type">
                    <li><a href="${pageContext.request.contextPath}/goods/list/${type.id}"
                           class="${type.logo}">${type.name}</a></li>
                </c:forEach>
            </ul>
        </div>
        <ul class="navlist fl">
            <li><a href="${pageContext.request.contextPath}/">首页</a></li>
            <li class="interval">|</li>
            <li><a href="">手机生鲜</a></li>
            <li class="interval">|</li>
            <li><a href="">抽奖</a></li>
        </ul>
    </div>
</div>

<div class="breadcrumb">
    <a href="#">全部分类</a>
    <span>></span>
    <a href="#">新鲜水果</a>
    <span>></span>
    <a href="#">商品详情</a>
</div>

<div class="goods_detail_con clearfix">
    <div class="goods_detail_pic fl"><img src="${pageContext.request.contextPath}/${goods_sku.image}" width="320" height="320"></div>
    <div class="goods_detail_list fr">
        <h3>${goods_sku.name}</h3>
        <p>${goods_sku.desc}</p>
        <div class="prize_bar">
            <span class="show_pirze">¥<em>${goods_sku.price}</em></span>
            <span class="show_unit">单  位：${goods_sku.unite}</span>
            <span class="show_unit">销  量：${goods_sku.sales}</span>
        </div>
        <div class="goods_num clearfix">
            <div class="num_name fl">数 量：</div>
            <div class="num_add fl">
                <input type="text" class="num_show fl" value="1">
                <a href="javascript:void(0);" class="add fr" onclick="addOne()">+</a>
                <a href="javascript:void(0);" class="minus fr" onclick="subOne()">-</a>
            </div>
            <div class="num_name fl" style="margin-left: 120px">库 存：${goods_sku.stock}</div>
        </div>
        <div class="total">总价：<em>16.80元</em></div>
        <div class="operate_btn">
            <a href="javascript:void(0);" class="buy_btn">立即购买</a>
            <a href="javascript:void(0);" class="add_cart" id="add_cart">加入购物车</a>
        </div>
    </div>
</div>

<div class="main_wrap clearfix">
    <div class="l_wrap fl clearfix">
        <div class="new_goods">
            <h3>新品推荐</h3>
            <ul>
                <c:forEach items="${new_sku}" var="news">
                    <li>
                        <a href="${pageContext.request.contextPath}/goods/${news.id}"><img src="${pageContext.request.contextPath}/${news.image}"></a>
                        <h4><a href="${pageContext.request.contextPath}/goods/${news.id}">${news.name}</a></h4>
                        <div class="prize">￥${news.price}</div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>

    <div class="r_wrap fr clearfix">
        <ul class="detail_tab clearfix">
            <li class="active">商品介绍</li>
            <li>评论</li>
        </ul>

        <div class="tab_content">
            <dl>
                <dt>商品详情：</dt>
                <dd>${goods_spu.detail}</dd>
            </dl>
        </div>

    </div>
</div>

<div class="footer" id="footer">
</div>
<div class="add_jump"></div>
<div class="popup_con">
    <div class="popup">
        <p id="pop_msg"></p>
    </div>
    <div class="mask"></div>
</div>

<div class="add_jump" id="add_jump"></div>
<script>
    // 计算商品总价格
    function cal_goods_amount() {
        // 获取商品单价和数量
        var price = $(".show_pirze").children('em').text();
        var count = $(".num_show").val();
        var price2 = new BigDecimal(price);
        var count2 = new BigDecimal(count);
        var amount = price2.multiply(count2);
        var amount2 = parseFloat(amount.toString());
        // 设置商品总价
        $(".total").children("em").text(amount2.toFixed(2) + "元");
    }

    // 增加商品数量
    function addOne(){
        // 获取原有数目
        var count = $(".num_show").val();
        count = parseInt(count) + 1;
        $(".num_show").val(count);
        cal_goods_amount();
    }
    function subOne(){
        // 获取原有数目
        var count = $(".num_show").val();
        count = parseInt(count) - 1;
        if (count <= 0) {
            count = 1;
        }
        $(".num_show").val(count);
        cal_goods_amount();
    }
    // 手动输入商品数量
    function inputSome(){
        // 获取
        var count = $(this).val();
        // 校验
        if (isNaN(count) || count.trim().length == 0 || parseInt(count) <= 0) {
            count = 1;
        }
        $(this).val(parseInt(count));
        cal_goods_amount();
    }
</script>
</body>
</html>

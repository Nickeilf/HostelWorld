<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 2017/3/13
  Time: 下午4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人主页</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
    <link href="css/costume/personal.css" rel="stylesheet"/>
    <link href="css/airbnb/common_o2.1-7a9ba7f9634ca8f5f400a2d90082c402.css" rel="stylesheet"/>
</head>
<body>
<%--顶部导航栏--%>
<div class="navbar-fixed">
    <nav class="white" role="navigation">
        <div class="nav-wrapper container">
            <a id="logo-container" class="brand-logo">
                <embed src="/HostelWorld/pic/hotel.svg" width="64" height="64"
                       type="image/svg+xml"
                       pluginspage="http://www.adobe.com/svg/viewer/install/"></embed>

                <%--<object id="front-page-logo" type="image/svg+xml" data="/HostelWorld/pic/hotel.svg">Your browser does not support SVG</object>--%>
            </a>
            <div class="row">
                <div class="col l5 offset-l1" style="height:100%">
                    <ul id="nav" class="hide-on-med-and-down">
                        <li class="grey-text" style="font-size: 30px">
                            Hostel World
                        </li>
                    </ul>
                </div>

                <c:if test="${empty sessionScope.user}">
                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="index" class="grey-text">首页</a></li>
                        <li><a href="hostel" class="grey-text">客栈</a></li>
                        <c:if test="${sessionScope.user.type=='hostel'}">
                            <li><a href="apply" class="grey-text">客栈管理</a></li>
                        </c:if>
                        <c:if test="${sessionScope.user.type!='hostel'}">
                            <li><a href="apply" class="grey-text">成为店家</a></li>
                        </c:if>
                        <li><a href="register"class="grey-text">注册</a></li>
                        <li><a href="login"class="grey-text">登录</a></li>
                    </ul>
                </c:if>
                <c:if test="${not empty sessionScope.user}">
                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="index" class="grey-text">首页</a></li>
                        <li><a href="hostel" class="grey-text">客栈</a></li>
                        <c:if test="${sessionScope.user.type=='hostel'}">
                            <li><a href="hostel/modify" class="grey-text">客栈管理</a></li>
                        </c:if>
                        <c:if test="${sessionScope.user.type!='hostel'}">
                            <li><a href="apply" class="grey-text">成为店家</a></li>
                        </c:if>
                        <li>
                            <a href="#"class="grey-text dropdown-button" data-activates="dropdown1">${sessionScope.user.login}</a>
                            <ul id='dropdown1' class='dropdown-content' style="padding-left: 0px">
                                <li><a href="personal">个人主页</a></li>
                                <li><a href="logout">登出</a></li>
                            </ul>
                        </li>
                    </ul>
                </c:if>
            </div>
        </div>
    </nav>
</div>


<div class="container">
    <div class="row">
        <div class="col m8 offset-m2">
            <div id="card-info" class="section scroll-spy underline">
                <p style="color: #ff5a5f;">${message}</p>
                <h3 class="header">
                    会员卡信息
                </h3>
                <div class="row">
                    <div class="col m8">
                        <embed src="/HostelWorld/pic/credit-card.svg" width="320" height="320"
                               type="image/svg+xml"
                               pluginspage="http://www.adobe.com/svg/viewer/install/"></embed>
                    </div>
                    <div class="col m4">
                        <div class="row">
                            <div class="col m12">
                                <br>
                                <p>卡号:${member.member_id}</p>

                                    <c:if test="${member.state =='invalid'}">
                                        <p style="color: #ff5a5f;">状态:未激活</p>
                                    </c:if>
                                    <c:if test="${member.state =='cancel'}">
                                        <p>状态:已作废</p>
                                    </c:if>
                                    <c:if test="${member.state =='use'}">
                                        <p style="color: #26a69a;">状态:已激活</p>
                                    </c:if>
                                    <c:if test="${member.state =='suspend'}">
                                        <p>状态:暂停使用</p>
                                    </c:if>
                                <p>上次消费时间:${member.last_pay}</p>
                                <p>会员卡余额:${member.balance}</p>
                                <p>会员卡等级:${member.level}</p>
                            </div>
                            <div class="col m12">
                                <button class="btn btn-lg btn-primary btn-block login-button" type="submit" style="border-color: #26a69a;background: #26a69a;margin-top: 10px" onclick="window.location.href='pay'">充值</button>
                                <button class="btn btn-lg btn-primary btn-block login-button" type="submit" style="margin-top: 10px" onclick="window.location.href='cancel'">取消资格</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            
            <c:if test="${member.state != 'invalid'}">
            <div id="personal-info" class="section scroll-spy underline">
                <h3 class="header">
                    会员信息
                </h3>
                <div class="row">
                    <form id="info-form" method="post" action="changeinfo">
                        <div class="input-field col s6">
                            <input value="${member.name}" name="nickname" id="nickname" type="text">
                            <label for="nickname">昵称</label>
                        </div>
                        <div class="input-field col s6">
                            <input value="${member.phone}" name="phone" id="phone" type="number">
                            <label for="phone">电话</label>
                        </div>
                        <div class="input-field col s6">
                            <input value="${member.email}" name="email" id="email" type="email">
                            <label for="email">邮箱</label>
                        </div>

                        <div class="col m6">
                            <button class="btn btn-lg btn-primary btn-block login-button" type="submit" style="border-color: #26a69a;background: #26a69a;margin-top: 10px">修改</button>
                        </div>
                    </form>
                </div>
                <br>
                <div class="row">
                <div class="col s6">
                    当前积分:${member.point}
                </div>

                <div class="col s6">
                    卡余额:${member.balance}元
                </div>

                    <form name="trans-form" action="trans" method="post">
                    <div class="col m12">
                        <p class="range-field">
                            <label for="point2balance">积分转余额(20积分=1元)</label>
                            <input type="range" name="point2balance" id="point2balance" min="0" max="${member.point}" />
                        </p>
                    </div>
                    <div class="col m6 offset-m6">
                        <button class="btn btn-lg btn-primary btn-block login-button" type="submit" style="border-color: #26a69a;background: #26a69a;margin-top: 10px">确定</button>
                    </div>
                    </form>
                </div>


            </div>
            <div id="register" class="section scroll-spy underline">
                <h3 class="header">
                    当前预定
                </h3>

                <%--tab--%>
                <div class="col s12">
                    <ul class="tabs" style="width: 100%;">
                        <li class="tab col s4"><a class="active" href="#wait">未出行订单</a></li>
                        <li class="tab col s4"><a href="#finish" class="">已完成订单</a></li>
                        <li class="tab col s4"><a href="#cancel" class="">已取消订单</a></li>
                        <div class="indicator" style="right: 394px; left: 0px;"></div></ul>
                </div>

                <div id="wait">
                    <ul class="collapsible collapsible-accordion" data-collapsible="accordion">
                        <c:forEach var="order" items="${wait}" varStatus="status">
                            <li class="">
                                <div class="collapsible-header">
                                    <i class="material-icons">store</i>
                                    ${order.hostel_name}-${order.plan_name}
                                </div>
                                <div class="collapsible-body" style="display: none;">
                                    <span>
                                        <div class="row">
                                            <div class="col m9">
                                                金额:${order.amount}<br>
                                                时间:${order.fromdate}到${order.todate}<br>
                                                <c:if test="${order.type=='card'}">
                                                    支付方式:会员卡支付<br>
                                                </c:if>
                                                <c:if test="${order.type=='cash'}">
                                                    支付方式:现金支付<br>
                                                </c:if>
                                                人数:${order.number}人<br>
                                                订单时间:${order.order_time}&nbsp;&nbsp;订单状态:未出行<br>
                                            </div>
                                            <form action="cancelorder" method="post">
                                                <input name="order_id" value="${order.order_id}"type="text" hidden style="display: none">
                                                <input name="login" value="${order.user_login}"type="text" hidden style="display: none">
                                                <input name="amount" value="${order.amount}"type="text" hidden style="display: none">
                                                <input name="card" value="${order.type}"type="text" hidden style="display: none">

                                                <div class="col m3">
                                                    <button class="btn btn-lg btn-primary btn-block login-button" type="submit" style="border-color: #26a69a;background: #26a69a;margin-top: 10px">取消订单</button>
                                                </div>
                                            </form>
                                        </div>
                                    </span>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div id="finish">
                    <ul class="collapsible collapsible-accordion" data-collapsible="accordion">
                        <c:forEach var="order" items="${finish}" varStatus="status">
                            <li class="">
                                <div class="collapsible-header">
                                    <i class="material-icons">store</i>
                                        ${order.hostel_name}-${order.plan_name}
                                </div>
                                <div class="collapsible-body" style="display: none;">
                                    <span>
                                        <div class="row">
                                            <div class="col m9">
                                                金额:${order.amount}<br>
                                                时间:${order.fromdate}到${order.todate}<br>
                                                <c:if test="${order.type=='card'}">
                                                    支付方式:会员卡支付<br>
                                                </c:if>
                                                <c:if test="${order.type=='cash'}">
                                                    支付方式:现金支付<br>
                                                </c:if>
                                                人数:${order.number}人<br>
                                                订单时间:${order.order_time}&nbsp;&nbsp;订单状态:已完成<br>
                                            </div>
                                        </div>
                                    </span>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div id="cancel">
                    <ul class="collapsible collapsible-accordion" data-collapsible="accordion">
                        <c:forEach var="order" items="${cancel}" varStatus="status">
                            <li class="">
                                <div class="collapsible-header">
                                    <i class="material-icons">store</i>
                                        ${order.hostel_name}-${order.plan_name}
                                </div>
                                <div class="collapsible-body" style="display: none;">
                                    <span>
                                        <div class="row">
                                            <div class="col m9">
                                                金额:${order.amount}<br>
                                                时间:${order.fromdate}到${order.todate}<br>
                                                <c:if test="${order.type=='card'}">
                                                    支付方式:会员卡支付<br>
                                                </c:if>
                                                <c:if test="${order.type=='cash'}">
                                                    支付方式:现金支付<br>
                                                </c:if>
                                                人数:${order.number}人<br>
                                                订单时间:${order.order_time}&nbsp;&nbsp;订单状态:已取消<br>
                                                <c:if test="${order.type=='card'}">
                                                    <p style="color: #ff5a5f;">退款金额已到账</p>
                                                </c:if>
                                            </div>
                                        </div>
                                    </span>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>


            </div>
            <div id="info" class="section scroll-spy">
                <h3 class="header">
                    钱都去哪里了
                </h3>

                <div class="row">
                    <div class="col m12">
                        <table class="striped">
                            <thead>
                            <tr>
                                <th data-field="id">啥时候！</th>
                                <th data-field="id">我的钱！</th>
                                <th data-field="name">去哪了！</th>
                                <th data-field="price">多少钱！</th>
                                <th data-field="price">为什么！</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="tradeitem" items="${trade}" varStatus="status">
                                <tr>
                                    <td>${tradeitem.create_time}</td>
                                    <td>${tradeitem.from_login}</td>
                                    <td>${tradeitem.to_login}</td>
                                    <td>${tradeitem.amount}</td>
                                    <c:if test="${tradeitem.reason=='order'}">
                                        <td>当然是用来剁手下单了</td>
                                    </c:if>
                                    <c:if test="${tradeitem.reason=='drawback'}">
                                        <td>看来你退款了</td>
                                    </c:if>
                                    <c:if test="${tradeitem.reason=='applyForNewHostel'}">
                                        <td>你是不是想开个店</td>
                                    </c:if>
                                    <c:if test="${tradeitem.reason=='check'}">
                                        <td>经理大发慈悲给你发钱</td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
            </c:if>

        </div>
        <div class="col hide-on-small-only m3 l2">
            <div class="toc-wrapper pin-top" style="top: 0px;">
                <div style="height: 1px;">
                    <ul class="section table-of-contents">
                        <li><a href="#card-info" class="">会员卡信息</a></li>
                        <li><a href="#personal-info" class="">会员信息</a></li>
                        <li><a href="#register" class="">当前预定</a></li>
                        <li><a href="#info" class="">统计信息</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>


<%--底部footer--%>
<footer class="page-footer">
    <div class="container">
        <div class="row">
            <div class="col l4 s8">
                <h5 class="white-text">Hostel World</h5>
                <p class="grey-text text-lighten-4">一个没有中间商赚差价的客栈网站</p>
                <p class="grey-text text-lighten-4">店家多赚钱，游客少花钱</p>
            </div>
            <div class="col l4 s4" style="word-break: break-all;">
                <h5 class="white-text">实在不知道要写啥了</h5>
                <button class="btn waves-effect waves-light red lighten-3" type="submit" name="action" alt="PayPal - The safer, easier way to pay online!" style="border: none;color: #fff;border-radius:2px">+1s
                </button>
            </div>

            <div class="col l3 offset-l1 s12">
                <h5 class="white-text">如果你不喜欢</h5>
                <ul>
                    <li><a class="grey-text text-lighten-3" href="http://www.ctrip.com/">携程</a></li>
                    <li><a class="grey-text text-lighten-3" href="http://hotel.qunar.com/">去哪儿</a></li>
                    <li><a class="grey-text text-lighten-3" href="https://www.alitrip.com/">飞猪</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            © made by Nick
            <a class="grey-text text-lighten-4 right" href="#!">Try me!</a>
        </div>
    </div>
</footer><script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script>
    function check() {
        var number = document.getElementById("point2balance").value;
        alert(number);
        return false;
    }

    $(document).ready(function(){
        $('.scrollspy').scrollSpy();
    });

    $('.dropdown-button').dropdown({
                inDuration: 300,
                outDuration: 225,
                constrainWidth: false, // Does not change width of dropdown to that of the activator
                hover: true, // Activate on hover
                gutter: 0, // Spacing from edge
                belowOrigin: false, // Displays dropdown below the button
                alignment: 'left', // Displays dropdown with edge aligned to the left of button
                stopPropagation: false // Stops event propagation
            }
    );
</script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 2017/3/13
  Time: 下午2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客栈管理</title>
    <link href="/HostelWorld/css/costume/personal.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="/HostelWorld/css/materialize.min.css"  media="screen,projection"/>
    <link href="/HostelWorld/css/ghpages-materialize.css" rel="stylesheet"/>
    <%--<link href="css/airbnb/common-a7a76140779c5ed54899279593238a95.css" rel="stylesheet"/>--%>
    <%--<link href="css/airbnb/common_o2.1-7a9ba7f9634ca8f5f400a2d90082c402.css" rel="stylesheet"/>--%>
    <%--<link href="css/airbnb/landing_pages-487744574aa7b0a331ab1ec9aa593550.css" rel="stylesheet"/>--%>
    <%--<link href="css/airbnb/main-3da15b9c7afa29f4f14ae793f310cafb.css" rel="stylesheet"/>--%>
</head>
<body>

<%--顶部及左边--%>
<header>
    <nav class="top-nav">
        <div class="container">
            <div class="nav-wrapper">
                <a class="page-title">财务统计</a>

                <ul id="top-nav-mobile" class="right hide-on-med-and-down" style="margin: 36px">
                    <li class="white-text">客栈账户余额:${hostel.balance} ¥</li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <a href="#" data-activates="nav-mobile" class="button-collapse top-nav full hide-on-large-only"><i class="material-icons">menu</i></a></div>
    <ul id="nav-mobile" class="side-nav fixed" style="transform: translateX(0%);">
        <li class="logo" style="margin-bottom: 0px">
            <a id="logo-container" href="/HostelWorld/index" class="brand-logo">
                <object id="front-page-logo" type="image/svg+xml" data="/HostelWorld/pic/hotel.svg">Your browser does not support SVG</object>
            </a>
        </li>
        <li class="bold">
            <a href="modify" class="waves-effect waves-teal">修改信息</a>
        </li>
        <li class="bold ">
            <a href="plan" class="waves-effect waves-teal">发布计划</a>
        </li>
        <li class="bold ">
            <a href="register" class="waves-effect waves-teal">房客登记</a>
        </li>
        <li class="bold active">
            <a href="info" class="waves-effect waves-teal">财务统计</a>
        </li>
    </ul>
</header>

<main>
    <div class="container">
        <div class="row">

            <div id="order-info" class="section underline">
                <h3 class="header">
                    预定信息
                </h3>
                <div class="row">
                    <div class="col m12">
                        <table class="striped">
                            <thead>
                            <tr>
                                <th data-field="id">订单号</th>
                                <th data-field="id">下单时间</th>
                                <th data-field="name">房型</th>
                                <th data-field="price">入住时间</th>
                                <th data-field="price">退房时间</th>
                                <th data-field="price">用户名</th>
                                <th data-field="price">支付方式</th>
                                <th data-field="price">总价</th>
                                <th data-field="price">订单状态</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="order" items="${orders}">
                                <tr>
                                    <td>${order.order_id}</td>
                                    <td>${order.order_time}</td>
                                    <td>${order.plan_name}</td>
                                    <td>${order.fromdate}</td>
                                    <td>${order.todate}</td>
                                    <td>${order.user_login}</td>
                                    <td>${order.type}</td>
                                    <td>${order.amount}</td>
                                    <td>${order.state}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>

            <div id="register-info" class="section underline">
                <h3 class="header">
                    入住信息
                </h3>
                <div class="row">
                    <div class="col m12">
                        <table class="striped">
                            <thead>
                            <tr>
                                <th data-field="id">入住单号</th>
                                <th data-field="id">房客姓名</th>
                                <th data-field="name">入住时间</th>
                                <th data-field="price">退房时间</th>
                                <th data-field="price">人数</th>
                                <th data-field="price">支付方式</th>
                                <th data-field="price">是否会员</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="register" items="${registers}">
                                <tr>
                                    <td>${register.register_id}</td>
                                    <td>${register.names}</td>
                                    <td>${register.indate}</td>
                                    <td>${register.outdate}</td>
                                    <td>${register.humans}</td>
                                    <td>${register.type}</td>
                                    <td>${register.ismember}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
            <div id="trade-info" class="section underline">
                <h3 class="header">
                    经理什么时候给我发钱
                </h3>
                <div class="row">
                    <div class="col m12">
                        <table class="striped">
                            <thead>
                            <tr>
                                <th data-field="id">啥时候!!!</th>
                                <th data-field="name">发了多少?_?</th>
                                <th data-field="price">感谢的话</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="tradeitem" items="${trade}" varStatus="status">
                                <tr>
                                    <td>${tradeitem.create_time}</td>
                                    <td>${tradeitem.amount}</td>

                                    <c:if test="${tradeitem.amount<1000}">
                                        <td>感谢金主发钱</td>
                                    </c:if>
                                    <c:if test="${tradeitem.amount>1000 and tradeitem.amount<10000}">
                                        <td>发财了发财了</td>
                                    </c:if>
                                    <c:if test="${tradeitem.amount>10000}">
                                        <td>经理爸爸！</td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>

        </div>
    </div>
</main>




<script type="text/javascript" src="/HostelWorld/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/HostelWorld/js/materialize.min.js"></script>


</body>
</html>

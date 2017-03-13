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
    <link href="/HostelWorld/css/costume/hostel-manage.css" rel="stylesheet"/>
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
                <a class="page-title">房客登记</a>

                <ul id="top-nav-mobile" class="right hide-on-med-and-down" style="margin: 36px">
                    <li class="white-text">客栈账户余额:XXXX ¥</li>
                    &nbsp;&nbsp;&nbsp;
                    <button class="btn waves-effect waves-light" type="submit" name="action">
                        登出
                    </button>
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
        <li class="bold active">
            <a href="register" class="waves-effect waves-teal">房客登记</a>
        </li>
        <li class="bold">
            <a href="info" class="waves-effect waves-teal">财务统计</a>
        </li>
    </ul>
</header>

<main>
    <div class="container">
        <div class="row">
            <div class="col m12" style="border-bottom: 1px solid #dce0e0;padding-bottom: 20px">

                <h3>住店</h3>

                <div class="input-field col s12">
                    <input id="hostel" placeholder="请填写所有房客的姓名用','分隔" type="text">
                    <label for="hostel">房客姓名</label>
                </div>

                <div class="input-field col s6">
                    <input id="hunams" type="number">
                    <label for="hunams">人数</label>
                </div>

                <div class="input-field col s6">
                    <select>
                        <option value="" disabled selected>请选择房型</option>
                        <option value="1">Option 1</option>
                        <option value="2">Option 2</option>
                        <option value="3">Option 3</option>
                    </select>
                    <label>选择房型</label>
                </div>
                <div class="input-field col s6">
                    <select>
                        <option value="" disabled selected>选择支付方式</option>
                        <option value="1">会员卡支付</option>
                        <option value="2">现金支付</option>
                    </select>
                    <label>支付方式</label>
                </div>
                <div class="input-field col s6">
                <p>
                    <input type="checkbox" id="test6" checked="checked" />
                    <label for="test6">是否会员</label>
                </p>
                </div>

                <div class="col s12">
                    <button class="btn waves-effect waves-light" type="submit" name="action">
                        提交
                    </button>
                </div>
            </div>

            <div class="col m12">
                <h3>退房</h3>

                <div class="input-field col s12">
                    <input id="planid" type="number">
                    <label for="planid">入住单号</label>
                </div>
                <div class="col s12">
                    <button class="btn waves-effect waves-light" type="submit" name="action">
                        退房
                    </button>
                </div>

            </div>
        </div>
    </div>
</main>




<script type="text/javascript" src="/HostelWorld/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/HostelWorld/js/materialize.min.js"></script>
<script>
    $(document).ready(function() {
        $('select').material_select();
    });
</script>

</body>
</html>

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
    <title>Hostel经理</title>
    <link href="/HostelWorld/css/costume/manage.css" rel="stylesheet"/>
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
                <a class="page-title">审批申请</a>

                <ul id="top-nav-mobile" class="right hide-on-med-and-down" style="margin: 36px">
                    <li class="white-text">Hostel账户余额:XXXX ¥</li>
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
        <li class="bold active">
            <a href="approve" class="waves-effect waves-teal">审批申请</a>
        </li>
        <li class="bold">
            <a href="check" class="waves-effect waves-teal">支付结算</a>
        </li>
        <li class="bold">
            <a href="info" class="waves-effect waves-teal">Hostel统计</a>
        </li>
    </ul>
</header>

<main>
    <div class="container">
        <div class="row">
            <ul class="collapsible collapsible-accordion" data-collapsible="accordion">
                <li class="">
                    <div class="collapsible-header">
                        <i class="material-icons">room</i>
                        客栈名
                    </div>
                    <div class="collapsible-body" style="display: none;">
                        <span>
                            <div class="row">
                                <div class="col m8">
                                    账户余额：1000¥<br>
                                    地址：XXXX<br>
                                    <br>
                                </div>
                                <div class="col m4">
                                    <button class="btn waves-effect waves-light" type="submit" name="action">
                                        通过
                                    </button>
                                </div>
                            </div>
                            描述啊啊啊

                        </span>
                    </div>
                </li>
                <li class="">
                    <div class="collapsible-header">
                        <i class="material-icons">loop</i>
                        客栈名
                    </div>
                    <div class="collapsible-body" style="display: none;">
                        <span>
                            <div class="row">
                                <div class="col m8">
                                    账户余额：1000¥<br>
                                    地址：XXXX<br>
                                    <br>
                                </div>
                                <div class="col m4">
                                    <button class="btn waves-effect waves-light" type="submit" name="action">
                                        通过
                                    </button>
                                </div>
                            </div>
                            描述啊啊啊
                        </span>
                    </div>
                </li>
                <li class="">
                    <div class="collapsible-header"><i class="material-icons">loop</i>Third</div>
                    <div class="collapsible-body" style="display: none;"><span>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</span></div>
                </li>
            </ul>
        </div>
    </div>
</main>




<script type="text/javascript" src="/HostelWorld/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/HostelWorld/js/materialize.min.js"></script>
<script>
    $(document).ready(function(){
        $('.collapsible').collapsible();
    });
</script>

</body>
</html>

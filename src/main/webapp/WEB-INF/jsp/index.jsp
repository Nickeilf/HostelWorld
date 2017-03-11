<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 2017/3/10
  Time: 下午11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎来到Hostel World</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
    <link href="css/costume/home.css" rel="stylesheet"/>
    <link href="css/airbnb/common-a7a76140779c5ed54899279593238a95.css" rel="stylesheet"/>
    <link href="css/airbnb/common_o2.1-7a9ba7f9634ca8f5f400a2d90082c402.css" rel="stylesheet"/>
    <link href="css/airbnb/landing_pages-487744574aa7b0a331ab1ec9aa593550.css" rel="stylesheet"/>
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


                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="index" class="grey-text">首页</a></li>
                    <li><a href="sass.html" class="grey-text">客栈</a></li>
                    <li><a href="sass.html" class="grey-text">成为店家</a></li>
                    <li><a href="register"class="grey-text">注册</a></li>
                    <li><a href="login"class="grey-text">登录</a></li>
                </ul>
            </div>



        </div>
    </nav>
</div>

<div class="lando-hero">
    <div class="media-cover media-cover-dark pretzel-header-module" style="background-image:url(https://z0.muscache.com/lando_page/1047/image/1415366970/standard.jpg);">
    </div>

    <div class="page-container page-container-responsive header-content">
        <div class="row">
            <div class="col-12 text-center text-contrast">
                <h1 class="text-special">
                    Hostel World 精品客栈|与房东互动 了解民生疾苦
                </h1>

                <p class="h3">
                    北京 南京 东京 天津
                </p>
                <form accept-charset="UTF-8" action="/s" class="emphasized-search-form" data-behavior="validates-booking-dates" method="get">
                    <div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="✓"></div>

                    <%--地点--%>
                    <input type="text" name="location" data-behavior="autocompletes-addresses" class="location-input input-contrast input-large pull-left input-search" value="" placeholder="输入地点" autocomplete="off" style="width:300px;border:1px solid #aaa;outline:inherit;background: #fff;height:22px;border-radius: 2px;padding: 10px 10px 10px 10px">
                    <%--入住日期--%>
                    <input type="text" name="checkin" class="date-input checkin input-contrast input-large pull-left ui-datepicker-target input-search" placeholder="入住日期" style="width:120px;border:1px solid #aaa;outline:inherit;background: #fff;height:22px;border-radius: 2px;padding: 10px 10px 10px 10px">
                    <%--退房日期--%>
                    <input type="text" name="checkout" class="date-input checkout input-contrast input-large pull-left ui-datepicker-target input-search" placeholder="退房日期" style="width:120px;border:1px solid #aaa;outline:inherit;background: #fff;height:22px;border-radius: 2px;padding: 10px 10px 10px 10px">
                    <button type="submit" class="btn btn-large btn-primary pull-left"style="height: 42px">
                        搜索
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="page-container page-container-responsive listings-module">
    <div class="space-4 space-top-6">
        <div class="row row-table hide-sm">
            <div class="col-8 col-middle">
        <span class="h3">
          各地的独特房源任您挑选
        </span>
            </div>
            <div class="col-4 col-bottom">
                <a href="/s" class="pull-right">
                    更多
                </a>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col s12 m6 l4">
            <div class="card">
                <a href="#">
                <div class="card-image">
                    <img src="pic/house1.jpg">
                </div>
                </a>
                <div class="card-content">
                    <h5>￥998&nbsp;&nbsp;&nbsp;独立房间&nbsp;·&nbsp;1张床</h5>
                    <p>Aroma(n)tica TreehouseinMonferrato</p>
                </div>
            </div>
        </div>

        <div class="col s12 m6 l4">
            <div class="card">
                <a href="#">
                    <div class="card-image">
                        <img src="pic/house2.jpg">
                    </div>
                </a>
                <div class="card-content">
                    <h5>￥998&nbsp;&nbsp;&nbsp;整套公寓 · 2张床</h5>
                    <p>Waterfront with extraordinary view</p>
                </div>
            </div>
        </div>


        <div class="col s12 m6 l4">
            <div class="card">
                <a href="#">
                    <div class="card-image">
                        <img src="pic/house3.jpg">
                    </div>
                </a>
                <div class="card-content">
                    <h5>￥847&nbsp;&nbsp;&nbsp;独栋城堡 · 6张床</h5>
                    <p>The Gatehouse to Ayton Castle</p>
                </div>
            </div>
        </div>
    </div>





</div>





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
</footer>





    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>
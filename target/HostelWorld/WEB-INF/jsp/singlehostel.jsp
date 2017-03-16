<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 2017/3/12
  Time: 下午8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客栈详情</title>

    <link href="css/costume/singlehostel.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

    <%--<link href="css/airbnb/common-a7a76140779c5ed54899279593238a95.css" rel="stylesheet"/>--%>
    <link href="css/airbnb/common_o2.1-7a9ba7f9634ca8f5f400a2d90082c402.css" rel="stylesheet"/>
    <%--<link href="css/airbnb/landing_pages-487744574aa7b0a331ab1ec9aa593550.css" rel="stylesheet"/>--%>
    <%--<link href="css/airbnb/main-3da15b9c7afa29f4f14ae793f310cafb.css" rel="stylesheet"/>--%>
</head>
<body>

<%--顶部--%>
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
                    <li><a href="hostel" class="grey-text">客栈</a></li>
                    <li><a href="apply" class="grey-text">成为店家</a></li>
                    <li><a href="register"class="grey-text">注册</a></li>
                    <li><a href="login"class="grey-text">登录</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>

<%--图片--%>
<div class="carousel carousel-slider initialized" style="height: 340px;">
    <a class="carousel-item active" href="#one!" style="z-index: 0; opacity: 1; display: block; transform: translateX(0px) translateX(0px) translateX(0px) translateZ(0px);"><img src="pic/desktop_hero.jpg"></a>
    <a class="carousel-item" href="#two!" style="transform: translateX(0px) translateX(680px) translateZ(0px); z-index: -1; opacity: 1; display: block;"><img src="pic/house1.jpg"></a>
    <a class="carousel-item" href="#three!" style="transform: translateX(0px) translateX(-1360px) translateZ(0px); z-index: -2; opacity: 1; display: block;"><img src="pic/house2.jpg"></a>
    <a class="carousel-item" href="#four!" style="transform: translateX(0px) translateX(-680px) translateZ(0px); z-index: -1; opacity: 1; display: block;"><img src="pic/house3.jpg"></a>
</div>
<%--综述--%>

<div class="container">

    <div class="row">
        <%--信息界面--%>
        <br>
        <div class="col m7">

            <div class="row underline">
            <h3 class="underline">
                房源详情
            </h3>
                <div class="col m9">
                    <h3>
                        <c:out value="${hostel.hostel_name}"></c:out>
                    </h3>
                    <h5>
                        <c:out value="${plan.room}"></c:out>
                    </h5>
                    <p><c:out value="${hostel.address}"></c:out></p>
                    <div class="row" style="margin-bottom: 0px;">
                        <div class="col m4">
                            <div class="left-icon">
                                <embed src="/HostelWorld/pic/piggy-bank.svg" width="36" height="36"
                                       type="image/svg+xml"
                                       pluginspage="http://www.adobe.com/svg/viewer/install/"></embed>
                            </div>
                            <p>¥<c:out value="${plan.price}"></c:out>每晚</p>
                        </div>
                        <div class="col m4">
                            <div class="left-icon">
                                <embed src="/HostelWorld/pic/bed.svg" width="36" height="36"
                                       type="image/svg+xml"
                                       pluginspage="http://www.adobe.com/svg/viewer/install/"></embed>
                            </div>
                            <p>共<c:out value="${plan.bed_num}"></c:out>张床</p>
                        </div>

                        <div class="col m4">
                            <div class="left-icon">
                                <embed src="/HostelWorld/pic/stick-man.svg" width="36" height="36"
                                       type="image/svg+xml"
                                       pluginspage="http://www.adobe.com/svg/viewer/install/"></embed>
                            </div>
                            <p><c:out value="${plan.people}"></c:out>人居住</p>
                        </div>
                    </div>
                </div>

                <div class="col m3">
                    <div class="col m12" style="text-align: center">
                        <img src="pic/original.jpg" class="avatar" alt="avatar" style="border-radius: 64px;width: 64px;height:64px">
                    </div>

                    <p class="center">${member.name}</p>
                </div>
            </div>

            <div class="row underline">
                <div class="col m12">
                <h5 class="promo-caption">客栈简述</h5>
                <p class="light" style="word-wrap:break-word;font-size: 20px">
                    <c:out value="${hostel.description}"></c:out>
                </p>
                </div>
                <div class="col m12">
                    <h4 class="promo-caption">关于此房源</h4>
                    <p class="light" style="word-wrap:break-word;font-size: 20px">
                        <c:out value="${plan.plan_description}"></c:out>
                    </p>

                </div>
            </div>

            <div class="row underline">
            <div class="col m12">
                <h5 class="promo-caption">联系房东</h5>
                <div class="col m6">
                    <p><i class="material-icons">call</i>${member.phone}</p>
                </div>
                <div class="col m6">
                    <p><i class="material-icons">email</i>${member.email}</p>
                </div>
            </div>
            </div>


            <div class="row">
                <div class="col m12">
                    <h5 class="promo-caption">更多照片</h5>
                </div>

                <div class="col m12">
                    <div class="col s12 m6 l4">
                        <div class="card">
                            <div class="card-image">
                                <img src="pic/house1.jpg">
                            </div>
                        </div>
                    </div>
                    <div class="col s12 m6 l4">
                        <div class="card">
                            <div class="card-image">
                                <img src="pic/house1.jpg">
                            </div>
                        </div>
                    </div>
                    <div class="col s12 m6 l4">
                        <div class="card">
                            <div class="card-image">
                                <img src="pic/house1.jpg">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>




        <%--付款界面--%>
        <div class="col m5">
            <div class="pay-panel">
                <div class="row">
                    <div class="col m6">
                        <label for="fromdate" class="SearchForm__label"><span>入住时间</span></label>
                        <input type="date" class="datepicker" id="fromdate">
                    </div>
                    <div class="col m6">
                        <label for="fromdate" class="SearchForm__label"><span>退房时间</span></label>
                        <input type="date" class="datepicker" id="todate">
                    </div>

                </div>
                <div class="row">
                    <div class="col m12">
                        <label for="human">人数</label>
                        <input type="number" id="human">
                    </div>
                </div>
                <div class="row">
                    <div class="col m6">
                        <p>
                            <input name="group1"  class="with-gap" type="radio" id="test1" checked/>
                            <label for="test1" style="padding-top:0px;padding-bottom: 0px">会员卡付款</label>
                        </p>
                    </div>
                    <div class="col m6">
                        <p>
                            <input name="group1" class="with-gap" type="radio" id="test2" />
                            <label for="test2" style="padding-top:0px;padding-bottom: 0px">到店付款</label>
                        </p>
                    </div>
                </div>




                <button type="submit" class="btn btn-primary btn-large btn-block" data-reactid="95">
                    <div data-reactid="96"><div class="hide-lg" data-reactid="97">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" class="notInline_uhlm2" style="fill:currentColor;height:1em;width:1em;" data-reactid="98"><path fill-rule="evenodd" d="M23.53 22.47l-6.807-6.808A9.455 9.455 0 0 0 19 9.5 9.5 9.5 0 1 0 9.5 19c2.353 0 4.502-.86 6.162-2.277l6.808 6.807a.75.75 0 0 0 1.06-1.06zM9.5 17.5a8 8 0 1 1 0-16 8 8 0 0 1 0 16z" data-reactid="99"></path></svg>
                    </div>
                        <span class="SearchForm__submit-text hide-md" data-reactid="100"><span data-reactid="101">申请预定</span></span>
                    </div>
                </button>

                    </div>
                </div>
            </div>

        </div>





<%--底部--%>
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
<script>
    $('.carousel.carousel-slider').carousel({fullWidth: true});
    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 17 // Creates a dropdown of 15 years to control year
    });
</script>
</body>
</html>

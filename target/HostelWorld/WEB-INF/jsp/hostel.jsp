<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 2017/3/11
  Time: 下午9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更多房源</title>
    <link href="css/costume/hostel.css" rel="stylesheet"/>
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

                <c:if test="${empty sessionScope.user}">
                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="index" class="grey-text">首页</a></li>
                        <li><a href="hostel" class="grey-text">客栈</a></li>
                        <li><a href="apply" class="grey-text">成为店家</a></li>
                        <li><a href="register"class="grey-text">注册</a></li>
                        <li><a href="login"class="grey-text">登录</a></li>
                    </ul>
                </c:if>
                <c:if test="${not empty sessionScope.user}">
                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="index" class="grey-text">首页</a></li>
                        <li><a href="hostel" class="grey-text">客栈</a></li>
                        <li><a href="apply" class="grey-text">成为店家</a></li>
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
    <br>
    <%--搜索框--%>
    <div class="row search-border">

        <form method="post" action="hostel" name="search-form" onsubmit="return check()">
        <div class="col m3">
            <label for="search-location" class="SearchForm__label"><span>地点</span></label>
            <input type="text" class="LocationInput input-large" name="location" id="location" placeholder="目的地，城市" autocomplete="off" id="search-location" value="${location}" data-reactid="20">
        </div>


        <div class="col m5 inside-search-border" style="border-left: 1px solid #dce0e0;border-right: 1px solid #dce0e0">
            <div class="col m6">
                <label for="checkin" class="SearchForm__label"><span>入住时间</span></label>
                <input type="date" class="datepicker" name="checkin" value="${checkin}" id="checkin">
            </div>
            <div class="col m6">
                <label for="checkout" class="SearchForm__label"><span>退房时间</span></label>
                <input type="date" class="datepicker" name="checkout" value="${checkout}" id="checkout">
            </div>
        </div>
        <div class="col m4">
            <div class="col m6">
                <label for="human">人数</label>
                <input type="number" id="human" value="${human}" name="human">
            </div>
            <div class="col m6" style="padding: 16px">
                <button type="submit" class="btn btn-primary btn-large btn-block" data-reactid="95">
                    <div data-reactid="96"><div class="hide-lg" data-reactid="97">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" class="notInline_uhlm2" style="fill:currentColor;height:1em;width:1em;" data-reactid="98"><path fill-rule="evenodd" d="M23.53 22.47l-6.807-6.808A9.455 9.455 0 0 0 19 9.5 9.5 9.5 0 1 0 9.5 19c2.353 0 4.502-.86 6.162-2.277l6.808 6.807a.75.75 0 0 0 1.06-1.06zM9.5 17.5a8 8 0 1 1 0-16 8 8 0 0 1 0 16z" data-reactid="99"></path></svg>
                    </div>
                        <span class="SearchForm__submit-text hide-md" data-reactid="100"><span data-reactid="101">搜索</span></span>
                    </div>
                </button>
            </div>

        </div>
        </form>
    </div>


    <%--主体部分--%>
    <div class="row">
        <div class="col m12">
            <div class="row row-table hide-sm">
                <div class="col-8 col-middle">
                    <span class="h3">
                      搜索结果
                    </span>
                </div>
                <div class="col-4 col-bottom">
                    <a href="/s" class="pull-right">
                        按价格由低到高
                    </a>
                </div>
            </div>
        </div>

        <c:forEach var="plan" items="${plans}" varStatus="status">
            <div class="col s12 m6 l4">
                <div class="card">
                    <a href="/HostelWorld/singleHostel?id=${plan.plan_id}">
                        <div class="card-image">
                            <img src="pic/house${status.count%3}.jpg">
                        </div>
                    </a>
                    <div class="card-content">
                        <h5>￥${plan.price}&nbsp;&nbsp;&nbsp;可供<c:out value="${plan.people}"/>个人居住&nbsp;·&nbsp;${plan.bed_num}张床</h5>
                        <p>${plan.room}</p>
                    </div>
                </div>
            </div>
        </c:forEach>


    </div>
</div>

<br>



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
    function check(){
        var location=document.getElementById("location").value;
        var checkin =document.getElementById("checkin").value;
        var checkout=document.getElementById("checkout").value;
        var human   =document.getElementById("human").value;

        var success=true;
        if(location==null||location=='') {
            Materialize.toast("地点不能为空", 2000);
            success=false;
        }
        if(checkin==null||checkin==''){
            Materialize.toast("入住日期不能为空", 2000);
            success=false;
        }
        if(checkout==null||checkout==''){
            Materialize.toast("退房日期不能为空", 2000);
            success=false;
        }
        if(human==null||human==''){
            Materialize.toast("人数日期不能为空", 2000);
            success=false;
        }

        if(checkin!=null&&checkin!=''&&checkout!=null&&checkout!=''){
            var d1=toDate(checkin);
            var d2=toDate(checkout);
            if(d1>=d2){
                Materialize.toast("入住日期不能晚于退房日期", 2000);
                success=false;
            }

        }

        return success;
    }

    function toDate(str){
        var sd=str.split("-");
        return new Date(sd[0],sd[1],sd[2]);
    }

    $(document).ready(function(){
        $('.collapsible').collapsible();
    });
</script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 2017/3/11
  Time: 下午8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册账号</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
    <link href="css/costume/register.css" rel="stylesheet"/>
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

<br>

<div class="container">
    <div class="row">
        <div class="col l4 offset-l4">
            <form class="form-signin" id="register-form" method="post" action="checkRegister" onsubmit="return check()">
                <h3 class="form-signin-heading">注册</h3>
                <p style="color: #ff5a5f;">${message}</p>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="login" name="login" type="text" class="validate">
                        <label for="login">用户名</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="password" name="password" type="password" class="validate">
                        <label for="password">密码</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="repassword" name="repassword" type="password" class="validate">
                        <label for="repassword">再次输入密码</label>
                    </div>
                </div>
                <button class="btn btn-lg btn-primary btn-block login-button" type="submit" style="border-color: #26a69a;background: #26a69a;margin-top: 20px">注册</button>
            </form>
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
</footer>
<script>
    function check() {
        var login=document.getElementById("login").value;
        var password =document.getElementById("password").value;
        var repassword =document.getElementById("repassword").value;

        var success=true;
        if(login==null||login==''){
            Materialize.toast("用户名不能为空", 2000);
            success=false;
        }
        if(password==null||password==''){
            Materialize.toast("密码不能为空", 2000);
            success=false;
        }
        if(repassword==null||repassword==''){
            Materialize.toast("确认密码不能为空", 2000);
            success=false;
        }

        if(password!=repassword){
            Materialize.toast("密码和确认密码需一致",2000);
            success=false;
        }


        return success;
    }
</script>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>

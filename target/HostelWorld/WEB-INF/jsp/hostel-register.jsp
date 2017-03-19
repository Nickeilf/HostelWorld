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

                <form name="reigsterin" action="registerin" method="post" onsubmit="return check()">
                    <div class="row">
                <div class="input-field col s12">
                    <input id="names" name="names" placeholder="请填写所有房客的姓名用','分隔" type="text">
                    <label for="names">房客姓名</label>
                </div>

                    <input name="hostel_id" value="${hostel.hostel_id}"type="text" hidden style="display: none">

                <div class="input-field col s6">
                    <input id="humans" name="humans" type="number">
                    <label for="humans">人数</label>
                </div>

                <div class="input-field col s6">
                    <input id="order_id" name="order_id" placeholder="若无预定就不用填写" type="number">
                    <label for="order_id">订单号</label>
                </div>
                <div class="input-field col s6">
                    <select id="type" name="type">
                        <option value="" disabled selected>选择支付方式</option>
                        <option value="1">会员卡支付</option>
                        <option value="2">现金支付</option>
                    </select>
                    <label>支付方式</label>
                </div>

                <div class="input-field col s6">
                <p>
                    <input type="checkbox" name="card" id="card" checked="checked" />
                    <label for="card">是否会员</label>
                </p>
                </div>
                    </div>
                    <div class="row">


                <div class="col s6 offset-s6">
                    <button class="btn waves-effect waves-light"style="margin-top: 15px" type="submit" name="action">
                        提交
                    </button>
                </div>
                    </div>
                </form>
            </div>

            <div class="col m12">
                <h3>退房</h3>

                <form name="checkout-form" action="checkout" method="post" onsubmit="return checkout()">
                <div class="input-field col s12">
                    <input id="registerid" name="registerid" type="number">
                    <label for="registerid">入住单号</label>
                </div>
                <div class="col s12">
                    <button class="btn waves-effect waves-light" type="submit" name="action">
                        退房
                    </button>
                </div>
                </form>

            </div>
        </div>
    </div>
</main>




<script type="text/javascript" src="/HostelWorld/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/HostelWorld/js/materialize.min.js"></script>
<script>
    function checkout() {
        var registerId=document.getElementById("registerid").value;
        var success=true;
        if(registerId==null||registerId=='') {
            Materialize.toast("入住单号不能为空", 2000);
            success=false;
        }
        return success;
    }

    function check(){
        var names = document.getElementById("names").value;
        var humans= document.getElementById("humans").value;
        var type = document.getElementById("type").value;
        var card=document.getElementById("card").value;

        var success=true;
        if(names==null||names=='') {
            Materialize.toast("房客姓名不能为空", 2000);
            success=false;
        }
        if(humans==null||humans==''){
            Materialize.toast("人数不能为空", 2000);
            success=false;
        }
        if(type==null||type==''){
            Materialize.toast("请选择支付方式", 2000);
            success=false;
        }

        return success;
    }

    $(document).ready(function() {
        $('select').material_select();
    });
</script>

</body>
</html>

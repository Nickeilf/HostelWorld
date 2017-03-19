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
                <a class="page-title">发布计划</a>

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
        <li class="bold active">
            <a href="plan" class="waves-effect waves-teal">发布计划</a>
        </li>
        <li class="bold">
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
                <h3>发布新计划</h3>

                <form name="plan-form" action="newplan" method="post" onsubmit="return check()">
                    <div class="input-field col s6">
                        <input id="room" name="room" type="text">
                        <label for="room">房型名称</label>
                    </div>
                    <div class="input-field col s6">
                        <input id="price" name="price" placeholder="价格按每晚/元计算" type="number">
                        <label for="price">房间价格</label>
                    </div>
                    <div class="input-field col s6">
                        <input id="fromdate" name="fromdate" type="date" class="datepicker">
                        <label for="fromdate">起始时间</label>
                    </div>
                    <div class="input-field col s6">
                        <input id="todate" name="todate" type="date" class="datepicker">
                        <label for="todate">终止时间</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="humans" name="humans" type="number">
                        <label for="humans">可居住人数</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="beds" name="beds" type="number" >
                        <label for="beds">房间床数</label>
                    </div>
                    <div class="input-field col s12">
                        <textarea id="description" name="description" class="materialize-textarea" data-length="120"></textarea>
                        <label for="description">房间描述</label>
                        <span class="character-counter" style="float: right; font-size: 12px; height: 1px;"></span>
                    </div>
                    <div class="col s6 offset-s6">
                        <button class="btn waves-effect waves-light" type="submit" name="action">
                            提交
                        </button>
                    </div>
                </form>

            </div>

            <div class="col m12">
                <h3>当前计划</h3>

                <ul class="collapsible collapsible-accordion" data-collapsible="accordion">
                    <c:forEach var="plan" items="${plan}" varStatus="status">
                        <li class="">
                            <div class="collapsible-header">
                                <i class="material-icons">store</i>
                                ${plan.room}(${plan.price}¥每晚)
                            </div>
                            <div class="collapsible-body" style="display: none;">
                            <span>
                                <div class="row">
                                    <div class="col m8">
                                        从${plan.fromdate}到${plan.todate}<br>
                                        ${plan.bed_num}张床<br>
                                        可供${plan.people}人居住<br>
                                    </div>
                                </div>
                            </span>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</main>




<script type="text/javascript" src="/HostelWorld/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/HostelWorld/js/materialize.min.js"></script>
<script>
    function check() {
        var room = document.getElementById("room").value;
        var price = document.getElementById("price").value;
        var fromdate = document.getElementById("fromdate").value;
        var todate = document.getElementById("todate").value;
        var humans = document.getElementById("humans").value;
        var bed = document.getElementById("beds").value;
        var description = document.getElementById("description").value;

        var success=true;
        if(room==null||room==''){
            Materialize.toast("房间名称不能为空",2000);
            success=false;
        }
        if(price==null||price==''){
            Materialize.toast("房间价格不能为空",2000);
            success=false;
        }
        if(fromdate==null||fromdate==''){
            Materialize.toast("开始时间不能为空",2000);
            success=false;
        }
        if(todate==null||todate==''){
            Materialize.toast("结束时间不能为空",2000);
            success=false;
        }
        if(humans==null||humans==''){
            Materialize.toast("最大人数不能为空",2000);
            success=false;
        }
        if(bed==null||bed==''){
            Materialize.toast("床数不能为空",2000);
            success=false;
        }
        if(description==null||description==''){
            Materialize.toast("房间描述不能为空",2000);
            success=false;
        }

        if(checkin!=null&&checkin!=''&&checkin!=null&&checkin!=''){
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
    
    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 17, // Creates a dropdown of 15 years to control year
        format:'yyyy-mm-dd'
    });
</script>

</body>
</html>

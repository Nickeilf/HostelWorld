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
    <title>Hostel经理</title>
    <link href="/HostelWorld/css/costume/personal.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="/HostelWorld/css/materialize.min.css"  media="screen,projection"/>
    <link href="/HostelWorld/css/ghpages-materialize.css" rel="stylesheet"/>
    <script type="text/javascript" src="/HostelWorld/js/echarts.js"></script>
    <script type="text/javascript" src="/HostelWorld/js/echarts.min.js"></script>
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
                <a class="page-title">Hostel统计</a>

                <ul id="top-nav-mobile" class="right hide-on-med-and-down" style="margin: 36px">
                    <li class="white-text">Hostel账户余额:${manager.balance} ¥</li>
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
            <a href="approve" class="waves-effect waves-teal">审批申请</a>
        </li>
        <li class="bold ">
            <a href="check" class="waves-effect waves-teal">支付结算</a>
        </li>
        <li class="bold active">
            <a href="info" class="waves-effect waves-teal">Hostel统计</a>
        </li>
    </ul>
</header>

<main>
    <div class="container">
        <div class="row">
            <div id="register-info" class="section underline">
                <h3 class="header">
                    各店入住情况
                </h3>
                <div class="row">
                    <div class="col m12">
                        <table class="striped">
                            <thead>
                            <tr>
                                <th data-field="id">客栈号</th>
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
                                    <td>${register.hostel_id}</td>
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

                <div class="col m12">
                    <div id="register2" style="width:500px;height: 500px">
                        <script type="text/javascript">
                            // 基于准备好的dom，初始化echarts实例
                            var myChart = echarts.init(document.getElementById('register2'));

                            // 指定图表的配置项和数据
                            var dataStyle = {
                                normal: {
                                    label: {show:false},
                                    labelLine: {show:false},
                                    shadowBlur: 40,
                                    shadowColor: 'rgba(40, 40, 40, 0.5)',
                                }
                            };
                            var placeHolderStyle = {
                                normal : {
                                    color: 'rgba(0,0,0,0)',
                                    label: {show:false},
                                    labelLine: {show:false}
                                },
                                emphasis : {
                                    color: 'rgba(0,0,0,0)'
                                }
                            };
                            var option = {
                                backgroundColor: 'rgb(251,251,251)',
                                color: ['#85b6b2', '#6d4f8d','#cd5e7e', '#e38980','#f7db88'],
                                tooltip : {
                                    show: true,
                                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                                },
                                legend: {
                                    itemGap:12,
                                    data:['h000002','h000001','others']
                                },
                                toolbox: {
                                    show : true,
                                    feature : {
                                        mark : {show: true},
                                        dataView : {show: true, readOnly: false},
                                        restore : {show: true},
                                        saveAsImage : {show: true}
                                    }
                                },
                                series : [
                                    {
                                        name:'h000002',
                                        type:'pie',
                                        clockWise:false,
                                        radius : [180,200],
                                        itemStyle : dataStyle,
                                        hoverAnimation: false,

                                        data:[
                                            {
                                                value:300,
                                                name:'01'
                                            },
                                            {
                                                value:50,
                                                name:'invisible',
                                                itemStyle : placeHolderStyle
                                            }

                                        ]
                                    },
                                    {
                                        name:'h000001',
                                        type:'pie',
                                        clockWise:false,
                                        radius : [160, 180],
                                        itemStyle : dataStyle,
                                        hoverAnimation: false,

                                        data:[
                                            {
                                                value:20,
                                                name:'02'
                                            },
                                            {
                                                value:60,
                                                name:'invisible',
                                                itemStyle : placeHolderStyle
                                            }
                                        ]
                                    },
                                    {
                                        name:'others',
                                        type:'pie',
                                        clockWise:false,
                                        hoverAnimation: false,
                                        radius : [140, 160],
                                        itemStyle : dataStyle,

                                        data:[
                                            {
                                                value:10,
                                                name:'others'
                                            },
                                            {
                                                value:50,
                                                name:'invisible',
                                                itemStyle : placeHolderStyle
                                            }
                                        ]
                                    }

                                ]
                            };

                            // 使用刚指定的配置项和数据显示图表。
                            myChart.setOption(option);
                        </script>
                    </div>
                </div>

            </div>
            <div id="order-info" class="section underline">
                <h3 class="header">
                    预定/消费情况
                </h3>
                <div class="row">
                    <div class="col m12">
                        <table class="striped">
                            <thead>
                            <tr>
                                <th data-field="id">下单时间</th>
                                <th data-field="name">房型</th>
                                <th data-field="price">入住时间</th>
                                <th data-field="price">退房时间</th>
                                <th data-field="price">用户名</th>
                                <th data-field="price">支付方式</th>
                                <th data-field="price">总价</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="order" items="${orders}">
                                <tr>
                                    <td>${order.order_time}</td>
                                    <td>${order.plan_name}</td>
                                    <td>${order.fromdate}</td>
                                    <td>${order.todate}</td>
                                    <td>${order.user_login}</td>
                                    <td>${order.type}</td>
                                    <td>${order.amount}</td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <div class="col m12">
                        <div id="register3" style="width:400px;height: 400px">
                            <script type="text/javascript">
                                // 基于准备好的dom，初始化echarts实例
                                var myChart = echarts.init(document.getElementById('register3'));

                                // 指定图表的配置项和数据
                                var option = {
                                    tooltip: {
                                        trigger: 'item',
                                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                                    },
                                    legend: {
                                        orient: 'vertical',
                                        x: 'left',
                                        data:['会员卡支付','现金支付']
                                    },
                                    series: [
                                        {
                                            name:'访问来源',
                                            type:'pie',
                                            radius: ['50%', '70%'],
                                            avoidLabelOverlap: false,
                                            label: {
                                                normal: {
                                                    show: false,
                                                    position: 'center'
                                                },
                                                emphasis: {
                                                    show: true,
                                                    textStyle: {
                                                        fontSize: '30',
                                                        fontWeight: 'bold'
                                                    }
                                                }
                                            },
                                            labelLine: {
                                                normal: {
                                                    show: false
                                                }
                                            },
                                            data:[
                                                {value:8, name:'会员卡支付'},
                                                {value:1, name:'现金支付'},
                                            ]
                                        }
                                    ]
                                };
                                myChart.setOption(option);
                            </script>
                        </div>

                </div>
            </div>
            <div id="trade-info" class="section underline">
                <h3 class="header">
                    财务情况
                </h3>
                <div class="row">
                    <div class="col m12">
                        <table class="striped">
                            <thead>
                            <tr>
                                <th data-field="id">时间</th>
                                <th data-field="id">来源</th>
                                <th data-field="name">去向</th>
                                <th data-field="price">金额</th>
                                <th data-field="price">原因</th>
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
                                        <td>下单</td>
                                    </c:if>
                                    <c:if test="${tradeitem.reason=='drawback'}">
                                        <td>退款</td>
                                    </c:if>
                                    <c:if test="${tradeitem.reason=='applyForNewHostel'}">
                                        <td>开店申请</td>
                                    </c:if>
                                    <c:if test="${tradeitem.reason=='check'}">
                                        <td>支付结算</td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="col m12">
                        <div id="register" style="width:400px;height: 400px">
                            <script type="text/javascript">
                                // 基于准备好的dom，初始化echarts实例
                                var myChart = echarts.init(document.getElementById('register'));

                                // 指定图表的配置项和数据
                                var option = {
                                    title: {
                                        text: '金额变动'
                                    },
                                    tooltip : {
                                        trigger: 'axis'
                                    },
                                    legend: {
                                        data:['金额变动']
                                    },
                                    toolbox: {
                                        feature: {
                                            saveAsImage: {}
                                        }
                                    },
                                    grid: {
                                        left: '3%',
                                        right: '4%',
                                        bottom: '3%',
                                        containLabel: true
                                    },
                                    xAxis : [
                                        {
                                            type : 'category',
                                            boundaryGap : false,
                                            data : ['3-9','3-10','3-11','3-12','3-13','3-14','3-15','3-16','3-17','3-18','3-19']
                                        }
                                    ],
                                    yAxis : [
                                        {
                                            type : 'value'
                                        }
                                    ],
                                    series : [
                                        {
                                            name:'金额变动',
                                            type:'line',
                                            stack: '总量',
                                            areaStyle: {normal: {}},
                                            data:[100000,103613,109581,104872,105872,100364,100364,105872,111380,110987,125556]
                                        }
                                    ]
                                };

                                // 使用刚指定的配置项和数据显示图表。
                                myChart.setOption(option);
                            </script>
                        </div>
                    </div>
                </div>

            </div>
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

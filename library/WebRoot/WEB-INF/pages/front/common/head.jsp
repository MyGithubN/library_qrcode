<!--
    响应式导航栏(头部)
-->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<% String path1 = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head lang="zh-hans">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	
	<link rel="stylesheet" href="<%=path1 %>/public/plugins/bootstrap-3.3.5/css/bootstrap.min.css">
    <script src="<%=path1 %>/public/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
    <script src="<%=path1 %>/public/plugins/jquery-1.11.3/jquery.min.js"></script>

</head>
<body>
<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#home">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<%=path1%>/search_s_search">图书馆</a>
        </div>
        <div class="collapse navbar-collapse" id="home">
            <ul class="nav navbar-nav">
                <li><a href="<%=path1 %>/order_s_order">借阅记录</a></li>
                <li><a href="<%=path1 %>/bespeak_s_bespeak">预约记录</a></li>
                <li><a href="<%=path1 %>/collect_s_collect">我的收藏</a></li>
                <li><a href="<%=path1 %>/history_s_history">我的足迹</a></li>
                <s:if test="#session.student == null">
                	<li><a href="<%=path1 %>/user_s_login">登录</a></li>
                </s:if>
                <s:else>
                	<li><a href="<%=path1 %>/user_exit">退出登录</a></li>
                </s:else>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
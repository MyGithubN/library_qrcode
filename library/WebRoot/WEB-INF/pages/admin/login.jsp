<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
    String path = request.getContextPath();
%>

<html lang="zh-CN" class="bootstrap-admin-vertical-centered">
<head>
	<title>登录</title>
    <meta charset="UTF-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

    <link rel="stylesheet" href="<%=path %>/public/plugins/bootstrap-3.3.5/css/bootstrap.min.css">
    <script src="<%=path %>/public/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
    <script src="<%=path %>/public/plugins/jquery-1.11.3/jquery.min.js"></script>
    <script src="<%=path %>/public/js/login.js"></script>
    
    <style type="text/css">
        .alert{
            margin: 0 auto 20px;
            text-align: center;
        }
    </style>
</head>
<body class="bootstrap-admin-without-padding">
<%@ include file="common/head.jsp"%>
<%@ include file="common/foot.jsp"%>
<br/>
<br/>
<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <div class="alert alert-info">
                <a class="close" data-dismiss="alert" href="#">&times;</a>
                <s:if test="#request.msg == null">
                欢迎登录借阅系统
                </s:if>
                <s:else>
                	${msg }
                </s:else>
            </div>
            <form class="bootstrap-admin-login-form" action="<%=path%>/admin_login" method="post">
                <div class="form-group">
                    <label class="control-label" for="username">账&nbsp;号</label>
                    <input type="text" class="form-control" id="username" placeholder="管理员帐号" name="username"/>
                    <label class="control-label" for="username" style="display:none;"></label>
                </div>
                <div class="form-group">
                    <label class="control-label" for="password">密&nbsp;码</label>
                    <input type="password" class="form-control" id="password" placeholder="密码"/ name="password">
                    <label class="control-label" for="username" style="display:none;"></label>
                </div>
                <input type="button" class="btn btn-lg btn-primary" id="login_submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;录"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
    String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head  lang="zh-hans">

	<title>登录</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

    <link rel="stylesheet" href="<%=path %>/public/plugins/bootstrap-3.3.5/css/bootstrap.min.css">
    <script src="<%=path %>/public/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
    <script src="<%=path %>/public/plugins/jquery-1.11.3/jquery.min.js"></script>
    <script src="<%=path %>/public/js/login.js"></script>

</head>
<body>

<%@ include file="common/head.jsp"%>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                登 录
            </h3>
            <p class="text-center">
                ${msg }
            </p>
            <br/>
            <form class="form-horizontal" role="form" action="<%=path %>/user_login" method="post">
                <div class="form-group">
                    <label class="col-md-2 control-label" for="username">账&nbsp;号</label>
                    <div class="col-md-10">
                    	<input type="text" class="form-control" id="username" name="student.phone" placeholder="手机号 / 学号"/>
                    	<label class="control-label" for="username" style="display:none;"></label>
                	</div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="password">密&nbsp;码</label>
                    <div class="col-md-10">
                    	<input type="password" class="form-control" id="password"  name="student.password" placeholder="密码"/>
                    	<label class="control-label" for="username" style="display:none;"></label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label><input type="checkbox"/>记住密码？</label>
                        </div>
                    </div>
                </div>
                <br/>
                <div class="form-group">
                    <div class="col-sm-5"></div>
                    <div class="col-sm-2 column">
                        <button type="button" class="btn btn-default btn-block btn-primary" id="login_submit">登 录</button>
                    </div>
                    <div class="col-sm-5"></div>
                </div>
                <br/>
                <div class="form-group">
                    <div class="col-sm-5"></div>
                    <div class="col-sm-2 column">
                        没有帐号？
                        <a href="<%=path %>/user_s_register" class="btn btn-default btn-block btn-success">注 册</a>
                    </div>
                    <div class="col-sm-5"></div>
                </div>
            </form>
        </div>
    </div>
</div>
<br/>
<br/>
<br/>
<br/>
</body>
</html>
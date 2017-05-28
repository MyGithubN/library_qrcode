
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head lang="zh-hans">

    <title>注册</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

    <link rel="stylesheet" href="<%=path %>/public/plugins/bootstrap-3.3.5/css/bootstrap.min.css">
    <script src="<%=path %>/public/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
    <script src="<%=path %>/public/plugins/jquery-1.11.3/jquery.min.js"></script>
	<script src="<%=path %>/public/js/login.js"></script>
	
</head>
<body>

<%@ include file="common/head.jsp"%>
<div class="container" >
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                注 册
            </h3>
            <p class="text-center">
                ${msg }
            </p>
            <br/>
            <form class="form-horizontal" role="form" action="<%=path%>/user_register" method="post">
                <div class="form-group">
                    <label class="col-md-2 control-label" for="sname">姓&nbsp;名</label>
                    <div class="col-md-10">
                    	<input type="text" class="form-control" id="sname" name="student.sname"  onchange="checkSname()" placeholder="真实姓名"/>
                    	<label class="control-label" for="sname" style="display:none;"></label>
                	</div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="sno">学&nbsp;号</label>
                    <div class="col-md-10">
                    	<input type="text" class="form-control" id="sno" name="student.sno"  onchange="checkSno()"  placeholder="学号"/>
                    	<label class="control-label" for="sno" style="display:none;"></label>
                	</div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="email">邮&nbsp;箱</label>
                    <div class="col-md-10">
                    	<input type="text" class="form-control" id="email" name="student.email"  onchange="checkEmail()" placeholder="*@*.com"/>
                    	<label class="control-label" for="email" style="display:none;"></label>
                	</div>
                </div>
                <div class="form-group">
	                    <label class="col-sm-2 control-label" for="phone">手机号码</label>
                    <div class="col-sm-10">
                        <input class="form-control" id="phone" type="text" name="student.phone"  onchange="checkPhone()" placeholder="0000"/>
                        <label class="control-label" for="phone" style="display:none;"></label>
                        <br/>
                        <!-- 
                        <div class="row">
                            <div class="col-xs-5 col-sm-3">
                                <input class="form-control" id="proving1" type="text" placeholder="手机验证码"/>
                            </div>
                            <div class="col-xs-2">
                                <button type="button" class="btn btn-default">发送验证码</button>
                            </div>
                            <div class="col-xs-4"></div>
                        </div>
                         -->
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="password">密&nbsp;码</label>
                    <div class="col-md-10">
                    	<input type="password" class="form-control" id="password" name="student.password" onchange="checkPassword()" placeholder="6-19位"/>
                    	<label class="control-label" for="password" style="display:none;"></label>
                	</div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="password2">确定密码</label>
                    <div class="col-md-10">
                    	<input type="password" class="form-control" id="password2" onchange="checkPassword2()" placeholder="请再输入一次"/>
                    	<label class="control-label" for="password2" style="display:none;"></label>
                	</div>
                </div>
                <br/>
                <div class="form-group">
                    <div class="col-sm-5"></div>
                    <div class="col-sm-2 column">
                        <button type="button" class="btn btn-default btn-block btn-primary" id="submit_register" >注 册</button>
                    </div>
                    <div class="col-sm-5"></div>
                </div>
                <br/>
                <div class="form-group">
                    <div class="col-sm-5"></div>
                    <div class="col-sm-2 column">
                        已有帐号？
                        <a href="<%=path %>/user_s_login" class="btn btn-default btn-block btn-success">登 录</a>
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
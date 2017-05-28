<!--
    响应式导航栏(底部)
-->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path2 = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head lang="zh-hans">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    
    <link rel="stylesheet" href="<%=path2 %>/public/plugins/bootstrap-3.3.5/css/bootstrap.min.css">
    <script src="<%=path2 %>/public/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
    <script src="<%=path2 %>/public/plugins/jquery-1.11.3/jquery.min.js"></script>
    
    <style type="text/css">
        .vertical-center {
            display: table;
            width: auto;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
<div class="row">
        <nav class="navbar navbar-default navbar-fixed-bottom">
                <div class="col-xs-4">
                    <div class="vertical-center">
                        <a class="navbar-brand fixed" href="<%=path2%>/search_s_bookType"><span class="glyphicon glyphicon-align-center"></span> 分类</a>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="vertical-center">
                        <a class="navbar-brand" href="<%=path2%>/search_s_search" ><span class="glyphicon glyphicon-search"></span> 搜索</a>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="vertical-center">
                        <a class="navbar-brand" href="<%=path2%>/user_s_home"><span class="glyphicon glyphicon-user"></span> 我的</a>
                    </div>
                </div>
        </nav>
    </div>
</body>
</html>
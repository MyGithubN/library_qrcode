<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head lang="zh-hans">

    <title>分类</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

    <link rel="stylesheet" href="<%=path %>/public/plugins/bootstrap-3.3.5/css/bootstrap.min.css">
    <script src="<%=path %>/public/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
    <script src="<%=path %>/public/plugins/jquery-1.11.3/jquery.min.js"></script>
	
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

<%@ include file="common/head.jsp"%>

<div class="row">
        <nav class="navbar navbar-default navbar-fixed-bottom">
                <div class="col-xs-4">
                    <div class="vertical-center">
                        <a class="navbar-brand fixed" href="<%=path%>/search_s_bookType" style="color:#a6e1ec"><span class="glyphicon glyphicon-align-center"></span> 分类</a>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="vertical-center">
                        <a class="navbar-brand" href="<%=path%>/search_s_search" ><span class="glyphicon glyphicon-search"></span> 搜索</a>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="vertical-center">
                        <a class="navbar-brand" href="<%=path%>/user_s_home"><span class="glyphicon glyphicon-user"></span> 我的</a>
                    </div>
                </div>
        </nav>
    </div>
<h4 class="text-center">分类</h4>
<br/>
    <div class="container">
    	<s:iterator value="#request.bookTypes" var="bookType">
			<div class="list-group-item">
	            <a href="<%=path%>/search_s_search?tname=<s:property value="#bookType.tname"/>"><s:property value="#bookType.tname"/></a><span class="badge"><s:property value="#bookType.bcount"/></span>
	        </div>
        </s:iterator>
    </div>
<br/>
<br/>
<br/>
<br/>
</body>
</html>

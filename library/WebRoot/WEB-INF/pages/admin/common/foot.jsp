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
                <div class="col-xs-12">
                    <div class="vertical-center">
                        <a class="navbar-brand" href="<%=path2%>/admin_s_home" ><span class="glyphicon glyphicon-home"></span></a>
                    </div>
                </div>
        </nav>
    </div>
</body>
</html>
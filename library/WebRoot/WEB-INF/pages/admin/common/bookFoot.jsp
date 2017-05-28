<!--
    图书信息(底部)
-->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path3 = request.getContextPath();
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
            <div class="row">
                <div class="col-xs-3">
                    <div class="vertical-center">
                        <a class="navbar-brand fixed" href="javascript:void(0)"><span class="glyphicon glyphicon-heart-empty"></span></a>
                    </div>
                </div>
                <div class="col-xs-5">
                    <div class="vertical-center">
                        <a class="navbar-brand" href="">立即借书</a>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="vertical-center">
                        <a class="navbar-brand" href="javascript:void(0)">预约</a>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head lang="zh-hans">
	
	<title><s:property value="#request.admin.sname"/></title>
    <meta charset="UTF-8">
    <title><s:property value="#request.student.sname"/></title>
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
    <script type="text/javascript">
		 window.onload = function() {
		  var show = document.getElementById("showTime");
		  setInterval(function() {
		   var time = new Date();
		   var m = time.getMonth() + 1;
		   var h = time.getHours();
		   var str;
		   if(h >=0 && h <= 12)
		   		str= "上午 ";
		   else
		   		str="下午 ";
		   var t = time.getFullYear() + "年" + m + "月" + time.getDate() + "日  "+ str + time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds();
		   show.innerHTML = t;
		  },1000);};
</script>
</head>
  <body>

<%@ include file="common/head.jsp"%>
<%@ include file="common/foot.jsp"%>
<p class="text-center">${msg }</p>
<br/>
<br/>
<br/>
<br/>
<div class="col-xs-12">
    <div class="list-group">
        <a href="javascript:void(0)" class="list-group-item active"><s:property value="#request.admin.aname"/></a>
        <div class="list-group-item" id="showTime"></div>
        <div class="list-group-item"></div>
        <div class="list-group-item">
        <a href="<%=path %>/order_ads_order" class="list-group-item active"> <span class="badge"><s:property value="#request.admin.jcount"/></span> 借阅记录</a>
        <div class="list-group-item"></div>
        <a href="<%=path %>/bespeak_ads_bespeak" class="list-group-item active"> <span class="badge"><s:property value="#request.admin.ycount"/></span> 预约记录</a>
    </div>
</div>
<br/>
<br/>
<br/>
<br/>
</div>
</body>
</html>

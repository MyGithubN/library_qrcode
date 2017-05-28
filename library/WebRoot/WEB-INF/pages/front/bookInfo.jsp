<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head lang="zh-hans">

	<title><s:property value="#request.book.bname"/></title>
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
            <div class="row">
                <div class="row">
                <div class="col-xs-3">
                    <div class="vertical-center">
                    	<s:if test="#request.ctag == 0">
                        	<a class="navbar-brand fixed" href="<%=path%>/collect_save?bid=<s:property value="#request.book.id" />"><span class="glyphicon glyphicon-heart-empty"></span></a>
                    	</s:if>
                    	<s:else>
                        	<a class="navbar-brand fixed" href="<%=path%>/collect_delete?cid=<s:property value="#request.ctag" />&bid=<s:property value="#request.book.id" />"><span class="glyphicon glyphicon-heart"></span></a>
                    	</s:else>
                    </div>
                </div>
                <div class="col-xs-7">
					<div class="vertical-center">
						<s:if test="#request.ytag == 0">
							<s:if test="#request.jtag == 0">
								<s:if test="#request.book.remain > 0">
									<a class="navbar-brand" href="<%=path%>/bespeak_save?bid=<s:property value="#request.book.id" />">在线预约</a>
								</s:if>
								<s:else>
									<a class="navbar-brand" href="<%=path%>/remind_save?bid=<s:property value="#request.book.id" />">有货提醒</a>
								</s:else>
							</s:if>
							<s:else>
							<a class="navbar-brand" href="<%=path%>/order_s_order?tab=1">查看借阅</a>
						</s:else>
						</s:if>
						<s:else>
							<a class="navbar-brand" href="<%=path%>/bespeak_s_bespeak?tab=1">查看预约</a>
						</s:else>
					</div>
				</div>
				<div class="col-xs-1"></div>
                </div>
            </div>
        </nav>
    </div>
<div class="container">
    <div class="row clearfix">
        <div class="col-xs-12 column">
            <h3 class="text-center">
                <s:property value="#request.book.bname"/>
            </h3>
            <p class="text-center">
                ${msg }
            </p>
            <img alt="140x150" src="<%=path%><s:property value="#request.bookImgPath" /><s:property value="#request.book.bookImg.iname" />.jpg" " class="img-thumbnail center-block" width="140" height="150"/> <br/>
            <dl class="dl-horizontal">
                <dt>
                    作者:
                </dt>
                <dd>
                     <s:property value="#request.book.author"/>
                </dd>
                <dt>
                    出版社:
                </dt>
                <dd>
                     <s:property value="#request.book.publishing"/>
                </dd>
                <dt>
                    ISBN:
                </dt>
                <dd>
                    <s:property value="#request.book.bno"/>
                </dd>
                <dt>
                    价格:
                </dt>
                <dd>
                    <s:property value="#request.book.price"/>
                </dd>
                <dt>
                    剩余库存:
                </dt>
                <dd>
                    <s:property value="#request.book.remain"/>
                </dd>
            </dl>
            <br/>
            <div class="tabbable" id="tabs-785329">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="#panel-492471" data-toggle="tab">详情</a>
                    </li>
                    <li>
                        <a href="#panel-681289" data-toggle="tab">书评</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="panel-492471">
                        <p>
                        <div class="panel-group" id="panel-19622">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-19622"
                                       href="#panel-element-325236">简介 </a>
                                </div>
                                <div id="panel-element-325236" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <s:property value="#request.book.brief" escapeHtml="false"/>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-19622"
                                       href="#panel-element-133356">目录</a>
                                </div>
                                <div id="panel-element-133356" class="panel-collapse collapse">
                                    <div class="panel-body" id="catalogue">
                                    	<s:property value="#request.book.catalogue" escapeHtml="false"/>
                                    </div>
                                </div>
                            </div>
                        </div>
 					</p>
                    </div>
                    <div class="tab-pane" id="panel-681289">
                        <p>
	                        <div class="container">
	                            <div class="row clearfix">
	                                <div class="col-md-12 column">
	                                    	<!--PC和WAP自适应版-->
										<div id="SOHUCS" sid="<s:property value="#request.book.id"/>"></div>
										<script type="text/javascript"> 
(function(){ 
var appid = 'cyt08Om3F'; 
var conf = 'prod_f1bef5273f10380759383a25318ddf0b'; 
var width = window.innerWidth || document.documentElement.clientWidth; 
if (width < 960) { 
window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="https://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>'); } else { var loadJs=function(d,a){var c=document.getElementsByTagName("head")[0]||document.head||document.documentElement;var b=document.createElement("script");b.setAttribute("type","text/javascript");b.setAttribute("charset","UTF-8");b.setAttribute("src",d);if(typeof a==="function"){if(window.attachEvent){b.onreadystatechange=function(){var e=b.readyState;if(e==="loaded"||e==="complete"){b.onreadystatechange=null;a()}}}else{b.onload=a}}c.appendChild(b)};loadJs("https://changyan.sohu.com/upload/changyan.js",function(){window.changyan.api.config({appid:appid,conf:conf})}); } })(); </script>
									</div>
	                            </div>
	                        </div>
                    </div>
                </div>
            </div>
            <hr/>
            <hr/>
            <s:property value="#request.tname" />图书推荐
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <ul>
                        	<s:iterator value="#request.recBooks" var="book">
	                            <li>
	                                <a href="<%=path%>/book_s_bookInfo?bid=<s:property value="#book.id"/>"><s:property value="#book.bname"/> </a>
	                            </li>
                            </s:iterator>
                        </ul>
                    </div>
                </div>
            </div>
<br/>
<br/>
<br/>
<br/>
</body>
</html>
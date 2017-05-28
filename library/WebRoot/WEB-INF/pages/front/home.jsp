<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head lang="zh-hans">
	
	<title><s:property value="#request.student.sname"/></title>
    <meta charset="UTF-8">
    <title><s:property value="#request.student.sname"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

    <link rel="stylesheet" href="<%=path %>/public/plugins/bootstrap-3.3.5/css/bootstrap.min.css">
    <script src="<%=path %>/public/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
    <script src="<%=path %>/public/plugins/jquery-1.11.3/jquery.min.js"></script>
	<script src="<%=path %>/public/js/login.js"></script>
	
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

<div class="row">
        <nav class="navbar navbar-default navbar-fixed-bottom">
                <div class="col-xs-4">
                    <div class="vertical-center">
                        <a class="navbar-brand fixed" href="<%=path%>/search_s_bookType"><span class="glyphicon glyphicon-align-center"></span> 分类</a>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="vertical-center">
                        <a class="navbar-brand" href="<%=path%>/search_s_search" ><span class="glyphicon glyphicon-search"></span> 搜索</a>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="vertical-center">
                        <a class="navbar-brand" href="<%=path%>/user_s_home" style="color:#a6e1ec"><span class="glyphicon glyphicon-user"></span> 我的</a>
                    </div>
                </div>
        </nav>
    </div>
<br/>
<div class="col-xs-12">
    <div class="list-group">
        <a id="modal-487946" href="#modal-container-487946" role="button" class="btn list-group-item active"  data-toggle="modal"><s:property value="#request.student.sname"/></a>
        <div class="list-group-item" id="showTime"></div>
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" 
								   href="#collapseThree2">
									推荐图书
								</a>
							</h4>
						</div>
						<div id="collapseThree2" class="panel-collapse collapse">
							<div class="panel-body">
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
				</div>
        <a href="<%=path %>/collect_s_collect" class="list-group-item active"> <span class="badge"><s:property value="#request.student.ccount"/></span>  我的收藏</a>
        <a href="<%=path %>/order_s_order" class="list-group-item active"> <span class="badge"><s:property value="#request.student.jcount"/></span> 借阅记录</a>
        <a href="<%=path %>/bespeak_s_bespeak" class="list-group-item active"> <span class="badge"><s:property value="#request.student.ycount"/></span>预约记录</a>
    	<a href="<%=path %>/history_s_history" class="list-group-item active"> <span class="badge"><s:property value="#request.student.hcount"/></span>我的足迹</a>
    </div>
<br/>
<br/>
<br/>
<br/>
<div class="modal fade" id="modal-container-487946" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h5 class="modal-title" id="myModalLabel">
						<s:property value="#request.student.sname"/>
					</h5>
					</div>
					<form class="form-horizontal" role="form" action="<%=path %>/user_update" method="post">
					<div class="modal-body">
			                <div class="form-group">
			                    <label class="col-md-2 control-label " for="sname">姓&nbsp;名</label>
			                    <div class="col-md-10">
			                    	<input type="text" class="form-control" id="sname" name="student.sname"  value="<s:property value="#request.student.sname"/>" disabled />
			                    	<label class="control-label" for="sname" style="display:none;"></label>
			                	</div>
			                </div>
			                <div class="form-group">
			                    <label class="col-md-2 control-label" for="sno">学&nbsp;号</label>
			                    <div class="col-md-10">
			                    	<input type="text" class="form-control" id="sno" name="student.sno"  value="<s:property value="#request.student.sno"/>"  disabled />
			                    	<label class="control-label" for="sno" style="display:none;"></label>
			                	</div>
			                </div>
			                <div class="form-group">
			                    <label class="col-md-2 control-label" for="email">邮&nbsp;箱</label>
			                    <div class="col-md-10">
			                    	<input type="text" class="form-control" id="email" name="student.email"  onchange="checkEmail()" placeholder="*@*.com" value="<s:property value="#request.student.email"/>"/>
			                    	<label class="control-label" for="email" style="display:none;"></label>
			                	</div>
			                </div>
			                <div class="form-group">
				                    <label class="col-sm-2 control-label" for="phone">手机号码</label>
			                    <div class="col-sm-10">
			                        <input class="form-control" id="phone" type="text" name="student.phone"  onchange="checkPhone()"  value="<s:property value="#request.student.phone"/>"/>
			                        <label class="control-label" for="phone" style="display:none;"></label>
			                        <br/>
			                     </div>
			                </div>
			                <div class="form-group">
			                    <label class="col-md-2 control-label" for="passwordy">原密码</label>
			                    <div class="col-md-10">
			                    	<input type="password" class="form-control" id="passwordy"  placeholder="6-19位" />
			                    	<label class="control-label" for="passwordy" style="display:none;"></label>
			                	</div>
			                </div>
			                <div class="form-group">
			                    <label class="col-md-2 control-label" for="newPassword">新密码</label>
			                    <div class="col-md-10">
			                    	<input type="password" class="form-control" id="password" name="student.password" onchange="checkPassword()" placeholder="6-19位"/>
			                    	<label class="control-label" for="password" style="display:none;"></label>
			                	</div>
			                </div>
					</div>
					</form>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary" id="submit">提交</button>
					</div>
				</div>
				<input type="hidden" value="<s:property value="#request.student.password"/>" id="pwd"/>
		</div>
</div>
</div>
</body>
</html>


<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head lang="zh-hans">

	<title> 借阅记录</title>
	<meta charset="utf-8">
	
	<link rel="stylesheet" href="<%=path %>/public/plugins/bootstrap-3.3.5/css/bootstrap.min.css">
    <script src="<%=path %>/public/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
    <script src="<%=path %>/public/plugins/jquery-1.11.3/jquery.min.js"></script>

	<!-- 响应式布局 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

	<style type="text/css">
		.table tbody tr td{
            vertical-align: middle;
		}
		
        .vertical-center {
            display: table;
            width: auto;
            margin-left: auto;
            margin-right: auto;
        }
	</style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-head">
	<div class="col-xs-4">
		<div class="vertical-center">
			<s:if test="#request.tab == 1">
				<a class="navbar-brand" href="javascript:void(0)"  style="color:#a6e1ec">待确定</a>
			</s:if>
			<s:else>
				<a class="navbar-brand" href="<%=path%>/order_s_order?tab=1" >待确定</a>
			</s:else>
		</div>
	</div>
	<div class="col-xs-4">
		<div class="vertical-center">
			<s:if test="#request.tab == 2">
				<a class="navbar-brand" href="javascript:void(0)"  style="color:#a6e1ec">以确定</a>
			</s:if>
			<s:else>
				<a class="navbar-brand" href="<%=path%>/order_s_order?tab=2" >以确定</a>
			</s:else>
		</div>
	</div>
	<div class="col-xs-4">
		<div class="vertical-center">
			<s:if test="#request.tab == 0">
				<a class="navbar-brand" href="javascript:void(0)" style="color:#a6e1ec">已归还</a>
			</s:if>
			<s:else>
				<a class="navbar-brand" href="<%=path%>/order_s_order?tab=0" >已归还</a>
			</s:else>
		</div>
	</div>
</nav>
       
<%@ include file="common/foot.jsp"%>

<h3 class="text-center">
	借阅记录
</h3>
<p class="text-center">
	${msg }
</p>
<br />
<h6 class="text-center" id="tab"><s:property value="#request.pageBean.totalCount" />条记录，共<s:property value="#request.pageBean.totalPage" />页</h6>
<div class="col-xs-12">
 <table class="table">
	<tbody>
        <s:iterator value="#request.pageBean.data" var="order">
        	<!-- 
        	<tr>
        		<td >
	        		<div class="progress">
						<div class="progress-bar" role="progressbar" aria-valuenow="100"
							aria-valuemin="0" aria-valuemax="100" style="width: 4%;">
							<span class="sr-only"></span>
						</div>
					</div>
	        	</td>
        	</tr>
        	-->
	        <tr>
	            <td>
	            	编号：<s:property value="#order.id" />
	            	<h4>书名：<s:property value="#order.book.bname" /></h4>
	                <h5>作者：<s:property value="#order.book.author" /></h5>
	                <h5>ISBN：<s:property value="#order.book.bno" /></h5>
	                <hr/>
	                <h5>
	                	确定时间：
	                	<s:if test="#order.adate == null">
	                	等待确定
	                	</s:if>
	                	<s:else>
	                		<s:property value="@com.library.util.DateUtils@formatDateTime(#order.adate)" />
	                	</s:else>
	                </h5>
	                <h5>创建时间：<s:property value="@com.library.util.DateUtils@formatDateTime(#order.bdate)" /></h5>
	                <h5>还书时间：<s:property value="@com.library.util.DateUtils@formatDateTime(#order.rdate)" /></h5>
	                <h6>
	                	状态：
	                		<s:if test="#order.yn == 0">
							已归还
							</s:if>
							<s:elseif test="#order.status == 1">
							等待确定
							</s:elseif>
							<s:elseif test="#order.status == 0">
							借阅成功
							</s:elseif>
	                </h6>
	                <a class="btn btn-default  btn-sm"  href="<%=path%>/order_s_qrcode?oid=<s:property value="#order.id"/>&sid=<s:property value="#order.student.id"/>">
	                	&nbsp&nbsp&nbsp<span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span>&nbsp&nbsp&nbsp
					</a>
	            </td>
	            <s:if test="#request.tab == 1">
		            <td>
		                <a href="<%=path %>/order_delete?oid=<s:property value="#order.id" />&tab=1"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a><br/>
		            </td>
	            </s:if>
	        </tr>
	        <tr>
	        	<td><br/></td>
	        </tr>
        </s:iterator>
	</tbody>
</table>
    <s:if test="#request.pageBean.totalPage == 1">
	    <hr/>
	    <p class="text-center">- END -</p>
	    <br/>
	    <br/>
	    <br/>
    </s:if>
</div>
</body>
</html>
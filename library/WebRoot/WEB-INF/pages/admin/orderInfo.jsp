
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head lang="zh-hans">

	<title>借书单</title>
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

<%@ include file="common/head.jsp"%>
<%@ include file="common/foot.jsp"%>

<h3 class="text-center">
	借书单
</h3>
<p class="text-center">
	${msg }
</p>
<br />
<div class="col-xs-12">
 <table class="table">
	<tbody>
	        <tr>
	            <td>
	            	编号：<s:property value="#request.bookStudent.id" />
	            	<h4>书名：<s:property value="#request.bookStudent.book.bname" /></h4>
	                <h5>作者：<s:property value="#request.bookStudent.book.author" /></h5>
	                <h5>ISBN：<s:property value="#request.bookStudent.book.bno" /></h5>
	                <hr/>
		                <h4>借阅人：<s:property value="#request.bookStudent.student.sname" /></h4>
		                <h5>学号：<s:property value="#request.bookStudent.student.sno" /></h5>
		                <h5>手机号码：<s:property value="#request.bookStudent.student.phone" /></h5>
		                <h5>预约次数：<s:property value="#request.bookStudent.student.ycount" /></h5>
		                <h5>借阅次数：<s:property value="#request.bookStudent.student.jcount" /></h5>
		                <h5>
		                	不良记录：
		                	<s:if test="#request.bookStudent.student.tag == 0">
		                		  无
		                	</s:if>
		                	<s:else>
		                		<s:property value="#request.bookStudent.student.tag" />
		                	</s:else>
		                </h5>
		                <hr/>
	                <h5>
	                	确定时间：
	                	<s:if test="#request.bookStudent.adate == null">
	                	等待确定
	                	</s:if>
	                	<s:else>
	                		<s:property value="@com.library.util.DateUtils@formatDateTime(#request.bookStudent.adate)" />
	                	</s:else>
	                </h5>
	                <h5>创建时间：<s:property value="@com.library.util.DateUtils@formatDateTime(#request.bookStudent.bdate)" /></h5>
	                <h5>还书时间：<s:property value="@com.library.util.DateUtils@formatDateTime(#request.bookStudent.rdate)" /></h5>
	                <h6>
	                	状态：
	                		<s:if test="#request.bookStudent.yn == 0">
							已归还
							</s:if>
							<s:elseif test="#request.bookStudent.status == 1">
							等待确定
							</s:elseif>
							<s:elseif test="#request.bookStudent.status == 0">
							借阅成功
							</s:elseif>
	                </h6>
	            </td>
	            <td><br/></td>
	            <td><br/></td>
	        </tr>
	        <tr>
	        	<td>
		        	<s:if test="#request.bookStudent.yn == 0">
							已归还
							</s:if>
							<s:elseif test="#request.bookStudent.status == 1">
								<form action="<%=path%>/order_borrow" method="post">
				        			<input type="submit" class="btn btn-lg btn-primary" id="login_submit" value=" 确定借出"/>
				        			<input type="hidden" name="sid" value="<s:property value="#request.bookStudent.student.id" />"/>
				        			<input type="hidden" name="oid" value="<s:property value="#request.bookStudent.id" />"/>
		        				</form>
							</s:elseif>
							<s:elseif test="#request.bookStudent.status == 0">
								<form action="<%=path%>/order_returnb" method="post">
				        			<input type="submit" class="btn btn-lg btn-primary" id="login_submit" value=" 确定归还"/>
				        			<input type="hidden" name="oid" value="<s:property value="#request.bookStudent.id" />"/>
		        				</form>
							</s:elseif>
	        	</td>
	        </tr>
	</tbody>
</table>
<br/>
<br/>
<br/>
</div>
</body>
</html>
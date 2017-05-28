
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%	
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head lang="zh-hans">

	<title>订单二维码</title>
	<meta charset="utf-8">
	
	<link rel="stylesheet" href="<%=path %>/public/plugins/bootstrap-3.3.5/css/bootstrap.min.css">
    <script src="<%=path %>/public/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
    <script src="<%=path %>/public/plugins/jquery-1.11.3/jquery.min.js"></script>

	<!-- 响应式布局 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	
</head>
<body>
<%@ include file="common/head.jsp"%>
<%@ include file="common/foot.jsp"%>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h4 class="text-center">请让图书管理员扫码确定</h4>
				<br />
				<s:if test="#request.bookStudent == null">
					<p class="text-center">二维码以失效</p>
				</s:if>
				<s:else>
					<img alt="300x300"
						src="${pageContext.request.contextPath }/img/bookStudent/<s:property value="#request.bookStudent.qname"/>.jpg"
						class="img-thumbnail center-block" width="200" height="200" />
				</s:else>
				<s:if test="#request.bookStudent != null">
					<h5 class="text-center">一分钟内有效</h5>
				</s:if>
				<br/>
				<div class="alert alert-dismissable alert-info">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
					<h4>步骤 !</h4>

					<p>1）图书馆管理员扫码</p>

					<p>2）检查图书是否正确</p>

					<p>3）管理员 确定借出</p>

					<p>该二维码将保存在我的借阅记录</p>
				</div>
				<br/>
				<br/>
				<br/>
			</div>
		</div>
	</div>
</body>
</html>
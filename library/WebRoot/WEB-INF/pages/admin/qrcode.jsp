
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
				<h4 class="text-center">借书单二维码</h4>
				<br />
				<s:if test="#request.bookStudent == null">
					<p class="text-center">二维码以失效</p>
				</s:if>
				<s:else>
					<img alt="300x300"
						src="${pageContext.request.contextPath }/img/bookStudent/<s:property value="#request.bookStudent.qname"/>.jpg"
						class="img-thumbnail center-block" width="200" height="200" />
				</s:else>
				<br/>
				<br/>
				<br/>
				<br/>
			</div>
		</div>
	</div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head lang="zh-hans">

	<title>我的收藏</title>
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
	</style>
</head>
<body>

<%@ include file="common/head.jsp"%>
<%@ include file="common/foot.jsp"%>

<h3 class="text-center">
	我的收藏
</h3>
<p class="text-center">
	${msg }
</p>
<br />
<h6 class="text-center" id="tab"><s:property value="#request.pageBean.totalCount" />条收藏，共<s:property value="#request.pageBean.totalPage" />页</h6>
<div class="col-xs-12">
    <table class="table table-hover">
        <tbody>
	        <s:iterator value="#request.pageBean.data" var="collect">
		        <tr onclick="parent.location='<%=path%>/book_s_bookInfo?bid=<s:property value='#collect.book.id' />'">
		            <td><br/></td>
		            <td>
		                <img src="<%=path%><s:property value="#request.bookImgPath" /><s:property value="#collect.book.bookImg.iname" />.jpg" class="img-responsive center-block img-rounded" width="80"
		                     height="90"/>
		            </td>
		            <td><br/></td>
		            <td><br/></td>
		            <td>
		                <h4><s:property value="#collect.book.bname" /></h4>
		                <h5><s:property value="#collect.book.author" /></h5>
		                <h6><s:property value="#collect.book.ccount" />人收藏</h6>
		            </td>
		            <td>
		                <a href="<%=path %>/collect_delete?cid=<s:property value="#collect.id" />&tab=tab&currentPage=<s:property value="#request.pageBean.currentPage" />"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a><br/>
		            </td>
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
<s:if test="#request.pageBean.totalPage > 1">
<div class="col-xs-12">
    <div class="container">
        <nav style="text-align: center">
            <ul class="pagination pagination-lg">
            	<s:if test="1 == #request.pageBean.currentPage">
                	<li><a href="javascript:void(0)">&laquo;</a></li>
                </s:if>
                <s:else>
                	<li><a href="<%=path%>/collect_s_collect?currentPage=1">&laquo;</a></li>
                </s:else>
                
                <s:iterator value="#request.pageBean.pageList" var="page">
                	<s:if test="#page == #request.pageBean.currentPage">
                		<li class="active"><a href="javascript:void(0)" ><s:property value="#page"/></a></li>
                	</s:if>
                	<s:else>
                		<li><a href="<%=path%>/collect_s_collect?currentPage=<s:property value="#page"/>"><s:property value="#page"/></a></li>
                	</s:else>
                </s:iterator>
                
                <s:if test="#request.pageBean.totalPage == #request.pageBean.currentPage">
                	<li><a href="javascript:void(0)">&raquo;</a></li>
                </s:if>
                <s:else>
                	<li><a href="<%=path%>/collect_s_collect?currentPage=<s:property value="#request.pageBean.totalPage"/>">&raquo;</a></li>
                </s:else>
            </ul>
            <br/>
			<br/>
			<br/>
			<br/>
        </nav>
    </div>
</div>
</s:if>
</body>
</html>
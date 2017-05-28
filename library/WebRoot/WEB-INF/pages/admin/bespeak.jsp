
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head lang="zh-hans">

	<title> 预约记录</title>
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
		<div class="col-xs-6">
			<div class="vertical-center">
				<s:if test="#request.tab == 1">
                	<a class="navbar-brand" href="javascript:void(0)"  style="color:#a6e1ec">未完成</a>
                </s:if>
                <s:else>
                	<a class="navbar-brand" href="<%=path%>/bespeak_ads_bespeak" >未完成</a>
                </s:else>
			</div>
		</div>
		<div class="col-xs-6">
			<div class="vertical-center">
				<s:if test="#request.tab == 0">
					<a class="navbar-brand" href="javascript:void(0)" style="color:#a6e1ec">已完成</a>
				</s:if>
                <s:else>
                	<a class="navbar-brand" href="<%=path%>/bespeak_ads_bespeak?tab=0" >已完成</a>
                </s:else>
			</div>
		</div>
</nav>

<%@ include file="common/foot.jsp"%>

<h3 class="text-center">
	预约记录
</h3>
<p class="text-center">
	${msg }
</p>
<br/>
<h6 class="text-center" id="tab"><s:property value="#request.pageBean.totalCount" />条记录，共<s:property value="#request.pageBean.totalPage" />页</h6>
<div class="col-xs-12">
    <table class="table table-hover">
        <tbody>
	        <s:iterator value="#request.pageBean.data" var="bespeak">
		        <tr>
		            <td>
		            	编号：<s:property value="#bespeak.id" />
		            	<h4>书名：<s:property value="#bespeak.book.bname" /></h4>
		                <h5>作者：<s:property value="#bespeak.book.author" /></h5>
		                <h5>ISBN：<s:property value="#bespeak.book.bno" /></h5>
		                <hr/>
		                <h4>预约人：<s:property value="#bespeak.student.sname" /></h4>
		                <h5>学号：<s:property value="#bespeak.student.sno" /></h5>
		                <h5>手机号码：<s:property value="#bespeak.student.phone" /></h5>
		                <h5>预约次数：<s:property value="#bespeak.student.ycount" /></h5>
		                <h5>借阅次数：<s:property value="#bespeak.student.jcount" /></h5>
		                <h5>
		                	不良记录：
		                	<s:if test="#bespeak.student.tag == 0">
		                		  无
		                	</s:if>
		                	<s:else>
		                		<s:property value="#bespeak.student.tag" />
		                	</s:else>
		                </h5>
		                <hr/>
		                <h5>创建时间：<s:property value="@com.library.util.DateUtils@formatDateTime(#bespeak.cdate)" /></h5>
		                <h5>取书时间：<s:property value="@com.library.util.DateUtils@formatDateTime(#bespeak.gdate)" /></h5>
		                <h6>
		                	状态：
								<s:if test="#bespeak.status == 1">
								等待取书
								</s:if>
								<s:elseif test="#bespeak.status == 0">
								预约完成
								</s:elseif>
		                </h6>
		            </td>
		            <td><br/></td>
		            <td><br/></td>
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
<s:if test="#request.pageBean.totalPage > 1">
<div class="col-xs-12">
    <div class="container">
        <nav style="text-align: center">
            <ul class="pagination pagination-lg">
            	<s:if test="1 == #request.pageBean.currentPage">
                	<li><a href="javascript:void(0)">&laquo;</a></li>
                </s:if>
                <s:else>
                	<li><a href="<%=path%>/bespeak_s_bespeak?currentPage=1">&laquo;</a></li>
                </s:else>
                
                <s:iterator value="#request.pageBean.pageList" var="page">
                	<s:if test="#page == #request.pageBean.currentPage">
                		<li class="active"><a href="javascript:void(0)" ><s:property value="#page"/></a></li>
                	</s:if>
                	<s:else>
                		<li><a href="<%=path%>/bespeak_s_bespeak?currentPage=<s:property value="#page"/>"><s:property value="#page"/></a></li>
                	</s:else>
                </s:iterator>
                
                <s:if test="#request.pageBean.totalPage == #request.pageBean.currentPage">
                	<li><a href="javascript:void(0)">&raquo;</a></li>
                </s:if>
                <s:else>
                	<li><a href="<%=path%>/bespeak_s_bespeak?currentPage=<s:property value="#request.pageBean.totalPage"/>">&raquo;</a></li>
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
<!--
    搜索页
-->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head lang="zh-hans">

    <title>搜索</title>
    <meta charset="UTF-8">
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

		.table tbody tr td{
			vertical-align: middle;
		}
	</style>
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
				<a class="navbar-brand" href="<%=path%>/search_s_search"  style="color:#a6e1ec"><span class="glyphicon glyphicon-search"></span> 搜索</a>
			</div>
		</div>
		<div class="col-xs-4">
			<div class="vertical-center">
 				<a class="navbar-brand" href="<%=path%>/user_s_home"><span class="glyphicon glyphicon-user"></span> 我的</a>
			</div>
		</div>
	</nav>
</div>
<div class="col-xs-12">
    <form class="bs-example bs-example-form" role="form" action="<%=path%>/search_s_search" method="post">
        <div class="row">
        	<div class="col-xs-1"></div>
            <div class="col-xs-10">
                <div class="input-group">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <s:property value="#request.tname"/>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" id="tname">
                        		<s:if test="#request.tname == '全部'">
                        			<li id="select"><a href="javascript:void(0)">全部</a></li>
                            	</s:if>
                            	<s:else>
                        			<li><a href="<%=path%>/search_s_search">全部</a></li>
                        		</s:else>
                        		<s:iterator value="#request.bookTypes" var="bookType">
                        			<s:if test="#request.tname == #bookType.tname">
	                            		<li id="select"><a href="javascript:void(0)"><s:property value="#bookType.tname"/></a></li>
                            		</s:if>
                            		<s:else>
                            			<li><a href="<%=path%>/search_s_search?tname=<s:property value="#bookType.tname"/>"><s:property value="#bookType.tname"/></a></li>
                            		</s:else>
                            	</s:iterator>
                        </ul>
                    </div>
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" id="tname">
                        	<s:iterator value="#request.searchs" var="search">
	                        	<li id="select"><a href="<%=path%>/search_s_search?search=<s:property value="#search.keywords"/>&tname=搜索"><s:property value="#search.keywords"/> </a></li>
                        	</s:iterator>
                        	<s:if test="#session.student != null">
                        		<li class="divider"></li>
								<li><a href="<%=path%>/search1_delete">清空搜索记录</a></li>
	                        </s:if>
	                        <s:else>
	                        	<li class="divider"></li>
	                        	<li><a href="javascript:void(0)">历史搜索记录</a></li>
	                        </s:else>
                        </ul>
                    </div>
                    
                    <input type="text" class="form-control" placeholder="书名，作者，ISBN" id="search" name="search"/>
                    
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default" id="search_submit"> 搜索</button>
                    </div>
                </div>
            </div>
            <div class="col-xs-1"></div>
        </div>
        <input type="hidden" value="搜索" name="tname"/>
    </form>
    <br/>
</div>
<h6 class="text-center" id="tab"><s:property value="#request.pageBean.totalCount" />条数据，共<s:property value="#request.pageBean.totalPage" />页</h6>
<div class="col-xs-12">
    <table class="table table-hover">
        <tbody>
        <s:iterator value="#request.pageBean.data" var="book">
	        <tr onclick="parent.location='<%=path%>/book_s_bookInfo?bid=<s:property value='#book.id' />'">
	            <td>
	                <br/>
	            </td>
	            <td>
	                <img src="<%=path%><s:property value="#request.bookImgPath" /><s:property value="#book.bookImg.iname" />.jpg" class="img-responsive center-block img-rounded" width="80"
	                     height="90"/>
	            </td>
	            <td>
	                <br/>
	            </td>
	            <td>
	                <br/>
	            </td>
	            <td class=".center-vertical">
	                <h4><s:property value="#book.bname" /></h4>
	                <h5><s:property value="#book.author" /></h5>
	                <h6>剩余：<s:property value="#book.remain" /></h6>
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
                	<li><a href="<%=path%>/search_s_search?currentPage=1&tname=<s:property value="#request.tname"/>">&laquo;</a></li>
                </s:else>
                
                <s:iterator value="#request.pageBean.pageList" var="page">
                	<s:if test="#page == #request.pageBean.currentPage">
                		<li class="active"><a href="javascript:void(0)" ><s:property value="#page"/></a></li>
                	</s:if>
                	<s:else>
                		<li><a href="<%=path%>/search_s_search?currentPage=<s:property value="#page"/>&tname=<s:property value="#request.tname"/>"><s:property value="#page"/></a></li>
                	</s:else>
                </s:iterator>
                
                <s:if test="#request.pageBean.totalPage == #request.pageBean.currentPage">
                	<li><a href="javascript:void(0)">&raquo;</a></li>
                </s:if>
                <s:else>
                	<li><a href="<%=path%>/search_s_search?currentPage=<s:property value="#request.pageBean.totalPage"/>&tname=<s:property value="#request.tname"/>">&raquo;</a></li>
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
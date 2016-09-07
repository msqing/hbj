<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pg" uri="/WEB-INF/page/template/pager-taglib.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta charset="UTF-8">
<title>体质监测</title>
<link rel="stylesheet" href="static/css/jquery-ui-1.9.2.redmond.min.css" type="text/css"></link>
<link rel="stylesheet" href="static/css/iconfont.css" type="text/css"></link>
<link rel="stylesheet" href="static/css/style_a.css" type="text/css"></link>
<script src="static/js/jquery-1.8.2.min.js" type="text/javascript"></script>
<script src="static/js/tohours.min.js" type="text/javascript"></script>
<script src="static/js/jquery-ui-1.9.2.redmond.min.js" type="text/javascript"></script>
<style type="text/css">
.its {
    background-color: #c5c5c5;
    text-align: center;
    border-top-width: 0px;
    border-right-width: 0px;
    border-bottom-width: 0px;
    border-left-width: 0px;
    border-spacing: 1px;
    margin-left: 60px;
    margin-right: 60px;
    width: 90%;
   }
.its th {
    font-size: 15px;
    background-color: #3994e8;
    height: 26px;
    color:#ffffff;
    vertical-align: middle;
}
.odd {
	 background-color: #ffffff;
	 height: 30px;
	 overflow: hidden;
	 white-space: nowarp;
	 text-overflow: ellipsis;
	}
</style>
</head>
<body style="text-align: center;width: 100%;margin: 0 auto;">
<div style="width: 100%;background: white;height: 100%;" align="center">
	<h1><font color="#0A4891" size="5px">长宁区市民体质监测报告列表</font></h1>
	<div class="page-header-1 xiahuaxian">
        <!--beginunit name=tyj_当前栏目 -->
          <h4 class="jcss"><span>查询结果</span></h4>
          <!--endunit --> 
        </div>
	<table class="its">
		<tr>
			<th>编号</th>
			<th>监测机构</th>
			<th>测试时间</th>
			<th>类型</th>
			<th>审核状态</th>
			<th>身份证号码</th>
			<th>姓名</th>
			<th>单位</th>
			<th>性别</th>
			<th>详情</th>
		</tr>
		<s:if test="page.getResult().size() > 0">
			<s:iterator value="page.getResult()">
				<tr class="odd">
					<td align="center"><s:property value="bh"/></td>
					<td align="center"><s:property value="jcjg"/></td>
					<td align="center"><s:date name="cssj" format="yyyy-MM-dd"/></td>
					<td align="center"><s:property value="lx"/></td>
					<td align="center"><s:property value="shzt"/></td>
					<td align="center"><s:property value="cardId"/></td>
					<td align="center"><s:property value="name"/></td>
					<td align="center"><s:property value="dw"/></td>
					<td align="center"><s:property value="sex"/></td>
					<td align="center"><a href="healthInfoDetail.do?id=<s:property value='id'/>" style="text-decoration: none;">查看</a></td>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr class="odd"><td colspan="10">暂无数据</td></tr>
		</s:else>
		<script type="text/javascript">
	   		window.colspan=10;
	   </script>
		<pg:pager items="${page.totalCount}" index="center" maxPageItems="${page.pageSize}" maxIndexPages="${10}" export="currentPage=pageNumber" scope="request">
		<pg:index> 
		    <jsp:include page="/tag/page_tag_front.jsp" flush="true" />
		</pg:index>
	</pg:pager>
	</table>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pg" uri="/WEB-INF/page/template/pager-taglib.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta charset="UTF-8">
<title>上海长宁区-环保局</title>
<link rel="stylesheet" type="text/css" href="static/css/ETUI.min.css">
<link rel="stylesheet" href="static/css/iconfont.css" type="text/css"></link>
<link rel="stylesheet" href="static/css/style_a.css" type="text/css"></link>
<script type="text/javascript" src="static/js/jquery-1.8.2.min.js"></script>
<style type="text/css">
.its {
    background-color: #c5c5c5;
    text-align: center;
    border-top-width: 0px;
    border-right-width: 0px;
    border-bottom-width: 0px;
    border-left-width: 0px;
    border-spacing: 0px;
    margin-left: 2px;
    margin-right: 2px;
    width: 100%;
   }
.its th {
    font-size: 15px;
    background-color: #3994e8;
    height: 60px;
    color:#ffffff;
    line-height:12pt;
    vertical-align: middle;
}
.odd {
	 background-color: #ddFFFF;
	 height: 40px;
	 line-height:12pt;
	 overflow: hidden;
	 white-space: nowarp;
	 text-overflow: ellipsis;
	}
</style>
</head>
<body style="text-align: center;width: 100%;margin: 0 auto;">
<div id="container">
  <div class="main liebiao" id="main">
    <div class="row-fluid">
      <div class="Article" id="example">
        <h4 class="juzhong">建设项目竣工环境保护验收审批决定公告的告知事项</h4>
        <hr class="fegexian">
        <h2><small class="PBtime"></small></h2>
        <div class="Article_content">
        <form action="saveExamineList.do" id="myForm">
		  <table class="its">
			<tr>
				<th>项目名称</th>
				<th>建设地点</th>
				<th>建设单位</th>
				<th width="8%">验收监测（调查）单位</th>
				<th>批文名称</th>
				<th>批文号码</th>
				<th>批文内容</th>
				<th>批文时间</th>
				<th>公示时间</th>
			</tr>
			<s:if test="page.getResult().size() > 0">
				<s:iterator value="page.getResult()" status="st">
					<tr class="odd">
						<td align="center" title="<s:property value="name" />">
							<s:if test="name.length() > 12">
	                            <s:property value="name.substring(0,9)" />...
	                        </s:if>
	                        <s:else>
	                            <s:property value="name" />
	                        </s:else>
						</td>
						<td align="center" title="<s:property value="address" />">
							<s:if test="address.length() > 12">
	                            <s:property value="address.substring(0,9)" />...
	                        </s:if>
	                        <s:else>
	                            <s:property value="address" />
	                        </s:else>
						</td>
						<td align="center" title="<s:property value='unit'/>">
							<s:if test="unit.length() > 10">
	                            <s:property value="unit.substring(0,7)" />...
	                        </s:if>
	                        <s:else>
	                            <s:property value="unit" />
	                        </s:else>
						</td>
						<td align="center" title="<s:property value="checkUnit"/>">
							<s:if test="checkUnit.length() > 10">
	                            <s:property value="checkUnit.substring(0,7)" />...
	                        </s:if>
	                        <s:else>
	                            <s:property value="checkUnit" />
	                        </s:else>
						</td>
						<td align="center" title="<s:property value="title"/>">
							<s:if test="title.length() > 10">
	                            <s:property value="title.substring(0,7)" />...
	                        </s:if>
	                        <s:else>
	                            <s:property value="title" />
	                        </s:else>
						</td>
						<td align="center"><s:property value="index"/></td>
						<td align="center">
							<s:if test="!timeOut">
								<a href="http://hbj.changning.sh.cn/ManagerBg/Filupld/<s:property value='content'/>" style="text-decoration: none;" target="_blank">点击查看</a>
							</s:if>
							<s:else><a href="#" style="text-decoration: none;">点击查看</a></s:else>
						</td>
						<td align="center"><s:date name="time" format="yyyy-MM-dd"/></td>
						<td align="center"><s:date name="startTime" format="yyyy-MM-dd"/>~<s:date name="endTime" format="yyyy-MM-dd"/></td>
					</tr>
				</s:iterator>
			</s:if>
			<s:else>
				<tr class="odd"><td colspan="9">暂无数据</td></tr>
			</s:else>
			<script type="text/javascript">
		   		window.colspan=9;
		   </script>
			<pg:pager items="${page.totalCount}" index="center" maxPageItems="${page.pageSize}" maxIndexPages="${10}" export="currentPage=pageNumber" scope="request">
			<pg:index> 
			    <jsp:include page="/tag/page_tag_front.jsp" flush="true" />
			</pg:index>
		</pg:pager>
		</table>
		</form>	
        </div>
      </div>
    </div>
  </div>
  </div>
</body>
</html>
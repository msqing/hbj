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
    line-height:12pt;
    color:#ffffff;
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
        <h4 class="juzhong">建设项目环境影响评价拟审批公示的告知事项</h4>
        <hr class="fegexian">
        <h2><small class="PBtime"></small></h2>
        <div class="Article_content">
        <form action="effectPreExamineList.do" id="myForm">
		  <table class="its">
			<tr>
				<th>项目名称</th>
				<th>建设地点</th>
				<th>建设单位</th>
				<th>环境影响评价机构</th>
				<th>公示时间</th>
				<th width="6%">建设项目概况</th>
				<th width="10%">主要环境影响及预防或者减轻不良环境影响的对策和措施</th>
				<th>公众参与情况</th>
				<th width="10%">建设单位或地方政府所作出的相关环境保护措施承诺文件</th>
				<th>拟审批决定</th>
				<th width="5%">拟不批准原因</th>
				<th>公众反馈意见</th>
			</tr>
			<s:if test="page.getResult().size() > 0">
				<s:iterator value="page.getResult()" status="st">
					<tr class="odd">
						<td align="center" title="<s:property value="name" />">
							<s:if test="name.length() > 13">
	                            <s:property value="name.substring(0,10)" />...
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
							<s:if test="unit.length() > 13">
	                            <s:property value="unit.substring(0,10)" />...
	                        </s:if>
	                        <s:else>
	                            <s:property value="unit" />
	                        </s:else>
						</td>
						<td align="center" title="<s:property value="org"/>">
							<s:if test="org.length() > 10">
	                            <s:property value="org.substring(0,7)" />...
	                        </s:if>
	                        <s:else>
	                            <s:property value="org" />
	                        </s:else>
						</td>
						<td align="center"><s:date name="startTime" format="yyyy-MM-dd"/>~<s:date name="endTime" format="yyyy-MM-dd"/></td>
						<td align="center" title="<s:property value="basicFacts"/>">
							<s:if test="basicFacts.length() > 10">
	                            <s:property value="basicFacts.substring(0,7)" />...
	                        </s:if>
	                        <s:else>
	                            <s:property value="basicFacts" />
	                        </s:else>
						</td>
						<td align="center" title="<s:property value="policyAttachment" />">
							<s:if test="!timeOut">
								<s:if test="policyAttachment != null && policyAttachment.length()>0">
	                            	<a href="http://hbj.changning.sh.cn/ManagerBg/Filupld/<s:property value='policyAttachment'/>" style="text-decoration: none;color: black;">点击查看</a>
								</s:if>
								<s:else>
	                            	<a href="#" style="text-decoration: none;color: black;">点击查看</a>
								</s:else>
							</s:if>
							<s:else>已过期</s:else>
						</td>
						<td align="center" title="<s:property value="participateInfo" />">
							<s:if test="!timeOut">
								<s:if test="participateFile != null && participateFile.length()>0">
		                            <a href="http://hbj.changning.sh.cn/ManagerBg/Filupld/<s:property value='participateFile'/>" style="text-decoration: none;color: black;">
		                            	<s:if test="participateInfo.length()>0">
		                            		<s:if test="participateInfo.length() > 10">
					                            <s:property value="participateInfo.substring(0,7)" />...
					                        </s:if>
					                        <s:else>
					                            <s:property value="participateInfo" />
					                        </s:else>
		                            	</s:if>
		                            	<s:else>点击查看</s:else>
		                            </a>
	                            </s:if>
	                            <s:else><a href="#" style="text-decoration: none;color: black;">点击查看</a></s:else>
							</s:if>
							<s:else>
								<s:if test="participateInfo.length() > 10">
		                            <s:property value="participateInfo.substring(0,7)" />...
		                        </s:if>
		                        <s:else>
		                            <s:property value="participateInfo" />
		                        </s:else>
							</s:else>
						</td>
						<td align="center" title="<s:property value="promiseAttachment" />">
							<s:if test="!timeOut">
								<s:if test="promiseAttachment != null && promiseAttachment.length()>0">
	                            	<a href="http://hbj.changning.sh.cn/ManagerBg/Filupld/<s:property value='promiseAttachment'/>" style="text-decoration: none;color: black;">点击查看</a>
								</s:if>
								<s:else><a href="#" style="text-decoration: none;color: black;">点击查看</a></s:else>
							</s:if>
							<s:else>已过期</s:else>
						</td>
						<td align="center"><s:property value="decision"/></td>
						<td align="center"><s:property value="reason"/></td>
						<td align="center">
							<s:if test="!timeOut">
								<a href="http://hbj.changning.sh.cn/otherDeaprtment.aspx" style="text-decoration: none;" target="_blank">点击留言</a>
							</s:if>
							<s:else><span style="color:red;">已过期</span></s:else>
						</td>
					</tr>
				</s:iterator>
			</s:if>
			<s:else>
				<tr class="odd"><td colspan="12">暂无数据</td></tr>
			</s:else>
			<script type="text/javascript">
		   		window.colspan=12;
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
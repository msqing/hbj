<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pg" uri="/WEB-INF/page/template/pager-taglib.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta charset="UTF-8">
<title>上海长宁区-审计局</title>
<link rel="stylesheet" type="text/css" href="static/css/ETUI.min.css">
<link rel="stylesheet" href="static/css/iconfont.css" type="text/css"></link>
<link rel="stylesheet" href="static/css/style_a.css" type="text/css"></link>
<style type="text/css">
.its {
    background-color: #c5c5c5;
    text-align: center;
    border-top-width: 20px;
    border-right-width: 0px;
    border-bottom-width: 0px;
    border-left-width: 0px;
    border-spacing: 0px;
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
	 background-color: #ddFFFF;
	 height: 40px;
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
        <h4 class="juzhong">污水处理厂废水自动监控情况</h4>
        <hr class="fegexian">
        <h2><small class="PBtime"></small></h2>
        <div class="Article_content">
        <form action="swageTable.do" id="myForm">
		  <table class="its">
			<tr>
				<th>企业名称</th>
				<th>排口名称</th>
				<th>监测因子</th>
				<th>监测日期</th>
				<th>监测值</th>
				<th>标准值</th>
			</tr>
			<s:if test="page.getResult().size() > 0">
				<s:iterator value="page.getResult()" status="st">
					<tr class="odd">
						<td align="center">
							<s:property value="name" />
						</td>
						<td align="center">
							<s:property value="portName" />
						</td>
						<td align="center">
							<s:property value="factorName" />
						</td>
						<td align="center"><s:date name="time" format="yyyy-MM-dd"/></td>
						<td align="center">
							<s:property value="factorValue" />
						</td>
						<td align="center">
							<s:property value="standard" />
						</td>
					</tr>
				</s:iterator>
			</s:if>
			<s:else>
				<tr class="odd"><td colspan="6">暂无数据</td></tr>
			</s:else>
			<script type="text/javascript">
		   		window.colspan=6;
		   </script>
		</table>
		</form>		
          <p class="text-left">
           	 注：①计量单位：毫克/平方米（PH值无量纲）；②实时公布数据未经审核，仅供参考。
          </p>
        </div>
      </div>
    </div>
  </div>
  </div>
</body>
</html>
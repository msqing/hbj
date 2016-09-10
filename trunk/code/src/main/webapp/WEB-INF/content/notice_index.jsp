<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta charset="UTF-8">
<title>环保局</title>
<script src="static/js/jquery-1.7.1.min.js" type="text/javascript"></script>
<style type="text/css">
.subsearch{height:34px;margin:0px auto;width:500px;margin-top:200px}
.subsearch input{
	width:400px;
	height:34px !important;
	line-height:34px;
	padding:0px;
	font-size:10px;
	text-indent: 1em;
	border:1px solid #003299;
	float: left;
	}
.subsearch a{
	display:block; 
	height:34px;
	float:left;
	color: #00f;
	text-align: center;
	line-height: 34px; 
	_width:39px;
	_height:32px;
	_line-height:32px;
	margin-left:5px;
	text-decoration: none;
	}
.subsearch a i { 
	font-size: 25px;
}
</style>
</head>
<body>
	<div class="subsearch">
		<a href="effectInfo.do" target="_blank">【1】建设项目环境影响评价受理信息公示</a>
		<a href="effectPreExamine.do" target="_blank">【2】建设项目环境影响评价拟审批公示</a>
		<a href="effectExamine.do" target="_blank">【3】建设项目环境影响审批公告</a>
		<a href="saveInfo.do" target="_blank">【4】建设项目竣工环境保护验收信息公示</a>
		<a href="savePreExamine.do" target="_blank">【5】建设项目竣工环境保护验收拟审批公示</a>
		<a href="saveExamine.do" target="_blank">【6】建设项目竣工环境保护验收审批公告</a>
		<a href="swageTable.do" target="_blank">【7】污水处理厂废水自动监控情况</a>
	</div>
</body>
</html>
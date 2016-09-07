<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta charset="UTF-8">
<title>体质监测查询入口</title>
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
	background:#0066CC;
	display:block; 
	width:10%; 
	height:34px;
	float:left;
	color: #fff;
	text-align: center;
	line-height: 34px; 
	_width:39px;
	_height:32px;
	_line-height:32px;
	margin-left:5px;
	}
.subsearch a i { 
	font-size: 25px;
}
</style>
<script type="text/javascript">
	function search(){
		var sear = $('#content').val();
		if(!sear){
			alert('请填写身份证号进行查询！');
			return;
		}
		location.href = "searchResultList.do?sear="+sear;
	}
</script>
</head>
<body>
	<div class="subsearch">
	  <input type="text" id="content" placeholder="请输入您的身份证号进行查询"><a href="javascript:search();" title="搜索" style="text-decoration:none;"><i><img src="static/images/sousuo.png"/></i></a>
	</div>
</body>
</html>
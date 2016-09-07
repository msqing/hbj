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
    font-size: 16px;
    background-color: #3994e8;
    height: 40px;
    color:#ffffff;
    vertical-align: middle;
    padding-left:10px;
    text-align: left;
}
.odd {
	 background-color: #ffffff;
	 height: 30px;
	 overflow: hidden;
	 white-space: nowarp;
	 text-overflow: ellipsis;
	}
.info {
	color: red;
	}
</style>
</head>
<body style="text-align: center;width: 100%;margin: 0 auto;">
<div style="width: 100%;background: white;height: 100%;" align="center">
	<h1><font color="#0A4891" size="5px">长宁区市民体质监测报告数据详情</font></h1>
	<div class="page-header-1 xiahuaxian">
        <!--beginunit name=tyj_当前栏目 -->
          <h4 class="jcss"><span>结果详情查看</span></h4>
          <!--endunit --> 
        </div>
	<table class="its">
		<tr>
			<th colspan="8">健康查询详细信息【<font color="red"><s:property value="info.name"/></font>】</th>
		</tr>
		<tr class="odd">
			<td align="center">监测机构：</td>
			<td align="center" class="info"><s:property value="info.jcjg"/></td>
			<td align="center">测试时间：</td>
			<td align="center" class="info"><s:date name="info.cssj" format="yyyy-MM-dd"/></td>
			<td align="center">类型：</td>
			<td align="center" class="info"><s:property value="info.lx"/></td>
			<td align="center">审核状态：</td>
			<td align="center" class="info"><s:property value="info.shzt"/></td>
		</tr>
		<tr class="odd">
			<td align="center">身份证号：</td>
			<td align="center" class="info"><s:property value="info.cardId"/></td>
			<td align="center">姓名：</td>
			<td align="center" class="info"><s:property value="info.name"/></td>
			<td align="center">单位：</td>
			<td align="center" class="info"><s:property value="info.dw"/></td>
			<td align="center">性别：</td>
			<td align="center" class="info"><s:property value="info.sex"/></td>
		</tr>
		<tr class="odd">
			<td align="center">年龄：</td>
			<td align="center" class="info"><s:property value="info.nl"/></td>
			<td align="center">职业：</td>
			<td align="center" class="info"><s:property value="info.zy"/></td>
			<td align="center">身高：</td>
			<td align="center" class="info"><s:property value="info.sg"/></td>
			<td align="center">体重：</td>
			<td align="center" class="info"><s:property value="info.tz"/></td>
		</tr>
		<tr class="odd">
			<td align="center">BMI：</td>
			<td align="center" class="info"><s:property value="info.bmi"/></td>
			<td align="center">肺活量：</td>
			<td align="center" class="info"><s:property value="info.fhl"/></td>
			<td align="center">握力：</td>
			<td align="center" class="info"><s:property value="info.wl"/></td>
			<td align="center">坐位体前屈：</td>
			<td align="center" class="info"><s:property value="info.zlqq"/></td>
		</tr>
		<tr class="odd">
			<td align="center">反应时：</td>
			<td align="center" class="info"><s:property value="info.fys"/></td>
			<td align="center">闭眼单腿站立：</td>
			<td align="center" class="info"><s:property value="info.bydz"/></td>
			<td align="center">纵跳：</td>
			<td align="center" class="info"><s:property value="info.ct"/></td>
			<td align="center">俯卧撑：</td>
			<td align="center" class="info"><s:property value="info.fwc"/></td>
		</tr>
		<tr class="odd">
			<td align="center">仰卧起坐：</td>
			<td align="center" class="info"><s:property value="info.ywqz"/></td>
			<td align="center">台阶指数：</td>
			<td align="center" class="info"><s:property value="info.tjzs"/></td>
			<td align="center">舒张压：</td>
			<td align="center" class="info"><s:property value="info.szy"/></td>
			<td align="center">收缩压：</td>
			<td align="center" class="info"><s:property value="info.ssy"/></td>
		</tr>
		<tr class="odd">
			<td align="center">脉搏：</td>
			<td align="center" class="info"><s:property value="info.mb"/></td>
			<td align="center">50*8米：</td>
			<td align="center" class="info"><s:property value="info.wcb"/></td>
			<td align="center">800米：</td>
			<td align="center" class="info"><s:property value="info.bbm"/></td>
			<td align="center">1000米：</td>
			<td align="center" class="info"><s:property value="info.yqm"/></td>
		</tr>
		<tr class="odd">
			<td align="center">10米折返跑：</td>
			<td align="center" class="info"><s:property value="info.smzp"/></td>
			<td align="center">50米：</td>
			<td align="center" class="info"><s:property value="info.wsm"/></td>
			<td align="center">斜身、引体向上：</td>
			<td align="center" class="info"><s:property value="info.xs"/></td>
			<td align="center">网球：</td>
			<td align="center" class="info"><s:property value="info.wq"/></td>
		</tr>
		<tr class="odd">
			<td align="center">平衡木：</td>
			<td align="center" class="info"><s:property value="info.phm"/></td>
			<td align="center">双脚跳：</td>
			<td align="center" class="info"><s:property value="info.hjt"/></td>
			<td align="center">立定跳远：</td>
			<td align="center" class="info"><s:property value="info.ldty"/></td>
			<td align="center">往返跑：</td>
			<td align="center" class="info"><s:property value="info.wfp"/></td>
		</tr>
		<tr class="odd">
			<td align="center">平衡木：</td>
			<td align="center" class="info"><s:property value="info.phm"/></td>
			<td align="center">双脚跳：</td>
			<td align="center" class="info"><s:property value="info.hjt"/></td>
			<td align="center">立定跳远：</td>
			<td align="center" class="info"><s:property value="info.ldty"/></td>
			<td align="center">往返跑：</td>
			<td align="center" class="info"><s:property value="info.wfp"/></td>
		</tr>
		<tr class="odd">
			<td align="center">背力：</td>
			<td align="center" class="info"><s:property value="info.bl"/></td>
			<td align="center">人体水分：</td>
			<td align="center" class="info"><s:property value="info.rtsf"/></td>
			<td align="center">蛋白质：</td>
			<td align="center" class="info"><s:property value="info.dbz"/></td>
			<td align="center">矿物质：</td>
			<td align="center" class="info"><s:property value="info.kwz"/></td>
		</tr>
		<tr class="odd">
			<td align="center">脂肪：</td>
			<td align="center" class="info"><s:property value="info.zf"/></td>
			<td align="center">骨骼肌：</td>
			<td align="center" class="info"><s:property value="info.glj"/></td>
			<td align="center">腰臀比：</td>
			<td align="center" class="info"><s:property value="info.ybb"/></td>
			<td align="center">基础代谢率：</td>
			<td align="center" class="info"><s:property value="info.jcdx"/></td>
		</tr>
		<tr class="odd">
			<td align="center">SOS：</td>
			<td align="center" class="info"><s:property value="info.sos"/></td>
			<td align="center">BUA：</td>
			<td align="center" class="info"><s:property value="info.bua"/></td>
			<td align="center">BQI：</td>
			<td align="center" class="info"><s:property value="info.bqi"/></td>
			<td align="center">T-Score：</td>
			<td align="center" class="info"><s:property value="info.tscore"/></td>
		</tr>
		<tr class="odd">
			<td align="center">Z-Score：</td>
			<td align="center" class="info"><s:property value="info.zscore"/></td>
			<td align="center">T-Ratio：</td>
			<td align="center" class="info"><s:property value="info.tration"/></td>
			<td align="center">Z-Ratio：</td>
			<td align="center" class="info"><s:property value="info.zration"/></td>
			<td align="center">胸围：</td>
			<td align="center" class="info"><s:property value="info.xw"/></td>
		</tr>
		<tr class="odd">
			<td align="center">腰围：</td>
			<td align="center" class="info"><s:property value="info.yw"/></td>
			<td align="center">臀围：</td>
			<td align="center" class="info"><s:property value="info.pw"/></td>
			<td align="center">腰臀比指数：</td>
			<td align="center" class="info"><s:property value="info.ybbzs"/></td>
			<td align="center">体脂率：</td>
			<td align="center" class="info"><s:property value="info.tzl"/></td>
		</tr>
		<tr class="odd">
			<td align="center">上臂部皮褶厚度：</td>
			<td align="center" class="info"><s:property value="info.spbtz"/></td>
			<td align="center">肩胛部皮褶厚度：</td>
			<td align="center" class="info"><s:property value="info.jjbpz"/></td>
			<td align="center">腹部皮褶厚度：</td>
			<td align="center" class="info"><s:property value="info.fbpzhd"/></td>
			<td align="center">身高标准体重评分：</td>
			<td align="center" class="info"><s:property value="info.sgbzt"/></td>
		</tr>
		<tr class="odd">
			<td align="center">肺活量评分：</td>
			<td align="center" class="info"><s:property value="info.fhlpf"/></td>
			<td align="center">台阶指数评分：</td>
			<td align="center" class="info"><s:property value="info.tjzspf"/></td>
			<td align="center">纵跳评分：</td>
			<td align="center" class="info"><s:property value="info.ctpf"/></td>
			<td align="center">握力评分：</td>
			<td align="center" class="info"><s:property value="info.wlpf"/></td>
		</tr>
		<tr class="odd">
			<td align="center">坐位体前屈评分：</td>
			<td align="center" class="info"><s:property value="info.zwtqpf"/></td>
			<td align="center">闭眼单腿站立评分：</td>
			<td align="center" class="info"><s:property value="info.bydtzpf"/></td>
			<td align="center">选择反应时评分：</td>
			<td align="center" class="info"><s:property value="info.xzfyspf"/></td>
			<td align="center">俯卧撑(男)评分：</td>
			<td align="center" class="info"><s:property value="info.fwcpf"/></td>
		</tr>
		<tr class="odd">
			<td align="center">1分钟仰卧起坐(女)评分：</td>
			<td align="center" class="info"><s:property value="info.yfzyw"/></td>
			<td align="center">人体形态评分：</td>
			<td align="center" class="info"><s:property value="info.rtxt"/></td>
			<td align="center">人体机能评分：</td>
			<td align="center" class="info"><s:property value="info.rtjn"/></td>
			<td align="center">人体素质评分：</td>
			<td align="center" class="info"><s:property value="info.rtsz"/></td>
		</tr>
		<tr class="odd">
			<td align="center">综合总分：</td>
			<td align="center" class="info"><s:property value="info.zhzf"/></td>
			<td align="center">综合评价：</td>
			<td align="center" class="info"><s:property value="info.zhpj"/></td>
			<td align="center">编号：</td>
			<td align="center" class="info"><s:property value="info.bh"/></td>
			<td align="center" colspan="2"></td>
		</tr>
	</table>
	<div style="margin-top: 30px;">&nbsp;</div>
</div>
</body>
</html>
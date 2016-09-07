<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pg" uri="/WEB-INF/page/template/pager-taglib.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="author" content="tohours.com" />
<link rel="stylesheet" href="../static/css/main.css" type="text/css"></link>
<link rel="stylesheet" href="../static/css/jquery-ui-1.9.2.redmond.min.css" type="text/css"></link>
<title>内容管理</title>
<script src="../static/js/jquery-1.8.2.min.js" type="text/javascript"></script>
<script src="../static/js/jquery-ui-1.9.2.redmond.min.js" type="text/javascript"></script>
<script src="../static/js/tohours.min.js" type="text/javascript"></script>
<script src="../static/js/checkbox.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$('#btnAdd').click(function(){
			location.href = "articleAddPre.do";
		});
		tohours.storage.set('article_list', location.href);
			
	});
</script>
</head>
<body >
<form method="get" action="articleList.do" id="myForm">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="tableAll" style="display: none;" >
  <tr>
    <td><table border="0" align="left" cellpadding="0" cellspacing="0" class="table"  >
  <tr >
    <td><img src="../static/images/n_01.jpg"></img></td>
    <td class="navigation_middle" > 您现在的位置：内容管理 > 内容列表 </td>
    <td><img src="../static/images/n_03.jpg"></img></td>
  </tr>
</table></td>
  </tr>
  <tr>
    <td><table border="0" align="left" cellpadding="0" cellspacing="0" class="table" style="padding-bottom: 5px;padding-top: 5px"  >
  <tr>
    <td>
    	标题：<s:textfield name="nameSearch" cssStyle="width:80px;" />&nbsp;
    </td>
    <td align="right">
      <input type="submit" id="btnSearch" value=" 查 询 " class="shortbutton" onMouseOver="this.className='shortbutton_mouseover'" onMouseOut="this.className='shortbutton'" />
      <input type="button"  value=" 新 增 " id="btnAdd" class="shortbutton" onMouseOver="this.className='shortbutton_mouseover'" onMouseOut="this.className='shortbutton'" />
      <input type="button" value=" 删 除 " onclick="batchDelete('articleDelete.do')" class="shortbutton" onMouseOver="this.className='shortbutton_mouseover'" onMouseOut="this.className='shortbutton'" /></td>
  </tr>
</table></td>
  </tr>
  <tr>
    <td><table border="0" align="left" cellspacing="1" class="its" id="ufile" >
  <tr>
    <th><input type="checkbox" class="chk_all"/></th>
    <th>序号</th>
    <th>标题</th>
    <th>作者</th>
    <th>模块</th>
    <th>时间</th>
    <th>操作</th>
  </tr>
  <s:if test="page.getResult().size() > 0" >
	<s:iterator value="page.getResult()" status="st">
		<tr class="odd" >
			<td><input name="check2" type="checkbox" value="<s:property value="id" />" class="chk_single"/></td>
			<td align="left" style="padding-left:10px; text-align:center;"><s:property value="#st.count + pager.offset" /></td>
			<td><s:property value="tittle" /></td>
			<td width="10%"><s:property value="author" /></td>
			<td width="10%">
				<s:if test="type == 0">勤务动态</s:if>
				<s:elseif test="type == 1">队伍建设</s:elseif>
				<s:elseif test="type == 2">党建工作</s:elseif>
				<s:elseif test="type == 3">警务实战</s:elseif>
				<s:else>通知</s:else>
			</td>
			<td width="10%"><s:date name="insertTime" format="yyyy-MM-dd HH:mm:ss"/></td>
			<td><a href="articleEditPre.do?article.id=<s:property value="id" />">修改</a> 
	    	    <a href="javascript:singleDelete('articleDelete.do', '<s:property value="id" />');">删除</a>
			</td>
		</tr>
  	</s:iterator>
  </s:if>
  
  <s:else>
  	<tr class="odd">
  		<td colspan="17" style="text-align:center; color:gray;">没有可显示的结果</td>
  	</tr>
  </s:else>
   <script type="text/javascript">
   		window.colspan=17;
   		window.onload=function(){
   			$('#tableAll').show();
   		}
   </script>
	<pg:pager items="${page.totalCount}" index="center" maxPageItems="${page.pageSize}" maxIndexPages="${10}" url="partyMemberList.do" export="currentPage=pageNumber" scope="request">
		<pg:index> 
		    <jsp:include page="/tag/page_tag.jsp" flush="true" />
		</pg:index>
	</pg:pager>		
</table>

</td>
  </tr>
</table>
</form>
</body>
</html>


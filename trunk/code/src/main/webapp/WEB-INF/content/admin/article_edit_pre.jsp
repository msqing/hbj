<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="author" content="tohours.com" />
<link rel="stylesheet" href="../static/css/main.css" type="text/css"></link>
<link rel="stylesheet" href="../static/css/jquery-ui-1.9.2.redmond.min.css" type="text/css"></link>
<script src="../static/js/jquery-1.8.2.min.js" type="text/javascript"></script>
<script src="../static/js/jquery-ui-1.9.2.redmond.min.js" type="text/javascript"></script>
<script src="../static/js/tohours.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="../static/js/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="../static/js/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="../static/js/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript">
var editor;
	KindEditor.ready(function(K) {
				editor = K.create('textarea[name="article.content"]', {
					uploadJson : '../static/js/kindeditor/jsp/upload_json.jsp',
	                fileManagerJson : '../static/js/kindeditor/jsp/file_manager_json.jsp',
	                allowFileManager : true
			});
	  });
</script>
<script type="text/javascript">
function check(){
	var name=$('#article_tittle');
	if(!name.val()){
		alert('请输入内容标题！');
		name.focus();
		return false;
	}
	var name=$('#article_author');
	if(!name.val()){
		alert('请输入作者名称！');
		name.focus();
		return false;
	}
	return true;
}
</script>
<title>内容添加</title>
</head>
<body>
<form action="articleEdit.do" method="post" onsubmit="return check()">
<s:hidden name="article.id"/>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table border="0" align="left" cellpadding="0" cellspacing="0" class="table"  >
  <tr >
    <td><img src="../static/images/n_01.jpg"></img></td>
    <td class="navigation_middle" > 您现在的位置： 内容管理 &gt; 内容编辑</td>
    <td><img src="../static/images/n_03.jpg"></img></td>
  </tr>
</table></td>
  </tr>
  <tr>
    <td><table border="0" align="left" cellpadding="0" cellspacing="0" class="table" style="padding-bottom: 5px;padding-top: 5px" >
  <tr>
    <td>&nbsp;</td>
    <td align="right">&nbsp;</td>
  </tr>
</table></td>
  </tr>
  <tr>
    <td><table border="0" align="left" cellspacing="1" class="its" id="ufile">
  <tr class="odd" >
    <td width="150">标题：</td>
    <td align="center" style="padding-left:10px; text-align:left;"><s:textfield name="article.tittle" cssStyle="width:80%;" /></td>
  </tr>
  <tr class="odd" >
    <td width="150">作者：</td>
    <td align="center" style="padding-left:10px; text-align:left;"><s:textfield name="article.author" cssStyle="width:80%;" /></td>
  </tr>
  <tr class="odd" >
    <td width="150">模块：</td>
    <td align="center" style="padding-left:10px; text-align:left;"><s:select name="article.type" list="#{'0':'勤务动态','1':'队伍建设','2':'党建工作','3':'警务实战','4':'通知' }" cssStyle="width:80%;"/></td>
  </tr>
  <tr class="odd" >
    <td width="150">内容：</td>
    <td align="center" style="padding-left:10px; text-align:left;"><s:textarea name="article.content" rows="20" visibility="hidden" cssStyle="width:80%" /></td>
  </tr>
   
  <tr class="odd" >
    <td colspan="2" align="center"><input type="submit" value="确认修改" class="shortbutton" onMouseOver="this.className='shortbutton_mouseover'" onMouseOut="this.className='shortbutton'"/></td>
  </tr>
  </table></td>
  </tr>
  <tr><td height="20">&nbsp;</td></tr>
</table>
</form>
</body>
</html>

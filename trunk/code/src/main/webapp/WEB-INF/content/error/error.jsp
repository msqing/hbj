<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>体质监测查询</title>
<link href="<s:url value="/static/css/css.css"/>" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40" valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td align="center">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="300" valign="top"><table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><table width="100%" border="0" cellspacing="1" cellpadding="10" bgcolor="#CCCCCC">
          <tr>
            <td height="200" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="5" cellpadding="0">
              <tr>
                <td width="220" align="center" valign="top"><img src="<s:url value="/static/images/IconTexto_WebDev_017.png"/>" width="128" height="128" /></td>
                <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                            <td class="font" height="40" align="left"><strong>提示：<s:property value="#attr.tips"/><s:fielderror></s:fielderror><s:actionerror></s:actionerror><s:actionmessage></s:actionmessage></strong></td>
                 </tr>
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td><table border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="35">谢谢您的支持，请继续您的操作！</td>
                      </tr>
                      <tr>
                        <td height="35"></td>
                      </tr>
                      <tr>
                        <td height="50"><a href="<s:if test="#attr.url!=null"><s:property value="#attr.url"/></s:if><s:else>javascript:history.back();</s:else>"><img src="<s:url value="/static/images/icon_fh.jpg"/>" width="78" height="25" border="0" /></a></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><img src="<s:url value="/static/images/login_bg_tips.jpg"/>" height="28" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
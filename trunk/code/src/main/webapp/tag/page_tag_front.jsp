<%@ page language="java" import="javax.servlet.*,org.springside.modules.orm.Page" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pg" uri="/WEB-INF/page/template/pager-taglib.tld"%>
  <tr class="odd" >
    <td id="footer">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="64%" align="left">
			<pg:first export="pageUrl">
	          	<IMG src="static/images/page_top.gif" />
	          	<a href="javascript:go(1);" style="color: #585956; text-decoration: none">第一页</a> 
			</pg:first>
			<pg:prev export="pageUrl">
	          	<IMG src="static/images/page_prev.gif" />
	          	<a href="javascript:go(<s:property value="page.getPrePage()" />);" style="color: #585956; text-decoration: none">上一页</a>
	        </pg:prev>
          	&nbsp;当前第<s:property value="page.getPageNo()" />页，共<s:property value="page.getTotalPages()" />页 &nbsp;
			<pg:next export="pageUrl">
	          	<a href="javascript:go(<s:property value="page.getNextPage()" />);"  style="color: #585956; text-decoration: none">下一页</a>
	          	<IMG src="static/images/page_next.gif" /> 
	         </pg:next>
			<pg:last export="pageUrl">
	          	<a href="javascript:go(<s:property value="page.getTotalPages()" />);"  style="color: #585956; text-decoration: none">最后一页</a>
	          	<IMG src="static/images/page_end.gif" />
	        </pg:last>
          </td>     	
          <td width="40%">
          	<s:hidden name="pager.offset" />
          	<script>
          		function go(page_num){
          			if(!page_num){
          				return; 
          			}
          			$('#pager_offset').val((parseInt(page_num) - 1) * <s:property value="pager.pageSize" />);
          			$('#myForm').submit();
          		}
          		
          		$(function(){
          			$('#footer').attr('colspan', window.colspan);
          		});
          	</script>
          </td>
        </tr>
      </table>
	</td>
  </tr>
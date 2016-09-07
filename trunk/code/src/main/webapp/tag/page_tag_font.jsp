<%@ page language="java" import="javax.servlet.*,org.springside.modules.orm.Page" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pg" uri="/WEB-INF/page/template/pager-taglib.tld"%>
<!-- 分页开始 -->
<div id="result_page_c">
	<p class="page">
		<pg:first export="pageUrl">
		<span>
			<a href="javascript:search(1)">首页</a>
		</span>
		</pg:first>
		<pg:prev export="pageUrl">
		<span>
			<a href="javascript:search(<s:property value="page.getPrePage()" />)">上一页&gt;</a>
		</span>
		</pg:prev>
		<pg:next export="pageUrl">
		<span>
			<a href="javascript:search(<s:property value="page.getNextPage()" />)">下一页&gt;</a>
		</span>
		</pg:next>
		<pg:last export="pageUrl">
		<span>
			<a href="javascript:search(<s:property value="page.getTotalPages()" />)">末页</a>
		</span>
		</pg:last>
	</p>
</div>
<!-- 分页结束 -->
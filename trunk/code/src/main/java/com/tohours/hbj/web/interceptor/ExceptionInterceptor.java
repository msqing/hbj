package com.tohours.hbj.web.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tohours.hbj.exception.LoginException;
import com.tohours.hbj.exception.ProjectException;

public class ExceptionInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(ExceptionInterceptor.class);

	@Override
	public String intercept(ActionInvocation invocation) {
		String rv = null;
		try {
			rv = invocation.invoke();
		} catch(LoginException le){
			try {
				HttpServletResponse response = ServletActionContext.getResponse();
				PrintWriter writer = ServletActionContext.getResponse().getWriter();
				HttpServletRequest request = ServletActionContext.getRequest();
				String contextPath = request.getContextPath();
				if ("/".equals(contextPath)) {
					contextPath = "";
				}
				StringBuffer sb = new StringBuffer("<script type='text/javascript'>");
				sb.append("location.href = '%s/loginPre.do';");
				sb.append("</script>");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html");
				response.setDateHeader("Expires", 0);
				writer.print(String.format(sb.toString(), contextPath));
			} catch (IOException e) {
				rv = logError(invocation, e);
			}
		}
		catch(ProjectException pe) {
			invocation.getInvocationContext().getContextMap().put("tips", pe.getMessage());
			rv =  "error";
		}
		catch(Exception e) {
			rv = logError(invocation, e);
		}
		return rv;
	}

	private String logError(ActionInvocation invocation, Exception e) {
		invocation.getInvocationContext().getContextMap().put("tips", "系统错误，请联系管理员解决");
		StringWriter sw = new StringWriter();  
		e.printStackTrace(new PrintWriter(sw, true));
		log.error(sw.toString());
		return "error";
	}
}

package com.tohours.hbj.web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tohours.hbj.constants.TohoursUtils;
import com.tohours.hbj.service.LogService;

public class LogInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private LogService logService;
	Logger log = Logger.getLogger(LogInterceptor.class);

	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String remoteAddr = request.getRemoteAddr();
		String realIp = request.getHeader("X-Real-IP");
		if(StringUtils.isNotEmpty(realIp)){
			remoteAddr = realIp;
		}
		JSONObject more = TohoursUtils.requestToJSON(request);
		JSONObject ua = TohoursUtils.userAgentFromString(request.getHeader("User-Agent"));

		Map<String, Object> session = invocation.getInvocationContext().getSession();
		String user = "anonymous";
		if (null != session.get("username")) {
			 user = (String) session.get("username");
		}
		logService.log(user, ua.getString("browser"), ua.getString("os"), remoteAddr, request.getServletPath(), more.toString());
		return invocation.invoke();
	}
}

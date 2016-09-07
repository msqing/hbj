package com.tohours.hbj.web.interceptor;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tohours.hbj.constants.Constants;
import com.tohours.hbj.exception.LoginException;

public class AdminInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(AdminInterceptor.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = null;
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		if (null == session.get(Constants.SESSION_USER_NAME)) {
			String actionName = invocation.getInvocationContext().getName();
			if (actionName.indexOf("login") >= 0 || actionName.indexOf("logout") >= 0 || actionName.indexOf("updateUserAgent") >= 0) {
				result = invocation.invoke();
			} else {
				throw new LoginException();
			}
		} else {
			result = invocation.invoke();
		}
		return result;
	}

}

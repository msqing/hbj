package com.tohours.hbj.exception;

public class LoginException extends ProjectException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginException() {
		super("您尚未登录");
	}
}

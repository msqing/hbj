package com.tohours.hbj.service.impl;

import java.util.Date;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tohours.hbj.dao.LogDao;
import com.tohours.hbj.entity.Log;
import com.tohours.hbj.service.LogService;

@Service
@Transactional
public @Data class LogServiceImpl implements LogService{
	
	@Autowired
	private LogDao logDao;
	
	@Override
	public void log(String user, String browser, String os, String remoteAddr, String servletPath, String more) {
		Log log = new Log();
		log.setUser(user);
		log.setBrowser(browser);
		log.setOs(os);
		log.setRemoteAddr(remoteAddr);
		log.setServletPath(servletPath);
		log.setMore(more);
		Date now = new Date();
		log.setApplicationTime(now);
		log.setInsertTime(now);
		this.logDao.save(log);
	}
	

}

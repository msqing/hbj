package com.tohours.hbj.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.tohours.hbj.dao.LogDao;
import com.tohours.hbj.entity.Log;

@Repository
public class LogDaoImpl extends AbstractDaoImpl<Log, Long> implements LogDao{

}

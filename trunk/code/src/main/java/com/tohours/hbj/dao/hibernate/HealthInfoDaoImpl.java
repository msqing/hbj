package com.tohours.hbj.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.tohours.hbj.dao.HealthInfoDao;
import com.tohours.hbj.entity.HealthInfo;

@Repository
public class HealthInfoDaoImpl extends AbstractDaoImpl<HealthInfo, Long> implements HealthInfoDao{

}

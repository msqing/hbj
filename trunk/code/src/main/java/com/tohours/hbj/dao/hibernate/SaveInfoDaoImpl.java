package com.tohours.hbj.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.tohours.hbj.dao.SaveInfoDao;
import com.tohours.hbj.entity.SaveInfo;

@Repository
public class SaveInfoDaoImpl extends AbstractDaoImpl<SaveInfo, Long> implements SaveInfoDao{

}

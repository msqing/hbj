package com.tohours.hbj.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.tohours.hbj.dao.UserDao;
import com.tohours.hbj.entity.User;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User, String> implements UserDao{

}

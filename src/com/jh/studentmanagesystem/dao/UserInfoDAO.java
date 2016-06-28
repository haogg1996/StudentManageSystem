package com.jh.studentmanagesystem.dao;

import com.jh.studentmanagesystem.bean.UserInfo;

public class UserInfoDAO extends BaseDAO<UserInfo>
{
  public String setClassName()
  {
    return UserInfo.class.getName();
  }
}
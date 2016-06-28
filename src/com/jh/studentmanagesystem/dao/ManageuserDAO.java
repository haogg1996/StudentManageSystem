package com.jh.studentmanagesystem.dao;

import com.jh.studentmanagesystem.bean.Manageuser;

public class ManageuserDAO extends BaseDAO<Manageuser>
{
  public String setClassName()
  {
    return Manageuser.class.getName();
  }
}
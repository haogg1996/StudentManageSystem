package com.jh.studentmanagesystem.test;

import com.jh.studentmanagesystem.bean.Manageuser;
import com.jh.studentmanagesystem.bean.UserInfo;
import com.jh.studentmanagesystem.dao.BaseDAO;
import com.jh.studentmanagesystem.dao.CscourseDAO;
import com.jh.studentmanagesystem.dao.ManageuserDAO;
import com.jh.studentmanagesystem.dao.UserInfoDAO;

import java.io.PrintStream;

import org.junit.Before;

public class Test
{
  BaseDAO<UserInfo> dao;
  

  @Before
  public void before()
  {
    this.dao = new BaseDAO<UserInfo>() {

		@Override
		public String setClassName() {
			// TODO Auto-generated method stub
			return UserInfo.class.getName();
		}
	};
  }

  @org.junit.Test
  public void test()
  {
//    UserInfo user = dao.selectBeanByid(1);
//    user.setName("jh");
//    dao.updataBean(user);
    System.out.println(dao.selectBeanByid(1));
  }
}
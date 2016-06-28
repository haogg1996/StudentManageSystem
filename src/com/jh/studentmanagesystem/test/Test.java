package com.jh.studentmanagesystem.test;

import com.jh.studentmanagesystem.bean.Manageuser;
import com.jh.studentmanagesystem.bean.UserInfo;
import com.jh.studentmanagesystem.dao.CscourseDAO;
import com.jh.studentmanagesystem.dao.ManageuserDAO;
import com.jh.studentmanagesystem.dao.UserInfoDAO;

import java.io.PrintStream;

import org.junit.Before;

public class Test
{
  ManageuserDAO dao;
  

  @Before
  public void before()
  {
    this.dao = new ManageuserDAO();
  }

  @org.junit.Test
  public void test()
  {
    System.out.println(this.dao.selectByManager(new Manageuser("xyh","111")));
//	  System.out.println(dao.selectBeanByid(1));
  }
}
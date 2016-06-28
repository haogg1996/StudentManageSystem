package com.jh.studentmanagesystem.test;

import com.jh.studentmanagesystem.dao.CscourseDAO;
import java.io.PrintStream;
import org.junit.Before;

public class Test
{
  CscourseDAO dao;

  @Before
  public void before()
  {
    this.dao = new CscourseDAO();
  }

  @org.junit.Test
  public void test()
  {
    System.out.println(this.dao.selectCoursesByUserId(1));
  }
}
package com.jh.studentmanagesystem.dao;

import com.jh.studentmanagesystem.bean.Course;

public class CourseDAO extends BaseDAO<Course>
{
  public String setClassName()
  {
    return Course.class.getName();
  }
}
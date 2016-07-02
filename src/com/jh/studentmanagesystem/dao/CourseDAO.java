package com.jh.studentmanagesystem.dao;

import com.jh.studentmanagesystem.bean.Course;

public class CourseDAO extends BaseDAO<Course>
{
  public String setClassName()
  {
    return Course.class.getName();
  }
  
  public void deletCourse(int id) {
	CscourseDAO dao=new CscourseDAO();
	dao.deletCoursesByCourseId(id);
	deletBean(new Course(id));
}
}
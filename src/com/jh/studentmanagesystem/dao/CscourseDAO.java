package com.jh.studentmanagesystem.dao;

import com.jh.studentmanagesystem.bean.Course;
import com.jh.studentmanagesystem.bean.Cscourse;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class CscourseDAO extends BaseDAO<Cscourse>
{
  public String setClassName()
  {
    return Cscourse.class.getName();
  }

  public ArrayList<String> selectCoursesByUserId(int userid) {
    this.transaction = this.session.beginTransaction();
    Query query = this.session.createQuery("from Cscourse where userInfo.id=" + userid);
    List list = query.list();
    ArrayList courses = new ArrayList();
    for (int i = 0; i < list.size(); i++) {
      courses.add(((Cscourse)list.get(i)).getCourse().getCourseName());
    }
    return courses;
  }
}
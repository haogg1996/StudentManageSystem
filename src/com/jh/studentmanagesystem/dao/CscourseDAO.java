package com.jh.studentmanagesystem.dao;

import com.jh.studentmanagesystem.bean.Course;
import com.jh.studentmanagesystem.bean.Cscourse;
import com.jh.studentmanagesystem.bean.UserInfo;

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

  public List<Cscourse> selectCscourseByUserId(int userid) {
    this.transaction = this.session.beginTransaction();
    Query query = this.session.createQuery("from Cscourse where userInfo.id=" + userid);
    return query.list();
  }
  
  public boolean addCscourse(int userid,int courseid) {
	  UserInfoDAO dao=new UserInfoDAO();
	  UserInfo user = dao.selectBeanByid(userid);
	  return insertBean(new Cscourse(new Course(courseid), user));
  }
}
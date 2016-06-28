package com.jh.studentmanagesystem.bean;

import java.io.Serializable;

public class Cscourse
  implements Serializable
{
  private Integer cscourseid;
  private Course course;
  private UserInfo userInfo;

  public Cscourse()
  {
  }

  public Cscourse(Integer cscourseid, Course course, UserInfo userInfo)
  {
    this.cscourseid = cscourseid;
    this.course = course;
    this.userInfo = userInfo;
  }

  public Integer getCscourseid()
  {
    return this.cscourseid;
  }

  public void setCscourseid(Integer cscourseid) {
    this.cscourseid = cscourseid;
  }

  public Course getCourse() {
    return this.course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public UserInfo getUserInfo() {
    return this.userInfo;
  }

  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

  public String toString()
  {
    return getUserInfo().getName() + "@" + getCourse().getCourseName();
  }
}
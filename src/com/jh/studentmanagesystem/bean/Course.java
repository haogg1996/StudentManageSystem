package com.jh.studentmanagesystem.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Course
  implements Serializable
{
  private Integer courseid;
  private String courseName;
  private Set cscourses = new HashSet(0);

  public Course()
  {
  }

  public Course(Integer courseid)
  {
    this.courseid = courseid;
  }

  public Course(Integer courseid, String courseName, Set cscourses)
  {
    this.courseid = courseid;
    this.courseName = courseName;
    this.cscourses = cscourses;
  }
  public Course(String courseName, Set cscourses) {
    this.courseName = courseName;
    this.cscourses = cscourses;
  }

  public Integer getCourseid()
  {
    return this.courseid;
  }

  public void setCourseid(Integer courseid) {
    this.courseid = courseid;
  }

  public String getCourseName() {
    return this.courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public Set getCscourses() {
    return this.cscourses;
  }

  public void setCscourses(Set cscourses) {
    this.cscourses = cscourses;
  }

  public String toString()
  {
    return getCourseid() + "@" + getCourseName();
  }
}
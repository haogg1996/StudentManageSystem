package com.jh.studentmanagesystem.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class UserInfo
  implements Serializable
{
  private Integer id;
  private String name;
  private String password;
  private String address;
  private Integer age;
  private String telephone;
  private Timestamp birthday;
  private String sex;
  private Set cscourses = new HashSet(0);

  public UserInfo()
  {
  }

  public UserInfo(Integer id, String name, String password)
  {
    this.id = id;
    this.name = name;
    this.password = password;
  }
  public UserInfo(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public UserInfo(Integer id, String name, String password, String address, Integer age, String telephone, Timestamp birthday, String sex, Set cscourses)
  {
    this.id = id;
    this.name = name;
    this.password = password;
    this.address = address;
    this.age = age;
    this.telephone = telephone;
    this.birthday = birthday;
    this.sex = sex;
    this.cscourses = cscourses;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getAge() {
    return this.age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getTelephone() {
    return this.telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public Timestamp getBirthday() {
    return this.birthday;
  }

  public void setBirthday(Timestamp birthday) {
    this.birthday = birthday;
  }

  public String getSex() {
    return this.sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Set getCscourses() {
    return this.cscourses;
  }

  public void setCscourses(Set cscourses) {
    this.cscourses = cscourses;
  }

  public String toString()
  {
    return getId() + "@" + getName();
  }
}
package com.jh.studentmanagesystem.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Manageuser
  implements Serializable,User
{
  private Integer id;
  private String name;
  private String password;
  private String address;
  private Integer age;
  private String telephone;
  private Timestamp birthday;
  private String sex;

  public Manageuser()
  {
  }

  public Manageuser(Integer id, String name, String password)
  {
    this.id = id;
    this.name = name;
    this.password = password;
  }

  public Manageuser(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public Manageuser(Integer id, String name, String password, String address, Integer age, String telephone, Timestamp birthday, String sex)
  {
    this.id = id;
    this.name = name;
    this.password = password;
    this.address = address;
    this.age = age;
    this.telephone = telephone;
    this.birthday = birthday;
    this.sex = sex;
  }

  @Override
  public Integer getId()
  {
    return this.id;
  }
  @Override
  public void setId(Integer id) {
    this.id = id;
  }
  @Override
  public String getName() {
    return this.name;
  }
  @Override
  public void setName(String name) {
    this.name = name;
  }
  @Override
  public String getPassword() {
    return this.password;
  }
  @Override
  public void setPassword(String password) {
    this.password = password;
  }
  @Override
  public String getAddress() {
    return this.address;
  }
  @Override
  public void setAddress(String address) {
    this.address = address;
  }
  @Override
  public Integer getAge() {
    return this.age;
  }
  @Override
  public void setAge(Integer age) {
    this.age = age;
  }
  @Override
  public String getTelephone() {
    return this.telephone;
  }
  @Override
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
  @Override
  public Timestamp getBirthday() {
    return this.birthday;
  }
  @Override
  public void setBirthday(Timestamp birthday) {
    this.birthday = birthday;
  }
  @Override
  public String getSex() {
    return this.sex;
  }
  @Override
  public void setSex(String sex) {
    this.sex = sex;
  }

  public String toString()
  {
    return getId() + "@" + getName();
  }
}
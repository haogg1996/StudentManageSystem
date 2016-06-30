package com.jh.studentmanagesystem.bean;

import java.sql.Timestamp;

public interface User {
	 public Integer getId();

	  public void setId(Integer id);
	  public String getName();
	  public void setName(String name);

	  public String getPassword();
	  public void setPassword(String password) ;

	  public String getAddress();

	  public void setAddress(String address) ;

	  public Integer getAge();

	  public void setAge(Integer age) ;

	  public String getTelephone() ;

	  public void setTelephone(String telephone);

	  public Timestamp getBirthday() ;

	  public void setBirthday(Timestamp birthday);

	  public String getSex();

	  public void setSex(String sex) ;
}

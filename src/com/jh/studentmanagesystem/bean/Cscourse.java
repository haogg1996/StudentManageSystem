package com.jh.studentmanagesystem.bean;

/**
 * Cscourse entity. @author MyEclipse Persistence Tools
 */

public class Cscourse implements java.io.Serializable {

	// Fields

	private Integer cscourseid;
	private Course course;
	private UserInfo userInfo;
	private Integer scores;

	// Constructors

	/** default constructor */
	public Cscourse() {
	}

	/** minimal constructor */
	public Cscourse(Integer cscourseid, Course course, UserInfo userInfo) {
		this.cscourseid = cscourseid;
		this.course = course;
		this.userInfo = userInfo;
	}

	/** full constructor */
	public Cscourse( Course course, UserInfo userInfo) {
		this.course = course;
		this.userInfo = userInfo;

	}
	// Property accessors

	public Integer getCscourseid() {
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

	public Integer getScores() {
		return this.scores;
	}

	public void setScores(Integer scores) {
		this.scores = scores;
	}

}
package com.jh.studentmanagesystem.dao;

import java.util.List;

import org.hibernate.Query;

import com.jh.studentmanagesystem.bean.UserInfo;

public class UserInfoDAO extends BaseDAO<UserInfo> {

	public String setClassName() {
		return UserInfo.class.getName();
	}
	
	public boolean selectByUser(UserInfo user) {
		transaction=session.beginTransaction();
		String queryString = String.format("from UserInfo where name='%s' and password='%s'",user.getName(),user.getPassword());
		Query query = session.createQuery(queryString);
		List list = query.list();
		transaction.commit();
		return list.size()>0?true:false;
	}
	public int selectIdByUser(UserInfo user) {
		transaction=session.beginTransaction();
		String queryString = String.format("from UserInfo where name='%s' and password='%s'",user.getName(),user.getPassword());
		Query query = session.createQuery(queryString);
		List list = query.list();
		transaction.commit();
		return ((UserInfo)list.get(0)).getId();
	}
}
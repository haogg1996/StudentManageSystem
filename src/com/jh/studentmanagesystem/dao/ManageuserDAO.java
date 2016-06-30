package com.jh.studentmanagesystem.dao;

import java.util.List;

import org.hibernate.Query;

import com.jh.studentmanagesystem.bean.Manageuser;
import com.jh.studentmanagesystem.bean.UserInfo;

public class ManageuserDAO extends BaseDAO<Manageuser>
{
  public String setClassName()
  {
    return Manageuser.class.getName();
  }
  public boolean selectByManager(Manageuser user) {
		transaction=session.beginTransaction();
		String queryString = String.format("from Manageuser where name='%s' and password='%s'",user.getName(),user.getPassword());
		Query query = session.createQuery(queryString);
		List list = query.list();
		transaction.commit();
		return list.size()>0?true:false;
	}
  public int selectIdByManager(Manageuser user) {
		transaction=session.beginTransaction();
		String queryString = String.format("from Manageuser where name='%s' and password='%s'",user.getName(),user.getPassword());
		Query query = session.createQuery(queryString);
		List list = query.list();
		transaction.commit();
		if (list.size()<=0) {
			return 0;
		}else {
			
			return ((Manageuser)list.get(0)).getId();
		}
		
	}
}
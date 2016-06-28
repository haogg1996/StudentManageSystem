package com.jh.studentmanagesystem.dao;

import com.jh.studentmanagesystem.hibernate.HibernateSessionFactory;
import java.io.PrintStream;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class BaseDAO<T>
{
  public Session session;
  public Transaction transaction;
  private String className;

  public BaseDAO()
  {
    this.session = HibernateSessionFactory.getSession();
    this.className = setClassName();
  }

  public abstract String setClassName();

  public T selectBeanByid(int id)
  {
    return (T) this.session.get(this.className, id);
  }

  public List<T> selectAll() {
    Query query = this.session.createQuery("from " + this.className);
    return query.list();
  }

  public boolean insertBean(T bean) {
    this.transaction = this.session.beginTransaction();
    int id = ((Integer)this.session.save(bean)).intValue();
    this.transaction.commit();
    System.out.println(id);
    return id > 0;
  }
}
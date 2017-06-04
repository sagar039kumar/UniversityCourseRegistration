package spring.CourseApplication.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import spring.CourseApplication.dto.Master;

@Transactional
public class MasterDAOImpl implements MasterDAO {
	
	 private SessionFactory sessionFactory;
	 
	    public MasterDAOImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	
    @Override 	    
	public void add(Master item) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(item);
		  } catch (HibernateException e) {
			  e.printStackTrace();
			  session.getTransaction().rollback();
		}
			session.getTransaction().commit();
	}
	
    @Override 	
	public void update(Master item) {
		
		Session session = sessionFactory.getCurrentSession();
		try {
			System.out.println("IN Update");
			session.beginTransaction();
			session.saveOrUpdate(item);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		session.getTransaction().commit();
	}
	
	@Override 
	public Master getItem(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Master item=null;
		try {
			System.out.println("IN GetIteam");
			session.beginTransaction();
		    item = (Master) session.get(Master.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return item;
	}
	 
	@Override 
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Master item = (Master) session.get(Master.class, id);
		if(null != item) {
			session.delete(item);
		}
		session.getTransaction().commit();
		//return item;
	}

	@Override 
	public List<Master> list() {
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Master> items = null;
		try {
			System.out.println("IN LIST");
			items = (List<Master>)session.createQuery("from Master").list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return items;
	}

}

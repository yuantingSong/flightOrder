package com.web.airplane.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.web.airplane.exceptions.UserException;
import com.web.airplane.pojo.User;

public class UserDao extends AbstractDao {
	
	public UserDao() {
		super();
	}
	
    public User create(User user) throws UserException {
        try {
            begin();            
            getSession().save(user);     
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Exception while creating: " + e.getMessage());
        }
    }
    
    public User delete(User user) throws UserException {
    	try {
    		begin();
    		getSession().delete(user);
    		commit();
    		return user;
    	} catch (HibernateException e) {
    		rollback();
    		throw new UserException("Exception while deleting : " + e.getMessage());
    	}
    }
    
	public boolean hasName(String name) throws UserException {
		try {
			begin();			
			Query q = getSession().createQuery("from User where username = :username ");
			q.setString("username", name);
			User user = (User) q.uniqueResult();
			commit();
			return user != null;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while check" + e.getMessage());
		}
	}
	
	public User get(String username, String password) throws UserException {
		try {
			begin();
			System.out.println(username + " " + password);
			Query q = getSession().createQuery("from User where username = :username and password = :password");
			q.setString("username", username);
			System.out.println(username);
			q.setString("password", password);			
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " , e);
		}
	}
		
}

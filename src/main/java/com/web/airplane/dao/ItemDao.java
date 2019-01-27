package com.web.airplane.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.web.airplane.exceptions.AirplaneException;
import com.web.airplane.exceptions.FlightException;
import com.web.airplane.exceptions.OrderException;
import com.web.airplane.exceptions.PersonException;
import com.web.airplane.pojo.Airplane;
import com.web.airplane.pojo.Flight;
import com.web.airplane.pojo.Item;
import com.web.airplane.pojo.Person;
import com.web.airplane.pojo.User;

public class ItemDao extends AbstractDao {

	public ItemDao() {
		super();
	}
	
	public Item create(Item order) throws OrderException {
        try {
            begin();            
            getSession().save(order);     
            commit();
            return order;
        } catch (HibernateException e) {
            rollback();
            throw new OrderException("Exception while create: " + e.getMessage());
        }
	}
	
	public Item delete(Item order) throws OrderException {
        try {
            begin();            
            getSession().delete(order);     
            commit();
            return order;
        } catch (HibernateException e) {
            rollback();
            throw new OrderException("Exception while delete: " + e.getMessage());
        }
	}
	
    @SuppressWarnings("unchecked")
    public List<Item> getOrders(User user) throws OrderException {
        try {
        	begin();
        	Query q  =getSession().createQuery("from Item where userId =:userId"); 
        	q.setParameter("userId", user.getUserId());
        	List<Item> orders = q.list();  
            commit();
            return orders;
        } catch (HibernateException e) {
            rollback();
            throw new OrderException("Exception while list: " + e.getMessage());
        }
    }
	 
}

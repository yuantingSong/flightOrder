package com.web.airplane.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.web.airplane.exceptions.AirplaneException;
import com.web.airplane.exceptions.FlightException;
import com.web.airplane.exceptions.PersonException;
import com.web.airplane.pojo.Airplane;
import com.web.airplane.pojo.Flight;
import com.web.airplane.pojo.Person;
import com.web.airplane.pojo.User;

public class PersonDao extends AbstractDao {

	public PersonDao() {
		super();
	}
	
	public Person create(Person person) throws PersonException {
        try {
            begin();            
            getSession().save(person);     
            commit();
            return person;
        } catch (HibernateException e) {
            rollback();
            throw new PersonException("Exception while create: " + e.getMessage());
        }
	}
	
	public Person delete(Person person) throws PersonException {
        try {
            begin();            
            getSession().delete(person);     
            commit();
            return person;
        } catch (HibernateException e) {
            rollback();
            throw new PersonException("Exception while delete: " + e.getMessage());
        }
	}
	
    @SuppressWarnings("unchecked")
    public List<Person> getPersons(User user) throws PersonException {
        try {
        	begin();
        	Query q  =getSession().createQuery("from Person where userId =:userId"); 
        	q.setParameter("userId", user.getUserId());
        	List<Person> persons = q.list();  
            commit();
            return persons;
        } catch (HibernateException e) {
            rollback();
            throw new PersonException("Exception while list: " + e.getMessage());
        }
    }
	
    public Person get(String Id) throws PersonException {
        try {
            begin();            
            Query q=getSession().createQuery("from Person where id =:id");     
            q.setString("id", Id);
            Person person=(Person)q.uniqueResult();
            commit();
            return person;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new PersonException("Exception while creating advert: " + e.getMessage());
        }
    }
}

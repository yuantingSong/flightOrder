package com.web.airplane.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;


import com.web.airplane.exceptions.FlightException;
import com.web.airplane.pojo.Airplane;
import com.web.airplane.pojo.Flight;

import java.util.*;

public class FlightDao extends AbstractDao {
	
	public FlightDao() {
		super();
	}
	
    public Flight create(Flight flight) throws FlightException {
        try {
            begin();            
            getSession().save(flight);     
            commit();
            return flight;
        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Exception while creating: " + e.getMessage());
        }
    }

    public Flight delete(Flight flight) throws FlightException {
        try {
            begin();            
            getSession().delete(flight);     
            commit();
            return flight;
        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Exception while delete: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Flight> list() throws FlightException {
        try {
        	begin();
        	Query q  =getSession().createQuery("from Flight ");      
        	List<Flight> flights = q.list();  
            commit();
            return flights;
        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Exception while list: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Flight> getFlights(Airplane airplane) throws FlightException {
        try {
        	begin();
        	Query q  =getSession().createQuery("from Flight where airplaneId =:airplaneId");     
        	q.setParameter("airplaneId", airplane.getAirplaneId());
        	List<Flight> flights = q.list();  
            commit();
            return flights;
        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Exception while getFlights: " + e.getMessage());
        }
    }
    public Flight get(String Id) throws FlightException {
        try {
            begin();            
            Query q=getSession().createQuery("from Flight where id =:id");     
            q.setString("id", Id);
            Flight flight=(Flight)q.uniqueResult();
            commit();
            return flight;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new FlightException("Exception while creating advert: " + e.getMessage());
        }
    }
}

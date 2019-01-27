package com.web.airplane.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
 
import com.web.airplane.exceptions.AirplaneException;
import com.web.airplane.pojo.Airplane;
import com.web.airplane.pojo.Flight;
import com.web.airplane.pojo.User;

public class AirplaneDao extends AbstractDao {

	public AirplaneDao() {
		super();
	}
	
    public Airplane create(Airplane airplane) throws AirplaneException {
        try {
            begin();            
            getSession().save(airplane);     
            commit();
            return airplane;
        } catch (HibernateException e) {
            rollback();
            throw new AirplaneException("Exception while create: " + e.getMessage());
        }
    }

    public Airplane delete(Airplane airplane) throws AirplaneException {
        try {
            begin();            
            getSession().delete(airplane);     
            commit();
            return airplane;
        } catch (HibernateException e) {
            rollback();
            throw new AirplaneException("Exception while deleting: " + e.getMessage());
        }
    }

    public Airplane get(String airplaneId) throws AirplaneException {
        try {
            begin();            
        	Query q = getSession().createQuery("from Airplane where airplaneId = :airplaneId ");
			q.setString("airplaneId", airplaneId);
			Airplane airplane = (Airplane) q.uniqueResult();
            commit();
            return airplane;
        } catch (HibernateException e) {
            rollback();
            throw new AirplaneException("Exception while get: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public List<Airplane> getAirplanesOfPage(int page) {
    	Criteria criteria =  getSession().createCriteria(Airplane.class);  
    	page = (page - 1) * 5;
    	criteria.setFirstResult(page);
    	criteria.setMaxResults(8);
    	List<Airplane> list = criteria.list();
    	return list;
    }
    
    public List<Airplane> list() throws AirplaneException{
    	
    	try {
            begin();
            Query q = getSession().createQuery("from Airplane");
            List<Airplane> airplanes = q.list();
            commit();
            return airplanes;
        } catch (HibernateException e) {
            rollback();
            throw new AirplaneException("Could not list airplanes", e);
        }
    	
    }
    /*
    public List<Flight> getFlights(Airplane airplane) throws AirplaneException {
        try {
        	begin();
        	Query q  =getSession().createQuery("from Flight where airplaneId =:airplaneId");     
        	q.setParameter("airplaneId", airplane);
        	List<Flight> flights = q.list();    
            commit();
            return flights;
        } catch (HibernateException e) {
            rollback();
            throw new AirplaneException("Exception while getFlights: " + e.getMessage());
        }
    }
    */
    
}

package com.web.airplane.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.airplane.dao.AirplaneDao;
import com.web.airplane.dao.FlightDao;
import com.web.airplane.dao.PersonDao;
import com.web.airplane.exceptions.AirplaneException;
import com.web.airplane.exceptions.FlightException;
import com.web.airplane.pojo.Airplane;
import com.web.airplane.pojo.Flight;
import com.web.airplane.pojo.Person;
import com.web.airplane.pojo.User;

@Controller
@RequestMapping("/flight/*")
public class FlightController {
	
	@Autowired
	@Qualifier("flightDao")
	FlightDao flightDao;
	
	@Autowired
	@Qualifier("airplaneDao")
	AirplaneDao airplaneDao;
	
	@Autowired
	@Qualifier("personDao")
	PersonDao personDao;
	
	@RequestMapping(value = "/flight/showDetail")
	public ModelAndView showDetail(HttpRequest request) {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/flight/orderFlight", method = RequestMethod.POST)
	public ModelAndView orderFlight(HttpServletRequest request) throws Exception {
		String flightId = request.getParameter("flightId");
		User user = (User) request.getSession().getAttribute("user");
		List<Person> persons = personDao.getPersons(user);
		System.out.println(flightId);
		System.out.println("show persons from flight"); 
		ModelAndView mv = new ModelAndView("showPersons", "flightId", flightId);
		mv.addObject("persons", persons);
		return mv;
	}
	
	@RequestMapping(value = "/flight/createFlight.htm", method = RequestMethod.GET)
	public ModelAndView createFlighthtm(HttpServletRequest request) {
		String airplaneId = request.getParameter("airplaneId");
		return new ModelAndView("createFlight", "airplaneId", airplaneId);
	}
	
	@RequestMapping(value = "/flight/createFlight", method = RequestMethod.POST)
	public ModelAndView createFlight(HttpServletRequest request) throws AirplaneException, FlightException {
		System.out.println("creating flight");
		String airplaneId = request.getParameter("airplaneId");
		Airplane airplane = airplaneDao.get(airplaneId);
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String departureTime = request.getParameter("departureTime");
		String arrivalTime = request.getParameter("arrivalTime");
		Flight flight = new Flight(from, to ,departureTime, arrivalTime, airplane);
		flightDao.create(flight);
		airplane = airplaneDao.get(airplaneId);
		airplane.getFlights().add(flight);
		ModelAndView mav = new  ModelAndView("createFlight", "airplaneId", airplaneId);
		List<Flight> flights = flightDao.getFlights(airplane);
		mav.addObject("flights",flights);
		System.out.println(flights.size());
		return mav;
	}
}

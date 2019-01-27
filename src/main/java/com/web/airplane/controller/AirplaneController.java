package com.web.airplane.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.airplane.dao.AirplaneDao;
import com.web.airplane.dao.FlightDao;
import com.web.airplane.pojo.Airplane;
import com.web.airplane.pojo.Flight;

@Controller
@RequestMapping("/airplane/*")
public class AirplaneController {
	
	@Autowired
	@Qualifier("airplaneDao")
	AirplaneDao airplaneDao;
	
	@Autowired
	@Qualifier("flightDao")
	FlightDao flightDao;
	
	
	@RequestMapping(value = "/airplane/createAirplane.htm", method = RequestMethod.GET)
	public ModelAndView createAirplaneHtm(HttpServletRequest request) throws Exception {
		System.out.println("goto create Airplane");
		return new ModelAndView("createAirplane");
	}
	
	@RequestMapping(value = "/airplane/deleteAirplane", method = RequestMethod.POST)
	public ModelAndView deleteAirplane(HttpServletRequest request) throws Exception {
		String airplaneId = request.getParameter("airplaneId");
		airplaneDao.delete(airplaneDao.get(airplaneId));
		return showAirplanes(request);
	}
	
	@RequestMapping(value = "/airplane/createAirplane", method = RequestMethod.POST)
	public ModelAndView createAirplane(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String seatNum = request.getParameter("seatNumber");
		int seatNumber = Integer.valueOf(seatNum);
		Airplane airplane = new Airplane(name, seatNumber);
		airplaneDao.create(airplane);
		return new ModelAndView("createAirplane");
	}
	
	@RequestMapping(value = "/airplane/showAirplanes", method = RequestMethod.GET)
	public ModelAndView showAirplanes(HttpServletRequest request) throws Exception {
		List<Airplane> airplanes = airplaneDao.list();
		return new ModelAndView("showAirplanes", "airplanes", airplanes);
	}
	
	@RequestMapping(value = "/airplane/showFlights", method = RequestMethod.POST)
	public ModelAndView showFlights(HttpServletRequest request) throws Exception {
		String airplaneId = request.getParameter("airplaneId");
		Airplane airplane = airplaneDao.get(airplaneId);
		List<Flight> flights = flightDao.getFlights(airplane);
		ModelAndView mv = new ModelAndView("showFlights", "airplane", airplane);
		mv.addObject("flights", flights);
		return mv;
	}
	
	@RequestMapping(value = "/airplane/showOrderFlights", method = RequestMethod.GET)
	public ModelAndView showOrderFlights(HttpServletRequest request) throws Exception {
		List<Flight> flights = flightDao.list();
		ModelAndView mv = new ModelAndView("showOrderFlights", "flights", flights); 
		return mv;
	}
	
	@RequestMapping(value = "/airplane/showOrderFlights", method = RequestMethod.POST)
	public ModelAndView showOrderFlight(HttpServletRequest request) throws Exception {
		List<Flight> flights = flightDao.list();
		ModelAndView mv = new ModelAndView("showOrderFlights", "flights", flights); 
		return mv;
	}
}

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
import com.web.airplane.dao.ItemDao;
import com.web.airplane.dao.PersonDao;
import com.web.airplane.pojo.Airplane;
import com.web.airplane.pojo.Flight;
import com.web.airplane.pojo.Item;
import com.web.airplane.pojo.Person;
import com.web.airplane.pojo.User;

@Controller
@RequestMapping("/person/*")
public class PersonController {
	
	@Autowired
	@Qualifier("personDao")
	PersonDao personDao;
	
	@Autowired
	@Qualifier("flightDao")
	FlightDao flightDao;
	
	@Autowired
	@Qualifier("itemDao")
	ItemDao itemDao;
	
	@RequestMapping(value = "/person/createPerson.htm", method = RequestMethod.POST)
	public ModelAndView createAirplaneHtm(HttpServletRequest request) throws Exception {
		System.out.println("goto create Person");
		User user = (User) request.getSession().getAttribute("user");
		ModelAndView mv = new ModelAndView("createPerson", "user", user); 
		return mv;
	}
	
	@RequestMapping(value = "/person/createPerson", method = RequestMethod.POST)
	public ModelAndView createPerson(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String birthday = request.getParameter("birthday");
		int age = Integer.valueOf(request.getParameter("age"));
		String email = request.getParameter("email");  
		User user = (User) session.getAttribute("user");
		Person person = new Person(firstname, lastname, birthday, age, email, user);
		personDao.create(person);
		return new ModelAndView("createPerson");
	}
	
	@RequestMapping(value = "/person/showPersons", method = RequestMethod.GET)
	public ModelAndView showPersons(HttpServletRequest request) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		List<Person> persons = personDao.getPersons(user);
		System.out.println(persons.size());
		System.out.println("show persons");
		return new ModelAndView("showPersons", "persons", persons);
	}
	
	@RequestMapping(value = "/person/order", method = RequestMethod.POST)
	public ModelAndView orderTicket(HttpServletRequest request) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		String flightId = request.getParameter("flightId");
		String personId = request.getParameter("personId");
		Flight flight = flightDao.get(flightId);
		Person person = personDao.get(personId);
		System.out.println("order ");
		System.out.println(flight);

		System.out.println(flightId);
		Item item = new Item(person, user, flight);
		itemDao.create(item);
		List<Person> persons = personDao.getPersons(user);
		return new ModelAndView("showPersons", "persons", persons);
	}
}

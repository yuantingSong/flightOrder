package com.web.airplane.controller;

import java.util.List;

import javax.servlet.http.Cookie;
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
import com.web.airplane.dao.UserDao;
import com.web.airplane.pojo.Airplane;
import com.web.airplane.pojo.Flight;
import com.web.airplane.pojo.User;


@Controller
@RequestMapping("/user/*")
public class UserController {
	
	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	
	@Autowired
	@Qualifier("airplaneDao")
	AirplaneDao airplaneDao;
	
	@Autowired
	@Qualifier("flightDao")
	FlightDao flightDao;

	@RequestMapping(value = "/user/login", method = RequestMethod.GET) 
	public ModelAndView loginUserHtm(HttpServletRequest request,HttpServletResponse response) throws Exception {
 
		return new ModelAndView("login");
	}
	

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		boolean remember=request.getParameter("rememberMe") != null;
		
		System.out.println("login trying");
		if (name == null || name.length() == 0) {
			session.setAttribute("mes", "");
			return new ModelAndView("signup");
		}

		User user = userDao.get(name, password);
		if (user == null) {
			System.out.println("cannot login");
			return new ModelAndView("login");
		}
		// userDao.get(name, password);
		System.out.println("login success");
		if(remember){
            Cookie ckUsername=new Cookie("username",user.getUsername());
            ckUsername.setMaxAge(3600);
            response.addCookie(ckUsername);   
            Cookie ckPassword=new Cookie("password",user.getPassword());
            ckPassword.setMaxAge(3600);
            response.addCookie(ckPassword);
        }
		session.setAttribute("user", user);
		if (user.isAdmin()) {

			List<Airplane> airplanes = airplaneDao.list();
			ModelAndView mv = new ModelAndView("redirect:/airplane/showAirplanes", "airplanes", airplanes);
			return mv;
		}
		List<Flight> flights = flightDao.list();
		ModelAndView mv = new ModelAndView("redirect:/airplane/showOrderFlights", "flights", flights);
		return mv;
	}
	
	@RequestMapping(value = "/user/signup", method = RequestMethod.GET)
	public ModelAndView signupHtmUser(HttpServletRequest request,HttpServletRequest response) throws Exception {
		ModelAndView mav = new ModelAndView("signup");
		request.getSession().setAttribute("mes", "");
		return mav;
	}
	
	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public ModelAndView signupUser(HttpServletRequest request,HttpServletRequest response) throws Exception {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("registering");
		if (name == null || name.length() == 0) {
			String message = "";			 
			message = "error name！";		
			ModelAndView mav = new ModelAndView("signup");
			mav.addObject("mes", message);
			return mav;
		}
		if (userDao.hasName(name) == true) {			
			String message = "";			 
			message = "used name！";		
			ModelAndView mav = new ModelAndView("signup");
			request.getSession().setAttribute("mes", message);
			return mav;
		}
		User user;
		if (name.equals("admin")) {
			user = new User(name, password, true);
		} else {
			user = new User(name, password);
		}
		userDao.create(user);
		System.out.println("registered");
		List<Airplane> airplanes = airplaneDao.list();
		//return new ModelAndView("showAirplanes", "airplanes", airplanes);
		return new ModelAndView("login");
	}
	
	 public User checkCookie(HttpServletRequest request){
	        Cookie[] cookies=request.getCookies();
	        User account=null;
	        if(cookies==null) 
	            return null;
	        else{
	            String username="";
	            String password="";
	            for(Cookie ck:cookies){
	                if(ck.getName().equalsIgnoreCase("username"))
	                    username=ck.getValue();
	                if(ck.getName().equalsIgnoreCase("password"))
	                    password=ck.getValue();
	            }
	            if(!username.isEmpty()&&!password.isEmpty())
	              account=new User(username,password);  
	        }
	        return account;
	    }
	
}


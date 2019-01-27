package com.web.airplane.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.web.airplane.pojo.Flight;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airplane")
public class Airplane {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "airplaneId" , unique = true, nullable = false)
	private long airplaneId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "seatNum") 
	private int seatNum;

	@OneToMany(
	        mappedBy = "airplane",
	        cascade = CascadeType.ALL)
	private List<Flight> flights;
	
	public Airplane() {

		this.flights = new ArrayList<Flight>();
	}
	
	public Airplane(String name, int seatNum) {
		this.name = name;
		this.seatNum = seatNum;
		this.flights = new ArrayList<Flight>();
	}
	
	public long getAirplaneId() {
		return airplaneId;
	}

	public void setAirplaneId(long airplaneId) {
		this.airplaneId = airplaneId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

}

package com.web.airplane.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flightId" , unique = true, nullable = false)
	private long flightId;
	
	@Column(name = "fromTime")
	private String fromTime;

	@Column(name = "toTime")
	private String toTime;
	
	@Column(name = "departureTime")
	private String departureTime;
	
	@Column(name = "arrivalTime")
	private String arrivalTime;
	
	@Column(name = "seatLeft")
	private int seatLeft;
	
	@ManyToOne
	@JoinColumn(name="airplaneId")
	private Airplane airplane;
	
	public Flight() {
		
	}
	
	public Flight(String from, String to, String departureTime, String arrivalTime, Airplane airplane) {
		this(from, to, departureTime, arrivalTime, airplane, airplane.getSeatNum()); 
	}

	public Flight(String from, String to, String departureTime, String arrivalTime, Airplane airplane, int seatLeft) {
		this.fromTime = from;
		this.toTime = to;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.airplane = airplane;
		this.seatLeft = airplane.getSeatNum();
	}
	
	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
	
	public int getSeatLeft() {
		return seatLeft;
	}

	public void setSeatLeft(int seatLeft) {
		this.seatLeft = seatLeft;
	}
}

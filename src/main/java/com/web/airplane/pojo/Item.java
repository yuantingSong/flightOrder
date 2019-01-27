package com.web.airplane.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.web.airplane.pojo.*;

@Entity
@Table(name = "item")
public class Item {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itemId", unique = true, nullable = false) 
	private long itemId;

	@Column(name = "hasPaid")
	private boolean hasPaid;
	
	@ManyToOne
	@JoinColumn(name = "personId")
	private Person passenger;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User orderBy;
	
	@ManyToOne
	@JoinColumn(name = "flightId")
	private Flight flight;
	
	public Item(Person passenger, User user, Flight flight) {
		this.passenger = passenger;
		this.orderBy = user;
		this.flight = flight;
	}
	
	public long getOrderId() {
		return itemId;
	}

	public void setOrderId(long orderId) {
		this.itemId = orderId;
	}

	public boolean isHasPaid() {
		return hasPaid;
	}

	public void setHasPaid(boolean hasPaid) {
		this.hasPaid = hasPaid;
	}

	public Person getPassenger() {
		return passenger;
	}

	public void setPassenger(Person passenger) {
		this.passenger = passenger;
	}

	public User getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(User orderBy) {
		this.orderBy = orderBy;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
}

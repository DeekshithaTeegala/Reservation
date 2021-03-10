package com.cg.rms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Seat {

	@Id
	@Column(name="seat_number")
	private int seatNumber;
	
	@Column(name="seat_status",length=20)
	private String seatStatus;
	
	@ManyToOne
	@JoinColumn(name="bus_id")
	@JsonIgnore
	private Bus bus;

//	@OneToMany(mappedBy="seats")
//	private List<Seat> seats=new ArrayList<Seat>();

	public Seat(int seatNumber, String seatStatus,Bus bus) {
		super();
		this.seatNumber = seatNumber;
		this.seatStatus = seatStatus;
		this.bus = bus;
	}

	public Seat() {
		super();
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

//	public List<Seat> getSeats() {
//		return seats;
//	}
//
//	public void setSeats(List<Seat> seats) {
//		this.seats = seats;
//	}

	
	
	
	
	
}

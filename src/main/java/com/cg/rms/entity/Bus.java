package com.cg.rms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="bus_tbl")
public class Bus {
	
	@Id
	@Column(name="bus_id")
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="busId_seq",allocationSize=1)
	private int busId;
	
	@Column(name="seat_capacity")
	private int seatCapacity;
	
	@ManyToOne
	@JoinColumn(name="seat_number")
	@JsonIgnore
	private Seat seat;
	
	@OneToMany(mappedBy="bus")
	private List<Reservation> reservations=new ArrayList<>();

	@OneToMany(mappedBy="bus")
	private List<Seat> seats=new ArrayList<Seat>();
	
    
	
	


public Bus(int busId, int seatCapacity, Seat seat) {
		super();
		this.busId = busId;
		this.seatCapacity = seatCapacity;
		this.seat = seat;
	}

//	public Bus(int busId, String seatStatus) {
//		super();
//		this.busId = busId;
//		this.seatStatus = seatStatus;
//		this.seat = seat;
//	}

	public Bus() {
		super();
	}



	
	

	public int getBusId() {
		return busId;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	} 
	
	

	
}

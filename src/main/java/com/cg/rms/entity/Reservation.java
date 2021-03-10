package com.cg.rms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="reservation_tbl")
public class Reservation {

	@Id
	@Column(name="rid")
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="reservation_seq",allocationSize=1)
	private int rid;
	
	@Column(name="name",length=20)
	private String name;
	
	@Column(name="gender",length=20)
	private String gender;
	
	@Column(name="age")
	private int age;
	
	@Column(name="contact")
	private int contact;
	
	@Column(name="ramount")
	private double ramount;
	
	@Column(name="departure_date")
	private Date departureDate;
	
	@Column(name="arrival_date")
	private Date arrivalDate;
	
	@Column(name="boarding_point",length=20)
	private String boardingPoint;
	
	@Column(name="dropping_point",length=20)
	private String droppingPoint;
	
//	@Column(name="seat")
//	private Seat seat;
	
	@ManyToOne
	@JoinColumn(name="seat_number")
	@JsonIgnore
	private Seat seat;
	
	@ManyToOne
	@JoinColumn(name="bus_id")
	@JsonIgnore
	private Bus bus;

	

	public Reservation(int rid, String name, String gender, int age, int contact, double ramount, Date departureDate,
			Date arrivalDate, String boardingPoint, String droppingPoint, Seat seat, Bus bus) {
		super();
		this.rid = rid;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.contact = contact;
		this.ramount = ramount;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.boardingPoint = boardingPoint;
		this.droppingPoint = droppingPoint;
		this.seat = seat;
		this.bus = bus;
	}

	public Reservation() {
		super();
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public double getRamount() {
		return ramount;
	}

	public void setRamount(double ramount) {
		this.ramount = ramount;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public String getDroppingPoint() {
		return droppingPoint;
	}

	public void setDroppingPoint(String droppingPoint) {
		this.droppingPoint = droppingPoint;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
	
}

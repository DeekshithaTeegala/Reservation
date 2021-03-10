package com.cg.rms.service;

import java.util.List;

import com.cg.rms.entity.Bus;
import com.cg.rms.entity.Login;
import com.cg.rms.entity.Reservation;
import com.cg.rms.entity.Seat;
import com.cg.rms.exception.ReservationException;

public interface ReservationService {

	public Login findUser(String username,String password) throws ReservationException;
	
	public List findAllSeats(int busId) throws ReservationException;
	public Reservation bookSeat(Reservation res,int busId,int seatNo) throws ReservationException;
	public Reservation cancelSeat(int rid) throws ReservationException;
	
	public List<Seat> checkSeatAvailability(int busId) throws ReservationException;
}

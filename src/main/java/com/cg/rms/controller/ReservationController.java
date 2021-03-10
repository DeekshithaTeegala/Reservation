package com.cg.rms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rms.entity.Bus;
import com.cg.rms.entity.Login;
import com.cg.rms.entity.Reservation;
import com.cg.rms.entity.Seat;
import com.cg.rms.exception.ReservationException;
import com.cg.rms.service.ReservationService;

@RestController
@CrossOrigin("*")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;

	@GetMapping("admin/login/{user}/{pass}")
	public ResponseEntity<Login>  findUserLogin(@PathVariable("user") String username,
			                               @PathVariable("pass") String password) throws ReservationException
	{
	 
	Login log = reservationService.findUser(username,password);
	if(log==null) {
	throw new ReservationException("Login not successful");
	}
	return new ResponseEntity<Login>(log,HttpStatus.OK);

	}
	

	
	@GetMapping("bus/busId/{id}")
	public ResponseEntity<List<Seat>> findAllSeats(@PathVariable("id") int busId) throws ReservationException
	{
		List<Seat> list=reservationService.findAllSeats(busId);
		ResponseEntity<List<Seat>> rt=new ResponseEntity<List<Seat>>(list,HttpStatus.OK);
		return rt;
	}
	

	
	@PostMapping("reservation")
	public ResponseEntity<Reservation> bookSeat(@RequestBody Reservation reservation,@PathVariable("id") int busId,
			@PathVariable("seat") int seatNo) throws ReservationException
	{
		Reservation res=reservationService.bookSeat(reservation, busId, seatNo);
		ResponseEntity<Reservation> rt=new ResponseEntity<Reservation>(res,HttpStatus.OK);
		return rt;
	}


	@DeleteMapping("reservation/id/{id}")
	public ResponseEntity<Reservation> cancelSeat(@PathVariable("id") int rid) throws ReservationException
	{
		ResponseEntity<Reservation> re=null;
		Reservation res=reservationService.cancelSeat(rid);
		ResponseEntity<Reservation> rt=new ResponseEntity<Reservation>(res,HttpStatus.OK);
		return re;
	}
	
	@PutMapping("reservation/id/{id}")
	public ResponseEntity<List<Seat>> checkSeatAvailability(@PathVariable("id") int busId) throws ReservationException
	{
		List<Seat> list=reservationService.checkSeatAvailability(busId);
		ResponseEntity<List<Seat>> rt=new ResponseEntity<List<Seat>>(list,HttpStatus.OK);
		return rt;
		
	}
}

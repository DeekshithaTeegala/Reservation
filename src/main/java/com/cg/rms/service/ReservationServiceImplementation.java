package com.cg.rms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rms.dao.BusDao;
import com.cg.rms.dao.LoginDao;
import com.cg.rms.dao.ReservationDao;
import com.cg.rms.entity.Bus;
import com.cg.rms.entity.Login;
import com.cg.rms.entity.Reservation;
import com.cg.rms.entity.Seat;
import com.cg.rms.exception.ReservationException;

@Service
public class ReservationServiceImplementation implements ReservationService {
	
	@Autowired
	ReservationDao reservationDao;
	
	@Autowired
	BusDao busDao;
	
	@Autowired
	LoginDao loginDao;
	
	@Override
	public Reservation bookSeat(Reservation res,int busId,int seatNo) throws ReservationException {
		
		if(checkSeatAvailability(busId)==null)
		{
			throw new ReservationException("All seats are reserved");
		}
		
        Reservation reservation=new Reservation();
		reservation.setName(res.getName());
		reservation.setAge(res.getAge());
		reservation.setGender(res.getGender());
		reservation.setContact(res.getContact());
		reservation.setDepartureDate(res.getDepartureDate());
		reservation.setArrivalDate(res.getArrivalDate());
		reservation.setBoardingPoint(res.getBoardingPoint());
		reservation.setDroppingPoint(res.getDroppingPoint());
		reservation.setRamount(res.getRamount());
		reservation.setSeat(res.getSeat());
		Bus bus=busDao.findById(busId).get();
		reservation.setBus(bus);
		reservation.getBus().getSeat().setSeatNumber(seatNo);
		reservation.getBus().getSeat().setSeatStatus("reserved");
		
		List<Reservation> list=bus.getReservations();
		list.add(reservation);
		
		reservationDao.saveAndFlush(reservation);
		busDao.saveAndFlush(bus);
		System.out.println(reservation.getRid());
		
		return reservation;
	}

	@Override
	public Reservation cancelSeat(int rid) throws ReservationException {
		Reservation res=null;
		if(reservationDao.existsById(rid))
		{
			res=reservationDao.findById(rid).get();
			reservationDao.deleteById(rid);
		}
		else
			throw new ReservationException("id not found");
		
		return res;
	}
	
	@Override
	public List<Seat> findAllSeats(int busId) throws ReservationException {
	    Bus bus=busDao.findById(busId).get();
	    List<Seat> list=bus.getSeats();
	    if(list.isEmpty())
	    	throw new ReservationException("Seats are not available");
	    else
		return list;
	}
	
	@Override
	public Login findUser(String username,String password) throws ReservationException {
		
		return loginDao.findUser(username,password);
	}

	@Override
	public List<Seat> checkSeatAvailability(int busId) throws ReservationException {
        Bus bus=busDao.findById(busId).get();
        List<Seat> list=bus.getSeats();
        List<Seat> li=list.stream().filter(seat->seat.getSeatStatus()=="vacant"?true:false).collect(Collectors.toList());
		li.forEach(p->System.out.println(p));
        return li;
	}
}

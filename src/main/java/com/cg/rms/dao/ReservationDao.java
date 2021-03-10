package com.cg.rms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rms.entity.Reservation;

@Repository
public interface ReservationDao extends JpaRepository<Reservation,Integer>{

}

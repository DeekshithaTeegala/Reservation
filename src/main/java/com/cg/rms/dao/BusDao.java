package com.cg.rms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rms.entity.Bus;

@Repository
public interface BusDao extends JpaRepository<Bus,Integer>{
    
}

package com.sltk.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltk.app.model.Plant;
import com.sltk.app.model.Purchaser;

@Repository
public interface PurchaserDao extends JpaRepository<Purchaser, String>{


}

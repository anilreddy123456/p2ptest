package com.sltk.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltk.app.model.Plant;

@Repository
public interface PlantDao extends JpaRepository<Plant, String>{

}

package com.sltk.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltk.app.model.Grn;





@Repository
public interface GrnDao extends JpaRepository<Grn, Long> {

}

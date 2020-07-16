package com.sltk.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltk.app.model.Prheader;
@Repository
public interface PrheaderDao extends JpaRepository<Prheader, Long> {

}

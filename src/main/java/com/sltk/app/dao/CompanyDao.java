package com.sltk.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltk.app.model.Company;

@Repository
public interface CompanyDao extends JpaRepository<Company, Long> {

}

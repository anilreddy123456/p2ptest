package com.sltk.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sltk.app.model.Vendor;

public interface VendorDao extends JpaRepository<Vendor, Long> {

}

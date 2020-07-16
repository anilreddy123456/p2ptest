package com.sltk.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltk.app.model.Invoices;

@Repository
public interface InvoiceDao extends JpaRepository<Invoices, Long> {

}

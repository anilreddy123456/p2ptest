package com.sltk.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltk.app.model.PaymentHeader;

@Repository
public interface PaymentDao extends JpaRepository<PaymentHeader, Long> {

}

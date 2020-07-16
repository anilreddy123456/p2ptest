package com.sltk.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltk.app.model.Account;
import com.sltk.app.model.Plant;

@Repository
public interface AccountDao extends JpaRepository<Account, String>{


}

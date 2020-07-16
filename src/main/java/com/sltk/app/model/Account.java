package com.sltk.app.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "account_group")
@NamedQueries({ @NamedQuery(name = "Account.findAll", query = "SELECT p FROM Account p"),
		@NamedQuery(name = "Account.findByAccountGroup", query = "SELECT p FROM Account p WHERE p.accountGroup = :accountGroup"),
		@NamedQuery(name = "Account.findByName", query = "SELECT p FROM Account p WHERE p.name = :name") })

public class Account {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "account_group")
	private String accountGroup;
	@Column(name = "name")
	private String name;

	public Account() {
		
	}
	public Account(String accountGroup) {
		this.accountGroup = accountGroup;
	}
	
	public Account(Long accountGroup) {
		this.accountGroup = String.valueOf(accountGroup);
	}
	public String getAccountGroup() {
		return accountGroup;
	}
	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Account [accountGroup=" + accountGroup + ", name=" + name + "]";
	}
	
	
}

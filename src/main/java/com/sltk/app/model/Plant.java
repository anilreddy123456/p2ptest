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
@Table(name = "plant")
@NamedQueries({ @NamedQuery(name = "Plant.findAll", query = "SELECT p FROM Plant p"),
		@NamedQuery(name = "Plant.findByPlant", query = "SELECT p FROM Plant p WHERE p.plant = :plant"),
		@NamedQuery(name = "Plant.findByName", query = "SELECT p FROM Plant p WHERE p.name = :name"),
		@NamedQuery(name = "Plant.findByAddress1", query = "SELECT p FROM Plant p WHERE p.address1 = :address1"),
		@NamedQuery(name = "Plant.findByAddress2", query = "SELECT p FROM Plant p WHERE p.address2 = :address2"),
		@NamedQuery(name = "Plant.findByCity", query = "SELECT p FROM Plant p WHERE p.city = :city"),
		@NamedQuery(name = "Plant.findByState", query = "SELECT p FROM Plant p WHERE p.state = :state"),
		@NamedQuery(name = "Plant.findByCountry", query = "SELECT p FROM Plant p WHERE p.country = :country"),
		@NamedQuery(name = "Plant.findByPostalcode", query = "SELECT p FROM Plant p WHERE p.postalcode = :postalcode") })
public class Plant {

	 private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "plant")
	private String plant;
	@Column(name = "")
	private String name;
	@Column(name = "")
	private String address1;
	@Column(name = "")
	private String address2;
	@Column(name = "")
	private String city;
	@Column(name = "")
	private String state;
	@Column(name = "")
	private String country;
	@Column(name = "")
	private long postalcode;

	public Plant() {

	}

	public Plant(String plant) {
		this.plant = plant;
	}

	public Plant(Long plant) {
		this.plant = String.valueOf(plant);
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(long postalcode) {
		this.postalcode = postalcode;
	}

	@Override
	public String toString() {
		return "Plant [plant=" + plant + ", name=" + name + ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", postalcode=" + postalcode + "]";
	}
	
	

}

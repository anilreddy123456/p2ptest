package com.sltk.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "prheader")
@NamedQueries({ @NamedQuery(name = "Prheader.findAll", query = "SELECT p FROM Prheader p"),
		@NamedQuery(name = "Prheader.findByPrNumber", query = "SELECT p FROM Prheader p WHERE p.prNumber = :prNumber"),
		@NamedQuery(name = "Prheader.findByPrDescription", query = "SELECT p FROM Prheader p WHERE p.prDescription = :prDescription") })
public class Prheader implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	
	@Column(name = "pr_number")
	private Long prNumber;
	@Column(name = "pr_description")
	private String prDescription;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prnumber")
	private List<PrlineItems> prlineItems;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pr_number")
	private List<Polineitems> pr_number;

	public Prheader() {
	}

	public Prheader(Long prNumber) {
		this.prNumber = prNumber;
	}

	public Prheader(String prNumber) {
		this.prNumber = Long.parseLong(prNumber);
	}

	public Long getPrNumber() {
		return prNumber;
	}

	public void setPrNumber(Long prNumber) {
		this.prNumber = prNumber;
	}

	public String getPrDescription() {
		return prDescription;
	}

	public void setPrDescription(String prDescription) {
		this.prDescription = prDescription;
	}

	public List<PrlineItems> getPrlineItems() {
		return prlineItems;
	}

	public void setPrlineItems(List<PrlineItems> prlineItems) {
		this.prlineItems = prlineItems;
	}

	public List<Polineitems> getPr_number() {
		return pr_number;
	}

	public void setPr_number(List<Polineitems> pr_number) {
		this.pr_number = pr_number;
	}

	@Override
	public String toString() {
		return "Prheader [prNumber=" + prNumber + ", prDescription=" + prDescription + ", prlineItems=" + prlineItems
				+ ", pr_number=" + pr_number + "]";
	}

}

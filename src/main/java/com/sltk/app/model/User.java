/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sltk.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status"),
    @NamedQuery(name = "User.findByMobileNo", query = "SELECT u FROM User u WHERE u.mobileNo = :mobileNo"),
    @NamedQuery(name = "User.findByFax", query = "SELECT u FROM User u WHERE u.fax = :fax"),
    @NamedQuery(name = "User.findByCreatedBy", query = "SELECT u FROM User u WHERE u.createdBy = :createdBy"),
    @NamedQuery(name = "User.findByCreatedDate", query = "SELECT u FROM User u WHERE u.createdDate = :createdDate"),
    @NamedQuery(name = "User.findByLastModifiedBy", query = "SELECT u FROM User u WHERE u.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "User.findByLastModifiedDate", query = "SELECT u FROM User u WHERE u.lastModifiedDate = :lastModifiedDate")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Column(name = "email")
    private String email;
    
    @Column(name = "user_name")
    private String userName;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "mobile_no")
    private String mobileNo;
    
    @Column(name = "fax")
    private String fax;
    
    @Column(name = "status")
    private short status = 1;
    
    @Column(name = "validFrom")
    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate validFrom;
    
    @Column(name = "ValidTo")
    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ValidTo;
    
    @Column(name = "created_by")
    private String createdBy;
    
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @Column(name = "last_modified_by")
    private String lastModifiedBy;
    
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    
    @JoinColumn(name = "comp_id", referencedColumnName = "comp_id")
    @ManyToOne
    private Company compId;
    
    @JoinColumn(name = "usertype_id", referencedColumnName = "usertype_id")
    @ManyToOne
    private UserTypes usertype;
    
    @JoinColumn(name = "vendor_id", referencedColumnName = "vendor_id")
    @ManyToOne
    private Vendor vendor;
    
    @Transient
    private String reEnterPassword;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String firstName, String lastName, String email, String password, short status) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getMobileNo()
	{
		return mobileNo;
	}

	public void setMobileNo(String mobileNo)
	{
		this.mobileNo = mobileNo;
	}

	public String getFax()
	{
		return fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	public LocalDate getValidFrom()
	{
		return validFrom;
	}

	public void setValidFrom(LocalDate validFrom)
	{
		this.validFrom = validFrom;
	}

	public LocalDate getValidTo()
	{
		return ValidTo;
	}

	public void setValidTo(LocalDate validTo)
	{
		ValidTo = validTo;
	}

	public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Company getCompId() {
        return compId;
    }

    public void setCompId(Company compId) {
        this.compId = compId;
    }

    public Vendor getVendor()
	{
		return vendor;
	}

	public void setVendor(Vendor vendor)
	{
		this.vendor = vendor;
	}

	public UserTypes getUsertype()
	{
		return usertype;
	}

	public void setUsertype(UserTypes usertype)
	{
		this.usertype = usertype;
	}

	public String getReEnterPassword()
	{
		return reEnterPassword;
	}

	public void setReEnterPassword(String reEnterPassword)
	{
		this.reEnterPassword = reEnterPassword;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sltk.app.entity.User[ userId=" + userId + " ]";
    }
    
}

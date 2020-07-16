/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sltk.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "vendor")
@NamedQueries({
    @NamedQuery(name = "Vendor.findAll", query = "SELECT v FROM Vendor v"),
    @NamedQuery(name = "Vendor.findByVendorId", query = "SELECT v FROM Vendor v WHERE v.vendorId = :vendorId"),
    @NamedQuery(name = "Vendor.findByVendorSapCode", query = "SELECT v FROM Vendor v WHERE v.vendorSapCode = :vendorSapCode"),
    @NamedQuery(name = "Vendor.findByVendorCompanyName", query = "SELECT v FROM Vendor v WHERE v.vendorCompanyName = :vendorCompanyName"),
    @NamedQuery(name = "Vendor.findByRigistrationNo", query = "SELECT v FROM Vendor v WHERE v.rigistrationNo = :rigistrationNo"),
    @NamedQuery(name = "Vendor.findByCompanyType", query = "SELECT v FROM Vendor v WHERE v.companyType = :companyType"),
    @NamedQuery(name = "Vendor.findByAddressLine1", query = "SELECT v FROM Vendor v WHERE v.addressLine1 = :addressLine1"),
    @NamedQuery(name = "Vendor.findByAddressLine2", query = "SELECT v FROM Vendor v WHERE v.addressLine2 = :addressLine2"),
    @NamedQuery(name = "Vendor.findByCity", query = "SELECT v FROM Vendor v WHERE v.city = :city"),
    @NamedQuery(name = "Vendor.findByState", query = "SELECT v FROM Vendor v WHERE v.state = :state"),
    @NamedQuery(name = "Vendor.findByPincode", query = "SELECT v FROM Vendor v WHERE v.pincode = :pincode"),
    @NamedQuery(name = "Vendor.findByCountry", query = "SELECT v FROM Vendor v WHERE v.country = :country"),
    @NamedQuery(name = "Vendor.findByGstNo", query = "SELECT v FROM Vendor v WHERE v.gstNo = :gstNo"),
    @NamedQuery(name = "Vendor.findByPan", query = "SELECT v FROM Vendor v WHERE v.pan = :pan"),
    @NamedQuery(name = "Vendor.findByOther", query = "SELECT v FROM Vendor v WHERE v.other = :other"),
    @NamedQuery(name = "Vendor.findBySalutation", query = "SELECT v FROM Vendor v WHERE v.salutation = :salutation"),
    @NamedQuery(name = "Vendor.findByFirstName", query = "SELECT v FROM Vendor v WHERE v.firstName = :firstName"),
    @NamedQuery(name = "Vendor.findByLastName", query = "SELECT v FROM Vendor v WHERE v.lastName = :lastName"),
    @NamedQuery(name = "Vendor.findByUserName", query = "SELECT v FROM Vendor v WHERE v.userName = :userName"),
    @NamedQuery(name = "Vendor.findByPhoneNo", query = "SELECT v FROM Vendor v WHERE v.phoneNo = :phoneNo"),
    @NamedQuery(name = "Vendor.findByMobileNo", query = "SELECT v FROM Vendor v WHERE v.mobileNo = :mobileNo"),
    @NamedQuery(name = "Vendor.findByEmailId", query = "SELECT v FROM Vendor v WHERE v.emailId = :emailId"),
    @NamedQuery(name = "Vendor.findByAccHolderName", query = "SELECT v FROM Vendor v WHERE v.accHolderName = :accHolderName"),
    @NamedQuery(name = "Vendor.findByAccountNo", query = "SELECT v FROM Vendor v WHERE v.accountNo = :accountNo"),
    @NamedQuery(name = "Vendor.findByBankName", query = "SELECT v FROM Vendor v WHERE v.bankName = :bankName"),
    @NamedQuery(name = "Vendor.findByBranchName", query = "SELECT v FROM Vendor v WHERE v.branchName = :branchName"),
    @NamedQuery(name = "Vendor.findByIfscCode", query = "SELECT v FROM Vendor v WHERE v.ifscCode = :ifscCode"),
    @NamedQuery(name = "Vendor.findByBankCountry", query = "SELECT v FROM Vendor v WHERE v.bankCountry = :bankCountry"),
    @NamedQuery(name = "Vendor.findByBankRegion", query = "SELECT v FROM Vendor v WHERE v.bankRegion = :bankRegion"),
    @NamedQuery(name = "Vendor.findByBankCity", query = "SELECT v FROM Vendor v WHERE v.bankCity = :bankCity"),
    @NamedQuery(name = "Vendor.findByProductionServices", query = "SELECT v FROM Vendor v WHERE v.productionServices = :productionServices"),
    @NamedQuery(name = "Vendor.findByFax", query = "SELECT v FROM Vendor v WHERE v.fax = :fax"),
    @NamedQuery(name = "Vendor.findByAltFax", query = "SELECT v FROM Vendor v WHERE v.altFax = :altFax"),
    @NamedQuery(name = "Vendor.findByAltFirstName", query = "SELECT v FROM Vendor v WHERE v.altFirstName = :altFirstName"),
    @NamedQuery(name = "Vendor.findByAltLastName", query = "SELECT v FROM Vendor v WHERE v.altLastName = :altLastName"),
    @NamedQuery(name = "Vendor.findByAltPhoneNo", query = "SELECT v FROM Vendor v WHERE v.altPhoneNo = :altPhoneNo"),
    @NamedQuery(name = "Vendor.findByAltMobileNo", query = "SELECT v FROM Vendor v WHERE v.altMobileNo = :altMobileNo"),
    @NamedQuery(name = "Vendor.findByAltEmailId", query = "SELECT v FROM Vendor v WHERE v.altEmailId = :altEmailId"),
    @NamedQuery(name = "Vendor.findByPassword", query = "SELECT v FROM Vendor v WHERE v.password = :password"),
    @NamedQuery(name = "Vendor.findByStatus", query = "SELECT v FROM Vendor v WHERE v.status = :status")})
public class Vendor implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    private Integer vendorId;
    
    @Column(name = "vendor_sap_code")
    private String vendorSapCode;
    
    @Column(name = "vendor_company_name")
    private String vendorCompanyName;
    
    @Column(name = "rigistration_no")
    private String rigistrationNo;
    
    @Column(name = "company_type")
    private String companyType;
    
    @Column(name = "address_line1")
    private String addressLine1;
    
    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "country")
    private String country;

    @Column(name = "gst_no")
    private String gstNo;

    @Column(name = "pan")
    private String pan;

    @Column(name = "other")
    private String other;

    @Column(name = "salutation")
    private String salutation;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "acc_holder_name")
    private String accHolderName;
    
    @Column(name = "account_no")
    private String accountNo;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @Column(name = "bank_country")
    private String bankCountry;

    @Column(name = "bank_region")
    private String bankRegion;

    @Column(name = "bank_city")
    private String bankCity;

    @Column(name = "production_services")
    private String productionServices;
    
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Column(name = "fax")
    private String fax;

    @Column(name = "alt_fax")
    private String altFax;

    @Column(name = "alt_first_name")
    private String altFirstName;

    @Column(name = "alt_last_name")
    private String altLastName;

    @Column(name = "alt_phone_no")
    private String altPhoneNo;

    @Column(name = "alt_mobile_no")
    private String altMobileNo;

    @Column(name = "alt_email_id")
    private String altEmailId;

    @Column(name = "password")
    private String password = "tree123";

    @Column(name = "status")
    private short status;
    
    @Column(name = "approval_status")
    private short approvalStatus = 0;
    
    /**
    @JoinColumns({
        @JoinColumn(name = "comp_id", referencedColumnName = "comp_id"),
        @JoinColumn(name = "comp_id", referencedColumnName = "comp_id")})
    **/
    @ManyToOne
    @JoinColumn(name = "comp_id", referencedColumnName = "comp_id")
    private Company company;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor")
    private List<User> userList;


    public Vendor() {
    }

    public Vendor(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorSapCode() {
        return vendorSapCode;
    }

    public void setVendorSapCode(String vendorSapCode) {
        this.vendorSapCode = vendorSapCode;
    }

    public String getVendorCompanyName() {
        return vendorCompanyName;
    }

    public void setVendorCompanyName(String vendorCompanyName) {
        this.vendorCompanyName = vendorCompanyName;
    }

    public String getRigistrationNo() {
        return rigistrationNo;
    }

    public void setRigistrationNo(String rigistrationNo) {
        this.rigistrationNo = rigistrationNo;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public String getBankRegion() {
        return bankRegion;
    }

    public void setBankRegion(String bankRegion) {
        this.bankRegion = bankRegion;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public String getProductionServices() {
        return productionServices;
    }

    public void setProductionServices(String productionServices) {
        this.productionServices = productionServices;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAltFax() {
        return altFax;
    }

    public void setAltFax(String altFax) {
        this.altFax = altFax;
    }

    public String getAltFirstName() {
        return altFirstName;
    }

    public void setAltFirstName(String altFirstName) {
        this.altFirstName = altFirstName;
    }

    public String getAltLastName() {
        return altLastName;
    }

    public void setAltLastName(String altLastName) {
        this.altLastName = altLastName;
    }

    public String getAltPhoneNo() {
        return altPhoneNo;
    }

    public void setAltPhoneNo(String altPhoneNo) {
        this.altPhoneNo = altPhoneNo;
    }

    public String getAltMobileNo() {
        return altMobileNo;
    }

    public void setAltMobileNo(String altMobileNo) {
        this.altMobileNo = altMobileNo;
    }

    public String getAltEmailId() {
        return altEmailId;
    }

    public void setAltEmailId(String altEmailId) {
        this.altEmailId = altEmailId;
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

    public short getApprovalStatus()
	{
		return approvalStatus;
	}

	public void setApprovalStatus(short approvalStatus)
	{
		this.approvalStatus = approvalStatus;
	}
    
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<User> getUserList()
	{
		return userList;
	}

	public void setUserList(List<User> userList)
	{
		this.userList = userList;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorId != null ? vendorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendor)) {
            return false;
        }
        Vendor other = (Vendor) object;
        if ((this.vendorId == null && other.vendorId != null) || (this.vendorId != null && !this.vendorId.equals(other.vendorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sltk.app.entity.Vendor[ vendorId=" + vendorId + " ]";
    }
    
}

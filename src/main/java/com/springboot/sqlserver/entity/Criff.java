package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "criff")
public class Criff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sno")
	private int sno;

	private String cibilid,firstName,last_name,ph,gender,kyctypeId,kycdocno,
	kyctypeId2,kycdocno2,address1,address2,city,state,pincode,requiredamount,
	criffUrl,criffXmlUrl,customerType,appname,status,rem_1,rem_2,rem_3;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getCibilid() {
		return cibilid;
	}

	public void setCibilid(String cibilid) {
		this.cibilid = cibilid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getKyctypeId() {
		return kyctypeId;
	}

	public void setKyctypeId(String kyctypeId) {
		this.kyctypeId = kyctypeId;
	}

	public String getKycdocno() {
		return kycdocno;
	}

	public void setKycdocno(String kycdocno) {
		this.kycdocno = kycdocno;
	}

	public String getKyctypeId2() {
		return kyctypeId2;
	}

	public void setKyctypeId2(String kyctypeId2) {
		this.kyctypeId2 = kyctypeId2;
	}

	public String getKycdocno2() {
		return kycdocno2;
	}

	public void setKycdocno2(String kycdocno2) {
		this.kycdocno2 = kycdocno2;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getRequiredamount() {
		return requiredamount;
	}

	public void setRequiredamount(String requiredamount) {
		this.requiredamount = requiredamount;
	}

	public String getCriffUrl() {
		return criffUrl;
	}

	public void setCriffUrl(String criffUrl) {
		this.criffUrl = criffUrl;
	}

	public String getCriffXmlUrl() {
		return criffXmlUrl;
	}

	public void setCriffXmlUrl(String criffXmlUrl) {
		this.criffXmlUrl = criffXmlUrl;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRem_1() {
		return rem_1;
	}

	public void setRem_1(String rem_1) {
		this.rem_1 = rem_1;
	}

	public String getRem_2() {
		return rem_2;
	}

	public void setRem_2(String rem_2) {
		this.rem_2 = rem_2;
	}

	public String getRem_3() {
		return rem_3;
	}

	public void setRem_3(String rem_3) {
		this.rem_3 = rem_3;
	}

	@Override
	public String toString() {
		return "Criff [sno=" + sno + ", cibilid=" + cibilid + ", firstName=" + firstName + ", last_name=" + last_name
				+ ", ph=" + ph + ", gender=" + gender + ", kyctypeId=" + kyctypeId + ", kycdocno=" + kycdocno
				+ ", kyctypeId2=" + kyctypeId2 + ", kycdocno2=" + kycdocno2 + ", address1=" + address1 + ", address2="
				+ address2 + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", requiredamount="
				+ requiredamount + ", criffUrl=" + criffUrl + ", criffXmlUrl=" + criffXmlUrl + ", customerType="
				+ customerType + ", appname=" + appname + "]";
	}
	

}

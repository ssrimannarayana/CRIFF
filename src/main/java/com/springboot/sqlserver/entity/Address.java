package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "request_address")
public class Address {
	@Id
	@Column(name = "adno")
	private int adno;
	
	private int reqno;
	
	private  String refId, aDDRESS,timestamp;

	public Integer getAdno() {
		return adno;
	}

	public void setAdno(Integer adno) {
		this.adno = adno;
	}

	public Integer getReqno() {
		return reqno;
	}

	public void setReqno(Integer reqno) {
		this.reqno = reqno;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getaDDRESS() {
		return aDDRESS;
	}

	public void setaDDRESS(String aDDRESS) {
		this.aDDRESS = aDDRESS;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Address [adno=" + adno + ", reqno=" + reqno + ", refId=" + refId + ", aDDRESS=" + aDDRESS
				+ ", timestamp=" + timestamp + "]";
	}
}

package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alerts")
public class Alerts {

	@Id
	@Column(name = "ano")
	private int sno;
	
	private String refId,timestamp;

	private String aLERT_dESC;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getaLERT_dESC() {
		return aLERT_dESC;
	}

	public void setaLERT_dESC(String aLERT_dESC) {
		this.aLERT_dESC = aLERT_dESC;
	}

	@Override
	public String toString() {
		return "Alerts [sno=" + sno + ", refId=" + refId + ", timestamp=" + timestamp + ", aLERT_dESC=" + aLERT_dESC
				+ "]";
	}
	
}

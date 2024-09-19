package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "printable")
public class PrintableReportPojo {
	@Id
	@Column(name = "pno")
	private int pno;
	
	private String tYPE, fILE_nAME;
	private String refId,timestamp;
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String gettYPE() {
		return tYPE;
	}
	public void settYPE(String tYPE) {
		this.tYPE = tYPE;
	}
	public String getfILE_nAME() {
		return fILE_nAME;
	}
	public void setfILE_nAME(String fILE_nAME) {
		this.fILE_nAME = fILE_nAME;
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
	@Override
	public String toString() {
		return "PrintableReportPojo [pno=" + pno + ", tYPE=" + tYPE + ", fILE_nAME=" + fILE_nAME + ", refId=" + refId
				+ ", timestamp=" + timestamp + "]";
	}

}

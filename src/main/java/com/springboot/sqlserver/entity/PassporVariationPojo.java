package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "passport_variation")
public class PassporVariationPojo {
	@Id
	@Column(name = "ppno")
	private int ppno;
	
	private String refId,timestamp;
	private String value,reportedDate;
	public int getPpno() {
		return ppno;
	}
	public void setPpno(int ppno) {
		this.ppno = ppno;
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getReportedDate() {
		return reportedDate;
	}
	public void setReportedDate(String reportedDate) {
		this.reportedDate = reportedDate;
	}
	@Override
	public String toString() {
		return "PassporVariationPojo [ppno=" + ppno + ", refId=" + refId + ", timestamp=" + timestamp + ", value="
				+ value + ", reportedDate=" + reportedDate + "]";
	}
}

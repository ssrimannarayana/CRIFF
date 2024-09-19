package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dob_variation")
public class DobVariationPojo {
	@Id
	@Column(name = "dno")
	private int dno;
	
	private String refId,timestamp;

	private String value,reportedDate;

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
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
		return "DobVariationPojo [dno=" + dno + ", refId=" + refId + ", timestamp=" + timestamp + ", value=" + value
				+ ", reportedDate=" + reportedDate + "]";
	}
	
}

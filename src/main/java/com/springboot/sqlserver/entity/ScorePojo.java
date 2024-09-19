package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Scores")
public class ScorePojo {
	@Id
	@Column(name = "sid")
	private int sid;
	
	private String refId,timestamp;
	private String sCORE_tYPE,sCORE_vALUE,sCORE_fACTORS,sFACTOR1,sFACTOR2,sFACTOR3,sFACTOR4;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public String getsCORE_tYPE() {
		return sCORE_tYPE;
	}
	public void setsCORE_tYPE(String sCORE_tYPE) {
		this.sCORE_tYPE = sCORE_tYPE;
	}
	public String getsCORE_vALUE() {
		return sCORE_vALUE;
	}
	public void setsCORE_vALUE(String sCORE_vALUE) {
		this.sCORE_vALUE = sCORE_vALUE;
	}
	public String getsCORE_fACTORS() {
		return sCORE_fACTORS;
	}
	public void setsCORE_fACTORS(String sCORE_fACTORS) {
		this.sCORE_fACTORS = sCORE_fACTORS;
	}
	public String getsFACTOR1() {
		return sFACTOR1;
	}
	public void setsFACTOR1(String sFACTOR1) {
		this.sFACTOR1 = sFACTOR1;
	}
	public String getsFACTOR2() {
		return sFACTOR2;
	}
	public void setsFACTOR2(String sFACTOR2) {
		this.sFACTOR2 = sFACTOR2;
	}
	public String getsFACTOR3() {
		return sFACTOR3;
	}
	public void setsFACTOR3(String sFACTOR3) {
		this.sFACTOR3 = sFACTOR3;
	}
	public String getsFACTOR4() {
		return sFACTOR4;
	}
	public void setsFACTOR4(String sFACTOR4) {
		this.sFACTOR4 = sFACTOR4;
	}
	@Override
	public String toString() {
		return "ScorePojo [sid=" + sid + ", refId=" + refId + ", timestamp=" + timestamp + ", sCORE_tYPE=" + sCORE_tYPE
				+ ", sCORE_vALUE=" + sCORE_vALUE + ", sCORE_fACTORS=" + sCORE_fACTORS + ", sFACTOR1=" + sFACTOR1
				+ ", sFACTOR2=" + sFACTOR2 + ", sFACTOR3=" + sFACTOR3 + ", sFACTOR4=" + sFACTOR4 + "]";
	}
}

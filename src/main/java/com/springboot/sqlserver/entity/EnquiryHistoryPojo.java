package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "enquiry_history")
public class EnquiryHistoryPojo {

	@Id
	@Column(name = "eno")
	private int eno;
	
	private String refid,mEMBER_nAME,iNQUIRY_dATE,pURPOSE,aMOUNT,rEMARK,timestamp;

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getRefid() {
		return refid;
	}

	public void setRefid(String refid) {
		this.refid = refid;
	}

	public String getmEMBER_nAME() {
		return mEMBER_nAME;
	}

	public void setmEMBER_nAME(String mEMBER_nAME) {
		this.mEMBER_nAME = mEMBER_nAME;
	}

	public String getiNQUIRY_dATE() {
		return iNQUIRY_dATE;
	}

	public void setiNQUIRY_dATE(String iNQUIRY_dATE) {
		this.iNQUIRY_dATE = iNQUIRY_dATE;
	}

	public String getpURPOSE() {
		return pURPOSE;
	}

	public void setpURPOSE(String pURPOSE) {
		this.pURPOSE = pURPOSE;
	}

	public String getaMOUNT() {
		return aMOUNT;
	}

	public void setaMOUNT(String aMOUNT) {
		this.aMOUNT = aMOUNT;
	}

	public String getrEMARK() {
		return rEMARK;
	}

	public void setrEMARK(String rEMARK) {
		this.rEMARK = rEMARK;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "EnquiryHistoryPojo [eno=" + eno + ", refid=" + refid + ", mEMBER_nAME=" + mEMBER_nAME
				+ ", iNQUIRY_dATE=" + iNQUIRY_dATE + ", pURPOSE=" + pURPOSE + ", aMOUNT=" + aMOUNT + ", rEMARK="
				+ rEMARK + ", timestamp=" + timestamp + "]";
	}
	
}

package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StatusDetails")
public class StatusDetails {

	@Id
	@Column(name = "sNo")
	private int sNo;

	private String refid, oPTIONS, oPTION_sTATUS, eRRORS, tIMEtIME_sTAMP;

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	
	public String getRefid() {
		return refid;
	}

	public void setRefid(String refid) {
		this.refid = refid;
	}

	public String getoPTIONS() {
		return oPTIONS;
	}

	public void setoPTIONS(String oPTIONS) {
		this.oPTIONS = oPTIONS;
	}

	public String getoPTION_sTATUS() {
		return oPTION_sTATUS;
	}

	public void setoPTION_sTATUS(String oPTION_sTATUS) {
		this.oPTION_sTATUS = oPTION_sTATUS;
	}

	public String geteRRORS() {
		return eRRORS;
	}

	public void seteRRORS(String eRRORS) {
		this.eRRORS = eRRORS;
	}

	public String gettIMEtIME_sTAMP() {
		return tIMEtIME_sTAMP;
	}

	public void settIMEtIME_sTAMP(String tIMEtIME_sTAMP) {
		this.tIMEtIME_sTAMP = tIMEtIME_sTAMP;
	}

	@Override
	public String toString() {
		return "StatusDetails [sNo=" + sNo + ", rEFID=" + refid + ", oPTION=" + oPTIONS + ", oPTION_sTATUS="
				+ oPTION_sTATUS + ", eRRORS=" + eRRORS + ", tIMEtIME_sTAMP=" + tIMEtIME_sTAMP + "]";
	}

}

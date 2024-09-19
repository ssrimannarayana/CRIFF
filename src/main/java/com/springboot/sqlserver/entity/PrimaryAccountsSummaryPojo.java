package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "primary_account_summary")
public class PrimaryAccountsSummaryPojo {
	@Id
	@Column(name = "pno")
	private int pno;
	
	private String refId,timestamp;
	private String pRIMARY_nUMBER_oF_aCCOUNTS,
	pRIMARY_aCTIVE_nUMBER_oF_aCCOUNTS,
	pRIMARY_oVERDUE_nUMBER_oF_aCCOUNTS,
	pRIMARY_sECURED_nUMBER_oF_aCCOUNTS,
	pRIMARY_uNSECURED_nUMBER_oF_aCCOUNTS,
	pRIMARY_uNTAGGED_nUMBER_oF_aCCOUNTS,
	pRIMARY_cURRENT_bALANCE,
	pRIMARY_sANCTIONED_aMOUNT,
	pRIMARY_dISBURSED_aMOUNT;
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
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
	public String getpRIMARY_nUMBER_oF_aCCOUNTS() {
		return pRIMARY_nUMBER_oF_aCCOUNTS;
	}
	public void setpRIMARY_nUMBER_oF_aCCOUNTS(String pRIMARY_nUMBER_oF_aCCOUNTS) {
		this.pRIMARY_nUMBER_oF_aCCOUNTS = pRIMARY_nUMBER_oF_aCCOUNTS;
	}
	public String getpRIMARY_aCTIVE_nUMBER_oF_aCCOUNTS() {
		return pRIMARY_aCTIVE_nUMBER_oF_aCCOUNTS;
	}
	public void setpRIMARY_aCTIVE_nUMBER_oF_aCCOUNTS(String pRIMARY_aCTIVE_nUMBER_oF_aCCOUNTS) {
		this.pRIMARY_aCTIVE_nUMBER_oF_aCCOUNTS = pRIMARY_aCTIVE_nUMBER_oF_aCCOUNTS;
	}
	public String getpRIMARY_oVERDUE_nUMBER_oF_aCCOUNTS() {
		return pRIMARY_oVERDUE_nUMBER_oF_aCCOUNTS;
	}
	public void setpRIMARY_oVERDUE_nUMBER_oF_aCCOUNTS(String pRIMARY_oVERDUE_nUMBER_oF_aCCOUNTS) {
		this.pRIMARY_oVERDUE_nUMBER_oF_aCCOUNTS = pRIMARY_oVERDUE_nUMBER_oF_aCCOUNTS;
	}
	public String getpRIMARY_sECURED_nUMBER_oF_aCCOUNTS() {
		return pRIMARY_sECURED_nUMBER_oF_aCCOUNTS;
	}
	public void setpRIMARY_sECURED_nUMBER_oF_aCCOUNTS(String pRIMARY_sECURED_nUMBER_oF_aCCOUNTS) {
		this.pRIMARY_sECURED_nUMBER_oF_aCCOUNTS = pRIMARY_sECURED_nUMBER_oF_aCCOUNTS;
	}
	public String getpRIMARY_uNSECURED_nUMBER_oF_aCCOUNTS() {
		return pRIMARY_uNSECURED_nUMBER_oF_aCCOUNTS;
	}
	public void setpRIMARY_uNSECURED_nUMBER_oF_aCCOUNTS(String pRIMARY_uNSECURED_nUMBER_oF_aCCOUNTS) {
		this.pRIMARY_uNSECURED_nUMBER_oF_aCCOUNTS = pRIMARY_uNSECURED_nUMBER_oF_aCCOUNTS;
	}
	public String getpRIMARY_uNTAGGED_nUMBER_oF_aCCOUNTS() {
		return pRIMARY_uNTAGGED_nUMBER_oF_aCCOUNTS;
	}
	public void setpRIMARY_uNTAGGED_nUMBER_oF_aCCOUNTS(String pRIMARY_uNTAGGED_nUMBER_oF_aCCOUNTS) {
		this.pRIMARY_uNTAGGED_nUMBER_oF_aCCOUNTS = pRIMARY_uNTAGGED_nUMBER_oF_aCCOUNTS;
	}
	public String getpRIMARY_cURRENT_bALANCE() {
		return pRIMARY_cURRENT_bALANCE;
	}
	public void setpRIMARY_cURRENT_bALANCE(String pRIMARY_cURRENT_bALANCE) {
		this.pRIMARY_cURRENT_bALANCE = pRIMARY_cURRENT_bALANCE;
	}
	public String getpRIMARY_sANCTIONED_aMOUNT() {
		return pRIMARY_sANCTIONED_aMOUNT;
	}
	public void setpRIMARY_sANCTIONED_aMOUNT(String pRIMARY_sANCTIONED_aMOUNT) {
		this.pRIMARY_sANCTIONED_aMOUNT = pRIMARY_sANCTIONED_aMOUNT;
	}
	public String getpRIMARY_dISBURSED_aMOUNT() {
		return pRIMARY_dISBURSED_aMOUNT;
	}
	public void setpRIMARY_dISBURSED_aMOUNT(String pRIMARY_dISBURSED_aMOUNT) {
		this.pRIMARY_dISBURSED_aMOUNT = pRIMARY_dISBURSED_aMOUNT;
	}
	@Override
	public String toString() {
		return "PrimaryAccountsSummaryPojo [pno=" + pno + ", refId=" + refId + ", timestamp=" + timestamp
				+ ", pRIMARY_nUMBER_oF_aCCOUNTS=" + pRIMARY_nUMBER_oF_aCCOUNTS + ", pRIMARY_aCTIVE_nUMBER_oF_aCCOUNTS="
				+ pRIMARY_aCTIVE_nUMBER_oF_aCCOUNTS + ", pRIMARY_oVERDUE_nUMBER_oF_aCCOUNTS="
				+ pRIMARY_oVERDUE_nUMBER_oF_aCCOUNTS + ", pRIMARY_sECURED_nUMBER_oF_aCCOUNTS="
				+ pRIMARY_sECURED_nUMBER_oF_aCCOUNTS + ", pRIMARY_uNSECURED_nUMBER_oF_aCCOUNTS="
				+ pRIMARY_uNSECURED_nUMBER_oF_aCCOUNTS + ", pRIMARY_uNTAGGED_nUMBER_oF_aCCOUNTS="
				+ pRIMARY_uNTAGGED_nUMBER_oF_aCCOUNTS + ", pRIMARY_cURRENT_bALANCE=" + pRIMARY_cURRENT_bALANCE
				+ ", pRIMARY_sANCTIONED_aMOUNT=" + pRIMARY_sANCTIONED_aMOUNT + ", pRIMARY_dISBURSED_aMOUNT="
				+ pRIMARY_dISBURSED_aMOUNT + "]";
	}
	
}

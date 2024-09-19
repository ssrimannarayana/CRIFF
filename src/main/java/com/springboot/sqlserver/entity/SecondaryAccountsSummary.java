package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "secondary_account_summary")
public class SecondaryAccountsSummary {
	@Id
	@Column(name = "sano")
	private int sano;
	
	private String refId,timestamp;
	
	private String sECONDARY_nUMBER_oF_aCCOUNTS, sECONDARY_aCTIVE_nUMBER_oF_aCCOUNTS,
			sECONDARY_oVERDUE_nUMBER_oF_aCCOUNTS, sECONDARY_sECURED_nUMBER_oF_aCCOUNTS,
			sECONDARY_uNSECURED_nUMBER_oF_aCCOUNTS, sECONDARY_uNTAGGED_nUMBER_oF_aCCOUNTS, sECONDARY_cURRENT_bALANCE,
			sECONDARY_sANCTIONED_aMOUNT, sECONDARY_dISBURSED_aMOUNT;

	public int getSano() {
		return sano;
	}

	public void setSano(int sano) {
		this.sano = sano;
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

	public String getsECONDARY_nUMBER_oF_aCCOUNTS() {
		return sECONDARY_nUMBER_oF_aCCOUNTS;
	}

	public void setsECONDARY_nUMBER_oF_aCCOUNTS(String sECONDARY_nUMBER_oF_aCCOUNTS) {
		this.sECONDARY_nUMBER_oF_aCCOUNTS = sECONDARY_nUMBER_oF_aCCOUNTS;
	}

	public String getsECONDARY_aCTIVE_nUMBER_oF_aCCOUNTS() {
		return sECONDARY_aCTIVE_nUMBER_oF_aCCOUNTS;
	}

	public void setsECONDARY_aCTIVE_nUMBER_oF_aCCOUNTS(String sECONDARY_aCTIVE_nUMBER_oF_aCCOUNTS) {
		this.sECONDARY_aCTIVE_nUMBER_oF_aCCOUNTS = sECONDARY_aCTIVE_nUMBER_oF_aCCOUNTS;
	}

	public String getsECONDARY_oVERDUE_nUMBER_oF_aCCOUNTS() {
		return sECONDARY_oVERDUE_nUMBER_oF_aCCOUNTS;
	}

	public void setsECONDARY_oVERDUE_nUMBER_oF_aCCOUNTS(String sECONDARY_oVERDUE_nUMBER_oF_aCCOUNTS) {
		this.sECONDARY_oVERDUE_nUMBER_oF_aCCOUNTS = sECONDARY_oVERDUE_nUMBER_oF_aCCOUNTS;
	}

	public String getsECONDARY_sECURED_nUMBER_oF_aCCOUNTS() {
		return sECONDARY_sECURED_nUMBER_oF_aCCOUNTS;
	}

	public void setsECONDARY_sECURED_nUMBER_oF_aCCOUNTS(String sECONDARY_sECURED_nUMBER_oF_aCCOUNTS) {
		this.sECONDARY_sECURED_nUMBER_oF_aCCOUNTS = sECONDARY_sECURED_nUMBER_oF_aCCOUNTS;
	}

	public String getsECONDARY_uNSECURED_nUMBER_oF_aCCOUNTS() {
		return sECONDARY_uNSECURED_nUMBER_oF_aCCOUNTS;
	}

	public void setsECONDARY_uNSECURED_nUMBER_oF_aCCOUNTS(String sECONDARY_uNSECURED_nUMBER_oF_aCCOUNTS) {
		this.sECONDARY_uNSECURED_nUMBER_oF_aCCOUNTS = sECONDARY_uNSECURED_nUMBER_oF_aCCOUNTS;
	}

	public String getsECONDARY_uNTAGGED_nUMBER_oF_aCCOUNTS() {
		return sECONDARY_uNTAGGED_nUMBER_oF_aCCOUNTS;
	}

	public void setsECONDARY_uNTAGGED_nUMBER_oF_aCCOUNTS(String sECONDARY_uNTAGGED_nUMBER_oF_aCCOUNTS) {
		this.sECONDARY_uNTAGGED_nUMBER_oF_aCCOUNTS = sECONDARY_uNTAGGED_nUMBER_oF_aCCOUNTS;
	}

	public String getsECONDARY_cURRENT_bALANCE() {
		return sECONDARY_cURRENT_bALANCE;
	}

	public void setsECONDARY_cURRENT_bALANCE(String sECONDARY_cURRENT_bALANCE) {
		this.sECONDARY_cURRENT_bALANCE = sECONDARY_cURRENT_bALANCE;
	}

	public String getsECONDARY_sANCTIONED_aMOUNT() {
		return sECONDARY_sANCTIONED_aMOUNT;
	}

	public void setsECONDARY_sANCTIONED_aMOUNT(String sECONDARY_sANCTIONED_aMOUNT) {
		this.sECONDARY_sANCTIONED_aMOUNT = sECONDARY_sANCTIONED_aMOUNT;
	}

	public String getsECONDARY_dISBURSED_aMOUNT() {
		return sECONDARY_dISBURSED_aMOUNT;
	}

	public void setsECONDARY_dISBURSED_aMOUNT(String sECONDARY_dISBURSED_aMOUNT) {
		this.sECONDARY_dISBURSED_aMOUNT = sECONDARY_dISBURSED_aMOUNT;
	}

	@Override
	public String toString() {
		return "SecondaryAccountsSummary [sano=" + sano + ", refId=" + refId + ", timestamp=" + timestamp
				+ ", sECONDARY_nUMBER_oF_aCCOUNTS=" + sECONDARY_nUMBER_oF_aCCOUNTS
				+ ", sECONDARY_aCTIVE_nUMBER_oF_aCCOUNTS=" + sECONDARY_aCTIVE_nUMBER_oF_aCCOUNTS
				+ ", sECONDARY_oVERDUE_nUMBER_oF_aCCOUNTS=" + sECONDARY_oVERDUE_nUMBER_oF_aCCOUNTS
				+ ", sECONDARY_sECURED_nUMBER_oF_aCCOUNTS=" + sECONDARY_sECURED_nUMBER_oF_aCCOUNTS
				+ ", sECONDARY_uNSECURED_nUMBER_oF_aCCOUNTS=" + sECONDARY_uNSECURED_nUMBER_oF_aCCOUNTS
				+ ", sECONDARY_uNTAGGED_nUMBER_oF_aCCOUNTS=" + sECONDARY_uNTAGGED_nUMBER_oF_aCCOUNTS
				+ ", sECONDARY_cURRENT_bALANCE=" + sECONDARY_cURRENT_bALANCE + ", sECONDARY_sANCTIONED_aMOUNT="
				+ sECONDARY_sANCTIONED_aMOUNT + ", sECONDARY_dISBURSED_aMOUNT=" + sECONDARY_dISBURSED_aMOUNT + "]";
	}

	

}

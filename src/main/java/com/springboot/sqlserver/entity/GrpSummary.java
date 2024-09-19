package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grp_summary")
public class GrpSummary {
	@Id
	@Column(name = "gsno")
	private int gsno;
	
	private String refId,timestamp;
	private String sTATUS, tOTAL_rESPONSES, nO_oF_oTHER_mFIS, nO_oF_dEFAULT_aCCOUNTS, oWN_mFI_iNDECATOR,
			nO_oF_cLOSED_aCCOUNTS, nO_oF_aCTIVE_aCCOUNTS, nO_oF_oWN_mFIS;
	public int getGsno() {
		return gsno;
	}
	public void setGsno(int gsno) {
		this.gsno = gsno;
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
	public String getsTATUS() {
		return sTATUS;
	}
	public void setsTATUS(String sTATUS) {
		this.sTATUS = sTATUS;
	}
	public String gettOTAL_rESPONSES() {
		return tOTAL_rESPONSES;
	}
	public void settOTAL_rESPONSES(String tOTAL_rESPONSES) {
		this.tOTAL_rESPONSES = tOTAL_rESPONSES;
	}
	public String getnO_oF_oTHER_mFIS() {
		return nO_oF_oTHER_mFIS;
	}
	public void setnO_oF_oTHER_mFIS(String nO_oF_oTHER_mFIS) {
		this.nO_oF_oTHER_mFIS = nO_oF_oTHER_mFIS;
	}
	public String getnO_oF_dEFAULT_aCCOUNTS() {
		return nO_oF_dEFAULT_aCCOUNTS;
	}
	public void setnO_oF_dEFAULT_aCCOUNTS(String nO_oF_dEFAULT_aCCOUNTS) {
		this.nO_oF_dEFAULT_aCCOUNTS = nO_oF_dEFAULT_aCCOUNTS;
	}
	public String getoWN_mFI_iNDECATOR() {
		return oWN_mFI_iNDECATOR;
	}
	public void setoWN_mFI_iNDECATOR(String oWN_mFI_iNDECATOR) {
		this.oWN_mFI_iNDECATOR = oWN_mFI_iNDECATOR;
	}
	public String getnO_oF_cLOSED_aCCOUNTS() {
		return nO_oF_cLOSED_aCCOUNTS;
	}
	public void setnO_oF_cLOSED_aCCOUNTS(String nO_oF_cLOSED_aCCOUNTS) {
		this.nO_oF_cLOSED_aCCOUNTS = nO_oF_cLOSED_aCCOUNTS;
	}
	public String getnO_oF_aCTIVE_aCCOUNTS() {
		return nO_oF_aCTIVE_aCCOUNTS;
	}
	public void setnO_oF_aCTIVE_aCCOUNTS(String nO_oF_aCTIVE_aCCOUNTS) {
		this.nO_oF_aCTIVE_aCCOUNTS = nO_oF_aCTIVE_aCCOUNTS;
	}
	public String getnO_oF_oWN_mFIS() {
		return nO_oF_oWN_mFIS;
	}
	public void setnO_oF_oWN_mFIS(String nO_oF_oWN_mFIS) {
		this.nO_oF_oWN_mFIS = nO_oF_oWN_mFIS;
	}
	@Override
	public String toString() {
		return "GrpSummary [gsno=" + gsno + ", refId=" + refId + ", timestamp=" + timestamp + ", sTATUS=" + sTATUS
				+ ", tOTAL_rESPONSES=" + tOTAL_rESPONSES + ", nO_oF_oTHER_mFIS=" + nO_oF_oTHER_mFIS
				+ ", nO_oF_dEFAULT_aCCOUNTS=" + nO_oF_dEFAULT_aCCOUNTS + ", oWN_mFI_iNDECATOR=" + oWN_mFI_iNDECATOR
				+ ", nO_oF_cLOSED_aCCOUNTS=" + nO_oF_cLOSED_aCCOUNTS + ", nO_oF_aCTIVE_aCCOUNTS="
				+ nO_oF_aCTIVE_aCCOUNTS + ", nO_oF_oWN_mFIS=" + nO_oF_oWN_mFIS + "]";
	}

}

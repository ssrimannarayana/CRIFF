package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grp_secondary")
public class GrpSecondarySummary {

	@Id
	@Column(name = "grpsno")
	private int grpsno;
	
	private String refId,timestamp;
	
	private String nO_oF_dEFAULT_aCCOUNTS, tOTAL_rESPONSES, nO_oF_cLOSED_aCCOUNTS, nO_oF_aCTIVE_aCCOUNTS,
			nO_oF_oTHER_mFIS, nO_oF_oWN_mFIS;

	public int getGrpsno() {
		return grpsno;
	}

	public void setGrpsno(int grpsno) {
		this.grpsno = grpsno;
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

	public String getnO_oF_dEFAULT_aCCOUNTS() {
		return nO_oF_dEFAULT_aCCOUNTS;
	}

	public void setnO_oF_dEFAULT_aCCOUNTS(String nO_oF_dEFAULT_aCCOUNTS) {
		this.nO_oF_dEFAULT_aCCOUNTS = nO_oF_dEFAULT_aCCOUNTS;
	}

	public String gettOTAL_rESPONSES() {
		return tOTAL_rESPONSES;
	}

	public void settOTAL_rESPONSES(String tOTAL_rESPONSES) {
		this.tOTAL_rESPONSES = tOTAL_rESPONSES;
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

	public String getnO_oF_oTHER_mFIS() {
		return nO_oF_oTHER_mFIS;
	}

	public void setnO_oF_oTHER_mFIS(String nO_oF_oTHER_mFIS) {
		this.nO_oF_oTHER_mFIS = nO_oF_oTHER_mFIS;
	}

	public String getnO_oF_oWN_mFIS() {
		return nO_oF_oWN_mFIS;
	}

	public void setnO_oF_oWN_mFIS(String nO_oF_oWN_mFIS) {
		this.nO_oF_oWN_mFIS = nO_oF_oWN_mFIS;
	}

	@Override
	public String toString() {
		return "GrpSecondarySummary [grpsno=" + grpsno + ", refId=" + refId + ", timestamp=" + timestamp
				+ ", nO_oF_dEFAULT_aCCOUNTS=" + nO_oF_dEFAULT_aCCOUNTS + ", tOTAL_rESPONSES=" + tOTAL_rESPONSES
				+ ", nO_oF_cLOSED_aCCOUNTS=" + nO_oF_cLOSED_aCCOUNTS + ", nO_oF_aCTIVE_aCCOUNTS="
				+ nO_oF_aCTIVE_aCCOUNTS + ", nO_oF_oTHER_mFIS=" + nO_oF_oTHER_mFIS + ", nO_oF_oWN_mFIS="
				+ nO_oF_oWN_mFIS + "]";
	}

}

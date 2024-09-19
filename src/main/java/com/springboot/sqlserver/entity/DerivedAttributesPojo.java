package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "derived_attributes")
public class DerivedAttributesPojo {
	@Id
	@Column(name = "dno")
	private int dno;
	
	private String refId,timestamp;

	private String iNQUIRIES_iN_lAST_sIX_mONTHS,
	lENGTH_oF_cREDIT_hISTORY_yEAR,
	lENGTH_oF_cREDIT_hISTORY_mONTH,
	aVERAGE_aCCOUNT_aGE_yEAR,
	aVERAGE_aCCOUNT_aGE_mONTH,
	nEW_aCCOUNTS_iN_lAST_sIX_mONTHS,
	nEW_dELINQ_aCCOUNT_iN_lAST_sIX_mONTHS;

	
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


	public String getiNQUIRIES_iN_lAST_sIX_mONTHS() {
		return iNQUIRIES_iN_lAST_sIX_mONTHS;
	}


	public void setiNQUIRIES_iN_lAST_sIX_mONTHS(String iNQUIRIES_iN_lAST_sIX_mONTHS) {
		this.iNQUIRIES_iN_lAST_sIX_mONTHS = iNQUIRIES_iN_lAST_sIX_mONTHS;
	}


	public String getlENGTH_oF_cREDIT_hISTORY_yEAR() {
		return lENGTH_oF_cREDIT_hISTORY_yEAR;
	}


	public void setlENGTH_oF_cREDIT_hISTORY_yEAR(String lENGTH_oF_cREDIT_hISTORY_yEAR) {
		this.lENGTH_oF_cREDIT_hISTORY_yEAR = lENGTH_oF_cREDIT_hISTORY_yEAR;
	}


	public String getlENGTH_oF_cREDIT_hISTORY_mONTH() {
		return lENGTH_oF_cREDIT_hISTORY_mONTH;
	}


	public void setlENGTH_oF_cREDIT_hISTORY_mONTH(String lENGTH_oF_cREDIT_hISTORY_mONTH) {
		this.lENGTH_oF_cREDIT_hISTORY_mONTH = lENGTH_oF_cREDIT_hISTORY_mONTH;
	}


	public String getaVERAGE_aCCOUNT_aGE_yEAR() {
		return aVERAGE_aCCOUNT_aGE_yEAR;
	}


	public void setaVERAGE_aCCOUNT_aGE_yEAR(String aVERAGE_aCCOUNT_aGE_yEAR) {
		this.aVERAGE_aCCOUNT_aGE_yEAR = aVERAGE_aCCOUNT_aGE_yEAR;
	}


	public String getaVERAGE_aCCOUNT_aGE_mONTH() {
		return aVERAGE_aCCOUNT_aGE_mONTH;
	}


	public void setaVERAGE_aCCOUNT_aGE_mONTH(String aVERAGE_aCCOUNT_aGE_mONTH) {
		this.aVERAGE_aCCOUNT_aGE_mONTH = aVERAGE_aCCOUNT_aGE_mONTH;
	}


	public String getnEW_aCCOUNTS_iN_lAST_sIX_mONTHS() {
		return nEW_aCCOUNTS_iN_lAST_sIX_mONTHS;
	}


	public void setnEW_aCCOUNTS_iN_lAST_sIX_mONTHS(String nEW_aCCOUNTS_iN_lAST_sIX_mONTHS) {
		this.nEW_aCCOUNTS_iN_lAST_sIX_mONTHS = nEW_aCCOUNTS_iN_lAST_sIX_mONTHS;
	}


	public String getnEW_dELINQ_aCCOUNT_iN_lAST_sIX_mONTHS() {
		return nEW_dELINQ_aCCOUNT_iN_lAST_sIX_mONTHS;
	}


	public void setnEW_dELINQ_aCCOUNT_iN_lAST_sIX_mONTHS(String nEW_dELINQ_aCCOUNT_iN_lAST_sIX_mONTHS) {
		this.nEW_dELINQ_aCCOUNT_iN_lAST_sIX_mONTHS = nEW_dELINQ_aCCOUNT_iN_lAST_sIX_mONTHS;
	}


	@Override
	public String toString() {
		return "DerivedAttributesPojo [dno=" + dno + ", refId=" + refId + ", timestamp=" + timestamp
				+ ", iNQUIRIES_iN_lAST_sIX_mONTHS=" + iNQUIRIES_iN_lAST_sIX_mONTHS + ", lENGTH_oF_cREDIT_hISTORY_yEAR="
				+ lENGTH_oF_cREDIT_hISTORY_yEAR + ", lENGTH_oF_cREDIT_hISTORY_mONTH=" + lENGTH_oF_cREDIT_hISTORY_mONTH
				+ ", aVERAGE_aCCOUNT_aGE_yEAR=" + aVERAGE_aCCOUNT_aGE_yEAR + ", aVERAGE_aCCOUNT_aGE_mONTH="
				+ aVERAGE_aCCOUNT_aGE_mONTH + ", nEW_aCCOUNTS_iN_lAST_sIX_mONTHS=" + nEW_aCCOUNTS_iN_lAST_sIX_mONTHS
				+ ", nEW_dELINQ_aCCOUNT_iN_lAST_sIX_mONTHS=" + nEW_dELINQ_aCCOUNT_iN_lAST_sIX_mONTHS + "]";
	}

	
	
	
}

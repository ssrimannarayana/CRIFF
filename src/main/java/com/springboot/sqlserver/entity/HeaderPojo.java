package com.springboot.sqlserver.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "header")
public class HeaderPojo {

	@Id
	@Column(name = "hno")
	private int hno;
	
	private String refid, dATE_oF_rEQUEST, pREPARED_fOR, pREPARED_fOR_iD, dATE_oF_iSSUE, bATCH_iD, rEPORT_iD,tIME_sTAMP;


	public HeaderPojo() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "HeaderPojo [hno=" + hno + ", rEFId=" + refid + ", dATE_oF_rEQUEST=" + dATE_oF_rEQUEST
				+ ", pREPARED_fOR=" + pREPARED_fOR + ", pREPARED_fOR_iD=" + pREPARED_fOR_iD + ", dATE_oF_iSSUE="
				+ dATE_oF_iSSUE + ", bATCH_iD=" + bATCH_iD + ", rEPORT_iD=" + rEPORT_iD + ", tIME_sTAMP=" + tIME_sTAMP
				+ "]";
	}



	public Integer getHno() {
		return hno;
	}



	public void setHno(Integer hno) {
		this.hno = hno;
	}


	public String getRefid() {
		return refid;
	}



	public void setRefid(String refid) {
		this.refid = refid;
	}



	public String getdATE_oF_rEQUEST() {
		return dATE_oF_rEQUEST;
	}



	public void setdATE_oF_rEQUEST(String dATE_oF_rEQUEST) {
		this.dATE_oF_rEQUEST = dATE_oF_rEQUEST;
	}



	public String getpREPARED_fOR() {
		return pREPARED_fOR;
	}



	public void setpREPARED_fOR(String pREPARED_fOR) {
		this.pREPARED_fOR = pREPARED_fOR;
	}



	public String getpREPARED_fOR_iD() {
		return pREPARED_fOR_iD;
	}



	public void setpREPARED_fOR_iD(String pREPARED_fOR_iD) {
		this.pREPARED_fOR_iD = pREPARED_fOR_iD;
	}



	public String getdATE_oF_iSSUE() {
		return dATE_oF_iSSUE;
	}



	public void setdATE_oF_iSSUE(String dATE_oF_iSSUE) {
		this.dATE_oF_iSSUE = dATE_oF_iSSUE;
	}



	public String getbATCH_iD() {
		return bATCH_iD;
	}



	public void setbATCH_iD(String bATCH_iD) {
		this.bATCH_iD = bATCH_iD;
	}



	public String getrEPORT_iD() {
		return rEPORT_iD;
	}



	public void setrEPORT_iD(String rEPORT_iD) {
		this.rEPORT_iD = rEPORT_iD;
	}



	public String gettIME_sTAMP() {
		return tIME_sTAMP;
	}



	public void settIME_sTAMP(String tIME_sTAMP) {
		this.tIME_sTAMP = tIME_sTAMP;
	}

	
}

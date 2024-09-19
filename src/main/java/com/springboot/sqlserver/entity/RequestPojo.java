package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "request_data")
public class RequestPojo {
	@Id
	@Column(name = "reqNo")
	private int reqNo;
	
	private String refid,nAME, aKA, dOB, aGE_aS_oN, id_type_1,id_value_1,id_type_2,id_value_2,address,phone,gender,eMAILS, bRANCH, kENDRA, mBR_ID, cREDIT_iNQ_pURPS_tYP,
			cREDIT_iNQ_pURPS_tYP_dESC, cREDIT_iNQUIRY_sTAGE, cREDIT_rPT_iD, cREDIT_rEQ_tYP, cREDIT_rPT_tRN_dT_tM,
			lOS_aPP_iD, lOAN_aMOUNT, mFI_iND, mFI_sCORE, mFI_gROUP, cNS_iND, cNS_sCORE, iOI,tIME_sTAMP;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	public String getRefid() {
		return refid;
	}

	public void setRefid(String refid) {
		this.refid = refid;
	}

	public String getnAME() {
		return nAME;
	}

	public void setnAME(String nAME) {
		this.nAME = nAME;
	}

	public String getaKA() {
		return aKA;
	}

	public void setaKA(String aKA) {
		this.aKA = aKA;
	}

	public String getdOB() {
		return dOB;
	}

	public void setdOB(String dOB) {
		this.dOB = dOB;
	}

	public String getaGE_aS_oN() {
		return aGE_aS_oN;
	}

	public void setaGE_aS_oN(String aGE_aS_oN) {
		this.aGE_aS_oN = aGE_aS_oN;
	}

	public String getId_type_1() {
		return id_type_1;
	}

	public void setId_type_1(String id_type_1) {
		this.id_type_1 = id_type_1;
	}

	public String getId_value_1() {
		return id_value_1;
	}

	public void setId_value_1(String id_value_1) {
		this.id_value_1 = id_value_1;
	}

	public String getId_type_2() {
		return id_type_2;
	}

	public void setId_type_2(String id_type_2) {
		this.id_type_2 = id_type_2;
	}

	public String getId_value_2() {
		return id_value_2;
	}

	public void setId_value_2(String id_value_2) {
		this.id_value_2 = id_value_2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String geteMAILS() {
		return eMAILS;
	}

	public void seteMAILS(String eMAILS) {
		this.eMAILS = eMAILS;
	}

	public String getbRANCH() {
		return bRANCH;
	}

	public void setbRANCH(String bRANCH) {
		this.bRANCH = bRANCH;
	}

	public String getkENDRA() {
		return kENDRA;
	}

	public void setkENDRA(String kENDRA) {
		this.kENDRA = kENDRA;
	}

	public String getmBR_ID() {
		return mBR_ID;
	}

	public void setmBR_ID(String mBR_ID) {
		this.mBR_ID = mBR_ID;
	}

	public String getcREDIT_iNQ_pURPS_tYP() {
		return cREDIT_iNQ_pURPS_tYP;
	}

	public void setcREDIT_iNQ_pURPS_tYP(String cREDIT_iNQ_pURPS_tYP) {
		this.cREDIT_iNQ_pURPS_tYP = cREDIT_iNQ_pURPS_tYP;
	}

	public String getcREDIT_iNQ_pURPS_tYP_dESC() {
		return cREDIT_iNQ_pURPS_tYP_dESC;
	}

	public void setcREDIT_iNQ_pURPS_tYP_dESC(String cREDIT_iNQ_pURPS_tYP_dESC) {
		this.cREDIT_iNQ_pURPS_tYP_dESC = cREDIT_iNQ_pURPS_tYP_dESC;
	}

	public String getcREDIT_iNQUIRY_sTAGE() {
		return cREDIT_iNQUIRY_sTAGE;
	}

	public void setcREDIT_iNQUIRY_sTAGE(String cREDIT_iNQUIRY_sTAGE) {
		this.cREDIT_iNQUIRY_sTAGE = cREDIT_iNQUIRY_sTAGE;
	}

	public String getcREDIT_rPT_iD() {
		return cREDIT_rPT_iD;
	}

	public void setcREDIT_rPT_iD(String cREDIT_rPT_iD) {
		this.cREDIT_rPT_iD = cREDIT_rPT_iD;
	}

	public String getcREDIT_rEQ_tYP() {
		return cREDIT_rEQ_tYP;
	}

	public void setcREDIT_rEQ_tYP(String cREDIT_rEQ_tYP) {
		this.cREDIT_rEQ_tYP = cREDIT_rEQ_tYP;
	}

	public String getcREDIT_rPT_tRN_dT_tM() {
		return cREDIT_rPT_tRN_dT_tM;
	}

	public void setcREDIT_rPT_tRN_dT_tM(String cREDIT_rPT_tRN_dT_tM) {
		this.cREDIT_rPT_tRN_dT_tM = cREDIT_rPT_tRN_dT_tM;
	}

	public String getlOS_aPP_iD() {
		return lOS_aPP_iD;
	}

	public void setlOS_aPP_iD(String lOS_aPP_iD) {
		this.lOS_aPP_iD = lOS_aPP_iD;
	}

	public String getlOAN_aMOUNT() {
		return lOAN_aMOUNT;
	}

	public void setlOAN_aMOUNT(String lOAN_aMOUNT) {
		this.lOAN_aMOUNT = lOAN_aMOUNT;
	}

	public String getmFI_iND() {
		return mFI_iND;
	}

	public void setmFI_iND(String mFI_iND) {
		this.mFI_iND = mFI_iND;
	}

	public String getmFI_sCORE() {
		return mFI_sCORE;
	}

	public void setmFI_sCORE(String mFI_sCORE) {
		this.mFI_sCORE = mFI_sCORE;
	}

	public String getmFI_gROUP() {
		return mFI_gROUP;
	}

	public void setmFI_gROUP(String mFI_gROUP) {
		this.mFI_gROUP = mFI_gROUP;
	}

	public String getcNS_iND() {
		return cNS_iND;
	}

	public void setcNS_iND(String cNS_iND) {
		this.cNS_iND = cNS_iND;
	}

	public String getcNS_sCORE() {
		return cNS_sCORE;
	}

	public void setcNS_sCORE(String cNS_sCORE) {
		this.cNS_sCORE = cNS_sCORE;
	}

	public String getiOI() {
		return iOI;
	}

	public void setiOI(String iOI) {
		this.iOI = iOI;
	}

	public String gettIME_sTAMP() {
		return tIME_sTAMP;
	}

	public void settIME_sTAMP(String tIME_sTAMP) {
		this.tIME_sTAMP = tIME_sTAMP;
	}

	@Override
	public String toString() {
		return "RequestPojo [reqNo=" + reqNo + ", refid=" + refid + ", nAME=" + nAME + ", aKA=" + aKA + ", dOB=" + dOB
				+ ", aGE_aS_oN=" + aGE_aS_oN + ", id_type_1=" + id_type_1 + ", id_value_1=" + id_value_1
				+ ", id_type_2=" + id_type_2 + ", id_value_2=" + id_value_2 + ", address=" + address + ", phone="
				+ phone + ", eMAILS=" + eMAILS + ", bRANCH=" + bRANCH + ", kENDRA=" + kENDRA + ", mBR_ID=" + mBR_ID
				+ ", cREDIT_iNQ_pURPS_tYP=" + cREDIT_iNQ_pURPS_tYP + ", cREDIT_iNQ_pURPS_tYP_dESC="
				+ cREDIT_iNQ_pURPS_tYP_dESC + ", cREDIT_iNQUIRY_sTAGE=" + cREDIT_iNQUIRY_sTAGE + ", cREDIT_rPT_iD="
				+ cREDIT_rPT_iD + ", cREDIT_rEQ_tYP=" + cREDIT_rEQ_tYP + ", cREDIT_rPT_tRN_dT_tM="
				+ cREDIT_rPT_tRN_dT_tM + ", lOS_aPP_iD=" + lOS_aPP_iD + ", lOAN_aMOUNT=" + lOAN_aMOUNT + ", mFI_iND="
				+ mFI_iND + ", mFI_sCORE=" + mFI_sCORE + ", mFI_gROUP=" + mFI_gROUP + ", cNS_iND=" + cNS_iND
				+ ", cNS_sCORE=" + cNS_sCORE + ", iOI=" + iOI + ", tIME_sTAMP=" + tIME_sTAMP + "]";
	}

}

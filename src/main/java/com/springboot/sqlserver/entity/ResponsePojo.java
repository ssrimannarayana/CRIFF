package com.springboot.sqlserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_details_response")
public class ResponsePojo {
	@Id
	@Column(name = "resno")
	private int resno;
	
	private String refId,timestamp;
	private String aCCT_nUMBER,
	cREDIT_gUARANTOR,
	aCCT_tYPE,
	dATE_rEPORTED,
	oWNERSHIP_iND,
	aCCOUNT_sTATUS,
	dISBURSED_aMT,
	dISBURSED_dATE,
	cLOSED_dATE,
	oVERDUE_aMT,
	wRITE_oFF_aMT,
	cURRENT_bAL,
	sECURITY_sTATUS,
	oRIGINAL_tERM,
	cOMBINED_pAYMENT_hISTORY,
	mATCHED_tYPE,
	sETTLEMENT_aMT,
    pRINCIPAL_wRITE_oFF_aMT,
	wRITTEN_oFF_sETTLED_sTATUS,
	iNSTALLMENT_aMT,
	sUIT_fILED_wILFUL_dEFAULT;
	
	
	private int 
	  dpd0,  
	  dpd1,
	  dpd2,
	  dpd3,
	  dpd4,
	  dpd5,
	  dpd6,
	  dpd7,
	  dpd8,
	  dpd9,
	  dpd10,
	  dpd11,
	  dpd12,
	  dpd13,
	  dpd14,
	  dpd15,
	  dpd16,
	  dpd17,
	  dpd18,
	  dpd19,
	  dpd20,
	  dpd21,
	  dpd22,
	  dpd23,
	  dpd24,
	  dpd25,
	  dpd26,
	  dpd27,
	  dpd28,
	  dpd29,
	  dpd30,
	  dpd31,
	  dpd32,
	  dpd33,
	  dpd34,
	  dpd35,
	  dpd36,
	  dpd37,
	  dpd38,
	  dpd39,
	  dpd40,
	  dpd41,
	  dpd42,
	  dpd43,
	  dpd44,
	  dpd45,
	  dpd46,
	  dpd47,
	  dpd48,
	  dpd49,
	  high_dpd,low_dpd,Avg_dpd;
	
	private String split0,
	split1,
	split2,
	split3,
	split4,
	split5,
	split6,
	split7,
	split8,
	split9,
	split10,
	split11,
	split12,
	split13,
	split14,
	split15,
	split16,
	split17,
	split18,
	split19,
	split20,
	split21,
	split22,
	split23,
	split24,
	split25,
	split26,
	split27,
	split28,
	split29,
	split30,
	split31,
	split32,
	split33,
	split34,
	split35,
	split36,
	split37,
	split38,
	split39,
	split40,
	split41,
	split42,
	split43,
	split44,
	split45,
	split46,
	split47,
	split48,
	split49;
	
	
	public int getResno() {
		return resno;
	}
	public void setResno(int resno) {
		this.resno = resno;
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
	public String getaCCT_nUMBER() {
		return aCCT_nUMBER;
	}
	public void setaCCT_nUMBER(String aCCT_nUMBER) {
		this.aCCT_nUMBER = aCCT_nUMBER;
	}
	public String getcREDIT_gUARANTOR() {
		return cREDIT_gUARANTOR;
	}
	public void setcREDIT_gUARANTOR(String cREDIT_gUARANTOR) {
		this.cREDIT_gUARANTOR = cREDIT_gUARANTOR;
	}
	public String getaCCT_tYPE() {
		return aCCT_tYPE;
	}
	public void setaCCT_tYPE(String aCCT_tYPE) {
		this.aCCT_tYPE = aCCT_tYPE;
	}
	public String getdATE_rEPORTED() {
		return dATE_rEPORTED;
	}
	public void setdATE_rEPORTED(String dATE_rEPORTED) {
		this.dATE_rEPORTED = dATE_rEPORTED;
	}
	public String getoWNERSHIP_iND() {
		return oWNERSHIP_iND;
	}
	public void setoWNERSHIP_iND(String oWNERSHIP_iND) {
		this.oWNERSHIP_iND = oWNERSHIP_iND;
	}
	public String getaCCOUNT_sTATUS() {
		return aCCOUNT_sTATUS;
	}
	public void setaCCOUNT_sTATUS(String aCCOUNT_sTATUS) {
		this.aCCOUNT_sTATUS = aCCOUNT_sTATUS;
	}
	public String getdISBURSED_aMT() {
		return dISBURSED_aMT;
	}
	public void setdISBURSED_aMT(String dISBURSED_aMT) {
		this.dISBURSED_aMT = dISBURSED_aMT;
	}
	public String getdISBURSED_dATE() {
		return dISBURSED_dATE;
	}
	public void setdISBURSED_dATE(String dISBURSED_dATE) {
		this.dISBURSED_dATE = dISBURSED_dATE;
	}
	public String getcLOSED_dATE() {
		return cLOSED_dATE;
	}
	public void setcLOSED_dATE(String cLOSED_dATE) {
		this.cLOSED_dATE = cLOSED_dATE;
	}
	public String getoVERDUE_aMT() {
		return oVERDUE_aMT;
	}
	public void setoVERDUE_aMT(String oVERDUE_aMT) {
		this.oVERDUE_aMT = oVERDUE_aMT;
	}
	public String getwRITE_oFF_aMT() {
		return wRITE_oFF_aMT;
	}
	public void setwRITE_oFF_aMT(String wRITE_oFF_aMT) {
		this.wRITE_oFF_aMT = wRITE_oFF_aMT;
	}
	public String getcURRENT_bAL() {
		return cURRENT_bAL;
	}
	public void setcURRENT_bAL(String cURRENT_bAL) {
		this.cURRENT_bAL = cURRENT_bAL;
	}
	public String getsECURITY_sTATUS() {
		return sECURITY_sTATUS;
	}
	public void setsECURITY_sTATUS(String sECURITY_sTATUS) {
		this.sECURITY_sTATUS = sECURITY_sTATUS;
	}
	public String getoRIGINAL_tERM() {
		return oRIGINAL_tERM;
	}
	public void setoRIGINAL_tERM(String oRIGINAL_tERM) {
		this.oRIGINAL_tERM = oRIGINAL_tERM;
	}
	public String getcOMBINED_pAYMENT_hISTORY() {
		return cOMBINED_pAYMENT_hISTORY;
	}
	public void setcOMBINED_pAYMENT_hISTORY(String cOMBINED_pAYMENT_hISTORY) {
		this.cOMBINED_pAYMENT_hISTORY = cOMBINED_pAYMENT_hISTORY;
	}
	public String getmATCHED_tYPE() {
		return mATCHED_tYPE;
	}
	public void setmATCHED_tYPE(String mATCHED_tYPE) {
		this.mATCHED_tYPE = mATCHED_tYPE;
	}
	public int getDpd0() {
		return dpd0;
	}
	public void setDpd0(int dpd0) {
		this.dpd0 = dpd0;
	}
	public int getDpd1() {
		return dpd1;
	}
	public void setDpd1(int dpd1) {
		this.dpd1 = dpd1;
	}
	public int getDpd2() {
		return dpd2;
	}
	public void setDpd2(int dpd2) {
		this.dpd2 = dpd2;
	}
	public int getDpd3() {
		return dpd3;
	}
	public void setDpd3(int dpd3) {
		this.dpd3 = dpd3;
	}
	public int getDpd4() {
		return dpd4;
	}
	public void setDpd4(int dpd4) {
		this.dpd4 = dpd4;
	}
	public int getDpd5() {
		return dpd5;
	}
	public void setDpd5(int dpd5) {
		this.dpd5 = dpd5;
	}
	public int getDpd6() {
		return dpd6;
	}
	public void setDpd6(int dpd6) {
		this.dpd6 = dpd6;
	}
	public int getDpd7() {
		return dpd7;
	}
	public void setDpd7(int dpd7) {
		this.dpd7 = dpd7;
	}
	public int getDpd8() {
		return dpd8;
	}
	public void setDpd8(int dpd8) {
		this.dpd8 = dpd8;
	}
	public int getDpd9() {
		return dpd9;
	}
	public void setDpd9(int dpd9) {
		this.dpd9 = dpd9;
	}
	public int getDpd10() {
		return dpd10;
	}
	public void setDpd10(int dpd10) {
		this.dpd10 = dpd10;
	}
	public int getDpd11() {
		return dpd11;
	}
	public void setDpd11(int dpd11) {
		this.dpd11 = dpd11;
	}
	public int getDpd12() {
		return dpd12;
	}
	public void setDpd12(int dpd12) {
		this.dpd12 = dpd12;
	}
	public int getDpd13() {
		return dpd13;
	}
	public void setDpd13(int dpd13) {
		this.dpd13 = dpd13;
	}
	public int getDpd14() {
		return dpd14;
	}
	public void setDpd14(int dpd14) {
		this.dpd14 = dpd14;
	}
	public int getDpd15() {
		return dpd15;
	}
	public void setDpd15(int dpd15) {
		this.dpd15 = dpd15;
	}
	public int getDpd16() {
		return dpd16;
	}
	public void setDpd16(int dpd16) {
		this.dpd16 = dpd16;
	}
	public int getDpd17() {
		return dpd17;
	}
	public void setDpd17(int dpd17) {
		this.dpd17 = dpd17;
	}
	public int getDpd18() {
		return dpd18;
	}
	public void setDpd18(int dpd18) {
		this.dpd18 = dpd18;
	}
	public int getDpd19() {
		return dpd19;
	}
	public void setDpd19(int dpd19) {
		this.dpd19 = dpd19;
	}
	public int getDpd20() {
		return dpd20;
	}
	public void setDpd20(int dpd20) {
		this.dpd20 = dpd20;
	}
	public int getDpd21() {
		return dpd21;
	}
	public void setDpd21(int dpd21) {
		this.dpd21 = dpd21;
	}
	public int getDpd22() {
		return dpd22;
	}
	public void setDpd22(int dpd22) {
		this.dpd22 = dpd22;
	}
	public int getDpd23() {
		return dpd23;
	}
	public void setDpd23(int dpd23) {
		this.dpd23 = dpd23;
	}
	public int getDpd24() {
		return dpd24;
	}
	public void setDpd24(int dpd24) {
		this.dpd24 = dpd24;
	}
	public int getDpd25() {
		return dpd25;
	}
	public void setDpd25(int dpd25) {
		this.dpd25 = dpd25;
	}
	public int getDpd26() {
		return dpd26;
	}
	public void setDpd26(int dpd26) {
		this.dpd26 = dpd26;
	}
	public int getDpd27() {
		return dpd27;
	}
	public void setDpd27(int dpd27) {
		this.dpd27 = dpd27;
	}
	public int getDpd28() {
		return dpd28;
	}
	public void setDpd28(int dpd28) {
		this.dpd28 = dpd28;
	}
	public int getDpd29() {
		return dpd29;
	}
	public void setDpd29(int dpd29) {
		this.dpd29 = dpd29;
	}
	public int getDpd30() {
		return dpd30;
	}
	public void setDpd30(int dpd30) {
		this.dpd30 = dpd30;
	}
	public int getDpd31() {
		return dpd31;
	}
	public void setDpd31(int dpd31) {
		this.dpd31 = dpd31;
	}
	public int getDpd32() {
		return dpd32;
	}
	public void setDpd32(int dpd32) {
		this.dpd32 = dpd32;
	}
	public int getDpd33() {
		return dpd33;
	}
	public void setDpd33(int dpd33) {
		this.dpd33 = dpd33;
	}
	public int getDpd34() {
		return dpd34;
	}
	public void setDpd34(int dpd34) {
		this.dpd34 = dpd34;
	}
	public int getDpd35() {
		return dpd35;
	}
	public void setDpd35(int dpd35) {
		this.dpd35 = dpd35;
	}
	public int getDpd36() {
		return dpd36;
	}
	public void setDpd36(int dpd36) {
		this.dpd36 = dpd36;
	}
	public int getDpd37() {
		return dpd37;
	}
	public void setDpd37(int dpd37) {
		this.dpd37 = dpd37;
	}
	public int getHigh_dpd() {
		return high_dpd;
	}
	public void setHigh_dpd(int high_dpd) {
		this.high_dpd = high_dpd;
	}
	public int getLow_dpd() {
		return low_dpd;
	}
	public void setLow_dpd(int low_dpd) {
		this.low_dpd = low_dpd;
	}
	public int getAvg_dpd() {
		return Avg_dpd;
	}
	public void setAvg_dpd(int avg_dpd) {
		Avg_dpd = avg_dpd;
	}
	
	public String getSplit0() {
		return split0;
	}
	public void setSplit0(String split0) {
		this.split0 = split0;
	}
	public String getSplit1() {
		return split1;
	}
	public void setSplit1(String split1) {
		this.split1 = split1;
	}
	public String getSplit2() {
		return split2;
	}
	public void setSplit2(String split2) {
		this.split2 = split2;
	}
	public String getSplit3() {
		return split3;
	}
	public void setSplit3(String split3) {
		this.split3 = split3;
	}
	public String getSplit4() {
		return split4;
	}
	public void setSplit4(String split4) {
		this.split4 = split4;
	}
	public String getSplit5() {
		return split5;
	}
	public void setSplit5(String split5) {
		this.split5 = split5;
	}
	public String getSplit6() {
		return split6;
	}
	public void setSplit6(String split6) {
		this.split6 = split6;
	}
	public String getSplit7() {
		return split7;
	}
	public void setSplit7(String split7) {
		this.split7 = split7;
	}
	public String getSplit8() {
		return split8;
	}
	public void setSplit8(String split8) {
		this.split8 = split8;
	}
	public String getSplit9() {
		return split9;
	}
	public void setSplit9(String split9) {
		this.split9 = split9;
	}
	public String getSplit10() {
		return split10;
	}
	public void setSplit10(String split10) {
		this.split10 = split10;
	}
	public String getSplit11() {
		return split11;
	}
	public void setSplit11(String split11) {
		this.split11 = split11;
	}
	public String getSplit12() {
		return split12;
	}
	public void setSplit12(String split12) {
		this.split12 = split12;
	}
	public String getSplit13() {
		return split13;
	}
	public void setSplit13(String split13) {
		this.split13 = split13;
	}
	public String getSplit14() {
		return split14;
	}
	public void setSplit14(String split14) {
		this.split14 = split14;
	}
	public String getSplit15() {
		return split15;
	}
	public void setSplit15(String split15) {
		this.split15 = split15;
	}
	public String getSplit16() {
		return split16;
	}
	public void setSplit16(String split16) {
		this.split16 = split16;
	}
	public String getSplit17() {
		return split17;
	}
	public void setSplit17(String split17) {
		this.split17 = split17;
	}
	public String getSplit18() {
		return split18;
	}
	public void setSplit18(String split18) {
		this.split18 = split18;
	}
	public String getSplit19() {
		return split19;
	}
	public void setSplit19(String split19) {
		this.split19 = split19;
	}
	public String getSplit20() {
		return split20;
	}
	public void setSplit20(String split20) {
		this.split20 = split20;
	}
	public String getSplit21() {
		return split21;
	}
	public void setSplit21(String split21) {
		this.split21 = split21;
	}
	public String getSplit22() {
		return split22;
	}
	public void setSplit22(String split22) {
		this.split22 = split22;
	}
	public String getSplit23() {
		return split23;
	}
	public void setSplit23(String split23) {
		this.split23 = split23;
	}
	public String getSplit24() {
		return split24;
	}
	public void setSplit24(String split24) {
		this.split24 = split24;
	}
	public String getSplit25() {
		return split25;
	}
	public void setSplit25(String split25) {
		this.split25 = split25;
	}
	public String getSplit26() {
		return split26;
	}
	public void setSplit26(String split26) {
		this.split26 = split26;
	}
	public String getSplit27() {
		return split27;
	}
	public void setSplit27(String split27) {
		this.split27 = split27;
	}
	public String getSplit28() {
		return split28;
	}
	public void setSplit28(String split28) {
		this.split28 = split28;
	}
	public String getSplit29() {
		return split29;
	}
	public void setSplit29(String split29) {
		this.split29 = split29;
	}
	public String getSplit30() {
		return split30;
	}
	public void setSplit30(String split30) {
		this.split30 = split30;
	}
	public String getSplit31() {
		return split31;
	}
	public void setSplit31(String split31) {
		this.split31 = split31;
	}
	public String getSplit32() {
		return split32;
	}
	public void setSplit32(String split32) {
		this.split32 = split32;
	}
	public String getSplit33() {
		return split33;
	}
	public void setSplit33(String split33) {
		this.split33 = split33;
	}
	public String getSplit34() {
		return split34;
	}
	public void setSplit34(String split34) {
		this.split34 = split34;
	}
	public String getSplit35() {
		return split35;
	}
	public void setSplit35(String split35) {
		this.split35 = split35;
	}
	public String getSplit36() {
		return split36;
	}
	public void setSplit36(String split36) {
		this.split36 = split36;
	}
	public String getSplit37() {
		return split37;
	}
	public void setSplit37(String split37) {
		this.split37 = split37;
	}
	
	public String getSplit38() {
		return split38;
	}
	public void setSplit38(String split38) {
		this.split38 = split38;
	}
	public String getSplit39() {
		return split39;
	}
	public void setSplit39(String split39) {
		this.split39 = split39;
	}
	public String getSplit40() {
		return split40;
	}
	public void setSplit40(String split40) {
		this.split40 = split40;
	}
	public String getSplit41() {
		return split41;
	}
	public void setSplit41(String split41) {
		this.split41 = split41;
	}
	public String getSplit42() {
		return split42;
	}
	public void setSplit42(String split42) {
		this.split42 = split42;
	}
	public String getSplit43() {
		return split43;
	}
	public void setSplit43(String split43) {
		this.split43 = split43;
	}
	public String getSplit44() {
		return split44;
	}
	public void setSplit44(String split44) {
		this.split44 = split44;
	}
	public String getSplit45() {
		return split45;
	}
	public void setSplit45(String split45) {
		this.split45 = split45;
	}
	public String getSplit46() {
		return split46;
	}
	public void setSplit46(String split46) {
		this.split46 = split46;
	}
	public String getSplit47() {
		return split47;
	}
	public void setSplit47(String split47) {
		this.split47 = split47;
	}
	public String getSplit48() {
		return split48;
	}
	public void setSplit48(String split48) {
		this.split48 = split48;
	}
	public String getSplit49() {
		return split49;
	}
	public void setSplit49(String split49) {
		this.split49 = split49;
	}
	
	
	public int getDpd38() {
		return dpd38;
	}
	public void setDpd38(int dpd38) {
		this.dpd38 = dpd38;
	}
	public int getDpd39() {
		return dpd39;
	}
	public void setDpd39(int dpd39) {
		this.dpd39 = dpd39;
	}
	public int getDpd40() {
		return dpd40;
	}
	public void setDpd40(int dpd40) {
		this.dpd40 = dpd40;
	}
	public int getDpd41() {
		return dpd41;
	}
	public void setDpd41(int dpd41) {
		this.dpd41 = dpd41;
	}
	public int getDpd42() {
		return dpd42;
	}
	public void setDpd42(int dpd42) {
		this.dpd42 = dpd42;
	}
	public int getDpd43() {
		return dpd43;
	}
	public void setDpd43(int dpd43) {
		this.dpd43 = dpd43;
	}
	public int getDpd44() {
		return dpd44;
	}
	public void setDpd44(int dpd44) {
		this.dpd44 = dpd44;
	}
	public int getDpd45() {
		return dpd45;
	}
	public void setDpd45(int dpd45) {
		this.dpd45 = dpd45;
	}
	public int getDpd46() {
		return dpd46;
	}
	public void setDpd46(int dpd46) {
		this.dpd46 = dpd46;
	}
	public int getDpd47() {
		return dpd47;
	}
	public void setDpd47(int dpd47) {
		this.dpd47 = dpd47;
	}
	public int getDpd48() {
		return dpd48;
	}
	public void setDpd48(int dpd48) {
		this.dpd48 = dpd48;
	}
	public int getDpd49() {
		return dpd49;
	}
	public void setDpd49(int dpd49) {
		this.dpd49 = dpd49;
	}
	public String getsETTLEMENT_aMT() {
		return sETTLEMENT_aMT;
	}
	public void setsETTLEMENT_aMT(String sETTLEMENT_aMT) {
		this.sETTLEMENT_aMT = sETTLEMENT_aMT;
	}
	public String getpRINCIPAL_wRITE_oFF_aMT() {
		return pRINCIPAL_wRITE_oFF_aMT;
	}
	public void setpRINCIPAL_wRITE_oFF_aMT(String pRINCIPAL_wRITE_oFF_aMT) {
		this.pRINCIPAL_wRITE_oFF_aMT = pRINCIPAL_wRITE_oFF_aMT;
	}
	public String getwRITTEN_oFF_sETTLED_sTATUS() {
		return wRITTEN_oFF_sETTLED_sTATUS;
	}
	public void setwRITTEN_oFF_sETTLED_sTATUS(String wRITTEN_oFF_sETTLED_sTATUS) {
		this.wRITTEN_oFF_sETTLED_sTATUS = wRITTEN_oFF_sETTLED_sTATUS;
	}
	public String getiNSTALLMENT_aMT() {
		return iNSTALLMENT_aMT;
	}
	public void setiNSTALLMENT_aMT(String iNSTALLMENT_aMT) {
		this.iNSTALLMENT_aMT = iNSTALLMENT_aMT;
	}
	
	public String getsUIT_fILED_wILFUL_dEFAULT() {
		return sUIT_fILED_wILFUL_dEFAULT;
	}
	public void setsUIT_fILED_wILFUL_dEFAULT(String sUIT_fILED_wILFUL_dEFAULT) {
		this.sUIT_fILED_wILFUL_dEFAULT = sUIT_fILED_wILFUL_dEFAULT;
	}
	@Override
	public String toString() {
		return "ResponsePojo [resno=" + resno + ", refId=" + refId + ", timestamp=" + timestamp + ", aCCT_nUMBER="
				+ aCCT_nUMBER + ", cREDIT_gUARANTOR=" + cREDIT_gUARANTOR + ", aCCT_tYPE=" + aCCT_tYPE
				+ ", dATE_rEPORTED=" + dATE_rEPORTED + ", oWNERSHIP_iND=" + oWNERSHIP_iND + ", aCCOUNT_sTATUS="
				+ aCCOUNT_sTATUS + ", dISBURSED_aMT=" + dISBURSED_aMT + ", dISBURSED_dATE=" + dISBURSED_dATE
				+ ", cLOSED_dATE=" + cLOSED_dATE + ", oVERDUE_aMT=" + oVERDUE_aMT + ", wRITE_oFF_aMT=" + wRITE_oFF_aMT
				+ ", cURRENT_bAL=" + cURRENT_bAL + ", sECURITY_sTATUS=" + sECURITY_sTATUS + ", oRIGINAL_tERM="
				+ oRIGINAL_tERM + ", cOMBINED_pAYMENT_hISTORY=" + cOMBINED_pAYMENT_hISTORY + ", mATCHED_tYPE="
				+ mATCHED_tYPE + ", sETTLEMENT_aMT=" + sETTLEMENT_aMT + ", pRINCIPAL_wRITE_oFF_aMT="
				+ pRINCIPAL_wRITE_oFF_aMT + ", wRITTEN_oFF_sETTLED_sTATUS=" + wRITTEN_oFF_sETTLED_sTATUS
				+ ", iNSTALLMENT_aMT=" + iNSTALLMENT_aMT + ", sUIT_fILED_wILFUL_dEFAULT=" + sUIT_fILED_wILFUL_dEFAULT
				+ ", dpd0=" + dpd0 + ", dpd1=" + dpd1 + ", dpd2=" + dpd2 + ", dpd3=" + dpd3 + ", dpd4=" + dpd4
				+ ", dpd5=" + dpd5 + ", dpd6=" + dpd6 + ", dpd7=" + dpd7 + ", dpd8=" + dpd8 + ", dpd9=" + dpd9
				+ ", dpd10=" + dpd10 + ", dpd11=" + dpd11 + ", dpd12=" + dpd12 + ", dpd13=" + dpd13 + ", dpd14=" + dpd14
				+ ", dpd15=" + dpd15 + ", dpd16=" + dpd16 + ", dpd17=" + dpd17 + ", dpd18=" + dpd18 + ", dpd19=" + dpd19
				+ ", dpd20=" + dpd20 + ", dpd21=" + dpd21 + ", dpd22=" + dpd22 + ", dpd23=" + dpd23 + ", dpd24=" + dpd24
				+ ", dpd25=" + dpd25 + ", dpd26=" + dpd26 + ", dpd27=" + dpd27 + ", dpd28=" + dpd28 + ", dpd29=" + dpd29
				+ ", dpd30=" + dpd30 + ", dpd31=" + dpd31 + ", dpd32=" + dpd32 + ", dpd33=" + dpd33 + ", dpd34=" + dpd34
				+ ", dpd35=" + dpd35 + ", dpd36=" + dpd36 + ", dpd37=" + dpd37 + ", dpd38=" + dpd38 + ", dpd39=" + dpd39
				+ ", dpd40=" + dpd40 + ", dpd41=" + dpd41 + ", dpd42=" + dpd42 + ", dpd43=" + dpd43 + ", dpd44=" + dpd44
				+ ", dpd45=" + dpd45 + ", dpd46=" + dpd46 + ", dpd47=" + dpd47 + ", dpd48=" + dpd48 + ", dpd49=" + dpd49
				+ ", high_dpd=" + high_dpd + ", low_dpd=" + low_dpd + ", Avg_dpd=" + Avg_dpd + ", split0=" + split0
				+ ", split1=" + split1 + ", split2=" + split2 + ", split3=" + split3 + ", split4=" + split4
				+ ", split5=" + split5 + ", split6=" + split6 + ", split7=" + split7 + ", split8=" + split8
				+ ", split9=" + split9 + ", split10=" + split10 + ", split11=" + split11 + ", split12=" + split12
				+ ", split13=" + split13 + ", split14=" + split14 + ", split15=" + split15 + ", split16=" + split16
				+ ", split17=" + split17 + ", split18=" + split18 + ", split19=" + split19 + ", split20=" + split20
				+ ", split21=" + split21 + ", split22=" + split22 + ", split23=" + split23 + ", split24=" + split24
				+ ", split25=" + split25 + ", split26=" + split26 + ", split27=" + split27 + ", split28=" + split28
				+ ", split29=" + split29 + ", split30=" + split30 + ", split31=" + split31 + ", split32=" + split32
				+ ", split33=" + split33 + ", split34=" + split34 + ", split35=" + split35 + ", split36=" + split36
				+ ", split37=" + split37 + ", split38=" + split38 + ", split39=" + split39 + ", split40=" + split40
				+ ", split41=" + split41 + ", split42=" + split42 + ", split43=" + split43 + ", split44=" + split44
				+ ", split45=" + split45 + ", split46=" + split46 + ", split47=" + split47 + ", split48=" + split48
				+ ", split49=" + split49 + "]";
	}
	
}

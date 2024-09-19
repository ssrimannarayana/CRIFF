package com.springboot.sqlserver.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.springboot.sqlserver.entity.AddressVariationPojo;
import com.springboot.sqlserver.entity.Alerts;
import com.springboot.sqlserver.entity.Criff;
import com.springboot.sqlserver.entity.DerivedAttributesPojo;
import com.springboot.sqlserver.entity.DobVariationPojo;
import com.springboot.sqlserver.entity.DrivingLicenseVariationPojo;
import com.springboot.sqlserver.entity.EmailVariationPojo;
import com.springboot.sqlserver.entity.EnquiryHistoryPojo;
import com.springboot.sqlserver.entity.GrpPrimarySummeryPojo;
import com.springboot.sqlserver.entity.GrpSecondarySummary;
import com.springboot.sqlserver.entity.GrpSummary;
import com.springboot.sqlserver.entity.HeaderPojo;

import com.springboot.sqlserver.entity.PanVariationsPojo;
import com.springboot.sqlserver.entity.PassporVariationPojo;
import com.springboot.sqlserver.entity.PhoneVariationPojo;
import com.springboot.sqlserver.entity.PrimaryAccountsSummaryPojo;
import com.springboot.sqlserver.entity.PrimarySummeryPojo;
import com.springboot.sqlserver.entity.PrintableReportPojo;
import com.springboot.sqlserver.entity.RationCardVariationPojo;
import com.springboot.sqlserver.entity.RequestPojo;
import com.springboot.sqlserver.entity.ResponsePojo;
import com.springboot.sqlserver.entity.ScorePojo;
import com.springboot.sqlserver.entity.ScoringFactores;
import com.springboot.sqlserver.entity.SecondaryAccountsSummary;
import com.springboot.sqlserver.entity.SecondarySummary;
import com.springboot.sqlserver.entity.StatusDetails;
import com.springboot.sqlserver.entity.Summary;
import com.springboot.sqlserver.entity.VoterIdVariationPojo;
import com.springboot.sqlserver.repository.IAddressRepository;
import com.springboot.sqlserver.repository.IAddressVariationRepository;
import com.springboot.sqlserver.repository.IAlertRepository;
import com.springboot.sqlserver.repository.ICriffRepository;
import com.springboot.sqlserver.repository.IDerivedAttrubutesRepository;
import com.springboot.sqlserver.repository.IDlVariationRepository;
import com.springboot.sqlserver.repository.IDobVariationRepository;
import com.springboot.sqlserver.repository.IEmailVariationRepository;
import com.springboot.sqlserver.repository.IEnquiryHistoryRepository;
import com.springboot.sqlserver.repository.IGrpPrimaryRepository;
import com.springboot.sqlserver.repository.IGrpSecondarySummaryRepository;
import com.springboot.sqlserver.repository.IGrpSummaryRepository;
import com.springboot.sqlserver.repository.IHeaderRepository;
import com.springboot.sqlserver.repository.INameVariationRepository;
import com.springboot.sqlserver.repository.IPanVariationRepository;
import com.springboot.sqlserver.repository.IPassportVariationRepository;
import com.springboot.sqlserver.repository.IPhoneVarificationRepository;
import com.springboot.sqlserver.repository.IPrimaryAcSummaryRepository;
import com.springboot.sqlserver.repository.IPrimarySummaryRepository;
import com.springboot.sqlserver.repository.IPrintableReportRepository;
import com.springboot.sqlserver.repository.IRationCardVariationRepository;
import com.springboot.sqlserver.repository.IRequestRepository;
import com.springboot.sqlserver.repository.IResponseStatusRepository;
import com.springboot.sqlserver.repository.IScoreRepository;
import com.springboot.sqlserver.repository.ISecondaryAcSummaryRepository;
import com.springboot.sqlserver.repository.ISecondarySummaryRepository;
import com.springboot.sqlserver.repository.IStatusDetailsRepository;
import com.springboot.sqlserver.repository.ISummaryRepository;
import com.springboot.sqlserver.repository.IVoterVariationRepository;
import com.springboot.sqlserver.repository.NameVariationPojo;
import com.springboot.sqlserver.util.CriffUtil;

@Service
public class CriffReportService {

	@Autowired
	IHeaderRepository headerRepo;
	
	@Autowired
	ICriffRepository criffRepo;

	@Autowired
	IStatusDetailsRepository statusRepo;

	@Autowired
	IRequestRepository reqRep;

	@Autowired
	IAddressRepository addRepo;

	@Autowired
	INameVariationRepository nameVariationRepo;
	
	@Autowired
	IAddressVariationRepository addressVariationRepo;

	@Autowired
	IPanVariationRepository panVariationRepo;

	@Autowired
	IDlVariationRepository dlVariationRepo;

	@Autowired
	IDobVariationRepository dobVariationRepo;

	@Autowired
	IVoterVariationRepository voterVariationRepo;

	@Autowired
	IPassportVariationRepository passportVariationRepo;

	@Autowired
	IPhoneVarificationRepository phoneVariationRepo;

	@Autowired
	IRationCardVariationRepository rationCardVariationRepo;

	@Autowired
	IEmailVariationRepository emailVariationRepo;

	@Autowired
	IDerivedAttrubutesRepository derivedAtRepo;

	@Autowired
	IPrimaryAcSummaryRepository primaryAcSumRepo;

	@Autowired
	ISecondaryAcSummaryRepository secondaryAcSumRepo;

	@Autowired
	IAlertRepository alertRepo;

	@Autowired
	IScoreRepository scoreRepo;

	@Autowired
	IResponseStatusRepository respPojoRepo;

	@Autowired
	IPrimarySummaryRepository iprimarySumRepo;

	@Autowired
	ISecondarySummaryRepository isecondarySumRepo;

	@Autowired
	ISummaryRepository isumRepo;

	@Autowired
	IGrpPrimaryRepository igrpPrimaryRepo;

	@Autowired
	IGrpSecondarySummaryRepository igrpSecondaryRepo;

	@Autowired
	IGrpSummaryRepository igrpsumRepo;

	@Autowired
	IPrintableReportRepository printRepo;

	@Autowired
	IEnquiryHistoryRepository enquiryRepo;

	private static final Logger logger = LoggerFactory.getLogger(CriffReportService.class);
	private static XPath xPath = XPathFactory.newInstance().newXPath();
	private static Object result;
	private static Node nNode;
	private static String refId;
	private static String timestamp = new CriffUtil().timeStamp();
	private static XPathExpression exprs = null;

	public int save(Criff criff) throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException, GeneralSecurityException, InterruptedException {
		// TODO Auto-generated method stub
		logger.info(criff.toString());
		if(criff.getCriffXmlUrl().contains("xml"))
		{
			logger.info("valid XML");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(criff.getCriffXmlUrl());
			doc.getDocumentElement().normalize();
			refId=criff.getCibilid();
			//int criffData = criffTable(criff);
			
			int printableReportStatus = printableR(doc);
			int headerDataStatus = headerData(doc);
			int statusData = statusDetails(doc);
			int requestDataStatus = requestData(doc,criff);
			int nameVariationStatus = nameVariation(doc);
			int addressVariatonStatus = adderssVariation(doc);
			int panVariationStatus = panVariation(doc);
			int dlVariationStatus = dlVariation(doc);
			int dobVariationStatus = dobVariation(doc);
			int voterVariationStatus = voterVariation(doc);
			int passPortVariationStatus = passPortVariation(doc);
			int phVariationStatus = phVariation(doc);
			int rationCardVariationStatus = rationCardVariation(doc);
			int emailVaiationStatus = emailVaiation(doc);
			int derivedAttributes = derivedAt(doc);
			int primaryAcSummary = primaryAc(doc);
			int secondAcSummary = secondAc(doc);
			int alertStatus = alertS(doc);
			int scoreStatus = scoreS(doc);
			int enquiryHistoryStatus = enqhistory(doc);
			int responseStatus = responseS(doc);
			int priamarySummaryStatus = priamaryS(doc);
			int secondarySummaryStatus = secondaryS(doc);
			int summaryStatus = summaryS(doc);
			int grpPrimarySummaryStatus = grpPrimaryS(doc);
			int grpSecondarySummaryStatus = grpSecondaryS(doc);
			int grpSummaryStatus = grpSummaryS(doc);
			
			logger.info("printableReportStatus"+printableReportStatus);
			logger.info("headerDataStatus"+headerDataStatus);
			logger.info("statusData"+statusData);
			logger.info("requestDataStatus"+requestDataStatus);
			logger.info("nameVariationStatus"+nameVariationStatus);
			logger.info("addressVariatonStatus"+addressVariatonStatus);
			logger.info("panVariationStatus"+panVariationStatus);
			logger.info("dlVariationStatus"+dlVariationStatus);
			
			logger.info("derivedAttributes"+derivedAttributes);
			logger.info("emailVaiationStatus"+emailVaiationStatus);
			logger.info("rationCardVariationStatus"+rationCardVariationStatus);
			logger.info("phVariationStatus"+phVariationStatus);
			logger.info("passPortVariationStatus"+passPortVariationStatus);
			logger.info("voterVariationStatus"+voterVariationStatus);
			logger.info("dobVariationStatus "+dobVariationStatus);
			
			logger.info("primaryAcSummary "+primaryAcSummary);
			logger.info("derivedAttributes "+derivedAttributes);
			logger.info("emailVaiationStatus "+emailVaiationStatus);
			logger.info("rationCardVariationStatus "+rationCardVariationStatus);
			logger.info("phVariationStatus "+phVariationStatus);
			logger.info("passPortVariationStatus "+passPortVariationStatus);
			logger.info("voterVariationStatus "+voterVariationStatus);
			logger.info("dobVariationStatus "+dobVariationStatus);
			
			logger.info("grpSecondarySummaryStatus "+grpSecondarySummaryStatus);
			logger.info("grpPrimarySummaryStatus "+grpPrimarySummaryStatus);
			logger.info("summaryStatus "+summaryStatus);
			logger.info("secondarySummaryStatus "+secondarySummaryStatus);
			logger.info("priamarySummaryStatus "+priamarySummaryStatus);
			logger.info("responseStatus "+responseStatus);
			logger.info("enquiryHistoryStatus "+enquiryHistoryStatus);
			logger.info("scoreStatus "+scoreStatus);
			logger.info("alertStatus "+alertStatus);
			logger.info("secondAcSummary "+secondAcSummary);
			logger.info("grpSummaryStatus:: "+grpSummaryStatus);
			logger.info("completed");
			return 1;
		}
		else {
			logger.info("not a valid XML");
			return 0;
		}
	}
	/*private int criffTable(Criff criff) {
		// TODO Auto-generated method stub
		criffRepo.save(criff);
		return 1;
	}*/
	
	private int headerData(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/HEADER");
		result = exprs.evaluate(doc, XPathConstants.NODE);
		nNode = (Node) result;
		try {
			HeaderPojo headerPojo = new HeaderPojo();
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				headerPojo.setHno(new CriffUtil().ranDomNum());
				headerPojo.setRefid(refId);
				headerPojo.settIME_sTAMP(timestamp);
				if (eElement.getElementsByTagName("DATE-OF-REQUEST").item(0) != null) {

					headerPojo.setdATE_oF_rEQUEST(
							eElement.getElementsByTagName("DATE-OF-REQUEST").item(0).getTextContent());
				} else {
					headerPojo.setdATE_oF_rEQUEST("NA");
				}

				if (eElement.getElementsByTagName("PREPARED-FOR").item(0) != null) {
					headerPojo.setpREPARED_fOR(eElement.getElementsByTagName("PREPARED-FOR").item(0).getTextContent());
				} else {
					headerPojo.setpREPARED_fOR("NA");
				}

				if (eElement.getElementsByTagName("PREPARED-FOR-ID").item(0) != null) {
					headerPojo.setpREPARED_fOR_iD(
							eElement.getElementsByTagName("PREPARED-FOR-ID").item(0).getTextContent());
				} else {
					headerPojo.setpREPARED_fOR_iD("NA");
				}

				if (eElement.getElementsByTagName("DATE-OF-ISSUE").item(0) != null) {
					headerPojo
							.setdATE_oF_iSSUE(eElement.getElementsByTagName("DATE-OF-ISSUE").item(0).getTextContent());
				} else {
					headerPojo.setdATE_oF_iSSUE("NA");
				}

				if (eElement.getElementsByTagName("BATCH-ID").item(0) != null) {
					headerPojo.setbATCH_iD(eElement.getElementsByTagName("BATCH-ID").item(0).getTextContent());
				} else {
					headerPojo.setbATCH_iD("NA");
				}

				if (eElement.getElementsByTagName("REPORT-ID").item(0) != null) {
					//refId=eElement.getElementsByTagName("REPORT-ID").item(0).getTextContent();
					headerPojo.setrEPORT_iD(refId);
				} else {
					headerPojo.setrEPORT_iD("NA");
				}
				try {
					if (headerPojo != null) {
						System.out.println(headerPojo);
						logger.info("headerPojo :: "+headerPojo.toString());
						headerRepo.save(headerPojo);
						return 1;
					}
				} catch (Exception e) {
					logger.info("headers data insertion error:: " + e);
				}
			}
		} catch (Exception e) {
			logger.info("headers data parsing error:: " + e);
		}
		return 0;
	}
	
	private int printableR(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PRINTABLE-REPORT");
		result = exprs.evaluate(doc, XPathConstants.NODE);
		nNode = (Node) result;
		PrintableReportPojo printableReportPojo = new PrintableReportPojo();
		try {
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				if (eElement.getElementsByTagName("TYPE").item(0) != null) {
					printableReportPojo.settYPE(eElement.getElementsByTagName("TYPE").item(0).getTextContent());
				} else {
					printableReportPojo.settYPE("NA");
				}
				if (eElement.getElementsByTagName("FILE-NAME").item(0) != null) {
					printableReportPojo
							.setfILE_nAME(eElement.getElementsByTagName("FILE-NAME").item(0).getTextContent());
				} else {
					printableReportPojo.setfILE_nAME("NA");
				}
				printableReportPojo.setPno(new CriffUtil().ranDomNum());
				printableReportPojo.setRefId(refId);
				printableReportPojo.setTimestamp(timestamp);
				printRepo.save(printableReportPojo);
			}
			logger.info("printable Report :: " +printableReportPojo.toString());
			return 1;
		} catch (Exception e) {
			logger.info("printable insertion error:: " + e);
		}
		return 0;
	}

	private int enqhistory(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		EnquiryHistoryPojo enquiryHistoryPojo = null;
		exprs = xPath.compile("count(/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/INQUIRY-HISTORY/HISTORY)");
		result = exprs.evaluate(doc, XPathConstants.NUMBER);
		Double c = (Double) result;
		try {
			for (double i = 1; i <= c; i++) {
				exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/INQUIRY-HISTORY/HISTORY[" + i + "]");
				result = exprs.evaluate(doc, XPathConstants.NODE);
				nNode = (Node) result;
				enquiryHistoryPojo = new EnquiryHistoryPojo();
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					enquiryHistoryPojo.setEno(new CriffUtil().ranDomNum());
					enquiryHistoryPojo.setRefid(refId);
					enquiryHistoryPojo.setTimestamp(timestamp);
					if (eElement.getElementsByTagName("MEMBER-NAME").item(0) != null) {
						enquiryHistoryPojo
								.setmEMBER_nAME(eElement.getElementsByTagName("MEMBER-NAME").item(0).getTextContent());
					} else {
						enquiryHistoryPojo.setmEMBER_nAME("NA");
					}
					if (eElement.getElementsByTagName("INQUIRY-DATE").item(0) != null) {
						enquiryHistoryPojo.setiNQUIRY_dATE(
								eElement.getElementsByTagName("INQUIRY-DATE").item(0).getTextContent());
					} else {
						enquiryHistoryPojo.setiNQUIRY_dATE("NA");
					}
					if (eElement.getElementsByTagName("INQUIRY-DATE").item(0) != null) {
						enquiryHistoryPojo.setiNQUIRY_dATE(
								eElement.getElementsByTagName("INQUIRY-DATE").item(0).getTextContent());
					} else {
						enquiryHistoryPojo.setiNQUIRY_dATE("NA");
					}
					if (eElement.getElementsByTagName("PURPOSE").item(0) != null) {
						enquiryHistoryPojo
								.setpURPOSE(eElement.getElementsByTagName("PURPOSE").item(0).getTextContent());
					} else {
						enquiryHistoryPojo.setpURPOSE("NA");
					}
					if (eElement.getElementsByTagName("AMOUNT").item(0) != null) {
						enquiryHistoryPojo.setaMOUNT(eElement.getElementsByTagName("AMOUNT").item(0).getTextContent());
					} else {
						enquiryHistoryPojo.setaMOUNT("NA");
					}
					if (eElement.getElementsByTagName("REMARK").item(0) != null) {
						enquiryHistoryPojo.setrEMARK(eElement.getElementsByTagName("REMARK").item(0).getTextContent());
					} else {
						enquiryHistoryPojo.setrEMARK("NA");
					}
					logger.info("enquiryHistoryPojo:: "+enquiryHistoryPojo.toString());
					enquiryRepo.save(enquiryHistoryPojo);
				}
			}
			return 1;
		} catch (Exception e) {
			logger.info("enquiry history insertion error:: " + e);
		}
		return 0;
	}

	private int scoreS(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		ScorePojo scorePojo = new ScorePojo();
		exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/SCORES/SCORE");
		result = exprs.evaluate(doc, XPathConstants.NODE);
		nNode = (Node) result;
		try {
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				scorePojo.setSid(new CriffUtil().ranDomNum());
				scorePojo.setRefId(refId);
				scorePojo.setTimestamp(timestamp);
				
				if (eElement.getElementsByTagName("SCORE-TYPE").item(0) != null) {
					scorePojo.setsCORE_tYPE(eElement.getElementsByTagName("SCORE-TYPE").item(0).getTextContent());
				} else {
					scorePojo.setsCORE_tYPE("NA");
				}

				if (eElement.getElementsByTagName("SCORE-VALUE").item(0) != null) {
					scorePojo.setsCORE_vALUE(eElement.getElementsByTagName("SCORE-VALUE").item(0).getTextContent());
				} else {
					scorePojo.setsCORE_vALUE("NA");
				}

				if (eElement.getElementsByTagName("SCORE-FACTORS").item(0) != null) {
					scorePojo.setsCORE_fACTORS(eElement.getElementsByTagName("SCORE-FACTORS").item(0).getTextContent());
					scorePojo = new ScoringFactores().sc(scorePojo);//scorePojo.getsCORE_fACTORS();
				} else {
					scorePojo.setsCORE_fACTORS("NA");
				}
				logger.info("SCORE:: "+scorePojo.toString());
				scoreRepo.save(scorePojo);

			}
			return 1;
		} catch (Exception e) {
			logger.info("Scores insertion error:: " + e);
		}
		return 0;
	}

	

	private int grpSummaryS(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		GrpSummary grpsummary = new GrpSummary();
		exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/GRP-RESPONSES/SUMMARY");
		result = exprs.evaluate(doc, XPathConstants.NODE);
		nNode = (Node) result;
		try {
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				grpsummary.setGsno(new CriffUtil().ranDomNum());
				grpsummary.setRefId(refId);
				grpsummary.setTimestamp(timestamp);
				if (eElement.getElementsByTagName("STATUS").item(0) != null) {
					grpsummary.setsTATUS(eElement.getElementsByTagName("STATUS").item(0).getTextContent());
				} else {
					grpsummary.setsTATUS("NA");
				}
				if (eElement.getElementsByTagName("TOTAL-RESPONSES").item(0) != null) {
					grpsummary.settOTAL_rESPONSES(
							eElement.getElementsByTagName("TOTAL-RESPONSES").item(0).getTextContent());
				} else {
					grpsummary.settOTAL_rESPONSES("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-OTHER-MFIS").item(0) != null) {
					grpsummary.setnO_oF_oTHER_mFIS(
							eElement.getElementsByTagName("NO-OF-OTHER-MFIS").item(0).getTextContent());
				} else {
					grpsummary.setnO_oF_oTHER_mFIS("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-DEFAULT-ACCOUNTS").item(0) != null) {
					grpsummary.setnO_oF_dEFAULT_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-DEFAULT-ACCOUNTS").item(0).getTextContent());
				} else {
					grpsummary.setnO_oF_dEFAULT_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("OWN-MFI-INDECATOR").item(0) != null) {
					grpsummary.setoWN_mFI_iNDECATOR(
							eElement.getElementsByTagName("OWN-MFI-INDECATOR").item(0).getTextContent());
				} else {
					grpsummary.setoWN_mFI_iNDECATOR("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-CLOSED-ACCOUNTS").item(0) != null) {
					grpsummary.setnO_oF_cLOSED_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-CLOSED-ACCOUNTS").item(0).getTextContent());
				} else {
					grpsummary.setnO_oF_cLOSED_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-ACTIVE-ACCOUNTS").item(0) != null) {
					grpsummary.setnO_oF_aCTIVE_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-ACTIVE-ACCOUNTS").item(0).getTextContent());
				} else {
					grpsummary.setnO_oF_aCTIVE_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-OWN-MFIS").item(0) != null) {
					grpsummary.setnO_oF_oWN_mFIS(
							eElement.getElementsByTagName("NO-OF-OWN-MFIS").item(0).getTextContent());
				} else {
					grpsummary.setnO_oF_oWN_mFIS("NA");
				}
				logger.info("grpsummary "+ grpsummary.toString());
				igrpsumRepo.save(grpsummary);
			}
			return 1;
		} catch (Exception e) {
			logger.info("grp insertion summary error::" + e);
		}
		return 0;
	}

	private int grpSecondaryS(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		GrpSecondarySummary grpsecondarySummary = new GrpSecondarySummary();
		exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/GRP-RESPONSES/SECONDARY-SUMMARY");
		result = exprs.evaluate(doc, XPathConstants.NODE);
		nNode = (Node) result;
		try {
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				grpsecondarySummary.setGrpsno(new CriffUtil().ranDomNum());
				grpsecondarySummary.setRefId(refId);
				grpsecondarySummary.setTimestamp(timestamp);
				if (eElement.getElementsByTagName("NO-OF-DEFAULT-ACCOUNTS").item(0) != null) {
					grpsecondarySummary.setnO_oF_dEFAULT_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-DEFAULT-ACCOUNTS").item(0).getTextContent());
				} else {
					grpsecondarySummary.setnO_oF_dEFAULT_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("TOTAL-RESPONSES").item(0) != null) {
					grpsecondarySummary.settOTAL_rESPONSES(
							eElement.getElementsByTagName("TOTAL-RESPONSES").item(0).getTextContent());
				} else {
					grpsecondarySummary.settOTAL_rESPONSES("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-CLOSED-ACCOUNTS").item(0) != null) {
					grpsecondarySummary.setnO_oF_cLOSED_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-CLOSED-ACCOUNTS").item(0).getTextContent());
				} else {
					grpsecondarySummary.setnO_oF_cLOSED_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-ACTIVE-ACCOUNTS").item(0) != null) {
					grpsecondarySummary.setnO_oF_aCTIVE_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-ACTIVE-ACCOUNTS").item(0).getTextContent());
				} else {
					grpsecondarySummary.setnO_oF_aCTIVE_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-OTHER-MFIS").item(0) != null) {
					grpsecondarySummary.setnO_oF_oTHER_mFIS(
							eElement.getElementsByTagName("NO-OF-OTHER-MFIS").item(0).getTextContent());
				} else {
					grpsecondarySummary.setnO_oF_oTHER_mFIS("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-OWN-MFIS").item(0) != null) {
					grpsecondarySummary.setnO_oF_oWN_mFIS(
							eElement.getElementsByTagName("NO-OF-OWN-MFIS").item(0).getTextContent());
				} else {
					grpsecondarySummary.setnO_oF_oWN_mFIS("NA");
				}
				logger.info("grpsecondarySummary:: "+ grpsecondarySummary.toString());
				igrpSecondaryRepo.save(grpsecondarySummary);
			}
			return 1;
		} catch (Exception e) {
			logger.info("Grp secondary data insertion error:: " + e);
		}
		return 0;
	}

	private int grpPrimaryS(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		GrpPrimarySummeryPojo grpprimarySummaryPojo = new GrpPrimarySummeryPojo();
		exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/GRP-RESPONSES/PRIMARY-SUMMARY");
		result = exprs.evaluate(doc, XPathConstants.NODE);
		nNode = (Node) result;
		try {
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				grpprimarySummaryPojo.setGrpno(new CriffUtil().ranDomNum());
				grpprimarySummaryPojo.setRefId(refId);
				grpprimarySummaryPojo.setTimestamp(timestamp);
				if (eElement.getElementsByTagName("NO-OF-DEFAULT-ACCOUNTS").item(0) != null) {
					grpprimarySummaryPojo.setnO_oF_dEFAULT_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-DEFAULT-ACCOUNTS").item(0).getTextContent());
				} else {
					grpprimarySummaryPojo.setnO_oF_dEFAULT_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("TOTAL-RESPONSES").item(0) != null) {
					grpprimarySummaryPojo.settOTAL_rESPONSES(
							eElement.getElementsByTagName("TOTAL-RESPONSES").item(0).getTextContent());
				} else {
					grpprimarySummaryPojo.settOTAL_rESPONSES("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-CLOSED-ACCOUNTS").item(0) != null) {
					grpprimarySummaryPojo.setnO_oF_cLOSED_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-CLOSED-ACCOUNTS").item(0).getTextContent());
				} else {
					grpprimarySummaryPojo.setnO_oF_cLOSED_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-ACTIVE-ACCOUNTS").item(0) != null) {
					grpprimarySummaryPojo.setnO_oF_aCTIVE_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-ACTIVE-ACCOUNTS").item(0).getTextContent());
				} else {
					grpprimarySummaryPojo.setnO_oF_aCTIVE_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-OTHER-MFIS").item(0) != null) {
					grpprimarySummaryPojo.setnO_oF_oTHER_mFIS(
							eElement.getElementsByTagName("NO-OF-OTHER-MFIS").item(0).getTextContent());
				} else {
					grpprimarySummaryPojo.setnO_oF_oTHER_mFIS("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-OWN-MFIS").item(0) != null) {
					grpprimarySummaryPojo.setnO_oF_oWN_mFIS(
							eElement.getElementsByTagName("NO-OF-OWN-MFIS").item(0).getTextContent());
				} else {
					grpprimarySummaryPojo.setnO_oF_oWN_mFIS("NA");
				}
				logger.info("grpprimarySummaryPojo :: "+ grpprimarySummaryPojo.toString());
				igrpPrimaryRepo.save(grpprimarySummaryPojo);
			}
			return 1;
		} catch (Exception e) {
			logger.info("grp primary data insertion error:: " + e);
		}
		return 0;
	}

	private int summaryS(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		Summary summary = new Summary();
		exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/INDV-RESPONSES/SUMMARY");
		result = exprs.evaluate(doc, XPathConstants.NODE);
		nNode = (Node) result;
		try {
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				summary.setInso(new CriffUtil().ranDomNum());
				summary.setRefId(refId);
				summary.setTimestamp(timestamp);
				if (eElement.getElementsByTagName("STATUS").item(0) != null) {
					summary.setsTATUS(eElement.getElementsByTagName("STATUS").item(0).getTextContent());
				} else {
					summary.setsTATUS("NA");
				}
				if (eElement.getElementsByTagName("TOTAL-RESPONSES").item(0) != null) {
					summary.settOTAL_rESPONSES(
							eElement.getElementsByTagName("TOTAL-RESPONSES").item(0).getTextContent());
				} else {
					summary.settOTAL_rESPONSES("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-OTHER-MFIS").item(0) != null) {
					summary.setnO_oF_oTHER_mFIS(
							eElement.getElementsByTagName("NO-OF-OTHER-MFIS").item(0).getTextContent());
				} else {
					summary.setnO_oF_oTHER_mFIS("NA");
				}

				if (eElement.getElementsByTagName("NO-OF-DEFAULT-ACCOUNTS").item(0) != null) {
					summary.setnO_oF_dEFAULT_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-DEFAULT-ACCOUNTS").item(0).getTextContent());
				} else {
					summary.setnO_oF_dEFAULT_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("OWN-MFI-INDECATOR").item(0) != null) {
					summary.setoWN_mFI_iNDECATOR(
							eElement.getElementsByTagName("OWN-MFI-INDECATOR").item(0).getTextContent());
				} else {
					summary.setoWN_mFI_iNDECATOR("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-CLOSED-ACCOUNTS").item(0) != null) {
					summary.setnO_oF_cLOSED_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-CLOSED-ACCOUNTS").item(0).getTextContent());
				} else {
					summary.setnO_oF_cLOSED_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("NO-OF-ACTIVE-ACCOUNTS").item(0) != null) {
					summary.setnO_oF_aCTIVE_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-ACTIVE-ACCOUNTS").item(0).getTextContent());
				} else {
					summary.setnO_oF_aCTIVE_aCCOUNTS("NA");
				}

				if (eElement.getElementsByTagName("NO-OF-OWN-MFIS").item(0) != null) {
					summary.setnO_oF_oWN_mFIS(eElement.getElementsByTagName("NO-OF-OWN-MFIS").item(0).getTextContent());
				} else {
					summary.setnO_oF_oWN_mFIS("NA");
				}
				logger.info("summary:: "+ summary.toString());
				isumRepo.save(summary);
			}
			return 1;
		} catch (Exception e) {
			logger.info("grp summary insertion data :: " + e);
		}
		return 0;
	}

	private int secondaryS(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		SecondarySummary secondarySummary = new SecondarySummary();
		exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/INDV-RESPONSES/SECONDARY-SUMMARY");
		result = exprs.evaluate(doc, XPathConstants.NODE);
		nNode = (Node) result;
		try {
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				secondarySummary.setIsno(new CriffUtil().ranDomNum());
				secondarySummary.setRefId(refId);
				secondarySummary.setTimestamp(timestamp);
				if (eElement.getElementsByTagName("NO-OF-DEFAULT-ACCOUNTS").item(0) != null) {
					secondarySummary.setnO_oF_dEFAULT_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-DEFAULT-ACCOUNTS").item(0).getTextContent());
				} else {
					secondarySummary.setnO_oF_dEFAULT_aCCOUNTS("NA");
				}

				if (eElement.getElementsByTagName("TOTAL-RESPONSES").item(0) != null) {
					secondarySummary.settOTAL_rESPONSES(
							eElement.getElementsByTagName("TOTAL-RESPONSES").item(0).getTextContent());
				} else {
					secondarySummary.settOTAL_rESPONSES("NA");
				}

				if (eElement.getElementsByTagName("NO-OF-CLOSED-ACCOUNTS").item(0) != null) {
					secondarySummary.setnO_oF_cLOSED_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-CLOSED-ACCOUNTS").item(0).getTextContent());
				} else {
					secondarySummary.setnO_oF_cLOSED_aCCOUNTS("NA");
				}

				if (eElement.getElementsByTagName("NO-OF-ACTIVE-ACCOUNTS").item(0) != null) {
					secondarySummary.setnO_oF_aCTIVE_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-ACTIVE-ACCOUNTS").item(0).getTextContent());
				} else {
					secondarySummary.setnO_oF_aCTIVE_aCCOUNTS("NA");
				}

				if (eElement.getElementsByTagName("NO-OF-OTHER-MFIS").item(0) != null) {
					secondarySummary.setnO_oF_oTHER_mFIS(
							eElement.getElementsByTagName("NO-OF-OTHER-MFIS").item(0).getTextContent());
				} else {
					secondarySummary.setnO_oF_oTHER_mFIS("NA");
				}

				if (eElement.getElementsByTagName("NO-OF-OWN-MFIS").item(0) != null) {
					secondarySummary.setnO_oF_oWN_mFIS(
							eElement.getElementsByTagName("NO-OF-OWN-MFIS").item(0).getTextContent());
				} else {
					secondarySummary.setnO_oF_oWN_mFIS("NA");
				}
				logger.info("secondarySummary:: "+ secondarySummary.toString());
				isecondarySumRepo.save(secondarySummary);
			}
			return 1;
		} catch (Exception e) {
			logger.info("secondary summary insertion data error:: " + e);
		}
		return 0;
	}

	private int priamaryS(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		PrimarySummeryPojo primarySummaryPojo = new PrimarySummeryPojo();
		exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/INDV-RESPONSES/PRIMARY-SUMMARY");
		result = exprs.evaluate(doc, XPathConstants.NODE);
		nNode = (Node) result;
		try {
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				primarySummaryPojo.setIndno(new CriffUtil().ranDomNum());
				primarySummaryPojo.setRefId(refId);
				primarySummaryPojo.setTimestamp(timestamp);
				if (eElement.getElementsByTagName("NO-OF-DEFAULT-ACCOUNTS").item(0) != null) {
					primarySummaryPojo.setnO_oF_dEFAULT_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-DEFAULT-ACCOUNTS").item(0).getTextContent());
				} else {
					primarySummaryPojo.setnO_oF_dEFAULT_aCCOUNTS("NA");
				}

				if (eElement.getElementsByTagName("TOTAL-RESPONSES").item(0) != null) {
					primarySummaryPojo.settOTAL_rESPONSES(
							eElement.getElementsByTagName("TOTAL-RESPONSES").item(0).getTextContent());
				} else {
					primarySummaryPojo.settOTAL_rESPONSES("NA");
				}

				if (eElement.getElementsByTagName("NO-OF-CLOSED-ACCOUNTS").item(0) != null) {
					primarySummaryPojo.setnO_oF_cLOSED_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-CLOSED-ACCOUNTS").item(0).getTextContent());
				} else {
					primarySummaryPojo.setnO_oF_cLOSED_aCCOUNTS("NA");
				}

				if (eElement.getElementsByTagName("NO-OF-ACTIVE-ACCOUNTS").item(0) != null) {
					primarySummaryPojo.setnO_oF_aCTIVE_aCCOUNTS(
							eElement.getElementsByTagName("NO-OF-ACTIVE-ACCOUNTS").item(0).getTextContent());
				} else {
					primarySummaryPojo.setnO_oF_aCTIVE_aCCOUNTS("NA");
				}

				if (eElement.getElementsByTagName("NO-OF-OTHER-MFIS").item(0) != null) {
					primarySummaryPojo.setnO_oF_oTHER_mFIS(
							eElement.getElementsByTagName("NO-OF-OTHER-MFIS").item(0).getTextContent());
				} else {
					primarySummaryPojo.setnO_oF_oTHER_mFIS("NA");
				}

				if (eElement.getElementsByTagName("NO-OF-OWN-MFIS").item(0) != null) {
					primarySummaryPojo.setnO_oF_oWN_mFIS(
							eElement.getElementsByTagName("NO-OF-OWN-MFIS").item(0).getTextContent());
				} else {
					primarySummaryPojo.setnO_oF_oWN_mFIS("NA");
				}
				logger.info("primarySummaryPojo:: "+ primarySummaryPojo.toString());
				iprimarySumRepo.save(primarySummaryPojo);
			}
			return 1;
		} catch (Exception e) {
			logger.info(" priamry summary data insertion error:: " + e);
		}
		return 0;
	}

	/*public static void main(String[] args) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
		CriffReportService cs = new CriffReportService();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse("http://3.6.24.30:8088/PDF/c973ad97_criff.xml");
		doc.getDocumentElement().normalize();
		cs.responseS(doc);
	}*/
	private int responseS(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		ResponsePojo respPojo = null;
		// List<ResponsePojo> resList = new ArrayList<ResponsePojo>();
		exprs = xPath.compile("count(//INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/RESPONSES/RESPONSE)");
		result = exprs.evaluate(doc, XPathConstants.NUMBER);
		Double count = (Double) result;
		String actualS = null;
		try {
			for (double i = 1; i <= count; i++) {
				exprs = xPath.compile(
						"/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/RESPONSES/RESPONSE[" + i + "]/LOAN-DETAILS");
				result = exprs.evaluate(doc, XPathConstants.NODE);
				nNode = (Node) result;
				respPojo = new ResponsePojo();
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					respPojo.setResno(new CriffUtil().ranDomNum());
					respPojo.setRefId(refId);
					respPojo.setTimestamp(timestamp);
					if (eElement.getElementsByTagName("ACCT-NUMBER").item(0) != null) {
						respPojo.setaCCT_nUMBER(
								eElement.getElementsByTagName("ACCT-NUMBER").item(0).getTextContent());
					} else {
						respPojo.setaCCT_nUMBER("NA");
					}
					if (eElement.getElementsByTagName("CREDIT-GUARANTOR").item(0) != null) {
						respPojo.setcREDIT_gUARANTOR(
								eElement.getElementsByTagName("CREDIT-GUARANTOR").item(0).getTextContent());
					} else {
						respPojo.setcREDIT_gUARANTOR("NA");
					}
					if (eElement.getElementsByTagName("ACCT-TYPE").item(0) != null) {
						respPojo.setaCCT_tYPE(eElement.getElementsByTagName("ACCT-TYPE").item(0).getTextContent());
					} else {
						respPojo.setaCCT_tYPE("NA");
					}
					if (eElement.getElementsByTagName("DATE-REPORTED").item(0) != null) {
						respPojo.setdATE_rEPORTED(
								eElement.getElementsByTagName("DATE-REPORTED").item(0).getTextContent());
					} else {
						respPojo.setdATE_rEPORTED("NA");
					}
					if (eElement.getElementsByTagName("OWNERSHIP-IND").item(0) != null) {
						respPojo.setoWNERSHIP_iND(
								eElement.getElementsByTagName("OWNERSHIP-IND").item(0).getTextContent());
					} else {
						respPojo.setoWNERSHIP_iND("NA");
					}
					if (eElement.getElementsByTagName("ACCOUNT-STATUS").item(0) != null) {
						respPojo.setaCCOUNT_sTATUS(
								eElement.getElementsByTagName("ACCOUNT-STATUS").item(0).getTextContent());
					} else {
						respPojo.setaCCOUNT_sTATUS("NA");
					}
					if (eElement.getElementsByTagName("DISBURSED-AMT").item(0) != null) {
						respPojo.setdISBURSED_aMT(
								eElement.getElementsByTagName("DISBURSED-AMT").item(0).getTextContent());
					} else {
						respPojo.setdISBURSED_aMT("NA");
					}
					if (eElement.getElementsByTagName("DISBURSED-DATE").item(0) != null) {
						respPojo.setdISBURSED_dATE(
								eElement.getElementsByTagName("DISBURSED-DATE").item(0).getTextContent());
					} else {
						respPojo.setdISBURSED_dATE("NA");
					}
					if (eElement.getElementsByTagName("CLOSED-DATE").item(0) != null) {
						respPojo.setcLOSED_dATE(eElement.getElementsByTagName("CLOSED-DATE").item(0).getTextContent());
					} else {
						respPojo.setcLOSED_dATE("NA");
					}
					if (eElement.getElementsByTagName("OVERDUE-AMT").item(0) != null) {
						respPojo.setoVERDUE_aMT(eElement.getElementsByTagName("OVERDUE-AMT").item(0).getTextContent());
					} else {
						respPojo.setoVERDUE_aMT("NA");
					}
					if (eElement.getElementsByTagName("WRITE-OFF-AMT").item(0) != null) {
						respPojo.setwRITE_oFF_aMT(
								eElement.getElementsByTagName("WRITE-OFF-AMT").item(0).getTextContent());
					} else {
						respPojo.setwRITE_oFF_aMT("NA");
					}
					if (eElement.getElementsByTagName("CURRENT-BAL").item(0) != null) {
						respPojo.setcURRENT_bAL(eElement.getElementsByTagName("CURRENT-BAL").item(0).getTextContent());
					} else {
						respPojo.setcURRENT_bAL("NA");
					}
					if (eElement.getElementsByTagName("SECURITY-STATUS").item(0) != null) {
						respPojo.setsECURITY_sTATUS(
								eElement.getElementsByTagName("SECURITY-STATUS").item(0).getTextContent());
					} else {
						respPojo.setsECURITY_sTATUS("NA");
					}
					if (eElement.getElementsByTagName("ORIGINAL-TERM").item(0) != null) {
						respPojo.setoRIGINAL_tERM(
								eElement.getElementsByTagName("ORIGINAL-TERM").item(0).getTextContent());
					} else {
						respPojo.setoRIGINAL_tERM("NA");
					}
					if (eElement.getElementsByTagName("COMBINED-PAYMENT-HISTORY").item(0) != null) {
						actualS = eElement.getElementsByTagName("COMBINED-PAYMENT-HISTORY").item(0).getTextContent();
						respPojo.setcOMBINED_pAYMENT_hISTORY(actualS.substring(0, 10));
					} else {
						respPojo.setcOMBINED_pAYMENT_hISTORY("NA");
					}
					if (eElement.getElementsByTagName("MATCHED-TYPE").item(0) != null) {
						respPojo.setmATCHED_tYPE(
								eElement.getElementsByTagName("MATCHED-TYPE").item(0).getTextContent());
					} else {
						respPojo.setmATCHED_tYPE("NA");
					}
					if (eElement.getElementsByTagName("WRITTEN-OFF_SETTLED-STATUS").item(0) != null) {
						respPojo.setwRITTEN_oFF_sETTLED_sTATUS(
								eElement.getElementsByTagName("WRITTEN-OFF_SETTLED-STATUS").item(0).getTextContent());
					} else {
						respPojo.setwRITTEN_oFF_sETTLED_sTATUS("NA");
					}
					if (eElement.getElementsByTagName("SETTLEMENT-AMT").item(0) != null) {
						respPojo.setsETTLEMENT_aMT(
								eElement.getElementsByTagName("SETTLEMENT-AMT").item(0).getTextContent());
					} else {
						respPojo.setsETTLEMENT_aMT("NA");
					}
					if (eElement.getElementsByTagName("SUIT-FILED_WILFUL-DEFAULT").item(0) != null) {
						respPojo.setsUIT_fILED_wILFUL_dEFAULT(
								eElement.getElementsByTagName("SUIT-FILED_WILFUL-DEFAULT").item(0).getTextContent());
					} else {
						respPojo.setsUIT_fILED_wILFUL_dEFAULT("NA");
					}
					if (eElement.getElementsByTagName("INSTALLMENT-AMT").item(0) != null) {
						respPojo.setiNSTALLMENT_aMT(
								eElement.getElementsByTagName("INSTALLMENT-AMT").item(0).getTextContent());
					} else {
						respPojo.setiNSTALLMENT_aMT("NA");
					}
					if (eElement.getElementsByTagName("PRINCIPAL-WRITE-OFF-AMT").item(0) != null) {
						respPojo.setpRINCIPAL_wRITE_oFF_aMT(
								eElement.getElementsByTagName("PRINCIPAL-WRITE-OFF-AMT").item(0).getTextContent());
					} else {
						respPojo.setpRINCIPAL_wRITE_oFF_aMT("NA");
					}
					try {
						if(actualS!=null) {
							System.out.println("actual String:: "+actualS);
							List<String> stringList = getSplitDataList(actualS);
							System.out.println("actualstring size:: "+stringList.size());
							int c=0;
							for(int f=stringList.size() ; f<48 ; f++)
							{
								stringList.add("NA");
								c++;
							}
							System.out.println("differencetobeAddtoList:: "+c);
							respPojo = getSplitStringMapping(stringList,respPojo);
							System.out.println("getting required string::between--> ,|<-----");
							List<String> stringLists = getStringList(actualS); 
							System.out.println(stringLists.toString());
							System.out.println("stringLists:: "+stringLists.size());
							System.out.println("getting dpds::::");
							List<Integer> dpdList = getDpdList(stringLists);
							respPojo=getDpdStringMapping(dpdList,respPojo);
							System.out.println(dpdList.size());
							System.out.println("before::" +dpdList);
							List<Integer> postiveList = dpdList.stream()
		                            .filter(number -> number >= 0)
		                            .collect(Collectors.toList());
							System.out.println(postiveList);
							Optional<Integer> maxNumber = postiveList.stream().max(Integer::compareTo);
							respPojo.setHigh_dpd(maxNumber.get());
							System.out.println("maxdpd:: "+maxNumber.get());
							int sumofdpd = postiveList.stream().reduce(0, Integer::sum);
							System.out.println("sumofDPD::" +sumofdpd);
							int avgDpd = sumofdpd/(postiveList.size());
							System.out.println("Avg:: "+avgDpd);
							respPojo.setAvg_dpd(avgDpd);
					        logger.info("respPojo:: "+ respPojo.toString());
					}
					
					}
					catch(Exception e) {
						logger.info("::insertion error "+e);
					}
					respPojoRepo.save(respPojo);
				}
			}
			return 1;
		} catch (Exception e) {
			logger.info("response data insertion error::: " + e);
		}
		return 0;
	}

	private ResponsePojo getDpdStringMapping(List<Integer> dpdList, ResponsePojo respPojo) {
		for(int l=0;l<dpdList.size();l++) {
			respPojo.setDpd0(dpdList.get(0));
			respPojo.setDpd1(dpdList.get(1));
			respPojo.setDpd2(dpdList.get(2));
			respPojo.setDpd3(dpdList.get(3));
			respPojo.setDpd4(dpdList.get(4));
			respPojo.setDpd5(dpdList.get(5));
			respPojo.setDpd6(dpdList.get(6));
			respPojo.setDpd7(dpdList.get(7));
			respPojo.setDpd8(dpdList.get(8));
			respPojo.setDpd9(dpdList.get(9));
			respPojo.setDpd10(dpdList.get(10));
			respPojo.setDpd11(dpdList.get(11));
			respPojo.setDpd12(dpdList.get(12));
			respPojo.setDpd13(dpdList.get(13));
			respPojo.setDpd14(dpdList.get(14));
			respPojo.setDpd15(dpdList.get(15));
			respPojo.setDpd16(dpdList.get(16));
			respPojo.setDpd17(dpdList.get(17));
			respPojo.setDpd18(dpdList.get(18));
			respPojo.setDpd19(dpdList.get(19));
			respPojo.setDpd20(dpdList.get(20));
			respPojo.setDpd21(dpdList.get(21));
			respPojo.setDpd22(dpdList.get(22));
			respPojo.setDpd23(dpdList.get(23));
			respPojo.setDpd24(dpdList.get(24));
			respPojo.setDpd25(dpdList.get(25));
			respPojo.setDpd26(dpdList.get(26));
			respPojo.setDpd27(dpdList.get(27));
			respPojo.setDpd28(dpdList.get(28));
			respPojo.setDpd29(dpdList.get(29));
			respPojo.setDpd30(dpdList.get(30));
			respPojo.setDpd31(dpdList.get(31));
			respPojo.setDpd32(dpdList.get(32));
			respPojo.setDpd33(dpdList.get(33));
			respPojo.setDpd34(dpdList.get(34));
			respPojo.setDpd35(dpdList.get(35));
			
			respPojo.setDpd36(dpdList.get(36));
			respPojo.setDpd37(dpdList.get(37));
			respPojo.setDpd38(dpdList.get(38));
			respPojo.setDpd39(dpdList.get(39));
			respPojo.setDpd40(dpdList.get(40));
			respPojo.setDpd41(dpdList.get(41));
			respPojo.setDpd42(dpdList.get(42));
			respPojo.setDpd43(dpdList.get(43));
			respPojo.setDpd44(dpdList.get(44));
			respPojo.setDpd45(dpdList.get(45));
			respPojo.setDpd46(dpdList.get(46));
			respPojo.setDpd47(dpdList.get(44));
			
		}// TODO Auto-generated method stub
		return respPojo;
	}

	private ResponsePojo getSplitStringMapping(List<String> stringList, ResponsePojo respPojo) {
		// TODO Auto-generated method stub
		for(int k=0;k<stringList.size()-1;k++) {
			respPojo.setSplit0(stringList.get(0));
			respPojo.setSplit1(stringList.get(1));
			respPojo.setSplit2(stringList.get(2));
			respPojo.setSplit3(stringList.get(3));
			respPojo.setSplit4(stringList.get(4));
			respPojo.setSplit5(stringList.get(5));
			respPojo.setSplit6(stringList.get(6));
			respPojo.setSplit7(stringList.get(7));
			respPojo.setSplit8(stringList.get(8));
			respPojo.setSplit9(stringList.get(9));
			respPojo.setSplit10(stringList.get(10));
			respPojo.setSplit11(stringList.get(11));
			respPojo.setSplit12(stringList.get(12));
			respPojo.setSplit13(stringList.get(13));
			respPojo.setSplit14(stringList.get(14));
			respPojo.setSplit15(stringList.get(15));
			respPojo.setSplit16(stringList.get(16));
			respPojo.setSplit17(stringList.get(17));
			respPojo.setSplit18(stringList.get(18));
			respPojo.setSplit19(stringList.get(19));
			respPojo.setSplit20(stringList.get(20));
			respPojo.setSplit21(stringList.get(21));
			respPojo.setSplit22(stringList.get(22));
			respPojo.setSplit23(stringList.get(23));
			respPojo.setSplit24(stringList.get(24));
			respPojo.setSplit25(stringList.get(25));
			respPojo.setSplit26(stringList.get(26));
			respPojo.setSplit27(stringList.get(27));
			respPojo.setSplit28(stringList.get(28));
			respPojo.setSplit29(stringList.get(29));
			respPojo.setSplit30(stringList.get(30));
			respPojo.setSplit31(stringList.get(31));
			respPojo.setSplit32(stringList.get(32));
			respPojo.setSplit33(stringList.get(33));
			respPojo.setSplit34(stringList.get(34));
			respPojo.setSplit35(stringList.get(35));
			
			respPojo.setSplit36(stringList.get(36));
			respPojo.setSplit37(stringList.get(37));
			respPojo.setSplit38(stringList.get(38));
			respPojo.setSplit39(stringList.get(39));
			respPojo.setSplit40(stringList.get(40));
			respPojo.setSplit41(stringList.get(41));
			respPojo.setSplit42(stringList.get(42));
			respPojo.setSplit43(stringList.get(43));
			respPojo.setSplit44(stringList.get(44));
			respPojo.setSplit45(stringList.get(45));
		}
		return respPojo;
	}

	private List<String> getSplitDataList(String s) {
		// TODO Auto-generated method stub
		List<String> sList = new ArrayList<String>();
		String[] arrOfStr = s.split("\\|");
        for (String w : arrOfStr) {
        	 
        	 sList.add(w);
        } 
		return sList;
	}

	private List<Integer> getDpdList(List<String> stringList) {
		// TODO Auto-generated method stub
		System.out.println(stringList.toString());
		List<Integer> dpdValueList = new ArrayList<Integer>();
		int y=0,i;
		int addingsize = 48-stringList.size();
		int listSizes=stringList.size()+addingsize;
		System.out.println(listSizes);
		System.out.println(stringList.size());
		for(i=0; i<listSizes; i++)
		{
				//System.out.println(i);
				if(i<stringList.size())
				{
					String res = stringList.get(i);
					if(res.contains("XXX") && res.length()==3)
					{
						y=0;
					}
					else {
						y=Integer.parseInt(res);
					}
				}
				else {
					y=-1;
				}
			dpdValueList.add(y);
		}
		return dpdValueList;
	}

	private List<String> getStringList(String s) {
		// TODO Auto-generated method stub
		System.out.println("sss:: "+s);
		List<String> sList = new ArrayList<String>();
		String[] arrOfStr = s.split("\\|");
        for (String w : arrOfStr) {
        	 String extractedSubstring = w.substring(w.indexOf(",") + 1, w.indexOf("/"));
        	 sList.add(extractedSubstring);
        } 
		return sList;
	}
	
	
	private int alertS(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		Alerts alerts = null;
		// List<Alerts> alertsList = new ArrayList<Alerts>();
		exprs = xPath.compile("count(/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/ALERTS/ALERT)");
		result = exprs.evaluate(doc, XPathConstants.NUMBER);
		Double alcount = (Double) result;
		try {
			for (double i = 1; i <= alcount; i++) {
				exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/ALERTS/ALERT[" + i + "]");
				result = exprs.evaluate(doc, XPathConstants.NODE);
				nNode = (Node) result;
				alerts = new Alerts();
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					alerts.setSno(new CriffUtil().ranDomNum());
					alerts.setRefId(refId);
					alerts.setTimestamp(timestamp);
					if (eElement.getElementsByTagName("ALERT-DESC").item(0) != null) {
						alerts.setaLERT_dESC(eElement.getElementsByTagName("ALERT-DESC").item(0).getTextContent());
					} else {
						alerts.setaLERT_dESC("NA");
					}
					logger.info("alerts::: "+ alerts.toString());
					alertRepo.save(alerts);
				}
			}
			return 1;
		} catch (Exception e) {
			logger.info("alerts data insertion error:: " + e);
		}
		return 0;
	}

	private int secondAc(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		SecondaryAccountsSummary secondaryAccountsSummaryPojo = new SecondaryAccountsSummary();
		exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/ACCOUNTS-SUMMARY/SECONDARY-ACCOUNTS-SUMMARY");
		result = exprs.evaluate(doc, XPathConstants.NODE);
		nNode = (Node) result;
		try {
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				secondaryAccountsSummaryPojo.setSano(new CriffUtil().ranDomNum());
				secondaryAccountsSummaryPojo.setRefId(refId);
				secondaryAccountsSummaryPojo.setTimestamp(timestamp);
				if (eElement.getElementsByTagName("SECONDARY-NUMBER-OF-ACCOUNTS").item(0) != null) {
					secondaryAccountsSummaryPojo.setsECONDARY_nUMBER_oF_aCCOUNTS(
							eElement.getElementsByTagName("SECONDARY-NUMBER-OF-ACCOUNTS").item(0).getTextContent());
				} else {
					secondaryAccountsSummaryPojo.setsECONDARY_nUMBER_oF_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("SECONDARY-ACTIVE-NUMBER-OF-ACCOUNTS").item(0) != null) {
					secondaryAccountsSummaryPojo.setsECONDARY_aCTIVE_nUMBER_oF_aCCOUNTS(eElement
							.getElementsByTagName("SECONDARY-ACTIVE-NUMBER-OF-ACCOUNTS").item(0).getTextContent());
				} else {
					secondaryAccountsSummaryPojo.setsECONDARY_aCTIVE_nUMBER_oF_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("SECONDARY-OVERDUE-NUMBER-OF-ACCOUNTS").item(0) != null) {
					secondaryAccountsSummaryPojo.setsECONDARY_oVERDUE_nUMBER_oF_aCCOUNTS(eElement
							.getElementsByTagName("SECONDARY-OVERDUE-NUMBER-OF-ACCOUNTS").item(0).getTextContent());
				} else {
					secondaryAccountsSummaryPojo.setsECONDARY_oVERDUE_nUMBER_oF_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("SECONDARY-SECURED-NUMBER-OF-ACCOUNTS").item(0) != null) {
					secondaryAccountsSummaryPojo.setsECONDARY_sECURED_nUMBER_oF_aCCOUNTS(eElement
							.getElementsByTagName("SECONDARY-SECURED-NUMBER-OF-ACCOUNTS").item(0).getTextContent());
				} else {
					secondaryAccountsSummaryPojo.setsECONDARY_sECURED_nUMBER_oF_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("SECONDARY-UNSECURED-NUMBER-OF-ACCOUNTS").item(0) != null) {
					secondaryAccountsSummaryPojo.setsECONDARY_uNSECURED_nUMBER_oF_aCCOUNTS(eElement
							.getElementsByTagName("SECONDARY-UNSECURED-NUMBER-OF-ACCOUNTS").item(0).getTextContent());
				} else {
					secondaryAccountsSummaryPojo.setsECONDARY_uNSECURED_nUMBER_oF_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("SECONDARY-UNTAGGED-NUMBER-OF-ACCOUNTS").item(0) != null) {
					secondaryAccountsSummaryPojo.setsECONDARY_uNTAGGED_nUMBER_oF_aCCOUNTS(eElement
							.getElementsByTagName("SECONDARY-UNTAGGED-NUMBER-OF-ACCOUNTS").item(0).getTextContent());
				} else {
					secondaryAccountsSummaryPojo.setsECONDARY_uNTAGGED_nUMBER_oF_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("SECONDARY-CURRENT-BALANCE").item(0) != null) {
					secondaryAccountsSummaryPojo.setsECONDARY_cURRENT_bALANCE(
							eElement.getElementsByTagName("SECONDARY-CURRENT-BALANCE").item(0).getTextContent());
				} else {
					secondaryAccountsSummaryPojo.setsECONDARY_cURRENT_bALANCE("NA");
				}
				if (eElement.getElementsByTagName("SECONDARY-SANCTIONED-AMOUNT").item(0) != null) {
					secondaryAccountsSummaryPojo.setsECONDARY_sANCTIONED_aMOUNT(
							eElement.getElementsByTagName("SECONDARY-SANCTIONED-AMOUNT").item(0).getTextContent());
				} else {
					secondaryAccountsSummaryPojo.setsECONDARY_sANCTIONED_aMOUNT("NA");
				}
				if (eElement.getElementsByTagName("SECONDARY-DISBURSED-AMOUNT").item(0) != null) {
					secondaryAccountsSummaryPojo.setsECONDARY_dISBURSED_aMOUNT(
							eElement.getElementsByTagName("SECONDARY-DISBURSED-AMOUNT").item(0).getTextContent());
				} else {
					secondaryAccountsSummaryPojo.setsECONDARY_dISBURSED_aMOUNT("NA");
				}
				logger.info("secondaryAccountsSummaryPojo"+ secondaryAccountsSummaryPojo.toString());
				secondaryAcSumRepo.save(secondaryAccountsSummaryPojo);
			}
			return 1;
		} catch (Exception e) {
			logger.info("Secondary ac data insertion error :: " + e);
		}
		return 0;
	}

	private int primaryAc(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		PrimaryAccountsSummaryPojo primaryAccountsSummaryPojo = new PrimaryAccountsSummaryPojo();
		exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/ACCOUNTS-SUMMARY/PRIMARY-ACCOUNTS-SUMMARY");
		result = exprs.evaluate(doc, XPathConstants.NODE);
		nNode = (Node) result;
		try {
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				primaryAccountsSummaryPojo.setPno(new CriffUtil().ranDomNum());
				primaryAccountsSummaryPojo.setRefId(refId);
				primaryAccountsSummaryPojo.setTimestamp(timestamp);
				if (eElement.getElementsByTagName("PRIMARY-NUMBER-OF-ACCOUNTS").item(0) != null) {
					primaryAccountsSummaryPojo.setpRIMARY_nUMBER_oF_aCCOUNTS(
							eElement.getElementsByTagName("PRIMARY-NUMBER-OF-ACCOUNTS").item(0).getTextContent());
				} else {
					primaryAccountsSummaryPojo.setpRIMARY_nUMBER_oF_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("PRIMARY-ACTIVE-NUMBER-OF-ACCOUNTS").item(0) != null) {
					primaryAccountsSummaryPojo.setpRIMARY_aCTIVE_nUMBER_oF_aCCOUNTS(eElement
							.getElementsByTagName("PRIMARY-ACTIVE-NUMBER-OF-ACCOUNTS").item(0).getTextContent());
				} else {
					primaryAccountsSummaryPojo.setpRIMARY_aCTIVE_nUMBER_oF_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("PRIMARY-OVERDUE-NUMBER-OF-ACCOUNTS").item(0) != null) {
					primaryAccountsSummaryPojo.setpRIMARY_oVERDUE_nUMBER_oF_aCCOUNTS(eElement
							.getElementsByTagName("PRIMARY-OVERDUE-NUMBER-OF-ACCOUNTS").item(0).getTextContent());
				} else {
					primaryAccountsSummaryPojo.setpRIMARY_oVERDUE_nUMBER_oF_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("PRIMARY-SECURED-NUMBER-OF-ACCOUNTS").item(0) != null) {
					primaryAccountsSummaryPojo.setpRIMARY_sECURED_nUMBER_oF_aCCOUNTS(eElement
							.getElementsByTagName("PRIMARY-SECURED-NUMBER-OF-ACCOUNTS").item(0).getTextContent());
				} else {
					primaryAccountsSummaryPojo.setpRIMARY_sECURED_nUMBER_oF_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("PRIMARY-UNSECURED-NUMBER-OF-ACCOUNTS").item(0) != null) {
					primaryAccountsSummaryPojo.setpRIMARY_uNSECURED_nUMBER_oF_aCCOUNTS(eElement
							.getElementsByTagName("PRIMARY-UNSECURED-NUMBER-OF-ACCOUNTS").item(0).getTextContent());
				} else {
					primaryAccountsSummaryPojo.setpRIMARY_uNSECURED_nUMBER_oF_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("PRIMARY-UNTAGGED-NUMBER-OF-ACCOUNTS").item(0) != null) {
					primaryAccountsSummaryPojo.setpRIMARY_uNTAGGED_nUMBER_oF_aCCOUNTS(eElement
							.getElementsByTagName("PRIMARY-UNTAGGED-NUMBER-OF-ACCOUNTS").item(0).getTextContent());
				} else {
					primaryAccountsSummaryPojo.setpRIMARY_uNTAGGED_nUMBER_oF_aCCOUNTS("NA");
				}
				if (eElement.getElementsByTagName("PRIMARY-CURRENT-BALANCE").item(0) != null) {
					primaryAccountsSummaryPojo.setpRIMARY_cURRENT_bALANCE(
							eElement.getElementsByTagName("PRIMARY-CURRENT-BALANCE").item(0).getTextContent());
				} else {
					primaryAccountsSummaryPojo.setpRIMARY_cURRENT_bALANCE("NA");
				}
				if (eElement.getElementsByTagName("PRIMARY-SANCTIONED-AMOUNT").item(0) != null) {
					primaryAccountsSummaryPojo.setpRIMARY_sANCTIONED_aMOUNT(
							eElement.getElementsByTagName("PRIMARY-SANCTIONED-AMOUNT").item(0).getTextContent());
				} else {
					primaryAccountsSummaryPojo.setpRIMARY_sANCTIONED_aMOUNT("NA");
				}
				if (eElement.getElementsByTagName("PRIMARY-DISBURSED-AMOUNT").item(0) != null) {
					primaryAccountsSummaryPojo.setpRIMARY_dISBURSED_aMOUNT(
							eElement.getElementsByTagName("PRIMARY-DISBURSED-AMOUNT").item(0).getTextContent());
				} else {
					primaryAccountsSummaryPojo.setpRIMARY_dISBURSED_aMOUNT("NA");
				}
				logger.info("primaryAccountsSummaryPojo:: "+ primaryAccountsSummaryPojo.toString());
				primaryAcSumRepo.save(primaryAccountsSummaryPojo);
			}
			return 1;
		} catch (Exception e) {
			logger.info("primary ac summary data insertion error:: " + e);
		}
		return 0;
	}

	private int derivedAt(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		DerivedAttributesPojo derivedAttributesPojo = new DerivedAttributesPojo();
		exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/ACCOUNTS-SUMMARY/DERIVED-ATTRIBUTES");
		result = exprs.evaluate(doc, XPathConstants.NODE);
		nNode = (Node) result;
		try {
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				derivedAttributesPojo.setDno(new CriffUtil().ranDomNum());
				derivedAttributesPojo.setRefId(refId);
				derivedAttributesPojo.setTimestamp(timestamp);
				if (eElement.getElementsByTagName("INQUIRIES-IN-LAST-SIX-MONTHS").item(0) != null) {
					derivedAttributesPojo.setiNQUIRIES_iN_lAST_sIX_mONTHS(
							eElement.getElementsByTagName("INQUIRIES-IN-LAST-SIX-MONTHS").item(0).getTextContent());
				} else {
					derivedAttributesPojo.setiNQUIRIES_iN_lAST_sIX_mONTHS("NA");
				}
				if (eElement.getElementsByTagName("LENGTH-OF-CREDIT-HISTORY-YEAR").item(0) != null) {
					derivedAttributesPojo.setlENGTH_oF_cREDIT_hISTORY_yEAR(
							eElement.getElementsByTagName("LENGTH-OF-CREDIT-HISTORY-YEAR").item(0).getTextContent());
				} else {
					derivedAttributesPojo.setlENGTH_oF_cREDIT_hISTORY_yEAR("NA");
				}
				if (eElement.getElementsByTagName("LENGTH-OF-CREDIT-HISTORY-MONTH").item(0) != null) {
					derivedAttributesPojo.setlENGTH_oF_cREDIT_hISTORY_mONTH(
							eElement.getElementsByTagName("LENGTH-OF-CREDIT-HISTORY-MONTH").item(0).getTextContent());
				} else {
					derivedAttributesPojo.setlENGTH_oF_cREDIT_hISTORY_mONTH("NA");
				}
				if (eElement.getElementsByTagName("AVERAGE-ACCOUNT-AGE-YEAR").item(0) != null) {
					derivedAttributesPojo.setaVERAGE_aCCOUNT_aGE_yEAR(
							eElement.getElementsByTagName("AVERAGE-ACCOUNT-AGE-YEAR").item(0).getTextContent());
				} else {
					derivedAttributesPojo.setaVERAGE_aCCOUNT_aGE_yEAR("NA");
				}
				if (eElement.getElementsByTagName("AVERAGE-ACCOUNT-AGE-MONTH").item(0) != null) {
					derivedAttributesPojo.setaVERAGE_aCCOUNT_aGE_mONTH(
							eElement.getElementsByTagName("AVERAGE-ACCOUNT-AGE-MONTH").item(0).getTextContent());
				} else {
					derivedAttributesPojo.setaVERAGE_aCCOUNT_aGE_mONTH("NA");
				}
				if (eElement.getElementsByTagName("NEW-ACCOUNTS-IN-LAST-SIX-MONTHS").item(0) != null) {
					derivedAttributesPojo.setnEW_aCCOUNTS_iN_lAST_sIX_mONTHS(
							eElement.getElementsByTagName("NEW-ACCOUNTS-IN-LAST-SIX-MONTHS").item(0).getTextContent());
				} else {
					derivedAttributesPojo.setnEW_aCCOUNTS_iN_lAST_sIX_mONTHS("NA");
				}
				if (eElement.getElementsByTagName("NEW-DELINQ-ACCOUNT-IN-LAST-SIX-MONTHS").item(0) != null) {
					derivedAttributesPojo.setnEW_dELINQ_aCCOUNT_iN_lAST_sIX_mONTHS(eElement
							.getElementsByTagName("NEW-DELINQ-ACCOUNT-IN-LAST-SIX-MONTHS").item(0).getTextContent());
				} else {
					derivedAttributesPojo.setnEW_dELINQ_aCCOUNT_iN_lAST_sIX_mONTHS("NA");
				}
				logger.info("derivedAttributesPojo:: "+ derivedAttributesPojo.toString());
				derivedAtRepo.save(derivedAttributesPojo);
			}
			return 1;
		} catch (Exception e) {
			logger.info("Dervied attributes data insertion error:: " + e);
		}
		return 0;
	}

	
	private int nameVariation(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		NameVariationPojo nameVariationPojo = null;
		// List<NameVariationPojo> nameVariationList = new
		// ArrayList<NameVariationPojo>();
		exprs = xPath.compile(
				"count(/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/NAME-VARIATIONS/VARIATION)");
		result = exprs.evaluate(doc, XPathConstants.NUMBER);
		Double nameVariationcount = (Double) result;
		try {
			for (double i = 1; i <= nameVariationcount; i++) {
				exprs = xPath.compile(
						"/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/NAME-VARIATIONS/VARIATION["
								+ i + "]");
				result = exprs.evaluate(doc, XPathConstants.NODE);
				nNode = (Node) result;
				nameVariationPojo = new NameVariationPojo();
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					nameVariationPojo.setDno(new CriffUtil().ranDomNum());
					nameVariationPojo.setRefId(refId);
					nameVariationPojo.setTimestamp(timestamp);
					if (eElement.getElementsByTagName("VALUE").item(0) != null) {
						nameVariationPojo.setValue(eElement.getElementsByTagName("VALUE").item(0).getTextContent());
					} else {
						nameVariationPojo.setValue("NA");
					}
					if (eElement.getElementsByTagName("REPORTED-DATE").item(0) != null) {
						nameVariationPojo.setReportedDate(
								eElement.getElementsByTagName("REPORTED-DATE").item(0).getTextContent());
					} else {
						nameVariationPojo.setReportedDate("NA");
					}
					// nameVariationList.add(nameVariationPojo);
					logger.info("nameVairations :: "+nameVariationPojo.toString());
					nameVariationRepo.save(nameVariationPojo);
				}
			}
			return 1;
		} catch (Exception e) {
			logger.info("Name Variation insertion error:: " + e);
		}
		return 0;
	}
	
	
	private int emailVaiation(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		EmailVariationPojo emailVariationPojo = new EmailVariationPojo();
		// List<EmailVariationPojo> emailVariationPojoPojoList = new
		// ArrayList<EmailVariationPojo>();
		exprs = xPath.compile(
				"count(/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/EMAIL-VARIATIONS/VARIATION)");
		result = exprs.evaluate(doc, XPathConstants.NUMBER);
		Double emailVariationPojocount = (Double) result;
		try {
			for (double i = 1; i <= emailVariationPojocount; i++) {
				exprs = xPath.compile(
						"/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/EMAIL-VARIATIONS/VARIATION["
								+ i + "]");
				result = exprs.evaluate(doc, XPathConstants.NODE);
				nNode = (Node) result;
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					emailVariationPojo.setEno(new CriffUtil().ranDomNum());
					emailVariationPojo.setRefId(refId);
					emailVariationPojo.setTimestamp(timestamp);
					if (eElement.getElementsByTagName("VALUE").item(0) != null) {
						emailVariationPojo.setValue(eElement.getElementsByTagName("VALUE").item(0).getTextContent());
					} else {
						emailVariationPojo.setValue("NA");
					}
					if (eElement.getElementsByTagName("REPORTED-DATE").item(0) != null) {
						emailVariationPojo.setReportedDate(
								eElement.getElementsByTagName("REPORTED-DATE").item(0).getTextContent());
					} else {
						emailVariationPojo.setReportedDate("NA");
					}
					// emailVariationPojoPojoList.add(emailVariationPojo);
					logger.info("emailVariationPojo:: "+ emailVariationPojo.toString());
					emailVariationRepo.save(emailVariationPojo);
				}
			}
			return 1;
		} catch (Exception e) {
			logger.info("Email Variation Pojo Data insertion error :: " + e);
		}
		return 0;
	}

	private int rationCardVariation(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		RationCardVariationPojo rationCardVariationPojo = new RationCardVariationPojo();
		// List<RationCardVariationPojo> rationCardVariationPojoList = new
		// ArrayList<RationCardVariationPojo>();
		exprs = xPath.compile(
				"count(/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/RATION-CARD-VARIATIONS/VARIATION)");
		result = exprs.evaluate(doc, XPathConstants.NUMBER);
		Double rationCardVariationPojocount = (Double) result;
		try {
			for (double i = 1; i <= rationCardVariationPojocount; i++) {
				exprs = xPath.compile(
						"/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/RATION-CARD-VARIATIONS/VARIATION["
								+ i + "]");
				result = exprs.evaluate(doc, XPathConstants.NODE);
				nNode = (Node) result;
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					rationCardVariationPojo.setRno(new CriffUtil().ranDomNum());
					rationCardVariationPojo.setRefId(refId);
					rationCardVariationPojo.setTimestamp(timestamp);
					Element eElement = (Element) nNode;
					if (eElement.getElementsByTagName("VALUE").item(0) != null) {
						rationCardVariationPojo
								.setValue(eElement.getElementsByTagName("VALUE").item(0).getTextContent());
					} else {
						rationCardVariationPojo.setValue("NA");
					}
					if (eElement.getElementsByTagName("REPORTED-DATE").item(0) != null) {
						rationCardVariationPojo.setReportedDate(
								eElement.getElementsByTagName("REPORTED-DATE").item(0).getTextContent());
					} else {
						rationCardVariationPojo.setReportedDate("NA");
					}
					// rationCardVariationPojoList.add(rationCardVariationPojo);
					logger.info("rationCardVariationPojo:: "+rationCardVariationPojo.toString());
					rationCardVariationRepo.save(rationCardVariationPojo);
				}
			}
			return 1;
		} catch (Exception e) {
			logger.info("rationcard data insertion error :: " + e);
		}
		return 0;
	}

	private int phVariation(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		PhoneVariationPojo phoneVariationPojo = null;
		// List<PhoneVariationPojo> phoneVariationPojoList = new
		// ArrayList<PhoneVariationPojo>();
		exprs = xPath.compile(
				"count(/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/PHONE-NUMBER-VARIATIONS/VARIATION)");
		result = exprs.evaluate(doc, XPathConstants.NUMBER);
		Double phoneVariationPojocount = (Double) result;
		try {
			for (double i = 1; i <= phoneVariationPojocount; i++) {
				exprs = xPath.compile(
						"/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/PHONE-NUMBER-VARIATIONS/VARIATION["
								+ i + "]");
				result = exprs.evaluate(doc, XPathConstants.NODE);
				nNode = (Node) result;
				phoneVariationPojo = new PhoneVariationPojo();
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					phoneVariationPojo.setPno(new CriffUtil().ranDomNum());
					phoneVariationPojo.setRefId(refId);
					phoneVariationPojo.setTimestamp(timestamp);
					if (eElement.getElementsByTagName("VALUE").item(0) != null) {
						phoneVariationPojo.setValue(eElement.getElementsByTagName("VALUE").item(0).getTextContent());
					} else {
						phoneVariationPojo.setValue("NA");
					}
					if (eElement.getElementsByTagName("REPORTED-DATE").item(0) != null) {
						phoneVariationPojo.setReportedDate(
								eElement.getElementsByTagName("REPORTED-DATE").item(0).getTextContent());
					} else {
						phoneVariationPojo.setReportedDate("NA");
					}
					// phoneVariationPojoList.add(phoneVariationPojo);
					logger.info("phoneVariationPojo :: "+phoneVariationPojo.toString());
					phoneVariationRepo.save(phoneVariationPojo);
				}
			}
			return 1;
		} catch (Exception e) {
			logger.info("ph variation data insertion error:: " + e);
		}
		return 0;
	}

	private int passPortVariation(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		PassporVariationPojo passporVariationPojo = new PassporVariationPojo();
		// List<PassporVariationPojo> PassporVariationPojoList = new
		// ArrayList<PassporVariationPojo>();
		exprs = xPath.compile(
				"count(/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/PASSPORT-VARIATIONS/VARIATION)");
		result = exprs.evaluate(doc, XPathConstants.NUMBER);
		Double passporVariationPojocount = (Double) result;
		try {
			for (double i = 1; i <= passporVariationPojocount; i++) {
				exprs = xPath.compile(
						"/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/PASSPORT-VARIATIONS/VARIATION["
								+ i + "]");
				result = exprs.evaluate(doc, XPathConstants.NODE);
				nNode = (Node) result;
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					passporVariationPojo.setPpno(new CriffUtil().ranDomNum());
					passporVariationPojo.setRefId(refId);
					passporVariationPojo.setTimestamp(timestamp);
					if (eElement.getElementsByTagName("VALUE").item(0) != null) {
						passporVariationPojo.setValue(eElement.getElementsByTagName("VALUE").item(0).getTextContent());
					} else {
						passporVariationPojo.setValue("NA");
					}
					if (eElement.getElementsByTagName("REPORTED-DATE").item(0) != null) {
						passporVariationPojo.setReportedDate(
								eElement.getElementsByTagName("REPORTED-DATE").item(0).getTextContent());
					} else {
						passporVariationPojo.setReportedDate("NA");
					}
					// PassporVariationPojoList.add(passporVariationPojo);
					logger.info("passporVariationPojo:: "+passporVariationPojo.toString());
					passportVariationRepo.save(passporVariationPojo);
				}
			}
			return 1;
		} catch (Exception e) {
			logger.info("passport data insertion error ::" + e);
		}
		return 0;
	}

	private int voterVariation(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		VoterIdVariationPojo voterIdVariationPojo = new VoterIdVariationPojo();
		// List<VoterIdVariationPojo> voterIdVariationPojoList = new
		// ArrayList<VoterIdVariationPojo>();
		exprs = xPath.compile(
				"count(/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/VOTER-ID-VARIATIONS/VARIATION)");
		result = exprs.evaluate(doc, XPathConstants.NUMBER);
		Double voterIdVariationPojocount = (Double) result;
		try {
			for (double i = 1; i <= voterIdVariationPojocount; i++) {
				exprs = xPath.compile(
						"/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/VOTER-ID-VARIATIONS/VARIATION["
								+ i + "]");
				result = exprs.evaluate(doc, XPathConstants.NODE);
				nNode = (Node) result;
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					voterIdVariationPojo.setVno(new CriffUtil().ranDomNum());
					voterIdVariationPojo.setRefId(refId);
					voterIdVariationPojo.setTimestamp(timestamp);
					if (eElement.getElementsByTagName("VALUE").item(0) != null) {
						voterIdVariationPojo.setValue(eElement.getElementsByTagName("VALUE").item(0).getTextContent());
					} else {
						voterIdVariationPojo.setValue("NA");
					}
					if (eElement.getElementsByTagName("REPORTED-DATE").item(0) != null) {
						voterIdVariationPojo.setReportedDate(
								eElement.getElementsByTagName("REPORTED-DATE").item(0).getTextContent());
					} else {
						voterIdVariationPojo.setReportedDate("NA");
					}
					// voterIdVariationPojoList.add(voterIdVariationPojo);
					logger.info("voterIdVariationPojo:: "+voterIdVariationPojo.toString());
					voterVariationRepo.save(voterIdVariationPojo);
				}
			}
			return 1;
		} catch (Exception e) {
			logger.info("voter variation data insertion error::" + e);
		}
		return 0;
	}

	private int dobVariation(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		DobVariationPojo dobVariationPojo = new DobVariationPojo();
		// List<DobVariationPojo> dobVariationPojoList = new
		// ArrayList<DobVariationPojo>();
		exprs = xPath.compile(
				"count(/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/DATE-OF-BIRTH-VARIATIONS/VARIATION)");
		result = exprs.evaluate(doc, XPathConstants.NUMBER);
		Double dobVariationPojocount = (Double) result;
		try {
			for (double i = 1; i <= dobVariationPojocount; i++) {
				exprs = xPath.compile(
						"/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/DATE-OF-BIRTH-VARIATIONS/VARIATION["
								+ i + "]");
				result = exprs.evaluate(doc, XPathConstants.NODE);
				nNode = (Node) result;
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					dobVariationPojo.setDno(new CriffUtil().ranDomNum());
					dobVariationPojo.setRefId(refId);
					dobVariationPojo.setTimestamp(timestamp);
					if (eElement.getElementsByTagName("VALUE").item(0) != null) {
						dobVariationPojo.setValue(eElement.getElementsByTagName("VALUE").item(0).getTextContent());
					} else {
						dobVariationPojo.setValue("NA");
					}
					if (eElement.getElementsByTagName("REPORTED-DATE").item(0) != null) {
						dobVariationPojo.setReportedDate(
								eElement.getElementsByTagName("REPORTED-DATE").item(0).getTextContent());
					} else {
						dobVariationPojo.setReportedDate("NA");
					}
					// dobVariationPojoList.add(dobVariationPojo);
					logger.info("dobVariationPojo:: "+dobVariationPojo.toString());
					dobVariationRepo.save(dobVariationPojo);
				}
			}
			return 1;
		} catch (Exception e) {
			logger.info("dob variation data insertion error::" + e);
		}
		return 0;
	}

	private int dlVariation(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		DrivingLicenseVariationPojo drivingLicenseVariationPojo = new DrivingLicenseVariationPojo();
		// List<DrivingLicenseVariationPojo> drivingLicenseVariationPojoList = new
		// ArrayList<DrivingLicenseVariationPojo>();
		exprs = xPath.compile(
				"count(/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/DRIVING-LICENSE-VARIATIONS/VARIATION)");
		result = exprs.evaluate(doc, XPathConstants.NUMBER);
		Double drivingLicenseVariationcount = (Double) result;
		try {
			for (double i = 1; i <= drivingLicenseVariationcount; i++) {
				exprs = xPath.compile(
						"/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/DRIVING-LICENSE-VARIATIONS/VARIATION["
								+ i + "]");
				result = exprs.evaluate(doc, XPathConstants.NODE);
				nNode = (Node) result;
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					drivingLicenseVariationPojo.setDno(new CriffUtil().ranDomNum());
					drivingLicenseVariationPojo.setRefId(refId);
					drivingLicenseVariationPojo.setTimestamp(timestamp);
					if (eElement.getElementsByTagName("VALUE").item(0) != null) {
						drivingLicenseVariationPojo
								.setValue(eElement.getElementsByTagName("VALUE").item(0).getTextContent());
					} else {
						drivingLicenseVariationPojo.setValue("NA");
					}
					if (eElement.getElementsByTagName("REPORTED-DATE").item(0) != null) {
						drivingLicenseVariationPojo.setReportedDate(
								eElement.getElementsByTagName("REPORTED-DATE").item(0).getTextContent());
					} else {
						drivingLicenseVariationPojo.setReportedDate("NA");
					}
					// drivingLicenseVariationPojoList.add(drivingLicenseVariationPojo);
					logger.info("drivingLicenseVariationPojo:: "+ drivingLicenseVariationPojo.toString());
					dlVariationRepo.save(drivingLicenseVariationPojo);
				}
			}
			return 1;
		} catch (Exception e) {
			logger.info("Dlvariation data insertion error::" + e);
		}
		return 0;
	}

	private int panVariation(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		PanVariationsPojo panVariationsPojo = new PanVariationsPojo();
		// List<PanVariationsPojo> panVariationsPojoList = new
		// ArrayList<PanVariationsPojo>();
		exprs = xPath.compile(
				"count(/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/PAN-VARIATIONS/VARIATION)");
		result = exprs.evaluate(doc, XPathConstants.NUMBER);
		Double panVariationscount = (Double) result;
		try {
			for (double i = 1; i <= panVariationscount; i++) {
				exprs = xPath.compile(
						"/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/PAN-VARIATIONS/VARIATION["
								+ i + "]");
				result = exprs.evaluate(doc, XPathConstants.NODE);
				nNode = (Node) result;
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					panVariationsPojo.setSno(new CriffUtil().ranDomNum());
					panVariationsPojo.setRefId(refId);
					panVariationsPojo.setTimestamp(timestamp);
					if (eElement.getElementsByTagName("VALUE").item(0) != null) {
						panVariationsPojo.setValue(eElement.getElementsByTagName("VALUE").item(0).getTextContent());
					} else {
						panVariationsPojo.setValue("NA");
					}
					if (eElement.getElementsByTagName("REPORTED-DATE").item(0) != null) {
						panVariationsPojo.setReportedDate(
								eElement.getElementsByTagName("REPORTED-DATE").item(0).getTextContent());
					} else {
						panVariationsPojo.setReportedDate("NA");
					}
					logger.info("panVariationsPojo:: "+panVariationsPojo.toString());
					panVariationRepo.save(panVariationsPojo);
				}
			}
			return 1;
		} catch (Exception e) {
			logger.info("pan variation insertion error:: " + e);
		}
		return 0;
	}

	private int adderssVariation(Document doc) throws XPathExpressionException {
		// TODO Auto-generated method stub
		AddressVariationPojo addressVariationPojo = null;
		// List<AddressVariationPojo> addressVariationPojoList = new
		// ArrayList<AddressVariationPojo>();
		exprs = xPath.compile(
				"count(/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/ADDRESS-VARIATIONS/VARIATION)");
		result = exprs.evaluate(doc, XPathConstants.NUMBER);
		Double addressVariationcount = (Double) result;
		try {
			for (double i = 1; i <= addressVariationcount; i++) {
				exprs = xPath.compile(
						"/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/PERSONAL-INFO-VARIATION/ADDRESS-VARIATIONS/VARIATION["
								+ i + "]");
				result = exprs.evaluate(doc, XPathConstants.NODE);
				nNode = (Node) result;
				addressVariationPojo = new AddressVariationPojo();
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					addressVariationPojo.setSno(new CriffUtil().ranDomNum());
					addressVariationPojo.setRefId(refId);
					addressVariationPojo.setTimestamp(timestamp);
					if (eElement.getElementsByTagName("VALUE").item(0) != null) {
						addressVariationPojo.setValue(eElement.getElementsByTagName("VALUE").item(0).getTextContent());
					} else {
						addressVariationPojo.setValue("NA");
					}
					if (eElement.getElementsByTagName("REPORTED-DATE").item(0) != null) {
						addressVariationPojo.setReportedDate(
								eElement.getElementsByTagName("REPORTED-DATE").item(0).getTextContent());
					} else {
						addressVariationPojo.setReportedDate("NA");
					}
					// addressVariationPojoList.add(addressVariationPojo);
					logger.info("address variations::  "+ addressVariationPojo.toString());
					addressVariationRepo.save(addressVariationPojo);
				}
			}
			return 1;
		} catch (Exception e) {
			logger.info("address variation insertion error::" + e);
		}
		return 0;
	}

	

	private int requestData(Document doc, Criff criff) throws XPathExpressionException {
		// TODO Auto-generated method stub
		exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/REQUEST");
		result = exprs.evaluate(doc, XPathConstants.NODE);
		nNode = (Node) result;
		try {
			RequestPojo requestPojo = new RequestPojo();
			try {
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String address = criff.getAddress1().concat(" ").concat(criff.getAddress2().concat(" ")).concat(criff.getCity().concat(" ")).concat(criff.getState().concat(" ")).concat(criff.getPincode());
					requestPojo.setReqNo(new CriffUtil().ranDomNum());
					requestPojo.setRefid(refId);
					requestPojo.settIME_sTAMP(timestamp);
					requestPojo.setId_type_1(criff.getKyctypeId());
					requestPojo.setId_value_1(criff.getKycdocno());
					requestPojo.setId_type_2(criff.getKyctypeId2());
					requestPojo.setId_value_2(criff.getKycdocno2());
					requestPojo.setAddress(address);
					requestPojo.setPhone(criff.getPh());
					requestPojo.setGender(criff.getGender());
					
					if (eElement.getElementsByTagName("NAME").item(0) != null) {
						requestPojo.setnAME(eElement.getElementsByTagName("NAME").item(0).getTextContent());
					} else {
						requestPojo.setnAME("NA");
					}
					if (eElement.getElementsByTagName("AKA").item(0) != null) {
						requestPojo.setaKA(eElement.getElementsByTagName("AKA").item(0).getTextContent());
					} else {
						requestPojo.setaKA("NA");
					}
					if (eElement.getElementsByTagName("DOB").item(0) != null) {
						requestPojo.setdOB(eElement.getElementsByTagName("DOB").item(0).getTextContent());
					} else {
						requestPojo.setdOB("NA");
					}
					if (eElement.getElementsByTagName("AGE-AS-ON").item(0) != null) {
						requestPojo.setaGE_aS_oN(eElement.getElementsByTagName("AGE-AS-ON").item(0).getTextContent());
					} else {
						requestPojo.setaGE_aS_oN("NA");
					}
					if (eElement.getElementsByTagName("EMAILS").item(0) != null) {
						requestPojo.seteMAILS(eElement.getElementsByTagName("EMAILS").item(0).getTextContent());
					} else {
						requestPojo.seteMAILS("NA");
					}
					if (eElement.getElementsByTagName("BRANCH").item(0) != null) {
						requestPojo.setbRANCH(eElement.getElementsByTagName("BRANCH").item(0).getTextContent());
					} else {
						requestPojo.setbRANCH("NA");
					}
					if (eElement.getElementsByTagName("KENDRA").item(0) != null) {
						requestPojo.setkENDRA(eElement.getElementsByTagName("KENDRA").item(0).getTextContent());
					} else {
						requestPojo.setkENDRA("NA");
					}
					if (eElement.getElementsByTagName("MBR-ID").item(0) != null) {
						requestPojo.setmBR_ID(eElement.getElementsByTagName("MBR-ID").item(0).getTextContent());
					} else {
						requestPojo.setmBR_ID("NA");
					}
					if (eElement.getElementsByTagName("CREDIT-INQ-PURPS-TYP").item(0) != null) {
						requestPojo.setcREDIT_iNQ_pURPS_tYP(
								eElement.getElementsByTagName("CREDIT-INQ-PURPS-TYP").item(0).getTextContent());
					} else {
						requestPojo.setcREDIT_iNQ_pURPS_tYP("NA");
					}
					if (eElement.getElementsByTagName("CREDIT-INQ-PURPS-TYP-DESC").item(0) != null) {
						requestPojo.setcREDIT_iNQ_pURPS_tYP_dESC(
								eElement.getElementsByTagName("CREDIT-INQ-PURPS-TYP-DESC").item(0).getTextContent());
					} else {
						requestPojo.setcREDIT_iNQ_pURPS_tYP_dESC("NA");
					}
					if (eElement.getElementsByTagName("CREDIT-INQUIRY-STAGE").item(0) != null) {
						requestPojo.setcREDIT_iNQUIRY_sTAGE(
								eElement.getElementsByTagName("CREDIT-INQUIRY-STAGE").item(0).getTextContent());
					} else {
						requestPojo.setcREDIT_iNQUIRY_sTAGE("NA");
					}
					if (eElement.getElementsByTagName("CREDIT-RPT-ID").item(0) != null) {
						requestPojo.setcREDIT_rPT_iD(
								eElement.getElementsByTagName("CREDIT-RPT-ID").item(0).getTextContent());
					} else {
						requestPojo.setcREDIT_rPT_iD("NA");
					}
					if (eElement.getElementsByTagName("CREDIT-REQ-TYP").item(0) != null) {
						requestPojo.setcREDIT_rEQ_tYP(
								eElement.getElementsByTagName("CREDIT-REQ-TYP").item(0).getTextContent());
					} else {
						requestPojo.setcREDIT_rEQ_tYP("NA");
					}
					if (eElement.getElementsByTagName("CREDIT-RPT-TRN-DT-TM").item(0) != null) {
						requestPojo.setcREDIT_rPT_tRN_dT_tM(
								eElement.getElementsByTagName("CREDIT-RPT-TRN-DT-TM").item(0).getTextContent());
					} else {
						requestPojo.setcREDIT_rPT_tRN_dT_tM("NA");
					}
					if (eElement.getElementsByTagName("LOS-APP-ID").item(0) != null) {
						requestPojo.setlOS_aPP_iD(eElement.getElementsByTagName("LOS-APP-ID").item(0).getTextContent());
					} else {
						requestPojo.setlOS_aPP_iD("NA");
					}
					if (eElement.getElementsByTagName("LOAN-AMOUNT").item(0) != null) {
						requestPojo
								.setlOAN_aMOUNT(eElement.getElementsByTagName("LOAN-AMOUNT").item(0).getTextContent());
					} else {
						requestPojo.setlOAN_aMOUNT("NA");
					}
					if (eElement.getElementsByTagName("MFI-IND").item(0) != null) {
						requestPojo.setmFI_iND(eElement.getElementsByTagName("MFI-IND").item(0).getTextContent());
					} else {
						requestPojo.setmFI_iND("NA");
					}
					if (eElement.getElementsByTagName("MFI-SCORE").item(0) != null) {
						requestPojo.setmFI_sCORE(eElement.getElementsByTagName("MFI-SCORE").item(0).getTextContent());
					} else {
						requestPojo.setmFI_sCORE("NA");
					}
					if (eElement.getElementsByTagName("MFI-GROUP").item(0) != null) {
						requestPojo.setmFI_gROUP(eElement.getElementsByTagName("MFI-GROUP").item(0).getTextContent());
					} else {
						requestPojo.setmFI_gROUP("NA");
					}
					if (eElement.getElementsByTagName("CNS-IND").item(0) != null) {
						requestPojo.setcNS_iND(eElement.getElementsByTagName("CNS-IND").item(0).getTextContent());
					} else {
						requestPojo.setcNS_iND("NA");
					}
					if (eElement.getElementsByTagName("CNS-SCORE").item(0) != null) {
						requestPojo.setcNS_sCORE(eElement.getElementsByTagName("CNS-SCORE").item(0).getTextContent());
					} else {
						requestPojo.setcNS_sCORE("NA");
					}
					if (eElement.getElementsByTagName("IOI").item(0) != null) {
						requestPojo.setiOI(eElement.getElementsByTagName("IOI").item(0).getTextContent());
					} else {
						requestPojo.setiOI("NA");
					}
				}
				logger.info("requestPojo:: "+requestPojo);
				reqRep.save(requestPojo);
				return 1;
			} catch (Exception e) {
				logger.info("Request data insertion error:: " + e);
			}
		} catch (Exception e) {
			logger.info("Request data insertion error:: " + e);
		}
		return 0;
	}

	private int statusDetails(Document doc) throws XPathExpressionException, InterruptedException {
		// TODO Auto-generated method stub
		StatusDetails statusDetails = null;
		exprs = xPath.compile("count(/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/STATUS-DETAILS/STATUS)");
		result = exprs.evaluate(doc, XPathConstants.NUMBER);
		Double sDCount = (Double) result;
		try {
			for (double i = 1; i <= sDCount; i++) {
				exprs = xPath.compile("/INDV-REPORT-FILE/INDV-REPORTS/INDV-REPORT/STATUS-DETAILS/STATUS[" + i + "]");
				result = exprs.evaluate(doc, XPathConstants.NODE);
				nNode = (Node) result;
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					statusDetails = new StatusDetails();
					statusDetails.setsNo(new CriffUtil().ranDomNum());
					statusDetails.setRefid(refId);
					statusDetails.settIMEtIME_sTAMP(timestamp);
					Element eElement = (Element) nNode;
					if (eElement.getElementsByTagName("OPTION").item(0) != null) {
						statusDetails.setoPTIONS(eElement.getElementsByTagName("OPTION").item(0).getTextContent());
					} else {
						statusDetails.setoPTIONS("NA");
					}
					if (eElement.getElementsByTagName("OPTION-STATUS").item(0) != null) {
						statusDetails.setoPTION_sTATUS(
								eElement.getElementsByTagName("OPTION-STATUS").item(0).getTextContent());
					} else {
						statusDetails.setoPTION_sTATUS("NA");
					}
				}
				logger.info("statusDetails:: "+statusDetails.toString());
				statusRepo.save(statusDetails);
			}
			return 1;
		} catch (Exception e) {
			logger.info("statusDetails data insertion error:: " + e);
		}

		return 0;
	}

	

}

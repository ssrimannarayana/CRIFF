package com.springboot.sqlserver.entity;

public class ScoringFactores {

	public ScorePojo sc(ScorePojo scorePojo) {
		String s = scorePojo.getsCORE_fACTORS();
		int k = s.length();
		
		return getScFactores(scorePojo,k,s);
	}

	private ScorePojo getScFactores(ScorePojo sc,int k,String s) {
		// TODO Auto-generated method stub
		if(k==8)
		{
			sc.setsFACTOR1(getScoreFactorDesciption(s.substring(0,4)));
			sc.setsFACTOR2("NA");
			sc.setsFACTOR3("NA");
			sc.setsFACTOR4("NA");
		}
		else if(k==12) {
			sc.setsFACTOR1(getScoreFactorDesciption(s.substring(0,4)));
			sc.setsFACTOR2(getScoreFactorDesciption(s.substring(5,9)));
			sc.setsFACTOR3("NA");
			sc.setsFACTOR4("NA");
		}
		else if(k==16) {
			sc.setsFACTOR1(getScoreFactorDesciption(s.substring(0,4)));
			sc.setsFACTOR2(getScoreFactorDesciption(s.substring(5,9)));
			sc.setsFACTOR3(getScoreFactorDesciption(s.substring(10,14)));
			sc.setsFACTOR4("NA");
		}
		else if(k==20) {
			sc.setsFACTOR1(getScoreFactorDesciption(s.substring(0,4)));
			sc.setsFACTOR2(getScoreFactorDesciption(s.substring(5,9)));
			sc.setsFACTOR3(getScoreFactorDesciption(s.substring(10,14)));
			sc.setsFACTOR3(getScoreFactorDesciption(s.substring(15,19)));
		}
		return sc;
	}

	private String getScoreFactorDesciption(String substring) {
		// TODO Auto-generated method stub
		ScoreFactorCode scfCode = ScoreFactorCode.valueOf(substring);
		return scfCode.getDescription();
	}
}

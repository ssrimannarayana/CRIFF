package com.springboot.sqlserver.entity;

public enum ScoreFactorCode {
	SF01("No/minimal recent missed payments"), SF02("Very recent delinquency observed"),
	SF03("No/minimal missed payments in recent past"), SF04("Delinquency observed in recent past"),
	SF05("No/minimal missed payments in the past"), SF06("Delinquency observed in the past"),
	SF07("No/minimal missed payments observed historically"), SF08("Delinquency observed historically"),
	SF09("No/minimal missed payments in recent past across instalment loans"),
	SF10("Delinquency observed in recent past across instalment loans"),
	SF11("Normal proportion of outstanding balance to disbursed amount"),
	SF12("Substantial proportion of outstanding balance to disbursed amount"),
	SF13("Consistent decrease in outstanding balance on self/overall instalment loans in recent past"),
	SF14("Current balance build-up on self/overall instalment loans in recent past"),
	SF15("Consistent decrease in outstanding balance on self/overall instalment loans in the past"),
	SF16("Current balance build-up on self/overall instalment loans in the past"),
	SF17("Consistent decrease in outstanding balance on self/overall instalment loans historically"),
	SF18("Current balance build-up on self/overall instalment loans historically"),
	SF19("Recent credit utilization on self/overall accounts is consistent"),
	SF20("Recent credit utilization on self/overall accounts is consistently high"),
	SF21("Considerably high credit age of open contracts"), SF22("Relatively low credit age of open contracts"),
	SF23("Decent utilization of credit limit on self/overall revolving accounts"),
	SF24("Considerably high utilization of credit limit on self/overall revolving accounts"),
	SF25("Decent number of self/overall loans disbursed in the past"),
	SF26("Considerably high number of self/overall loans disbursed in the past"),
	SF27("Disbursed amount of general instalment loans is adequate"),
	SF28("Disbursed amount of general instalment loans may induce stress"), SF29("None/too few active accounts"),
	SF30("Considerably high proportion of active contracts"),
	SF31("Normal proportion of active contracts switch condition");

	private final String description;

	// Enum constructor
	ScoreFactorCode(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

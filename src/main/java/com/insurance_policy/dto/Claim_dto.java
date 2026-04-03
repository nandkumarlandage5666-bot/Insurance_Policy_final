package com.insurance_policy.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Claim_dto {
	@NotNull(message = "claim_No your claim it not be null")
	private Integer claim_No;
	@NotNull(message = "Plese describe your claim it not be null")
	private String description;
	@NotNull
	@Pattern(regexp = "^(3[01]|[12][0-9]|00|0[1-9])/(1[0-2]|00|0[1-9])/([0-9]{4})$",message = "date formate dd/mm/yy")
	private String claim_Date;
	@NotNull(message = "claims status can not be null")
	private String claim_Status;
	private Integer policy_No;
	private String claim_Flag;
	
	public Integer getClaim_No() {
		return claim_No;
	}
	public void setClaim_No(Integer claim_No) {
		this.claim_No = claim_No;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClaim_Date() {
		return claim_Date;
	}
	public void setClaim_Date(String claim_Date) {
		this.claim_Date = claim_Date;
	}
	public String getClaim_Status() {
		return claim_Status;
	}
	public void setClaim_Status(String claim_Status) {
		this.claim_Status = claim_Status;
	}
	public Integer getPolicy_No() {
		return policy_No;
	}
	public void setPolicy_No(Integer policy_No) {
		this.policy_No = policy_No;
	}
	public String getClaim_Flag() {
		return claim_Flag;
	}
	public void setClaim_Flag(String claim_Flag) {
		this.claim_Flag = claim_Flag;
	}
		
}

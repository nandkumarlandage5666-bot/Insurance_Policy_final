package com.insurance_policy.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Claim {
	@Id
	private Integer claim_No;
	private String description;
	private String claim_Date;
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
	@Override
	public String toString() {
		return "Claim [claim_No=" + claim_No + ", description=" + description + ", claim_Date=" + claim_Date
				+ ", claim_Status=" + claim_Status + ", policy_No=" + policy_No + ", claim_Flag=" + claim_Flag + "]";
	}
		
	

}

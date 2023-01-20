package com.cropdeal.adminservice.model;

public class BankDetails {

	private String accountNumber;
	private String bankName;
	private String iFSCCode;
	
	
	
		public BankDetails() {
		
	}

		public BankDetails(String accountNumber, String bankName, String iFSCCode) {
		super();
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.iFSCCode = iFSCCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getiFSCCode() {
		return iFSCCode;
	}

	public void setiFSCCode(String iFSCCode) {
		this.iFSCCode = iFSCCode;
	}

	
	
}

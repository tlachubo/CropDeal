package com.cropdeal.adminservice.model;

import org.springframework.data.annotation.Id;

public class Dealer {

	@Id
	private String dealerId;
	private String dealerName;
	private String dealerEmail;
	private String dealerContactNo;
    private BankDetails bank_detail;
    
	public Dealer() {
		
	}

	public Dealer(String dealerId, String dealerName, String dealerEmail, String dealerContactNo,
			BankDetails bank_detail) {
		super();
		this.dealerId = dealerId;
		this.dealerName = dealerName;
		this.dealerEmail = dealerEmail;
		this.dealerContactNo = dealerContactNo;
		this.bank_detail = bank_detail;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerEmail() {
		return dealerEmail;
	}

	public void setDealerEmail(String dealerEmail) {
		this.dealerEmail = dealerEmail;
	}

	public String getDealerContactNo() {
		return dealerContactNo;
	}

	public void setDealerContactNo(String dealerContactNo) {
		this.dealerContactNo = dealerContactNo;
	}

	public BankDetails getBank_detail() {
		return bank_detail;
	}

	public void setBank_detail(BankDetails bank_detail) {
		this.bank_detail = bank_detail;
	}

	@Override
	public String toString() {
		return "Dealer [dealerId=" + dealerId + ", dealerName=" + dealerName + ", dealerEmail=" + dealerEmail
				+ ", dealerContactNo=" + dealerContactNo + ", bank_detail=" + bank_detail + "]";
	}
    
    
	
}

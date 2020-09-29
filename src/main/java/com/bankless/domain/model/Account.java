package com.bankless.domain.model;

public class Account {

	private String countryCode;

	private long no;

	private double balance;

	public Account(String countryCode, long no, double balance) {
		this.countryCode = countryCode;
		this.no = no;
		this.balance = balance;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}

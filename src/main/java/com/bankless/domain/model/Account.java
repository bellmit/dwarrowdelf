package com.bankless.domain.model;

public class Account {

	private String countryCode;

	private int no;

	private double balance;

	public Account(String countryCode, int no, double balance) {
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}

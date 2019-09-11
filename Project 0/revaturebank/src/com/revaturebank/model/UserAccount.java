package com.revaturebank.model;

public class UserAccount {

	private double depositStat;
	private double checkStat;
	private int userRegId;
	private String userAccoNum;
	
	
	public UserAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public UserAccount(double depositStat, double checkStat, int userRegId) {
		super();
		this.depositStat = depositStat;
		this.checkStat = checkStat;
		this.userRegId = userRegId;
	}
	
	

	public String getUserAccoNum() {
		return userAccoNum;
	}



	public void setUserAccoNum(String userAccoNum) {
		this.userAccoNum = userAccoNum;
	}



	public double getDepositStat() {
		return depositStat;
	}


	public void setDepositStat(double depositStat) {
		this.depositStat = depositStat;
	}


	public double getCheckStat() {
		return checkStat;
	}


	public void setCheckStat(double checkStat) {
		this.checkStat = checkStat;
	}


	public int getUserRegId() {
		return userRegId;
	}


	public void setUserRegId(int userRegId) {
		this.userRegId = userRegId;
	}
	
	
	
	
	
}

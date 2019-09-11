package com.revaturebank.model;

public class UserInfoAccount {
	
	private int userId;
	private String firstName;
	private String lastName;
	private String userEmail;
	private String userName;
	private String passWord;
	private double deposit;
	private double checkings;
	
	public UserInfoAccount() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserInfoAccount(String firstName, String lastName, String userEmail, String userName, String passWord,double deposit, double checkings) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userName = userName;
		this.passWord = passWord;
		this.deposit = deposit;
		this.checkings = checkings;
	}
	
	





	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getCheckings() {
		return checkings;
	}

	public void setCheckings(double checkings) {
		this.checkings = checkings;
	}
	
	
	
	


}

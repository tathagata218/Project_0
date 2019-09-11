package com.revaturebank.main;

import org.apache.log4j.Logger;

public class Disp1 {
	private static final Logger log = Logger.getLogger(Disp1.class);
	public void introDisp( ) {
		log.info("Welcome To Bank Revature");
		log.info("--------------------------------");
		log.info("1. Login");
		log.info("2. Register");
		log.info("3. Exit");
		
	
	}
	
	public void registerDisp1() {
		log.info("Please Enter Your Login Information .....");
		log.info("-----------------------------------");
		log.info("1. Please Select 1 to Enter your Information for Registration");
		log.info("2. Please Select 2 to Go Back To Main Menu"); 
		
	}

	
	
	public void loginDisp() {
		log.info("Please Enter Your Login Information .....");
		log.info("-----------------------------------");
		log.info("1. Please Enter Your UserName and Password");
		log.info("2. Go Back To Main Menu"); // This will Return back to Login/Register Page
	}
	
	
	public void backDisp(String firName,String lastName,String bankAcc, double dipVal, double checkVal) {
		log.info("-----------------------------------");
		log.info("Welcome"+firName+" "+lastName+" to Bank Revature");
		log.info("-----------------------------------");
		log.info("This is Your Account Number : -----> "+ bankAcc);
		log.info("-----------------------------------");
		log.info("This is your Checkings Balance : -----> $"+ dipVal);
		log.info("-----------------------------------");
		log.info("This is your Savings Balance: -----> $"+ checkVal);
		log.info("------------------------------------");
		log.info("What do you Want to do today ? ");
		log.info("------------------------------------");
		log.info("1. Deposit Money in Checkings ?");
		log.info("2. Deposit Money in Savings ?");
		log.info("3. Withdraw Money in Checkings ?");
		log.info("4. Withdraw Money in Savings ?");
		log.info("5. Show Old Transactions ?");
		log.info("6. Logout");
		
	}
	
	
	public void depositMoney() {
		log.info("Please select One Choice");
		log.info(" 1. How much Money You Want to Diposit into Checkings");
		log.info(" 2. How much Money You Want to Diposit into Savings");
		log.info(" 3. Go Back to your Menu");
	}
	
	public void widthdrawMoney() {
		log.info("Please select One Choice");
		log.info(" 1. How Much Money You Want to Widthdraw from Checkings");
		log.info(" 2. How Much Money You Want to Widthdraw from Savings");
		log.info(" 2. Go Back to your Menu");
	}
	
	public void showTrans() {
		log.info("Please select One Choice");
		log.info(" 1. Show All Transactions ");
		log.info(" 2. Go Back To Main Menu ");
	}
	
	public void logoutMen() {
		log.info("Are you sure You want to logout ?");
		log.info("1. Yes Logout");
		log.info("2. Go Back to Main Menu");
	}
	
	
	public void showTrans(int[] tran) {
		for (int i = 0; i < tran.length; i++) {
			log.info("These are the Transactions : "+tran[i]);
			
		}
	}
	
	
	


}

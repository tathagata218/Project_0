package com.revaturebank.service.impl;

import java.util.regex.Pattern;

import com.revaturebank.dao.impl.UserAccountDaoImpl;
import com.revaturebank.dao.impl.UserInfoDaolmpl;
import com.revaturebank.exceptions.BusinessException;
import com.revaturebank.model.UserAccount;
import com.revaturebank.model.UserInfoAccount;
import com.revaturebank.service.CheckValidation; 

public class ValidClass implements CheckValidation {

	@Override
	public boolean checkUserName(String str)  {
		boolean chk = false;
		String rgx = "[a-zA-Z_0-9]{4,}";
		Pattern pt = Pattern.compile(rgx);
		
		if(pt.matcher(str).matches()) {
			chk = true;
		}
		return chk;
	}


	@Override
	public boolean checkDipWidChkSav(Double num) {
		boolean chk = false;
		
		if(num%1==0) {
			chk = false;
		}
		else {
			chk=true;
		}
		return chk;
	}


	@Override
	public boolean checkNoNum(final String str) {
		if( str == null || str.length() == 0) {
			return false;
		}
		return str.chars().allMatch(Character::isDigit);
	}


	@Override
	public UserInfoAccount validUserInfo(UserInfoAccount newUser) throws BusinessException {
		UserInfoDaolmpl uidi = new UserInfoDaolmpl(); 
		UserInfoAccount finalUser = null;
		try {
			
		finalUser =  uidi.registerNewUserInfo(newUser);
		
		}catch(BusinessException e) {
			throw e;
		};
		
		return finalUser;
	}


	@Override
	public boolean passVal( String pass) {
		
		boolean passChk = false;
		String rgx = "[^/s]{4,}";
		Pattern pt = Pattern.compile(rgx);
		
		if(pt.matcher(pass).matches()) {
			passChk = true;
		}
		return passChk;
		
		
	
	}


	@Override
	public boolean checkUserNameReg(String str) throws BusinessException {
		boolean chk = false;
		String rgx = "[a-zA-Z_0-9]{4,}";
		Pattern pt = Pattern.compile(rgx);
		
		if(pt.matcher(str).matches() == true) {
			chk = true;
		}
		else  {
			throw new BusinessException("Invalid UserName Please Restart");
		}
		return chk;
	}


	@Override
	public UserAccount validUserAcc(UserAccount newAcc) throws BusinessException {
		UserAccountDaoImpl uadi = new UserAccountDaoImpl();
		UserAccount nua = null;  
				try {
				nua = uadi.registerAccountInfo(newAcc);
				}
		catch(BusinessException e) {
			throw e;
		}
				return nua;
	}
	
	

}
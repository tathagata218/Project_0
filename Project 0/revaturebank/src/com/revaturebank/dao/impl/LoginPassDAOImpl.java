package com.revaturebank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revaturebank.dao.LoginPassDAO;
import com.revaturebank.exceptions.BusinessException;
import com.revaturebank.model.UserAccount;
import com.revaturebank.model.UserInfoAccount;

import com.revaturebank.main.CheckMethods;
import com.revaturebank.dbutil.OracleJDBC;

public class LoginPassDAOImpl implements LoginPassDAO{
	CheckMethods cm = new CheckMethods();
	
	
	//@SuppressWarnings("null")
	@Override
	public UserInfoAccount loginCheck(String userName, String password) throws BusinessException {
		
		UserInfoAccount usrInfAcc = null;
		
		String husPa =  cm.hashPass(password);
		
		try(Connection con = OracleJDBC.getConnection()){
			String sql = "SELECT userInf_id,firstname,lastname,useremail,username,userpass FROM userinfo WHERE username = ?";
			PreparedStatement preStat = con.prepareStatement(sql);
			preStat.setString(1, userName);
			ResultSet resSet = preStat.executeQuery();
			if(resSet.next()) {
				System.out.println("User Exists from Dao Impl");
				if(resSet.getString("userpass").equals(husPa)) {
				System.out.println("Pass was Check");
				usrInfAcc = new UserInfoAccount(); 
				
				usrInfAcc.setUserId(resSet.getInt("userInf_id"));
				usrInfAcc.setFirstName(resSet.getString("firstname"));
				usrInfAcc.setLastName(resSet.getString("lastname"));
				usrInfAcc.setUserEmail(resSet.getString("useremail"));
				usrInfAcc.setUserName(resSet.getString("username"));
				usrInfAcc.setPassWord(resSet.getString("userpass"));
			}
				else {
					throw new BusinessException("Invalid Password Please Redo the login");
				}
				
			}
			else {
				throw new BusinessException("User With This userName : "+userName+" NOT FOUND");
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			//throw new BusinessException("Internal Error Occured");
		}
		
		
		return usrInfAcc;
	}
	
	//------------------------------------------------------------------------------------------------------------

	@Override
	public UserAccount loginAccountCheck(int userId) throws BusinessException {
		
		UserAccount userAcc = null;
		
		try(Connection con = OracleJDBC.getConnection()){
		
			String sql = "SELECT account_id,accNumebr,accDiposit,accCheckings,userInf_id FROM accountInfo WHERE userInf_id = ?";
			PreparedStatement preStat = con.prepareStatement(sql);
			preStat.setInt(1, userId);
			ResultSet resSet2 = preStat.executeQuery();
			
			if(resSet2.next()) {
				userAcc = new UserAccount();
				
				userAcc.setUserAccoNum(Long.toString(resSet2.getLong("accNumebr")));
				userAcc.setCheckStat(resSet2.getDouble("accCheckings"));
				userAcc.setDepositStat(resSet2.getDouble("accDiposit"));
			} 
		
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error Occured");

		}
		
		
		return userAcc;
	}

}

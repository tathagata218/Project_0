package com.revaturebank.dao.impl;

import com.revaturebank.dao.UserDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import com.revaturebank.exceptions.BusinessException;
import com.revaturebank.main.CheckMethods;
import com.revaturebank.dbutil.OracleJDBC;
import com.revaturebank.model.UserInfoAccount;

public class UserInfoDaolmpl implements UserDAO {
	
	CheckMethods cm = new CheckMethods();

	@Override
	public UserInfoAccount registerNewUserInfo(UserInfoAccount newUser) throws BusinessException {
		
		try(Connection con = OracleJDBC.getConnection()){
			String sql = "{call USERINFOINSERT(?,?,?,?,?,?)}";
			CallableStatement callState = con.prepareCall(sql);
			callState.setString(1, newUser.getFirstName());
			callState.setString(2, newUser.getLastName());
			callState.setString(3, newUser.getUserEmail());
			callState.setString(4, newUser.getUserName());
			callState.setString(5, cm.hashPass(newUser.getPassWord()));
			callState.registerOutParameter(6,java.sql.Types.NUMERIC);
			
			callState.execute();
			newUser.setUserId(callState.getInt(6));
			
			
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error Occured");
		}
		
		
		
		// TODO Auto-generated method stub
		return newUser;
	}

	@Override
	public UserInfoAccount getUserByUserNamePass(String userName, String password) {
		
		// TODO Auto-generated method stub
		return null;
	}

}
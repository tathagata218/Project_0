package com.revaturebank.dao.impl;
import com.revaturebank.exceptions.BusinessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import com.revaturebank.dbutil.OracleJDBC;

public class SavCheckDAOImpl {

	
	public void dipSavings(double oriNum, double num, int userID) throws BusinessException {
		double updSavBal = oriNum + num;
		try(Connection con = OracleJDBC.getConnection()){
			String sql = "UPDATE accountInfo SET accdiposit = ? WHERE userinf_id = ?";
			CallableStatement preSet = con.prepareCall(sql);
			preSet.setDouble(1, updSavBal);
			preSet.setInt(2, userID);
			preSet.executeQuery();        
			preSet.close();
			
			
			
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error Occured");
		}
		
		
		
		
	}

	
	public void widSavings(double oriNum, double num, int userID) throws BusinessException {
		double updSavBal = oriNum - num;
		if(updSavBal>0) {
		try(Connection con = OracleJDBC.getConnection()){
			String sql = "UPDATE accountInfo SET accdiposit = ? WHERE userinf_id = ?";
			CallableStatement preSet = con.prepareCall(sql);
			preSet.setDouble(1, updSavBal);
			preSet.setInt(2, userID);
			preSet.executeQuery();
			preSet.close();
			
			
			
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error Occured");
		}
		}
		else {
			throw new BusinessException("Cannot Widthdraw Low Balance");
		}
		
	}

	
	public void dipCheckings(double oriNum, double num, int userID) throws BusinessException {
		double updChaBal = oriNum + num;
		try(Connection con = OracleJDBC.getConnection()){
			String sql = "UPDATE accountInfo SET acccheckings = ? WHERE userinf_id = ?";
			CallableStatement preSet = con.prepareCall(sql);
			preSet.setDouble(1, updChaBal);
			preSet.setInt(2, userID);
			preSet.executeQuery();
			preSet.close();
			
			
			
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error Occured");
		}
		
	}

	
	public void widCheckings(double oriNum, double num, int userID) throws BusinessException {
		double updChaBal = oriNum - num;
		
		if(updChaBal>0) {
		try(Connection con = OracleJDBC.getConnection()){
			String sql = "UPDATE accountInfo SET acccheckings = ? WHERE userinf_id = ?";
			CallableStatement preSet = con.prepareCall(sql);
			preSet.setDouble(1, updChaBal);
			preSet.setInt(2, userID);
			preSet.executeQuery();
			preSet.close();
			
			
			
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error Occured");
		}
		}
		else {
			throw new BusinessException("Cannot Widthdraw low Balance");
		}
		
	}

	
	

}

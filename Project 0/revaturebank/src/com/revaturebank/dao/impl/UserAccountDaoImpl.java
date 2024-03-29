package com.revaturebank.dao.impl;
import com.revaturebank.exceptions.BusinessException;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revaturebank.model.UserAccount;
import com.revaturebank.dao.UserAccountDAO;
import com.revaturebank.dbutil.OracleJDBC;

public class UserAccountDaoImpl implements UserAccountDAO {

	@Override
	public UserAccount registerAccountInfo(UserAccount userAcc) throws BusinessException {
		try(Connection con = OracleJDBC.getConnection()){
			String sql = "{call ACCOUNTINFOINSERT(?,?,?,?)}";
			CallableStatement callState = con.prepareCall(sql);
			callState.setDouble(1, userAcc.getDepositStat());
			callState.setDouble(2, userAcc.getCheckStat());
			callState.setInt(4, userAcc.getUserRegId());
			callState.registerOutParameter(3,java.sql.Types.BIGINT);
			
			callState.execute();
			userAcc.setUserAccoNum(Long.toString(callState.getLong(3)));
			
			
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error Occured");
		}
		return userAcc;
	}

	@Override
	public UserAccount getAllUserAccount(int userId) throws BusinessException {
		
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

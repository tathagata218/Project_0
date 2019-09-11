package com.revaturebank.dao;

import com.revaturebank.exceptions.BusinessException;
import com.revaturebank.model.UserAccount;

public interface UserAccountDAO {
	
	public UserAccount registerAccountInfo(UserAccount userAcc) throws BusinessException;
	public UserAccount getAllUserAccount (int userId) throws BusinessException;
}

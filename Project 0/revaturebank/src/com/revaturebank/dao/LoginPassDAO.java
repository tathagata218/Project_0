package com.revaturebank.dao;

import com.revaturebank.exceptions.BusinessException;
import com.revaturebank.model.UserAccount;
import com.revaturebank.model.UserInfoAccount;

public interface LoginPassDAO {
	
	public UserInfoAccount loginCheck(String userName, String password) throws BusinessException;
	public UserAccount loginAccountCheck(int userId) throws BusinessException;

}

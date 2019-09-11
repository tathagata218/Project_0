package com.revaturebank.dao;

import com.revaturebank.exceptions.BusinessException;
import com.revaturebank.model.UserInfoAccount;

public interface UserDAO {

	public UserInfoAccount registerNewUserInfo(UserInfoAccount newUser) throws BusinessException;
	public UserInfoAccount getUserByUserNamePass(String userName,String password);


}

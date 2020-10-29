package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserDao extends GenericDAO<UserModel>{
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}

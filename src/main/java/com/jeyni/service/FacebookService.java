package com.jeyni.service;

import com.jeyni.dao.FacebookDao;

import facebook4j.ResponseList;
import facebook4j.User;

public class FacebookService {

	public static ResponseList<User> searchUsers(String userName) {
		return FacebookDao.searchUsers(userName);
	}
	
	
}

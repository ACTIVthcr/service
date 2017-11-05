package com.jeyni.process;

import com.jeyni.service.FacebookService;

import facebook4j.ResponseList;
import facebook4j.User;

public class FacebookProcess {
	
	public static ResponseList<User> searchUsers(String userName) {
		return FacebookService.searchUsers(userName);
	}

}

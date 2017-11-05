package com.jeyni.dao;

import org.apache.log4j.Logger;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;

public class FacebookDao {
	
	private static final Logger LOGGER = Logger.getLogger(FacebookDao.class);
	
	private static final String OAUTH_APP_ID = "130203210483274";
	
	private static final String OAUTH_APP_SECRET = "0c2fcee13a3696d8cada58a2564f045f";
	
	private static final String OAUTH_APP_ACCESS_TOKEN = "EAAB2a0wcBkoBAJ2STDxqcNBUXDhGVd1ZC7FxKkZB4zwEdlFuMdGRuskCBObu1AHnjpERQTZCZC8tUUOx1kxWQwPJiXSPzPYRMltIZBit7PZBDAtQTwUc4PZBxC7VNnq2ubzJ1Shw0RY71G7K6qp883U0ekxiSkEf9LbgNgg69DFBvVmn6nvlps1jz5zfKV4fJIZD";
	
	private static Facebook facebook = new FacebookFactory().getInstance();

	public static ResponseList<User> searchUsers(String userName) {
		facebook.setOAuthAppId(OAUTH_APP_ID, OAUTH_APP_SECRET);
		facebook.setOAuthAccessToken(new AccessToken(OAUTH_APP_ACCESS_TOKEN));
		ResponseList<User> userSearchResult = null;
		try {
			userSearchResult = facebook.searchUsers(userName);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return userSearchResult;
	}

}

package com.jeyni.bean;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonFromFacebook {

    Facebook facebook = new FacebookFactory().getInstance();

    public ResponseList<User> getListNameResearch(String userName) {
	facebook.setOAuthAppId("130203210483274", "0c2fcee13a3696d8cada58a2564f045f");
	// facebook.setOAuthPermissions(commaSeparetedPermissions);
	facebook.setOAuthAccessToken(new AccessToken(
		"EAAB2a0wcBkoBAJ2STDxqcNBUXDhGVd1ZC7FxKkZB4zwEdlFuMdGRuskCBObu1AHnjpERQTZCZC8tUUOx1kxWQwPJiXSPzPYRMltIZBit7PZBDAtQTwUc4PZBxC7VNnq2ubzJ1Shw0RY71G7K6qp883U0ekxiSkEf9LbgNgg69DFBvVmn6nvlps1jz5zfKV4fJIZD"));
	ResponseList<User> userSearchResult = null;
	try {
	    userSearchResult  = facebook.searchUsers(userName);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return userSearchResult;
    }

}

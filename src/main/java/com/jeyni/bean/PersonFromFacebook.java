package com.jeyni.bean;

import facebook4j.ResponseList;
import facebook4j.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonFromFacebook {
	
	private ResponseList<User> users;

}

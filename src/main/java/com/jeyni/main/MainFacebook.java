package com.jeyni.main;

import org.apache.log4j.Logger;

import com.jeyni.bean.PersonFromFacebook;

public class MainFacebook {
    
    private static final Logger LOGGER = Logger.getLogger(MainFacebook.class);


    public static void main(String[] args) {
	PersonFromFacebook personFromFacebook = new PersonFromFacebook();
	LOGGER.info(personFromFacebook.getListNameResearch("test"));
    }

}

package com.jeyni.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jeyni.bean.PersonFromFacebook;
import com.jeyni.process.FacebookProcess;

@Path("/facebook")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FacebookController {

	@GET
	@Path("/get")
	public Response userList(String userName) {
		return Response.status(200).entity(FacebookProcess.searchUsers(userName)).build();
	}

}

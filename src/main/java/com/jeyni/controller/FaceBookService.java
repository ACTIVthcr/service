package com.jeyni.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jeyni.bean.PersonFromFacebook;

@Path("/facebook")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FaceBookService {

	@GET
	@Path("/get")
	public Response userList(String userName) {
		PersonFromFacebook personFromFacebook = new PersonFromFacebook();
		return Response.status(200).entity(personFromFacebook.getListNameResearch(userName)).build();
	}

}

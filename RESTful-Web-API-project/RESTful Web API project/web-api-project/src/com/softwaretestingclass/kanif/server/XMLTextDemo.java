package com.softwaretestingclass.kanif.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/account")
public class XMLTextDemo {
	    @POST  
	    @Produces(MediaType.TEXT_XML)
	    @Path("/add")  
	    @Consumes("application/x-www-form-urlencoded")
	    public Response findUIDPassword(  
	        @FormParam("id") String accountNo,  
	        @FormParam("name") String name,  
	        @FormParam("phone") String phone) {  
	   
	        return Response.status(200)  
	            .entity("<?xml version='1.0'?>"
	    				        + "<accountNo>"+accountNo+"</accountNo>"
	    						+ "<name>"+name+"</name>"
	    						+ "<phone>"+phone+"</phone>"
	    						+ "<UID>SoftwareTestingClasses</UID>"
	    						+ "<Password>Let'sLearn</Password>").build();  
	    } 
}

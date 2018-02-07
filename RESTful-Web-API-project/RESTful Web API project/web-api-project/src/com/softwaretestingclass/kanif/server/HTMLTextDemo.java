package com.softwaretestingclass.kanif.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/htmltext")
public class HTMLTextDemo {
    @POST  
    @Produces(MediaType.TEXT_HTML)
    @Path("/add")  
    @Consumes("application/x-www-form-urlencoded")
    public Response findUIDPassword(  
        @FormParam("id") String accountNo,  
        @FormParam("name") String name,  
        @FormParam("phone") String phone) {  
   
        return Response.status(200)  
            .entity(" UID and Password successfuly created for!"
            		+ "<br> Account No: "+ ""+accountNo
            		+ "<br> Name: " + name
            		+ "<br> Phone: "+phone
            		+ "<br> UID: SoftwareTestingClasses"
            		+ "<br> PWD: Let'sLearn").build();  
    }  
}

package com.pluralsight.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("secured")
public class SecuredFilter {

    @GET
    @Path("message")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSecuredMessgae() {
        return "this is a secured message";
    }
}

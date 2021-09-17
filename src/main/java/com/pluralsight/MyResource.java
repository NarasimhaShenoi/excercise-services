package com.pluralsight;

import com.pluralsight.model.Activity;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URL;

@Path("{pathParam}/myresource")
public class MyResource {
    @PathParam("pathParam") private String pathParamExample;
    @QueryParam("query") private String queryParamExample;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!. pathParamExample "+ pathParamExample + " queryParamExample"+ queryParamExample;
    }
}

package com.pluralsight.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    @GET
    @Path("annotations")
    public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
                                            @HeaderParam("customheader") String header,
                                            @CookieParam("cookieParam") String cookieParam) {
        return "Matrix Param: "+matrixParam+ " Header param: "+header+ " Cookie param: "+cookieParam;
    }

    @GET
    @Path("context")
    public String getParamsWithContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
        String path = uriInfo.getPath().toString();
        String cookies = headers.getCookies().toString();
        return "Path: "+path+ " Cookies: "+cookies;
    }
}

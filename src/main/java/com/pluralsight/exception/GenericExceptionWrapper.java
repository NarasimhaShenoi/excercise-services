package com.pluralsight.exception;

import com.pluralsight.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

public class GenericExceptionWrapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        ErrorMessage errorMessage =  new ErrorMessage(500, exception.getMessage(), "www.google.com");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
    }
}

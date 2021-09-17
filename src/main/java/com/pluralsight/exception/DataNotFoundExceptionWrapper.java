package com.pluralsight.exception;

import com.pluralsight.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionWrapper implements ExceptionMapper<DataNotFoundException> {

    @Override
    public Response toResponse(DataNotFoundException exception) {
        ErrorMessage errorMessage =  new ErrorMessage(404, exception.getMessage(), "www.google.com");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }
}

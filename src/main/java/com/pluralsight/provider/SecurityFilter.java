package com.pluralsight.provider;

import org.glassfish.jersey.internal.util.Base64;
import org.glassfish.jersey.internal.util.Tokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

    private static final String AUTHORIZATION_HEADER_KEY = "AUTHORIZATION";
    private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
    private static final String SECURED_PREFIX = "secured";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (requestContext.getUriInfo().getPath().contains(SECURED_PREFIX)) {
            // url which needs to be secured
            List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
            if (authHeader != null && authHeader.size() > 0) {
                // have the auth header
                String authToken = authHeader.get(0);
                String authHeaderPrefix = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
                String decodedString = Base64.decodeAsString(authHeaderPrefix);
                StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
                String username = tokenizer.nextToken();
                String password = tokenizer.nextToken();

                if ("user".equals(username) && "password".equals(password)) {
                    return;
                }
            }
            // no auth header
            Response unauthorizedResponseStatus = Response.status(Response.Status.UNAUTHORIZED)
                                                .entity("User cannot access the data")
                                                .build();

            requestContext.abortWith(unauthorizedResponseStatus);
        }
    }
}

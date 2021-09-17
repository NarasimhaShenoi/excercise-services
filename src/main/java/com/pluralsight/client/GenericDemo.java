package com.pluralsight.client;

import com.pluralsight.model.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        List<Message> messages = client.target("http://localhost:8080/excercise-services/webapi/")
                .path("messages")
                .queryParam("year", 2021)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List< Message >> () { });
        System.out.println(messages);
    }
}

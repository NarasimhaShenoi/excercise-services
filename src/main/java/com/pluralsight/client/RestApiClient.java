package com.pluralsight.client;

import com.pluralsight.model.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestApiClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        WebTarget baseTarget = client.target("http://localhost:8080/excercise-services/webapi/");
        WebTarget messagesTarget = baseTarget.path("messages");
        WebTarget singleMessageTarget = messagesTarget.path("{messageId}");

//        Message message = client.target("http://localhost:8080/excercise-services/webapi/messages/2")
//                                    .request(MediaType.APPLICATION_JSON)
//                                    .get(Message.class);
//        System.out.println(message.getMessage());

//        Message message1 = singleMessageTarget.resolveTemplate("messageId", 1)
//                                        .request(MediaType.APPLICATION_JSON)
//                                        .get(Message.class);
//        Message message2 = singleMessageTarget.resolveTemplate("messageId", 2)
//                .request(MediaType.APPLICATION_JSON)
//                .get(Message.class);
//        System.out.println(message1.getMessage());
//        System.out.println(message2.getMessage());

        Message newMesaage = new Message(4, "This is a msg created for testing", "NarasimhaS");
        Response postResponse  = messagesTarget.request()
                                        .post(Entity.json(newMesaage));
        System.out.println(postResponse);
        if (postResponse.getStatus() != 201) {
            System.out.println("Error");
            return ;
        }
        Message createdMessage = postResponse.readEntity(Message.class);
        System.out.println(createdMessage.getMessage());
    }
}

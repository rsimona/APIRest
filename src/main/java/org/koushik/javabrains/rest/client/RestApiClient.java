/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.koushik.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.koushik.javabrains.messenger.model.Message;

/**
 *
 * @author Ramon
 */
public class RestApiClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        WebTarget baseTarget = client.target("http://localhost:8080/messenger/webapi");
        WebTarget messagesTarget = baseTarget.path("messages");
        WebTarget singleMessageTarges = messagesTarget.path("{messageId}");

        Message message1 = singleMessageTarges
                .resolveTemplate("messageId", "1")
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);

        Message message2 = singleMessageTarges
                .resolveTemplate("messageId", "2")
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);

        Message newMessage = new Message(4, "My New message from JAX-RS client", "Ramon");
        Response postResponse = messagesTarget
                .request()
                .post(Entity.json(newMessage));
        if (postResponse.getStatus() != 201) {
            System.out.println("Error");
        }
        Message createdmMessage = postResponse.readEntity(Message.class);

        System.out.println(createdmMessage.getMessage());
    }

}

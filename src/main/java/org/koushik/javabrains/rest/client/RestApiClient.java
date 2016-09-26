/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.koushik.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
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

//        WebTarget target = client.target("http://localhost:8080/messenger/webapi/messages/1");
//        Builder builder = (Builder) target.request();
//        Response response = builder.get();
        Message message = client
                .target("http://localhost:8080/messenger/webapi/messages/1")
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);

//        Message message = response.readEntity(Message.class);
        System.out.println(message.getMessage());
    }

}

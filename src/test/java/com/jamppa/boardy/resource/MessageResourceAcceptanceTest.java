package com.jamppa.boardy.resource;

import static com.jamppa.boardy.resource.pojo.JsonUtils.fromJson;
import static com.jamppa.boardy.resource.pojo.JsonUtils.jsonFixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.ws.rs.core.MediaType;

import io.dropwizard.testing.junit.DropwizardAppRule;

import org.junit.ClassRule;
import org.junit.Test;

import com.jamppa.boardy.BoardyApplication;
import com.jamppa.boardy.BoardyConfiguration;
import com.jamppa.boardy.resource.pojo.MessagePojo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

public class MessageResourceAcceptanceTest {

	@ClassRule
	public static final DropwizardAppRule<BoardyConfiguration> RULE = 
			new DropwizardAppRule<>(BoardyApplication.class, "boardy-app.yml");
	
	@Test
	public void shouldPOSTNewMessage() throws Exception {
		
		Client client = new Client();
		
		ClientResponse response = 
				client.resource("http://localhost:8080/api/messages")
				.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, messagePojo());
		
		assertThat(response.getStatus(), is(204));
	}

	private MessagePojo messagePojo() throws Exception {
		return fromJson(jsonFixture("fixtures/message.json"), MessagePojo.class);
	}
	
}

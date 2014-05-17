package com.jamppa.boardy.resource;

import static com.jamppa.boardy.resource.pojo.JsonUtils.fromJson;
import static com.jamppa.boardy.resource.pojo.JsonUtils.jsonFixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import io.dropwizard.testing.junit.DropwizardAppRule;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
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
	
	private Client client;
	
	@Before
	public void setUp() {
		client = new Client();
	}
	
	@Test
	public void shouldPOSTNewMessage() throws Exception {
		
		ClientResponse response = 
				client.resource("http://localhost:8080/api/messages")
				.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, messagePojo());
		
		assertThat(response.getStatus(), is(204));
	}
	
	@Test
	public void shouldNotPOSTNewMessageWhenMessagePayloadIsInvalid() throws Exception {
		
		ClientResponse response = 
				client.resource("http://localhost:8080/api/messages")
				.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, invalidMessagePojo());
		
		assertThat(response.getStatus(), is(422));
	}
	
	@Test
	public void shouldGETListOfMessagePojos() {
		
		ClientResponse response = 
				client.resource("http://localhost:8080/api/v2/messages")
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		assertThat(response.getStatus(), is(200));
	}
	
	@Test
	public void shouldGETListOfThinMessagePojos() {
		
		ClientResponse response = 
				client.resource("http://localhost:8080/api/v1/messages")
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		assertThat(response.getStatus(), is(200));
	}
	
	@Test
	public void shouldGetListOfMessagePojosAsXml() {
		
		ClientResponse response = 
				client.resource("http://localhost:8080/api/v2/messages")
				.accept(MediaType.APPLICATION_XML)
				.get(ClientResponse.class);
		
		assertThat(response.getStatus(), is(200));
	}

	private MessagePojo invalidMessagePojo() throws Exception {
		return fromJson(jsonFixture("fixtures/invalid_message.json"), MessagePojo.class);
	}

	private MessagePojo messagePojo() throws Exception {
		return fromJson(jsonFixture("fixtures/message.json"), MessagePojo.class);
	}
	
}

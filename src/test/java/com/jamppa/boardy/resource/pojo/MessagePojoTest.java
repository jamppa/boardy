package com.jamppa.boardy.resource.pojo;

import static com.jamppa.boardy.resource.pojo.JsonUtils.asJson;
import static com.jamppa.boardy.resource.pojo.JsonUtils.jsonFixture;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jamppa.boardy.model.Message;

public class MessagePojoTest {

	private MessagePojo messagePojo;
	
	@Before
	public void setUp() {
		messagePojo = setupMessagePojo();
	}
	
	private MessagePojo setupMessagePojo() {
		MessagePojo messagePojo = new MessagePojo();
		messagePojo.content = "test content";
		messagePojo.title = "test title";
		messagePojo.sender = "test sender";
		messagePojo.url = "http://foo.com";
		return messagePojo;
	}

	@Test
	public void shouldReturnAsMessage() throws MalformedURLException {
		Message message = messagePojo.asMessage();
		assertMessage(message, messagePojo);
	}
	
	@Test
	public void shouldSerializeToJson() throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
		assertThat(asJson(messagePojo), is(equalTo(jsonFixture("fixtures/message.json"))));
	}

	private void assertMessage(Message message, MessagePojo messagePojo) throws MalformedURLException {
		assertThat(message.content(), is(messagePojo.content));
		assertThat(message.sender(), is(messagePojo.sender));
		assertThat(message.title(), is(messagePojo.title));
		Assert.assertTrue(message.url().equals(new URL(messagePojo.url)));
	}
	
}

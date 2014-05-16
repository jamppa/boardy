package com.jamppa.boardy.resource.pojo;

import static com.jamppa.boardy.resource.pojo.JsonUtils.asJson;
import static com.jamppa.boardy.resource.pojo.JsonUtils.fromJson;
import static com.jamppa.boardy.resource.pojo.JsonUtils.jsonFixture;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
	public void shouldSerializeToJson() throws Exception {
		assertThat(asJson(messagePojo), is(equalTo(jsonFixture("fixtures/message.json"))));
	}
	
	@Test
	public void shouldDeserializeFromJson() throws Exception {
		MessagePojo messagePojo = setupMessagePojo();
		MessagePojo messageFromJson = fromJson(jsonFixture("fixtures/message.json"), MessagePojo.class);
		assertMessageFromJson(messagePojo, messageFromJson);
	}

	private void assertMessageFromJson(MessagePojo pojo, MessagePojo pojoFromJson) {
		assertThat(pojo.content, is(pojoFromJson.content));
		assertThat(pojo.title, is(pojoFromJson.title));
		assertThat(pojo.sender, is(pojoFromJson.sender));
		assertThat(pojo.url, is(pojoFromJson.url));
	}

	private void assertMessage(Message message, MessagePojo messagePojo) throws MalformedURLException {
		assertThat(message.content(), is(messagePojo.content));
		assertThat(message.sender(), is(messagePojo.sender));
		assertThat(message.title(), is(messagePojo.title));
		Assert.assertTrue(message.url().equals(new URL(messagePojo.url)));
	}
	
}

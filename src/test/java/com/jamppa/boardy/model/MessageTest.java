package com.jamppa.boardy.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import com.jamppa.boardy.resource.pojo.MessagePojo;

public class MessageTest {

	private Message message;
	
	@Before
	public void setUp() throws MalformedURLException {
		message = new Message("", "", "", new URL("http://foo.com"));
	}
	
	@Test
	public void shouldReturnMessageAsPojo() {
		MessagePojo pojo = message.asPojo();
		assertPojo(pojo, message);
	}

	private void assertPojo(MessagePojo pojo, Message message) {
		assertThat(pojo.content, is(message.content()));
		assertThat(pojo.sender, is(message.sender()));
		assertThat(pojo.title, is(message.title()));
		assertThat(pojo.url, is(message.url().toString()));
	}
	
}

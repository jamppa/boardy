package com.jamppa.boardy.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.jamppa.boardy.resource.pojo.MessagePojo;

public class MessageListTest {
	
	private MessageList messageList;
	private List<Message> messages;
	private Message message;
	
	@Before
	public void setUp() throws MalformedURLException {
		message = new Message("title", "content", "sender", new URL("http://foo.com"));
		messages = Lists.newArrayList(message);
		messageList = new MessageList(messages);
	}
	
	@Test
	public void shouldReturnListOfMessagePojos() {
		List<MessagePojo> messagePojos = messageList.asPojos();
		assertPojos(messagePojos, messageList);
	}

	private void assertPojos(List<MessagePojo> messagePojos, MessageList messageList) {
		assertThat(messagePojos.size(), is(1));
	}

}

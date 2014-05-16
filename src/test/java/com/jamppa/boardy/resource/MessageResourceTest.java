package com.jamppa.boardy.resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.jamppa.boardy.model.Message;
import com.jamppa.boardy.repository.MessageRepository;
import com.jamppa.boardy.resource.pojo.MessagePojo;

public class MessageResourceTest {

	private MessageResource messageResource;
	@Mock
	private MessageRepository messageRepository;
	@Mock
	private MessagePojo messagePojo;
	private Message message;
	
	@Before
	public void setUp() {
		this.message = Message.newEmpty();
		this.messageResource = new MessageResource(messageRepository);
	}
	
	@Test
	public void shouldCreateNewMessage() {
		messageResource.createMessage(messagePojo);
	}
	
}

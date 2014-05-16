package com.jamppa.boardy.resource;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jamppa.boardy.model.Message;
import com.jamppa.boardy.repository.MessageRepository;
import com.jamppa.boardy.resource.pojo.MessagePojo;

@RunWith(MockitoJUnitRunner.class)
public class MessageResourceTest {

	private MessageResource messageResource;
	private Message message;
	
	@Mock
	private MessageRepository messageRepository;
	@Mock
	private MessagePojo messagePojo;
	
	@Before
	public void setUp() {
		this.message = Message.newEmpty();
		this.messageResource = new MessageResource(messageRepository);
	}
	
	@Test
	public void shouldCreateNewMessage() {
		when(messagePojo.asMessage()).thenReturn(message);
		messageResource.createMessage(messagePojo);
		verify(messageRepository).save(message);
	}
	
}

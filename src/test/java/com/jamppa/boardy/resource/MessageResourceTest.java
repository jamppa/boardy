package com.jamppa.boardy.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;
import com.jamppa.boardy.model.Message;
import com.jamppa.boardy.model.MessageList;
import com.jamppa.boardy.repository.MessageRepository;
import com.jamppa.boardy.resource.pojo.MessagePojo;
import com.jamppa.boardy.resource.pojo.ThinMessagePojo;

@RunWith(MockitoJUnitRunner.class)
public class MessageResourceTest {

	private MessageResource messageResource;
	private Message message;
	
	@Mock
	private MessageRepository messageRepository;
	@Mock
	private MessagePojo messagePojo;
	@Mock
	private MessageList messageList;
	
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
	
	@Test
	public void shouldReturnListOfMessagePojos() {
		List<MessagePojo> messagePojos = Lists.newArrayList();
		when(messageList.asPojos()).thenReturn(messagePojos);
		when(messageRepository.findAll()).thenReturn(messageList);
		
		List<MessagePojo> listOfMessages = messageResource.listMessages();
		
		assertThat(listOfMessages, is(messagePojos));
	}
	
	@Test
	public void shouldReturnListOfThinMessagePojos() {
		List<ThinMessagePojo> messagePojos = Lists.newArrayList();
		when(messageList.asThinPojos()).thenReturn(messagePojos);
		when(messageRepository.findAll()).thenReturn(messageList);
		
		List<ThinMessagePojo> listOfMessages = messageResource.listThinMessages();
		
		assertThat(listOfMessages, is(messagePojos));
	}
	
}

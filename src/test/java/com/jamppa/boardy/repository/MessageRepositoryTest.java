package com.jamppa.boardy.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.jamppa.boardy.model.Message;
import com.jamppa.boardy.model.MessageList;

public class MessageRepositoryTest {
	
	private MessageRepository messageRepository;
	
	@Before
	public void setUp() {
		messageRepository = new MessageRepository(Lists.newArrayList(Message.newEmpty()));
	}

	@Test
	public void shouldFindAllMessages() {
		MessageList messageList = messageRepository.findAll();
		assertThat(messageList.get().size(), is(1));
	}
	
	@Test
	public void shouldSaveNewMessage() {
		messageRepository.save(Message.newEmpty());
		assertThat(messageRepository.findAll().get().size(), is(2));
	}
	
}

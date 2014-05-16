package com.jamppa.boardy.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.jamppa.boardy.model.Message;
import com.jamppa.boardy.repository.MessageRepository;

public class MessageRepositoryTest {
	
	private MessageRepository messageRepository;
	
	@Before
	public void setUp() {
		messageRepository = new MessageRepository(Lists.newArrayList(new Message()));
	}

	@Test
	public void shouldFindAllMessages() {
		List<Message> messages = messageRepository.findAll();
		assertThat(messages.size(), is(1));
	}
	
}

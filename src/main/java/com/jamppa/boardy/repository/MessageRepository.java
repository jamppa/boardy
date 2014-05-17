package com.jamppa.boardy.repository;

import java.util.List;

import com.google.common.collect.Lists;
import com.jamppa.boardy.model.Message;
import com.jamppa.boardy.model.MessageList;

public class MessageRepository {
	
	private final List<Message> messages = Lists.newArrayList();
	
	public MessageRepository(final List<Message> initialMessages) {
		this.messages.addAll(initialMessages);
	}

	public MessageList findAll() {
		return new MessageList(messages);
	}

	public void save(final Message message) {
		this.messages.add(message);
	}

}

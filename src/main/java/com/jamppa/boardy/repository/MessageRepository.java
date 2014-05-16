package com.jamppa.boardy.repository;

import java.util.List;

import com.google.common.collect.Lists;
import com.jamppa.boardy.model.Message;

public class MessageRepository {
	
	private final List<Message> messages = Lists.newArrayList();
	
	public MessageRepository(List<Message> initialMessages) {
		this.messages.addAll(initialMessages);
	}

	public List<Message> findAll() {
		return Lists.newArrayList(messages);
	}

}

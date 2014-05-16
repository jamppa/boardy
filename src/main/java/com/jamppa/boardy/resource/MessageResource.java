package com.jamppa.boardy.resource;

import com.jamppa.boardy.repository.MessageRepository;
import com.jamppa.boardy.resource.pojo.MessagePojo;

public class MessageResource {

	private final MessageRepository messageRepository;
	
	public MessageResource(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public void createMessage(MessagePojo messagePojo) {
		messageRepository.save(messagePojo.asMessage());
	}

}

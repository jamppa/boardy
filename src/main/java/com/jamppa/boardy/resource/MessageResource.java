package com.jamppa.boardy.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jamppa.boardy.repository.MessageRepository;
import com.jamppa.boardy.resource.pojo.MessagePojo;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	private final MessageRepository messageRepository;
	
	public MessageResource(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@POST
	public void createMessage(MessagePojo messagePojo) {
		messageRepository.save(messagePojo.asMessage());
	}

}

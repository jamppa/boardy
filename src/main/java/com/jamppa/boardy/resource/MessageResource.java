package com.jamppa.boardy.resource;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jamppa.boardy.repository.MessageRepository;
import com.jamppa.boardy.resource.pojo.MessagePojo;
import com.jamppa.boardy.resource.pojo.ThinMessagePojo;

@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class MessageResource {

	private final MessageRepository messageRepository;
	
	public MessageResource(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@POST
	@Path("/messages")
	public void createMessage(@Valid MessagePojo messagePojo) {
		messageRepository.save(messagePojo.asMessage());
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/v2/messages")
	public List<MessagePojo> listMessages() {
		return messageRepository.findAll().asPojos();
	}

	@GET
	@Path("/v1/messages")
	public List<ThinMessagePojo> listThinMessages() {
		return messageRepository.findAll().asThinPojos();
	}

}

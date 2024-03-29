package com.jamppa.boardy.model;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.google.common.collect.Lists;
import com.jamppa.boardy.resource.pojo.MessagePojo;
import com.jamppa.boardy.resource.pojo.ThinMessagePojo;

public class MessageList {

	private final List<Message> messages = Lists.newArrayList();
	
	public MessageList(List<Message> messages) {
		this.messages.addAll(messages);
	}

	public List<MessagePojo> asPojos() {
		return messages.stream()
				.map(message -> message.asPojo()).collect(toList());
	}
	
	public List<ThinMessagePojo> asThinPojos() {
		return messages.stream()
				.map(message -> message.asThinPojo()).collect(toList());
	}

	public List<Message> get() {
		return Lists.newArrayList(messages);
	}
	
}

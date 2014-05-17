package com.jamppa.boardy.resource.pojo;

import java.net.MalformedURLException;
import java.net.URL;

import com.jamppa.boardy.model.Message;

public class MessagePojo {
	public String title;
	public String content;
	public String sender;
	public String url;
	
	public MessagePojo() {}
	public MessagePojo(Message message) {
		this.title = message.title();
		this.content = message.content();
		this.sender = message.sender();
		this.url = message.url().toString();
	}

	public Message asMessage() {
		try {
			return new Message(title, content, sender, new URL(url));
		} catch (MalformedURLException e) {
			throw new IllegalStateException(e);
		}
	}
	
}

package com.jamppa.boardy.model;

import java.net.URL;

import com.jamppa.boardy.resource.pojo.MessagePojo;
import com.jamppa.boardy.resource.pojo.ThinMessagePojo;

public class Message {

	private final String title;
	private final String content;
	private final String sender;
	private final URL url;
	
	public Message(String title, String content, String sender, URL url) {
		this.title = title;
		this.content = content;
		this.sender = sender;
		this.url = url;
	}
	
	public String title() {
		return title;
	}
	
	public String content() {
		return content;
	}
	
	public String sender() {
		return sender;
	}
	
	public URL url() {
		return url;
	}
	
	public static Message newEmpty() {
		return new Message("", "", "", null);
	}
	
	public MessagePojo asPojo() {
		return new MessagePojo(this);
	}

	public ThinMessagePojo asThinPojo() {
		return new ThinMessagePojo(this);
	}
	
}

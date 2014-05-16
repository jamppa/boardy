package com.jamppa.boardy.model;

import java.net.URL;

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
	
}

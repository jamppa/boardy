package com.jamppa.boardy.resource.pojo;

import java.net.MalformedURLException;
import java.net.URL;

import com.jamppa.boardy.model.Message;

public class MessagePojo {

	public String title;
	public String content;
	public String sender;
	public String url;
	
	public Message asMessage() throws MalformedURLException {
		return new Message(title, content, sender, new URL(url));
	}
	
}

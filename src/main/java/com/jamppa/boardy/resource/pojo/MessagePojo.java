package com.jamppa.boardy.resource.pojo;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;

import com.jamppa.boardy.model.Message;

@XmlRootElement
public class MessagePojo {
	
	@Length(max = 15)
	public String title;
	
	@Length(max = 256)
	public String content;
	
	@Length(max = 256)
	public String sender;
	
	@org.hibernate.validator.constraints.URL
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

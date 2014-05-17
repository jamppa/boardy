package com.jamppa.boardy.resource.pojo;

import com.jamppa.boardy.model.Message;

public class ThinMessagePojo {
	
	public String title;
	public String content;
	public String sender;
	
	public ThinMessagePojo() {}
	
	public ThinMessagePojo(Message message) {
		this.title = message.title();
		this.content = message.content();
		this.sender = message.sender();
	}

}

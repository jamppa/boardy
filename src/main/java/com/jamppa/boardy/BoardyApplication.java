package com.jamppa.boardy;

import com.google.common.collect.Lists;
import com.jamppa.boardy.repository.MessageRepository;
import com.jamppa.boardy.resource.MessageResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BoardyApplication extends Application<BoardyConfiguration>{
	
	public static void main(String[] args) throws Exception {
		new BoardyApplication().run(args);
	}

	@Override
	public String getName() {
		return "boardy-app";
	}
	
	@Override
	public void initialize(Bootstrap<BoardyConfiguration> bootstrap) {
		
	}

	@Override
	public void run(BoardyConfiguration conf, Environment env) throws Exception {
		env.jersey().register(new MessageResource(messageRepository()));
	}

	private MessageRepository messageRepository() {
		return new MessageRepository(Lists.newArrayList());
	}

}

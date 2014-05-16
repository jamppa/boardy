package com.jamppa.boardy;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.jamppa.boardy.resource.MessageResource;

@RunWith(MockitoJUnitRunner.class)
public class BoardyApplicationTest {

	private BoardyApplication application;
	private BoardyConfiguration conf;

	@Mock
	private Environment env;
	@Mock
	private JerseyEnvironment jerseyEnv;
	
	@Before
	public void setUp() {
		conf = new BoardyConfiguration();
		application = new BoardyApplication();
	}
	
	@Test
	public void itShouldRegisterMessageResourceToJerseyEnvironment() throws Exception {
		when(env.jersey()).thenReturn(jerseyEnv);
		application.run(conf, env);
		verify(jerseyEnv).register(Mockito.any(MessageResource.class));
	}
	
}

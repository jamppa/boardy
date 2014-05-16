package com.jamppa.boardy.resource.pojo;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class JsonUtils {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static String asJson(Object obj) throws JsonProcessingException {
		return objectMapper.writeValueAsString(obj);
	}
	
	public static <T> T fromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(json, clazz);
	}
	
	public static String fixture(String filename) throws IOException {
		return Resources.toString(Resources.getResource(filename), Charsets.UTF_8);
	}
	
	public static String jsonFixture(String filename) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
		return objectMapper.writeValueAsString(objectMapper.readValue(fixture(filename), JsonNode.class));
	}
}

package com.lawencon.app.controller;

import java.io.IOException;
import java.util.Base64;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseController<T> {
	
	public String[] authUser(String user){
		byte[] decodeBytes = Base64.getDecoder().decode(user);
        String decodeString = new String(decodeBytes);
        String[] authUser = decodeString.split(":");
        return authUser;
	}
	
	public T readValue(String content, Class<T> kelas) throws JsonParseException, JsonMappingException, IOException{
		return new ObjectMapper().readValue(content, kelas);
	}
}

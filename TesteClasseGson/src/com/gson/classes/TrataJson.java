package com.gson.classes;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class TrataJson {
	
	Gson gson = new Gson();
	
	
	public TrataJson(){
		
		/*
		// Or use new GsonBuilder().create();
		User user1 = new User();
		 // serializes target to Json
		
		System.out.println(json);
		
		User user2 = gson.fromJson(json, User.class); // deserializes json into target2
		
		System.out.println("ID: " + user2.getId() + " Nome: " + user2.getNome());
			
			*/
		
	}
	
	public String ConverterParaJson(List<User> usuario){
		
		String json = gson.toJson(usuario);
		return json;
	}
	
	
	public List<User> LerJson(String json){
		
		List<User> RetornoJson = gson.fromJson(json, new TypeToken<List<User>>(){}.getType());
		return RetornoJson;
	}
	

}
